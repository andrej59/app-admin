/**
 * Created by Andrey Kharintsev on 17.02.2019.
 */
Ext.define('Admin.view.users.Main', {
  extend: 'Ext.tab.Panel',
  xtype: 'users',
  requires: [
    'Ext.layout.container.Fit',
    'Ext.plugin.LazyItems'
  ],
  frame: true,
  resizable: false,
  minHeight: 400,
  defaults: {
    bodyPadding: 0,
    scrollable: true
  },

  items: [{
    title: 'Пользователи',
    xtype: 'userList'
  },
    {
      title: 'Роли пользователей',
      xtype: 'userRoles'
      /*
      plugins: {
        ptype: 'lazyitems',
        items: {
          xtype: 'userRoles'
        }
      }*/
    }
  ]
});