<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bootstrap 101 Template</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.css" rel="stylesheet">

	<style>
		/* springmvc theme source 改 */
		/* 自适应屏幕 大于1000px时 */
		@media (min-width:1000px)
		{
			.nb_left
			{
				width: 200px;;
			}

			.nb_left_container_desktop
			{
				display: block;
			}

			.nb_left_container_mobile
			{
				display: none;
			}

			.nb_right
			{
				left: 200px;
			}

			.nb_right .navbar-fixed-top
			{
				left:200px;
			}
		}

		/* 自适应屏幕 小于1000px时 */
		@media (max-width:1000px)
		{
			.nb_left
			{
				width: 40px;;
			}

			.nb_left_container_desktop
			{
				display: none;
			}

			.nb_left_container_mobile
			{
				display: block;
			}

			.nb_right
			{
				left: 40px;
			}

			.nb_right .navbar-fixed-top
			{
				left:40px;
			}
		}

		/* 左侧个性栏 */
		.nb_left
		{
			position: fixed;
			top: 0px;;
			bottom:0px;
			left:0px;
			right:0px;
			height: 100%;

			z-index: 1000;
			background-image: url("images/star.jpg");
		}


		.nb_left .nb_left_image
		{

		}

		.nb_left .nb_left_title
		{
			margin-top: 20px;

			color:honeydew;
			font-family: 微软雅黑;


		}

		.nb_left .nb_left_enablehidden {
			height: 150px;

			cursor: pointer;
		}

		.nb_content{
			margin-top:60px;
		}



		.innercenter
		{
			text-align: center;
		}

		.outtercenter
		{
			margin-left: auto;
			margin-right: auto;
		}
		.form-top-left {
			width: 75%; padding-top: 25px; float: left;
		}
		.form-top-left h3 {
		    margin-top: 0px;
		}
		.form-top-left p {
			opacity: 0.8;
		}
		.form-top-right {
			width: 25%; text-align: right; line-height: 100px; padding-top: 5px; font-size: 66px; float: left;
		}
		.sbbtn
		{
			width: 100%;;
		}

	</style>
