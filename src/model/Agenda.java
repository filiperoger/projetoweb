package model;

import java.sql.Time;
import java.util.Date;

public class Agenda {
	private Integer agendaId;
	private Date data;
	private Time hora;
	private Paciente paciente;
	
	public Integer getAgendaId() {
		return agendaId;
	}
	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
}
