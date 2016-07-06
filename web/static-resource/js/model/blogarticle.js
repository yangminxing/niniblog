/**
 * 博客文章列表前端实体对象
 * @constructor
 */
function BlogArticleList() {}
function BlogArticle(){}

BlogArticleList.prototype.currentPgIndex=0;
BlogArticleList.prototype.currentPgCount=0;
BlogArticleList.prototype.currentPgSize=5;
BlogArticleList.prototype.currentBlogArticle=null;
BlogArticle.prototype.title=null;

var blogArticleList;
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
    blogArticleList=new BlogArticleList();
    blogArticle=new BlogArticle();
    blogArticleList.currentBlogArticle=blogArticle;

    //设置默认读取页面
    defaultPage(blogArticleList);
});


/**
 * 加载默认页面
 * @param blogArticle
 */
function defaultPage(blogArticleList)
{
    listBlogarticlePage(blogArticleList.currentBlogArticle, blogArticleList.currentPgIndex,
    blogArticleList.currentPgCount, blogArticleList.currentPgSize);
}


//工作路径
//http://www.mkyong.com/spring-mvc/spring-4-mvc-ajax-hello-world-example/
//然后把传到 后台 后台传给freemarker 的各种参数都变成实体类

/**
 * 产生Blog文章列表
 * @param blogA
 * @param pg_index 当前页号
 * @param pg_count 总页数
 * @param pg_size  每页显示多少个
 */
function listBlogarticlePage(blogArticle, pgIndex, pgCount, pgSize)
{
    blogArticle.title="";
    mainContent.setPageUrl("/blogarticle/list",
        "blogArticle="+ JSON.stringify(blogArticle)+
        "&pgIndex="+pgIndex+
        "&pgSize="+pgSize,
        function(data){
            mainContent.setHtml(data.html);
            blogArticleList.currentPgIndex=data.pgIndex;
            blogArticleList.currentPgCount=data.pgCount;
            blogArticleList.currentPgSize=data.pgSize;
            blogArticleList.currentBlogArticle=data.t;
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

