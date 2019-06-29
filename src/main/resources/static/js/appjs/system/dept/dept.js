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
            {title : '编号', field : 'id', visible : false,  align : 'center', valign : 'center',  width : '50px', checkbox : true},
            {title : '部门名称', field : 'name', valign : 'center', width :20},
            {title : '排序', field : 'orderNum',  align : 'center', valign : 'center'},
            {title : '操作'}
        ]

    });
}