

angular.module('my-usestate-angjs-module', [])
  .controller('hommeeem',
  function($scope) {$scope.greeting = {id: 'xxx', content: 'Hello World!'} }
  )
//not actually used/accesses from apppg2.html


/* This is an AngularJS module.
There is a lot going on here:
1- A module name
2- A config
3- A controller called "home"

The "home" controller will be called when we load the "index.html" because we said:
 <body ng-app="my-usestate-angjs-module">
Angular does dependency injection.
*/