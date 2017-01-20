/**
 * Created by dushang on 2016/9/27.
 */
$(function () {

    /*var buyCount=$('form input[name=count]').val();

     $('#minusBtn').click(function () {
     if(buyCount>1){
     buyCount--;
     $('form input[name=count]').val(buyCount);
     $('.buy-count span').text(buyCount);
     }
     calcTotalPrice();
     });

     $('#plusBtn').click(function () {
     buyCount++;
     $('form input[name=count]').val(buyCount);
     $('.buy-count span').text(buyCount);

     calcTotalPrice();
     });*/

    /*更改商品数量*/
    $('.minus-btn').click(function () {
        var buyCount=$(this).parent().find('input').val();
        if(buyCount>1){
            buyCount--;
            $(this).parent().find('input').val(buyCount);
            $(this).parent().find('span').text(buyCount);
        }
        calcTotalPrice();
    });
    $('.plus-btn').click(function () {
        var buyCount=$(this).parent().find('input').val();
        buyCount++;
        $(this).parent().find('input').val(buyCount);
        $(this).parent().find('span').text(buyCount);

        calcTotalPrice();
    });

    calcTotalPrice();

    if(submitAvailableTest()){
        $('#submitOrderBtn').addClass('available');
    }


    function calcTotalPrice() {
        /*var commodityPrice=$('.price span').text().split('￥')[1];
         var price=buyCount*commodityPrice;
         if(price>=mianyunfei){
         $('.total-price span').text("￥"+price);
         }else{
         $('.total-price span').text("￥"+(parseFloat(price)+parseFloat(yunfei)));
         }*/

        var totalPrice=0;
        $('.price').each(function () {
            var price=$(this).attr('data-price');
            totalPrice+=price*$(this).next('.buy-count').find('input').val();
        });
        console.log(totalPrice);

        if(totalPrice>=mianyunfei){
            $('.postage span').text(0);
            $('.total-price span').text(totalPrice);
        }else{
            $('.postage span').text(yunfei);
            $('.total-price span').text(parseFloat(totalPrice)+parseFloat(yunfei));
        }

    }



    /*$('input[type=radio]').change(function () {
     var $this=$(this);
     var appendFlag=true;
     var inputName=$(this).attr('name');
     if($("input[name="+inputName+"]").length>1){
     $('.chosen-parameter span').each(function (i) {
     if($(this).attr('data-type')==$this.attr('name')){
     // val.html($this.val());
     appendFlag=false;
     }
     });

     if(appendFlag){
     $('.chosen-parameter').append("<span data-type='"+$this.attr('name')+"'>"+$this.attr('name')+"："+$this.val()+"</span>")
     }else{
     $(".chosen-parameter span[data-type="+$this.attr('name')+"]").html($this.attr('name')+"："+$this.val());
     }
     }
     if(submitAvailableTest()){
     $('#submitOrderBtn').addClass('available');
     }
     });*/


    /*根据参数是否选择完判断提交按钮是否可用*/
    function submitAvailableTest() {
        return $('select[name=addressId]').val();
    }


     $('#submitOrderBtn').click(function (e) {

     if(submitAvailableTest()){
     /*var chosenParameter="";
     $('.chosen-parameter span').each(function () {
     chosenParameter+=$(this).text()+"、";
     });
     chosenParameter+="数量："+$('input[name=count]').val();

     $('input[name=shopDetail]').val(chosenParameter);*/
     }else{
     return false;
     }
     })
});

// window.onload=function(){
//     // console.log(sessionStorage.getItem('freshFlag'));
//     if (sessionStorage.getItem('freshFlag')=="1")
//     {
//         window.location.reload();
//         sessionStorage.setItem('freshFlag',"0");
//     }
// };
