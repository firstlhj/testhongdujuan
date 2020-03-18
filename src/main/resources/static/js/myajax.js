$(function(){
    $('#btn').click(function () {

        //获取图片编号
        //var id = $('#id').val();//这种也可以
        var id = document.getElementById("id").value;

        if (!id) {
            alert("用户名必填");
            $('#id').focus();
            return;

        }


        $.ajax({
            type: "POST",
            url: "http://localhost:8010/file/findPictures",
            dataType: "json",
            async: "false",
            data: {"masterId": id},
        }).done(function (result) {
            console.log(result)
            if (result.data){
                // for(var i=0;i<result.length;i++){
                //     // bannerHtml+='<div class="swiper-slide"><a href="'+result[i].banner_url+'"><img src="'+result[i].banner_image+'"></a></div>';
                // }
                // $(".swiper-wrapper").html(bannerHtml);
                // var mySwiper = new Swiper('.swiper-container',{
                //     autoplay : 5000,
                //     speed:1000,
                //     loop: true
                alert("获取成功"),
                console.log(result.data.filePath)
            }else {
                alert("获取失败")

            }
        });


    });
});

