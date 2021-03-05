<!DOCTYPE html>
<html lang="en">
	<head>
    	<#include "head.inc">
    	<meta charset="UTF-8">
    	<title>Fehler!</title>
	</head>
	<body>
    	<#include "menu.inc">
    	
		<div id="content">
			<div class="titelseite">
				<h1>Willkommen bei StattAuto</h1>
				<p>
					Leider ist ein Problem aufgetreten, wir bitten um Entschuldigung!
					<br>
					Fehler ${status} (${error}): ${message}
				</p>
			</div>
			<hr/>
			<#include "footer.inc">
			<script src="/js/main.js"></script>
		</div>
	</body>
</html>