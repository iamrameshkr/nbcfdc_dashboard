
var webUrl ="http://localhost:8080/dashboard/api/"; 

/* yearly amount disbursed */

$(document).ready(function(){
   	
   	 console.log( "ready!" );
     
   	   	        	     	 	
        $.ajax({
       	  	  url: webUrl+"yearly_amount/",
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
	   	   
  	   var labels = jsonData.yearly_amount.map(function(e) {
		   return e.year;
		});
		var data = jsonData.yearly_amount.map(function(e) {
			 total_amount+=e.financial;
		   return e.financial;
		});
	   
		
	   
	   var ctx = document.getElementById('myChartAmount');
	

	   var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	    	  labels: labels,
	          datasets: [{
	              label: 'Amount Disbursed (in Lakhs) ',
	            //  minBarLength: 10,
	              barPercentage:0.4,
	              data: data,
	              backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
	              borderWidth: 1
	          }]
	      },
	      options: {
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
	          
	          tooltips: {
	              enabled: false
	            },
	          
	           hover: {
	              animationDuration: 0
	            },
	          
	          animation: {
	               duration: 0,
	              onComplete: function() {
	                var chartInstance = this.chart,
	                  ctx = chartInstance.ctx;

	                ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
	                ctx.textAlign = 'center';
	                ctx.textBaseline = 'bottom';

	                this.data.datasets.forEach(function(dataset, i) {
	                  var meta = chartInstance.controller.getDatasetMeta(i);
	                  meta.data.forEach(function(bar, index) {
	                    var data = dataset.data[index];
	                    ctx.fillText(data, bar._model.x, bar._model.y - 5);
	                  });
	                });
	              }
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
	   
	  var tableData = jsonData.yearly_amount;
	   
	    $(document).ready(function() {
		    $('#amountTable').DataTable( {
		    	"data" : tableData,
		        "columns": [
		            { "data": "year" },
		            { "data": "financial"}
		         ]
		    } );
		} );
	
    }
   
   
   
   
   
   
   
   
   /* beneficiaries assisted */

   $(document).ready(function(){
      	
      	 console.log( "ready!" );
        
      	   	        	     	 	
           $.ajax({
          	  	  url: webUrl+"yearly_ben/",
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
   	   
     	   var labels = jsonData.yearly_ben.map(function(e) {
   		   return e.year;
   		});
   		var data = jsonData.yearly_ben.map(function(e) {
   			total_ben+=e.physical;
   		   return e.physical;
   		});
   	   
   	 		
   	   var ctx = document.getElementById('myChartBen');
   	   var myChart = new Chart(ctx, {
   	      type: 'bar',
   	      data: {
   	    	  labels: labels,
   	          datasets: [{
   	              label: 'Beneficiaries Assisted',
   	              data: data,
   	              barPercentage:0.4,
	              backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
  	              borderWidth: 1
   	          }]
   	      },
   	      options: {
   	          scales: {
   	        	 yAxes: [{
	                  ticks: {
	                          beginAtZero: true,
	                    },
	                    scaleLabel: {
	     	                display: true,
	     	                labelString: 'Beneficiaries Assisted (in Numbers)'
	     	              }
	              }]	              
	             
   	          },
   	          

	          tooltips: {
	              enabled: false
	            },
	          
	           hover: {
	              animationDuration: 0
	            },
	          
	          animation: {
	               duration: 0,
	              onComplete: function() {
	                var chartInstance = this.chart,
	                  ctx = chartInstance.ctx;

	                ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
	                ctx.textAlign = 'center';
	                ctx.textBaseline = 'bottom';

	                this.data.datasets.forEach(function(dataset, i) {
	                  var meta = chartInstance.controller.getDatasetMeta(i);
	                  meta.data.forEach(function(bar, index) {
	                    var data = dataset.data[index];
	                    ctx.fillText(data, bar._model.x, bar._model.y - 5);
	                  });
	                });
	              }
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
   	   
   	   var tableData = jsonData.yearly_ben;
   	   
   	    $(document).ready(function() {
   		    $('#benTable').DataTable( {
   		    	"data" : tableData,
   		        "columns": [
   		            { "data": "year" },
   		            { "data": "physical"}
   		         ]
   		    } );
   		} );
   	
       }
  
   
  
   

   
   
  
   
   
   
  