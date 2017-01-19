<style type="text/css">
	div#userAddress
	{
		text-align: center;
		float: left;
		margin: auto;
	}
    ul#menu
    {
        /*border-bottom: 1px #5C87B2 solid;
        padding: 0 0 2px;
        position: relative;
        margin: 0;*/
        float: right;
    }
    ul#menu li
    {
        display: inline;
        margin-left: 10px;
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
    }
    .menucontainer
    {
        margin-top:20px;
    }
    .animate 
    {
            /*-webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            -ms-transition: all 0.3s ease-in-out;*/
            transition: all 0.3s ease-in-out;
    }
    .navbar-fixed-left {
            /*position: fixed;*/
            top: 0px;
            left: 0px;
            border-radius: 0px;
    }
    .navbar-minimal {
            width: 60px;		
            min-height: 60px;
            max-height: 100%;
            background-color: rgba(51, 51, 51, 0.9);
            border-width: 0px;
            z-index: 1000;
    }
    .navbar-minimal > .navbar-toggler {
            position: relative;
            min-height: 60px;
            border-bottom: 1px solid rgb(81, 81, 81);
            z-index: 100;
            cursor: pointer;
    }
    .navbar-minimal.open > .navbar-toggler,
    .navbar-minimal > .navbar-toggler:hover {
            background-color: #31b0d5;
    }
    .navbar-minimal > .navbar-toggler > span {
            background-image: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE2LjIuMSwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPgo8IURPQ1RZUEUgc3ZnIFBVQkxJQyAiLS8vVzNDLy9EVEQgU1ZHIDEuMS8vRU4iICJodHRwOi8vd3d3LnczLm9yZy9HcmFwaGljcy9TVkcvMS4xL0RURC9zdmcxMS5kdGQiPgo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IkxheWVyXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IgoJIHdpZHRoPSIxNnB4IiBoZWlnaHQ9IjMycHgiIHZpZXdCb3g9IjAgMCAxNiAzMiIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAwIDAgMTYgMzIiIHhtbDpzcGFjZT0icHJlc2VydmUiPgo8cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGNsaXAtcnVsZT0iZXZlbm9kZCIgZmlsbD0iI0ZGRkZGRiIgZD0iTTEsN2gxNGMwLjU1MiwwLDEsMC40NDgsMSwxcy0wLjQ0OCwxLTEsMUgxQzAuNDQ4LDksMCw4LjU1MiwwLDgKCVMwLjQ0OCw3LDEsN3oiLz4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGZpbGw9IiNGRkZGRkYiIGQ9Ik0xLDEyaDE0YzAuNTUyLDAsMSwwLjQ0OCwxLDFzLTAuNDQ4LDEtMSwxSDFjLTAuNTUyLDAtMS0wLjQ0OC0xLTEKCVMwLjQ0OCwxMiwxLDEyeiIvPgo8cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGNsaXAtcnVsZT0iZXZlbm9kZCIgZmlsbD0iI0ZGRkZGRiIgZD0iTTEsMmgxNGMwLjU1MiwwLDEsMC40NDgsMSwxcy0wLjQ0OCwxLTEsMUgxQzAuNDQ4LDQsMCwzLjU1MiwwLDMKCVMwLjQ0OCwyLDEsMnoiLz4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGZpbGw9IiNGRkZGRkYiIGQ9Ik0xLjMzLDI4Ljk3bDExLjY0LTExLjY0YzAuNDU5LTAuNDU5LDEuMjA0LTAuNDU5LDEuNjYzLDAKCWMwLjQ1OSwwLjQ1OSwwLjQ1OSwxLjIwNCwwLDEuNjYzTDIuOTkzLDMwLjYzM2MtMC40NTksMC40NTktMS4yMDQsMC40NTktMS42NjMsMEMwLjg3MSwzMC4xNzQsMC44NzEsMjkuNDMsMS4zMywyOC45N3oiLz4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGZpbGw9IiNGRkZGRkYiIGQ9Ik0yLjk5MywxNy4zM2wxMS42NDEsMTEuNjRjMC40NTksMC40NTksMC40NTksMS4yMDQsMCwxLjY2MwoJcy0xLjIwNCwwLjQ1OS0xLjY2MywwTDEuMzMsMTguOTkzYy0wLjQ1OS0wLjQ1OS0wLjQ1OS0xLjIwNCwwLTEuNjYzQzEuNzg5LDE2Ljg3MSwyLjUzNCwxNi44NzEsMi45OTMsMTcuMzN6Ii8+Cjwvc3ZnPgo=);
            background-repeat: no-repeat;
            background-position: 0 0;

            position: absolute;
            top: 50%;
            right: 50%;
            margin: -8px -8px 0 0;
            width: 16px;
            height: 16px;
            /*-webkit-transition: -webkit-transform .3s ease-out 0s;
            -moz-transition: -moz-transform .3s ease-out 0s;
            -o-transition: -moz-transform .3s ease-out 0s;
            -ms-transition: -ms-transform .3s ease-out 0s;*/
            transition: transform .3s ease-out 0s;
            /*-webkit-transform: rotate(0deg);
            -moz-transform: rotate(0deg);
            -o-transform: rotate(0deg);
            -ms-transform: rotate(0deg);*/
            transform: rotate(0deg);
    }
    .navbar-minimal > .navbar-menu {
            position: absolute;
            /*top: -1000px;*/
            visibility: hidden;
            opacity: 0;
            width: 16px;
            left: 0px;
            margin: 0px;
            padding: 0px;
            list-style: none;
            z-index: 50;
            background-color: rgba(51, 51, 51, 0.9);
    }
    .navbar-minimal > .navbar-menu > li {
            margin: 0px;
            padding: 0px;
            border-width: 0px;
            height: 54px;
    }
    .navbar-minimal > .navbar-menu > li > a {
            white-space: nowrap;
            text-overflow: ellipsis;
            position: relative;
            display: inline-block;
            color: rgb(255, 255, 255);
            padding: 20px 23px;
            text-align: left;
            cursor: pointer;
            border-bottom: 1px solid rgb(81, 81, 81);
            width: 100%;
            text-decoration: none;
            margin: 0px;
    }
    .navbar-minimal > .navbar-menu > li > a:last-child {
            border-bottom-width: 0px;
    }
    .navbar-minimal > .navbar-menu > li > a:hover {
            background-color: #31b0d5;
    }
    .navbar-minimal > .navbar-menu > li > a > .glyphicon {
            float: right;
    }
    .navbar-minimal.open {
            width: 320px;
    }
    .navbar-minimal.open > .navbar-toggler > span {
            background-position: 0 -16px;
            /*-webkit-transform: rotate(-180deg);
            -moz-transform: rotate(-180deg);
            -o-transform: rotate(-180deg);
            -ms-transform: rotate(-180deg);*/
            transform: rotate(-180deg);
    }
    .navbar-minimal.open > .navbar-menu {
            visibility: visible;
            opacity: 1;
            /*top: 60px;*/
            width: 100%;
            min-height: 100%;
    }
    /*@media (min-width: 768px) {
        .navbar-minimal.open {
                width: 60px;
        }
        .navbar-minimal.open > .navbar-menu {
                overflow: visible;
        }
        .navbar-minimal > .navbar-menu > li > a > .desc {
                position: absolute;
                display: inline-block;
                top: 50%;
                left: 130px;
                margin-top: -20px;
                margin-left: 20px;
                text-align: left;
                white-space: nowrap;
                padding: 10px 13px;
                border-width: 0px !important;
                background-color: rgba(51, 51, 51, 0.9);
                opacity: 0;
        }
        .navbar-minimal > .navbar-menu > li > a > .desc:after {
                z-index: -1;
                position: absolute;
                top: 50%;
                left: -10px;
                margin-top: -10px;
                content:'';
                width: 0;
                height: 0;
                border-top: 10px solid transparent;
                border-bottom: 10px solid transparent; 	
                border-right: 10px solid rgb(51, 51, 51);
                border-right-color: rgba(51, 51, 51, 0.9);
        }
        .navbar-minimal > .navbar-menu > li > a:hover > .desc {
                left: 60px;
                opacity: 1;
        }
    }*/
