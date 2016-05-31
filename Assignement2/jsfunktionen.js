
$(document).ready(function(){
    /* Hier der jQuery-Code */
	
	<!-- /* Hier irgendwo müssen per GET-Request (Kombi aus jQuery und AJAX)  
die .php-Dateien zu den Modulen eingebunden werden */ -->

/* Hier die dazugehörigen ids im Body bauen, die aufgerufen werden (einzelne ids= einzelne Donut-Abschnitte*/

<script type="text/javascript">
		$(function() {
			$('#submit').click(function(){
				var MyText = $('input[id=MeinText]').val();	 // id anpassen
				
				$.get("moduleGroups.php",
					  { text: MyText },									// anpassen
				      function(data) {
					     $('#result').html(data);						// was ist in dem Fall result? das Laden der entsprecheneden Infos zum Modul
                         alert('Load was performed.');
                      });
			});
		});
	</script>
