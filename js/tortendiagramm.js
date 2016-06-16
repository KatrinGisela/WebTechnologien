$(function() {$('<img id="ajax-loader" src="img/ajax-loader.gif" alt="Animation, während die Seite lädt"/>').insertAfter('h1');

$.getJSON('/php/moduleGroups.php', 
		function(data) {
			groups = data.groups; 

			$.each( groups, function( index, group){
				groups[index].mittelwert = (groups[index].minECTS+groups[index].maxECTS)/2; 
			});
 
			var categorical_colors = d3.scale.category10(); 
			var width = 400,
			    height = 400,
			    radius = Math.min(width, height) / 2;

			var color = d3.scale.category10(); 

			var arc = d3.svg.arc()
			    .outerRadius(radius - 10)
			    .innerRadius(radius - 70);

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
				var hovertext = g.append("text");
			        hovertext.append("tspan").text(d.data.id + '\n' )
					.attr("id","id")
				hovertext.append("tspan").text(d.data.name + '\n' )
					.attr("id","name")
				hovertext.append("tspan").text('[' + d.data.minECTS + ' – ' + d.data.maxECTS + ' ECTS-Punkte]' )
					.attr("id","ects")
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
				$('#ajax-loader').show(); 
				$("#details").empty();
				$("#tabelle-pflichtmodule").empty(); 
				$("#tabelle-wahlmodule").empty(); 
				$("#überschrift-pflichtmodule").hide(); 
				$("#überschrift-wahlmodule").hide(); 
				$.getJSON('/php/moduleGroups.php?module_details=' + d.data.id, function(data_details){
					details = data_details.details; 
					$("#details")
						.append('<p><h2 id="h2right"><em>' + details.id + ' </em> ' + details.name + '</h2>'+' ['+ d.data.minECTS+' – '+d.data.maxECTS+ ' ECTS-Punkte]</p>'); 
					$("#details")
						.append('<p>' + details.description + '</p>');
		
//tabelle-pflichtmodule, diese id einbauen
					var ersterDurchlaufPflicht = true;
					$.each( details.courses, function( index, course ){
						if(course.mandatory == true && ersterDurchlaufPflicht==true){
							$("#überschrift-pflichtmodule").show();
							$("#tabelle-pflichtmodule").append('<table> <th> Kürzel</th><th>Bezeichnung</th><th>Semester</th><th>ECTS</th>');
							ersterDurchlaufPflicht=false;
						};
					});
					
					$.each( details.courses, function( index, course ){
						if(course.mandatory == true){
						$('table').append('<tr><td>' + course.short_name +'</td><td>'+ course.full_name+'</td><td>'+course.semester+'</td><td>'+course.ects+'</td></tr>');		
						
						};
					});
					var ersterDurchlaufWahl = true;
					$.each( details.courses, function( index, course ){
						if(course.mandatory == false && ersterDurchlaufWahl==true){
							$("#überschrift-wahlmodule").show();
							$("#tabelle-wahlmodule").append('<table> <th> Kürzel</th><th>Bezeichnung</th><th>Semester</th><th>ECTS</th>');
							ersterDurchlaufWahl=false;
						};
					});
					$.each( details.courses, function( index, course ){
						if(course.mandatory == false){
						$('table').append('<tr><td>' + course.short_name +'</td><td>'+ course.full_name+'</td><td>'+course.semester+'</td><td>'+course.ects+'</td></tr>');		
						
						};

				

					});
					$('#ajax-loader').hide(); 
				});
			});
		});
	}); 

