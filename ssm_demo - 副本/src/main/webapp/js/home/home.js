$(function () {
	//登录用户名
	$("#userName").html();//后台传值
	$('.homeLeft ul').on('click', 'li', function () {
		$('.open').removeClass('open');
		$(this).addClass('open'); 
		$(this).attr('id');
	});
	$.ajax({
		type: "POST",
		url: "menuList.action",
		dataType: "json",
		success: function (data) {
			//首页点击事情绑定
			$('#c8a5bdd2-79af-4cfa-a61c-5136e6b402fa').on('click', function () {
				//菜单样式变更
				var url = "subMenuInit.action?code=c8a5bdd2-79af-4cfa-a61c-5136e6b402fa";
				$('#submenu').attr('src', url);
			});	
			var items = eval(data.data);
			$.each(items, function (index, item) {
				// alert("索引:" + index + "," + "对应值为：" + item.entityCode);
				$('#' + item.entityCode).removeClass("hid");
				$('#' + item.entityCode).on('click', function () {
					//菜单样式变更
					var url = "subMenuInit.action?code=" + item.entityCode;
					$('#submenu').attr('src', url);
				});
			});
		}
	});
}());

/** 登出 */
function loginOut() {
	$.messager.confirm("系统提示", "您确定要退出吗？", function(r) {
		if (r) {	
		$.ajax({
			type: "POST",
			url: "logout.action",
			dataType: "json",
			success: function (data) {
				if (data.success == "true") {
					window.location.reload();
				}
			}
		});
		}
	});
}
var url;
/** 修改密码 */
function modPassword() 
{
    $("#loginUserdlg").dialog("open").dialog("setTitle", "修改用户密码");
    url = "modPassword.action";
}
/**
 * 修改用户信息
 */
var error = document.getElementById('error');
function errorMsg(msg) {
	error.style.display = "block";
	$("#error").html(msg)
}
function saveUserInfo() {
    $("#loginUserform").form("submit", {
        url : url,
        onSubmit : function() {
            if ($("#loginCode").val() == "") {
				errorMsg("未登录或登录超时，不能修改密码！");
                return false;
            }
            if ($("#oldPasswordHidden").val() == "") {
				errorMsg("未登录或登录超时，不能修改密码！");
                return false;
            }            
            if ($("#oldPasswordId").val() == "") {
				errorMsg("请输入原密码！");
            	return false;
			}
            if ($("#passwordId").val() == "") {
				errorMsg("请输入新密码！");
            	return false;
			}else{
				var pwd = $("#passwordId").val(),
				reg = /^[a-zA-Z](?!^[_\W]*$)(?!^[0-9]*$){7,15}/;
				if (!reg.test(pwd)){
					errorMsg('8-16位，必须由字母开头可以数字、字母任意组合')
					return false;
				}
			}     
            if ($("#passwordCheckId").val() == "") {
            	errorMsg("请输入确认密码！");
            	return false;
            }             
            if ($("#passwordCheckId").val() != $("#passwordId").val()) {
            	errorMsg("两次输入密码不一致，请确认！");
            	return false;
            }             
            return $(this).form("validate");
        },
        success : function(result) {
            var result = eval('(' + result + ')');
            if (result.success) {
            	$(function () {
                    $.messager.alert("系统提示", "修改成功！","info",function(){
                    	location.href="/SignalIntel/login/relogin.action";
                    });
                });
				error.style.display = "none";
                closeUserDialog();
            } else {
                $.messager.alert("系统提示", "修改失败！");
                return;
            }
        }
    });
}
function closeUserDialog() {
	$("input[type=password]").val("");
    $("input[name=password]").val("");
    $("input[name=oldPassword]").val("");
    $("input[name=passwordCheck]").val("");
    $("#loginUserdlg").dialog("close");
}
