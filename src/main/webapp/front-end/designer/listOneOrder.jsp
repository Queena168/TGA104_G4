<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibame.designer.model.*" %>



<html>
<head>
<title>案件 - listOneOrder.jsp</title>

<meta charset="utf-8" />
<title>MatDesign</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="Free HTML Templates" name="keywords" />
<meta content="Free HTML Templates" name="description" />

<!-- Favicon -->
<link href="<%=request.getContextPath()%>/front-end/designer/img/favicon.ico" rel="icon" />

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap"
	rel="stylesheet" />

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet" />

<!-- Libraries Stylesheet -->
<link href="<%=request.getContextPath()%>/front-end/designer/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->

<link href="<%=request.getContextPath()%>/front-end/designer/css/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/front-end/designer/css/MatDesign.css" rel="stylesheet" />

<!-- Favicon -->
<link rel="icon" href="<%=request.getContextPath()%>/front-end/images/favicon.ico" sizes="32x32">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel='stylesheet' href='<%=request.getContextPath()%>/front-end/css/fontawesome.min.css'>
<!-- Animate -->
<link href="<%=request.getContextPath()%>/front-end/css/animate.css" rel="stylesheet">
<!-- Owl Carousel -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/owl.theme.default.min.css">
<!-- light box -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/lightbox.min.css">
<!-- jquery ui -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/jquery-ui.min.css">
<!-- nice select -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/nice-select.min.css">
<!-- Main Styles -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/scss/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/scss/main.css">


  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>


<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>


<style>


.wrap{
    margin: auto;
    margin-left: 500px;
}
.wrap1{
    margin: auto;
    margin-left: 300px;
}


#block1{
margin-left: 200px;
}
#block2{
margin-left: 500px;
}


#btn1{
float:left;
width: 100px;
margin-left: 450px;
}

#btn2{
float:left;
width: 100px;
margin-left: 20px;
}
</style>



<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 1100px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
 
#block2{
  margin-left: 50px;
}



@import url("https://fonts.googleapis.com/css2?family=Muli&display=swap");

/* 給一個 scope 設定變數 */
:root {
  /* 已完成進度的顏色 */
  --line-border-fill: #3498db;

  /* 未完成進度的顏色 */
  --line-border-empty: #e0e0e0;
}

/* 初始化一些基本排版 */
* {
  box-sizing: border-box;
}

.container1 {
  text-align: center;
  margin-left: 250px;
}

.progress-container {
  /* 讓這個元素成為 flexbox 的 container */
  display: flex;

  /* 使用 space-between 使內部元素取得相同間距 */
  justify-content: space-between;

  /* 想要使用 relative-absolute，所以這裡放 relative */
  position: relative;

  margin-bottom: 30px;
  max-width: 100%;
  width: 700px;
}

.progress-container::before {
  /* 使用偽元素一定要有 content，如果沒有內容可以放空字串 */
  content: "";

  /* 這裡使用了事先定義的未完成進度顏色 */
  background-color: var(--line-border-empty);

  /* 進度條容器的長寬 */
  height: 4px;
  width: 100%;
}
.progress-container::before {
  content: "";
  background-color: var(--line-border-empty);
  height: 4px;
  width: 100%;

  /* 以下是新增的 */
  /* 使用 relative-absolute */
  position: absolute;

  /* 調整 absolute 的位置到高度的 50%，距離左側 0 */
  top: 50%;
  left: 0;

  /* 因為這個元素自身的寬度，所以需要往上調自身寬度的 50% 回來才會回到正中間 */
  transform: translateY(-50%);

  /* 顯示到數字的後面 */
  z-index: -1;
}
.progress {
  /* 這裡使用了事先定義的已完成進度顏色 */
  background-color: var(--line-border-fill);

  /* height 一樣 4px，width在切版時可以先放成 50%，調整好再改回進度為 0% 的狀態 */
  /* 附圖為 50% 的狀態 */
  height: 4px;
  width: 0%;

  /* 一樣使用 relative-absolute把已完成進度條也放到正確位置上 */
  position: absolute;
  top: 50%;
  left: 0;
  transform: translateY(-50%);
  z-index: -1;

  /* 這裡用 transition 做出一點動畫效果*/
  transition: 0.4s ease;
}
.circle {
  /* 底色白色，文字顏色和邊框灰色 */
  background-color: #fff;
  color: #999;
  border: 3px solid #999;

  /* 把元素畫成寬高為 30px 的圓形 */
  border-radius: 50%;
  height: 50px;
  width: 50px;

  /* 用 flexbox 排版把文字放到正中間 */
  display: flex;
  align-items: center;
  justify-content: center;

  /* 一樣加上動畫效果 */
  transition: 0.4s ease;
}
.circle.active {
  border-color: var(--line-border-fill);
}
.btn {
  background-color: var(--line-border-fill);
  color: #fff;
  border: 0;
  border-radius: 6px;
  cursor: pointer;
  font-family: inherit;
  padding: 8px 30px;
  margin: 5px;
  font-size: 14px;
}
.btn:active {
  transform: scale(0.98);
}
.btn:focus {
  outline: 0;
}
.btn:disabled {
  background-color: var(--line-border-empty);
  cursor: not-allowed;
}


  .block{
  width: 1263px;
  height: 70px;
  }

  
