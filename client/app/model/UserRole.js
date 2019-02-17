/**
 * Роль пользователя.
 * Created by Andrey Kharintsev on 17.02.2019.
 */
Ext.define('Admin.model.UserRole', {
  extend: 'Ext.data.Model',

  fields: [
    {name: 'userId', type: 'int'},
    {name: 'roleId', type: 'int'},
    {name: 'name', type: 'string'},
    {name: 'code', type: 'string'},
    {name: 'granted', type: 'boolean'}
  ]

  /*
  Uncomment to add validation rules
  validators: {
      age: 'presence',
      name: { type: 'length', min: 2 },
      gender: { type: 'inclusion', list: ['Male', 'Female'] },
      username: [
          { type: 'exclusion', list: ['Admin', 'Operator'] },
          { type: 'format', matcher: /([a-z]+)[0-9]{2,3}/i }
      ]
  }
  */

  /*
  Uncomment to add a rest proxy that syncs data with the back end.
  proxy: {
      type: 'rest',
      url : '/users'
  }
  */
});