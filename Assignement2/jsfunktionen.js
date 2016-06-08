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
$('<img src="img/ajax-loader.gif" alt="Animation, während die Seite lädt"/>').insertAfter('body'); 

// Laden von Daten mittels AJAX-Befehl: https://xuad.net/artikel/vom-einfachen-ajax-request-zum-komplexen-objektaustausch-mit-json-mittels-jquery/ 
// erster Aufruf onload
// S92!!! getJSON!

$.getJSON('/php/moduleGroups.php', function()

)


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


$("button#ajaxCall_a1").click(function() {
$.ajax({
	type: "GET",
	url: "moduleDefinitions.php",
	data: {
	[module_details:"A1"	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function(content) {
		$("#content").html(content);
		document.write("Test" + content)
	}
});

return false;
});


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
});


//  Aufruf  Detailinformationen zu A2
$.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	type: "GET",
	url: "moduleGroups.php",
	data: {
		module_details:"/php/moduleGroups?module_details=A2" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function a1_courses(content) {
		$("#content").html(content);
		document.write("Test" + content)
	}
});

return false;
});

//  Aufruf  Detailinformationen zu A3
$.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	type: "GET",
	url: "moduleGroups.php",
	data: {
		module_details:"/php/moduleGroups?module_details=A3" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function a1_courses(content) {
		$("#content").html(content);
		document.write("Test" + content)
	}
});

return false;
});





//  Aufruf  Detailinformationen zu A4
$.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	type: "GET",
	url: "moduleGroups.php",
	data: {
		module_details:"/php/moduleGroups?module_details=A4" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function a1_courses(content) {
		$("#content").html(content);
		document.write("Test" + content)
	}
});

return false;
});


//  Aufruf  Detailinformationen zu A5
$.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	type: "GET",
	url: "moduleGroups.php",
	data: {
		module_details:"/php/moduleGroups?module_details=A5" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function a1_courses(content) {
		$("#content").html(content);
		document.write("Test" + content)
	}

	
	return false;
});

// return false;
// });

// //  Aufruf  Detailinformationen zu A2
// $.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	// type: "GET",
	// url: "moduleGroups.php",
	// data: {
		// module_details:"/php/moduleGroups?module_details=A2" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	// },
	// success: function a1_courses(content) {
		// $("#content").html(content);
		// document.write("Test" + content)
	// }
// });

// return false;
// });

// //  Aufruf  Detailinformationen zu A3
// $.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	// type: "GET",
	// url: "moduleGroups.php",
	// data: {
		// module_details:"/php/moduleGroups?module_details=A3" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	// },
	// success: function a1_courses(content) {
		// $("#content").html(content);
		// document.write("Test" + content)
	// }
// });

// return false;
// });





// //  Aufruf  Detailinformationen zu A4
// $.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	// type: "GET",
	// url: "moduleGroups.php",
	// data: {
		// module_details:"/php/moduleGroups?module_details=A4" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	// },
	// success: function a1_courses(content) {
		// $("#content").html(content);
		// document.write("Test" + content)
	// }
// });

// return false;
// });


// //  Aufruf  Detailinformationen zu A5
// $.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	// type: "GET",
	// url: "moduleGroups.php",
	// data: {
		// module_details:"/php/moduleGroups?module_details=A5" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	// },
	// success: function a1_courses(content) {
		// $("#content").html(content);
		// document.write("Test" + content)
	// }
// });

// return false;
// });

// //  Aufruf  Detailinformationen zu A6
// $.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	// type: "GET",
	// url: "moduleGroups.php",
	// data: {
		// module_details:"/php/moduleGroups?module_details=A6" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	// },
	// success: function a1_courses(content) {
		// $("#content").html(content);
		// document.write("Test" + content)
	// }
// });

// return false;
// });

});

return false;
});

//  Aufruf  Detailinformationen zu A6
$.getJSON('/php/moduleGroups?module_details=A6', function(data, textStatus, jqXHR) {
	type: "GET",
	url: "moduleGroups.php",
	data: {
		module_details:"/php/moduleGroups?module_details=A6" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function a1_courses(content) {
		$("#content").html(content);
		document.write("Test" + content)
	}
});

return false;
});


// //  Aufruf  Detailinformationen zu A7
// $.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	// type: "GET",
	// url: "moduleGroups.php",
	// data: {
		// module_details:"/php/moduleGroups?module_details=A7" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	// },
	// success: function a1_courses(content) {
		// $("#content").html(content);
		// document.write("Test" + content)
	// }
// });

// return false;
// });

//  Aufruf  Detailinformationen zu A7
$.getJSON('moduleDefinitions.php', function(data, textStatus, jqXHR) {
	type: "GET",
	url: "moduleGroups.php",
	data: {
		module_details:"/php/moduleGroups?module_details=A7" 	// alternativ: Variable außerhalb definieren und hier einbeziehen // ID hier eingeben
	},
	success: function a1_courses(content) {
		$("#content").html(content);
		document.write("Test" + content)
	}
});

return false;
});


function daten_laden() {
		$.get('moduleDefinitions.php', function(content) {
				$("#content").html(content);
		document.write("Test" + content)	
		})
	}
 



