
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

    function choosefunction(c){
       //$scope.userstate.lastChoice.push({});
       $scope.userstate.lastChoice=c;
       //alert("c="+c);
       /*
       // see public/websock/bcw-wsock.js:
       jsn_string=JSON.stringify({ 'uid': uid, 'new_choice':choice,  'old_choice':old_choice  });
       stompClient.send(APP_WEBSOCK_FULL, {}, jsn_string); //Send as a string.
       */
       //CHOOSE_URL="http://localhost:8080/choose?uid=7&choice=1";
       CHOOSE_URL="/choosej?uid=7&choice="+c;
       //alert("url="+CHOOSE_URL);

       function put_in_scope(data){
          $scope.userstate = data;
          $scope.userstate.debugText = "set through a json returned via the GET sent to the RESTController";
       }

       //this GET actually sends data, then puts it [the json] into $scope:
       $http.get(CHOOSE_URL).success(put_in_scope);
    }

    //data-ng-click="uchoose(3)"
    $scope.uchoose = choosefunction;  //uchoose  is simply called
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