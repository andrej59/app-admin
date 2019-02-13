/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.view.groups.Groups', {
  extend: 'Ext.grid.Panel',
  xtype: 'groupList',

  requires: [
    'Admin.view.groups.GroupsModel',
    'Admin.view.groups.GroupsController'
  ],
  title: 'Группы',

  viewModel: {
    type: 'groups'
  },

  controller: 'groups',

  bind: '{groupsData}',

  columns: [
    {text: 'ID', dataIndex: 'id'},
    {text: 'Имя группы', dataIndex: 'name', flex: 1}

  ]
});