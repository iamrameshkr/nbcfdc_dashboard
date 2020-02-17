
var localUrl ="http://localhost:8080/dashboard/api/"; 

/* cumulative amount disbursed */

$(document).ready(function(){
   	
   	 console.log( "ready!" );
     
   	   	        	     	 	
        $.ajax({
       	  	  url: localUrl+"cumulative_amount/",
       	        method:"GET",
       	         dataType:"JSON",
       	        success:function(jsonData){
       	  	         getCumulativeAmount(jsonData);
       	        }
       	    });
       	
       console.log( "Column Chart ready!" );
        
       });


// get Cumulative Amount
function getCumulativeAmount(jsonData) {
	
	 var total_amount=0;
 	   
	   var labels = jsonData.cumulative_amount.map(function(e) {
		   return e.year;
		});
		var data = jsonData.cumulative_amount.map(function(e) {
			 total_amount+=e.financial;
		   return e.financial;
		});
	   
   $('#total_amount_db').text(Math.round(total_amount*100)/100);
}





/* cumulative beneficiaries assisted */

$(document).ready(function(){
   	
  	 console.log( "ready!" );
    
  	   	        	     	 	
       $.ajax({
      	  	  url: webUrl+"cumulative_ben/",
      	        method:"GET",
      	         dataType:"JSON",
      	        success:function(jsonData){
      	  	         getCumulativeBen(jsonData);
      	        }
      	    });
      	
      console.log( "Column Chart ready!" );
       
      });


//get Cumulative Amount
function getCumulativeBen(jsonData) {
	
	 var total_ben=0;
	   
	   var labels = jsonData.cumulative_ben.map(function(e) {
		   return e.year;
		});
		var data = jsonData.cumulative_ben.map(function(e) {
			total_ben+=e.physical;
		   return e.physical;
		});
	   
   $('#ben_assisted').text(total_ben);
	
}