</head>
<body>
	<!-- 左侧开始 -->
	<div class="nb_left">

		<!-- 桌面版左侧栏 -->
		<div class="container-fluid nb_left_container_desktop">

			<!-- 隐藏左侧栏 触发区域 -->
			<div class="row nb_left_enablehidden">
				<div class="col-md-12">
				</div>
			</div>
			<!-- 图片行 -->
			<div class="row nb_left_image ">
				<div class="col-md-12 innercenter ">
					<img src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/140/140/default.jpg"
						 class="img-circle img-responsive outtercenter" />
				</div>
			</div>
			<!-- 文字行 -->
			<div class="row">
				<div class="col-md-12 nb_left_title innercenter">
					Yangminxing
				</div>
			</div>
			<!-- 图标控制行 -->
			<div class="row">
				<div class="col-md-12 nb_left_title innercenter">
					<i class="fa fa-envelope-o"></i>&nbsp;&nbsp;&nbsp;&nbsp;
					<i class="fa fa-gear"></i>
				</div>
			</div>
		</div>

		<!-- 移动版左侧栏 -->
		<div class="container-fluid nb_left_container_mobile">
			<!-- 图标控制行 -->
			<div class="row">
				<div class="col-md-12 nb_left_title innercenter">
					<i class="fa fa-envelope-o"></i>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 nb_left_title innercenter">
					<i class="fa fa-gear"></i>
				</div>
			</div>
		</div>
	</div>
	<!-- 左侧结束 -->
	<!-- 右侧开始 -->
	<div class="col-xs-10 nb_right">
			<!-- 导航开始 -->
			<%@ include file="common/top.jsp"%>
			<!-- 导航结束 -->
			<!-- 内容主体开始 -->
			<div class="row nb_content " >
				<div class="container-fluid">
					<!-- 排序 -->
					<div class="row text-right col-md-11 outtercenter">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-default"> <!-- active checked -->
								<input type="radio" name="options" id="option1" autocomplete="off"> Title&nbsp;<i class="fa fa-caret-up"></i>
							</label>
							<label class="btn btn-default">
								<input type="radio" name="options" id="option2" autocomplete="off"> View&nbsp;<i class="fa fa-caret-down"></i>
							</label>
							<label class="btn btn-default">
								<input type="radio" name="options" id="option3" autocomplete="off"> Date&nbsp;<i class="fa fa-caret-down"></i>
							</label>
						</div>
					</div>
					<!-- 正文 -->
					<div class="row">
						<div class="col-md-12 column">
							<h2>
								Heading
							</h2>
							<p>
								Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
							</p>
							<p>
								 <a class="btn" href="#">View details »</a>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 column">
							<h2>
								Heading
							</h2>
							<p>
								Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
							</p>
							<p>
								 <a class="btn" href="#">View details »</a>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 column">
							<h2>
								Heading
							</h2>
							<p>
								Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
							</p>
							<p>
								 <a class="btn" href="#">View details »</a>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 column">
							<h2>
								Heading
							</h2>
							<p>
								Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
							</p>
							<p>
								 <a class="btn" href="#">View details »</a>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 column">
							<h2>
								Heading
							</h2>
							<p>
								Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
							</p>
							<p>
								 <a class="btn" href="#">View details »</a>
							</p>
						</div>
					</div>

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
				</div>
			</div>
			<!-- 内容主体结束 -->
    </div>
	<!-- 右侧结束 -->

	<!-- 登陆窗体 开始 -->
	<div class="modal fade login" role="dialog" aria-labelledby="gridSystemModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="gridSystemModalLabel">Login</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-sm-12 form-box">
								<div class="form-top">
									<div class="form-top-left">
										<h3>Login to our site</h3>
										<p>Enter your username and password to log on:</p>
									</div>
									<div class="form-top-right">
										<i class="fa fa-lock"></i>
									</div>
								</div>
								<div class="form-bottom">
									<form role="form" action="" method="post" class="login-form">
										<div class="form-group">
											<label class="sr-only" for="form-username">Username</label>
											<input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username">
										</div>
										<div class="form-group">
											<label class="sr-only" for="form-password">Password</label>
											<input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
										</div>
										<button type="submit" class="btn sbbtn">Login in!</button>
									</form>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 social-login">
								<h3>or login with:</h3>
								<div class="social-login-buttons">
									<a class="btn btn-link-2" href="#">
										<i class="fa fa-qq"></i>&nbsp;QQ&nbsp;
									</a>
									<a class="btn btn-link-2" href="#">
										<i class="fa fa-weibo"></i>&nbsp;WeiBo&nbsp;
									</a>
									<a class="btn btn-link-2" href="#">
										<i class="fa fa-github"></i>&nbsp;GitHub&nbsp;
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- 登陆窗体 结束 -->
	<!-- 注册窗体 开始 -->
	<div class="modal fade sign" role="dialog" aria-labelledby="gridSystemModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="gridSystemModalLabel">Sign up</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-sm-12 form-box">
								<div class="form-top">
									<div class="form-top-left">
										<h3>Welcome to our site</h3>
										<p>Enter your username and password to sign up:</p>
									</div>
									<div class="form-top-right">
										<i class="fa fa-lock"></i>
									</div>
								</div>
								<div class="form-bottom">
									<form role="form" action="" method="post" class="sign-form">
										<div class="form-group">
											<label class="sr-only" for="form-username">Username</label>
											<input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username">
										</div>
										<div class="form-group">
											<label class="sr-only" for="form-password">Password</label>
											<input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
										</div>
										<div class="form-group">
											<label class="sr-only" for="form-password">Repeat Password</label>
											<input type="password" name="form-password" placeholder="Repeat Password..." class="form-password form-control" id="form-password">
										</div>
										<button type="submit" class="btn sbbtn">Sign up!</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- 注册窗体 结束 -->
	<script src="js/plugins/jquery.min.js"></script>
	<script src="js/plugins/bootstrap.min.js"></script>
	<script src="js/connect/ajax.js"></script>
	<script src="js/login/login.js" type="text/javascript"></script>
</body>
</html>