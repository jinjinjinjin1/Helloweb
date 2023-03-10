<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix = "fmt" %>

<!-- product/productList.jps -->
<!--Section -->
 <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                   <c:forEach var="product" items="${products }"> 
                    <div class="col mb-5">
                    </c:forEach>
                       
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            
                            <!-- Product image-->
                            <img class="card-img-top" src="image/${product.image }" alt="..." />
                            
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center" value ="${product.productDesc }">
                                   
                                    <!-- Product name-->
                                    <h5 class="fw-bolder" value="${product.productName }"><h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                    <c:forEach begin="1" end="5-${product.likeIt }" var="${product.likeIt }">
                                      <div class="bi-star-fill"></div>
                                    </c:forEach>
                                      
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through" value = "${product.productPrice }"></span>
                                    value = "${product.salePrice }"
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