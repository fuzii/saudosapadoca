<%@ include file="./views/master/master.jsp" %>
<body>
	<div class="container">
		<%@ include file="./views/master/topmenu.jsp" %>
		<%@ include file="./views/controls/accountcontrol.jsp" %>
	</div>
	<script>
		$(function () {
			if(localStorage.getItem('userInfo') != null){
				var userInfo = JSON.parse(localStorage.getItem('userInfo'));
				$('#name').val(userInfo.name);
				$('#email').val(userInfo.email);
			}
		});
	</script>
</body>