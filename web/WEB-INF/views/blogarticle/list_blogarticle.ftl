<!-- 正文开始 -->
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
<!-- 正文结束 -->

<!-- 分页开始 -->
<div class="row text-right">
    <div class="col-md-11 column">
        <ul class="pagination">
            <li>
                <a href="#">Prev</a>
            </li>
            <li>
                <a href="#">1</a>
            </li>
            <li>
                <a href="#">2</a>
            </li>
            <li>
                <a href="#">3</a>
            </li>
            <li>
                <a href="#">4</a>
            </li>
            <li>
                <a href="#">5</a>
            </li>
            <li>
                <a href="#">Next</a>
            </li>
        </ul>
    </div>
</div>
<!-- 分页结束 -->