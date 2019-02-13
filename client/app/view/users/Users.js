/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.view.users.Users', {
  extend: 'Ext.grid.Panel',
  xtype: 'userList',

  requires: [
    'Admin.view.users.UsersController',
    'Admin.model.User',
    'Ext.grid.column.Date'
  ],

  title: 'Пользователи',

  controller: 'users',

  viewModel: {
    type: 'users'
  },

  bind: '{usersData}',

  columns: [
    {dataIndex: 'id', text: 'ID'},
    {
      dataIndex: 'userName',
      text: 'Имя пользователя',
      width: 150,
      align: 'left'
    },
    {dataIndex: 'email', text: 'Email', flex: 1, align: 'left'},
    {
      dataIndex: 'locked', text: 'Блокировка', width: 100, align: 'center',
      renderer: function (value) {
        return value ? 'Да' : 'Нет';
      }
    },
    {
      dataIndex: 'createDate',
      text: 'Дата создания',
      xtype: 'datecolumn',
      format: 'd.m.Y',
      width: 120,
      align: 'center'
    },
    {
      dataIndex: 'lastLoginDate',
      text: 'Последний вход',
      xtype: 'datecolumn',
      format: 'd.m.Y H:i:s',
      width: 160,
      align: 'center'
    }
  ],

  listeners: {
    select: 'onItemSelected'
  }
});
