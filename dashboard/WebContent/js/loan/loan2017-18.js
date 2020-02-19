
var webUrl ="http://localhost:8080/dashboard/api/"; 

//bar graph
var barColors=["#D32F2F","#303F9F","#388E3C","#F57C00","#C2185B","#1976D2","#689F38","#E64A19","#0288D1","#AFB42B","#5D4037","#7B1FA2","#0097A7","#FBC02D","#616161","#512DA8","#00796B","#FFA000","#455A64","#003f5c","#58508d","#bc5090","#ff6361","#ffa600","#5899DA","#E8743B","#19A979","#ED4A7B","#945ECF"];

/* amount disbursed */

$(document).ready(function(){
   	
   	 console.log( "ready!" );
     
   	   	        	     	 	
        $.ajax({
       	  	  url: webUrl+"amount_2017_18/",
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
	   
  	   var labels = jsonData.amount.map(function(e) {
		   return e.state;
		});
		var data = jsonData.amount.map(function(e) {
			total_amount+=e.financial;
		   return e.financial;
		});
	   
		$('#total_amount_db').text(Math.round(total_amount*100)/100);
	   
	   
	   var ctx = document.getElementById('myChartAmount');
	   var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	    	  labels: labels,
	          datasets: [{
	              label: 'Amount Disbursed (in Lakhs)',
	              minBarLength: 10,
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
	           	       labelString: 'Amount Disbursed (in Lakhs)'
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

   
   function drawTableAmount(jsonData) {
	   
	   var tableData = jsonData.amount;
	   
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
          	  	  url: webUrl+"ben_2017_18/",
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
     	   
   	   var labels = jsonData.beneficiary.map(function(e) {
 		   return e.state;
 		});
 		var data = jsonData.beneficiary.map(function(e) {
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
   	              label: 'Beneficiaries Assisted (in Numbers) ',
   	              minBarLength: 10,
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
   	     	            labelString: 'Beneficiaries Assisted (in Numbers)'
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

      
      function drawTableBen(jsonData) {
   	   
   	   var tableData = jsonData.beneficiary;
   	   
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
  
   
  
   

   
   
  
   
   
   
  