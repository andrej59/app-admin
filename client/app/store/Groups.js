/**
 * Created by Андрей on 12.02.2019.
 */
Ext.define('Admin.store.Groups', {
  extend: 'Ext.data.Store',
  alias: 'store.groups',
  model: 'Admin.model.Group',

  data: [
    {
      id: 1,
      name: 'Группа администратора'
    },
    {
      id: 2,
      name: 'Группа пользователей'
    }
  ],

  proxy: {
    type: 'memory',
    reader: {
      type: 'json'
    }
  }
});