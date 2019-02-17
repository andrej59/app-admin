/**
 * Created by Andrey Kharintsev on 17.02.2019.
 */
Ext.define('Admin.store.UserRoles', {
  extend: 'Ext.data.Store',
  alias: 'store.userRoles',
  model: 'Admin.model.UserRole',
  data: [
    //Администратор
    {
      userId: 1,
      roleId: 1,
      name: 'Администратор',
      code: 'ROLE_ADMIN',
      granted: true
    },
    {
      userId: 1,
      roleId: 2,
      name: 'Пользователь',
      code: 'ROLE_USER',
      granted: true
    },
    {
      userId: 1,
      roleId: 3,
      name: 'Гость',
      code: 'ROLE_GUEST',
      granted: true
    },
    //Пользователь
    {
      userId: 2,
      roleId: 1,
      name: 'Администратор',
      code: 'ROLE_ADMIN',
      granted: false
    },
    {
      userId: 2,
      roleId: 2,
      name: 'Пользователь',
      code: 'ROLE_USER',
      granted: true
    },
    {
      userId: 2,
      roleId: 3,
      name: 'Гость',
      code: 'ROLE_GUEST',
      granted: true
    },
    //Гость
    {
      userId: 3,
      roleId: 1,
      name: 'Администратор',
      code: 'ROLE_ADMIN',
      granted: false
    },
    {
      userId: 3,
      roleId: 2,
      name: 'Пользователь',
      code: 'ROLE_USER',
      granted: false
    },
    {
      userId: 3,
      roleId: 3,
      name: 'Гость',
      code: 'ROLE_GUEST',
      granted: true
    }
  ],

  proxy: {
    type: 'memory',
    reader: {
      type: 'json'
    }
  }
});