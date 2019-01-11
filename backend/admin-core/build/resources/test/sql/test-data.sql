/*==============================================================*/
/* Table: USERS                                                 */
/*==============================================================*/
INSERT INTO users (id, name, password, salt, email, enabled, dt_create, dt_update) VALUES (1, 'admin', 123, 123, 'admin@mail.ru', 1, CURRENT_DATE, CURRENT_DATE);
INSERT INTO users (id, name, password, salt, email, enabled, dt_create, dt_update) VALUES (2, 'user', 123, 123, 'user@mail.ru', 1, CURRENT_DATE, CURRENT_DATE);
INSERT INTO users (id, name, password, salt, email, enabled, dt_create, dt_update) VALUES (3, 'developer', 123, 123, 'developer@mail.ru', 1, CURRENT_DATE, CURRENT_DATE);
/*==============================================================*/
/* Table: ROLES                                                 */
/*==============================================================*/
INSERT INTO roles (id, name, ident) VALUES (4, 'Администратор', 'admin');
INSERT INTO roles (id, name, ident) VALUES (5, 'Пользователь', 'user');
INSERT INTO roles (id, name, ident) VALUES (6, 'Разработчик', 'developer');
/*==============================================================*/
/* Table: USER_ROLES                                            */
/*==============================================================*/
INSERT INTO user_roles (user_id, role_id) VALUES (1, 4);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 5);
--INSERT INTO user_roles (user_id, role_id) VALUES (3, 6);