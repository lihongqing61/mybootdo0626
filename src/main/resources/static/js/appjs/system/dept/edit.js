$(function () {
    validateRule();
});

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i>";
    $("#signupForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 10

            }
        },
        messages: {
            name: {
                required: icon + "请输入部门名称",
                minlength: "部门名称长度不能小于2位",
                maxlength: "部门名称长度不能大于10位"
            }
        }
    });
}

$.validator.setDefaults({
    submitHandler: function() {
        update();
    }
});

function update() {
    $.ajax({
        cache : false,
        type : "POST",
        url : "/dept/update",
        //    contentType: "application/json;charset=UTF-8",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        success : function(data) {
            if (data.code == 1) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });
}