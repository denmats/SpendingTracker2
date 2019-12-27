$.ajax({
	url: "piechart",
	success: function(result){
		var series =[];
		var data =[];
		for(var i=0; i<result.length; i++){
			var object = {};
			object.name=result[i].operation.toUpperCase();
			object.y=result[i].sum;
			data.push(object);
		}
		var seriesObject = {
				name: 'Expense',
				colorByPoint: true,
				data: data
		}
		series.push(seriesObject);
		drawPieChart(series);
	}
});
 

function drawPieChart(series){
	Highcharts.chart('container', {
	    chart: {
	    	backgroundColor: 'transparent',
	    	plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: 'Expenses'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	            }
	        }
	    },
	    series: series
	});
}
