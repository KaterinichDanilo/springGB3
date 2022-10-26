angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.createProduct = function () {
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.changePrice = function (prodId, delta){
        $http({
            url: contextPath + '/product/change_price',
            method: 'GET',
            params: {
                clientId: prodId,
                delta: delta
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.deleteProduct = function (productId){
        $http.get(contextPath + '/product/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            })
    }

    $scope.loadProducts();

});