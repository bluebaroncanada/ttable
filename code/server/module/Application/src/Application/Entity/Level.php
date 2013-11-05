<?php

namespace Application\Entity;
use Doctrine\ORM\Mapping as ORM;
use Doctrine\Common\Collections\ArrayCollection;
use Zend\InputFilter\Factory as InputFactory;
use Zend\InputFilter\InputFilter;
use Zend\InputFilter\InputFilterAwareInterface;
use Zend\InputFilter\InputFilterInterface;

/**
 * @ORM\Entity
 * @ORM\Table(name="level")
 */
class Level {

 protected $inputFilter;


 function __construct()
 {
  $this->is_parent = false;
 }

 public function toArray()
 {
  return array(
   'email' => $this->getEmail(),
   'is_registered' => $this->getIsRegistered(),
  );


 }

 public function setInputFilter(InputFilterInterface $i)
 {
  throw new \Exception("Not used");
 }


 public function getInputFilter()
 {
  if($this->inputFilter) return $this->inputFilter;

  $inputFilter = new InputFilter();
  $factory = new InputFactory();

  //email
  $inputFilter->add($factory->createInput(array(
   'name' => 'email',
   'required' => true,
   'filters' => array(
    array('name' => 'StripTags'),
    array('name' => 'StringTrim'),
   ),
   'validators' => array(
    array(
     'name' => 'EmailAddress',
    ),
    array(
     'name' => 'StringLength',
     'options' => array(
      'encoding' => 'UTF-8',
      'min' => 1,
      'max' => 255,
     ),
    ),
   ),
  )));

  //password
  $inputFilter->add($factory->createInput(array(
   'name' => 'password',
   'required' => true,
   'filters' => array(
    array('name' => 'StripTags'),
    array('name' => 'StringTrim'),
   ),
   'validators' => array(
    array(
     'name' => 'StringLength',
     'options' => array(
      'encoding' => 'UTF-8',
      'min' => 8,
      'max' => 50,
     ),
    ),
   ),
  )));


  $this->inputFilter = $inputFilter;

  return $this->inputFilter;
 }

 /**
  * @ORM\Id
  * @ORM\GeneratedValue(strategy="AUTO")
  * @ORM\Column(type="integer")
  */
 protected $id;

 /** @ORM\ManyToOne(targetEntity="Application\Entity\Progeny") */
 protected $progeny;

 /** @ORM\Column(type="boolean") */
 protected $is_deleted;

 /** @ORM\Column(type="string") */
 protected $time;

 //How long it took them to complete the level when they finally did complete it
 /** @ORM\Column(type="string") */
 protected $final_completion_time;

 /** @ORM\Column(type="string") */
 protected $level;

 /** @ORM\Column(type="string") */
 protected $mistakes;

 //How many mistakes they made on the final completion of a level (thus, only show the mistakes on the time they pass the level)
 /** @ORM\Column(type="string") */
 protected $final_completion_mistakes;

 //How many times they attempted each level
 /** @ORM\Column(type="string") */
 protected $attempts;

 /** @ORM\Column(type="string") */
 protected $final_game_high_score;


 public function exchangeArray($data)
 {
  $this->email = (isset($data['email'])) ? $data['email'] : null;
  $this->password = (isset($data['password'])) ? $data['password'] : null;
  $this->first_name = (isset($data['first_name'])) ? $data['first_name'] : null;
  $this->last_name = (isset($data['last_name'])) ? $data['last_name'] : null;
  $this->fb_id = (isset($data['id'])) ? $data['id'] : null;
  $this->fb_link = (isset($data['fb_link'])) ? $data['fb_link'] : null;
 }


}

