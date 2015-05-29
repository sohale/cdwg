//This file contains important AngularJS "controller"s used by the App (ng-controller="getYourStateJs").
//They are not organised as a module. If as a module, each (x) should be set as:  angular.module(...).controller(name, THIS )
function getUserStateJs($scope, $http) {
    ///*fixme: Warning: hardcoded constant*/
    //u = 'http://localhost:8080//userfullstate?uid=8';
    u = '/userfullstate?uid=8';
    $http.get(u).
        success(function(data) {
            $scope.userstate = data;
            //alert(data);
        });
}

function getYourStateJs($scope, $http) {
    //todo: (AngularJS) Use getUserStateJs with uid param.
    //u = 'http://localhost:8080//userfullstate?uid=7';
    u = '/userfullstate?uid=7';
    $http.get(u).
        success(function(data) {
            $scope.userstate = data;
            //alert(data);
        });
}

