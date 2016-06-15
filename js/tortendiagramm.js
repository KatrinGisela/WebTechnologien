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

			var svg = d3.select("#left").append("svg")
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
			        .text(d.data.id + " \n" + d.data.name + " \n"+' ['+ d.data.minECTS+' - '+d.data.maxECTS+ ' ECTS-Punkte]')
			});

			g.on('mouseout', function(d){
				$("text").hide();
				// folgende Zeile wird gebraucht, da sich die text-Element aus g.on('mouseover', …) sonst in der html-Datei ansammlen
				d3.selectAll("text").remove(); 
			});


$(function() {$("#überschrift-pflichtmodule").append('<h3> Pflichtmodule </h3>');	
					$("#überschrift-wahlmodule").append('<h3> Wahlmodule </h3>');
				$("#überschrift-pflichtmodule").hide(); 
				$("#überschrift-wahlmodule").hide(); 
			});


			g.on('click', function(d){
				$('#ajax-loader').show(); 
				$.getJSON('/php/moduleGroups.php?module_details=' + d.data.id, function(data_details){
					details = data_details.details; 

					// html-Funktion ersetzen mit einer Funktion, die vor #überschrift-pflichtmodule einfügt 
	
					$("#right").html('<p><h2 id="h2right"><em>' +  details.id + ' </em> ' + details.name + '</h2>'+' ['+ d.data.minECTS+' - '+d.data.maxECTS+ ' ECTS-Punkte] </p>'); 
					$("#right").append('<p>' + details.description + '</p>');
					$("#right").append('<hr />');					

					$.each( details.courses, function( index, course ){
							var counter = 0;
						if(course.mandatory == true|| counter==0){
							$("#überschrift-pflichtmodule").show(); 
							$("#right").append('<table> <th> Kürzel</th><th>Bezeichnung</th><th>Semester</th><th>ECTS</th>');
						counter=1;
						};
						if(course.mandatory == true){
						$("#right").append('<tr><td>' + course.short_name +'</td><td>'+ course.full_name+'</td><td>'+course.semester+'</td><td>'+course.ects+'</td></tr>');		
						};
					});
						$("#right").append('</table> ');
						/*$.each( details.courses, function( index, course ){
						if(course.mandatory == false){
							console.log("mandatory == false : " + course.mandatory); 
							$("#überschrift-wahlmodule").show(); 
							$("#right").append('<p>' + course.short_name + '</p>');
						}
						*/
						
					console.log(details.courses); 

					$('#ajax-loader').hide(); 
				});
			});
	}); 
}) 


