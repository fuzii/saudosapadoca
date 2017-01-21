<%
    String orderJSON = "''";
    if(!session.isNew() && session.getAttribute("order") != null) {
    	orderJSON = formatter.GenerateJSON.GetOrderJSON((model.Order)session.getAttribute("order")).toString(); 
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
            <img id="establishment_photo" src="../../images/images.jpg" />
        </div>
        <div class="card-details-content">
            <h3 id="establishment_alias">NOME</h3>
            <p id="establishment_address">Rua endereço, número</p>
        </div>
        <div class="card-details-action">
            <a href="#">LINK</a>
            <a href="#">LINK</a>
        </div>
    </div>
    <form type="post" onsubmit="submitOrder(); return false;">
    <div id="planContainer" class="form-group card-details">
        <h3 style="padding-left: 10px">Configure seu plano</h3>
        <input type="hidden" name="establishment_id" id="establishment_id" />
        <input type="hidden" name="product_id" id="product_id" value="1" />
        <input type="hidden" id="monSelected" value="0" />
        <input type="hidden" id="tueSelected" value="0" />
        <input type="hidden" id="wedSelected" value="0" />
        <input type="hidden" id="thuSelected" value="0" />
        <input type="hidden" id="friSelected" value="0" />
        <input type="hidden" id="satSelected" value="0" />
        <input type="hidden" id="sunSelected" value="0" />
       	<div class="card-day-list-group">
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
        			<button type="button" id="btn_mon" class="btn btn-week" onclick="btnSelectedList(this);">Segunda</button>
       			</div>
        		<div class="card-day-list-content">
        			<input type="text" name="monday_amount" id="monday_amount" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%"  />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" name="monday_time" id="monday_time" type="button" data-toggle="dropdown" style="width: 100%" >Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
        				</ul>
        			</div>
        		</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
                            <button type="button" id="btn_tue" class="btn btn-week" onclick="btnSelectedList(this);">Terça</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" name="tuesday_amount" id="tuesday_amount" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" name="tuesday_time" id="tuesday_time" type="button" data-toggle="dropdown" style="width: 100%" >Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button type="button" id="btn_wed" class="btn btn-week" onclick="btnSelectedList(this);">Quarta</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" name="wednesday_amount" id="wednesday_amount" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" name="wednesday_time" id="wednesday_time" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button type="button" id="btn_thu" class="btn btn-week" onclick="btnSelectedList(this);">Quinta</button>
   				</div>
       			<div class="card-day-list-content">
       				<input name="thursday_amount" id="thursday_amount" type="text" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" name="thursday_time" id="thursday_time" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button type="button" id="btn_fri" class="btn btn-week" onclick="btnSelectedList(this);">Sexta</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" name="friday_amount" id="friday_amount" class="form-control quantity" placeholder="Quantidade" style="display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" name="friday_time" id="friday_time" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu weekday">
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button type="button" id="btn_sat" class="btn btn-weekend" onclick="btnSelectedList(this);">Sábado</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" name="saturday_amount" id="saturday_amount" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" name="saturday_time" id="saturday_time" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu saturday">
        				</ul>
        			</div>
       			</div>
       		</div>
       		<div class="card-day-list-item">
       			<div class="card-day-list-btn">
       				<button type="button" id="btn_sun" class="btn btn-weekend" onclick="btnSelectedList(this);">Domingo</button>
       			</div>
       			<div class="card-day-list-content">
       				<input type="text" name="sunday_amount" id="sunday_amount" class="form-control quantity" placeholder="Quantidade" style=" display: inline; width: 48%" />
        			<div class="btn-group" style="width: 50%; display: inline; float: right">
        				<button class="btn btn-default dropdown-toggle" name="sunday_time" id="sunday_time" type="button" data-toggle="dropdown" style="width: 100%">Horário<span class="caret"></span></button>
        				<ul class="dropdown-menu sunday">
        				</ul>
        			</div>
       			</div>
       		</div>
       	</div>
   	</div>
   	<div class="form-group">
            <input id="btn_submitorder" type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
            <div id="div_submitorder_message" style="display: none;"></div>
	</div>
        </form>
</div>
<div class="col-xs-3 hidden-xs">
    <div id="div_cart" class="panel panel-default" data-spy="affix" data-offset-top="65">
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
    function setDayItemEnabled(ctl, isAvailable) {
        if(isAvailable !== undefined && isAvailable)
            $(ctl).removeAttr('disabled','');
        $(ctl).attr('style','color: #fff; background-color: #499249');
        $(ctl).parent().parent().find('.card-day-list-content').attr('style','background-color: #5cb85c');
        $(ctl).parent().parent().find(':input').removeAttr('disabled');
        var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
        $('#planContainer').find('#' + selectedID).val('1');
    }
    function setDayItemDisabled(ctl, isAvailable) {
        if(isAvailable !== undefined && !isAvailable)
            $(ctl).attr('disabled','');
        $(ctl).attr('style','color: #000; background-color: rgba(230,230,230,0.5);');
        $(ctl).parent().attr('style','background-color: rgba(230,230,230,0.5);');
        $(ctl).parent().parent().find('.card-day-list-content').attr('style','background-color: #fff;');
        $(ctl).parent().parent().find('.card-day-list-content').find(':input').attr('disabled','');
        $(ctl).parent().parent().find('.card-day-list-content').find(':input[type=text]').val('');
        $(ctl).parent().parent().find('.card-day-list-content').find(':input[type=button]').html('Horário<span class="caret"></span>');
        var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
        $('#planContainer').find('#' + selectedID).val('0');
    }
    function btnSelectedList(ctl) {
    	var selectedID = $(ctl).attr('id').split('_')[1] + 'Selected';
    	if($('#planContainer').find('#' + selectedID).val() == '0') {
            setDayItemEnabled(ctl);
        }
    	else{
            setDayItemDisabled(ctl);
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
        //highlight
        $('#cart_total').fadeTo(100, 0.1).fadeTo(200, 1.0);
        $('#product_quantity').fadeTo(100, 0.1).fadeTo(200, 1.0);
    }
    function submitOrder() {
        $('#btn_submitorder').attr('class', 'btn btn-default disabled');
        $('#div_submitorder_message').css('display', 'none');
        var submitData = {
            establishment_id: $('#establishment_id').val(),
            product_id: $('#product_id').val()
        };
        if($('#monSelected').val() === '1') {
            submitData.monday_amount = $('#monday_amount').val();
            submitData.monday_time = $('#monday_time').val() + ':00';
        }
        if($('#tueSelected').val() === '1') {
            submitData.tuesday_amount = $('#tuesday_amount').val();
            submitData.tuesday_time = $('#tuesday_time').val() + ':00';
        }
        if($('#wedSelected').val() === '1') {
            submitData.wednesday_amount = $('#wednesday_amount').val();
            submitData.wednesday_time = $('#wednesday_time').val() + ':00';
        }
        if($('#thuSelected').val() === '1') {
            submitData.thursday_amount = $('#thursday_amount').val();
            submitData.thursday_time = $('#thursday_time').val() + ':00';
        }
        if($('#friSelected').val() === '1') {
            submitData.friday_amount = $('#friday_amount').val();
            submitData.friday_time = $('#friday_time').val() + ':00';
        }
        if($('#satSelected').val() === '1') {
            submitData.saturday_amount = $('#saturday_amount').val();
            submitData.saturday_time = $('#saturday_time').val() + ':00';
        }
        if($('#sunSelected').val() === '1') {
            submitData.sunday_amount = $('#sunday_amount').val();
            submitData.sunday_time = $('#sunday_time').val() + ':00';
        }
        $.ajax({
            url: '/addOrder',
            type: 'post',
            data: submitData,
            dataType: 'html',
            success: function (data) {
                $('#btn_submitorder').attr('class', 'btn btn-success'); 
                $('#div_submitorder_message').attr('class', 'alert alert-success');
                $('#div_submitorder_message').html('Alterado com sucesso!');
                $('#div_submitorder_message').css('display', 'inline-block');
            },
            error: function (data) {
                $('#btn_submitorder').attr('class', 'btn btn-success'); 
                $('#div_submitorder_message').attr('class', 'alert alert-danger');
                $('#div_submitorder_message').html('Erro ' + data.status);
                $('#div_submitorder_message').css('display', 'inline-block');
            }
        });
    }
    $(function() {
    	$('.quantity').keyup(function () {
            calcCart();
    	});
        $('.btn-week').each(function (i, btn) {
            setDayItemDisabled('#' + btn.id, false);
        });
        $('.btn-weekend').each(function (i, btn) {
            setDayItemDisabled('#' + btn.id, false);
        });
        //load page
        var order = <%= orderJSON %>;
        if(order !== '') {
            $('#establishment_id').val(order.establishment.id);
            $.each(order.orderItems, function(i, orderItem){
                switch(orderItem.dayWeek) {
                    case 'segunda':
                        setDayItemEnabled('#btn_mon', true);
                        $('#monday_amount').val(orderItem.quantity);
                        $('#monday_time').val(orderItem.deliveryTime);
                        $('#monday_time').html(orderItem.deliveryTime +'<span class="caret"></span>');
                        break;
                    case 'terça':
                        setDayItemEnabled('#btn_tue', true);
                        $('#tuesday_amount').val(orderItem.quantity);
                        $('#tuesday_time').val(orderItem.deliveryTime);
                        $('#tuesday_time').html(orderItem.deliveryTime +'<span class="caret"></span>');
                        break;
                    case 'quarta':
                        setDayItemEnabled('#btn_wed', true);
                        $('#wednesday_amount').val(orderItem.quantity);
                        $('#wednesday_time').val(orderItem.deliveryTime);
                        $('#wednesday_time').html(orderItem.deliveryTime +'<span class="caret"></span>');
                        break;
                    case 'quinta':
                        setDayItemEnabled('#btn_thu', true);
                        $('#thursday_amount').val(orderItem.quantity);
                        $('#thursday_time').val(orderItem.deliveryTime);
                        $('#thursday_time').html(orderItem.deliveryTime +'<span class="caret"></span>');
                        break;
                    case 'sexta':
                        setDayItemEnabled('#btn_fri', true);
                        $('#friday_amount').val(orderItem.quantity);
                        $('#friday_time').val(orderItem.deliveryTime);
                        $('#friday_time').html(orderItem.deliveryTime +'<span class="caret"></span>');
                        break;
                    case 'sábado':
                        setDayItemEnabled('#btn_sat', true);
                        $('#saturday_amount').val(orderItem.quantity);
                        $('#saturday_time').val(orderItem.deliveryTime);
                        $('#saturday_time').html(orderItem.deliveryTime +'<span class="caret"></span>');
                    case 'domingo':
                        setDayItemEnabled('#btn_sun', true);
                        $('#sunday_amount').val(orderItem.quantity);
                        $('#sunday_time').val(orderItem.deliveryTime);
                        $('#sunday_time').html(orderItem.deliveryTime +'<span class="caret"></span>');
                }
            });
        }
        $.ajax({
            url: '/establishments',
            type: 'get',
            data: {establishment_id: getUrlVars()['establishment_id']},
            dataType: 'json',
            success: function (data) {
                //set establishment
                $("#establishment_alias").html(data.establishment.alias);
                $("#establishment_address").html(data.address.street + ', ' + data.address.number);
                if(data.establishment.photoUrl !== undefined)
                    $('#establishment_photo').attr('src', 'http://res.cloudinary.com/' + $.cloudinary.config().cloud_name + '/' + data.establishment.photoUrl);
                //set product
                $('#product_price').html('R$ ' + parseFloat(data.priceList.price).toFixed(2).replace('.',','));
                //set hours
                $.each(data.schedules, function(i, schedule){
                    var initHour = parseInt(schedule.startTime.split(':')[0]);
                    var endHour = parseInt(schedule.endTime.split(':')[0]);
                    var hours = initHour;
                    while(hours < endHour){
                        switch(schedule.dayWeek) {
                            case 'Segunda': $('.weekday').append('<li>'+ hours + ':00</li>'); $('.btn-week').each(function(i, btn){setDayItemEnabled('#'+btn.id, true);}); break;
                            case 'Sábado': $('.saturday').append('<li>'+ hours + ':00</li>'); setDayItemEnabled('#btn_sat', true); break;
                            case 'Domingo': $('.sunday').append('<li>'+ hours + ':00</li>'); setDayItemEnabled('#btn_sun', true); break;
                        }
                        hours++;
                    }
                });
                calcCart();
            },
            error: function (data) { alert("error :" + data.status); }
        });
        $(".dropdown-menu").on('click', 'li', function(){
          $($(this).parent().siblings()[0]).html($(this).text() + '<span class="caret"></span>');
          $($(this).parent().siblings()[0]).val($(this).text());
          //$(".btn:first-child").html($(this).text() + '<span class="caret"></span>');
          //$(".btn:first-child").val($(this).text());
       });
    });
</script>