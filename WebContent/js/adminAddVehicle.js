// Automatically selects year 2019, if new:
$(function() {
 	$("#condition").change(function() {
 		$("#year option[value=2019]").attr('selected','selected');
 		// Prevents other choices.
 		//$("#year").attr('disabled','disabled');
 	});
}); 
 	
// Makes make/model drop-down menus dynamic:
$(function() {
    $("#make").change(function() {
        $("#model").load("WebContent/menu-dropdowns/" + $(this).val() + ".txt");
    });
});
 	
 // Formats date of purchase:
 $(function(){
 	$("#datepicker").datepicker({dateFormat: 'yy-mm-dd'}).val();
 });
