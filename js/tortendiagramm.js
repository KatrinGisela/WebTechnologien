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
 
	console.log('groupsArray[1]: '); 
	console.log(groupsArray[1]); 
	console.log('groupsArray[1].mittelwert: '); 
	console.log(groupsArray[1].mittelwert); 
	}); 

// Categorical Colors laut: https://github.com/d3/d4/wiki/Ordinal-Scales
var $categorical_colors = d3.scale.category10(); 

//		.style("fill", function () {return $categorical_colors(2)})


var data=[{"crimeType":"mip","totalCrimes":24},{"crimeType":"theft","totalCrimes":558},{"crimeType":"drugs","totalCrimes":81},{"crimeType":"arson","totalCrimes":3},{"crimeType":"assault","totalCrimes":80},{"crimeType":"burglary","totalCrimes":49},{"crimeType":"disorderlyConduct","totalCrimes":63},{"crimeType":"mischief","totalCrimes":189},{"crimeType":"dui","totalCrimes":107},{"crimeType":"resistingArrest","totalCrimes":11},{"crimeType":"sexCrimes","totalCrimes":24},{"crimeType":"other","totalCrimes":58}];


var width = 800,
    height = 250,
    radius = Math.min(width, height) / 2;

var color = d3.scale.ordinal()
    .range(["#98abc5", "#8a89a6", "#7b6888", "#6b486b", "#a05d56", "#d0743c", "#ff8c00"]);

var arc = d3.svg.arc()
    .outerRadius(radius - 10)
    .innerRadius(radius - 70);

var pie = d3.layout.pie()
    .sort(null)
    .value(function (d) {
    return d.totalCrimes;
});



var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height)
    .append("g")
    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");

    var g = svg.selectAll(".arc")
        .data(pie(data))
        .enter().append("g")
        .attr("class", "arc");

    g.append("path")
        .attr("d", arc)
        .style("fill", function (d) {
        return color(d.data.crimeType);
    });

});

