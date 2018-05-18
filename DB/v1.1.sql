create TABLE produto (
    id int not null auto_increment,
    nome varchar(255),
    valor DOUBLE,
    estoque varchar(255),
    filial varchar(255),
    
    primary key(id)
    );
    
alter table produto
add ativo boolean default true;