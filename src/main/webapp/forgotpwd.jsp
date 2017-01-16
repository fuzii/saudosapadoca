<%@ include file="./views/master/master.jsp" %>
<body>
	<div class="container">
		<%@ include file="./views/master/topmenu.jsp" %>
		<div class="col-sm-12">
			<div style="margin:auto; max-width: 440px;">
				<form method="post" action="">
					<h1><span class="glyphicon glyphicon-lock"></span>Esqueci minha senha</h1>
					<p>Preencha seu email para receber sua nova senha</p>
					<div class="form-group">
						<input class="form-control" type="text" placeholder="Email" />
					</div>
					<div class="form-group">
						<input class="btn btn-success" type="submit" value="Enviar" style="width: 100%" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>