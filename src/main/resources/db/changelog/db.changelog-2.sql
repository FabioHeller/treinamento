-- liquibase formatted sql

-- changeset fabio.heller:2.0 dbms:mysql
INSERT INTO `treinamento`.`company` (`document`, `name`, `site`, `vacancies`,`address_id`) VALUES
('123456789', 'Empresa 1', 'www.empresa1.com.br', '1', '1'),
('3215468789', 'Empresa 2', 'www.empresa2.com.br', '4', '2'),
('87454512135', 'Empresa 3', 'www.empresa3.com.br', '1', '3'),
('987512231', 'Empresa 4', 'www.empresa4.com.br', '5', '1'),
('231545689', 'Empresa 5', 'www.empresa5.com.br', '10', '2');


INSERT INTO `treinamento`.`user` (`name`, `document`, `age`, `login`, `password`, `company_id`, `salary`,`address_id`) VALUES
('Usuário 1','6544848956','20','user1','user1','1','2000.00', '1'),
('Usuário 2','54532454353','23','user2','user2','2','2430.10', '2'),
('Usuário 3','12421342134','54','user3','user3','5','5000.00', '3'),
('Usuário 4','2312342423','32','user4','user4','4','4030.80', '1'),
('Usuário 5','656346431','33','user5','user5','5','5340.50', '2'),
('Usuário 6','9876202838','43','user6','user6','5','6030.00', '3'),
('Usuário 7','9876534567','52','user7','user7','2','1570.44', '1'),
('Usuário 8','2356343234','18','user8','user8','3','5630.05', '2'),
('Usuário 9','2343675434','23','user9','user9','5','4543.50', '3'),
('Usuário 10','2145566576','32','user10','user10','2','6216.10', '1'),
('Usuário 11','8799898789','53','user11','user11','5','4805.00', '2'),
('Usuário 12','78974654632','25','user12','user12','5','7582.00', '3'),
('Usuário 13','6568655453','45','user13','user13','2','5820.40', '1'),
('Usuário 14','53456798726','29','user14','user14','5','2850.97', '2');


INSERT INTO `treinamento`.`address` (`city`, `country`, `district`, `number`, `street`, `zip_code`) VALUES
('Belo Horizonte', 'Brasil', 'Minas Gerais', '12', 'Afonso Pena1', '30260301'),
('Betim', 'Brasil', 'Minas Gerais', '123', 'Afonso Pena1', '30260302'),
('Contagem', 'Brasil', 'Minas Gerais', '1234', 'Afonso Pena1', '30260303');


