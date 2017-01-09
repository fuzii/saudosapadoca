<%@ include file="./views/master/master.jsp" %>
<body>
	<div class="container">
		<%@ include file="./views/master/topmenu.jsp" %>
		<div class="panel panel-default panel-fade">
			<div class="panel-heading" style="padding-bottom: 0px;">
				<ul class="panel-title nav nav-tabs nav-justified">
					<li class="active"><a data-toggle="tab" href="#tab_plan" style="border-bottom-style: none;">Plano</a></li>
					<li><a data-toggle="tab" href="#tab_account" style="border-bottom-style: none;">Cadastro</a></li>
					<li><a data-toggle="tab" href="#tab_orders" style="border-bottom-style: none;">Pedidos</a></li>
				</ul>
			</div>
			<div class="panel-body">
				<div class="tab-content">
					<div id="tab_plan" class="tab-pane fade in active">
						<%@ include file="./views/controls/plancontrol.jsp" %>
					</div>
					<div id="tab_account" class="tab-pane fade">
						<%@ include file="./views/controls/accountcontrol.jsp" %>
						<%@ include file="./views/controls/accountaddresscontrol.jsp" %>
					</div>
					<div id="tab_orders" class="tab-pane fade">
						<%@ include file="./views/controls/orderscontrol.jsp" %>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>