/**
 * Created by Andrey Kharintsev on 14.02.2019.
 */
Ext.define('Admin.view.users.UserRolesModel', {
  extend: 'Ext.app.ViewModel',
  alias: 'viewmodel.userRoles',
  stores: {
    userRolesData: {
      type: 'userRoles'
    }
  }
});