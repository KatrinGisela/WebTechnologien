# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ingredient (
  iid                       bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_ingredient primary key (iid))
;

create table recipe (
  rid                       bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_recipe primary key (rid))
;


create table recipe_ingredient (
  recipe_rid                     bigint not null,
  ingredient_iid                 bigint not null,
  constraint pk_recipe_ingredient primary key (recipe_rid, ingredient_iid))
;
create sequence ingredient_seq;

create sequence recipe_seq;




alter table recipe_ingredient add constraint fk_recipe_ingredient_recipe_01 foreign key (recipe_rid) references recipe (rid) on delete restrict on update restrict;

alter table recipe_ingredient add constraint fk_recipe_ingredient_ingredie_02 foreign key (ingredient_iid) references ingredient (iid) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists ingredient;

drop table if exists recipe_ingredient;

drop table if exists recipe;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists ingredient_seq;

drop sequence if exists recipe_seq;

