INSERT INTO occupational (code,uuid, type, description, create_at , user_at)
VALUES
 ('MC01','2f04150e-c6b3-4ede-900f-f803a2039456','MEDICO', 'Cardiologia', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MC02','ec019059-83b3-4bce-b812-171e8f7db36b','MEDICO','Clinico Geral', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MD03','1f9336be-e17e-48af-a607-9066b16c7492','MEDICO', 'Dermatologia', '2022-08-26 00:00:00', 'tiagobrito'),
 ('ME04','9b715541-967a-4e79-9c10-c1b0d334a6bd','MEDICO', 'Enfermagem', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MP05','38da7543-a8a1-45cc-b1c7-fe6845bdd08e','MEDICO', 'Pediatria', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MT06','7f2dd0f6-cb71-43ef-82e8-1168511340a0','MEDICO', 'Terapia Ocupacional', '2022-08-26 00:00:00', 'tiagobrito'),
 ('MU07','b5b520fd-5f17-463c-b95b-f1ffd213256a','MEDICO', 'Urologia', '2022-08-26 00:00:00', 'tiagobrito'),
 ('OE08','4bbe9ca2-dd69-40f0-a015-54f4fe056067','ODONTO', 'Endodontia', '2022-08-26 00:00:00', 'tiagobrito'),
 ('OE09','9dc52c0b-61fc-41b3-8c61-67b84c2074a3','ODONTO', 'Implantes', '2022-08-26 00:00:00', 'tiagobrito'),
 ('OE010','a2d945d5-0858-4a43-a2b4-f0f770bb2b41','ODONTO', 'Ordontia', '2022-08-26 00:00:00', 'tiagobrito');

INSERT INTO `customer`
    VALUES
        (1,'beb6275a-0916-433b-8a00-9b3758e3aa01','74429759000120','PJ','Beneficência Camiliana','ACTIVE','2022-09-06 20:53:00','2022-09-06 20:58:24','SYSTEM'),
        (2,'d0a4f0f4-b44d-4532-9150-9ef13b57d4e1','00061997048','PF','João da Silva','ACTIVE','2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM'),
        (3,'3f1da52c-704e-4146-b479-2a960ac8ffce','51832252060','PF','Ana Ferreira Santos','ACTIVE','2022-09-06 20:57:45','2022-09-06 20:57:45','SYSTEM'),
        (4,'e7eb8a40-2c9c-4811-a70d-5e1046258857','77360868000127','PJ','Hospital São Paulo','ACTIVE','2022-09-06 20:53:00','2022-09-06 20:58:24','SYSTEM'),
        (5,'23158bb9-52e0-4e27-82b9-5eeecda97e05','78038646000155','PJ','Hospital Universitário – University','ACTIVE','2022-09-06 20:53:00','2022-09-06 20:58:24','SYSTEM');

INSERT INTO `address`
    VALUES
        (1,'91d248df-119e-4489-b008-4be39f9be76b','06709-150','Avenida São Camilo',1363,NULL,'Granja Viana','BRASIL','SP','Cotia','2022-09-06 20:53:00','2022-09-06 20:53:00','SYSTEM','ACTIVE',1),
        (2,'5aaf954b-02f2-4646-9a07-e00533a2e670','05317-020','Av. Manuel Bandeira',291,'Bloco A','Vila Leopoldina','BRASIL','SP','São Paulo','2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM','ACTIVE',2),
        (3,'fe0f6577-da40-4b69-b1e6-1654b306d029','06420-130','Av. Henrique Gonçalves Baptista',1907,'Bloco A','Vila Iracema','BRASIL','SP','Barueri','2022-09-06 20:57:45','2022-09-06 20:57:45','SYSTEM','ACTIVE',3),
        (4,'5df829e9-3431-41e3-8e08-23fbe0d64021','04024-002','R. Napoleão de Barros',715,'Bloco B','Vila Clementino','BRASIL','SP','São Paulo','2022-09-06 20:57:45','2022-09-06 20:57:45','SYSTEM','ACTIVE',4),
        (5,'3a9e4a86-2192-4b92-84a2-6956cb429d7f','05508-000','Av. Prof. Lineu Prestes',2565,'Bloco A','Butantã','BRASIL','SP','São Paulo','2022-09-06 20:57:45','2022-09-06 20:57:45','SYSTEM','ACTIVE',5);

