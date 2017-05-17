drop database myWiki;
create database myWiki;
use myWiki;

create table user (
  name varchar(80),
  nameUsu varchar(30) primary key unique not null,
  email varchar(100) unique not null,
  location varchar(100),
  bio text,
  pass varchar(20) not null
);

create table entry(
	id int primary key auto_increment,
    language varchar(30) not null,
    title varchar(100) not null,
    code text not null,
    usu varchar(30) not null,
    Foreign key (usu) References user(nameUsu) on delete cascade
);

create table answer(
	id int primary key auto_increment,
    text_answer text not null,
    usu varchar(30) not null,
    id_entry int not null,
    Foreign key (usu) References user(nameUsu) on delete cascade,
    Foreign key (id_entry) References entry(id) on delete cascade
);
create table voteEntry(
    usu varchar(30) not null,
    id_entry int not null,
    fecha datetime,
    Primary key(usu, id_entry),
    Foreign key (usu) References user(nameUsu) on delete cascade,
    Foreign key (id_entry) References entry(id) on delete cascade
);
create table follow(
	usu_follow varchar(30) not null,
    usu_follower varchar(30) not null,
    fecha datetime,
    Primary key(usu_follow, usu_follower),
    Foreign key (usu_follow) References user(nameUsu) on delete cascade,
    Foreign key (usu_follower) References user(nameUsu) on delete cascade
);
