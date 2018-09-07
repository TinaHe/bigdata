$(function(){
	$(document).ready(function () {
		var checkTrust = $("#checkTrust").val();
		//请求信任编码
		$.ajax({
			type:"POST",
			url:"/SignalIntel/login/checkTrust.action",
			data:"checkTrust=" + checkTrust,
		    dataType:"JSON",
		    success:function(data){
		    	if (data.success != "true" && data.success != true ) 
		    		top.location.href = "/SignalIntel/jsp/404.html";
			}
		});		
		
	    if (window != top) {  
	        top.location.href = location.href;  
	    }
	}); 
	//获取cookie的值
	var loginName = $.cookie('loginName');
	var password = $.cookie('password');
	loginName = decodeBase64(loginName,5); 
	password = decodeBase64(password,5); 
	$("#password").attr("type","password");
	//将获取的值填充入输入框中
	$('#loginName').val(loginName);
	$('#password').val(password); 
	if(loginName != null && loginName != '' && password != null && password != ''){//选中保存秘密的复选框
		console.log("checked == true");
		$("#rememberPswd").attr('checked',true);
	}
	/**
 * 记住密码
 */
	function rememberPassword() {
		if ($("#rememberPswd")[0].checked) {
			var loginName = $('#loginName').val();
			var password = $('#password').val();
			loginName = encodeBase64(loginName,5); 
			password = encodeBase64(password,5); 
			$.cookie("rememberPswd", "true", { expires: 7 }); //存储一个带7天期限的cookie
			$.cookie("loginName", loginName, { expires: 7 });
			$.cookie("password", password, { expires: 7 });
		}
		else {
			$.cookie("rememberPswd", "false", { expire: -1 });
			$.cookie("loginName", "", { expires: -1 });
			$.cookie("password", "", { expires: -1 });
		}
		var params = "loginName=" + $('#loginName').val();
		var encryptPwd = $.md5($('#password').val());
//		$("#loginForm").submit();
		//向后台提交验证数据
		$.ajax({
			type:"POST",
			url:"/SignalIntel/login/login.action",
			data:params + "&password=" + encryptPwd,
		    dataType:"JSON",
		    success:function(data){
		    	console.log(data.success);
		    	if (data.success) 
		    		top.location.href = data.url;
		    	else 
		    		$(".warning").css("display","block");
			}
		});			
		
		$("#password").attr("type","text");
		$("#password").val("");
		
	}
//    忘记密码显示
	$('.fond').on('click',function() {
		var forget = document.getElementsByClassName('forgetWord')[0];
		forget.style.opacity = (forget.style.opacity == 0) ? .7 : 0;
	});
	$('#password').on('focus',function() {
		$("#password").attr("type","password");
		$(".warning").css("display","none");
	});
	$(document).ready(function () {  
		if (window != top) {  
			top.location.href = location.href;  
		}  
	}); 
	//获取用户名和密码
	$('[type="button"]').on("click",function() {
		var userName = $('#loginName').val();
		var psw = $('#password').val(); 
		if(userName == '' || userName == null){
			layer.msg("请输入用户名!");
			$('#loginName').focus();
			return;
		}
		if(psw == ""||psw == null){
			layer.msg("请输入密码!");
			$('#password').focus();
			return;
		}
		rememberPassword();
	});
	//加密方法。没有过滤首尾空格，即没有trim.
	//加密可以加密N次，对应解密N次就可以获取明文
	function encodeBase64(mingwen,times){
	  var code="";
	  var num=1;
	  if(typeof times=='undefined'||times==null||times==""){
	    num=1;
	  }else{
	    var vt=times+"";
	    num=parseInt(vt);
	  }
	  if(typeof mingwen=='undefined'||mingwen==null||mingwen==""){
	  }else{
	    $.base64.utf8encode = true;
	    code=mingwen;
	    for(var i=0;i<num;i++){
	      code=$.base64.btoa(code);
	    }
	  }
	  return code;
	}
	//解密方法。没有过滤首尾空格，即没有trim
	//加密可以加密N次，对应解密N次就可以获取明文
	function decodeBase64(mi,times){
	  var mingwen="";
	  var num=1;
	  if(typeof times=='undefined'||times==null||times==""){
	    num=1;
	  }else{
	    var vt=times+"";
	    num=parseInt(vt);
	  }
	  if(typeof mi=='undefined'||mi==null||mi==""){
	  }else{
	    $.base64.utf8encode = true;
	    mingwen=mi;
	    for(var i=0;i<num;i++){
	      mingwen=$.base64.atob(mingwen);
	    }
	  }
	  return mingwen;
	}	
	//回车登陆
	$(document).keyup(function(event){  
		if(event.keyCode ==13){  
			$('[type="button"]').trigger("click");  
		}  
	});  
}())