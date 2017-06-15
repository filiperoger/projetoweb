CREATE TABLE usuario (
	 usuarioId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	 nome VARCHAR(50) NOT NULL,
	 email VARCHAR(50) NOT NULL,
	 senha VARCHAR(20) NOT NULL
);

CREATE TABLE paciente (
	pacienteId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cpf INTEGER NOT NULL,
	rg INTEGER NOT NULL
);

CREATE TABLE agenda (
	agendaId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	data DATE NOT NULL,
	hora TIME NOT NULL,
	pacienteId INTEGER NOT NULL,
	CONSTRAINT FK_agenda_paciente FOREIGN KEY(pacienteId) REFERENCES paciente(pacienteId)
);

CREATE TABLE medico (
	medicoId INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	crm VARCHAR(20) NOT NULL,
	agendaId INTEGER NOT NULL,
	CONSTRAINT FK_medico_agenda FOREIGN KEY(agendaId) REFERENCES agenda(agendaId)
);