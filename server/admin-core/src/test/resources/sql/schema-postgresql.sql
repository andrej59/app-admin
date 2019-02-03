/*==============================================================*/
/* DBMS userName:      PostgreSQL 9.x                               */
/* Created on:     29.01.2018 0:24:30                           */
/*==============================================================*/

create SEQUENCE if not exists SEQ_USERS start with 1000;

/*==============================================================*/
/* Table: GROUPS                                                */
/*==============================================================*/
create table GROUPS (
   ID                   NUMERIC(12)          not null,
   NAME                 VARCHAR(128)         not null,
   IDENT                VARCHAR(32)          not null,
   constraint PK_GROUPS primary key (ID),
   constraint UK_GROUPS unique (IDENT)
);

comment on table GROUPS is
'Группы доступа';

comment on column GROUPS.ID is
'Идентификатор группы';

comment on column GROUPS.NAME is
'Наименование группы';

comment on column GROUPS.IDENT is
'Строковый идентификатор группы';

/*==============================================================*/
/* Table: GROUP_RIGHTS                                          */
/*==============================================================*/
create table GROUP_RIGHTS (
   GROUP_ID             NUMERIC(12)          not null,
   RIGHT_ID             NUMERIC(12)          not null,
   constraint PK_GROUP_RIGHTS primary key (GROUP_ID, RIGHT_ID)
);

comment on table GROUP_RIGHTS is
'Права группы';

comment on column GROUP_RIGHTS.GROUP_ID is
'Идентификатор группы';

comment on column GROUP_RIGHTS.RIGHT_ID is
'Идентификатор доступа';

/*==============================================================*/
/* Table: RIGHTS                                                */
/*==============================================================*/
create table RIGHTS (
   ID                   NUMERIC(12)          not null,
   NAME                 VARCHAR(128)         not null,
   IDENT                VARCHAR(64)          not null,
   constraint PK_RIGHTS primary key (ID),
   constraint UK_RIGHTS unique (IDENT)
);

comment on table RIGHTS is
'Права доступа';

comment on column RIGHTS.ID is
'Идентификатор доступа';

comment on column RIGHTS.NAME is
'Наименование доступа';

comment on column RIGHTS.IDENT is
'Строковый итентификатор';

/*==============================================================*/
/* Table: ROLES                                                 */
/*==============================================================*/
create table ROLES (
   ID                   NUMERIC(12)          not null,
   NAME                 VARCHAR(256)         not null,
   IDENT                VARCHAR(32)          not null,
   constraint PK_ROLES primary key (ID),
   constraint UK_ROLES unique (IDENT)
);

comment on table ROLES is
'Роли';

comment on column ROLES.ID is
'Идентификатор роли';

comment on column ROLES.NAME is
'Наименование роли';

comment on column ROLES.IDENT is
'Строковый идентификатор роли';

/*==============================================================*/
/* Table: ROLE_GROUPS                                           */
/*==============================================================*/
create table ROLE_GROUPS (
   ROLE_ID              NUMERIC(12)          not null,
   GROUP_ID             NUMERIC(12)          not null,
   constraint PK_ROLE_GROUPS primary key (ROLE_ID, GROUP_ID)
);

comment on table ROLE_GROUPS is
'Группы роли';

comment on column ROLE_GROUPS.ROLE_ID is
'Идентификатор роли';

comment on column ROLE_GROUPS.GROUP_ID is
'Идентификатор группы';

/*==============================================================*/
/* Table: USERS                                                 */
/*==============================================================*/
create table USERS (
   ID                   NUMERIC(12)          not null,
   NAME                 VARCHAR(32)          not null,
   PASSWORD             VARCHAR(64)          not null,
   SALT                 VARCHAR(32)          not null,
   EMAIL                VARCHAR(256)         null,
   ENABLED              NUMERIC(1)           not null default 0,
   DT_CREATE            TIMESTAMP            not null default CURRENT_TIMESTAMP,
   DT_UPDATE            TIMESTAMP            null,
   constraint PK_USERS primary key (ID),
   constraint UK_USERS unique (NAME)
);

comment on table USERS is
'Пользователи приложения';

comment on column USERS.ID is
'Идентификатор пользователя';

