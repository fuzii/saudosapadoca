<%@ include file="./views/master/master.jsp" %>
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
			<div class="panel form-login">
				<div class="panel-heading">
					<h1>Login</h1>
				</div>
				<div class="panel-body">
					<form action="post" onsubmit="submitForm(); return false;" class="form">
                                                <div id="error_message" class="alert alert-danger" style="display: none;">
                                                    <p>Senha invalida!</p>
                                                </div>
						<div class="form-group">
							<input type="text" class="form-control form-group" id="login" name="login" placeholder="email" />
							<input type="password" class="form-control form-group" id="password" name="password" placeholder="senha" />
							<input type="submit" id="btn_login" class="btn btn-success" value="Entrar" style="width: 150px" />
						</div>
						<div class="form-group col-sm-6 checkbox">
							<label for="remember_me">
								<input type="checkbox" id="remember_me" title="Manter-me conectado" />
							Manter-me conectado</label>
						</div>
						<div class="form-group col-sm-6" style="margin-top: 10px">
							<a href="forgotpwd.jsp">Esqueci minha senha</a>
						</div>
					</form>
				</div>
				<div class="panel-footer">
					<form action="signup.jsp">
						<div class="form-group">
							<p>Não possui cadastro?</p>
							<input type="submit" class="btn btn-default" value="Cadastrar" style="width: 150px;" />
						</div>
					</form>
				</div>
			</div>
	</div>
        <script type="text/javascript">
            function submitForm()
            {
                $("#error_message").hide();
                $('#btn_login').attr('class','btn btn-default disabled');
                $.ajax({
                   type: "POST",
                   url: "/login",
                   data: {login: $("#login").val(), password: $("#password").val()},
                   dataType: "html",
                   success: function(data) { callback_success(data) },
                   error: function (data) { callback_error(data); }
                });
            }
            function callback_success(data) {
                window.location.href = '/home.jsp';
            }
            function callback_error(data)
            {
                if(data.status === 401) {
                    $("#error_message").val("Senha inválida.");
                }
                else {
                    $("#error_message").val("Erro no servidor: " + data.status);
                }
                $("#error_message").show();
                $('#btn_login').attr('class','btn btn-success');
            }
        </script>
</body>