angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/product';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        console.log('Click')
        $http.get(contextPath + '/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.createProduct = function () {
        console.log('Click2');
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
                $scope.newProduct = null;
            });
    }

    $scope.loadProducts();
});