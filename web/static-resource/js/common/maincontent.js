function MainContent(config){

}

MainContent.prototype={
    //当前命令
    currentCommmand:''
}

//从后台读取内容
MainContent.prototype.setPageUrl=function(url, data, successFn, errorFn){

    this.currentCommmand=url;

    $.ajax({
        catch:false,
        type:"GET",
        url:url,
        data:data,
        async:false,
        success:successFn,
        error:errorFn
    });
}

//设置mainContent的内容
MainContent.prototype.setHtml=function(html){

    $('#mainContent').html(html);
}