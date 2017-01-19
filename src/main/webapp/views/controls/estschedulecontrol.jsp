<%
    String schedulesJSON = "";
    if(!session.isNew() && session.getAttribute("schedule") != null) {
        schedulesJSON = formatter.GenerateJSON.GetListScheduleJSON((java.util.List<model.Schedule>)session.getAttribute("schedule")).toString(); 
    }
%>
<div class="panel-heading">
	<h3>Horário de funcionamento</h3>
</div>
<div class="panel-body">
	<form method="post" onsubmit="submitSchedule(); return false;">
                <input type="hidden" id="establishment_id" name="establishment_id" />
		<div class="form-inline form-group">
			<div class="col-lg-2">
				<label for="time_start">Segunda - Sexta: </label>
			</div>
			<div class="col-lg-10">
				<input id="week_start_time" name="week_start_time" type="time" class="form-control" title="início" placeholder="início (ex. 08:00)"/>
				<input id= "week_end_time" name="week_end_time" type="time" class="form-control" title="fim" placeholder="fim (ex. 18:00)" />
				<div class="checkbox"><label><input type="checkbox" title="fechado" /> Fechado</label></div>
			</div>
		</div>
		<div class="form-inline form-group">
			<div class="col-lg-2">
				<label for="">Sábado: </label>
			</div>
			<div class="col-lg-10">
				<input id="saturday_start_time" name="saturday_start_time" type="time" class="form-control" title="início" placeholder="início (ex. 08:00)"/>
				<input id="saturday_end_time" name="saturday_end_time" type="time" class="form-control" title="fim" placeholder="fim (ex. 18:00)" />
				<div class="checkbox"><label><input title="fechado" type="checkbox" /> Fechado</label></div>
			</div>
		</div>
		<div class="form-inline form-group">
			<div class="col-lg-2">
				<label for="">Domingo: </label>
			</div>
			<div class="col-lg-10">
				<input id="sunday_start_time" name="sunday_start_time" type="time" class="form-control" title="início" placeholder="início (ex. 08:00)"/>
				<input id="sunday_end_time" name="sunday_end_time" type="time" class="form-control" title="fim" placeholder="fim (ex. 18:00)" />
				<div class="checkbox"><label><input type="checkbox" title="fechado" /> Fechado</label></div>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-success" value="Gravar" style="min-width: 150px;" />
		</div>
	</form>
</div>
<script type="text/javascript">
    function Schedule(obj) {
        this.id = obj.id;
        this.establishment_id = obj && obj.establishmentId;
        this.dayWeek = obj && obj.dayWeek;
        this.startTime = obj && obj.startTime;
        this.endTime = obj && obj.endTime;
    }
    var schedules = <%= schedulesJSON %>;
	$(function () {
            //set values
            if(schedules.length > 0) {
                $("#establishment_id").val(schedules && schedules[0].establishmentId);
                $.each(schedules, function (i, schedule) {
                    if(schedule.dayWeek === 'Segunda') {
                        $("#week_start_time").val(schedule.startTime);
                        $("#week_end_time").val(schedule.endTime);
                    }
                    else if(schedule.dayWeek === 'Sábado') {
                        $("#saturday_start_time").val(schedule.startTime);
                        $('#saturday_end_time').val(schedule.endTime);
                    }
                    else if(schedule.dayWeek === 'Domingo') {
                        $("#sunday_start_time").val(schedule.startTime);
                        $('#sunday_end_time').val(schedule.endTime); 
                    }
                });
            }
            $('input[type=checkbox]').click(function () {
                    if($(this).is(':checked')) {
                            $(this).parent().parent().siblings().each(function (i, ctl){
                                    $(ctl).val('');
                                    $(ctl).attr('disabled','');
                            });
                    }
                    else {
                            $(this).parent().parent().siblings().each(function (i, ctl){
                                    $(ctl).val('');
                                    $(ctl).removeAttr('disabled');
                            });
                    }
            });
	});
	
	function submitSchedule() {
		$.ajax({
			type: "post",
			url: "/addSchedule",
			data: { 
                            week_start_time: $("#week_start_time").val(),
                            week_end_time: $("#week_end_time").val(),
                            saturday_start_time: $("#saturday_start_time").val(),
                            saturday_end_time: $("#saturday_end_time").val(),
                            sunday_start_time: $("#sunday_start_time").val(),
                            sunday_end_time: $("#sunday_end_time").val()
                        },
			dataType: "html",
			success: function (data) { alert('sucesso!');},
			error : function (data) { alert('erro'); }
		});
		return false;
	}
</script>