var app = angular.module('formaturaApp',['ngRoute','InstituicaoControllerMdl']);

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
		});
}]);