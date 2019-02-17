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
      fio: 'Иванов Иван Иванович',
      email: 'admin@mail.com',
      locked: false,
      createDate: '2019-02-12',
      lastLoginDate: '2019-02-12T21:30:05'
    },
    {
      id: 2,
      userName: 'user',
      fio: 'Петров Иван',
      email: 'user@mail.ru',
      locked: false,
      createDate: '2019-02-11',
      lastLoginDate: null
    },
    {
      id: 3,
      userName: 'guest',
      fio: 'Гость',
      email: 'guest@mail.ru',
      locked: true,
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