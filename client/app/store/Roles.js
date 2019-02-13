/**
 * Created by Андрей on 11.02.2019.
 */
Ext.define('Admin.store.Roles', {
  extend: 'Ext.data.Store',
  alias: 'store.roles',
  model: 'Admin.model.Role',
  data: [
    {
      id: 1,
      name: 'Администратор',
      code: 'ROLE_ADMIN'
    },
    {
      id: 2,
      name: 'Пользователь',
      code: 'ROLE_USER'
    }
  ],

  proxy: {
    type: 'memory',
    reader: {
      type: 'json'
    }
  }
});