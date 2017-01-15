<link href="./css/card-details.css" type="text/css" rel="Stylesheet" />
<style type="text/css">
    #div_pricelist_message {
        padding: 7px;
    }
</style>
<div class="panel-heading">
	<h3>Configuração de produtos</h3>
</div>
<div class="panel-body">
	<form method="post" onsubmit="submitPriceList(); return false;">
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
                                            <input type="hidden" id="establishment_id" name="establishment_id" />
                                            <input type="hidden" id="product_id" name="product_id" />
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
						<input name="price" id="price" type="text" class="form-control" placeholder="por unidade" />
					</td>
				</tr>
			</tbody>
			</table>
			<div class="form-group">
				<input type="submit" id="btn_addpricelist" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
                                <div id="div_pricelist_message" style="display: none;">
                                </div>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
    function PriceList(obj) {
        this.establishment_id = obj && obj.establishmentId;
        this.product_id = obj && obj.productId;
        this.price = obj && obj.price;
        this.unit = obj && obj.unit;
        this.setValues = function (product_id, price, unit) {
            this.product_id = product_id;
            this.price = price;
            this.unit = unit;
        };
    }

    var priceList = new PriceList(<%= formatter.GenerateJSON.GetPriceListJSON(((model.PriceList)session.getAttribute("priceList"))) %>);
    $(function () {
        //set values
        //set pricelist
        $("#establishment_id").val(priceList.establishmentId);
        $("#product_id").val(priceList.productId);
        $("#price").val(priceList.price);
        $("#unit").val(priceList.unit);
        $('#unit').html(priceList.unit + '<span class="caret"></span>');

        $(".dropdown-menu").on('click', 'li', function(){
          $($(this).parent().siblings()[0]).html($(this).text() + '<span class="caret"></span>');
          $($(this).parent().siblings()[0]).val($(this).text());
       });
    });

    function submitPriceList(e){
        priceList.setValues($('#product_id').val(), $('#price').val(), $('#unit').val());
        $('#btn_addpricelist').attr('class', 'btn btn-default disabled');
        $('#div_pricelist_message').css('display', 'none');
        $.ajax({
                type: 'POST',
                url: '/addPriceList',
                data: priceList,
                dataType: 'json',
                success: function (data) { 
                    $('#btn_addpricelist').attr('class', 'btn btn-success'); 
                    $('#div_pricelist_message').attr('class', 'alert alert-success');
                    $('#div_pricelist_message').html('Alterado com sucesso!');
                    $('#div_pricelist_message').css('display', 'inline-block');
                },
                error: function(data) { 
                $('#btn_addpricelist').attr('class', 'btn btn-success');
                    $('#btn_addpricelist').attr('class', 'btn btn-success'); 
                    $('#div_pricelist_message').attr('class', 'alert alert-danger');
                    $('#div_pricelist_message').html('Erro ' + data.status);
                    $('#div_pricelist_message').css('display', 'inline-block');
                }
        });
    }
</script>