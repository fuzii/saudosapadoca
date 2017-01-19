<%
    String establishmentJSON = "";
    if(!session.isNew() && session.getAttribute("isAuthenticated") != null && (Boolean)session.getAttribute("isAuthenticated")) {
    	//establishmentJSON = formatter.GenerateJSON.GetEstablishmentJSON(establishment); 
    }
%>
<style type="text/css">
	#product_quantity 
	{
		text-align: center;
		width: 15%; 
		display:inline-block;
		transition: background-color 0.1s ease-in-out;
	}
	.colored
	{
		background-color: #e4c916;
	}
</style>
<link href="./css/card-details.css" type="text/css" rel="Stylesheet" />
<div class="col-sm-9">
    <div class="card-details">
        <div class="card-details-image">
            <img src="../../images/images.jpg" />
        </div>
        <div class="card-details-content">
            <h3 id="establishment_alias">TESTE</h3>
            <p id="establishment_address">Rua endere�o, n�mero</p>
        </div>
        <div class="card-details-action">
            <a href="#">LINK</a>
            <a href="#">LINK</a>
        </div>
    </div>
    <div id="planContainer" class="form-group card-details">
        <h3 style="padding-left: 10px">Configure seu plano</h3>
        <input type="hidden" id="monSelected" value="1" />
        <input type="hidden" id="tueSelected" value="1" />
        <input type="hidden" id="wedSelected" value="1" />
        <input type="hidden" id="thuSelected" value="1" />
        <input type="hidden" id="friSelected" value="1" />
        <input type="hidden" id="satSelected" value="1" />
        <input type="hidden" id="sunSelected" value="1" />
       	<div class="card-day-list-group">
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
        			<button id="btn_mon" onclick="btnSelectedList(this);">Segunda</button>
       			</div>
        		<div class="card-day-list-content">
        			<input type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%"  />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%" >Hor�rio<span class="caret"></span></button>
        				<ul class="dropdown-menu monday">
        					
        				</ul>
        			</div>
        		</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button id="btn_tue" onclick="btnSelectedList(this);">Ter�a</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%" >Hor�rio<span class="caret"></span></button>
        				<ul class="dropdown-menu">
        					<li>8:00</li>
        					<li>9:00</li>
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button id="btn_wed" onclick="btnSelectedList(this);">Quarta</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Hor�rio<span class="caret"></span></button>
        				<ul class="dropdown-menu">
        					<li>8:00</li>
        					<li>9:00</li>
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button id="btn_thu" onclick="btnSelectedList(this);">Quinta</button>
   				</div>
       			<div class="card-day-list-content">
       				<input type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Hor�rio<span class="caret"></span></button>
        				<ul class="dropdown-menu">
        					<li>8:00</li>
        					<li>9:00</li>
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button id="btn_fri" onclick="btnSelectedList(this);">Sexta</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" class="form-control quantity" placeholder="Quantidade" style="display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Hor�rio<span class="caret"></span></button>
        				<ul class="dropdown-menu">
        					<li>8:00</li>
        					<li>9:00</li>
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button id="btn_sat" onclick="btnSelectedList(this);">S�bado</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Hor�rio<span class="caret"></span></button>
        				<ul class="dropdown-menu">
        					<li>8:00</li>
        					<li>9:00</li>
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button id="btn_sun" onclick="btnSelectedList(this);">Domingo</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Hor�rio<span class="caret"></span></button>
        				<ul class="dropdown-menu">
        					<li>8:00</li>
        					<li>9:00</li>
        				</ul>
        			</div>
       			</div>
       		</div>
       	</div>
   	</div>
   	<div class="form-group">
		<input type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
	</div>
</div>
<div class="col-xs-3 hidden-xs">
    	<div class="panel panel-default" data-spy="affix" data-offset-top="300">
    		<div class="panel-heading">
    			<h3 class="panel-title"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</h3>
    		</div>
    		<div class="panel-body">
    			<ul class="list-unstyled">
    				<li><div id="product_quantity">0</div><div id="product_name" style="width:45%; display:inline-block"> P�o fran��s</div><div id="product_value" style="text-align: right; display:inline-block; width: 40%">R$ 10,00</div></li>
    			</ul>
    		</div>
    		<div class="panel-footer">
    			<div style="display: inline-block; width: 60%">Total</div>
    			<div id="cart_total" style="display: inline-block; width: 38%; text-align: right"><strong>R$ 0,00</strong></div>
    		</div>
    	</div>
    </div>
