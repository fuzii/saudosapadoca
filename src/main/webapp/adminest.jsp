<%@ include file="./views/master/master.jsp" %>
<body>
	<div class="container">
		<%@ include file="./views/master/topmenu.jsp" %>
		<div class="panel panel-default panel-fade">
			<div class="panel-heading">
				<ul class="panel-title nav nav-tabs nav-justified">
					<li class="active"><a data-toggle="tab" href="#tab_orders">Pedidos</a></li>
					<li><a data-toggle="tab" href="#tab_profile">Cadastro</a></li>
					<li><a data-toggle="tab" href="#tab_customers">Clientes</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<div class="tab-content">
					<div id="tab_orders" class="tab-pane fade in active">
						<%@ include file="./views/controls/orderscontrol.jsp" %>
					</div>
					<div id="tab_profile" class="tab-pane fade">
						<%@ include file="./views/controls/estcontrol.jsp" %>
						<%@ include file="./views/controls/productcontrol.jsp" %>
						<%@ include file="./views/controls/estschedulecontrol.jsp" %>
					</div>
					<div id="tab_customers" class="tab-pane fade">
						<%@ include file="./views/controls/estcustomercontrol.jsp" %>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>