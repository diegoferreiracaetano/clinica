package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="material")
public class Material implements Serializable{
	
	private static final long serialVersionUID = -1218805866198797473L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "procedimento_id")
	private Procedimento procedimento;
	private int tipo;
	private String descricao;
	private double valor;
	
	
	public Material() {
		super();
	}
	public Material(Procedimento procedimento, int tipo, String descricao,double valor) {
		super();
		this.procedimento = procedimento;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
		
	
}
