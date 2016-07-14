# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table partie (
  pid                       bigint not null,
  heimmannschaft_name       varchar(255),
  gastmannschaft_name       varchar(255),
  partie_datum              date,
  constraint pk_partie primary key (pid))
;

create table stadion (
  sid                       bigint not null,
  name                      varchar(255),
  addresse                  varchar(255),
  anzahl_sitzplaetze        integer,
  anzahl_zugaenge           integer,
  sponsor                   varchar(255),
  constraint pk_stadion primary key (sid))
;


create table stadion_partie (
  stadion_sid                    bigint not null,
  partie_pid                     bigint not null,
  constraint pk_stadion_partie primary key (stadion_sid, partie_pid))
;
create sequence partie_seq;

create sequence stadion_seq;




alter table stadion_partie add constraint fk_stadion_partie_stadion_01 foreign key (stadion_sid) references stadion (sid) on delete restrict on update restrict;

alter table stadion_partie add constraint fk_stadion_partie_partie_02 foreign key (partie_pid) references partie (pid) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists partie;

drop table if exists stadion;

drop table if exists stadion_partie;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists partie_seq;

drop sequence if exists stadion_seq;

