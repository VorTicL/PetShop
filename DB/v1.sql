CREATE TABLE cliente (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  dataNasc date NOT NULL,
  sexo varchar(1) NOT NULL,
  rg varchar(18) NOT NULL,
  cpf varchar(15) NOT NULL,
  endereco int(11) DEFAULT NULL,
  dataCri date NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE user1 (
  id int NOT NULL AUTO_INCREMENT,
  login varchar(100) NOT NULL,
  senha varchar(50) NOT NULL,
  filialId int(11) NOT NULL,
  dataCri date NOT NULL,
  email varchar(255) NOT NULL,
  nome varchar(255) NOT NULL,
  sobrenome varchar(255) NOT NULL,  
  dataNasc date not null,
  sexo varchar(255) NOT NULL,
  rg varchar(255) NOT NULL,
  cpf varchar(255) NOT NULL,
  typeUser varchar(255) NOT NULL,
  ativo boolean default true,  

  PRIMARY KEY (id),
  FOREIGN KEY (filialId) REFERENCES filial(idFilial)
)
CREATE TABLE servico (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(100),
  preco double,
  animal int(11),
  dataCri date NOT NULL,
  filialId int(11) NOT NULL,

  PRIMARY KEY (id)
  FOREIGN KEY (filialId) REFERENCES filial(idFilial)  
)
CREATE TABLE venda (
  id int(11) NOT NULL AUTO_INCREMENT,
  idservico int(11) DEFAULT NULL,
  idcliente int(11) DEFAULT NULL,
  dataCri date NOT NULL,
  filialId int(11) NOT NULL,
  
  PRIMARY KEY (id),
  FOREIGN KEY (filialId) REFERENCES filial(idFilial)  
)
CREATE TABLE produto (
    id int not null auto_increment,
    nome varchar(255),
    valor DOUBLE,
    estoque int,
    filialId varchar(255) not null,
    ativo boolean default true,
    
    primary key(id),
    FOREIGN KEY (filialId) REFERENCES filial(idFilial)
    )
CREATE TABLE filial(
    idFilial int not null auto_increment,
    nome varchar(255) not null,
    endereço varchar(255) not null,
    numeroEnd int not null,
    
    primary key(idFilial)
);