</style>

</head>
<body bgcolor='white'>


	<!-- main header navbar -->
	<nav class="navbar navbar-expand-lg navbar-light custom-navbar"
		id="mainMenu">
		<div class="container">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/front-end/index.html"> <img
				src="<%=request.getContextPath()%>/front-end/images/MatDesignLogo.png" alt="" >
			</a>
			<!--  navbar actions -->
			<div class="main-navbar-action">
				<div id="mainNavbarDropdown">
					<!-- navbar user account dropdown -->
					<div class="dropdown-wrapper" id="usermenu" data-collapse="false">
						<div class="account-wrapper">
							<!-- login form wrapper -->

							<div class="account-wrapper__content">
								<div class="custom-form__btn custom-form__input">
									<div class="account-wrapper__heading">
										<span>${designerVO.designerAccount}</span> <span
											class="account-wrapper__heading--link">${designerVO.designerName}
										</span>
									</div>
								</div>
								<div class="account-wrapper__content">
<!-- 									<div class="form-group custom-form__input"> -->
<!-- 										<a class="dropdown-item " href="memberPorfile.jsp"> <span><i -->
<!-- 												class="icon-user-profile"></i></span>設計師資料 -->
<!-- 										</a> -->
<!-- 									</div> -->
									<div class="form-group custom-form__input">
										<a class="dropdown-item  " href="<%=request.getContextPath()%>/front-end/index.html"><span><i
												class="icon-log-out"></i></span>登出</a>
									</div>
								</div>

							</div>
							<!-- account links when user is logged in-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-profile-tab"><span><i-->
							<!--                            class="icon-user-profile"></i></span>Profile</a>-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-order-tab"><span><i-->
							<!--                            class="icon-shopping-basket"></i></span>Orders</a>-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-address-tab"><span><i-->
							<!--                            class="icon-sign"></i></span>Addresses</a>-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-wishlist-tab"><span><i-->
							<!--                            class="icon-wish-list"></i></span>wishlist</a>-->
							<!--                    <a class="dropdown-item" href="#"><span><i class="icon-log-out"></i></span>Log out</a>-->

						</div>
					</div>
					<!-- navbar cart dropdown -->
					<div class="" id="cartmenu" data-collapse="false"></div>
				</div>
				<!-- navbar user account icon -->
				<div class="main-navbar-action__btn nav-dropdown">
					<a class="dropdown-link" data-target="usermenu"> <i
						class="icon-user"></i>
					</a>
				</div>
				<!-- navbar cart icon -->
				<div class="main-navbar-action__btn nav-dropdown">
					<a class="dropdown-link" data-target="cartmenu"> <span
						class="cart-badge">2</span> <i class="icon-shopping-bag"></i>
					</a>
				</div>
				<!-- navbar actions content -->
			</div>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#mainNavbar" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mainNavbar">
				<ul class="navbar-nav main-navbar">
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="<%=request.getContextPath()%>/DesignerEdit?designerNo=${designerVO.designerNo}">編輯簡介</a>
					</li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="<%=request.getContextPath()%>/DesignerOrder?designerNo=${designerVO.designerNo}">案件管理</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="<%=request.getContextPath()%>/DesignerQuotationController?designerNo=${designerVO.designerNo}">報價管理</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="<%=request.getContextPath()%>/DesignerContractController?designerNo=${designerVO.designerNo}">合約管理</a></li>
					<!-- <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" data-toggle="dropdown">報導文章</a>
                </li> -->
					<li class="nav-item main-navbar__item"><a class="nav-link"
						href="contact.html">作品管理</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- end main header navbar -->




