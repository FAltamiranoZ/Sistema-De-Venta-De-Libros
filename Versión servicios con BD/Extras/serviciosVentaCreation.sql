connect 'jdbc:derby://localhost:1527/serviciosVenta;user=app;password=app';


DROP TABLE pedidos;
DROP TABLE facturas;
DROP TABLE clientes;
DROP TABLE productos;


------------------------------- 
--     CLIENTES
-------------------------------

CREATE  TABLE  clientes
(
  idCliente VARCHAR(100) NOT NULL ,
  nombreCliente VARCHAR(100) NOT NULL ,
  saldo FLOAT NOT NULL ,
  PRIMARY KEY (idCliente)
);

INSERT INTO clientes (idCliente, nombreCliente, saldo) VALUES 
('1', 'Jose Francisco Altamirano Zevallos', 1000),
('2', 'Sebastian Valderrabano Cabrera', 1000),
('3', 'Fernando Merino Benitez', 1000),
('4', 'America Castrejon Porres', 1000),
('5', 'Rodrigo Castillo Gomez', 1000),
('6', 'Eduardo Daniel Urrutia Ruiz', 1000);


------------------------------- 
--     PRODUCTOS
-------------------------------

CREATE  TABLE  productos
(
  ISBN VARCHAR(100) NOT NULL ,
  nombreLibro VARCHAR(100) NOT NULL ,
  unidades INT NOT NULL ,
  PRIMARY KEY (ISBN)
);

INSERT INTO productos (ISBN, nombreLibro, unidades) VALUES 
('978-0-00-000000-0', 'La comunidad del anillo', 10),
('978-0-00-000000-1', 'Las dos torres', 20),
('978-0-00-000000-2', 'El retorno del rey', 30);


------------------------------- 
--     FACTURAS
-------------------------------

CREATE  TABLE facturas
 (
  idFactura VARCHAR(100) NOT NULL ,
  idCliente VARCHAR(100) NOT NULL ,
  cuantia FLOAT NOT NULL ,
  PRIMARY KEY (idFactura),
  CONSTRAINT fk_idCliente
    FOREIGN KEY (idCliente )
    REFERENCES clientes (idCliente )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO facturas (idFactura, idCliente, cuantia) VALUES 
('1', '1', 100),
('2', '1', 800),
('3', '2', 400),
('4', '4', 420.69),
('5', '3', 11.11);


------------------------------- 
--     PEDIDOS
-------------------------------

CREATE  TABLE pedidos
 (
  idPedido VARCHAR(100) NOT NULL ,
  fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  nombreEmpresa VARCHAR(100)  NOT NULL ,
  PRIMARY KEY (idPedido)
);

INSERT INTO pedidos (idPedido, fecha, nombreEmpresa) VALUES 
('1', TIMESTAMP('2020-01-24 12:00:00'), 'Amazon'),
('2', TIMESTAMP('2020-06-30 10:00:00'), 'Correos de Mexico'),
('3', TIMESTAMP('2020-07-11 04:00:00'), 'DHL'),
('4', TIMESTAMP('2020-08-18 22:00:00'), 'UPS'),
('5', TIMESTAMP('2020-10-21 18:00:00'), 'FedEx');


disconnect;
