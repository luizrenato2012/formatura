var app = angular.module('InstituicaoControllerMdl',['InstituicaoServiceMdl']);

app.controller('instituicaoController', ['$scope','instituicaoService' ,'$location', function($scope, instituicaoService, $location) {
	$scope.instituicao = {};
	$scope.instituicoes = [];
	$scope.argumento = '';
	$scope.idSelecao = {};
	$scope.tipoTela = '';
	
	$scope.classeMensagem='';
	$scope.mensagem='';
	
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
		var resValidacao = valida($scope.instituicao);
		if(resValidacao!=''){
			$scope.mensagem = 'Campos obrigatórios:'+ resValidacao;
			$scope.classeMensagem = 'alert alert-danger';
			return;
		}
		
		instituicaoService.grava($scope.instituicao)
			.success(function(data,status,headers,config){
				console.log(data);
				$scope.instituicao = {};
				$scope.mensagem='Registro gravado com sucesso!';
				$scope.classeMensagem = 'alert alert-info';
			})
			.error(function(data,status, headers, config){
				console.log( ' status ' + status);
				$scope.mensagem='<strong>Atenção</strong>Erro ao gravar.';
				$scope.classeMensagem = 'alert alert-info';
			});
	}
	
	$scope.valida = function (instituicao){
		var camposInvalidos = [];
		var retorno=[];
		if(instituicao.nome== null || instituicao.nome==''){
			camposInvalidos.push('nome');
		}
		if(instituicao.telefone== null || instituicao.telefone==''){
			camposInvalidos.push='telefone';
		}
		
		if (camposInvalidos.length > 0 ) {
			for(var i; camposInvalidos.length; i++){
				retorno+=camposInvalidos[i]+',';
			}
		}
		return retorno;
	}
	
	$scope.exibeMensagem = function (mensagem,tipo){
		$scope.classeMensagem='';
		$scope.mensagem='mensagem';
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
	
	$scope.cancela = function() {
		$scope.instituicao = {};
	}
	
	$scope.limpaMensagem = function() {
		$scope.mensagem='';
	}
}]);