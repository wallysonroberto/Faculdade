create table setor(
  id integer not null primary key,
  setor varchar(20) not null
);

create table funcion(
  id integer not null primary key,
  nome varchar(10),
  salario numeric(15,2),
  id_setor integer,
  foreign key (id_setor) references setor(id) on delete cascade
);

create table cliente(
  id integer not null primary key,
  nome varchar(10),
  sobrenome varchar(10),
  tipo_log varchar(5),
  logradouro varchar(20),
  numero varchar(5),
  municipio varchar(20),
  uf char(2),
  cep varchar(10)
);

create table pedido(
  id integer not null primary key,
  dt_pedido date not null,
  valor numeric(15,2) not null,
  id_cliente integer not null,
  id_funcion integer,
  foreign key(id_cliente) references cliente(id) on delete cascade,
  foreign key(id_funcion) references funcion(id) on delete set null
);

create table fone(
  id integer not null primary key,
  fone varchar(16),
  id_cliente integer not null,
  foreign key(id_cliente) references cliente(id) on delete cascade
);


insert into setor (id, setor)
values (1, 'Desenvolvedor');

insert into setor (id, setor)
values (2, 'Manutencao');

insert into setor (id, setor)
values (3, 'Financeiro');

insert into setor (id, setor)
values (4, 'Venda');

insert into setor (id, setor)
values (5, 'RH');

insert into funcion (id, nome, salario, id_setor)
values (1, 'Tadeu', 1500, 1);

insert into funcion (id, nome, salario, id_setor)
values (2, 'Ylane', 1200, 2);

insert into funcion (id, nome, salario, id_setor)
values (3, 'Julian', 1000, 1);

insert into funcion (id, nome, salario, id_setor)
values (4, 'Ewerton', 1000, 1);

insert into funcion (id, nome, salario, id_setor)
values (5, 'Joao', 800, 2);

insert into funcion (id, nome, salario, id_setor)
values (6, 'Celestino', 1500, 3);

insert into funcion (id, nome, salario)
values (7, 'Maria', 500);

insert into funcion (id, nome, salario, id_setor)
values (8, 'Joana', 1000, 4);

insert into funcion (id, nome, salario, id_setor)
values (9, 'Fernanda', 1000, 4);

insert into cliente (id, nome, sobrenome)
values (1, 'Francisco', 'Silva');

insert into cliente (id, nome, sobrenome)
values (2, 'Jose', 'Lima');

insert into cliente (id, nome, sobrenome)
values (3, 'Maria', 'Silva');

insert into cliente (id, nome, sobrenome)
values (4, 'Adriana', 'Ferreira');

insert into cliente (id, nome, sobrenome)
values (5, 'Joao', 'Oliveira');

insert into cliente (id, nome, sobrenome)
values (6, 'Eduardo', 'Souza');

insert into pedido (id, dt_pedido, valor, id_cliente, id_funcion)
values (1, '2011-01-01', 1000, 2, 1);

insert into pedido (id, dt_pedido, valor, id_cliente, id_funcion)
values (2, '2011-02-02', 2000, 4, 3);

insert into pedido (id, dt_pedido, valor, id_cliente, id_funcion)
values (3, '2011-03-03', 1500, 2, 6);

insert into pedido (id, dt_pedido, valor, id_cliente, id_funcion)
values (4, '2011-04-04', 2500, 5, 1);

insert into pedido (id, dt_pedido, valor, id_cliente)
values (5, '2011-05-05', 1000, 2);

insert into fone (id, id_cliente, fone)
values (1, 1, '1111-1111');

insert into fone (id, id_cliente, fone)
values (2, 1, '1111-2222');

insert into fone (id, id_cliente, fone)
values (3, 2, '2222-2222');

insert into fone (id, id_cliente, fone)
values (4, 5, '5555-4444');
