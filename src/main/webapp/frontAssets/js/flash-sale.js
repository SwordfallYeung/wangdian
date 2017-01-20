/**
 * Created by dushang on 2016/9/14.
 */
$(function () {

    setTimer();

    function setTimer() {
        $('.timer').each(function (i,value) {
            var endTime=$(this).attr('data-endTime');
            $(this).downCount({
                date:endTime,
                offset:+10
            },function () {
                $('.timer').eq(i).find('li span').css({
                    "color":"#FF463C",
                    "text-shadow":"0 1px 0 #FF463C"
                })
            })
        });
    }

    var page=1;
    var noMore=false;

    /*页面滚动时计算距离页面底部距离*/
    $(window).scroll(function () {

        var pageHeight=document.body.scrollHeight;   //窗口文档body的高度
        var scrollTop=document.body.scrollTop;        //滚动条top
        var viewHeight=$(window).height();          //视口高度

        var toBoottom=pageHeight-scrollTop-viewHeight;      //距离页面底部的距离

        /*当距离页面底部距离很小时，ajax加载更多内容*/
        if(toBoottom<1){
            ajaxGetData();
        }
    });


    /*通过ajax，传递当前页面参数，获取页面数据*/
    function ajaxGetData() {
        $.ajax({
            url:contextPath+'/flashSalePage',
            type:'POST',
            data:{
                page:page
            },
            cache:false,
            success:function (data) {
                if(data['shunShopList'].length!=0){
                    var shunShopList=data['shunShopList'];
                    for(var i=0;i<shunShopList.length;i++){
                        var appendContent="<a class='ui-grid-solo' href='"+contextPath+"/commodityDetail?id="+shunShopList[i].id+"&type=shunShop' data-ajax='false'>"+
                                "<div class='ui-block-a'><div><div class='countdown'>" +
                            "<p>距活动结束还剩：</p>" +
                            "<ul class='timer' data-endTime='"+formatDate(shunShopList[i].endTime)+"'>" +
                            "<li> <span class='days'>00</span></li>" +
                            "<li class='seperator'>天</li>" +
                            "<li> <span class='hours'>00</span></li>" +
                            "<li class='seperator'>时</li>" +
                            "<li> <span class='minutes'>00</span></li>" +
                            "<li class='seperator'>分</li>" +
                            "<li> <span class='seconds'>00</span></li>" +
                            "<li class='seperator'>秒</li>" +
                            "</ul></div></div>" +
                            "<img src='"+contextPath+"/"+shunShopList[i].firstPhoto+"'>" +
                            "<div class='commodity-info'>" +
                            "<div>"+shunShopList[i].name+"</div>" +
                            "<div class='price'><span>"+shunShopList[i].thirdCost+"</span><span>"+shunShopList[i].secondCost+"</span></div>" +
                            "</div></div></a>";

                        $('.flash-sale').append(appendContent);
                        setTimer();

                    }
                    console.log(shunShopList);
                }else{
                    if(!noMore){
                        $('.flash-sale').append("<div class='no-more'>----没有更多内容！----</div>");
                        noMore=true;
                    }

                }
                page++;
            }
        })
    }


    /*对时间戳进行格式化*/
    function formatDate(timeStamp) {
        var d=new Date(timeStamp);
        var date= (d.getMonth()+1)+"/"+(d.getDate())+"/"+(d.getFullYear())+" "+(d.getHours())+":"+(d.getMinutes())+":"+(d.getSeconds());
        // console.log(date);
        return date;
    }
});