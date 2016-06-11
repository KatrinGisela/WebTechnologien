// Tortendiagramm 

$(function() {$('<img id="ajax-loader" src="img/ajax-loader.gif" alt="Animation, während die Seite lädt"/>').insertAfter('div.right');

// Laden von Daten mittels AJAX-Befehl: https://xuad.net/artikel/vom-einfachen-ajax-request-zum-komplexen-objektaustausch-mit-json-mittels-jquery/ 
// erster Aufruf onload
// S92!!! getJSON!

$.getJSON('/php/moduleGroups.php', 
		function(data) {
			groups = data.groups; 

			$.each( groups, function( index, group){
				groups[index].mittelwert = (groups[index].minECTS+groups[index].maxECTS)/2; 
			});
 
			$('#ajax-loader').hide(); 

			var categorical_colors = d3.scale.category10(); 
			var width = 500,
			    height = 250,
			    radius = Math.min(width, height) / 2;

			var color = d3.scale.category10(); 

			var arc = d3.svg.arc()
			    .outerRadius(radius - 10)
			    .innerRadius(radius - 50);

			var pie = d3.layout.pie()
			    .sort(null)
			    .value(function (d) {
			    return d.mittelwert;
			});

			var svg = d3.select("#chartContainer").append("svg")
			    .attr("width", width)
			    .attr("height", height)
			    .append("g")
			    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")"); 


			var g = svg.selectAll(".arc")
				.data(pie(groups))
			        .enter().append("g")
			        .attr("class", "arc");

			    g.append("path")
			        .attr("d", arc)
			        .style("fill", function (d) {
			      return color(d.data.mittelwert);
				});

			// 	g.append("p")
			// 	.text('ID: ');

			// event: onmouseover
			// $( "selector" ).mousover( function … 
	});
}); 


