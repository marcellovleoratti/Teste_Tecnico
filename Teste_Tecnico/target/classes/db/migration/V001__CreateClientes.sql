create table clientes(
    id              integer primary key auto_increment NOT NULL,
    nome            varchar(255) not null,
    cpf             INTEGER not null,
    cidade          varchar(255) not null,
    uf              VARCHAR(2) not null,
    cliente_apolice integer not null
);

