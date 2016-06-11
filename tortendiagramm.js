// Tortendiagramm 

$(function() {$('<img id="ajax-loader" src="img/ajax-loader.gif" alt="Animation, während die Seite lädt"/>').insertAfter('div.right');

// Laden von Daten mittels AJAX-Befehl: https://xuad.net/artikel/vom-einfachen-ajax-request-zum-komplexen-objektaustausch-mit-json-mittels-jquery/ 
// erster Aufruf onload
// S92!!! getJSON!

var groupsArray = [];

$.getJSON('/php/moduleGroups.php', 
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

//d3.select("body").selectAll("p").data(dataset).enter().append("p").text(function(d){return"Neuer Paragraph mit Wert: "+d;});


var mittelwert = []; 

	$.each( groupsArray, function( index, group){
		groupsArray[index].mittelwert = (groupsArray[index].minECTS+groupsArray[index].maxECTS)/2; 
	});
 
	console.log('groupsArray[0]: '); 
	console.log(groupsArray[0]); 
	console.log('groupsArray[0].mittelwert: '); 
	console.log(groupsArray[0].mittelwert); 
	console.log('groupsArray[1]: '); 
	console.log(groupsArray[1]); 
	console.log('groupsArray[1].mittelwert: '); 
	console.log(groupsArray[1].mittelwert); 
	}); 

// Categorical Colors laut: https://github.com/d3/d4/wiki/Ordinal-Scales
var $categorical_colors = d3.scale.category10(); 

var vis = d3.select("#diagram"); 
var arc = d3.svg.arc() 
	.innerRadius(50) 
	.outerRadius(100) 
	.startAngle(0) 
	.endAngle(1.5*Math.PI);

//vis.selectAll("path") 
//	.data(data) 
//	.enter() 

	vis.append("path") 
		.attr("d", arc) 
		.style("fill", function () {return $categorical_colors(2)})
		.attr("transform", "translate(300,200)");

}); 


