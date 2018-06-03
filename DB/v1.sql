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
  FOREIGN KEY (filialId) REFERENCES filial(id)
)

CREATE TABLE servico (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(100),
  preco double,
  animal int(11),
  dataCri date NOT NULL,
  filialId int(11) NOT NULL,

  PRIMARY KEY (id)
  FOREIGN KEY (filialId) REFERENCES filial(id)  
)
CREATE TABLE venda (
  id int(11) NOT NULL AUTO_INCREMENT,
  clienteId int(11) not null,
  dataCri date NOT NULL,
  filialId int(11) NOT NULL,
  valorTotal double,  
  
  PRIMARY KEY (id),
  FOREIGN KEY (filialId) REFERENCES filial(id),
  FOREIGN KEY (clienteId) REFERENCES cliente(id)
)

CREATE TABLE itensVenda(
    vendaId int(11) not null,
    prodId int(11) not null,
    quantidade int (11) not null,
    valorUni double,

    FOREIGN KEY (vendaId) REFERENCES venda(id),
    FOREIGN KEY (prodId) REFERENCES produto(id)
)

CREATE TABLE itensServico(
    vendaId int(11) not null,
    servId int(11) not null,
    quantidade int (11) not null,
    valorUni double,

    FOREIGN KEY (vendaID) REFERENCES venda(id),
    FOREIGN KEY (servID) REFERENCES servico(id)
)

CREATE TABLE produto (
    id int not null auto_increment,
    nome varchar(255),
    valor DOUBLE,
    estoque int,
    filialId varchar(255) not null,
    ativo boolean default true,
    
    primary key(id),
    FOREIGN KEY (filialId) REFERENCES filial(id)
    )
CREATE TABLE filial(
    id int not null auto_increment,
    nome varchar(255) not null,
    endereco varchar(255) not null,
    numeroEnd int not null,
    dataCri date not null,
    
    primary key(id)
);