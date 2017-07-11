var app = angular.module('InstituicaoControllerMdl',['InstituicaoServiceMdl']);

app.controller('instituicaoController', ['$scope','instituicaoService' ,'$location', function($scope, instituicaoService, $location) {
	$scope.instituicao = {};
	$scope.instituicoes = [];
	$scope.argumento = '';
	$scope.idSelecao = {};
	$scope.tipoTela = '';
	
	$scope.busca = function(id) {
		instituicaoService.busca(id)
			.success(function(data,status,headers,config){
				console.log(data);
				$scope.instituicao = data;
			})
			.error(function(data,status, headers, config){
				console.log(data + ' status ' + status);
				
			});
	}
	
	$scope.init = function () {
		console.log('url ' + $location.path());
		var url =  $location.path();
		var urlSplit = url.split('/');
		if (url.indexOf('add') != -1) {
			console.log('Adiciona');
			$scope.tipoTela = 'Adiciona ';
		} else if (urlSplit.length > 1){
			console.log('Atualiza');
			$scope.tipoTela = 'Altera ';
			$scope.idSelecao = urlSplit[urlSplit.length-1];
			$scope.busca($scope.idSelecao);
		}
	}();
	
	$scope.grava = function() {
		console.log('Gravando ' + $scope.instituicao);
		instituicaoService.inclui($scope.instituicao)
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
		
		instituicaoService.lista($scope.argumento)
			.success(function(data,status,headers,config){
				$scope.instituicoes = data;
			})
			.error(function(data,status, headers, config){
				console.log(' status ' + status);
			});
	}
	
/*	$scope.testa = function() {
		$scope.instituicao = {
			id :1,
			nome: 'Instituicao 1',
			telefone: '222-2222',
		};
		
		console.log('Gravando ' + $scope.instituicao);
		instituicaoService.testa($scope.instituicao)
			.success(function(data,status,headers,config){
				console.log(data);
			})
			.error(function(data,status, headers, config){
				console.log(data + ' status ' + status);
				
			});
	}*/
	
	$scope.deleta = function() {
		console.log('deletando '+ $scope.idSelecao);
		instituicaoService.deleta($scope.idSelecao)
			.success(function(data,status,headers,config) {
				$scope.lista($scope.argumento);
			})
			.error(function(data,status,headers,config) {
				console.log('Erro ao excluir');
			});
	}
	
	$scope.seleciona = function(id) {
		console.log('selecionado '+ id);
		$scope.idSelecao = id;
	}
	
	$scope.irPara = function(id) {
		console.log('Indo para '+ id);
	}
	
	$scope.edita = function(instituicao) {
		$scope.instituicao = instituicao;
	}
}]);