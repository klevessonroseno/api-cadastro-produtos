create table categoria(
	codigo bigint(20) primary key auto_increment,
    nome varchar(100),
    descricao varchar(200)
)engine=InnoDb default charset=utf8;