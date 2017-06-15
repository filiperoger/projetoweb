package model;

public class Usuario {	
	
	private int usuarioId;
	private String nome;
	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	} 
	
	@Override
    public String toString() {
        return "Usuario [usuarioId=" + usuarioId + ", nome=" + nome
                + ", email=" + email + ", senha=" +senha+"]";
    }    
}
