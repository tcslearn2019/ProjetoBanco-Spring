INSERT INTO USER (ADMINISTRADOR, CPF, EMAIL, FNAME, LNAME, PWD, TEL, RG) VALUES (false,'98765432198','Guilherme@gmail.com','Guilherme','Nakahata','654321','159', '123')
INSERT INTO USER (ADMINISTRADOR, CPF, EMAIL, FNAME, LNAME, PWD, TEL, RG) VALUES (false,'12345612345','Glauco@gmail.com','Glauco','Junior','1234567','951', '123')
INSERT INTO USER (ADMINISTRADOR, CPF, EMAIL, FNAME, LNAME, PWD, TEL, RG) VALUES (false,'12345678912','Carol@gmail.com','Carol','Correa','123321','123', '123')
INSERT INTO USER (ADMINISTRADOR, CPF, EMAIL, FNAME, LNAME, PWD, TEL, RG) VALUES (true,'98765432112','Jhony@gmail.com','Jhony','Filho','159159','456', '123')
INSERT INTO CONTA (AGENCIA, CONTA, SALDO, IDUSER) VALUES (4570,159951,1000,1)
INSERT INTO CONTA (AGENCIA, CONTA, SALDO, IDUSER) VALUES (4570,123321,0,2)
INSERT INTO CONTA (AGENCIA, CONTA, SALDO, IDUSER) VALUES (4570,123456,900,3)
INSERT INTO CONTA (AGENCIA, CONTA, SALDO, IDUSER) VALUES (4570,654321,9000,4)
INSERT INTO TIPO_INVESTIMENTO ( JUROS, NOME) VALUES (2.57,'Poupança')
INSERT INTO TIPO_INVESTIMENTO ( JUROS, NOME) VALUES (3.11,'CDI')
INSERT INTO TIPO_INVESTIMENTO ( JUROS, NOME) VALUES (8.99,'IPCA')
INSERT INTO INVESTIMENTO ( DATA, ATIVO, VALOR, VALOR_TEMP,IDCONTA,ID_TIP_INV) VALUES (NOW(), true, 100,100,1,1)
INSERT INTO INVESTIMENTO ( DATA, ATIVO, VALOR, VALOR_TEMP,IDCONTA,ID_TIP_INV) VALUES (NOW(), false, 300,300,1,1)
INSERT INTO INVESTIMENTO ( DATA, ATIVO, VALOR, VALOR_TEMP,IDCONTA,ID_TIP_INV) VALUES (NOW(), true, 100,100,2,1)
INSERT INTO INVESTIMENTO ( DATA, ATIVO, VALOR, VALOR_TEMP,IDCONTA,ID_TIP_INV) VALUES (NOW(),true, 100,100,4,3)
INSERT INTO EMPRESTIMO(DATA_EMPRESTIMO,DATA_PAGAMENTO, JUROS, PAGO, VALOR_EMPRESTIMO,VALOR_PAGAR,IDUSER) VALUES (NOW(),NULL,2.75,false,5000,5000,1)
INSERT INTO EMPRESTIMO(DATA_EMPRESTIMO,DATA_PAGAMENTO, JUROS, PAGO, VALOR_EMPRESTIMO,VALOR_PAGAR,IDUSER) VALUES (NOW(),NULL,2.75,false,100,100,1)
INSERT INTO EMPRESTIMO(DATA_EMPRESTIMO,DATA_PAGAMENTO, JUROS, PAGO, VALOR_EMPRESTIMO,VALOR_PAGAR,IDUSER) VALUES (NOW(),NULL,2.75,false,398.85,398,1)
INSERT INTO EMPRESTIMO(DATA_EMPRESTIMO,DATA_PAGAMENTO, JUROS, PAGO, VALOR_EMPRESTIMO,VALOR_PAGAR,IDUSER) VALUES (NOW(),NULL,2.75,false,999.999,999.999,1)

