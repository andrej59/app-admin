/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.model.Group', {
  extend: 'Admin.model.Base',

  fields: [
    {name: 'id', type: 'int'},
    {name: 'name', type: 'string'}
  ]
});