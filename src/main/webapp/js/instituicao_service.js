var instituicaoService = angular.module('InstituicaoServiceMdl',[]);

instituicaoService.service('instituicaoService', function($http) {
	 //teste
	this.grava = function(instituicao) {
		if(instituicao.id!=null){
			return $http.put('/formatura/api/v1/instituicoes/'+ instituicao.id, instituicao);
		} else {
			return $http.post('/formatura/api/v1/instituicoes', instituicao);
		}
	}
	
	this.testa = function(teste) {
		return $http.post('/formatura/api/v1/instituicoes', teste);
	}
	
	this.lista = function(argumento) {
		var url = '';
		if(argumento!=null && argumento!="") {
			return $http.get('/formatura/api/v1/instituicoes/nome/'+argumento);
		} else {
			return $http.get('/formatura/api/v1/instituicoes');
		}
	}
	
	this.deleta = function(id) {
		return $http.delete('/formatura/api/v1/instituicoes/'+id);
	}
	
	this.busca = function(id) {
		return $http.get('/formatura/api/v1/instituicoes/'+id);
	}
});