comment on column USERS.NAME is
'Имя пользователя';

comment on column USERS.PASSWORD is
'Пароль пользователя';

comment on column USERS.SALT is
'Соль для пользователя';

comment on column USERS.EMAIL is
'E-mail пользователя';

comment on column USERS.ENABLED is
'Флаг определяет доступность пользователя';

comment on column USERS.DT_CREATE is
'Дата и время создания пользователя';

comment on column USERS.DT_UPDATE is
'Дата и время обновления пользователя';

/*==============================================================*/
/* Table: USER_ACCOUNTS                                         */
/*==============================================================*/
create table USER_ACCOUNTS (
   ID                   NUMERIC(12)          not null,
   LAST_NAME            VARCHAR(256)         not null,
   FIRST_NAME           VARCHAR(256)         not null,
   MIDDLE_NAME          VARCHAR(256)         null,
   LOCKED               NUMERIC(1)           not null default 1,
   ACCOUNT_EXPIRED      NUMERIC(1)           not null default 1,
   CREDENTIAL_EXPIRED   NUMERIC(1)           not null default 1,
   DT_CREATE            TIMESTAMP            not null default CURRENT_TIMESTAMP,
   DT_UPDATE            TIMESTAMP            null,
   constraint PK_USER_ACCOUNTS primary key (ID)
);

comment on table USER_ACCOUNTS is
'Учётная запись пользователя';

comment on column USER_ACCOUNTS.ID is
'Идентификатор аккаунта';

comment on column USER_ACCOUNTS.LAST_NAME is
'Фамилия пользователя';

comment on column USER_ACCOUNTS.FIRST_NAME is
'Имя пользователя';

comment on column USER_ACCOUNTS.MIDDLE_NAME is
'Отчество пользователя';

comment on column USER_ACCOUNTS.LOCKED is
'Флаг блокировки пользователя';

comment on column USER_ACCOUNTS.ACCOUNT_EXPIRED is
'Флаг времени действия аккаунта';

comment on column USER_ACCOUNTS.CREDENTIAL_EXPIRED is
'Флаг времени действия привилегий пользователя';

comment on column USER_ACCOUNTS.DT_CREATE is
'Дата и время создания';

comment on column USER_ACCOUNTS.DT_UPDATE is
'Дата и время обновления';

/*==============================================================*/
/* Table: USER_ROLES                                            */
/*==============================================================*/
create table USER_ROLES (
   USER_ID              NUMERIC(12)          not null,
   ROLE_ID              NUMERIC(12)          not null,
   constraint PK_USER_ROLES primary key (USER_ID, ROLE_ID)
);

comment on table USER_ROLES is
'Роли пользователей';

comment on column USER_ROLES.USER_ID is
'Идентификатор пользователя';

comment on column USER_ROLES.ROLE_ID is
'Идентификатор роли';

alter table GROUP_RIGHTS
   add constraint FK_GROUP_RI_REFERENCE_GROUPS foreign key (GROUP_ID)
      references GROUPS (ID)
      on delete restrict on update restrict;

alter table GROUP_RIGHTS
   add constraint FK_GROUP_RI_REFERENCE_RIGHTS foreign key (RIGHT_ID)
      references RIGHTS (ID)
      on delete restrict on update restrict;

alter table ROLE_GROUPS
   add constraint FK_ROLE_GRO_REFERENCE_ROLES foreign key (ROLE_ID)
      references ROLES (ID)
      on delete restrict on update restrict;

alter table ROLE_GROUPS
   add constraint FK_ROLE_GRO_REFERENCE_GROUPS foreign key (GROUP_ID)
      references GROUPS (ID)
      on delete restrict on update restrict;

alter table USER_ACCOUNTS
   add constraint FK_USER_ACCOUNTS_USERS foreign key (ID)
      references USERS (ID)
      on delete cascade;

alter table USER_ROLES
   add constraint FK_USER_ROLELS_USERS foreign key (USER_ID)
      references USERS (ID)
      on delete cascade;

alter table USER_ROLES
   add constraint FK_USER_ROLES_ROLES foreign key (ROLE_ID)
      references ROLES (ID)
      on delete cascade;

