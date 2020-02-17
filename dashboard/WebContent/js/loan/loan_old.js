
var webUrl ="http://localhost:8080/dashboard/api/"; 

/* amount disbursed */

$(document).ready(function(){
   	
   	 console.log( "ready!" );
     
   	   	        	     	 	
        $.ajax({
       	  	  url: webUrl+"cumulative_amount/",
       	        method:"GET",
       	         dataType:"JSON",
       	        success:function(jsonData){
       	        	
       	           drawChartAmount(jsonData);
       	           drawTableAmount(jsonData);
       	        }
       	    });
       	
       console.log( "Column Chart ready!" );
        
       });
   
   
  
   
   function drawChartAmount(jsonData) {
	   
	   var total_amount=0;
	   	   
  	   var labels = jsonData.cumulative_amount.map(function(e) {
		   return e.state;
		});
		var data = jsonData.cumulative_amount.map(function(e) {
			 total_amount+=e.financial;
		   return e.financial;
		});
	   
		
		
		$('#total_amount_db').text(Math.round(total_amount*100)/100);
	   
	   var ctx = document.getElementById('myChartAmount');
	     ctx.height = 600;

	   var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	    	  labels: labels,
	          datasets: [{
	              label: 'Amount Disbursed ',
	              minBarLength: 10,
	              data: data,
	        
	              backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
	              borderWidth: 1
	          }]
	      },
	      options: {
	    	  maintainAspectRatio: false,
	          scales: {
	              yAxes: [{
	                  ticks: {
	                          beginAtZero: true,
                          
	                    },
	                  
	                  scaleLabel: {
	     	                display: true,
	     	                labelString: 'Amount Disbursed (in Lakhs)'
	     	              }
	                  
	              }]
	          },
	          
	          legend: {
	              display: false,
	                labels: {
	                  display: false
	                }
	            }
	            
	           
	      }
	  });
	
}

   
   function drawTableAmount(jsonData) {
	   
	   var tableData = jsonData.cumulative_amount;
	   
	    $(document).ready(function() {
		    $('#amountTable').DataTable( {
		    	"data" : tableData,
		        "columns": [
		            { "data": "state" },
		            { "data": "financial"}
		         ]
		    } );
		} );
	
    }
   
   
   
   
   
   
   
   
   /* beneficiaries assisted */

   $(document).ready(function(){
      	
      	 console.log( "ready!" );
        
      	   	        	     	 	
           $.ajax({
          	  	  url: webUrl+"cumulative_ben/",
          	        method:"GET",
          	         dataType:"JSON",
          	        success:function(jsonData){
          	        	
          	           drawChartBen(jsonData);
          	           drawTableBen(jsonData);
          	        }
          	    });
          	
          console.log( "Column Chart ready!" );
           
          });
      
      
     
      
      function drawChartBen(jsonData) {
    	  
    	  var total_ben=0;
   	   
     	   var labels = jsonData.cumulative_ben.map(function(e) {
   		   return e.state;
   		});
   		var data = jsonData.cumulative_ben.map(function(e) {
   			total_ben+=e.physical;
   		   return e.physical;
   		});
   	   
   	   
   		$('#ben_assisted').text(Math.round(total_ben*100)/100);
   		
   		
   		
   		
   	   var ctx = document.getElementById('myChartBen');
   	   var myChart = new Chart(ctx, {
   	      type: 'bar',
   	      data: {
   	    	  labels: labels,
   	          datasets: [{
   	              label: 'Beneficiaries Assisted ',
   	              minBarLength: 10,
   	              data: data,
	              backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],

   	         /*     backgroundColor: [
   	                  'rgba(255, 99, 132, 0.2)',
   	                  'rgba(54, 162, 235, 0.2)',
   	                  'rgba(255, 206, 86, 0.2)',
   	                  'rgba(75, 192, 192, 0.2)',
   	                  'rgba(153, 102, 255, 0.2)',
   	                  'rgba(255, 159, 64, 0.2)',
   	                  'rgba(255, 99, 132, 0.2)',
   	                  'rgba(54, 162, 235, 0.2)',
   	                  'rgba(255, 206, 86, 0.2)',
   	                  'rgba(75, 192, 192, 0.2)',
   	                  'rgba(153, 102, 255, 0.2)',
   	                  'rgba(255, 159, 64, 0.2)',
   	                  'rgba(255, 99, 132, 0.2)',
   	                  'rgba(54, 162, 235, 0.2)',
   	                  'rgba(255, 206, 86, 0.2)',
   	                  'rgba(75, 192, 192, 0.2)',
   	                  'rgba(153, 102, 255, 0.2)',
   	                  'rgba(255, 159, 64, 0.2)',
   	                  'rgba(255, 99, 132, 0.2)',
   	                  'rgba(54, 162, 235, 0.2)',
   	                  'rgba(255, 206, 86, 0.2)',
   	                  'rgba(75, 192, 192, 0.2)',
   	                  'rgba(153, 102, 255, 0.2)',
   	                  'rgba(255, 159, 64, 0.2)',
   	                  'rgba(255, 99, 132, 0.2)',
   	                  'rgba(54, 162, 235, 0.2)',
   	                  'rgba(255, 206, 86, 0.2)',
   	                  'rgba(75, 192, 192, 0.2)',
   	                  'rgba(153, 102, 255, 0.2)',
   	                  'rgba(255, 159, 64, 0.2)'
   	              ],
   	              borderColor: [
   	                  'rgba(255, 99, 132, 1)',
   	                  'rgba(54, 162, 235, 1)',
   	                  'rgba(255, 206, 86, 1)',
   	                  'rgba(75, 192, 192, 1)',
   	                  'rgba(153, 102, 255, 1)',
   	                  'rgba(255, 159, 64, 1)',
   	                  'rgba(255, 99, 132, 1)',
   	                  'rgba(54, 162, 235, 1)',
   	                  'rgba(255, 206, 86, 1)',
   	                  'rgba(75, 192, 192, 1)',
   	                  'rgba(153, 102, 255, 1)',
   	                  'rgba(255, 159, 64, 1)',
   	                  'rgba(255, 99, 132, 1)',
   	                  'rgba(54, 162, 235, 1)',
   	                  'rgba(255, 206, 86, 1)',
   	                  'rgba(75, 192, 192, 1)',
   	                  'rgba(153, 102, 255, 1)',
   	                  'rgba(255, 159, 64, 1)',
   	                  'rgba(255, 99, 132, 1)',
   	                  'rgba(54, 162, 235, 1)',
   	                  'rgba(255, 206, 86, 1)',
   	                  'rgba(75, 192, 192, 1)',
   	                  'rgba(153, 102, 255, 1)',
   	                  'rgba(255, 159, 64, 1)',
   	                  'rgba(255, 99, 132, 1)',
   	                  'rgba(54, 162, 235, 1)',
   	                  'rgba(255, 206, 86, 1)',
   	                  'rgba(75, 192, 192, 1)',
   	                  'rgba(153, 102, 255, 1)',
   	                  'rgba(255, 159, 64, 1)',
   	                  'rgba(255, 99, 132, 1)',
   	                  'rgba(54, 162, 235, 1)',
   	                  'rgba(255, 206, 86, 1)',
   	                  'rgba(75, 192, 192, 1)',
   	                  'rgba(153, 102, 255, 1)',
   	                  'rgba(255, 159, 64, 1)'
   	              ],*/
   	              borderWidth: 1
   	          }]
   	      },
   	      options: {
   	          scales: {
   	              yAxes: [{
   	                  ticks: {
   	                	suggestedMin: 1,
   	                    suggestedMax: 764097
   	                  },
   	                  
   	               scaleLabel: {
   	                display: true,
   	                labelString: 'Beneficiaries Assisted'
   	              }
   	                  
   	              }]
   	          },
   	          
   	          legend: {
   	              display: false,
   	                labels: {
   	                  display: true
   	                }
   	            },
   	      }
   	  });
   	
   }

      
      function drawTableBen(jsonData) {
   	   
   	   var tableData = jsonData.cumulative_ben;
   	   
   	    $(document).ready(function() {
   		    $('#benTable').DataTable( {
   		    	"data" : tableData,
   		        "columns": [
   		            { "data": "state" },
   		            { "data": "physical"}
   		         ]
   		    } );
   		} );
   	
       }
  
   
  
   

   
   
  
   
   
   
  