<%@ include file="./Views/Master/master.jsp" %>
<body>
	<style type="text/css">
		.form-login
		{
			width: 100%;
			max-width: 440px;
			text-align: center;
			margin: auto;
		}
	</style>
	<div class="container">
		<form class="form form-login">
			<div class="panel">
				<div class="panel-heading">
					<h1>Login</h1>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<input type="text" class="form-control form-group" id="email" placeholder="email" />
						<input type="text" class="form-control form-group" id="pwd" placeholder="senha" />
						<input type="submit" class="btn btn-success" value="Entrar" style="width: 150px" />
					</div>
					<div class="form-group col-sm-6 checkbox">
						<label for="remember_me">
							<input type="checkbox" id="remember_me" title="Manter-me conectado" />
						Manter-me conectado</label>
					</div>
					<div class="form-group col-sm-6" style="margin-top: 10px">
						<a href="#">Esqueci minha senha</a>
					</div>
				</div>
				<div class="panel-footer">
					<div class="form-group">
						<p>Não possui cadastro?</p>
						<input type="submit" class="btn btn-default" value="Cadastrar" style="width: 150px;" />
					</div>
				</div>
			</div>
		</form>
	</div>
</body>