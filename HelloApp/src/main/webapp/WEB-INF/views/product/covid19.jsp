<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 시도: <input type = "text" id="sido"> -->
	시도선택: <select id ="sidoList">
		

	</select>
	<button id ="sidoBtn">찾기</button>
	
	<h3>센터현황</h3>
	
	<table border="1">
	<thead>
	<tr>
	<th>ID</th><th>센터명</th><th>주소</th><th>연락처</th><th>시도</th>
	</tr>
	</thead>
	<tbody id = "centerList" ></tbody>
	</table>
	
	
	<script>
	let showFields = ['id', 'centerName','address', 'phoneNumber', 'sido']
	
	function makeTr(center={}){ //center는 오브젝트타입이다라고 적은것
		//tr생성>td*여러개.
		let tr = document.createElement('tr');
		//tr에 추가적인 정보들을 담아준다
		tr.setAttribute('data-lng',center.lng);  //setAttribute:추가적인정보를 다시 담아줌 
		tr.setAttribute('data-lat',center.lat); 
		tr.setAttribute('data-name',center.centerName);
		
		tr.addEventListener('click',openMapFnc); //tr에 클릭이벤트를 지도여는기능을 달아줌
		//tr.id = center.id;
		//console.log(center.id); 센터번호 1,2,3,4,5,...
		
		//td생성.
		showFields.forEach(function(filed) {
			let td = document.createElement('td');
			td.innerText = center[filed];
			//console.log(center[filed]); 센터명,주소,연락처,시도 데이터들
			tr.append(td);
	
		})
		return tr;	
	}
	
	
	function openMapFnc(){
		let tr = this; //event target.
		let lng = tr.dataset.lng; //tr.getAttribute('data-lng');
		let lat = tr.dataset.lat; //tr.getAttribute('data-lat');
		let centerName = tr.dataset.centerName; //tr.getAttribute('data-name');
		//location.href = 'map.do?lng='+ lng+ '&lat='+lat+'&centerName'+centerName;
		window.open('map.do?lng='+lng+'&lat='+lat+'&centerName'+centerName);
	}
	
	//전체목록.
	let totalList; //다른 함수에서도 활용.
	
	let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=tX4WELPFGCuNMg1hLNCS91Gdq%2BElnfbONnJkVmuErUj5gCC0gn03UZ%2FIB9GXjP4Vssm4DSpkLVpgfLd5Hc1EwQ%3D%3D`;
	fetch(url)
	.then(resolve =>resolve.json()) //요청 url을 json타입으로 변환하고
	.then(result => {
		//console.log(result); //그 결과를 console창에 찍자
		
		let aryData = result.data;
		totalList = aryData;
		aryData.forEach(function(center){
			let tr = makeTr(center);
			document.querySelector('#centerList').append(tr);
		});

		//시도배열.
		totalList; //{id,centerName,address,sido}
		//push (추가), pop(빼기),unshift, shift
		console.log(totalList);
		// ['대구광역시', '경기도']
		
		let sidoAry = [] 
		totalList.forEach(function(center){
			if(sidoAry.indexOf(center.sido) == -1){
				sidoAry.push(center.sido);
			}
		})
		sidoAry.forEach(function(sido){
		let opt = document.createElement('option');
		opt.value=sido;
		opt.innerText = sido;
		document.querySelector('#sidoList').append(opt);
	});
	})
	.catch(reject => console.error(reject)); //예외처리
	
	
	//찾기 버튼
	document.querySelector('#sidoBtn').addEventListener('click',findSidoFnc);
	function findSidoFnc(){
		//전체목록. 검색조건 filter한 결과를 tbody의 하위목록 출력.
		document.querySelector('#centerList').innerHTML ="";
		let searchWord = document.getElementById('sido').value;
		let filterAry = totalList.filter(function(center){ //filter는 forEach와 같은 기능
			console.log(center); //forEach와 차이점은 리턴하는 값이 true인 요소에대해서 새로운 배열에 담아줌
			return center.sido == searchWord;
		});
		console.log(filterAry);
		
		filterAry.forEach(center => {
			document.querySelector('#centerList').append(makeTr(center));
		})
		
	}

	</script>
</body>
</html>