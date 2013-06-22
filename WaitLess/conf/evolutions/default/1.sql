# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table fila (
  id_fila                   integer not null,
  data_criacao              timestamp,
  data_atendimento          timestamp,
  senha                     varchar(255),
  constraint pk_fila primary key (id_fila))
;

create table tp_fila (
  tp_fila                   integer,
  ds_fila                   varchar(255))
;

create table usuario (
  id                        bigint,
  nome                      varchar(255),
  senha                     varchar(255))
;

create sequence fila_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists fila;

drop table if exists tp_fila;

drop table if exists usuario;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists fila_seq;

