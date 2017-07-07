package br.com.lrsantos.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//
@Entity
@Table(name="formatura.endereco")
@SequenceGenerator(sequenceName="formatura.seq_id_endereco",name="SEQ_ID_ENDERECO",allocationSize=1)
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_ID_ENDERECO")
	private Integer id;
	
	@Column(length=50)
	private String logradouro;
	
	@Column(length=7)
	private String numero;
	
	@Column(length=20)
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}
	
	
}
