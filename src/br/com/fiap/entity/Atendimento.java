package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="atendimento")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 5573046919684470762L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id")
	private Medico medico;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	private String descricao;
	private Date data;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "atendimento")
	private List<Procedimento> procendimentos = new ArrayList<Procedimento>();
	
	public Atendimento(){
		
		
	}
	
	public Atendimento(Medico medico, Paciente paciente,
			String descricao, Date data) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.descricao = descricao;
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Procedimento> getProcendimentos() {
		return procendimentos;
	}
	public void setProcendimentos(List<Procedimento> procendimentos) {
		this.procendimentos = procendimentos;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
