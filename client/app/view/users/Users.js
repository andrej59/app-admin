Ext.define('Admin.view.users.Users', {
  extend: 'Ext.grid.Panel',
  xtype: 'userList',

  requires: [
    'Admin.view.users.UsersController',
    'Admin.view.users.UsersModel'
  ],

  controller: 'users-users',
  title: 'Пользователи',

  viewModel: {
    type: 'users'
  },

  columns: [
    {text: 'Имя пользователя', dataIndex: 'name'},
    {text: 'Email', dataIndex: 'email', flex: 1},
    {text: 'Блокировка', dataIndex: 'locked', flex: 1},
    {text: 'Дата создания', dataIndex: 'createDate', flex: 1},
    {text: 'Время последнего входа', dataIndex: 'lastLoginDate', flex: 1}
  ],

  listeners: {
    select: 'onItemSelected'
  }
});
