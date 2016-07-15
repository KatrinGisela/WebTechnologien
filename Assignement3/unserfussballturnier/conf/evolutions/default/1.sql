# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table partie (
  pid                       bigint not null,
  heimmannschaft_name       varchar(255),
  gastmannschaft_name       varchar(255),
  partie_datum              date,
  stadion_sid               bigint,
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

create sequence partie_seq;

create sequence stadion_seq;

alter table partie add constraint fk_partie_stadion_1 foreign key (stadion_sid) references stadion (sid) on delete restrict on update restrict;
create index ix_partie_stadion_1 on partie (stadion_sid);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists partie;

drop table if exists stadion;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists partie_seq;

drop sequence if exists stadion_seq;

