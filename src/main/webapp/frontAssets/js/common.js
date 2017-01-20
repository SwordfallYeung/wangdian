/**
 * Created by dushang on 2016/9/16.
 */
$(function () {


    /*根据当前页面的title值来确定激活的导航菜单*/

    var title=$('title').text();
    if(title.indexOf('首页')!=-1){
        $('.ui-footer-fixed ul').find('a').eq(0).addClass('ui-btn-active').parent().siblings().removeClass('ui-btn-active');
    }else if(title.indexOf('限时秒杀')!=-1){
        $('.ui-footer-fixed ul').find('a').eq(1).addClass('ui-btn-active').parent().siblings().removeClass('ui-btn-active');
    }else if(title.indexOf('商品分类')!=-1){
        $('.ui-footer-fixed ul').find('a').eq(2).addClass('ui-btn-active').parent().siblings().removeClass('ui-btn-active');
    }else if(title.indexOf('个人中心')!=-1){
        $('.ui-footer-fixed ul').find('a').eq(3).addClass('ui-btn-active').parent().siblings().removeClass('ui-btn-active');
    }


    /*搜索按钮点击事件*/
    /*$('#searchBtn').click(function () {
        var searchContent=$(this).parent().find('input[name=shopName]') .val();
        if(searchContent==""){
            return false;
        }
    });*/

});