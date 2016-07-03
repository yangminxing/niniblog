
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

    //设置默认读取页面
    defaultPage();
});

function defaultPage()
{
    listBlogarticlePage();
}

function listBlogarticlePage(pg_index, pg_count,pg_size, fl_keywords)
{
    mainContent.setPageUrl("/blogarticle/list", "pg_index="+pg_index+"&pg_count="+pg_count+"&pg_size="+pg_size+"&fl_keywords="+fl_keywords,
        function(data){
            mainContent.setHtml(data);
        },
        function(error){
            mainContent.setHtml(error);
        });
}

function editBlogarticlePage()
{

}

function loadBlogarticlePage()
{

}

