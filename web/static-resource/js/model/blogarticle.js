/**
 * 博客文章列表前端实体对象
 * @constructor
 */
function BlogArticle() {}

BlogArticle.prototype.current_pg_index=0;
BlogArticle.prototype.current_pg_count=0;
BlogArticle.prototype.current_pg_size=5;
BlogArticle.prototype.current_fl_keywords="";

var blogArticle;
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

    //实例初始化
    blogArticle=new BlogArticle();

    //设置默认读取页面
    defaultPage(blogArticle);
});


/**
 * 加载默认页面
 * @param blogArticle
 */
function defaultPage(blogArticle)
{
    listBlogarticlePage(blogArticle);
}




/**
 * 产生Blog文章列表
 * @param pg_index 当前页号
 * @param pg_count 总页数
 * @param pg_size  每页显示多少个
 * @param fl_keywords 过滤关键词
 */
function listBlogarticlePage(blogArticle)
{
    mainContent.setPageUrl("/blogarticle/list",
        "pg_index="+blogArticle.current_pg_index+
        "&pg_count="+blogArticle.current_pg_count+
        "&pg_size="+blogArticle.current_pg_size+"" +
        "&fl_keywords="+blogArticle.current_fl_keywords,
        function(data){
            mainContent.setHtml(data.html);
            blogArticle.current_pg_index=data.pgIndex;
            blogArticle.current_pg_count=data.pgCount;
            blogArticle.current_pg_size=data.pgSize;
            blogArticle.current_fl_keywords=data.flKeywords;
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

