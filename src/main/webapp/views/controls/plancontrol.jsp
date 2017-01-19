<%
    String establishmentJSON = "";
    if(!session.isNew() && session.getAttribute("isAuthenticated") != null && (Boolean)session.getAttribute("isAuthenticated")) {
    	//establishmentJSON = formatter.GenerateJSON.GetEstablishmentJSON(establishment); 
    }
%>
<style type="text/css">
	div#product_quantity 
	{
            text-align: center;
            width: 15%; 
            display:inline-block;
            transition: background-color 0.1s ease-in-out;
	}
        div#product_price
        {
            text-align: right; 
            display:inline-block; 
            width: 40%
        }
        div#cart_total
        {
            display: inline-block; 
            width: 35%;
            text-align: right;
        }
	.colored
	{
		background-color: #e4c916;
	}
        .affix
        {
            top: 0px;
            width: 19%;
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
            <p id="establishment_address">Rua endereço, número</p>
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
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%" >Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
        				</ul>
        			</div>
        		</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button id="btn_tue" onclick="btnSelectedList(this);">Terça</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%" >Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
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
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
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
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
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
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button id="btn_sat" onclick="btnSelectedList(this);">Sábado</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu saturday">
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
        				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu sunday">
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
    <div class="panel panel-default" data-spy="affix" data-offset-top="65">
            <div class="panel-heading">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</h3>
            </div>
            <div class="panel-body">
                    <ul class="list-unstyled">
                            <li><div id="product_quantity">0</div><div id="product_name" style="width:45%; display:inline-block"> Pão françês</div><div id="product_price">R$ 0,00</div></li>
                    </ul>
            </div>
            <div class="panel-footer">
                    <div style="display: inline-block; width: 60%">Total</div>
                    <div id="cart_total"><strong>R$ 0,00</strong></div>
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
    		$(ctl).parent().parent().find('.card-day-list-content').find(':input[type=button]').html('Horário<span class="caret"></span>');
    		$('#planContainer').find('#' + selectedID).val('0');
    	}
    	calcCart();
    }
    function calcCart()
    {
        var sum = 0;
        $('.quantity').each(function(i, ctl) {
                if(!isNaN(parseInt($(ctl).val())))
                        sum += parseInt($(ctl).val());
        });
        $('#product_quantity').html(sum);
        //calc total
        var total = sum * parseFloat($('#product_price').html().split(' ')[1]).toFixed(2);
        $('#cart_total').html('<strong>R$ ' + total.toFixed(2).replace('.',',') + '</strong');
    }
    $(function() {
    	$('.quantity').keyup(function () {
            calcCart();
    	});
    	$.ajax({
    		url: '/establishments',
    		type: 'get',
    		data: {establishment_id: getUrlVars()['establishment_id']},
    		dataType: 'json',
    		success: function (data) {
                    $("#establishment_alias").html(data.establishment.alias);
                    $("#establishment_address").html(data.address.street + ', ' + data.address.number);
                    $('#product_price').html('R$ ' + parseFloat(data.priceList.price).toFixed(2).replace('.',','));
                    //set hours
                    $.each(data.schedules, function(i, schedule){
                        var initHour = parseInt(schedule.startTime.split(':')[0]);
                        var endHour = parseInt(schedule.endTime.split(':')[0]);
                        var hours = initHour;
                        while(hours < endHour){
                            switch(schedule.dayWeek) {
                                case 'Segunda': $('.weekday').append('<li>'+ hours + ':00</li>'); break;
                                case 'Sábado': $('.saturday').append('<li>'+ hours + ':00</li>'); break;
                                case 'Domingo': $('.sunday').append('<li>'+ hours + ':00</li>'); break;
                            }
                            hours++;
                        }
                    });
    		},
    		error: function (data) { alert("error :" + data.status); }
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