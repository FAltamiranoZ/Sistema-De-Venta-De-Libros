connect 'jdbc:derby://localhost:1527/serviciosVenta;user=app;password=app';


DROP TABLE pedidos;
DROP TABLE facturas;
DROP TABLE clientes;
DROP TABLE productos;
DROP TABLE empresas;


------------------------------- 
--     CLIENTES
-------------------------------

CREATE  TABLE  clientes
(
  idCliente INT  NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1 ,INCREMENT BY 1) 
     CONSTRAINT CLIENTES_PK PRIMARY KEY,
  nombreCliente VARCHAR(100) NOT NULL ,
  saldo FLOAT NOT NULL 
);

INSERT INTO clientes (nombreCliente, saldo) VALUES 
('Jose Francisco Altamirano Zevallos', 1000),
('Sebastian Valderrabano Cabrera', 1000),
('Fernando Merino Benitez', 1000),
('America Castrejon Porres', 1000),
('Rodrigo Castillo Gomez', 1000),
('Eduardo Daniel Urrutia Ruiz', 1000);


------------------------------- 
--     PRODUCTOS
-------------------------------

CREATE  TABLE  productos
(
  ISBN INT  NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1 ,INCREMENT BY 1) 
     CONSTRAINT PRODUCTOS_PK PRIMARY KEY,
  nombreLibro VARCHAR(100) NOT NULL ,
  unidades INT NOT NULL
);

INSERT INTO productos (nombreLibro, unidades) VALUES 
('La comunidad del anillo', 10),
('Las dos torres', 20),
('El retorno del rey', 30);


------------------------------- 
--     EMPRESAS
-------------------------------

CREATE  TABLE  empresas
(
  nombreEmpresa VARCHAR(100) NOT NULL ,
  PRIMARY KEY (nombreEmpresa)
);

INSERT INTO empresas (nombreEmpresa) VALUES 
('Amazon'),
('FedEx'),
('UPS'),
('DHL'),
('Correos de Mexico');


------------------------------- 
--     FACTURAS
-------------------------------

CREATE  TABLE facturas
 (
  idFactura INT  NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1 ,INCREMENT BY 1) 
     CONSTRAINT FACTURAS_PK PRIMARY KEY, 
  idCliente INT  NOT NULL ,
  cuantia FLOAT NOT NULL ,
  CONSTRAINT fk_idCliente
    FOREIGN KEY (idCliente )
    REFERENCES clientes (idCliente )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO facturas (idCliente, cuantia) VALUES 
(1, 100),
(1, 800),
(2, 400),
(4, 420.69),
(3, 11.11);


------------------------------- 
--     PEDIDOS
-------------------------------

CREATE  TABLE pedidos
 (
  idPedido INT  NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1 ,INCREMENT BY 1) 
     CONSTRAINT PEDIDOS_PK PRIMARY KEY, 
  fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  nombreEmpresa VARCHAR(100)  NOT NULL ,
  idFactura INT  NOT NULL ,
  CONSTRAINT fk_idFactura
    FOREIGN KEY (idFactura )
    REFERENCES facturas (idFactura )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_nombreEmpresa
    FOREIGN KEY (nombreEmpresa )
    REFERENCES empresas (nombreEmpresa )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO pedidos (fecha, nombreEmpresa, idFactura) VALUES 
(TIMESTAMP('2020-01-24 12:00:00'), 'Amazon', 1),
(TIMESTAMP('2020-06-30 10:00:00'), 'Correos de Mexico', 1),
(TIMESTAMP('2020-07-11 04:00:00'), 'DHL', 2),
(TIMESTAMP('2020-08-18 22:00:00'), 'UPS', 3),
(TIMESTAMP('2020-10-21 18:00:00'), 'FedEx', 4),
(TIMESTAMP('2020-11-06 12:00:00'), 'Amazon', 5);


disconnect;
