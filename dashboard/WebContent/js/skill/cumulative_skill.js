
var webUrl ="http://localhost:8080/dashboard/api/"; 

/* amount disbursed */

$(document).ready(function(){
   	
   	 console.log( "ready!" );
     
   	   	        	     	 	
        $.ajax({
       	  	  url: webUrl+"cumulative_amount_sanctioned/",
       	        method:"GET",
       	         dataType:"JSON",
       	        success:function(jsonData){
     	            getCumulativeAmountSanctioned(jsonData);
      	        }
       	    });
       	
       console.log( "Column Chart ready!" );
        
       });
   
   
  
   
   function getCumulativeAmountSanctioned(jsonData) {
	   
  	   var total_amount=0;
	   var labels = jsonData.cumulative_amount_sanctioned.map(function(e) {
		   return e.state;
		});
		var data = jsonData.cumulative_amount_sanctioned.map(function(e) {
			total_amount+=e.amount_al;
		   return e.amount_al;
		});
		
		
		$('#amount_al').text(Math.round(total_amount*100)/100);
   }

   
 
   
   
   
   
   
   
   
   
   /* trainees trained */

   $(document).ready(function(){
      	
      	 console.log( "ready!" );
        
      	   	        	     	 	
           $.ajax({
          	  	  url: webUrl+"cumulative_trainees_trained/",
          	        method:"GET",
          	         dataType:"JSON",
          	        success:function(jsonData){
          	         getTraineesTrained(jsonData);
          	        }
          	    });
          	
          console.log( "Column Chart ready!" );
           
          });
      
      
     
      
      function getTraineesTrained(jsonData) {
    	  
    	  var total_trainee=0;
   	   
     	   var labels = jsonData.cumulative_trainee.map(function(e) {
   		   return e.state;
   		});
   		var data = jsonData.cumulative_trainee.map(function(e) {
   			total_trainee+=e.trainee;
   		   return e.trainee;
   		});
   	   
   		$('#trainees_trained').text(total_trainee);
   }

      
     
   
  
   

   
   
  
   
   
   
  