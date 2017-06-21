package model;

public class Agenda {
	private Integer agendaId;
	private String data;
	private String hora;
	private Paciente paciente;
	private Medico medico;
	
	public Integer getAgendaId() {
		return agendaId;
	}
	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}