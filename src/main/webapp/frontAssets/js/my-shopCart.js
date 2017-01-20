/**
 * Created by dushang on 16/10/14.
 */
$(function () {

    /*检查按钮是否可用*/
    function checkBtn() {
        console.log($('input[name=shopCartIdList]:checked').length);
        if($('input[name=shopCartIdList]:checked').length>0){
            return true;
        }else{
            return false;
        }
    }

    $('form input').click(function () {
        if(checkBtn()){
            $('.options button').removeClass('unavailable');
        }else{
            $('.options button').addClass('unavailable');
        }
    });

    $('#delBtn').click(function () {
        if(checkBtn()){

            var alertInfo="确定要删除该条地址记录吗？";
            showAlertInfo(alertInfo);

            $('.confirmBtn').on('click',function () {
                var list=[];
                $('input[name=shopCartIdList]:checked').each(function () {
                    list.push($(this).val());
                });

                $.ajax({
                    url:contextPath+'/deleteFromShopCart',
                    type:'POST',
                    dataType:'json',
                    data:{
                        shopCartIdList:JSON.stringify(list)
                    },
                    cache:false,
                    /*数据传送成功*/
                    success:function (data) {
                        if(data.message == "success"){
                            location.reload();
                        }
                    }
                });
            });

        }
    });

    $('#submitBtn').click(function (e) {
        if(!checkBtn()){
            e.preventDefault();
            return false;
        }
    });

    function showAlertInfo(alertInfo) {
        $('.alert-info').html(alertInfo);
        $('#alertInfoBtn').click();
    }
});