<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      async function drawChart() {
        //[{'Admin':1},{'Accounting':2}.......]
         console.log("1"); 
        
        let outAry = [];
        outAry.push(['dept', 'cnt per dept']); 
        let promise1 = await fetch('chartAjax.do') //promise객체.  await가 붙으면 다음 구문 실행하지않고 기다림
        console.log(promise1);
        
        let promise2 = await promise1.json(); // [{},{},{}]}
        console.log(promise2);
        promise2.forEach(dept =>{
        	let ary =[];
        	for(let prop in dept){
        		ary[0] = prop;
        		ary[1] = dept[prop];
        	}
        	 outAry.push(ary); 
        })
        
        console.log("1-2");
          var data = google.visualization.arrayToDataTable(outAry); //아래의 배열을 위 outAry가 대체한다.
          var options = {
            title: 'Person By Department'
          };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
		console.log("2");
       
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
