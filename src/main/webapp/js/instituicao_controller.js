var app = angular.module('formaturaApp',['InstituicaoServiceMdl']);

app.controller('InstituicaoController', ['$scope','InstituicaoService' ,function($scope,InstituicaoService) {
	$scope.instituicao = {};
	$scope.lista = [];
	$scope.argumento = '';
	$scope.idSelecao = {};
	
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
	
	$scope.lista = function() {
		console.log('listando') ;
		
		InstituicaoService.lista($scope.argumento)
			.success(function(data,status,headers,config){
				$scope.lista = data;
			})
			.error(function(data,status, headers, config){
				console.log(' status ' + status);
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
	
	$scope.deleta = function() {
		console.log('deletando '+ $scope.idSelecao);
		InstituicaoService.deleta($scope.idSelecao)
			.success(function(data,status,headers,config) {
				this.lista($scope.argumento);
			})
			.error(function(data,status,headers,config) {
				console.log('Erro ao excluir');
			});
	}
	
	$scope.seleciona = function(id) {
		console.log('selecionado '+ id);
		$scope.idSelecao = id;
	}
}]);