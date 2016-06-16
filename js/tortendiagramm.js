$(function() {$('<img id="ajax-loader" src="img/ajax-loader.gif" alt="Animation, während die Seite lädt"/>').insertAfter('h1');

$.getJSON('/php/moduleGroups.php', 
		function(data) {
			groups = data.groups; 

			$.each( groups, function( index, group){
				groups[index].mittelwert = (groups[index].minECTS+groups[index].maxECTS)/2; 
			});
 
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

			var svg = d3.select("#left").append("svg")
				.attr("width", width)
				.attr("height", height)
				.attr("class" ,"svg-klasse")
				.attr("text-anchor", "middle")
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
				        .text(d.data.id + '\n' + d.data.name + '\n' + ' [' + d.data.minECTS + ' – ' + d.data.maxECTS + ' ECTS-Punkte]')
			});

			g.on('mouseout', function(d){
				$("text").hide();
				// folgende Zeile wird gebraucht, da sich die text-Element aus g.on('mouseover', …) sonst in der html-Datei ansammlen
				d3.selectAll("text").remove(); 
			});

			$('#ajax-loader').hide();
 
			$(function() {
				$("#überschrift-pflichtmodule").append('<h3> Pflichtmodule </h3>');	
				$("#überschrift-pflichtmodule").hide(); 
				$("#überschrift-wahlmodule").append('<h3> Wahlmodule </h3>');
				$("#überschrift-wahlmodule").hide(); 
				});

			g.on('click', function(d){
				$('h1#ajax-loader').show(); 
				$.getJSON('/php/moduleGroups.php?module_details=' + d.data.id, function(data_details){
					details = data_details.details; 

					$("#details").empty();
					$("#tabelle-pflichtmodule").empty(); 
					$("#tabelle-wahlmodule").empty(); 
					$("#überschrift-pflichtmodule").hide(); 
					$("#überschrift-wahlmodule").hide(); 
					
					$("#details")
						.append('<p><h2 id="h2right"><em>' + details.id + ' </em> ' + details.name + '</h2>'+' ['+ d.data.minECTS+' – '+d.data.maxECTS+ ' ECTS-Punkte]</p>'); 
					$("#details")
						.append('<p>' + details.description + '</p>');
		
//tabelle-pflichtmodule, diese id einbauen
					var ersterDurchlauf = true;
					$.each( details.courses, function( index, course ){
						if(course.mandatory == true && ersterDurchlauf==true){
							$("#überschrift-pflichtmodule").show();
							$("#tabelle-pflichtmodule").append('<table> <th> Kürzel</th><th>Bezeichnung</th><th>Semester</th><th>ECTS</th>');
							ersterDurchlauf=false;
						};
					});
					$.each( details.courses, function( index, course ){
						if(course.mandatory == true){
						$("#tabelle-pflichtmodule").append('<tr><td>' + course.short_name +'</td><td>'+ course.full_name+'</td><td>'+course.semester+'</td><td>'+course.ects+'</td></tr>');		
						$("#tabelle-pflichtmodule").append('</table> ');
						};
					});
						/*$.each( details.courses, function( index, course ){

						if(course.mandatory == false){
							$("#überschrift-wahlmodule").show(); 
							$("#tabelle-wahlmodule").append('<p>' + course.short_name + '</p>');
						}
						*/
						
					});

					$('#ajax-loader').hide(); 
				});
			});
	}); 

/*
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
*/

