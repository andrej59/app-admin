Ext.define('Admin.view.users.Users', {
  extend: 'Ext.grid.Panel',
  xtype: 'userList',

  requires: [
    'Admin.view.users.UsersController',
    'Admin.model.User',
    'Ext.grid.column.Date'
  ],

  controller: 'users',
  title: 'Пользователи',

  viewModel: {
    type: 'users'
  },

  bind: '{usersData}',

  columns: [
    {text: 'Имя пользователя', dataIndex: 'userName'},
    {text: 'Email', dataIndex: 'email', flex: 1},
    {text: 'Блокировка', dataIndex: 'locked', flex: 1},
    {text: 'Дата создания', dataIndex: 'createDate', flex: 1},
    {text: 'Время последнего входа', dataIndex: 'lastLoginDate', flex: 1}
  ],

  listeners: {
    select: 'onItemSelected'
  }
});
