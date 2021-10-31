create table cliente (
	idCliente int not null Primary Key,
	nome varchar(180),
	descricao varchar(250),
	cpfCnpj varchar(14),
	email varchar(110),
	telefone varchar(18),
	fotoPerfil varBinary(max),
	senha varchar(200),
	dataNascimento date,
	dataCadastro date,
	saldoCliente money,
	notaCliente decimal,
	reputacao decimal
)

insert cliente values(1, 'Lucas silva de Jesus', 'nenhuma', 'xxxxx-xxx', 'lucas@gmail.com', '19 9 971579760',  ,'não tem', '1999-04-01', '2021-01-01', 10, 5.0, 5.0)

create table horarioDisponiveis(
idHorarios int not null primary key,
horario datetime,
disponivel int
)

create table cabeleleiro(
idCabeleleiro int not null primary key,
nome varchar(150),
anosExperiencia decimal,
reputacao decimal
)

create table barbearia(
	idBarbearia int not null primary key,
	nome varchar(180),
	descricao varchar(250),
	cpfCnpj varchar(14),
	email varchar(110),
	telefone varchar(18),
	fotoPerfil varBinary(max),
	senha varchar(200),
	dataNascimento date,
	dataCadastro date,
	idHorarioDisponivel int,
	especialidade varchar(25),
	idCabeleleiro int,
	foreign key (idHorarioDisponivel) references horarioDisponiveis(idHorarios),
	foreign key (idCabeleleiro) references cabeleleiro(idCabeleleiro),
) 

 create table Endereco(
	idEndereco int not null primary key,
	cep varchar(9),
	rua varchar(50),
	bairro varchar(20),
	numero varchar(5),
	cidade varchar(25),
	estado varchar(25),
	complemento varchar(100)
 )

 create table servico(
	idServico int not null primary key,
	nome varchar(50),
	dataServico date,
	inicioCorte dateTime,
	fimCorte dateTime,
	valorCorte money
 )

 create table servicoSolicitado(
	idServico int,
	idCliente int,
	idBarbearia int,
	foreign key(idServico) references servico(idServico),
	foreign key(idCliente) references cliente(idCliente),
	foreign key(idBarbearia) references barbearia(idBarbearia),
 )

 create table avaliacao(
	idAvaliacao int not null primary key,
	notaAvaliacao decimal
 )

 create table feedback(
	idFeedback int not null primary key,
	idAvaliacao int,
	comentario varchar(150),
	foreign key(idAvaliacao) references avaliacao(idAvaliacao)
 )

 create table servicosRealizados(
	idServico int,
	idCliente int,
	idBarbearia int,
	idFeedback int,
	foreign key(idServico) references servico(idServico),
	foreign key(idCliente) references cliente(idCliente),
	foreign key(idBarbearia) references barbearia(idBarbearia),
	foreign key(idFeedback) references feedback(idFeedback),
 )

 create table moradiaCliente(
	idCliente int,
	idEndereco int,
	foreign key(idCliente) references cliente(idCliente),
	foreign key (idEndereco) references endereco(idEndereco)
)

 create table moradiaCabeleleiro(
	idCabeleleiro int,
	idEndereco int,
	foreign key(idCabeleleiro) references cabeleleiro(idCabeleleiro),
	foreign key (idEndereco) references endereco(idEndereco)
)

create table logradouroBarbearia(
	idBarbearia int,
	idEndereco int,
	foreign key(idBarbearia) references barbearia(idBarbearia),
	foreign key (idEndereco) references endereco(idEndereco)
)

select * from cliente

