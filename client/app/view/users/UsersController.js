Ext.define('Admin.view.users.UsersController', {
  extend: 'Ext.app.ViewController',
  alias: 'controller.users',
  onItemSelected: function (sender, record) {
    console.debug("selected: {}", record);
  },
});
