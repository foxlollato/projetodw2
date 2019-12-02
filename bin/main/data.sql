delete from usuarios;
insert into usuarios (id, username, password, nome, email) values ('user', '54321', 'Usuario Cliente', 'cliente1@ifsp.com.br');
insert into usuarios (id, username, password, nome, email) values ('admin', 'edcba54321', 'Usuario Admin', 'admin1@ifsp.com.br');
insert into usuarios (id, username, password, nome, email) values ('instalador', 'edcba', 'Usuario Instalador', 'instalador1@ifsp.com.br');

delete from papeis;
insert into papeis (usuario_id, papel) values (1, 'ROLE_USER');
insert into papeis (usuario_id, papel) values (2, 'ROLE_USER');
insert into papeis (usuario_id, papel) values (2, 'ROLE_ADMIN');
insert into papeis (usuario_id, papel) values (3, 'ROLE_INSTALADOR');