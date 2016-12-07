<%@ include file="./views/master/master.jsp" %>
<body>
	<style type="text/css">
		p 
		{
			font-size: 1.2em;
		}
		@media screen and (max-width: 768px)
		{
			h1 
			{
				font-size: 1.5em;
			}
			p
			{
				font-size: 1em;
			}
		}
	</style>
	<%@ include file="./views/master/topmenu.jsp" %>
	<div class="container">
		<div class="col-sm-12">
			<div style="margin:auto; max-width: 440px;">
				<form>
					<h1><span class="glyphicon glyphicon-lock"></span>Esqueci minha senha</h1>
					<p>Preencha seu email para enviar sua nova senha</p>
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