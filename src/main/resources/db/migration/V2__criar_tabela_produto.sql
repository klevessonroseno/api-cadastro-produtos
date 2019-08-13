create table produto(
	codigo bigint(20) primary key auto_increment,
    nome varchar(50) not null,
    preco decimal(10,2),
    quantidade bigint(10),
    codigo_categoria bigint(20) not null,
    foreign key (codigo_categoria) references categoria(codigo)
)engine=InnoDB default charset=utf8;