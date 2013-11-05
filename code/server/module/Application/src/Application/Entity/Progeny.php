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
 * @ORM\Table(name="child")
 */
class Progeny {

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


 /** @ORM\ManyToOne(targetEntity="User\Entity\User") */
 protected $user;

// /** @ORM\Column(type="string", nullable=true) */
// protected $fb_id;

 //Each child should have a different first name (1 to 20 characters) and an age (or birthday).
 //A Facebook user must be able to change the age on his/her child (but not the first name, if the first name is to change, then the user must delete the child and recreate it)
 /** @ORM\Column(type="string") */
 protected $first_name;

 /** @ORM\Column(type="string") */
 protected $last_name;

 /** @ORM\Column(type="string") */
 protected $age;

 //A Facebook user must be able to delete his/her children
 /** @ORM\Column(type="boolean") */
 protected $is_deleted;

 //A Facebook user must be able to set the time for each level per child (thus one child may be given 1 minute to complete a level but another child may be given 2 minutes to complete a level). Make the default time 30 seconds for each child.
 /** @ORM\Column(type="string") */
 protected $minutes_to_complete_level;

 //Initially each child starts at the beginner level
 //A Facebook user must be able to see which level his/her children have achieved
 /** @ORM\Column(type="string") */
 protected $level;

 //A Facebook user must be able to set the number of mistakes the children can make per level (maybe they can not make any mistake for the ones table, but for the 9 tables, they can make up to 3 mistakes and still go on to the next level). The mistake is per level, but the time is per child
 /** @ORM\Column(type="string") */
 protected $mistakes_allowed_per_level;


// /** @ORM\Column(type="string", nullable=true) */
// protected $fb_link;

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

