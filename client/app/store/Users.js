/**
 * Created by Андрей on 03.02.2019.
 */
Ext.define('Admin.store.Users', {
  extend: 'Ext.data.Store',
  alias: 'store.users',
  model: 'Admin.model.User',
  data: [
    {
      userName: 'admin',
      email: 'admin@mail.com',
      locked: false,
      createDate: null,
      lastLoginDate: null
    },
    {
      userName: 'user',
      email: 'user@mail.ru',
      locked: false,
      createDate: null,
      lastLoginDate: null
    }
  ],

  proxy: {
    type: 'memory',
    reader: {
      type: 'json'
    }
  }
});