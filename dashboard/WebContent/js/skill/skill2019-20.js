
var webUrl ="http://localhost:8080/dashboard/api/"; 

var barColors=["#D32F2F","#303F9F","#388E3C","#F57C00","#C2185B","#1976D2","#689F38","#E64A19","#0288D1","#AFB42B","#5D4037","#7B1FA2","#0097A7","#FBC02D","#616161","#512DA8","#00796B","#FFA000","#455A64","#003f5c","#58508d","#bc5090","#ff6361","#ffa600","#5899DA","#E8743B","#19A979","#ED4A7B","#945ECF"];

/* amount sanctioned */

$(document).ready(function(){
   	
   	 console.log( "ready!" );
     
   	   	        	     	 	
        $.ajax({
       	  	  url: webUrl+"amount_sanctioned_2019_20/",
       	        method:"GET",
       	         dataType:"JSON",
       	        success:function(jsonData){
       	        	
       	        	drawChartAmountDis(jsonData);
       	            drawTableAmountDis(jsonData);
       	        }
       	    });
       	
       console.log( "Column Chart ready!" );
        
       });
   
   
  
   
   function drawChartAmountDis(jsonData) {
	   
	   var total_amount=0;
	   var labels = jsonData.amount_sanctioned.map(function(e) {
		   return e.state;
		});
		var data = jsonData.amount_sanctioned.map(function(e) {
			total_amount+=e.amount_al;
		   return e.amount_al;
		});
		
		
		$('#amount_al').text(Math.round(total_amount*100)/100);
	   
	   
	   var ctx = document.getElementById('myChartAmount');
	   var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	    	  labels: labels,
	          datasets: [{
	              label: 'Amount Sanctioned (in Lakhs)',
	              data: data,
	              backgroundColor:barColors,
	              borderWidth: 1
	          }]
	      },
	      options: {
	          scales: {
	              yAxes: [{
	                  ticks: {
	                      beginAtZero: true
	                  },
	                  
	                  scaleLabel: {
		           	       display: true,
		           	       labelString: 'Amount Sanctioned (in Lakhs)'
	                  }
	                  
	              }]
	          },
	          
	          legend: {
	              display: false,
	                labels: {
	                  display: false
	                }
	            },
	      }
	  });
	
}

   
   function drawTableAmountDis(jsonData) {
	   
	   var tableData = jsonData.amount_sanctioned;
	   
	    $(document).ready(function() {
		    $('#amountTable').DataTable( {
		    	"data" : tableData,
		        "columns": [
		            { "data": "state" },
		            { "data": "amount_al"}
		         ]
		    } );
		} );
	
    }
   
   
   
   
   
   
   
   
   /* beneficiaries assisted */

   $(document).ready(function(){
      	
      	 console.log( "ready!" );
        
      	   	        	     	 	
           $.ajax({
          	  	  url: webUrl+"trainee_2019_20/",
          	        method:"GET",
          	         dataType:"JSON",
          	        success:function(jsonData){
          	        	
          	           drawChartTrainee(jsonData);
          	           drawTableTrainee(jsonData);
          	        }
          	    });
          	
          console.log( "Column Chart ready!" );
           
          });
      
      
     
      
      function drawChartTrainee(jsonData) {
   	   
    	  var total_trainee=0;
      	   
    	   var labels = jsonData.trainees_trained.map(function(e) {
  		   return e.state;
  		});
  		var data = jsonData.trainees_trained.map(function(e) {
  			total_trainee+=e.trainee;
  		   return e.trainee;
  		});
  	   
  		$('#trainees_trained').text(total_trainee);
   	   
   	  
	   var ctx = document.getElementById('myChartTrainee');
   	   var myChart = new Chart(ctx, {
   	      type: 'bar',
   	      data: {
   	    	  labels: labels,
   	          datasets: [{
   	              label: 'Trainees Trained (in Numbers)',
   	              data: data,
   	              backgroundColor:barColors,
   	              borderWidth: 1
   	          }]
   	      },
   	      options: {
   	          scales: {
   	              yAxes: [{
   	                  ticks: {
   	                      beginAtZero: true
   	                  },
   	                  
   	               scaleLabel: {
	           	       display: true,
	           	       labelString: 'Trainees Trained (in Numbers)'
	           	   }
   	                  
   	              }]
   	          },
   	          
   	          legend: {
   	              display: false,
   	                labels: {
   	                  display: false
   	                }
   	            },
   	      }
   	  });
   	
   }

      
      function drawTableTrainee(jsonData) {
   	   
   	   var tableData = jsonData.trainees_trained;
   	   
   	    $(document).ready(function() {
   		    $('#benTable').DataTable( {
   		    	"data" : tableData,
   		        "columns": [
   		            { "data": "state" },
   		            { "data": "trainee"}
   		         ]
   		    } );
   		} );
   	
       }
  
   
  
   

   
   
  
   
   
   
  