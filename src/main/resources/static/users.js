angular.module('app', []).controller('usersController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/v1';

    $scope.loadUsers = function () {
        $http.get(contextPath + '/users')
            .then(function (response) {
                $scope.usersLisr = response.data;
            });
    };

    $scope.loadUsers();

});