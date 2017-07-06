var app = angular.module('formaturaApp',['InstituicaoServiceMdl']);

app.controller('InstituicaoController', ['$scope','InstituicaoService' ,function($scope,InstituicaoService) {
	$scope.instituicao = {};
	
	$scope.grava = function() {
		console.log('Gravando ' + $scope.instituicao);
		InstituicaoService.inclui($scope.instituicao)
			.success(function(data){
				console.log(data);
			})
			.error(function(data,status, headers){
				console.data(data + ' status ' + status);
				
			});
	}
}]);