INSERT INTO `email`
    VALUES
        (1,'0df202c2-217f-4955-a294-dddd69cdb9a1','atendimento@bencamiliana.com.br','COMERCIAL',1,'ACTIVE','2022-09-06 20:53:00','2022-09-06 20:53:00','SYSTEM'),
        (2,'d995e846-c9f5-409d-98c5-3cf12ec63e01','joaosilva03@gmail.com','PESSOAL',2,'ACTIVE','2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM'),
        (3,'e8e109a3-1df7-4917-a8ec-7cffc03992d9','anaferreira@gmail.com','PESSOAL',3,'ACTIVE','2022-09-06 20:57:45','2022-09-06 20:57:45','SYSTEM'),
        (4,'bd42ad59-18ba-4bfe-935d-dff4c158b753','hosptila5@gmail.com','COMERCIAL',4,'ACTIVE','2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM'),
        (5,'255305f5-5f65-4ce1-b5ed-4576a0dbd4b4','hosptila2@gmail.com','COMERCIAL',5,'ACTIVE','2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM');

INSERT INTO `phone`
    VALUES
        (1,'4434ff64-7604-4643-9ef6-db35b2f56768','11','+55','46176966','COMERCIAL',1,'2022-09-06 20:53:00','2022-09-06 20:53:00','SYSTEM','ACTIVE'),
        (2,'65548b49-2e01-4da9-860f-4482a59d7109','11','+55','924242524','PESSOAL',2,'2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM','ACTIVE'),
        (3,'f2590f61-2dc1-4479-897c-734589b0473c','11','+55','987762323','PESSOAL',3,'2022-09-06 20:57:45','2022-09-06 20:57:45','SYSTEM','ACTIVE'),
        (4,'6e059fe6-0f3b-4cec-ba49-6136326a39b1','11','+55','924242529','COMERCIAL',4,'2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM','ACTIVE'),
        (5,'fd9ad83d-6750-4c16-86bc-3702cef3b658','11','+55','924242526','COMERCIAL',5,'2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM','ACTIVE');

INSERT INTO `provider`
    VALUES
        (1,'fc63cdcb-229a-476b-bc05-20a9e3062028','SISA1662508665033-8','2000-09-06','2022-09-06 20:57:45','2022-09-06 20:57:45','SYSTEM','ACTIVE',3,1);


INSERT INTO `associate`
    VALUES
        (1,'370efbec-72e2-4490-ac84-9c3bae67bed5','SISA_PF1662508498567-6','5b8ba651-29f8-40d1-86ef-6bf5921fc016','26149404021','OWNER','2000-09-06','2022-09-06 20:54:59','2022-09-06 20:54:59','SYSTEM','ACTIVE',null,2);

INSERT INTO `partner`
    VALUES
        (1,'5fc5c63d-9ffb-4544-9eb8-bb567cc304bb','Beneficência Camiliana',NULL,'SISA_PJ1662508380011-1','2022-09-06 20:58:24','2022-09-06 20:53:00','SYSTEM','ACTIVE',1),
        (2,'2e47ca30-a1a8-41ad-94d3-f445338ed358','Hospital São Paulo','https://www.hu.usp.br/','SISA_PJ1662508380011-3','2022-09-06 20:58:24','2022-09-06 20:53:00','SYSTEM','ACTIVE',4),
        (3,'3d64df50-e9aa-4e18-84c7-3b05238a2ae5','Hospital Universitario','http://www.hospitalsaopaulo.org.br/','SISA_PJ1662508380011-4','2022-09-06 20:58:24','2022-09-06 20:53:00','SYSTEM','ACTIVE',5);

INSERT INTO `provider_occupational`
    VALUES
        (1,1);
INSERT INTO `provider_partner`
    VALUES
        (1,1),
        (1,2);
