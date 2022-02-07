create table apolices(

    id integer primary key auto_increment NOT NULL,
    numero_apolice long not null,
    inc_vigencia date not null,
    fim_vingencia date not null,
    placa_veiculo varchar(15) not null,
    valor_apolice decimal(4,2) NOT NULL,
    cliente_apolice integer not null
);