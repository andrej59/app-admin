/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.view.roles.RolesModel', {
  extend: 'Ext.app.ViewModel',
  alias: 'viewmodel.roles',

  stores: {
    rolesData: {
      type: 'roles'
    }
  }

});