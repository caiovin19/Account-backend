
CREATE TABLE conta
(
    id_conta IDENTITY NOT NULL PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);


CREATE TABLE transferencia
(
    id IDENTITY NOT NULL PRIMARY KEY,
    data_transferencia TIMESTAMP WITH TIME ZONE NOT NULL,
    valor NUMERIC (20,2) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    nome_operador_transacao VARCHAR (50),
    conta_id INT NOT NULL,

        CONSTRAINT FK_CONTA
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);

 CREATE TABLE tb_conta_transferencia
 ( id_conta INT,
   conta_id INT
 ); ALTER TABLE tb_conta_transferencia ADD FOREIGN KEY (id_conta) REFERENCES conta(id_conta);
 ALTER TABLE tb_conta_transferencia ADD FOREIGN KEY (conta_id) REFERENCES transferencia(id);

INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (3,'Caio');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (4,'Ferreira');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (5,'Alexandre');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (6,'Matheus');

INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', null, 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', null,1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2022-05-20 12:12:04+03',12.24,'DEPOSITO', 'Ronnyscley',4);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8,'2021-03-19 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',5);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9,'2020-11-20 12:12:04+03',30895.46,'DEPOSITO', 'Ronnyscley',6);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',5);

INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (1,1);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (2,2);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (1,3);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (2,4);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (1,5);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (2,6);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (3,6);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (4,7);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (5,8);
INSERT INTO tb_conta_transferencia (id_conta, conta_id) VALUES (6,9);
