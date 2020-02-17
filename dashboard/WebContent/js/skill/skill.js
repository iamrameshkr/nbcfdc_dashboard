
var webUrl ="http://localhost:8080/dashboard/api/"; 

/* amount disbursed */

$(document).ready(function(){
   	
   	 console.log( "ready!" );
     
   	   	        	     	 	
        $.ajax({
       	  	  url: webUrl+"cumulative_amount_sanctioned/",
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
	   var labels = jsonData.cumulative_amount_sanctioned.map(function(e) {
		   return e.state;
		});
		var data = jsonData.cumulative_amount_sanctioned.map(function(e) {
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
	              backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
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
	   
	   var tableData = jsonData.cumulative_amount_sanctioned;
	   
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
          	  	  url: webUrl+"cumulative_trainees_trained/",
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
   	   
     	   var labels = jsonData.cumulative_trainee.map(function(e) {
   		   return e.state;
   		});
   		var data = jsonData.cumulative_trainee.map(function(e) {
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
	              backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
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
   	   
   	   var tableData = jsonData.cumulative_trainee;
   	   
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
  
   
  
   

   
   
  
   
   
   
  