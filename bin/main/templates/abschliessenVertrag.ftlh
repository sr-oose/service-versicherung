<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="de">
   	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
      	<link rel="stylesheet" type="text/css" href="<@spring.url '/css/bootstrap.css'/>"/>   
      	<link rel="stylesheet" type="text/css" href="<@spring.url '/css/styles.css'/>"/>   
      	<link rel="stylesheet" type="text/css" href="<@spring.url '/css/main.css'/>"/>   
  		
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
      	
      	<title>Versicherung</title>
      	<#include "head.inc"/>
   	</head>
   	
   	<body>
   		<#include "menu.inc" />
		<#if errorMessage??>
      		<div style="color:red;font-style:italic;">
         		${errorMessage}
      		</div>
      	</#if>
		<div id="content" class="container">
			<fieldset>
            	<h1>Versicherung:</h1>
            	<@spring.bind "options"/>
            	<form name="versicherung" action="" method="POST">

	               	<div class="form-group">
	               	 	<label for="vertragsart">Vertragsart:</label> <br/>
	               		<@spring.formSingleSelect "vertragForm.typ", options, " "/>    <br/>
	               	</div>
            	</form>
         	</fieldset>
      	</div>
   </body>
</html>