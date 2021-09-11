// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Bar Chart Example
function getBar(total){
	var ctx = document.getElementById("myBarChart");
	var myLineChart = new Chart(ctx, {
	  type: 'bar',
	  data: {
	    labels: ["January", "February", "March", "April", "May", "June", "july", "august", "september", "october", "november", "december"],
	    datasets: [{
	      label: "Revenue",
	      backgroundColor: "rgba(2,117,216,1)",
	      borderColor: "rgba(2,117,216,1)",
	      data: total,
	    }],
	  },
	  options: {
	    scales: {
	      xAxes: [{
	        time: {
	          unit: 'month'
	        },
	        gridLines: {
	          display: false
	        },
	        ticks: {
	          maxTicksLimit: 12
	        }
	      }],
	      yAxes: [{
	        ticks: {
	          min: 0,
	          max: 20000000,
	          maxTicksLimit: 5
	        },
	        gridLines: {
	          display: true
	        }
	      }],
	    },
	    legend: {
	      display: false
	    }
	  }
	});
};