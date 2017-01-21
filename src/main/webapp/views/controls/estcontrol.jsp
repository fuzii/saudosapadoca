<%
    String establishmentJSON = "''";
    String addressJSON = "''";
    if(!session.isNew() && session.getAttribute("address") != null) {
        addressJSON = formatter.GenerateJSON.GetAddressJSON(((java.util.List<model.Address>)session.getAttribute("address")).get(0)).toString(); 
    }
    if(!session.isNew() && session.getAttribute("establishment") != null) {
        establishmentJSON = formatter.GenerateJSON.GetEstablishmentJSON((model.Establishment)session.getAttribute("establishment")).toString();
    }
%>
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
        .menu-image-progress-bar
        {
            margin-top: 5px;
            background-color: #18aebd;
            text-align: center;
            color: #f5f5f5;
            border-radius: 3px;
            opacity: 0.5;
            transition: visibility ease-in-out 0.5s;
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
                <input type="hidden" id="image_id" name="image_id" />
                <input name="file" id="cloudinary_file_image" type="file" class="cloudinary-fileupload" data-cloudinary-field="image_id" style="visibility: hidden;" />
		<div>
			<div class="menu-image-wrapper">
				<div id="upload_image" class="menu-image">
					<img id="img_upload_image" src="../../images/images.jpg" alt="Alterar imagem estabelecimento" />
				</div>
				<div class="menu-image-button">
					<input class="btn" id="btn_upload_image" type="button" value="Alterar imagem" />
				</div>
                                <div class="menu-image-progress-bar" style="visibility: hidden"></div>
			</div>
			<div class="menu-content">
				<h3 id="est_name">NOME</h3>
				<p id="est_address">Endereço, número</p>
			</div>
		</div>
	</form>
</div>
<script src='../../scripts/jquery.ui.widget.js' type='text/javascript'></script>
<script src='../../scripts/jquery.iframe-transport.js' type='text/javascript'></script>
<script src='../../scripts/jquery.fileupload.js' type='text/javascript'></script>
<script type="text/javascript">
        var entityMap = {
        "&": "&amp;",
        "<": "&lt;",
        ">": "&gt;",
        '"': '&quot;',
        "'": '&#39;',
        "/": '&#x2F;'
        };
        function escapeHtml(string) {
          return String(string).replace(/[&<>"'\/]/g, function (s) {
            return entityMap[s];
          });
        }
        function Address(obj) {
            this.number = obj && obj.number;
            this.street = obj && obj.street;
        }
	$(function() {
            //set address
            var est_address = new Address(<%= addressJSON %>);
            var establishment = <%= establishmentJSON %>;
            //set values
            $("#est_name").html(establishment.alias);
            $('#est_address').html(est_address.street + ', ' + est_address.number);

            $("#upload_image").click(function () {
                    $("#cloudinary_file_image").click();
            });
            $("#btn_upload_image").click(function () {
                    $("#cloudinary_file_image").click();
            });

            $.ajax({
               url: '/addEstablishmentImage',
               type: "get",
               data: null,
               success: function (data) {
                   $('.cloudinary-fileupload').cloudinary_fileupload({formData: data});
                   $('.cloudinary-fileupload').bind('fileuploadsend', function () {
                       $('.menu-image-progress-bar').css('visibility', 'visible');
                   });
                   $('.cloudinary-fileupload').bind('fileuploadprogress', function(e, data) { 
                        $('.menu-image-progress-barr').css('width', Math.round((data.loaded * 100.0) / data.total) + '%');
                        $('.menu-image-progress-bar').html(Math.round((data.loaded * 100.0) / data.total) + '%');
                    });
                   $('.cloudinary-fileupload').bind('fileuploaddone', function () {
                       $('.menu-image-progress-bar').css('visibility','hidden');
                       $('.menu-image-progress-bar').html('');
                   });
                   
                   if(establishment.photoUrl !== null && establishment.photoUrl !== undefined)
                       $("#img_upload_image").attr("src", "http://res.cloudinary.com/" + $.cloudinary.config().cloud_name + '/' + establishment.photoUrl);
               },
               error: function (data) { alert("ERROR cloudinary"); }
            });
            function survey(selector, callback) {
                var input = $(selector);
                var oldvalue = input.val();
                setInterval(function(){
                   if (input.val() !== oldvalue){
                       oldvalue = input.val();
                       callback();
                   }
                }, 100);
            }
            survey('#image_id', function(){
                $("#img_upload_image").attr("src", "http://res.cloudinary.com/" + $.cloudinary.config().cloud_name + "/" + $("#image_id").val().toString().split('#')[0]);
                $.ajax({
                    url: 'addEstablishmentImage',
                    type: 'post',
                    data: { photo_url: $("#image_id").val().toString().split('#')[0] },
                    dataType: 'html',
                    error: function (data) { alert('Error insert image url' + data.status); }
                });
            }); 
	});
	/*function uploadFile() {
		event.preventDefault();
		
		var file = document.getElementById("est_file_image").files[0];

		//if(file.type.match('image.*')){
		//	return false;
		//}
		
		var formData = new FormData();
		formData.append('file', file, file.name);
		
		//Check for xhr Object
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		}
		else {
			//Try using ActiveXObject for older ie versions..
			if (window.ActiveXObject) {
				try {
					xhr = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e) { }
			}
		}

		//Now you can go ahead and use xhr
		if (xhr) {
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
		}
		else {
			//error
		}
		
		return false;
	}*/
</script>