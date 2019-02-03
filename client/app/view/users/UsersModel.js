Ext.define('Admin.view.users.UsersModel', {
  extend: 'Ext.app.ViewModel',
  alias: 'viewmodel.users',
  /*
  requires: [
    'Ext.data.Store',
    'Ext.data.field.Integer',
    'Ext.data.field.String',
    'Ext.data.field.Boolean',
    'Admin.model.Base',
    'Admin.model.User',
    'Admin.store.Users'
  ],
  */
  bind: {
    store: '{users}'
  }
  /*
  stores: {
    userData: {
      model: 'Admin.model.User'
    }
  }
  */
});
