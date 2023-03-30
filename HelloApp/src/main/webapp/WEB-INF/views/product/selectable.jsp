<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <link rel="icon" type="image/png" href="http://example.com/myicon.png">
  <meta charset='utf-8' />
  <script src='./full/dist/index.global.js'></script>
  <script>
    document.addEventListener('DOMContentLoaded', async function () {
      //fetch api를 사용.
      //컨트롤사용
      let events = [];
        let promise1 = await fetch('fullcalendarAjax.do') //promise객체.  await가 붙으면 다음 구문 실행하지않고 기다림
  
        let promise2 = await promise1.json(); // [{},{},{}]}
       // events = promise2;

       promise2.forEach(cal => {
    	   let obj = {title: cal.title, start: cal.startDate, end: cal.endDate}
    	   events.push(obj)
       })

      var calendarEl = document.getElementById('calendar');

      var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        initialDate: new Date(),
        navLinks: true, // can click day/week names to navigate views
        selectable: true,
        selectMirror: true,
        select: function (arg) {
          var title = prompt('일정등록:');
          
          if (title) {
        	  console.log(arg)
        	  fetch('calendalAddAjax.do',{
        		  method:'post',
        		  headers:{'Content-Type': 'application/x-www-form-urlencoded'},
        		  body:'title='+title+'&startDate='+arg.startStr+'&endDate='+arg.endStr
        	  })
        	  .then(resolve =>resolve.json())
        	  .then(result => {
        		console.log(result);
        		if(result.retCode =='Success'){
 					alert('성공');
		            calendar.addEvent({
		              title: title,
		              start: arg.start,
		              end: arg.end,
		              allDay: arg.allDay
		            })
        		}else if(result.retCode == 'Fail'){
 					alert('실패')
        		}else {
     				alert("retCode를 확인하세요")
 				}
        	  })
        	  .catch(reject=>console.error(reject));
        	  
          }
          calendar.unselect()
        },
        eventClick: function (arg) {
          if (confirm('이벤트를 삭제하시겠습니까?')) {
            arg.event.remove()
          }
        },
        editable: true,
        dayMaxEvents: true, // allow "more" link when too many events
        events: events
      });

      calendar.render();
    });
  </script>
  
  <style>
    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>

<body>

  <div id='calendar'></div>

</body>

</html>
