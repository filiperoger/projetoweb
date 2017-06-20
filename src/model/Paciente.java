package model;

public class Paciente {

	private int pacienteId;
	private String nome;
	private String cpf;
	private String rg;

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
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@Override
    public String toString() {
        return "Paciente [pacienteId=" + pacienteId + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg +"]";
    } 
}