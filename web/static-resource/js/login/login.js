
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
   // $.backstretch("../../static-resource/images/login.jpg");
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    });

	/**
	 * 注册事件
	 */
	$('.sign-form').on('submit',function(e){
		$.ajax({
			cache: true,
			type: "POST",
			url:"/register",
			data:$('.sign-form').serialize(),
			async: false,
			success: function(data) {
				//$("#commonLayout_appcreshi").parent().html(data);
			},
			error: function(request) {
				//alert("Connection error");
			}
		});
	});
    
});


jQuery(document).ready(function() {


});

function login()
{
	//success

	//failed
}

function register()
{
	//success

	//failed
}

