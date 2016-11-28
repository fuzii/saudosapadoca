
<%@ Page Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage" %>

<link href="../../Content/Card.css" type="text/css" rel="Stylesheet" />
<style type="text/css">
	#map
	{
		margin: auto;
		max-width: 90%;
		min-width: 400px;
		min-height: 500px;
		margin-left: 50px;
		margin-right: 50px;
	}
	#listresult
	{
		max-width: 100%;
	}
	#listresult li
	{
		margin-bottom: 20px;
	}
</style>
<form onsubmit="$('#myModal').modal('show'); searchCEP(); return false;">
	<div class="form-inline" style="text-align: center; padding-bottom: 15px">
		<label for="CEP">
			CEP:</label>
		<input type="text" class="form-control" id="CEP" placeholder="Enter CEP" maxlength="9" />
		<button type="submit" title="Pesquisar" id="btn_pesquisar" class="btn" data-toggle="modal"
			data-target="#myModal">
			Pesquisar</button>
		<%--<button type="button" title="Pesquisar" id="btn_pesquisar" class="btn" onclick="searchCEP();">
				Pesquisar</button>--%>
	</div>
</form>
<br />
<div id="map"></div>
<div id="listresult" class="container">
	<%--<div class="row">
		<div class="col-sm-4">
			<div class="card">
				<div class="card-image">
					<img src="../../Content/Images/images.jpg" style="width:122px; height:122px" />
				</div>
				<div class="card-content">
					<h3>TITLE</h3>
					<p>TESTE de card</p>
					<p>3 paragrafo</p>
				</div>
				<div class="card-action">
					<a href="#">LINK</a>
				</div>
			</div>
		</div>
	</div>--%>
	<div class="row" id="row_1"></div>
