//----------------banner图轮播-------------//
var postData ={
    id:$("#id").val(),
}
$.ajax({
    type: "get",
    dataType: 'json',
    url: "http://localhost:8010/file/findById",
    data: "postData",
    dataType: "json",
    success: function(data) {
        console.log(data)
        if(data.code == 1) { //请求成功
            var con = data.result.banner; //
            var len = con.length;
            console.log(len + "我是轮播图的数量");
            var sort = con.sort; //排序
            //---------------循环图片（轮播图）-----
            $.each(con, function(k, v) {
                var src = con[k].img_url; //图片地址
                var imgId = con[k].id; //图片id
                var sort = con[k].sort; //排序
                var imgurl = con[k].url; //商品id
                console.log(imgurl);
                var t = "<div class='swiper-slide'><a href='javascript:void(0)' imgId=" + imgId + " οnclick='goDetails(" + imgId + "," + imgurl + ")'  imgurl=" + imgurl + " > <img src=" + src + "  imgurl=" + imgurl + "  /></a></div>";
                $('.swiper-wrapper').append(t)

            });
        };
        if(len <= 1) {
            console.log("不能滑动");
            //swiper插件实现轮播图
            var mySwiper = new Swiper('.swiper-container', {
                //autoplay: false, //可选选项，自动滑动
                loop: false,
                pagination: '.swiper-pagination',
                paginationType: 'custom', //这里分页器类型必须设置为custom,即采用用户自定义配置
                paginationCustomRender: function(swiper, current, total) {
                    var customPaginationHtml = "";
                    for(var i = 0; i < total; i++) {
                        //判断哪个分页器此刻应该被激活
                        if(i == (current - 1)) {
                            customPaginationHtml += '<span class="swiper-pagination-customs swiper-pagination-customs-active"></span>';
                        } else {
                            customPaginationHtml += '<span class="swiper-pagination-customs"></span>';
                        }
                    }
                    return customPaginationHtml;
                }
            });
        } else {
            console.log("可以滑动");
            //swiper插件实现轮播图
            var mySwiper = new Swiper('.swiper-container', {
                autoplay: 5000, //可选选项，自动滑动
                loop: true,
                pagination: '.swiper-pagination',
                autoplayDisableOnInteraction : false,//手动滑动后可以自动滑动
                paginationType: 'custom', //这里分页器类型必须设置为custom,即采用用户自定义配置
                paginationCustomRender: function(swiper, current, total) {
                    var customPaginationHtml = "";
                    for(var i = 0; i < total; i++) {
                        //判断哪个分页器此刻应该被激活
                        if(i == (current - 1)) {
                            customPaginationHtml += '<span class="swiper-pagination-customs swiper-pagination-customs-active"></span>';
                        } else {
                            customPaginationHtml += '<span class="swiper-pagination-customs"></span>';
                        }
                    }
                    return customPaginationHtml;
                }
            });
        }
    }
});