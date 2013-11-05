<?php

namespace Progeny\Controller;

use Zend\Mvc\Controller\AbstractActionController;
use Zend\View\Model\JsonModel;

class ProgenyController extends AbstractActionController
{
 protected $facebook = null;
 protected $fb_id = null;

 public function indexAction()
 {
  return new ViewModel();
 }

 public function AddProgenyAction()
 {
  $first_name = $this->params()->fromQuery('first_name');
  $last_name = $this->params()->fromQuery('last_name');
  $age = $this->params()->fromQuery('age');

  $data = array('first_name' => $first_name, 'last_name' => $last_name, 'age' => $age);

  $progeny = $this->getProgenyTable()->newProgeny($data);


  return new JsonModel(array('success' => true));
 }



 /**
  * Return a Facebook object
  * @return \Facebook
  */
 public function getFacebook()
 {
  if ($this->facebook) return $this->facebook;
  $this->facebook = new \Facebook(array('appId' => '654412204576554', 'secret' => 'bebd056f6d6ff934cc48e36536b58318'));
  return $this->facebook;
 }

 public function getFbId()
 {
  if ($this->fb_id) return $this->fb_id;
  $this->fb_id = $this->getFacebook()->getProgeny();
  return $this->fb_id;
 }

 /**
  * @return \Progeny\Service\ProgenyTable
  */
 public function getProgenyTable()
 {
  if ($this->progenyTable) return $this->progenyTable;

  $this->progenyTable = $this->getServiceLocator()->get('Progeny\Service\ProgenyTable');
  $this->progenyTable->setFacebook($this->getFacebook());
  $this->progenyTable->setFbId($this->getFbId());

  return $this->progenyTable;
 }


}

