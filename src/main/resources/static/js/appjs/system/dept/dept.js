var prefix = "/dept";

$(function() {
    load();
});

function load() {
    $("#dataTable").bootstrapTreeTable({

        id: 'id',
        code: 'deptId',
        parentCode: 'parentId',
        type: 'GET',            // 请求方式
        url: prefix + '/list',  // 请求ajax地址
        ajaxParams: {},         // 请求的数据参数
        expandColumn : '1', // 在哪一列上面显示展开按钮
        striped : true, // 是否各行渐变色
        bordered : true, // 是否显示边框
        expandAll : false, // 是否全部展开
        columns: [
            {title : '编号', field : 'id',  align : 'center', valign : 'center', checkbox : true},
            {title : '部门名称', field : 'name', align : 'center', valign : 'center'},
            {title : '排序', field : 'orderNum',  align : 'center', valign : 'center'},
            {title : '操作', formatter: function (item, index) {
                var a = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(\''+item.id+'\')"><i class="fa fa-edit"></i></a>';
                var b = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="增加下级" onclick="add(\''+item.id+'\')"><i class="fa fa-plus"></i></a>';
                var c = '<a class="btn btn-warning btn-sm" href="#" mce_href="#" title="删除" onclick="remove(\''+item.id+'\')"><i class="fa fa-remove"></i></a>';
                var d = '<a class="btn btn-success btn-sm＂href="#" mce_href="#" title="备用" onclick="resetPwd(\'' + item.deptId + '\')"><i class="fa fa-key"></i></a>';
                return a + b + c + d;
                }}
        ]

    });
}


function add(pId) {
    layer.open({
        type: 2,
        title: '新增',
        shadeClose: false,
        area: ['800px', '520px'],
        content: prefix + '/add/' + pId     // 跳转到新增页面接口
    });
};

function reLoad() {
    $('#dataTable').bootstrapTable('refresh');
}