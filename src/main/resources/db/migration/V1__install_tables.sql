CREATE TABLE CATEGORIAS (
    ID_CATEGORIA INT PRIMARY KEY AUTO_INCREMENT,
    CATEGORIA VARCHAR(50) NOT NULL
);

INSERT INTO CATEGORIAS(ID_CATEGORIA, CATEGORIA) VALUES(1,'Bebida alcoólica');
INSERT INTO CATEGORIAS(ID_CATEGORIA, CATEGORIA) VALUES(2,'Refrigerante');
INSERT INTO CATEGORIAS(ID_CATEGORIA, CATEGORIA) VALUES(3,'Salgado');
INSERT INTO CATEGORIAS(ID_CATEGORIA, CATEGORIA) VALUES(4,'Almoço');

CREATE TABLE PRODUTOS (
    ID_PRODUTO INT PRIMARY KEY AUTO_INCREMENT,
    ID_CATEGORIA INT,
    PRODUTO VARCHAR(50) NOT NULL,
    PRECO INT NOT NULL,
    QUANTIDADE INT,
    DESCRICAO VARCHAR(255),
    FOTO VARCHAR(150),
    FOREIGN KEY(ID_CATEGORIA) REFERENCES CATEGORIAS(ID_CATEGORIA)
);

INSERT INTO PRODUTOS(ID_PRODUTO, ID_CATEGORIA, PRODUTO, PRECO, QUANTIDADE, DESCRICAO, FOTO) VALUES(1, 1, 'Skol beats', 780, 52, 'A Skol Beats Senses 269ml', 'https://static.carrefour.com.br/medias/sys_master/images/images/hf1/ha0/h00/h00/9319610810398.jpg');
INSERT INTO PRODUTOS(ID_PRODUTO, ID_CATEGORIA, PRODUTO, PRECO, QUANTIDADE, DESCRICAO, FOTO) VALUES(2, 2, 'Coca cola', 500, 44, 'Coca cola lata de 350cm', 'https://images-na.ssl-images-amazon.com/images/I/81mEIp4PMBL._SL1500_.jpg');
INSERT INTO PRODUTOS(ID_PRODUTO, ID_CATEGORIA,  PRODUTO, PRECO, QUANTIDADE, DESCRICAO, FOTO) VALUES(3, 3, 'Coxinha', 350, 15, 'Coxinha feita com massa de batata e frango', 'https://t1.rg.ltmcdn.com/pt/images/1/9/1/img_coxinha_simples_191_600.jpg');
INSERT INTO PRODUTOS(ID_PRODUTO, ID_CATEGORIA, PRODUTO, PRECO, QUANTIDADE, DESCRICAO, FOTO) VALUES(4, 4, 'Refeição PF', 1450, 39, 'Refeição completa com salada, arroz, feijão, batata frita e um bife de contra filé', 'https://media-cdn.tripadvisor.com/media/photo-s/0e/f4/fc/7c/bife-a-cebolado-de-contra.jpg');

CREATE TABLE CLIENTES (
    ID_CLIENTE INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(150) NOT NULL,
    EMAIL VARCHAR(150) NOT NULL UNIQUE,
    SENHA VARCHAR(150) NOT NULL,
    RUA VARCHAR(150),
    CIDADE VARCHAR(100),
    BAIRRO VARCHAR(100),
    CEP VARCHAR(8),
    ESTADO VARCHAR(30)
);

INSERT INTO CLIENTES(ID_CLIENTE, NOME, EMAIL, SENHA, RUA, CIDADE, BAIRRO, CEP, ESTADO) VALUES(1, 'Jhony Mota Oliveira', 'jhonymota@hotmail.com', '$2a$10$rs2z4AnQ7H8E8jUJOYju0uT4ks4wHeAD.1u4incmg4pIWZ8jEzE1y', 'rua lambari', 'ribeirão pires', 'ouro fino', '09440220', 'SP');

CREATE TABLE PEDIDOS (
    ID_PEDIDO INT PRIMARY KEY AUTO_INCREMENT,
    ID_CLIENTE INT NOT NULL,
    STATUS VARCHAR(50) NOT NULL,
    TOTAL INT NOT NULL,
    DATA_ABERTURA DATETIME NOT NULL,
    DATA_FECHAMENTO DATETIME,
    FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTES(ID_CLIENTE)
);

CREATE TABLE PEDIDO_ITENS (
    ID_ITEM INT PRIMARY KEY AUTO_INCREMENT,
    ID_PEDIDO INT NOT NULL,
    ID_PRODUTO INT NOT NULL,
    QUANTIDADE INT NOT NULL,
    VALOR INT NOT NULL,
    SUBTOTAL INT NOT NULL,
    FOREIGN KEY (ID_PEDIDO) REFERENCES PEDIDOS(ID_PEDIDO),
    FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTOS(ID_PRODUTO)
);