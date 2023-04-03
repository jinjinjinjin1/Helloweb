<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="jquery/jquery-3.6.4.min.js"></script>
  <script>
    //document 로딩 후 처리하겠습니다.
    $(document).ready(function () {
      $.ajax({
        //fetch('url',{option})
        url: "memberListJquery.do", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
        data: {
          name: "홍길동", //request.getParameter('name');
          id: 'user01' //request.getParameter('id');
        }, // HTTP 요청과 함께 서버로 보낼 데이터
        method: "GET", // HTTP 요청 방식(GET, POST)
        dataType: "json", // 서버에서 보내줄 데이터의 타입: JSON.parse()실행.
        success: function (result) { //서버요쳥의 성공시 실행.
          //JSON.parse(result); dataType 보내줄 방식이랑 같음
          console.log(result);
          $(result).each(function (idx, member) {
            console.log(idx, member);
            $('#list').append(
              //tr>td*4 생성.
              $('<tr id='+member.memberId+'/>').append($('<td />').text(member.memberId),
                $('<td />').text(member.memberName),
                $('<td />').text(member.memberAddr),
                $('<td />').text(member.memberTel),
                $('<td />').text(member.memberPw),
                $('<td />').append($('<button />')
                  .text('삭제')
                  .on('click', rowDeleteFnc)),
                $('<td />').append($('<input type ="checkbox" />')
                  .text('선택')
                  .attr('type', 'checkbox'))
              )
            );
          });
        },
        error: function (err) { //서버요청의 실패시 실행.
          console.error(err);
        }
      })
      //$.ajax()
      //추가버튼 이벤트 & 이벤트핸들러.    
      $('#addBtn').on('click', function (e) {
        e.preventDefault();
        //사용자가 필수입력값을 입력했는지 validation하고
        if ('#list input' == 0) { //필수 입력값이 빠졌으면
          return;
        }
        //ajax호출.
        /*   $.ajax({
          	url: "memberAddJquery.do",
          	data:{id:'',name:"홍길동", addr:'',tel: '', pw:''},
          	method:"post", //HTTP 요청방식(GET,POST)
          	dataType: "json",
          	succecss: function(result){
          		if(result.retCode=='Success'){
          			
          		}else if(reult.retCode =='Fail'){
          			
          		}else{
          			
          		}
          	},
          	error: function(reject){
          		
          	}
          }) */

        $('#list').append(
          //tr>td*4 생성.
          $('<tr />').append($('<td />').text($('#id').val()),
            $('<td />').text($('#name').val()),
            $('<td />').text($('addr').val()),
            $('<td />').text($('#tel').val()),
            $('<td />').text($('#passwd').val()),
            $('<td />').append($('<button />')
              .text('삭제')
              .on('click', rowDeleteFnc)),
            $('<td />').append($('<input type ="checkbox" />')
              .attr('type', 'checkbox'))
          )

        );

      })

      //선택삭제버튼 이벤트 & 이벤트 핸들러.
      $('#delSelected').on('click', function (e) {
        e.preventDefault();
        let memberIdAray = {}
        console.log($('#list input:checked').closest('tr'));
        //$('#list input:checked').closest('tr').remove();
        $('#list input:checked').each(function(idx,item){
          console.log($(item).parent().parent().attr('id'))})
          //memberIdAray.push({'memberId': item.memberId})
          memberIdAray.memberId = $(item).parent.
          //$(item).closest('tr').remove();
        })
        console.log(memberIdAray);

        //ajax호출.
        $.ajax({
          url:'memberRemoveJquery.do', //호출할 컨트롤
          method:'post',
          data:{memberId:'user01',memberId:'user02'}, //memberId = user01&memberId = user02를 넘기겠습니다.
          success: function(result){ 
            //성공하면
            
          },
          error: function(reject){
            //실패하면
          }
        })
      })

      //전체선택/ 전체해제
      $('th>input[type="checkbox"]').on('change', function () {
        //  $('td>input').attr('checked','checked')
        console.log(this.checked)
        $('td>input').prop({
          checked: this.checked
        })
      })

      //th>input 과 td>input을 비교해서 전체선택이 되도록.
      //선택된 갯수를 비교?
      //ajax 호출의 결과로 만들어지는 부분. 이벤트 위임.
      $('#list').on('change', 'td>input[type="checkbox"]', function () {
        //$('td>input[type="checkbox"]').on('change',function(){
        console.log(this);
        let checkCnt = $('td>input[type="checkbox"]:selected').length;
        let allCnt = $('td>input[type="checkbox"]').length;

        //전체개수 vs. 선택된 갯수 비교해서 
        if (checkCnt == allCnt) {
          $('th>input[type="checkbox"]').prop({
            checked: true
          })
        } else {
          $('th>input[type="checkbox"]').prop({
            checked: false
          })
        }



      })


      //삭제버튼 이벤트 & 이벤트 핸들러.
      function rowDeleteFnc() {
        //this는 이벤트를 만든 대상 button
        //$(this).parentsUntil('tbody').remove(); // tbody되기 전까지(=tr을 지운다)
        $(this).parent.parent.remove();
      }
    });
  </script>

</head>

<body>
  <div>
    <form>
      <table class="table" border="1">
        <tr>
          <td>Id:</td>
          <td><input type="text" id="id"></td>
        </tr>
        <tr>
          <td>Name:</td>
          <td><input type="text" id="name"></td>
        </tr>
        <tr>
          <td>Pass:</td>
          <td><input type="text" id="passwd"></td>
        </tr>
        <tr>
          <td>Addr:</td>
          <td><input type="text" id="addr"></td>
        </tr>
        <tr>
          <td>Tel:</td>
          <td><input type="text" id="tel"></td>
        </tr>
        <tr>
          <td colspan='2' align="center">
            <button id="addBtn">등록</button>
            <button id="delSelected">선택삭제</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
  <!--목록-->
  <div>
    <table class="table" border="1">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>주소</th>
          <th>연락처</th>
          <th>PASS</th>
          <th>삭제</th>
          <th><input type="checkbox"></th>
        </tr>
      </thead>
      <tbody id="list">
      </tbody>
    </table>
  </div>
</body>

</html>