/**
 * Created by dushang on 2016/9/21.
 */
/**
 * Created by dushang on 2016/9/21.
 */
$(function () {
    $('input[type=submit]').click(function () {

        var url=$('#registerForm').attr('action');
        var param={};

        param['username']=$('input[name=username]').val();
        param['nickname']=$('input[name=nickname]').val();
        param['telephone']=$('input[name=telephone]').val();
        param['email']=$('input[name=email]').val();
        param['password']=$('input[name=password]').val();
        var password=$('#password').val();

        var alertInfo="";
        if(param['username']==''){
            alertInfo="真实姓名不能为空！";
            showAlertInfo(alertInfo);
        }else if(param['nickname']==''){
            alertInfo="昵称不能为空！";
            showAlertInfo(alertInfo);
        }else if(param['telephone']==''){
            alertInfo="手机号码不能为空！";
            showAlertInfo(alertInfo);
        }else if(!/^1[34578]\d{9}$/.test(param['telephone'])){
            alertInfo="手机号码格式不正确！";
            showAlertInfo(alertInfo);
        }else if(param['email']==''){
            alertInfo="邮箱不能为空！";
            showAlertInfo(alertInfo);
        }else if(!/\w@\w*\.\w/.test(param['email'])){
            alertInfo="邮箱格式不正确！";
            showAlertInfo(alertInfo);
        }else if(param['password']==''){
            alertInfo="密码不能为空！";
            showAlertInfo(alertInfo);
        }else if(param['password']!=password){
            alertInfo="两次输入的密码不一致！";
            showAlertInfo(alertInfo);
        }else{
            /*向后台传递表单数据*/
            /*禁用按钮*/
            $(this).attr('disabled',"true");
            alertInfo="正在处理，请稍候...";
            showAlertInfo(alertInfo);
            $.post(url,param,function (msg) {

                $('input[type=submit]').removeAttr("disabled");

                if(msg["message"]=="注册成功"){
                    alertInfo="注册成功！";
                    showAlertInfo(alertInfo);
                    setTimeout(function () {
                        alertInfo="正在跳转到登录页面！";
                        showAlertInfo(alertInfo);
                    },2000);
                    setTimeout(function () {
                        window.location.href=contextPath+"/login";
                    },3000);
                }else{
                    alertInfo=msg["message"];
                    showAlertInfo(alertInfo);
                    return false;
                }
            })
        }

        return false;
    });



    function showAlertInfo(alertInfo) {
        $('.alert-info').html(alertInfo);
        $('#alertInfoBtn').click();
    }
});