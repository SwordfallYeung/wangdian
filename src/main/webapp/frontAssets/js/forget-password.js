/**
 * Created by dushang on 2016/9/22.
 */

$(function () {
    $('input[type=submit]').click(function () {

        var url=$('#forgetPwdForm').attr('action');
        var param={};

        param['email']=$('input[name=email]').val();

        var alertInfo="";
        if(param['email']==''){
            alertInfo="请先输入邮箱！";
            showAlertInfo(alertInfo);
        }else if(!( /\w@\w*\.\w/.test(param['email']))){
            alertInfo="邮箱格式不正确！";
            showAlertInfo(alertInfo);
        }else{
            /*向后台传递表单数据*/
            /*禁用按钮*/
            $(this).attr('disabled',"true");
            alertInfo="正在处理，请稍候...";
            showAlertInfo(alertInfo);
            $.post(url,param,function (msg) {

                $('input[type=submit]').removeAttr("disabled");
                if(msg["message"]=="发送成功"){
                    alertInfo="系统已发送重置密码到您的邮箱，请注意查收，如果未收到提醒，可能被过滤到垃圾箱！";
                    showAlertInfo(alertInfo);
                    setTimeout(function () {
                        alertInfo="正在跳转到登录页面!";
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