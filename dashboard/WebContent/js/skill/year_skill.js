
var webUrl ="http://localhost:8080/dashboard/api/"; 

/* yearly amount disbursed */

$(document).ready(function(){
   	
   	 console.log( "ready!" );
     
   	   	        	     	 	
        $.ajax({
       	  	  url: webUrl+"yearly_skill_amount/",
       	        method:"GET",
       	         dataType:"JSON",
       	        success:function(jsonData){
       	        	
       	        	drawChartAmountSanctioned(jsonData);
       	            drawTableAmountSanctioned(jsonData);
       	        }
       	    });
       	
       console.log( "Column Chart ready!" );
        
       });
   
   
  
   
   function drawChartAmountSanctioned(jsonData) {
	   
	  	   	   
  	   var labels = jsonData.yearly_amount_sanctioned.map(function(e) {
		   return e.year;
		});
		var data = jsonData.yearly_amount_sanctioned.map(function(e) {
			return e.amount_al;
		});
	   
		
	   
	   var ctx = document.getElementById('myChartAmount');
	

	   var myChart = new Chart(ctx, {
	      type: 'bar',
	      data: {
	    	  labels: labels,
	          datasets: [{
	              label: 'Amount Sanctioned (in Lakhs) ',
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

   
   function drawTableAmountSanctioned(jsonData) {
	   
	  var tableData = jsonData.yearly_amount_sanctioned;
	   
	    $(document).ready(function() {
		    $('#amountTable').DataTable( {
		    	"data" : tableData,
		        "columns": [
		            { "data": "year" },
		            { "data": "amount_al"}
		         ]
		    } );
		} );
	
    }
   
   
   
   
   
   
   
   
   /* trainees trained */

   $(document).ready(function(){
      	
      	 console.log( "ready!" );
        
      	   	        	     	 	
           $.ajax({
          	  	  url: webUrl+"yearly_trainee_trained/",
          	        method:"GET",
          	         dataType:"JSON",
          	        success:function(jsonData){
          	        	
          	           drawChartTraineeTrained(jsonData);
          	           drawTableTraineeTrained(jsonData);
          	        }
          	    });
          	
          console.log( "Column Chart ready!" );
           
          });
      
      
     
      
      function drawChartTraineeTrained(jsonData){
    	  
    	   	   
     	   var labels = jsonData.yearly_trainee_trained.map(function(e) {
   		    return e.year;
   		});
   		var data = jsonData.yearly_trainee_trained.map(function(e) {
   		    return e.trainee;
   		});
   		
   			   
   	 		
   	   var ctx = document.getElementById('myChartTrainee');
   	   var myChart = new Chart(ctx, {
   	      type: 'bar',
   	      data: {
   	    	  labels: labels,
   	          datasets: [{
   	              label: 'Trainees Trained (in Numbers)',
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

      
      function drawTableTraineeTrained(jsonData) {
   	   
   	   var tableData = jsonData.yearly_trainee_trained;
   	   
   	    $(document).ready(function() {
   		    $('#benTable').DataTable( {
   		    	"data" : tableData,
   		        "columns": [
   		            { "data": "year" },
   		            { "data": "trainee"}
   		         ]
   		    } );
   		} );
   	
       }
  
   
  
   

   
   
  
   
   
   
  