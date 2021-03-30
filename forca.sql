SET @@global.time_zone = '+3:00';

create database forcaII;

use forcaII;

create table palavras(
	id int not null auto_increment primary key,
    nome varchar(32) unique not null
);