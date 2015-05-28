
/* from public/js/appjs1.js */
function getUserStateJs2($scope, $http) {
    ///*fixme: Warning: hardcoded constant*/
    u = 'http://localhost:8080//userfullstate?uid=8';
    $http.get(u).
        success(function(data) {
            $scope.userstate = data;
            $scope.userstate.debugText="(s)he2";
            //alert(data);
        });
}

/* from public/js/appjs1.js */
function getYourStateJs2($scope, $http) {
    //todo: (AngularJS) Use getUserStateJs with uid param.
    u = 'http://localhost:8080//userfullstate?uid=7';
    $http.get(u).
        success(function(data) {
            $scope.userstate = data;
            $scope.userstate.debugText="you2";
            //alert(data);
        });
}



angular.module('my-usestate-angjs-module', [])
  .controller('getUserStateJs_',
  //function($scope) {$scope.greeting = {id: 'xxx', content: 'Hello World!'} }
  getUserStateJs2)
  .controller('getYourStateJs_',
  getYourStateJs2)


/* This is an AngularJS module.
There is a lot going on here:
1- A module name
2- A config
3- A controller called "home"

The "home" controller will be called when we load the "index.html" because we said:
 <body ng-app="my-usestate-angjs-module">
Angular does dependency injection.
*/