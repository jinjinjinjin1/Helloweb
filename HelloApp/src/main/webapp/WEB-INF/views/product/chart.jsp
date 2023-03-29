<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        //[{'Admin':1},{'Accounting':2}.......]
        fetch('chartAjax.do')
        .then(resolve => resolve.json())
        .then(result => {
        //console.log(result);
        let outAry = [];
        outAry.push(['dept', 'cnt per dept']); //데이터의 제목이 들어있는 배열
        
        result.forEach(dept=> {
          //console.log(dept)
          let ary = []
          for (prop in dept) {
            ary[0] = prop;
            ary[1] = dept[prop];
          }
          //console.log(ary);
          outAry.push(ary); //가공한것
         })
          //가공한것뒤에 바로 차트를 가지고 와야 차트그려줌.
          var data = google.visualization.arrayToDataTable(outAry); //아래의 배열을 위 outAry가 대체한다.
          var options = {
            title: 'Person By Department'
          };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
        //console.log(outAry);
      })
      .catch(reject => console.error(reject))

        //   [
        //   ['Task', 'Hours per Day'],
        //   ['Work',     11],
        //   ['Eat',      2],
        //   ['Commute',  2],
        //   ['Watch TV', 2],
        //   ['Sleep',    7],
        //   ['Game',     2],
        // ]);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
