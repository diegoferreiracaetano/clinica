package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name="paciente", schema = "clinica")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 297685567996806057L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String sobrenome;
	private String telefone;
	
	
	public Paciente() {
		super();
	}

	public Paciente(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
