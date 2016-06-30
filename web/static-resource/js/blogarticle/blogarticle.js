
jQuery(document).ready(function() {

    /**
     * 注册事件
     */
    $('.btnTest').click(function(){
        $.ajax({
            cache: true,
            type: "GET",
            url:"/blogarticle/load/2",
            data:"name=f",
            async: true,
            success: function(data) {
                //$("#commonLayout_appcreshi").parent().html(data);
                $('.pikaqiu').html(data);
            },
            error: function(request) {
                //alert("Connection error");
            }
        });
    });

});