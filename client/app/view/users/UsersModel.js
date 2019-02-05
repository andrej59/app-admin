Ext.define('Admin.view.users.UsersModel', {
  extend: 'Ext.app.ViewModel',
  alias: 'viewmodel.users',

  requires: [
    'Ext.data.Store',
    'Ext.data.proxy.Memory',
    'Ext.data.field.Integer',
    'Ext.data.field.String',
    'Ext.data.field.Date',
    'Ext.data.field.Boolean',
    'Ext.data.reader.Json'
  ],

  stores: {
    usersData: {
      type: 'users'
    }
  }

});
