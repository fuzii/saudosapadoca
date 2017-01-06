<style type="text/css">
	.menu-image-wrapper {
	  display: inline-block;
	  width: 125px;
	  background-clip: padding-box;
	  box-sizing: border-box;
	}
	.menu-image {
	  position: relative;
	  width: 125px;
	  height: 125px;
	  overflow: hidden;
	  display: inline-block;
	  background-color: #f5f5f5;
	  text-align: center;
	  vertical-align: middle;
	  cursor: pointer;
	}
	.menu-image img {
	  border-radius: 2px 2px 0 0;
	  background-clip: padding-box;
	  max-width: 100%;
	  max-height: 100%;
	  width: auto;
	  margin: auto;
	}
	.menu-content
	{
	  padding: 5px 5px 2px 16px;
	  border-radius: 0 0 2px 2px;
	  background-clip: padding-box;
	  box-sizing: border-box;
	  display: inline-block;
	  width: calc(100% - 130px);
	  vertical-align: top;
	}
	@media screen and (max-width: 576px)
	{
		.menu-image-wrapper
		{
			width: 100px;
		}
		.menu-image
		{
			width: 100px;
			height: 100px;
		}
		.menu-image-button
		{
			width: calc(100% - 100px);
		}
		.menu-image-button .btn
		{
			font-size: 12px;
			padding-left: 7px;
			padding-right: 7px;
		}
		.menu-content
		{
		  	width: calc(100% - 105px)
		}
	}
	@media screen and (max-width: 375px)
	{
		.menu-image-wrapper
		{
			width: 75px;
		}
		.menu-image
		{
			width: 75px;
			height: 75px;
		}
		.menu-content
		{
		  	width: calc(100% - 80px);
		}
		.menu-image-button
		{
			width: calc(100% - 75px)
		}
		.menu-image-button .btn
		{
			font-size:10px;
			padding-left: 2px;
			padding-right: 2px;
			height: 28px;
		}
	}
</style>
<div class="panel-body">
	<form onsubmit="uploadFile()">
		<input type="file" id="est_file_image" name="est_file_image" style="visibility: hidden;">
		<div>
			<div class="menu-image-wrapper">
				<div id="upload_image" class="menu-image">
					<img src="../../images/images.jpg" alt="Alterar imagem estabelecimento" />
				</div>
				<div class="menu-image-button">
					<input class="btn" id="btn_upload_image" type="button" value="Alterar imagem" />
				</div>
			</div>
			<div class="menu-content">
				<h3>SAUDOSA PADOCA</h3>
				<p>Endereço, número</p>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(function() {
		$("#upload_image").click(function () {
			$("#est_file_image").click();
		})
		$("#btn_upload_image").click(function () {
			$("#est_file_image").click();
		})
	});
	function uploadFile() {
		event.preventDefault();
		
		var file = document.getElementById("est_file_image").files[0];

		//if(file.type.match('image.*')){
		//	return false;
		//}
		
		var formData = new FormData();
		formData.append('file', file, file.name);
		
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/addEstablishmentPhoto', true);
		
		xhr.onload = function () {
			if(xhr.status === 200) {
				//success
			} 
			else {
				//error
			}
		}
		xhr.send(formData);
		
		return false;
	}
</script>