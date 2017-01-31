<%
    String accountJSON = "''";
    if(!session.isNew() && session.getAttribute("account") != null) {
    	accountJSON = formatter.GenerateJSON.GetAccountJSON((model.Account)session.getAttribute("account")).toString(); 
    }
%>
<form method="post" action="addAccount" class="form-horizontal panel panel-primary">
	<div class="panel-heading">
		<h2 class="panel-title">Cadasro de usuário</h2>
	</div>
	<div class="panel-body">
            <input type="hidden" name="id" id="id" />
		<div class="form-group">
			<div class="col-sm-2">
				<label for="name" class="control-label">Nome: </label>
			</div>
			<div class="col-sm-10">
				<input id="name" name="name" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="phone" class="control-label">Telefone: </label>
			</div>
			<div class="col-sm-10">
				<input id="phone" name="phone" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="email" class="control-label">Email: </label>
			</div>
			<div class="col-sm-10">
				<input id="email" name="email" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="password" class="control-label">Senha:</label>
			</div>
			<div class="col-sm-10">
				<input type="password" name="password" class="form-control" id="password" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label for="confirm_password" class="control-label">Confirme Senha:</label>
			</div>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="confirm_password" />
			</div>
		</div>				
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
    $(function () {
        var account = <%= accountJSON %>;
        if(account !== '') {
            $('#id').val(account.id);
            $('#name').val(account.name);
            $('#email').val(account.email);
            $('#email').attr('disabled', '');
            $('#phone').val(account.phone);
        }
    });
</script>