<%@ include file="./Views/Master/master.jsp" %>
<div class="container">
	<h1 class="panel-title hidden">Cadasro de usuário</h1>
	<form class="form-horizontal panel panel-primary">
		<div class="panel-heading">
			<h2 class="panel-title">Cadasro de usuário</h2>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-2">
					<label for="name" class="control-label">Nome: </label>
				</div>
				<div class="col-sm-10">
					<input id="name" class="form-control" type="text" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-2">
					<label for="email" class="control-label">Email: </label>
				</div>
				<div class="col-sm-10">
					<input id="email" class="form-control" type="text" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-2">
					<label for="password" class="control-label">Senha:</label>
				</div>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" />
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
	<form class="form-horizontal panel panel-primary">
		<div class="panel-heading">
			<h2 class="panel-title">Endereço</h2>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<div class="col-sm-2">
					<label for="CEP" class="control-label">CEP: </label>
				</div>
				<div class="col-sm-3">
					<input id="CEP" type="text" class="form-control" maxlength="9" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="text" class="form-control" id="uf" placeholder="UF" disabled style="width:25%; display:inline"/>
					<input type="text" class="form-control" id="cidade" placeholder="Cidade" disabled style="width:74%; display:inline" />
					<input type="text" class="form-control" id="logradouro" placeholder="Rua, Avenida, etc" disabled style="width:74%; display:inline" />
					<input type="text" class="form-control" id="numero" placeholder="Nº" style="width:25%; display:inline" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
				</div>
			</div>
		</div>
	</form>
</div>