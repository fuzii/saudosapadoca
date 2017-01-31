<% 
    String addressJSON = "''";
    if(!session.isNew() && session.getAttribute("address") != null && ((java.util.List<model.Address>)session.getAttribute("address")).size() > 0) {
        addressJSON = formatter.GenerateJSON.GetAddressJSON(((java.util.List<model.Address>)session.getAttribute("address")).get(0)).toString();
    }
%>
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
				<input id="CEP" name="zipCode" type="text" class="form-control" maxlength="9" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2">
				<label class="control-label">Endereço: </label>
			</div>
			<div class="col-sm-10">
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
<script type="text/javascript">	
    function searchCEP()
    {
        $.getJSON('http://api.postmon.com.br/v1/cep/' + $('#CEP').val(), function (data) {
            $('#uf').val(data.estado);
            $('#cidade').val(data.cidade);
            $('#logradouro').val(data.logradouro);
            $('#bairro').val(data.bairro);
        });
    }
    $(function () {
        jQuery("#CEP").mask("99999-999");
        $("#CEP").focusout(searchCEP);
        //load page
        var address = '';
        if(address !== '') {
            $('#CEP').val(address.zipCode);
            $('#uf').val(address.state);
            $('#cidade').val(address.city);
            $('#logradouro').val(address.street);
            $('#numero').val(address.number);
        }
    });
</script>