/**
 * Created by Andrey Kharintsev on 11.02.2019.
 */
Ext.define('Admin.model.Role', {
    extend: 'Admin.model.Base',

    fields: [
        { name: 'id',      type: 'int' },
        { name: 'name',     type: 'string' },
        { name: 'code',    type: 'string' }
    ]
});