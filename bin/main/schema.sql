
drop table if exists enderecos;
create table enderecos(
    id number not null auto_increment,
    cep varchar(8),
    estado varchar(2),
    cidade varchar(64),
    logradouro varchar(256),
    numero number,
    primary key (id)
);


drop table if exists usuarios;
create table usuarios (
	id number not null auto_increment,
	username varchar(10) not null,
	password varchar(100) not null,
	nome varchar(40) not null,
	email varchar(40) not null,
    PRIMARY KEY (id),
    UNIQUE KEY (username)
);

drop table if exists papeis;
create table papeis (
	id number not null auto_increment,
	usuario_id bigint,
	papel varchar(20) not null,
    primary key (id),
    UNIQUE KEY (papel),
    CONSTRAINT FOREIGN KEY
    usuarios_id_fk (usuario_id)
    references usuarios(id)
);

drop table if exists os;
create table os(
    id number not null auto_increment,
    cliente_id number,
    plano varchar(16),
    endereco_id number,
    instalador_id number,
    abertura date,
    execucao date,
    primary key (id),
    constraint FOREIGN key
    cliente_id_fk (cliente_id)
    references usuarios(id),
    constraint FOREIGN key
    endereco_id_fk (endereco_id)
    references enderecos(id),
    constraint FOREIGN key
    instalador_id_fk (instalador_id)
    references usuarios(id)
);
