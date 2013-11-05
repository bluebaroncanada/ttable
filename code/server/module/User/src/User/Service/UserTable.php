<?php

namespace User\Service;

use Zend\Db\TableGateway\TableGateway;
use User\Entity\User;
use Zend\Db\ResultSet\ResultSet;
use Zend\Db\Sql\Select;

class UserTable
{
 /** @var \Doctrine\ORM\EntityManager $userTable */
 protected $em;

 /** @var  \Facebook $facebook */
 protected $facebook;

 protected $fb_id;

 //Preset questions
 protected $questions = array(
  0 => 'What\'s your mother\'s maiden name?',
  1 => 'What\'s the name of your favourite pet?',
  2 => 'Other than CS2212, what is your favourite class/subject?',
 );

 public function __construct(\Zend\ServiceManager\ServiceManager $sm)
 {
  $this->em = $sm->get('Doctrine\ORM\EntityManager');
 }

 public function setAnswer($answer)
 {
  //persist answer
  $user = $this->getUser();
  $user->setAnswer($answer);
  $this->em->persist($user);
  $this->em->flush();
 }

 public function setQuestion($question)
 {
  //persist qustion array index
  $user = $this->getUser();
  $user->setQuestion($question);
  $this->em->persist($user);
  $this->em->flush();
 }

 public function getQuestions()
 {
  //return the questoins array
  return $this->questions;
 }

 /**
  * @param $password
  */
 public function setPassword($password)
 {
  //encrypt and persist the password
  $user = $this->getUser();
  $user->setPassword(md5($password));
  $user->setIncorrectPasswordAttempts(0);
  $this->em->persist($user);
  $this->em->flush();
 }

 /**
  * @param $password
  * @return bool
  */
 public function authenticate($password)
 {
  //encrypt the incomming password
  $user = $this->getUser();
  
  //challenge
  $authenticated = $user->getPassword() == md5($password);

  if($authenticated)
   //reset password attemts to 0
   $user->setIncorrectPasswordAttempts(0);
  else
   //slap the user's hand
   $user->setIncorrectPasswordAttempts($user->getIncorrectPasswordAttempts() + 1);

  //persist the user to save the password attempt count
  $this->em->persist($user);
  $this->em->flush();
  return $authenticated;
 }

 public function newUser($data)
 {
  //create a new user from the incomming data
  $user = new User();

  $user->exchangeArray($data);
  $user->setPassword(md5('cs2212'));

  $this->em->persist($user);
  $this->em->flush();

  return $user;
 }

 /**
  * @return \User\Entity\User
  * @throws \Exception
  */
 public function getUser()
 {
  //get the singleton user
  return $this->em->getRepository('User\Entity\User')->findOneBy(array('fb_id' => $this->fb_id));
 }

 /**
  * @param User $user
  */
 public function saveUser(User $user)
 {
  //persist the user in all its glory
  $this->em->persist($user);
 }

 /**
  * @return User[]
  */
 public function fetchAll()
 {
  //return all user objects
  //this will be important in the future
  return $this->em->getRepository('User\Entity\User')->findAll();
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