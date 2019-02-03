/**
 * Created by Andrey Kharintsev on 03.02.2019.
 */
Ext.define('Admin.model.User', {
  extend: 'Admin.model.Base',

  fields: [
    {name: 'userName', type: 'string'},
    {name: 'email', type: 'string'},
    {name: 'locked', type: 'boolean'},
    {name: 'createDate', type: 'date'},
    {name: 'lastLoginDate', type: 'date'}
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