</div>
<!-- modal -->
<div class="modal fade" id="myModal" role="dialog" data-backdrop="static">
	<div class="modal-dialog">
		<form id="form_register" action="https://saudosapadoca.herokuapp.com/addAccount">
		<div class="modal-content">
			<div class="modal-header">
				<h2>Complete seu endereço!</h2>
			</div>
			<div class="modal-body" style="padding: 40px 50px">
				<div class="form-group">
					<input type="text" class="form-control" id="uf" placeholder="UF" disabled style="width:25%; display:inline"/>
					<input type="text" class="form-control" id="cidade" placeholder="Cidade" disabled style="width:74%; display:inline" />
					<input type="text" class="form-control" id="logradouro" placeholder="Rua, Avenida, etc" disabled style="width:74%; display:inline" />
					<input type="text" class="form-control" id="numero" placeholder="Nº" style="width:25%; display:inline" />
				</div>
				<div class="form-group">
					<label for="name">
						<span class="glyphicon glyphicon-user"></span> Nome</label>
					<input type="text" class="form-control" id="name" placeholder="Nome" />
				</div>
				<div class="form-group">
					<label for="email">
						<span class="glyphicon glyphicon-envelope"></span> Email</label>
					<input type="text" class="form-control" id="email" placeholder="Email" required />
				</div>
			</div>
			<div class="modal-footer">
				<%--<input type="submit" class="btn btn-success" data-dismiss="modal" value="Salvar"></input>--%>
				<button type="button" class="btn" data-dismiss="modal" onclick="register();">
					Pesquisar</button>
			</div>
		</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	var geocoder;
	var map;
	var markers;
	var client_id = 'W4FHVCUFSIWDKKO4AS5VZ322DU1BMYNZMYCRAGCTKWXD5NTW';
	var client_secret = 'UEZ2AWYSHAICCL4IGYPFOA3C511VW2UG4XCYZFHH0RLV1KIQ';
	var near = "Sao%20Paulo";

	jQuery("#CEP").mask("99999-999");

	function searchCEP(address) {
		$.each(markers, function (i, marker) {
			marker.setMap(null);
		});
		markers = [];
		$('#listresult').empty();
		$('#listresult').append('<div class="row" id="row_1"></div>');
		if (address == null || address == '')
			address = $("#CEP").val();
		geocoder.geocode({ 'address': address }, function (results, status) {
			if (status === google.maps.GeocoderStatus.OK) {
				map.panTo(results[0].geometry.location);
				//                    if (marker == null) {
				//                        marker = new google.maps.Marker({
				//                            map: map,
				//                            draggable: true,
				//                            position: results[0].geometry.location,
				//                        });
				//                    }
				//                    else {
				//                        marker.setPosition(results[0].geometry.location);
				//                    }
				map.setZoom(15);
				fetchFoursquare("https://api.foursquare.com/v2/venues/search?client_id=" + client_id + "&client_secret=" + client_secret + "&ll=" + results[0].geometry.location.lat() + "," + results[0].geometry.location.lng() + "&radius=1000&section=food&query=padaria&v=20161123");
			}
			else
				alert('Geocode error: ' + status);
		});
		$.getJSON('http://api.postmon.com.br/v1/cep/' + $('#CEP').val(), function (data) {
			$('#uf').val(data.estado);
			$('#cidade').val(data.cidade);
			$('#logradouro').val(data.logradouro);
			$('#bairro').val(data.bairro);
		});
	}

	function initMap() {
		markers = [];
		geocoder = new google.maps.Geocoder();

		geocoder.geocode({ 'address': 'Sao Paulo' }, function (results, status) {
			if (status === google.maps.GeocoderStatus.OK) {
				map = new google.maps.Map(document.getElementById('map'), {
					zoom: 15,
					center: results[0].geometry.location
				});
			} else {
				alert('Geocode error: ' + status);
			}
		});
		fetchFoursquare("https://api.foursquare.com/v2/venues/search?client_id=" + client_id + "&client_secret=" + client_secret + "&near=" + near + "&radius=1000&section=food&query=padaria&v=20161123");
	}

	function fetchFoursquare(urlAPI) {
		//foursquare
		var url = urlAPI ;
		var rowCount = 1;
		$.getJSON(url, function (data) {
			$.each(data.response.venues, function (i, venue) {
				var mrk = new google.maps.Marker({
					map: map,
					position: { lat: venue.location.lat, lng: venue.location.lng },
					animation: google.maps.Animation.DROP,
					title: venue.name
				});
				mrk.addListener('click', function (e) {
					//location.href = '#';
					//location.href = '#' + venue.id;
					$('html,body').animate({
						scrollTop: $('#' + venue.id).offset().top
					}, 'slow');

				});
				markers.push(mrk);
				$('#row_' + rowCount).append(createCard(venue.name, venue.location.address));
				if((i + 1) % 2 == 0){
					rowCount++;
					$('#listresult').append('<div id="row_' + rowCount + '" class="row"></div>');
				}
			});
		});
	}

	function createCard(title, description) {
		return '<div class="col-sm-6"><div class="card"><div class="card-image"><img src="../../Content/Images/images.jpg" style="width:122px; height:122px" /></div><div class="card-content"><h4 class="card-title">' + title + '</h4><p>' + description + '</p></div><div class="card-action"><a href="#">LINK</a></div></div></div>';
	}

	function register() {
		$.ajax({
			type: "GET",
			url: "https://saudosapadoca.herokuapp.com/addAccount?name=" + $("#name").val() + "&email=" + $("#email").val(),
			data: null,
			success: function (data) { alert("OK " + data.toString()); },
			error: function (data) { alert("ERROR " + data.statusText); }
		});
		searchCEP($('#logradouro').val() + '+' + $('#numero').val() + '+' + $('#uf').val() + '+' + $('#cidade').val());
		return true;
	}

	//        $('#form_register').submit(function () {
	//            $.post($(this).attr('action'), $(this).serialize(), function (res) {
	//                alert("OK" + res);
	//            });
	//        });

	//        $("#form_register").submit(function (e) {
	//            $.ajax({
	//                type: "GET",
	//                url: "https://saudosapadoca.herokuapp.com/addAccount",
	//                data: $("#form_register").serialize(),
	//                success: function (data) {
	//                    alert("OK " + data);
	//                },
	//                error: function (data) { alert("ERROR " + data); }
	//            });
	//        });
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDNr74pDGCK8gERm_i_o0TsVtiZIrtjj7Y&callback=initMap"></script>
