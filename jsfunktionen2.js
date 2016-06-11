// <script src="/js/jquery-2.2.3.js" type="text/javascript"></script>
	
/* Hier irgendwo müssen per GET-Request (Kombi aus jQuery und AJAX) die .php-Dateien zu den Modulen eingebunden werden */ 

/* Hier die dazugehörigen ids im Body bauen, die aufgerufen werden (einzelne ids= einzelne Donut-Abschnitte*/

	
// vergleiche Kapitel 3 S. 79 
//$(document).ready( function() {$('<img id="ajax-loader" src="img/ajax-loader.gif" alt="Animation, während die Seite lädt"/>').insertAfter('h1'); }); 

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

$(document).ready( 
	function() {
'use strict';
               var dataset = [
          { label: 'Abulia', count: 10 }, 
          { label: 'Betelgeuse', count: 20 },
          { label: 'Cantaloupe', count: 30 },
          { label: 'Dijkstra', count: 40 }
        ];
	   
        var width = 360;
        var height = 360;
        var radius = Math.min(width, height) / 2;
		var donutWidth = 75;
        var color = d3.scale.category20b();
        var svg = d3.select('#chart')
          .append('svg')
          .attr('width', width)
          .attr('height', height)
          .append('g')
          .attr('transform', 'translate(' + (width / 2) + 
            ',' + (height / 2) + ')');
        var arc = d3.svg.arc()
		.innerRadius(radius - donutWidth) 
          .outerRadius(radius);
        var pie = d3.layout.pie()
          .value(function(d) { return d.count; })
          .sort(null);
		      
        var path = svg.selectAll('path')
          .data(pie(dataset))
          .enter()
          .append('path')
          .attr('d', arc)
          .attr('fill', function(d, i) { 
            return color(d.data.label);
		 }); 
		path.on('click', function(){
		$.ajax({
			type: "GET",
			url: "php/moduleGroups.php",
			data: {
			module_details:"A1"
			
			},
			success: function(content) {
				$("#content").html(content);
			}
			});
		
		});
		
		
}); 



// bei der Erstellung der einzelnen Elemente des Donut-Diagrammms werden Ids übergeben und wenn diese dann angeklickt werden,
// dann werden die entsprechenden A1/A2/A3 etc. aufgerufen
// Id wird dann hier eingebunden

/*
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
*/
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
