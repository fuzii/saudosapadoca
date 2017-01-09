<div class="form-group">
	<input class="form-control" id="txt_filter_input" onkeyup="filterTable('txt_filter_input','tbl_customers')" placeholder="Pesquisar" />
</div>
<table id="tbl_customers" class="table table-bordered table-hover">
	<thead>
		<tr>
			<th>Cliente</th>
			<th>Valor (R$)</th>
			<th>Data de início</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				Felipe
			</td>
			<td>
				49,90
			</td>
			<td>
				10/10/2016
			</td>
		</tr>
		<tr>
			<td>
				Fuzii
			</td>
			<td>
				1,99
			</td>
			<td>
				10/01/2016
			</td>
		</tr>
		<tr>
			<td>
				Herbert
			</td>
			<td>
				5,00
			</td>
			<td>
				05/06/2010
			</td>
		</tr>
	</tbody>
</table>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="row">
			<div class="col-md-12">
				<h2>Felipe Passos Lorenzetti</h2>
				<p>Endereço</p>
				<p>Contato</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h3>Pedidos</h3>
				<table class="table borderless">
					<thead>
						<tr>
							<th>Pedido</th>
							<th>Valor</th>
							<th>Data</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>000002</td>
							<td>20,00</td>
							<td>10/01/2017</td>
							<td>Provisionar</td>
						</tr>
						<tr>
							<td>000001</td>
							<td>15,00</td>
							<td>20/12/2016</td>
							<td>Faturado</td>
						</tr>
					</tbody>
					<tfoot>
						<tr  style="border-top: 1px solid">
							<td>Total faturado</td>	
							<td colspan="3">15,00</td>
						</tr>
						<tr>
							<td>Total a receber</td>
							<td>20,00</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function filterTable(inputFilterId, tableId) {
		var input, table, tr, td;
		
		input = document.getElementById(inputFilterId);
		table = document.getElementById(tableId);
		tr = table.getElementsByTagName("tr");
		for (var i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td");
			if(td) {
				for(var j = 0; j < td.length; j++) {
					if(td[j].innerHTML.toUpperCase().indexOf(input.value.toUpperCase()) > -1) {
						tr[i].style.display = "";
						break;
					} else if(j === (td.length - 1)) {
						tr[i].style.display = "none";
					}
				}
			}
		}
	}
	
	function sortTable(table, col, reverse) {
		var tb = table.tBodies[0],
			tr = Array.prototype.slice.call(tb.rows, 0),
			i;
		reverse = -((+reverse) || -1);
		tr = tr.sort(function (a, b) {
			return reverse * (a.cells[col].textContent.trim().localeCompare(b.cells[col].textContent.trim()));
		});
		for(i = 0; i < tr.length; i++)
			tb.appendChild(tr[i]);
	}
	
	function makeSortable(table) {
		var th = table.tHead,
			i;
		th && (th = th.rows[0]) && (th = th.cells);
		if(th)
			i = th.length;
		else return;
		while (--i >= 0) (function (i) {
			var dir = 1;
			th[i].addEventListener('click', function () {sortTable(table, i, (dir = 1 - dir))});
			th[i].innerHTML = th[i].innerHTML + ' <span class="glyphicon glyphicon-sort"></span>';
		}(i));
	}
	
	$(function () {
		makeSortable(document.getElementById("tbl_customers"));
	})
</script>