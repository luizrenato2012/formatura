var app = angular.module('formaturaApp',['InstituicaoServiceMdl']);

app.controller('InstituicaoController', ['$scope','InstituicaoService' ,function($scope,InstituicaoService) {
	$scope.instituicao = {};
//	$scope.instituicao.nome=null;
//	$scope.instituicao.telefone=null;
//	$scope.instituicao.endereco=null;
	
	$scope.grava = function() {
		console.log('Gravando ' + $scope.instituicao);
		InstituicaoService.inclui($scope.instituicao)
			.success(function(data,status,headers,config){
				console.log(data);
				$scope.instituicao = {};
			})
			.error(function(data,status, headers, config){
				console.log(data + ' status ' + status);
				
			});
	}
	
	$scope.testa = function() {
		$scope.instituicao = {
			id :1,
			nome: 'Instituicao 1',
			telefone: '222-2222',
		};
		
		console.log('Gravando ' + $scope.instituicao);
		InstituicaoService.testa($scope.instituicao)
			.success(function(data,status,headers,config){
				console.log(data);
			})
			.error(function(data,status, headers, config){
				console.log(data + ' status ' + status);
				
			});
	}
}]);