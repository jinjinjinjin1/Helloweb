<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">SKU: BST-498</div>
                        <h1 class="display-5 fw-bolder">Shop item template</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through">$45.00</span>
                            <span>$40.00</span>
                        </div>
                        <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi consequatur obcaecati excepturi alias magni, accusamus eius blanditiis delectus ipsam minima ea iste laborum vero?</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <input type = "text" id ="writer" value ="user02">
        <input type = "text" id ="content">
        <button id ="addContent"> 댓글등록 </button>
        <br>
        
      
        <table class="table">
         <thead>
          <tr>
           <th>댓글번호</th>
           <th>작성자</th>
           <th>댓글내용</th>
           <th>삭제</th>
           </tr>
         </thead>
        <tbody id="list">
         <tr>
          <td>1</td>
          <td>user01</td>
          <td>reply test</td>
          <td><button>삭제</button></td>
         </tr>
        </tbody>
        </table>
        
        <script>
        //목록데이터가져오는것
        //let promiseResult= fetch('')
        //promiseResult.then(function(){});
     	fetch('replyListAjax.do?code=CF0001') //괄호 안의 주소를 JSON 포맷으로 가져온다
     	.then(resolve => resolve.json()) //[{"id" : "user1", "name" : "Hong"}]
     	.then(result => {
     		console.log(result);
     		//값을 이용해서 tr 생성.
     		result.forEach(function(reply){
     		makeRow(reply)
     		});
     	})
     	.catch(reject => console.error(reject));
     	
        	
        let showProps=['replyNo','replyWriter','replyContent'];
        function makeRow(reply={}){ //tr > td*4
     		let tr =document.createElement('tr'); //<tr></tr>
     		tr.addEventListener('dblclick',modifyTr)
     		tr.id = reply.replyNo; // tr의 id의 attribute에 
     		console.log(tr.id);
     		showProps.forEach(function (prop){
     		let td =document.createElement('td'); //<td></td>생성
     		td.innerText = reply[prop];
     		console.log(reply[prop]);
     		tr.append(td);
     		})
     		
     		let td =document.createElement('td');
     		let btn = document.createElement('button');
     		btn.addEventListener('click',removeReply); //삭제처리
     		btn.innerText='삭제';
     		td.append(btn);
     		tr.append(td);
     		document.querySelector('#list').append(tr);
     		}
     	
        	function modifyTr(){
        		console.log(this);
        		let oldTr = this;
        		//데이터 결과 가져왔다치공..
        		//let data = {replyNo: 15,replyWriter:'user02',replyContent:'tttt'};
        		let data = {replyNo: 15,replyWriter:'user02',replyContent:'changetttt'};
        		let newTr = document.createElement('tr');
        		let td = document.createElement('td');
        		td.innerText = data.replyNo;
        		newTr.append(td);
        		
        		td = document.createElement('td');
        		td.innerText = data.replyWriter;
        		newTr.append(td);
        		
        		td = document.createElement('td');
        		let input = document.createElement('input');
        		input.value = data.replyContent;
        		td.append(input);
        		newTr.append(td);
        		
        		td = document.createElement('td');
        		let btn = document.createElement('button');
        		btn.innerText='저장';
        		btn.addEventListener('click',updateReply);
        		td.append(btn);
        		newTr.append(td);
        		
        		console.log(newTr);
        		document.getElementById('list').replaceChild(newTr,oldTr);
        	}
        	
        	function updateReply(){
        		
        		
        		
        		
        		
        	}
        
     		//댓글번호() 데이터를 삭제기능(컨트롤) + 화면에서 삭제(elem.remove())
     		function removeReply(){
     			console.log(this.parentElement.parentElement.id); //this 키워드 : 이벤트를 받는 대상.
     			let id = this.parentElement.parentElement.id; //아이디번호
     			
     			fetch('replyRemoveAjax.do?replyId='+id)
     			.then(resolve => resolve.json())
     			.then(result => {
     				console.log(result);
     				if(result.retCode =='Success'){
     					alert('성공');
     					document.getElementById(id).remove();
     				}else if(result.retCode =='Fail'){
     					alert('실패');
     				}else{
     					alert('retCode값을 확인하세요!!')
     				}
     			})
     			.catch(reject => console.error(reject));
     			
     		
     		}
     		
     		//댓글 등록.
     		document.querySelector('#addContent').addEventListener('click',addReply);
     		function addReply(){
     			//writer,content의 value.
     			let writer = document.querySelector('#writer').value;
     			let content = document.querySelector('#content').value;
     			
     			fetch('replyAddAjax.do',{//호출할 프론트컨트롤 map의 url주소
     				method:'post', 
     				headers:{'Content-Type' : 'application/x-www-form-urlencoded'},
     				body:'writer='+writer+'&content='+content+'&pcode=CF0001'
     			})
     			.then(resolve => resolve.json())
     			.then(result =>{
     				console.log(result);
     				if(result.retCode =='Success'){
     					alert('성공');
     					makeRow(result.reply);
     				}else if(result.retCode == 'Fail'){
     					alert('실패')
     				}else {
     					alert("retCode를 확인하세요")
     				}
     			})
     			.catch(reject => console.error(reject))
     		}
     		
     		//댓글 수정 
     		
     		
     		
     		

        </script>
        
        
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Related products</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Fancy Product</h5>
                                    <!-- Product price-->
                                    $40.00 - $80.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Special Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$20.00</span>
                                    $18.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Sale Item</h5>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$50.00</span>
                                    $25.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Popular Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>