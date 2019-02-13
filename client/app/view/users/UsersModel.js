/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.view.users.UsersModel', {
  extend: 'Ext.app.ViewModel',
  alias: 'viewmodel.users',
  stores: {
    usersData: {
      type: 'users'
    }
  }
});
