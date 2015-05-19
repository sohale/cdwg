function Hello($scope, $http) {
    /*fixme: Warning: hardcoded constant*/
    u = 'http://localhost:8080//userfullstate?uid=7';
    /* 'http://localhost:8080/angulargreeting' */
    $http.get(u).
        success(function(data) {
            $scope.greeting = data;
            //alert(data);
        });
}
