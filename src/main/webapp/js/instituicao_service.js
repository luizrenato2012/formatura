var instituicaoService = angular.module('InstituicaoServiceMdl',[]);

instituicaoService.service('instituicaoService', function($http) {
	
	this.grava = function(instituicao) {
		if(instituicao.id!=null){
			return $http.put('http://localhost:8080/formatura/api/v1/instituicoes', instituicao);
		} else {
			return $http.post('http://localhost:8080/formatura/api/v1/instituicoes', instituicao);
		}
		
	}
	
	this.testa = function(teste) {
		return $http.post('http://localhost:8080/formatura/api/v1/instituicoes', teste);
	}
	
	this.lista = function(argumento) {
		var url = '';
		if(argumento!=null && argumento!="") {
			return $http.get('http://localhost:8080/formatura/api/v1/instituicoes/nome/'+argumento);
		} else {
			return $http.get('http://localhost:8080/formatura/api/v1/instituicoes');
		}
	}
	
	this.deleta = function(id) {
		return $http.delete('http://localhost:8080/formatura/api/v1/instituicoes/'+id);
	}
	
	this.busca = function(id) {
		return $http.get('http://localhost:8080/formatura/api/v1/instituicoes/'+id);
	}
});