package br.com.lrsantos.model.dao;

import java.util.ArrayList;
import java.util.List;

public abstract class  AbstractDAO <T, I extends Integer> {
	private List<T> lista = new ArrayList<T>();
	
	public  void inclui(T t) {
		this.lista.add(t);
	}
	
	public  void atualiza(T t1) {
		int index = lista.indexOf(t1);
		for(T t2 : this.lista){
			if (isIgual(t1, t2)){
				this.lista.set(index,t2);
				break;
			}
		}
	}
	
	protected abstract boolean isIgual(T t1, T t2);
	
	protected abstract boolean isMesmoId(T t1, I id);
	
	public  void exclui(I id){
		for(T t2 : this.lista){
			if (isMesmoId(t2, id)){
				this.lista.remove(t2);
				break;
			}
		}
	}
	
	public  List<T> listaTodos() {
		return this.lista;
	}
	
	public  T procura( I id) {
		for(T t2 : this.lista){
			if (isMesmoId(t2, id)){
				return t2;
			}
		}
		return null;
	}

}
