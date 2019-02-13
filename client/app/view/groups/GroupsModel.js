/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.view.groups.GroupsModel', {
  extend: 'Ext.app.ViewModel',
  alias: 'viewmodel.groups',

  stores: {
    groupsData: {
      type: 'groups'
    }
  }
});