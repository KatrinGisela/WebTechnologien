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
$(document).ready( function() {$('<img id="ajax-loader" src="img/ajax-loader.gif" alt="Animation, während die Seite lädt"/>').insertAfter('h1'); }); 

// Laden von Daten mittels AJAX-Befehl: https://xuad.net/artikel/vom-einfachen-ajax-request-zum-komplexen-objektaustausch-mit-json-mittels-jquery/ 
// erster Aufruf onload
// S92!!! getJSON!

var groupsArray = [];
var idArray = []; 
var minECTSArray = []; 

$(document).ready( 
	function() { $.getJSON('/php/moduleGroups.php', 
		function(data) {
			groupsArray = data.groups; 
			// Zugriff z. B. über data.groups[1].id 
			$.each( data.groups, function( index, group ){
				// group.id
				// minECTS
				// minECTSArray = minECTSArray.append(group.minECTS); 
		
				// maxECTS

				}); 
			$('#ajax-loader').hide(); 
		}); 
	});

//d3.select("body").selectAll("p").data(dataset).enter().append("p").text(function(d){return"Neuer Paragraph mit Wert: "+d;});

$(document).ready( function() {

// Categorical Colors laut: https://github.com/d3/d4/wiki/Ordinal-Scales
var colors = d3.scale.category10(); 

var vis = d3.select("#diagram"); 
var arc = d3.svg.arc() 
	.innerRadius(50) 
	.outerRadius(100) 
	.startAngle(0) 
	.endAngle(1.5*Math.PI);

vis.append("path") 
	.attr("d", arc) 
//	.attr("transform", "translate(300,200)")
	.style("fill", function(d){return d[2];}) .attr("transform", "translate(300,200)");
}); 

/* var width = 460,
    height = 300,
    radius = Math.min(width, height) / 2;

var color = d3.scale.category20();

var pie = d3.layout.pie()
    .sort(null);

var arc = d3.svg.arc()
    .innerRadius(radius - 100)
    .outerRadius(radius - 50);


.append("svg")
    .attr("width", width)
    .attr("height", height)
    .append("g")
    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");

 var path = svg.selectAll("path")
    .data(pie(minECTSArray))
   .enter().append("path")
     .attr("fill", function(d, i) { return color(i); })
     .attr("d", arc); 
*/


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




// bei der Erstellung der einzelnen Elemente des Donut-Diagrammms werden Ids übergeben und wenn diese dann angeklickt werden,
// dann werden die entsprechenden A1/A2/A3 etc. aufgerufen
// Id wird dann hier eingebunden


$(document).ready(function() {
console.log("irgendein String"); 
$.ajax({
	type: "GET",
	url: "php/moduleGroups.php",
	data: {
	module_details:"A1"	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function(content) {
		$("#content").html(content);
	//	$("#content").write("Test" + content)
	}
});

return false;
});

/*
//  Aufruf  Detailinformationen zu A1

$.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	type: "GET";
	url: "php/moduleGroups?module_details=A1";
	data: {
		module_details:"A1" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	};

$.getJSON('/php/moduleGroups?module_details=A1', function(data, textStatus, jqXHR) {
	alert("Geht"); 
	document.writeln("Jetzt aber");
	echo("Ausgabe"); 
	return window.open("localhost"); 
}); */


// function daten_laden() {
		// $.get('moduleDefinitions.php', function(content) {
				// $("#content").html(content);
		// document.write("Test" + content)	
		// }); 
// }); 

