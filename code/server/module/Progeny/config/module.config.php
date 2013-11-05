<?php
return array(
 'doctrine' => array(
  'driver' => array(
   'progeny_entities' => array(
    'class' => 'Doctrine\ORM\Mapping\Driver\AnnotationDriver',
    'cache' => 'array',
    'paths' => array(__DIR__ . '/../src/Progeny/Entity')
   ),

   'orm_default' => array(
    'drivers' => array(
     'Progeny\Entity' => 'progeny_entities'
    )
   ))),

 'router' => array(
  'routes' => array(

   'addchild' => array(
    'type' => 'Zend\Mvc\Router\Http\Literal',
    'options' => array(
     'route' => '/addchild',
     'defaults' => array(
      'controller' => 'Progeny\Controller\Progeny',
      'action' => 'addchild',
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
   'Progeny\Controller\Progeny' => 'Progeny\Controller\ProgenyController'
  ),
 ),


);