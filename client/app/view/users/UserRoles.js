/**
 * Роли пользователей.
 * Created by Andrey Kharintsev on 14.02.2019.
 */
Ext.define('Admin.view.users.UserRoles', {
  extend: 'Ext.panel.Panel',
  xtype: 'userRoles',
  requires: [
    'Ext.layout.container.Border'
  ],
  profiles: {
    classic: {
      itemHeight: 100
    },
    neptune: {
      itemHeight: 100
    },
    graphite: {
      itemHeight: 120
    }
  },
  referenceHolder: true,
  layout: 'border',
  bodyBorder: false,
  width: 500,
  height: 400,
  defaults: {
    collapsible: true,
    split: true
  },

  session: {},
  items: [
    {
      title: 'Пользователи',
      region: 'west',
      floatable: false,
      margin: '5 0 0 0',
      layout: 'fit',
      width: 225,
      minWidth: 100,
      maxWidth: 250,
      xtype: 'grid',
      viewModel: {
        type: 'users'
      },
      bind: '{usersData}',
      reference: 'userGrid',
      columns: [
        {
          header: 'Имя пользователя',
          dataIndex: 'userName',
          width: '100%',
          align: 'left'
        }
      ]

    },
    {
      title: 'Текущие роли',
      collapsible: false,
      region: 'center',
      margin: '5 0 0 0',
      xtype: 'grid',

      viewModel: {
        type: 'userRoles'
      },

      bind: '{userRolesData}',

      columns: [
        {
          header: 'Доступ',
          xtype: 'checkcolumn',
          dataIndex: 'granted',
          width: 100,
          align: 'center'
        },
        {
          header: 'Роль',
          dataIndex: 'code',
          align: 'left',
          flex: 1
        }
      ]
    }
  ]
});