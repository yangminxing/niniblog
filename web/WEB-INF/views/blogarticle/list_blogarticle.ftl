<!-- 正文开始 -->
<#if blogarticles??>
    <#list blogarticles as blogarticle>
    <div class="row">
        <div class="col-md-12 column">
            <h2>
            ${blogarticle.title}
            </h2>
            <p>
            ${blogarticle.content}
            </p>
            <p>
                <a class="btn" href="#">View details »</a>
            </p>
        </div>
    </div>
    </#list>
</#if>
<!-- 正文结束 -->


<#macro pg blogarticle>
<div class="row text-right">
    <div class="col-md-11 column">
        <ul class="pagination">
            <#assign nba=blogarticle>
            <#assign pi=blogarticle.pgIndex?number>
            <#if pi gt 1>

                <a href="javascript:listBlogarticlePage('${nba}');">Prev</a>
            <#else>
                <a href="javascript:void(0);">Prev</a>
            </#if>

            <#if pi lt pg_size>
                <a href="javascript:listBlogarticlePage('${nba}');">Next</a>
            <#else>
                <a href="javascript:void(0);">Next</a>
            </#if>
        </ul>
    </div>
</div>
</#macro>

<@pg blogarticle=blogarticle />

<#--<!-- 分页开始 &ndash;&gt;-->
<#--<div class="row text-right">-->
    <#--<div class="col-md-11 column">-->
        <#--<ul class="pagination">-->
            <#--<li>-->
                <#--<!-- 上一页开始 &ndash;&gt;-->
                <#--&lt;#&ndash;<a href="javascript:listBlogarticlePage('${pg_index!0-1}','${pg_count},'${pg_size}','${fl_keywords}')">&ndash;&gt;-->
                    <#--Prev-->
                <#--&lt;#&ndash;</a>&ndash;&gt;-->
                <#--<!-- 上一页结束 &ndash;&gt;-->
            <#--</li>-->
            <#--<li>-->
                <#--<a href="#">1</a>-->
            <#--</li>-->
            <#--<li>-->
                <#--<a href="#">2</a>-->
            <#--</li>-->
            <#--<li>-->
                <#--<a href="#" class="pgselected">3</a>-->
            <#--</li>-->
            <#--<li>-->
                <#--<a href="#">4</a>-->
            <#--</li>-->
            <#--<li>-->
                <#--<a href="#" >5</a>-->
            <#--</li>-->
            <#--<li>-->
                <#--<!-- 上一页开始 &ndash;&gt;-->
                <#--<a href="#">-->
                    <#--Prev-->
                <#--</a>-->
            <#--</li>-->
        <#--</ul>-->
    <#--</div>-->
<#--</div>-->
<!-- 分页结束 -->