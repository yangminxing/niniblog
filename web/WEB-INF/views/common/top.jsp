<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 导航开始 -->
<div class="row ">
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <!-- 导航栏左侧 开始 -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button> <a class="navbar-brand" href="#">NiniBlog</a>
    </div>
    <!-- 导航栏左侧 结束 -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <!-- 导航栏右侧 开始 -->
      <div  class="navbar-right">
        <form class="navbar-form navbar-left" role="search">
          <div class="input-group">
            <input type="text" class="form-control"  placeholder="" aria-label="...">
									<span class="input-group-btn">
										<button class="btn btn-default" type="button">Search</button>
									  </span>
          </div><!-- /input-group -->
        </form>
        <ul class="nav navbar-nav navbar-left" >
          <li>
            <a href="#" data-toggle="modal" data-target=".login">Log in</a>
          </li>
          <li>
            <a href="#"  data-toggle="modal" data-target=".sign">Sign up</a>
          </li>
          <li>
            <a href="#"></a>
          </li>
        </ul>
      </div>
      <!-- 导航栏右侧 结束 -->
    </div>
  </nav>
</div>
<!-- 导航结束 -->