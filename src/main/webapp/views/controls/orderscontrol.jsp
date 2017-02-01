<style type="text/css">
	.borderless td, .borderless th {
		border: none !important;
	}
</style>
<table id="tbl_orders" class="table table-bordered table-hover">
    <thead>
        <tr>
            <th>Pedido</th>
            <th>Data</th>
            <th>Valor (R$)</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<div id="order_details" class="panel panel-default" style="display: none;">
	<div class="panel-body">
		<div class="row">
			<div class="col-md-10">
                            <h2>Pedido: <span id="span_order_item_id"></span></h2>
			</div>
			<div class="col-md-2">
                            <p>Status: <strong><span id="span_order_item_status"></span></strong></p>
                            <p>Data: <strong><span id="span_order_item_date"></span></strong></p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table id="tbl_order_item_desc" class="table borderless">
					<thead>
						<tr>
							<th>Produto</th>
							<th>Valor</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
					<tfoot>
                                            <tr>
                                                <td>Total</td>	
                                                <td><span id="span_order_item_total"><span></td>
                                            </tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
    function makeClickable() {
        $('#tbl_orders > tbody > tr').click(
            function () {
                $(this).siblings().removeAttr('class');
                $(this).attr('class','active');
                $('#order_details').fadeOut('fast');
                $.ajax({
                    url: '/getOrderItem',
                    type: 'get',
                    data: {id: $(this).children('td').first().html()},
                    dataType: 'json',
                    success: function (data) {
                        $('#tbl_order_item_desc > tbody').empty();
                        var tr = '<tr><td><span id="span_product_quantity">' + data.orderItem.quantity + '</span><span id="span_product_name"> ' + data.orderItem.product.name + '</span></td><td><span id="span_product_total">' + parseFloat(data.orderItem.price).toFixed(2).replace('.',',') + '</span></td></tr>';
                        $('#tbl_order_item_desc > tbody').append(tr);
                        $('#span_order_item_id').html(data.orderItem.id);
                        $('#span_order_item_status').html(data.orderItem.status);
                        $('#span_order_item_date').html(data.orderItem.deliveryDate);
                        
                        var total = parseFloat(data.orderItem.quantity) * parseFloat(data.orderItem.price);
                        $('#span_order_item_total').html(total.toFixed(2).replace('.',','));

                        $('#order_details').fadeIn('slow');
                    },
                    error: function (data) {}
                });
            }
        );
    }
    
    $(function () {
        $.ajax({
            url: '/getOrdersHistory',
            type: 'get',
            data: null,
            dataType: 'json',
            success: function (data) {
                $.each(data.orders, function(i, order) {
                    $.each(order.orderItems, function(i, orderItem) {
                        var tr_order = '<tr><td>' + orderItem.id + '</td><td>' + orderItem.delivery_date + '</td><td>' + orderItem.price.toFixed(2).replace('.',',') + '</td><td>' + order.status + '</td></tr>';
                        $('#tbl_orders > tbody').append(tr_order);
                    });
                });
                makeClickable();
            },
            error: function (data) {}
        });
    });
</script>