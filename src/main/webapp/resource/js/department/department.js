$(function () {
    $("#insert").click(function () {
        var btn = document.getElementById('save');
        btn.addEventListener('click', insert, false);
    });

    $('#departmentInsertDialog').on('hide.bs.modal', function () {
        $('.modal-body').find('input').each(function(){$(this).val('');});
        $("#insertDepartmentId").removeAttr("disabled");
        $('#insertDepartmentForm')[0].reset();
        $('#insertDepartmentForm').data('bootstrapValidator').resetForm(true);
    })

    $('#insertDepartmentForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            departmentId: {
                validators: {
                    notEmpty: {
                        message: '部门编号不能为空'
                    },
                    remote: {
                        url: '/department/checkDepartmentId',
                        message: '部门编号已存在',
                        type: 'POST',
                    },
                    regexp: {
                        regexp: /(^[0-9]{2,5})$/,
                        message: '部门编号由2-5位数字组成!'
                    }
                }
            },
            departmentName: {
                validators: {
                    notEmpty: {
                        message: '部门名称不能为空'
                    },
                    regexp: {
                        regexp: /^([\u4e00-\u9fa5·s]{2,20}|[a-zA-Z.s]{2,20})$/,
                        message: '由汉字或英文字母组成的2-20位字符!'
                    }
                }
            },
            departmentManager: {
                validators: {
                    notEmpty: {
                        message: '部门主管不能为空'
                    },
                    regexp: {
                        regexp: /^([\u4e00-\u9fa5·s]{2,20}|[a-zA-Z.s]{2,20})$/,
                        message: '由汉字或英文字母组成的2-20位字符!'
                    }
                }
            },
            departmentDescription: {
                validators: {
                    notEmpty: {
                        message: '部门描述不能为空'
                    },
                }
            },
        }
    })

    $('#close').click(function() {
        $('#insertDepartmentForm').data('bootstrapValidator').resetForm(true);
    });

    $("#insertDepartmentForm").submit(function(ev){ev.preventDefault();});

});

function edit(departmentRecId) {
    $.ajax({
        type:"get",
        url:"/department/edit",
        data:{"departmentRecId":departmentRecId},
        success:function(data) {
            $("#insertDepartmentRecId").val(data.departmentRecId);
            $("#insertDepartmentId").val(data.departmentId).attr("disabled","disabled");
            $("#insertDepartmentName").val(data.departmentName);
            $("#insertDepartmentManager").val(data.departmentManager);
            $("#insertDepartmentDescription").val(data.departmentDescription);
        }
    });
    var btn = document.getElementById('save');
    btn.removeEventListener('click',insert,false);
    btn.addEventListener('click',update,false);
};

function update() {
    var bootstrapValidator = $("#insertDepartmentForm").data('bootstrapValidator');
    bootstrapValidator.validate();
    if(bootstrapValidator.isValid())
        $("#insertDepartmentForm").submit();
    else return;
    $("#insertDepartmentId").removeAttr("disabled");
    $.post("/department/update",$("#insertDepartmentForm").serialize(),function(data){
        alert("更新成功！");
        window.location.reload();
    });
};

function insert() {
    var bootstrapValidator = $("#insertDepartmentForm").data('bootstrapValidator');
    bootstrapValidator.validate();
    if(bootstrapValidator.isValid())
        $("#insertDepartmentForm").submit();
    else return;
    $.post("/department/insert", $("#insertDepartmentForm").serialize(), function (data) {
        alert("新增成功！");
        window.location.reload();
    });
};

function deleteDepartment(departmentRecId) {
    if (confirm('确定要删除吗?')) {
        $.post("/department/delete", {"departmentRecId": departmentRecId}, function (data) {
            alert("删除成功！");
            window.location.reload();
        });
    };
};

function selectDelete() {
    var checked = $("#tableId").find(":input[id='case']:checked");
    if (checked.length <= 0) {
        alert("你还没有选择任何内容！");
        return;
    };
    if(confirm("确定删除所选中的?")==true){
        var ids= "";
        checked.each(function(index, item) {
            var id = $(item).val();
            ids += id + ",";
        });
        if (ids.length > 0) {
            $.post("/department/deleteMany", {"ids": ids}, function (data) {
                alert("已勾选部门删除成功!");
                window.location.reload();
            });
        }
    };
};

function selectAllCheckBox(Obj){
    var collid = document.getElementById("selectAll");
    var coll = document.getElementsByName(Obj);
    if (collid.checked){
        for(var i = 0; i < coll.length; i++)
            coll[i].checked = true;
    }else{
        for(var i = 0; i < coll.length; i++)
            coll[i].checked = false;
    }
};



































// //表单验证
// function reg(e) {
//     var errMsg;
//     if ($(e).attr("name") == "department_id") {
//         $(e).parent().find("span").remove();
//         var department_id = $(e).val();
//         var regName = /(^[0-9]{2,5})$/;
//         if (department_id == "" || department_id.trim() == "") {
//             errMsg = "<span class='nameMsg onError' style='color:red;'>✘部门编号不能为空!</span>";
//         } else if (!regName.test(department_id)) {
//             errMsg = "<span class='nameMsg onError' style='color:red;'>✘部门编号由2-5位数字组成!</span>";
//         }
//         else{
//             ajaxValidate(e);
//         }
//         $(e).parent().append(errMsg);
//     }
//
//     else if ($(e).attr("name") == "department_name") {
//         $(e).parent().find("span").remove();
//         var department_name = $(e).val();
//         var regName = /^([\u4e00-\u9fa5·s]{2,20}|[a-zA-Z.s]{2,20})$/;
//         if (department_name == "" || department_name.trim() == "") {
//             errMsg = "<span class='nameMsg onError' style='color:red;'>✘部门名称不能为空!</span>";
//         } else if (!regName.test(department_name)) {
//             errMsg = "<span class='nameMsg onError' style='color:red;'>✘由汉字或英文字母组成的2-20位字符!</span>";
//         }
//         else{
//             $(e).parent().append("<span class='nameMsg onSuccess' style='color:#66ff14;'>✔</span>");
//         }
//         $(e).parent().append(errMsg);
//     }
//
//     else if ($(e).attr("name") == "department_manager") {
//         $(e).parent().find("span").remove();
//         var department_manager = $(e).val();
//         var regName = /^([\u4e00-\u9fa5·s]{2,20}|[a-zA-Z.s]{2,20})$/;
//         if (department_manager == "" || department_manager.trim() == "") {
//             errMsg = "<span class='nameMsg onError' style='color:red;'>✘部门主管不能为空!</span>";
//         } else if (!regName.test(department_manager)) {
//             errMsg = "<span class='nameMsg onError' style='color:red;'>✘由汉字或英文字母组成的2-20位字符!</span>";
//         }
//         else{
//             $(e).parent().append("<span class='nameMsg onSuccess' style='color:#66ff14;'>✔</span>");
//         }
//         $(e).parent().append(errMsg);
//     }
//
//     else if ($(e).attr("name") == "department_description") {
//         $(e).parent().find("span").remove();
//         var department_description = $(e).val();
//         if (department_description == "" || department_description.trim() == "") {
//             errMsg = "<span class='nameMsg onError' style='color:red;'>✘部门描述不能为空!</span>";
//         }
//         else{
//             $(e).parent().append("<span class='nameMsg onSuccess' style='color:#66ff14;'>✔</span>");
//         }
//         $(e).parent().append(errMsg);
//     }
// };


