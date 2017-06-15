package model;

public class Paciente {

	private int pacienteId;
	private String nome;
	private Integer cpf;
	private Integer rg;

	public int getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Integer getRg() {
		return rg;
	}
	public void setRg(Integer rg) {
		this.rg = rg;
	}
	
	@Override
    public String toString() {
        return "Paciente [pacienteId=" + pacienteId + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg +"]";
    } 
}
