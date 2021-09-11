// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart Example
function getPie(total, crname, month){
   var ctx = document.getElementById("myPieChart");
   var myPieChart = new Chart(ctx, {
     type: 'pie',
     data: {
       labels: crname,
       datasets: [{
         data: total,
         backgroundColor: ['#4834d4', '#eb4d4b', '#f0932b', '#6ab04c', '#D980FA'],
       }],
     },
   });
};

