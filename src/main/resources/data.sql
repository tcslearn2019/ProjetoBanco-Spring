INSERT INTO USER (CPF, EMAIL, FNAME, LNAME, PWD, TEL, RG) VALUES ('159','Guilherme@gmail.com','Guilherme','Nakahata','123456','159', '123')
INSERT INTO USER (CPF, EMAIL, FNAME, LNAME, PWD, TEL, RG) VALUES ('951','Glauco@gmail.com','Glauco','Junior','123','951', '123')
INSERT INTO USER (CPF, EMAIL, FNAME, LNAME, PWD, TEL, RG) VALUES ('123','Carol@gmail.com','Carol','Filha','123321','123', '123')
INSERT INTO USER (CPF, EMAIL, FNAME, LNAME, PWD, TEL, RG) VALUES ('456','Jhony@gmail.com','Jhony','Filho','159','456', '123')
INSERT INTO CONTA (AGENCIA, CONTA, SALDO, IDUSER) VALUES (4570,159951,1000,1)
INSERT INTO CONTA (AGENCIA, CONTA, SALDO, IDUSER) VALUES (4570,123321,0,2)
INSERT INTO CONTA (AGENCIA, CONTA, SALDO, IDUSER) VALUES (4570,123456,900,3)
INSERT INTO CONTA (AGENCIA, CONTA, SALDO, IDUSER) VALUES (4570,654321,9000,4)
INSERT INTO TIPO_INVESTIMENTO ( JUROS, NOME) VALUES (2.57,'Poupança')
INSERT INTO TIPO_INVESTIMENTO ( JUROS, NOME) VALUES (3.11,'CDI')
INSERT INTO TIPO_INVESTIMENTO ( JUROS, NOME) VALUES (8.99,'IPCA')
INSERT INTO EMPRESTIMO(DATA_EMPRESTIMO,DATA_PAGAMENTO, JUROS, PAGO, VALOR_EMPRESTIMO,VALOR_PAGAR,IDUSER) VALUES (NOW(),NULL,2.75,false,5000,5000,1)
INSERT INTO EMPRESTIMO(DATA_EMPRESTIMO,DATA_PAGAMENTO, JUROS, PAGO, VALOR_EMPRESTIMO,VALOR_PAGAR,IDUSER) VALUES (NOW(),NULL,2.75,false,100,100,1)
INSERT INTO EMPRESTIMO(DATA_EMPRESTIMO,DATA_PAGAMENTO, JUROS, PAGO, VALOR_EMPRESTIMO,VALOR_PAGAR,IDUSER) VALUES (NOW(),NULL,2.75,false,398.85,398,1)
INSERT INTO EMPRESTIMO(DATA_EMPRESTIMO,DATA_PAGAMENTO, JUROS, PAGO, VALOR_EMPRESTIMO,VALOR_PAGAR,IDUSER) VALUES (NOW(),NULL,2.75,false,999.999,999.999,1)