<script type="text/javascript">
    //function selected(ctl) {
    //	var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
    //    if ($(ctl).is(':checked')) {
    //        $(ctl).parent().parent().attr('class', 'card-day-selected');
    //        $(ctl).parent().parent().find(':input').removeAttr('disabled');
    //        $('#planContainer').find('#' + selectedID).val('1');
    //    }
    //    else {
    //        $(ctl).parent().parent().attr('class', 'card-day');
    //        $(ctl).parent().parent().find(':input').attr('disabled', '');
    //        $(ctl).removeAttr('disabled');
    //        $('#planContainer').find('#' + selectedID).val('0');
    //    }
    //}
    function btnSelectedList(ctl) {
    	var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
    	if($('#planContainer').find('#' + selectedID).val() == '0') {
    		$(ctl).attr('style','color: #fff; background-color: #499249');
    		$(ctl).parent().parent().find('.card-day-list-content').attr('style','background-color: #5cb85c');
    		$(ctl).parent().parent().find(':input').removeAttr('disabled');
    		$('#planContainer').find('#' + selectedID).val('1');
   		}
    	else{
    		$(ctl).attr('style','color: #000; background-color: rgba(230,230,230,0.5);');
    		$(ctl).parent().attr('style','background-color: rgba(230,230,230,0.5);');
    		$(ctl).parent().parent().find('.card-day-list-content').attr('style','background-color: #fff;');
    		$(ctl).parent().parent().find('.card-day-list-content').find(':input').attr('disabled','');
    		$(ctl).parent().parent().find('.card-day-list-content').find(':input[type=text]').val('');
    		$(ctl).parent().parent().find('.card-day-list-content').find(':input[type=button]').html('Hor�rio<span class="caret"></span>');
    		$('#planContainer').find('#' + selectedID).val('0');
    	}
    		
    }
    $(function() {
    	$('.quantity').keyup(function () {
    		var sum = 0;
    		$('.quantity').each(function(i, ctl) {
    			if(!isNaN(parseInt($(ctl).val())))
        			sum += parseInt($(ctl).val());
        	});
    		$('#product_quantity').html(sum);
    		//calc total
    		var total = sum * parseFloat($('#product_value').html().split(' ')[1]).toFixed(2);
    		$('#cart_total').html('<strong>R$ ' + total.toFixed(2).replace('.',',') + '</strong');
    	});

    	var initDate = new Date();
    	var finishDate = new Date();
    	initDate.setHours(9);
    	initDate.setMinutes(0);
    	finishDate.setHours(18);
    	finishDate.setMinutes(0);
    	
    	var hours = initDate.getHours();
    	while(hours < finishDate.getHours()) {
    		$('.monday').append('<li>'+ hours + ':00</li>');
    		hours++;
    	}
    	
    	$.ajax({
    		url: '/establishments',
    		type: 'get',
    		data: {establishment_id: getUrlVars()['establishment_id']},
    		dataType: 'json',
    		success: function (data) {
    			$("#establishment_alias").html(data.establishment.alias);
    			$("#establishment_address").html(data.address.street + ', ' + data.address.number);
    		},
    		error: function (data) { }
    	});
    	$('input[type=hidden]').each(function (i, ctl) {
    		var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
        	if($('#planContainer').find(selectedID).val() == '1') {
        		$(ctl).attr('style','background-color: green');
       		}
        	else{
        		$(ctl).attr('style','background-color: white');
        	}	
    	});
        $(".dropdown-menu").on('click', 'li', function(){
          $($(this).parent().siblings()[0]).html($(this).text() + '<span class="caret"></span>');
          $($(this).parent().siblings()[0]).val($(this).text());
          //$(".btn:first-child").html($(this).text() + '<span class="caret"></span>');
          //$(".btn:first-child").val($(this).text());
       });
    });
</script>