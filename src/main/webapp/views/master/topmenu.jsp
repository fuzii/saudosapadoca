<style type="text/css">
	div#userAddress
	{
		text-align: center;
		display: inline-block;
		margin: auto;
	}
    ul#menu
    {
        /*border-bottom: 1px #5C87B2 solid;
        padding: 0 0 2px;
        position: relative;
        margin: 0;*/
        text-align: right;
        display: inline;
    }

    ul#menu li
    {
        display: inline;
    }
    .page
    {
        width: 100%;
        margin-left: auto;
        margin-right: auto;
    }
    #menucontainer
    {
        margin-top:20px;
        padding-right: 30px
    }
</style>
<div id="header">
    <div id="menucontainer">
    	<div id="userAddress">
    		<p></p>
    	</div>
        <ul id="menu">              
            <li id="signup"><a href="../signup.jsp" class="btn btn-info"><span class="glyphicon glyphicon-user"></span>
            	<span class="hidden-xs hidden-sm"> Cadastrar</span></a></li>
            <li><a href="../login.jsp" class="btn btn-info"><span class="glyphicon glyphicon-log-in"></span>
            <span id="userName" class="hidden-xs hidden-sm"> Entrar</span></a></li>
        </ul>
    </div>
</div>
<script type="text/javascript">
	Storage.prototype.setObject = function(key, value) {
    	this.setItem(key, JSON.stringify(value));
	}
	
	Storage.prototype.getObject = function(key) {
	    var value = this.getItem(key);
	    return value && JSON.parse(value);
	}
	
	$(function () {
		if(localStorage.userInfo != null) {
			var userInfo = localStorage.getObject('userInfo');
			$('#signup').hide();
			$('#userName').html('Olá ' + userInfo.name + '!');
			$('#userAddress').find('p').html('<span class="glyphicon glyphicon-map-marker"></span> ' + userInfo.street + ', ' + userInfo.number + ' - ' + userInfo.city);
		}
	});
</script>