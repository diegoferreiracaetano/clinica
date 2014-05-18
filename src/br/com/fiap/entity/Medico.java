package br.com.fiap.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="medico")
public class Medico implements Serializable {

	private static final long serialVersionUID = 1713765629353600826L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String crm;
	private String nome;
	private String sobrenome;
	
	public Medico(){
				
	}
	
	public Medico(String crm, String nome, String sobrenome) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
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
	
	
}