<!-- Topbar Start -->
<!-- 	<div class="container-fluid d-none d-lg-block"> -->
<!-- 		<div class="row align-items-center py-4 px-xl-5"> -->
<!-- 			<div class="align-item-center-right"> -->
<%-- 				<form method="post" action="<%=request.getContextPath()%>/DesignerLogout"> --%>
<%-- 				<div class="logintitle"><p>設計師${designerVO.designerName}您好</p></div> --%>
<!-- 			    <input type="hidden" name="logout" value="desginerlogout"> -->
<!-- 				<input  type="submit" class="btn btn-primary py-2 px-4 d-none d-lg-block"  -->
<!-- 				 value="登出" style=" color: #fff; background-color: #FF6600; border-color: #FF6600;" -->
<!-- 			    /> -->
<!-- 			    </form> -->
<!-- 			</div> -->
			
<!-- 			<div class="col-lg-0"> -->
<%-- 				<a href="<%=request.getContextPath()%>/front-end/designer/index.jsp" class="text-decoration-none"> --%>
<!-- 					<h1 class="m-0"> -->
<!-- 						<span class="text-primary">M</span>atDesign -->
<!-- 					</h1> -->
<!-- 				</a> -->
<!-- 			</div> -->

<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<!-- Topbar End --> 

<!-- 	<!-- Navbar Start --> 
<!-- 	<div class="container-fluid"> -->
<!-- 		<div class="row border-top px-xl-5"> -->

<!-- 			<div class="col-lg-9"> -->
<!-- 				<nav -->
<!-- 					class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0"> -->
<%-- 					<a href="<%=request.getContextPath()%>/front-end/designer/index.jsp" class="text-decoration-none d-block d-lg-none"> --%>
<!-- 						<h1 class="m-0"> -->
<!-- 							<span class="text-primary">M</span>atDesign -->
<!-- 						</h1> -->
<!-- 					</a> -->
<!-- 					<button type="button" class="navbar-toggler" data-toggle="collapse" -->
<!-- 						data-target="#navbarCollapse"> -->
<!-- 						<span class="navbar-toggler-icon"></span> -->
<!-- 					</button> -->
<!-- 					<div class="collapse navbar-collapse justify-content-between" -->
<!-- 						id="navbarCollapse"> -->
<!-- 						<div class="navbar-nav py-0"> -->
<%-- 							<div id="selfedit" style="width: 200px"><a href="<%=request.getContextPath()%>/DesignerEdit?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>編輯簡介</b></a></div> --%>
<%-- 							<div id="ordermanage" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerOrder?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>案件管理</b></a></div> --%>
<%-- 							<div id="quotation" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerQuotationController?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>報價管理</b></a></div> --%>
<%-- 							<div id="contract" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerContractController?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>合約管理</b></a></div> --%>
<!-- 							<div id="portfolio" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>作品管理</b></a></div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 				</nav> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	<!-- Navbar End -->
	
<div class="block"></div>		
<hr size="10px" align="center" width="100%" color="#000000">

<div style="text-align:center"><h3>案件明細</h3></div>
<div align="center">

  <div  class="container1">
    <!-- 進度條的 container -->
    <div  class="progress-container">
      <!-- 進度條本體 -->
      <div class="progress" id="progress"></div>
      <!-- 進度條的圈圈（Steps） -->
      <div class="circle active">尚未進行</div>
      <c:choose>
      <c:when test="${designerOrderVO.quotationStatus!='未報價'}">
      <div class="circle">報價</div>      
      <div class="circle">同意報價</div>
      </c:when>
      </c:choose>
      <c:choose>
      <c:when test="${designerOrderVO.contractStatus!='尚未進行'}">
      <div class="circle">簽約</div>
      <div class="circle">同意合約</div>
      <div class="circle">施工</div>
      </c:when>
       </c:choose>
      
      <div class="circle">結案</div>
    </div>
  </div>

