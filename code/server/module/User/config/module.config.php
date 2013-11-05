<?php

return array(

 'doctrine' => array(
  'driver' => array(
   'user_entities' => array(
    'class' => 'Doctrine\ORM\Mapping\Driver\AnnotationDriver',
    'cache' => 'array',
    'paths' => array(__DIR__ . '/../src/User/Entity')
   ),

   'orm_default' => array(
    'drivers' => array(
     'User\Entity' => 'user_entities'
    )
   ))),

 'router' => array(
  'routes' => array(

   'login' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/login',
     'defaults' => array(
      'controller' => 'User\Controller\User',
      'action' => 'login',
     ),
    ),
   ),

   'authenticate' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/authenticate',
     'defaults' => array(
      'controller' => 'User\Controller\User',
      'action' => 'authenticate',
     ),
    ),
   ),

   'setanswer' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/setanswer',
     'defaults' => array(
      'controller' => 'User\Controller\User',
      'action' => 'setanswer',
     ),
    ),
   ),

   'getuser' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/getuser',
     'defaults' => array(
      'controller' => 'User\Controller\User',
      'action' => 'getuser',
     ),
    ),
   ),

   'resetpassword' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/resetpassword',
     'defaults' => array(
      'controller' => 'User\Controller\User',
      'action' => 'resetpassword',
     ),
    ),
   ),

   'setquestion' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/setquestion',
     'defaults' => array(
      'controller' => 'User\Controller\User',
      'action' => 'setquestion',
     ),
    ),
   ),

   'getquestions' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/getquestions',
     'defaults' => array(
      'controller' => 'User\Controller\User',
      'action' => 'getquestions',
     ),
    ),
   ),

   'setpassword' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/setpassword',
     'defaults' => array(
      'controller' => 'User\Controller\User',
      'action' => 'setpassword',
     ),
    ),
   ),


  ),
 ),
 'view_manager' => array(
  'template_path_stack' => array(
   'page' => __DIR__ . '/../view',
  ),
  'strategies' => array(
   'ViewJsonStrategy',
  ),
 ),
 'controllers' => array(
  'invokables' => array(
   'User\Controller\User' => 'User\Controller\UserController'
  ),
 ),

 );