<%@ include file="./Views/Master/master.jsp" %>
<%@ include file="./Views/Master/header.jsp" %>
<link href="./CSS/card-details.css" type="text/css" rel="Stylesheet" />
<div class="container">
<div class="row">
        <div class="row-lg-1">
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
                <div class="card-day-container">
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
            <div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-sm-8">
                                <h4>Pão</h4>
                            </div>
                            <div class="col-sm-4">
                                Frequencia
                            </div>
                        </div>
                        
                    </li>
                    <li class="list-group-item">
                        <h4>Pão 2</h4>
                        <div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <h4>Pão 3</h4>
                        <div>
                        </div>
                    </li>
                </ul>
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
