/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.view.roles.Roles', {
  extend: 'Ext.grid.Panel',
  xtype: 'roleList',

  requires: [
    'Admin.view.roles.RolesModel',
    'Admin.view.roles.RolesController'
  ],

  title: 'Роли',

  viewModel: {
    type: 'roles'
  },

  bind: '{rolesData}',

  columns: [
    {text: 'ID', dataIndex: 'id'},
    {text: 'Имя', dataIndex: 'name', flex: 1},
    {text: 'Код', dataIndex: 'code', flex: 1}
  ],

  controller: 'roles'
});