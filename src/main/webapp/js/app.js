var app = angular.module('formaturaApp',['ngRoute','InstituicaoControllerMdl']);

app.controller('appController', ['$scope', '$route', function($scope, $route){
	$scope.rota = $route;
}]);

app.config(['$routeProvider','$locationProvider',function($routeProvider,$locationProvider){
	$locationProvider.hashPrefix('!');
	
	$routeProvider
		.when('/instituicoes', {
			templateUrl: 'view/lista_instituicao.html',
			controller: 'instituicaoController'
		})
		.when('/instituicoes/:id', {
			templateUrl: 'view/instituicao.html',
			controller: 'instituicaoController'
		})
		.when('/instituicoes/add', {
			templateUrl: 'view/instituicao.html',
			controller: 'instituicaoController'
		})
		.when('', {
			templateUrl: 'view/index.html',
			controller: 'appController'
		}).otherwise ({redirectTo: '/'}) ;
}]);