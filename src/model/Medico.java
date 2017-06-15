package model;

import java.util.List;

public class Medico {
	
	private int medicoId;
	private String nome;
	private String crm;
	private List<Agenda> agendas;

	public int getMedicoId() {
		return medicoId;
	}
	public void setMedicoId(int medicoId) {
		this.medicoId = medicoId;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public List<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	
	@Override
    public String toString() {
        return "Medico [medicoId=" + medicoId + ", nome=" + nome + ", crm=" + crm + "]";
    } 
}
