Ext.define('Admin.model.Base', {
  extend: 'Ext.data.Model',
  requires: [
    'Ext.data.proxy.Rest'
  ],
  schema: {
    namespace: 'Admin.model'
  }
});
