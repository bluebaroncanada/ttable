<?php

namespace User\Entity;

use Doctrine\ORM\Mapping as ORM;
use Doctrine\Common\Collections\ArrayCollection;
use Zend\Form\Annotation\Validator;
use Zend\InputFilter\Factory as InputFactory;
use Zend\InputFilter\InputFilter;
use Zend\InputFilter\InputFilterAwareInterface;
use Zend\InputFilter\InputFilterInterface;

/**
 * @ORM\Entity
 * @ORM\Table(name="user")
 */
class User {

 protected $inputFilter;


 function __construct()
 {
 }

 public function toArray()
 {
  //return user information
  return array(
   'fb_id' => $this->getFbId(),
   'first_name' => $this->getFirstName(),
   'last_name' => $this->getLastName(),
  );


 }

 /**
  * @return \Zend\Validator\StringLength
  */
 public function getPasswordValidator()
 {
  //return the validator accordint the project specs 	
  $length_validator = new \Zend\Validator\StringLength(array('min'=> 3, 'max' => 6));
  $length_validator->setMessages(array(
   \Zend\Validator\StringLength::TOO_LONG => "The password can have no more than 6 characters",
   \Zend\Validator\StringLength::TOO_SHORT => "The password can have no fewer than 3 characters",
  ));

  return $length_validator;
 }


 /**
  * @ORM\Id
  * @ORM\GeneratedValue(strategy="AUTO")
  * @ORM\Column(type="integer")
  */
 protected $id;

 /** @ORM\Column(type="string", nullable=true, unique=true) */
 protected $fb_id;

 /** @ORM\Column(type="string", nullable=true) */
 protected $first_name;

 /** @ORM\Column(type="string", nullable=true) */
 protected $last_name;

 /** @ORM\Column(type="string", nullable=true) */
 protected $fb_link;

 //Parent mode must have a password on it. The password should be cs2212 initially. Then he/she should be able to change the password to one that is case sensitive and 3-6 characters long.
 /** @ORM\Column(type="string", nullable=true) */
 protected $password;

//Initially the Facebook user should also be forced to answer one of 3 pre-set questions such as "What is your mother's maiden name". The Facebook user can pick which of the 3 questions to answer. The answers should NOT be case sensitive. The answer can not be longer than 30 characters and must be at least 1 character. Your group can pick what 3 questions to show to the parent.
//If the user types in the wrong password more than 3 times, then your system should display the question that was answered by the user. If the user gets the answer correct, allow him/her to reset the password to something new, otherwise set the password back to cs2212
 /** @ORM\Column(type="string", nullable=true) */
 protected $question;

 /** @ORM\Column(type="string", nullable=true) */
 protected $answer;

 //A user must be able to choose between three skins on the Drill Mode. A skin is a look and feel and/or a theme for the interface. For example all the buttons/text/menus would have the same colour scheme in a particular skin. 3% of your final mark for acceptance testing will be based on the aesthetic appeal/creativity/originality of your skins. HINT: Java swing has a look and feel class to help. If you want to do some cool stuff, do a search on Java, "Look and Feel" for sample code. BUT LEAVE THIS TO THE END, make sure all the other stuff works first :-)
 /** @ORM\Column(type="string", nullable=true) */
 protected $skin;

 /** @ORM\Column(type="string", nullable=true) */
 protected $incorrect_password_attempts;

 public function exchangeArray($data)
 {
  //swap incomming data into the user object
  $this->email = (isset($data['email'])) ? $data['email'] : null;
  $this->password = (isset($data['password'])) ? $data['password'] : null;
  $this->first_name = (isset($data['first_name'])) ? $data['first_name'] : null;
  $this->last_name = (isset($data['last_name'])) ? $data['last_name'] : null;
  $this->fb_id = (isset($data['id'])) ? $data['id'] : null;
  $this->fb_link = (isset($data['fb_link'])) ? $data['fb_link'] : null;
 }

 /**
  * @param mixed $answer
  */
 public function setAnswer($answer)
 {
  $this->answer = $answer;
 }

 /**
  * @return mixed
  */
 public function getAnswer()
 {
  return $this->answer;
 }

 /**
  * @param mixed $fb_id
  */
 public function setFbId($fb_id)
 {
  $this->fb_id = $fb_id;
 }

 /**
  * @return mixed
  */
 public function getFbId()
 {
  return $this->fb_id;
 }

 /**
  * @param mixed $fb_link
  */
 public function setFbLink($fb_link)
 {
  $this->fb_link = $fb_link;
 }

 /**
  * @return mixed
  */
 public function getFbLink()
 {
  return $this->fb_link;
 }

 /**
  * @param mixed $first_name
  */
 public function setFirstName($first_name)
 {
  $this->first_name = $first_name;
 }

 /**
  * @return mixed
  */
 public function getFirstName()
 {
  return $this->first_name;
 }

 /**
  * @param mixed $id
  */
 public function setId($id)
 {
  $this->id = $id;
 }

 /**
  * @return mixed
  */
 public function getId()
 {
  return $this->id;
 }

 /**
  * @param mixed $incorrect_password_attempts
  */
 public function setIncorrectPasswordAttempts($incorrect_password_attempts)
 {
  $this->incorrect_password_attempts = $incorrect_password_attempts;
 }

 /**
  * @return mixed
  */
 public function getIncorrectPasswordAttempts()
 {
  return $this->incorrect_password_attempts;
 }

 /**
  * @param mixed $last_name
  */
 public function setLastName($last_name)
 {
  $this->last_name = $last_name;
 }

 /**
  * @return mixed
  */
 public function getLastName()
 {
  return $this->last_name;
 }

 /**
  * @param mixed $password
  */
 public function setPassword($password)
 {
  $this->password = $password;
 }

 /**
  * @return mixed
  */
 public function getPassword()
 {
  return $this->password;
 }

 /**
  * @param mixed $question
  */
 public function setQuestion($question)
 {
  $this->question = $question;
 }

 /**
  * @return mixed
  */
 public function getQuestion()
 {
  return $this->question;
 }

 /**
  * @param mixed $skin
  */
 public function setSkin($skin)
 {
  $this->skin = $skin;
 }

 /**
  * @return mixed
  */
 public function getSkin()
 {
  return $this->skin;
 }


}

