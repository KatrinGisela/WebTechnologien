// <script src="/js/jquery-2.2.3.js" type="text/javascript"></script>
	
/* Hier irgendwo müssen per GET-Request (Kombi aus jQuery und AJAX) die .php-Dateien zu den Modulen eingebunden werden */ 

/* Hier die dazugehörigen ids im Body bauen, die aufgerufen werden (einzelne ids= einzelne Donut-Abschnitte*/


		// $(function() {
			// $('#submit').click(function(){
				// var MyText = $('input[id=MeinText]').val();	 // id anpassen
				
				// $.get("moduleGroups.php",
					  // { text: MyText },									// anpassen
				      // function(data) {
					     // $('#result').html(data);						// was ist in dem Fall result? das Laden der entsprecheneden Infos zum Modul
                         // alert('Load was performed.');
                      // });
			// });
		// });


	
// vergleiche Kapitel 3 S. 79 
function showLoaderGif() {
	//<img src="img/ajax-loader.gif" alt="Animation, während die Seite lädt" />
}



// Laden von Daten mittels AJAX-Befehl 
// https://xuad.net/artikel/vom-einfachen-ajax-request-zum-komplexen-objektaustausch-mit-json-mittels-jquery/ 

// erster Aufruf onload

$("button#ajaxCall_template").click(function() {

$.ajax({
	type: "GET",
	url: "moduleDefinitions.php",
	data: {},
	success: function(content) {
		$("#content").html(content);
	}
});

return false;
});

// S92!!! getJSON!


// bei der Erstellung der einzelnen Elemente des Donut-Diagrammms werden Ids übergeben und wenn diese dann angeklickt werden,
// dann werden die entsprechenden A1/A2/A3 etc. aufgerufen
// Id wird dann hier eingebunden


$("button#ajaxCall_a1").click(function() {
$.ajax({
	type: "GET",
	url: "moduleDefinitions.php",
	data: {
		module_details:"A1" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function(content) {
		$("#content").html(content);
		document.write("Test" + content)
	}
});

return false;
});

