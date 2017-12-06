create sequence usuario_id_seq;

CREATE TABLE usuario (
	 usuarioId INTEGER DEFAULT NEXTVAL('usuario_id_seq') PRIMARY KEY,
	 nome VARCHAR(50) NOT NULL,
	 email VARCHAR(50) NOT NULL,
	 senha VARCHAR(20) NOT NULL
);
insert into usuario (nome, email, senha) values ('gaby', 'gaby', 123);
insert into usuario (nome, email, senha) values ('gabryela.barros@gmail.com', 'gabryela.barros@gmail.com', 123);

create sequence paciente_id_seq; 
CREATE TABLE paciente (
	pacienteId INTEGER DEFAULT NEXTVAL('paciente_id_seq') PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(20) NOT NULL,
	rg VARCHAR(20) NOT NULL
);

create sequence medico_id_seq; 

CREATE TABLE medico (
	medicoId INTEGER DEFAULT NEXTVAL('medico_id_seq') PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	crm VARCHAR(20) NOT NULL
);

create sequence agenda_id_seq; 
CREATE TABLE agenda (
	agendaId INTEGER DEFAULT NEXTVAL('medico_id_seq') PRIMARY KEY,
	data VARCHAR(10) NOT NULL,
	hora VARCHAR(10) NOT NULL,
	pacienteId INTEGER NOT NULL,
	medicoId INTEGER NOT NULL,
	CONSTRAINT FK_agenda_paciente FOREIGN KEY(pacienteId) REFERENCES paciente(pacienteId),
	CONSTRAINT FK_agenda_medico FOREIGN KEY(medicoId) REFERENCES medico(medicoId)
);

