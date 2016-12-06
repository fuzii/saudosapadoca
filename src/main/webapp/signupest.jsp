<%@ include file="./Views/Master/Master.jsp" %>
<body>
	<div class="container">
		<form class="form-horizontal panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">Cadastro do estabelecimento</h1>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">Dados do estabelecimento</h2>
							</div>
							<div class="panel-body">
								<div class="form-group col-sm-offset-1 col-sm-11">
									<input id="est_name" placeholder="Nome" class="form-control" type="text" />
								</div>
								<div class="form-group col-sm-offset-1 col-sm-11">
									<input id="cnpj" placeholder="CNPJ" class="form-control" type="text" />
								</div>
								<div class="form-group col-sm-offset-1 col-sm-11">
									<input id="contact_phone" placeholder="Telefone de contato" class="form-control" type="text" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">Contato do representante legal</h2>
							</div>
							<div class="panel-body">
								<div class="form-group col-sm-offset-1 col-sm-11">
									<input id="rep_name" placeholder="Nome completo do representante" class="form-control" type="text" />
								</div>
								<div class="form-group col-sm-offset-1 col-sm-11">
									<input id="rep_email" placeholder="Email do representante" class="form-control" type="text" />
								</div>
								<div class="form-group col-sm-offset-1 col-sm-11">
									<input id="rep_contact_phone" placeholder="Telefone de contato" class="form-control" type="text" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">Endereço do estabelecimento</h2>
							</div>
							<div class="panel-body">
								<div class="form-group col-sm-3">
									<input id="est_CEP" type="text" class="form-control" placeholder="CEP" maxlength="9" />
								</div>
								<div class="form-group">
									<div class="col-sm-11">
										<input type="text" class="form-control" id="uf" placeholder="UF" disabled style="width:25%; display:inline"/>
										<input type="text" class="form-control" id="cidade" placeholder="Cidade" disabled style="width:74%; display:inline" />
										<input type="text" class="form-control" id="logradouro" placeholder="Rua, Avenida, etc" disabled style="width:74%; display:inline" />
										<input type="text" class="form-control" id="numero" placeholder="Nº" style="width:25%; display:inline" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 panel">
						<div class="form-group panel-body">
							<input type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>