<table>




	
		<tr><th>案件編號</th><td>${designerOrderVO.orderNo}</td></tr>
		<tr><th>客戶</th><td>${designerOrderVO.memberVO.memberName}</td></tr>
		<tr><th>案件設計師</th><td>${designerOrderVO.designerVO.designerName}</td></tr>
		<tr><th>諮詢預算</th><td>${designerOrderVO.inquiryBudget}元</td></tr>
		<tr><th>諮詢坪數</th><td>${designerOrderVO.inquirySize}坪</td></tr>
		<tr><th>諮詢內容</th><td>${designerOrderVO.inquiryDetail}</td></tr>
	    <tr><th>報價金額</th><td>${designerOrderVO.quotationAmount}元</td></tr>
		<tr><th>報價備註</th><td>${designerOrderVO.quotationDetail}</td></tr>
		<tr>
		<th>報價附件</th>
		<c:choose>
		   <c:when test="${designerOrderVO.quotationAtt!=null}">
		     <td><a href="#" style="color:red;" onclick="window.open(
	    '<%=request.getContextPath()%>/Quotationinfo?orderNo=${designerOrderVO.orderNo}'
	    , '_blank').focus();">預覽報價單</a></td>
		   </c:when>
		   <c:when test="${designerOrderVO.quotationAtt==null}">
		   <td>無附件</td>
		   </c:when>
		</c:choose>
		</tr>

	<c:forEach var="designerOrderPhaseVO" items="${list}">
		<tr><th>合約期數</th><td>${designerOrderPhaseVO.orderPhase}</td></tr>
    </c:forEach>
		<tr>
		   <th>合約備註</th>
		   <td>${designerOrderVO.contractDetail}</td></tr>
	    <tr>
		<th>合約附件</th>
		<c:choose>
		   <c:when test="${designerOrderVO.contractAtt!=null}">
		      <td><a href="#" style="color:red;" onclick="window.open(
	    '<%=request.getContextPath()%>/Contractinfo?orderNo=${designerOrderVO.orderNo}'
	    , '_blank').focus();">預覽合約</a></td>
		   </c:when>
		   <c:when test="${designerOrderVO.contractAtt==null}">
		   <td>無附件</td>
		   </c:when>
		</c:choose>
		</tr>
	<!--  	<c:forEach var="designerOrderPhaseVO" items="${list}">
		<tr><th>裝潢進度</th><td>${designerOrderPhaseVO.constructionStatus}</td></tr>
		</c:forEach>
		<c:forEach var="designerOrderPhaseVO" items="${list}">
		<tr><th>付款進度</th><td>${designerOrderPhaseVO.paymentStatus}</td></tr>
		</c:forEach>-->
		
		
		
		
		<tr>
		   <th>是否結案</th>
		      <td> 
		          <c:choose>
				       <c:when test="${designerOrderVO.finishStatus==true}">
				           已結案
				       </c:when>
				  <c:when test="${designerOrderVO.finishStatus==false}">
				           未結案
				  </c:when>
		          </c:choose>	
		      </td>
		</tr>

</table>
     <div id="block2"> 
           <div id="btn1">
          <form method="get" action="seeOrderPayment">
              <input type="hidden" value="${designerOrderVO.contractStatus}"> 
              <input type="hidden" name="orderNo" value="${designerOrderVO.orderNo}">
              <input id="btn2" type="submit" value="查看進度"  style="display: inline-block;">
          </form>           
          </div>
          <div id="btn2">
          <form action="FinishedDesignerOrder">
              <input type="hidden" name="orderNo" value="${designerOrderVO.orderNo}">
              <input id="btn" type="submit" value="結案"  style="display: inline-block;">   
           </form>
           </div>
             <div>
              <input type ="button" onclick="history.back()" value="回上一頁" > 
              </div> 
              
              <input type="hidden" value="${designerOrderVO.quotationStatus}">
        
     </div> 

</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/designer/js/btnscontrolorder.js"></script>


