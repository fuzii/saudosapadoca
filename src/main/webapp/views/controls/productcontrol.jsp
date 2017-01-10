<link href="./css/card-details.css" type="text/css" rel="Stylesheet" />
<div class="panel-heading">
	<h3>Configuração de produtos</h3>
</div>
<div class="panel-body">
	<form method="post" onsubmit="submitProduct();">
		<div class="form-group">
			<table class="table table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Unidade</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
                                            <input type="hidden" id="product_id" name="product_id" value="1" />
						Pão françes
					</td>
					<td>
						<div class="btn-group">
							<button id="unit" name="unit" value="Unidade" class="btn dropdown-toggle" data-toggle="dropdown" type="button">Unidade<span class="caret"></span></button>
							<ul class="dropdown-menu">
								<li>Kg</li>
								<li>Unidade</li>
								<li>Litro</li>
							</ul>
						</div>
					</td>
					<td>
						<input name="unitvalue" id="unitvalue" type="text" class="form-control" placeholder="por unidade" />
					</td>
				</tr>
			</tbody>
			</table>
			<div class="form-group">
				<input type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(function () {
		$(".dropdown-menu").on('click', 'li', function(){
	          $($(this).parent().siblings()[0]).html($(this).text() + '<span class="caret"></span>');
	          $($(this).parent().siblings()[0]).val($(this).text());
	       });
	});
	
	function submitProduct(){
		$.ajax({
			type: "POST",
			url: "/addPriceList",
			data: {product_id: $("#product_id").val(), unit: $("#unit").val(), price: $("#unitvalue").val() },
			dataType: "json",
			succes: function (data) { },
			error: function(data ) { }
		});
		return false;
	}
</script>