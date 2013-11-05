<?php

namespace Progeny\Service;

use Zend\Db\TableGateway\TableGateway;
use Progeny\Entity\Progeny;
use Zend\Db\ResultSet\ResultSet;
use Zend\Db\Sql\Select;

class ProgenyTable
{
 /** @var \Doctrine\ORM\EntityManager $progenyTable */
 protected $em;

 /** @var  \Facebook $facebook */
 protected $facebook;

 protected $fb_id;

 public function __construct(\Zend\ServiceManager\ServiceManager $sm)
 {
  $this->em = $sm->get('Doctrine\ORM\EntityManager');
 }

 public function newProgeny($data)
 {
  $progeny = new Progeny();

  $progeny->exchangeArray($data);

  $this->em->persist($progeny);
  $this->em->flush();

  return $progeny;
 }

 /**
  * @return \Progeny\Entity\Progeny
  * @throws \Exception
  */
 public function getProgeny()
 {
  return $this->em->getRepository('Progeny\Entity\Progeny')->findOneBy(array('fb_id' => $this->fb_id));
 }

 /**
  * @param Progeny $progeny
  */
 public function saveProgeny(Progeny $progeny)
 {
  $this->em->persist($progeny);
 }

 /**
  * @return Progeny[]
  */
 public function fetchAll()
 {
  return $this->em->getRepository('Progeny\Entity\Progeny')->findAll();
 }

 public function setFbId($fb_id)
 {
  $this->fb_id = $fb_id;
 }

 public function getFbId()
 {
  return $this->fb_id;
 }

 public function setFacebook(\Facebook $facebook)
 {
  $this->facebook = $facebook;
 }

 /**
  * Return a Facebook object
  * @return \Facebook
  */
 public function getFacebook()
 {
  return $this->facebook;
 }

}

