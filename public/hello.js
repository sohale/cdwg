//todo: deprecate later
function Hello($scope, $http) {
    ///*fixme: Warning: hardcoded constant*/
    // /* 'http://localhost:8080/angulargreeting' */
    u = '/userfullstate?uid=7';
    $http.get(u).
        success(function(data) {
            $scope.userstate = data;
            //alert(data);
        });
}