<script type="text/javascript">
//報價進度
function progressquotation(type) {
	

//進度條
const process = document.getElementById("progress");
// 進度圈圈
const circles = document.querySelectorAll(".circle");

// 首先設定變數現在的階段 currentActive 為 1
let currentActive = 1;

if(type=='確認中'){
     // currentActive 就加一（往前進一步）
	  currentActive++;
	  //判斷還能不能前進，如果不能前進了，就設為最大步數，也就是圈圈的個數
// 	  if (currentActive > circles.length) {
// 	    currentActive = circles.length;
// 	  }
	  update();

}


if(type=='同意報價'){
	// currentActive 就加一（往前進一步）
	  currentActive+=2;

	  //判斷還能不能前進，如果不能前進了，就設為最大步數，也就是圈圈的個數
// 	  if (currentActive > circles.length) {
// 	    currentActive = circles.length;
// 	  }
	  // 更新狀態（函式內容還沒定義）
	  update();
}

// if(type=='退回報價'){
// 	//每當後退紐被點擊的時候， currentActive 就減一（往後退一步）
// 	//prev.addEventListener("click", () => {
// 	  //currentActive++;
// 		currentActive--;

// 	  //判斷還能不能前進，如果不能後退了，就設為初始值，也就是1
// // 	  if (currentActive < 1) {
// // 	    currentActive = 2;
// // 	  }
// 	  // console.log(currentActive)

// 	  // 更新狀態（函式內容還沒定義）
// 	  update();
// 	//});
	
// }

function update() {
  // 第一件事：更新 .circle 元素的 .active class

  //遍歷一遍 circles
  circles.forEach((circle, idx) => {
    //如果現在的 circle 的 index 比 進度（currentActive） 小的話，就是一個已完成進度，加上 active
    if (idx < currentActive) {
      circle.classList.add("active");
    } else {
      //否則這個 circle 就是一個未完成進度，拿掉 active
      circle.classList.remove("active");
    }
  });

  // 第二件事：更新進度條元素的長度
  // 因為是進度條的長度，所以我們用（已完成距離（進度-1）)/間隔數(圈圈總數-1) *100 取得長度百分比
  length = ((currentActive - 1) / (circles.length - 1)) * 100;
  // 把單位加回去
  progress.style.width = length + "%";

 }

}

//簽約進度
function progresscontract(type) {	
	//進度條
	const process = document.getElementById("progress");

	// 進度圈圈
	const circles = document.querySelectorAll(".circle");

	// 首先設定變數現在的階段 currentActive 為 1
	let currentActive = 1;
	
	
	
	if(type=='確認中'){
   // currentActive 就加一（往前進一步）
	currentActive+=3;
		  //判斷還能不能前進，如果不能前進了，就設為最大步數，也就是圈圈的個數
//	 	  if (currentActive > circles.length) {
//	 	    currentActive = circles.length;
//	 	  }
		  // 更新狀態（函式內容還沒定義）
		  update();
	}
	
	
	
	if(type=='同意合約'){
    // currentActive 就加一（往前進一步）
     currentActive+=4;

		  //判斷還能不能前進，如果不能前進了，就設為最大步數，也就是圈圈的個數
//	 	  if (currentActive > circles.length) {
//	 	    currentActive = circles.length;
//	 	  }
		  // 更新狀態（函式內容還沒定義）
		  update();
	}

	function update() {
		  // 第一件事：更新 .circle 元素的 .active class

		  //遍歷一遍 circles
		  circles.forEach((circle, idx) => {
		    //如果現在的 circle 的 index 比 進度（currentActive） 小的話，就是一個已完成進度，加上 active
		    if (idx < currentActive) {
		      circle.classList.add("active");
		    } else {
		      //否則這個 circle 就是一個未完成進度，拿掉 active
		      circle.classList.remove("active");
		    }
		  });

		  // 第二件事：更新進度條元素的長度
		  // 因為是進度條的長度，所以我們用（已完成距離（進度-1）)/間隔數(圈圈總數-1) *100 取得長度百分比
		  length = ((currentActive - 1) / (circles.length - 1)) * 100;
		  // 把單位加回去
		  progress.style.width = length + "%";

		 }
}

</script>


<script type="text/javascript">
var type2 = '${designerOrderVO.contractStatus}';
var type = '${designerOrderVO.finishStatus}';
var typequotationStatus = '${designerOrderVO.quotationStatus}'
var typecontractStatus = '${designerOrderVO.contractStatus}'
DisplayAndHiddenBtn2("btn2",type2);
DisplayAndHiddenBtn("btn",type);
progressquotation(typequotationStatus);
progresscontract(typecontractStatus);
</script>



</body>
</html>