</style>
<section class="clearfix hidden-sm hidden-xs">
    <div id="header">
        <div id="menucontainer">
            <div id="userAddress" style="display: none;">
                    <p style="display: inline-block;"></p>
                    <a href="home.jsp?toHome=1">Alterar endereço</a>
            </div>
            <ul id="menu">
                <li id="signupest"><a href="../signupest.jsp">Cadastre sua padaria<span clas="glyphicon glyphicon-grain"></span></a>
                <li id="signup"><a href="../signup.jsp" class="btn btn-info"><span class="glyphicon glyphicon-user"></span>
                <li><a id="userName" href="../login.jsp" class="btn btn-info"><span class="glyphicon glyphicon-log-in"></span> Entrar</a></li>
            </ul>
        </div>
    </div>
</section>
<nav class="navbar navbar-fixed-left navbar-minimal animate hidden-lg hidden-md" role="navigation">
	<div class="navbar-toggler animate">
		<span class="menu-icon"></span>
		<span class="sr-only">Menu</span>
	</div>
	<ul class="navbar-menu animate">
            <li><a id="userName" href="../login.jsp" class="animate">
                    <span class="desc animate">Entrar</span>
                    <span class="glyphicon glyphicon-log-in"></span>
                </a>
            </li>
            <li id="signupest">
                <a href="../signupest.jsp" class="animate">
                    <span class="desc animate">Cadastre sua padaria</span>
                    <span class="glyphicon glyphicon-grain"></span>
                </a>
            </li>
            <li id="signup">
                <a href="../signup.jsp" class="animate">
                    <span class="desc animate">Cadastrar</span>
                    <span class="glyphicon glyphicon-user"></span>
                </a>
            </li>
	</ul>
</nav>
<script type="text/javascript">
	Storage.prototype.setObject = function(key, value) {
    	this.setItem(key, JSON.stringify(value));
	};
	
	Storage.prototype.getObject = function(key) {
	    var value = this.getItem(key);
	    return value && JSON.parse(value);
	};
	
	function showAddress() {
		if(localStorage.getItem('userInfo') != null) {
			var userInfo = localStorage.getObject('userInfo');
			$('#userName').html('Olá ' + userInfo.name + '!');
			$('#userAddress').show();
			$('#userAddress').find('p').html('<span class="glyphicon glyphicon-map-marker"></span> ' + userInfo.street + ', ' + userInfo.number + ' - ' + userInfo.city);
			if($('#searchAddress') != null) {
				$('#searchAddress').hide();
				$('#signup').hide();
			}
		}
	}
	
	function getUrlVars()
	{
	    var vars = [], hash;
	    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
	    for(var i = 0; i < hashes.length; i++)
	    {
	        hash = hashes[i].split('=');
	        vars.push(hash[0]);
	        vars[hash[0]] = hash[1];
	    }
	    return vars;
	}
	
	$(function () {
		$('.navbar-toggler').on('click', function(event) {
			event.preventDefault();
			$(this).closest('.navbar-minimal').toggleClass('open');
		})
		
		if(getUrlVars()['toHome'] == 1) {
			localStorage.removeItem('userInfo');
		}
		else {
			showAddress();
		}
	});
</script>