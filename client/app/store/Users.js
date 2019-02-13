/**
 * Created by Andrey Kharintsev on 03.02.2019.
 */
Ext.define('Admin.store.Users', {
  extend: 'Ext.data.Store',
  alias: 'store.users',
  model: 'Admin.model.User',
  data: [
    {
      id: 1,
      userName: 'admin',
      email: 'admin@mail.com',
      locked: false,
      createDate: '2019-02-12',
      lastLoginDate: '2019-02-12T21:30:05'
    },
    {
      id: 2,
      userName: 'user',
      email: 'user@mail.ru',
      locked: false,
      createDate: '2019-02-11',
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