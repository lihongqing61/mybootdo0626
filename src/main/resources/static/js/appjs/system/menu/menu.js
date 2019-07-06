
var prefix = "/menu";
$(function () {
    load();
});

function load() {
    $("#dataTable").bootstrapTreeTable({
        id: 'id',
        type: 'GET',
        url: prefix + '/list',
        code: 'id',
        parentCode: 'parentId',
        ajaxParams: {sort: 'order_num'},
        expandColumn: '1',      // 在哪一列上面显示展开按钮 收缩 展开按钮
        striped: true,
        bordered: true,
        expandAll: false,
        columns: [
            {title : '编号', field : 'id',  align : 'center', valign : 'center', checkbox : true},
            {title : '菜单名称', field : 'name', align : 'center', valign : 'center'},
            {title : '图标', field : 'icon', align : 'center', valign : 'center',
                formatter: function(item, index) {
                    return item.icon == null ? ''
                        : '<i class="' + item.icon
                        + ' fa-lg"></i>';
                }
             },
            {title : '类型', field : 'orderNum',  align : 'center', valign : 'center'},
            {title : '地址', field : 'url', align : 'center', valign : 'center'},
            {title : '权限标识', field : 'perms', align : 'center', valign : 'center'},
            {title: '操作', field: 'id', align: 'center', valign: 'center',
                formatter: function (item, index) {
                    var a = '<a class="btn btn-primary btn-sm '+ s_edit_h +'" href="#" mce_href="#" title="编辑" onclick="edit(\''+ item.id+ '\')"><i class="fa fa-edit"></i></a>';
                    var b = ' <a class="btn btn-primary btn-sm '+ s_add_h+ '" href="#" mce_href="#" title="添加下级" onclick="add(\''+ item.id+ '\')"><i class="fa fa-plus"></i></a> ';
                    var c = ' <a class="btn btn-warning btn-sm '+ s_remove_h+ '" href="#" title="删除"  mce_href="#" onclick="remove(\''+ item.id+ '\')"><i class="fa fa-remove"></i></a> ';
                    return a + b + c;
                }
            }
        ]
    });
}