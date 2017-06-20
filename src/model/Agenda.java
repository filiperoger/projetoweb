package model;

import java.sql.Time;
import java.util.Date;

public class Agenda {
	private Integer agendaId;
	private Date data;
	private Time hora;
	private Integer pacienteId;
	private Integer medicoId;
	
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
	
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public Integer getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}
	
	public Integer getMedicoId() {
		return medicoId;
	}
	public void setMedicoId(Integer medicoId) {
		this.medicoId = medicoId;
	}
}