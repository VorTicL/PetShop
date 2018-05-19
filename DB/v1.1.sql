create TABLE produto (
    id int not null auto_increment,
    nome varchar(255),
    valor DOUBLE,
    estoque int,
    filial varchar(255),
    ativo boolean default true,
    
    primary key(id)
    );