function getUserStateJs($scope, $http) {
    ///*fixme: Warning: hardcoded constant*/
    u = 'http://localhost:8080//userfullstate?uid=8';
    $http.get(u).
        success(function(data) {
            $scope.userstate = data;
            //alert(data);
        });
}

function getYourStateJs($scope, $http) {
    //todo: (AngularJS) Use getUserStateJs with uid param.
    u = 'http://localhost:8080//userfullstate?uid=7';
    $http.get(u).
        success(function(data) {
            $scope.userstate = data;
            //alert(data);
        });
}

