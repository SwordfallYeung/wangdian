/**
 * Created by dushang on 2016/9/17.
 */
$(function () {

    var alertInfo="";


    /*修改昵称*/
    $('#nickNameShow').parent().on('click',function () {
        $('#changeNickNameBtn').parent().find('.alertInfo').html("");
        $('#nickName input[name=nickname]').val("");
    });

    $("#changeNickNameBtn").on('click',function () {

        var newNickName=$('#nickName input[name=nickname]').val();

        if(newNickName==''){
            alertInfo="新昵称不能为空！";
            showAlertInfo($(this),alertInfo);

        }else{
            $('#changeNickNameBtn').attr('disabled','true');
            alertInfo="正在处理...";
            showAlertInfo($(this),alertInfo);
            $.ajax({
                url:contextPath+'/updateNickname',
                type:'POST',
                data:{
                    userId:userId,
                    nickname:newNickName
                },
                cache:false,
                success:function (data) {
                    $('#changeNickNameBtn').removeAttr("disabled");

                    showAlertInfo($("#changeNickNameBtn"),data['message']);

                    $('#nickNameShow').html(newNickName);
                    $('#userNickName').html(newNickName);
                }
            })
        }
    });

    /*修改邮箱*/
    $('#emailShow').parent().on('click',function () {
        $('#changeEmailBtn').parent().find('.alertInfo').html("");
        $('#email input[name=email]').val("");
    });

    $("#changeEmailBtn").on('click',function () {

        var newEmail=$('#email input[name=email]').val();

        if(newEmail==''){
            alertInfo="新邮箱不能为空！";
            showAlertInfo($(this),alertInfo);
        }else if(!/\w@\w*\.\w/.test(newEmail)){
            alertInfo="新邮箱格式不正确！";
            showAlertInfo($(this),alertInfo);
        }else{
            $('#changeEmailBtn').attr('disabled','true');
            alertInfo="正在处理...";
            showAlertInfo($(this),alertInfo);
            $.ajax({
                url:contextPath+'/updateEmail',
                type:'POST',
                data:{
                    userId:userId,
                    email:newEmail
                },
                cache:false,
                success:function (data) {
                    $('#changeEmailBtn').removeAttr("disabled");

                    showAlertInfo($("#changeEmailBtn"),data['message']);

                    $('#emailShow').html(newEmail);
                }
            })
        }
    });

    /*修改手机号*/
    $('#phoneShow').parent().on('click',function () {
        $('#changePhoneBtn').parent().find('.alertInfo').html("");
        $('#phone input[name=phone]').val("");
    });

    $("#changePhoneBtn").on('click',function () {

        var newPhone=$('#phone input[name=phone]').val();

        if(newPhone==''){
            alertInfo="新手机号不能为空！";
            showAlertInfo($(this),alertInfo);
        }else if(!/^1[34578]\d{9}$/.test(newPhone)){
            alertInfo="新手机号格式不正确！";
            showAlertInfo($(this),alertInfo);
        }else{
            $('#changePhoneBtn').attr('disabled','true');
            alertInfo="正在处理...";
            showAlertInfo($(this),alertInfo);
            $.ajax({
                url:contextPath+'/updateTelephone',
                type:'POST',
                data:{
                    userId:userId,
                    telephone:newPhone
                },
                cache:false,
                success:function (data) {
                    $('#changePhoneBtn').removeAttr("disabled");

                    showAlertInfo($("#changePhoneBtn"),data['message']);

                    $('#phoneShow').html(newPhone);
                }
            })
        }
    });


    function showAlertInfo($selector,alertInfo) {
        $selector.parent().find('.alertInfo').html(alertInfo);
        $selector.on('blur',function () {
            $selector.parent().find('.alertInfo').html("");
        })
    }
});