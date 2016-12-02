<%@ include file="./Views/Master/master.jsp" %>
<%@ include file="./Views/Master/header.jsp" %>
<link href="./CSS/card-details.css" type="text/css" rel="Stylesheet" />
<div class="container">
        <div class="col-sm-9">
            <div class="card-details">
                <div class="card-details-image">
                    <img src="./Images/images.jpg" />
                </div>
                <div class="card-details-content">
                    <h3>TESTE</h3>
                </div>
                <div class="card-details-action">
                    <a href="#">LINK</a>
                    <a href="#">LINK</a>
                </div>
            </div>
            <div class="card-details">
                <h3 style="padding-left: 10px">Configure seu plano</h3>
                <!-- xs sm md lg -->
                <div class="card-day-container hidden-xs hidden-sm">
                	<div class="row">
                		<div class="card-day">
	                        <label class="checkbox-inline"><input type="checkbox" value="" onclick="selected(this);" />Segunda</label>
	                        <input type="text" class="form-control" placeholder="Quantidade" disabled />
	                        <div class="btn-group" style="width:100%">
	                            <button id="Horario_Segunda" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
	                            <ul class="dropdown-menu">
	                                <li>08:00</li>
	                                <li>09:00</li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="card-day">
	                        <label class="checkbox-inline"><input type="checkbox" value="" onclick="selected(this);" />Terça</label>
	                        <input type="text" class="form-control" placeholder="Quantidade" disabled />
	                        <div class="btn-group" style="width:100%">
	                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
	                            <ul class="dropdown-menu">
	                                <li>08:00</li>
	                                <li>08:00</li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="card-day">
	                        <label class="checkbox-inline"><input type="checkbox" value="" onclick="selected(this);" />Quarta</label>
	                        <input type="text" class="form-control" placeholder="Quantidade" disabled />
	                        <div class="btn-group" style="width:100%">
	                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
	                            <ul class="dropdown-menu">
	                                <li>08:00</li>
	                                <li>08:00</li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="card-day">
	                        <label class="checkbox-inline"><input type="checkbox" value="" onclick="selected(this);" />Quinta</label>
	                        <input type="text" class="form-control" placeholder="Quantidade" disabled />
	                        <div class="btn-group" style="width:100%">
	                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
	                            <ul class="dropdown-menu">
	                                <li>08:00</li>
	                                <li>08:00</li>
	                            </ul>
	                        </div>
	                    </div>
                	</div>
                    <div class="row">
	                    <div class="card-day">
	                        <label class="checkbox-inline"><input type="checkbox" value="" onclick="selected(this);" />Sexta</label>
	                        <input type="text" class="form-control" placeholder="Quantidade" disabled />
	                        <div class="btn-group" style="width:100%">
	                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
	                            <ul class="dropdown-menu">
	                                <li>08:00</li>
	                                <li>08:00</li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="card-day">
	                        <label class="checkbox-inline"><input type="checkbox" value="" onclick="selected(this);" />Sábado</label>
	                        <input type="text" class="form-control" placeholder="Quantidade" disabled />
	                        <div class="btn-group" style="width:100%">
	                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
	                            <ul class="dropdown-menu">
	                                <li>08:00</li>
	                                <li>08:00</li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="card-day">
	                        <label class="checkbox-inline"><input type="checkbox" value="" onclick="selected(this);" />Domingo</label>
	                        <input type="text" class="form-control" placeholder="Quantidade" disabled />
	                        <div class="btn-group" style="width:100%">
	                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Horário<span class="caret"></span></button>
	                            <ul class="dropdown-menu">
	                                <li>08:00</li>
	                                <li>08:00</li>
	                            </ul>
	                        </div>
	                    </div>
                    </div>
                </div>
                <!-- xs sm -->
                <div class="hidden-md hidden-lg" style="margin: 10px">
                	<ul class="list-group">
                		<li class="list-group-item">
                			<div class="row">
                				<div class="col-xs-10">
                					<div class="input-group" style="display: inline;">
	                					<input type="text" class="form-control" placeholder="Quantidade" style="width: 40%; display: inline; margin-right: 10px" />
			                			<div class="btn-group" style="display: inline;">
				                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled style="width: 40%">Horário<span class="caret"></span></button>
				                            <ul class="dropdown-menu">
				                                <li>08:00</li>
				                                <li>08:00</li>
				                            </ul>
				                        </div>
		                        	</div>
                				</div>
		                        <div class="col-xs-2" style="border-left: solid 1px">
		                        	<p>Segunda</p>
		                        </div>
	                        </div>
                		</li>
                		<li class="list-group-item">
                			Terça
                		</li>
                		<li class="list-group-item">Quarta</li>
                		<li class="list-group-item">Quinta</li>
                		<li class="list-group-item">Sexta</li>
                		<li class="list-group-item">Sábado</li>
                		<li class="list-group-item">Domingo</li>
                		
                	</ul>
                </div>
            </div>            
        </div>
        <div class="col-xs-3 hidden-xs">
            	<div class="panel panel-default" data-spy="affix" data-offset-top="300">
            		<div class="panel-heading">
            			<h3 class="panel-title"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</h3>
            		</div>
            		<div class="panel-body">
            			<ul class="list-unstyled">
            				<li><span>1</span><span>Pão françês</span><span>R$ 50,00</span></li>
            			</ul>
            		</div>
            		<div class="panel-footer">
            			<span>SubTotal</span>
            			<span><strong>R$ 50,00</strong></span>
            		</div>
            	</div>
            </div>
</div>
<script type="text/javascript">
    function selected(ctl) {
        if ($(ctl).is(':checked')) {
            $(ctl).parent().parent().attr('class', 'card-day-selected');
            $(ctl).parent().parent().find(':input').removeAttr('disabled');
        }
        else {
            $(ctl).parent().parent().attr('class', 'card-day');
            $(ctl).parent().parent().find(':input').attr('disabled', '');
            $(ctl).removeAttr('disabled');
        }
    }
    $(function(){
        $(".dropdown-menu").on('click', 'li', function(){
          $($(this).parent().siblings()[0]).html($(this).text() + '<span class="caret"></span>');
          $($(this).parent().siblings()[0]).val($(this).text());
          //$(".btn:first-child").html($(this).text() + '<span class="caret"></span>');
          //$(".btn:first-child").val($(this).text());
       });

    });
</script>