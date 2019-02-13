/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.view.users.UsersController', {
  extend: 'Ext.app.ViewController',
  alias: 'controller.users',
  onItemSelected: function (sender, record) {
    console.debug("selected: {}", record);
  },
});
