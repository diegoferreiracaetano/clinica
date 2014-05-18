package br.com.fiap.programa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.fiap.dao.AtendimentoDao;
import br.com.fiap.dao.MaterialDao;
import br.com.fiap.dao.MedicoDao;
import br.com.fiap.dao.PacienteDao;
import br.com.fiap.dao.ProcedimentoDao;
import br.com.fiap.entity.Atendimento;
import br.com.fiap.entity.Material;
import br.com.fiap.entity.Medico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;

public class Main {

	/**
	 * Diego Ferreira Caetano<diegofcaetano@hotmail.com>
	 * 18/05/2014
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Insere Paciente
		 */
		Paciente paciente = new Paciente("Diego","Ferreira","11 9999-9999");
		new PacienteDao().insert(paciente);
		
		/**
		 * Insere Medico
		 */
		Medico medico = new Medico("22255","Dr." , "House");
		new MedicoDao().insert(medico);
		
		/**
		 * Insere Atendimento
		 */
		Atendimento atendimento = new Atendimento(medico,paciente,"Paciente com dores",new Date());
		new AtendimentoDao().insert(atendimento);
		
		/**
		 * Insere Procedimento
		 */
		Procedimento procedimento = new Procedimento(atendimento,"Tomar remedios");
		new ProcedimentoDao().insert(procedimento);
		
		/**
		 * Insere Materiais
		 */
	    new MaterialDao().insert(new Material(procedimento,1, "Dipirona", 10.50));
		new MaterialDao().insert(new Material(procedimento,2, "Injeção", 5.50));
		new MaterialDao().insert(new Material(procedimento,2, "agulha", 2.50));
		
		
		
		StringBuffer string = new StringBuffer();
		
		/**
		 * Lista Atendimento
		 */
		Atendimento a = new AtendimentoDao().findById(atendimento.getId());
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		string.append("Atedimento as : "+dt.format(a.getData())+" - Descrição : "+a.getDescricao()+"\n");
		
		/**
		 * Lista Paciente
		 */
		Paciente p1 = new PacienteDao().findById(paciente.getId());
		string.append("Paciente: "+p1.getNome()+" "+p1.getSobrenome()+" - Telefone: "+p1.getTelefone()+"\n");
		
		/**
		 * Lista Medicos
		 */
		Medico m1 = new MedicoDao().findById(medico.getId());
		string.append("Medico: "+m1.getNome()+" "+m1.getSobrenome()+" - CRM: "+m1.getCrm()+"\n");
		
		/**
		 * Lista Procedimentos
		 */
		Procedimento p = new ProcedimentoDao().findById(atendimento.getId());
		string.append("Procecimento: "+p.getDescricao()+"\n");
		
		
		/**
		 * Lista Materias
		 */
		string.append("Lista de Material/Medicamentos: \n");
		List<Material> lista = p.getMaterial();
		for (Material material : lista) {
			string.append("Descrição: "+material.getDescricao()+" Valor:"+material.getValor()+" Tipo: "+((material.getTipo()  == 1)?"Medicamento":"Material")+"\n");
		}
		
		
		/**
		 * Exibe conteudo
		 */
		System.out.println(string);
	}
	

}
