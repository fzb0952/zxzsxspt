/**
 * 
 */
$(document).ready(function() {  
       $("#formLogin").ajaxForm(function(data){  
             alert("post success." + data);  
             //Alert("post success.");  
       });            
});  