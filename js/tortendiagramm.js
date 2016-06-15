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
			.attr("class" ,"svg-klasse")
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

			g.on('mouseover', function(d){
				g.append("text")
			        .text(d.data.id + ' ' +  d.data.name +" [" + d.data.minECTS + " - " + d.data.maxECTS + " ECTS-Punkte]")
			         .attr("text-anchor", "middle")
			});

			g.on('mouseout', function(d){
				$("text").hide();
				// folgende Zeile wird gebraucht, da sich die text-Element aus g.on('mouseover', …) sonst in der html-Datei ansammlen
				d3.selectAll("text").remove(); 
			});

			g.on('click', function(d){
				$('#ajax-loader').show(); 
				$.getJSON('/php/moduleGroups.php?module_details=' + d.data.id, function(data_details){
					details = data_details.details; 	
					$("#content").html('<h2><em>' +  details.id + ' </em> ' + details.name + '</h2>'); 
					$("#content").append('<p>' + details.description + '</p>');
					$("#content").append('<p>' + details.minECTS + '</p>');
					$("#content").append('<p>' + details.maxECTS + '</p>');

					// eindeutiger Kurszugriff über short_name
					// Pflichtmodul: mandatory = true 
					$.each( details.courses, function( index, course ){
						if(course.mandatory == true){ alert("kurs"); 
							$("#content").html('<h3>Pflichtmodule</h3>'); 
							$("#content").append('<p>' + course.short_name + '</p>');
						 }
			});

					console.log(details.courses); 

					$('#ajax-loader').hide(); 
				});
			});
	}); 
}) 


var tab=new Array();
document.write("<table cellspacing='2' cellpadding='5' border='2' width='100%'>");
for(i=0;i<groups.length;i++)
   {
   
      tab=groups[i].split("/");
      document.write("<tr>");
      document.write("<td>" + tab[0] + "</td>");
      document.write("<td>" + tab[1] + "</td>");
      document.write("<td>" + tab[2] + "</td>");
      document.write("<td>" + tab[3] + "</td>");
      document.write("</tr>");
      }
   }
document.write("</table>");

CreateTable("unsereTabelle", hierTabelleRein, ["Kurse", "ECTS", "Modul"]);

function createTable (id, where, data){
	var table = '<table id=" '+ id +' + "<thead><tr>';
	for (var i = 0; )
}


