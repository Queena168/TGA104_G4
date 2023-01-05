<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="java.util.*" %> 
<%@ page import="com.tibame.designer.model.*" %>
<%@ page import="com.tibame.designer.service.*" %> 
<%@ page import="com.tibame.member.model.*"%>

<html>
  <head>
    <title>設計師資料 - listOneDesignerINFO.jsp</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="Free HTML Templates" name="keywords" />
    <meta content="Free HTML Templates" name="description" />

    <!-- Favicon -->
    <link
      href="<%=request.getContextPath()%>/front-end/designer/img/favicon.ico"
      rel="icon"
    />

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap"
      rel="stylesheet"
    />

    <!-- Font Awesome -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
      rel="stylesheet"
    />

    <!-- Libraries Stylesheet -->

    <!-- Customized Bootstrap Stylesheet -->
    <link
      href="<%=request.getContextPath()%>/front-end/designer/css/style.css"
      rel="stylesheet"
    />
    <link
      href="<%=request.getContextPath()%>/front-end/designer/css/MatDesign.css"
      rel="stylesheet"
    />
    
    
    
<!-- Favicon -->
    <link rel="icon" href="<%=request.getContextPath()%>/front-end/images/favicon.ico" sizes="32x32">


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
    <!--    <link rel="stylesheet" href="//basehold.it/24">-->

    <!-- nice select -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/nice-select.min.css">
    <!-- Main Styles -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/scss/main.css">

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>

    <style>
      table#table-1 {
        background-color: #ccccff;
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
      table,
      th,
      td {
        border: 1px solid #ccccff;
      }
      th,
      td {
        padding: 5px;
        text-align: center;
      }
    </style>
    <style>
      /* Cart-page start */
      .preview {
        display: -webkit-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-orient: vertical;
        -webkit-box-direction: normal;
        -webkit-flex-direction: column;
        -ms-flex-direction: column;
        flex-direction: column;
      }
      @media screen and (max-width: 996px) {
        .preview {
          margin-bottom: 20px;
        }
      }

      .preview-pic {
        -webkit-box-flex: 1;
        -webkit-flex-grow: 1;
        -ms-flex-positive: 1;
        flex-grow: 1;
      }

      .preview-thumbnail.nav-tabs {
        border: none;
        margin-top: 15px;
      }
      .preview-thumbnail.nav-tabs li {
        width: 18%;
        margin-right: 2.5%;
      }
      .preview-thumbnail.nav-tabs li img {
        max-width: 100%;
        display: block;
      }
      .preview-thumbnail.nav-tabs li a {
        padding: 0;
        margin: 0;
      }
      .preview-thumbnail.nav-tabs li:last-of-type {
        margin-right: 0;
      }

      .tab-content img {
        width: 100%;
        -webkit-animation-name: opacity;
        animation-name: opacity;
        -webkit-animation-duration: 0.3s;
        animation-duration: 0.3s;
      }

      .cartcard {
        margin-top: 50px;
        background: #fff7eb;
        padding: 3em;
        line-height: 1.5em;

        position: relative;
        display: flex;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 1px solid rgba(0, 0, 0, 0.125);
        border-radius: 8px;
      }

      @media screen and (min-width: 997px) {
        .wrapper {
          display: -webkit-box;
          display: -webkit-flex;
          display: -ms-flexbox;
          display: flex;
        }
      }

      .details {
        display: -webkit-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-orient: vertical;
        -webkit-box-direction: normal;
        -webkit-flex-direction: column;
        -ms-flex-direction: column;
        flex-direction: column;
      }

      .colors {
        -webkit-box-flex: 1;
        -webkit-flex-grow: 1;
        -ms-flex-positive: 1;
        flex-grow: 1;
      }

      .product-title,
      .price,
      .sizes,
      .colors {
        text-transform: UPPERCASE;
        font-weight: bold;
      }

      .checked,
      .price span {
        color: #ff6600;
      }

      .product-title,
      .rating,
      .product-description,
      .price,
      .vote,
      .sizes {
        margin-bottom: 15px;
      }

      .product-title {
        margin-top: 0;
      }

      .size {
        margin-right: 10px;
      }
      .size:first-of-type {
        margin-left: 40px;
      }

      .color {
        display: inline-block;
        vertical-align: middle;
        margin-right: 10px;
        height: 2em;
        width: 2em;
        border-radius: 2px;
      }
      .color:first-of-type {
        margin-left: 20px;
      }

      .add-to-cart,
      .like {
        margin-right: 8px;
        background: #ff6600;
        padding: 10px 20px;
        border: none;
        text-transform: UPPERCASE;
        font-weight: bold;
        color: #fff;
        -webkit-transition: background 0.3s ease;
        transition: background 0.3s ease;
      }
      .add-to-cart:hover,
      .like:hover {
        background: #b36800;
        color: #fff;
      }

      .not-available {
        text-align: center;
        line-height: 2em;
      }
      .not-available:before {
        font-family: fontawesome;
        content: "\f00d";
        color: #fff;
      }

      .orange {
        background: #ff9f1a;
      }

      .green {
        background: #85ad00;
      }

      .blue {
        background: #0076ad;
      }

      .tooltip-inner {
        padding: 1.3em;
      }

      @-webkit-keyframes opacity {
        0% {
          opacity: 0;
          -webkit-transform: scale(3);
          transform: scale(3);
        }
        100% {
          opacity: 1;
          -webkit-transform: scale(1);
          transform: scale(1);
        }
      }

      @keyframes opacity {
        0% {
          opacity: 0;
          -webkit-transform: scale(3);
          transform: scale(3);
        }
        100% {
          opacity: 1;
          -webkit-transform: scale(1);
          transform: scale(1);
        }
      }
      .btnqq {
        margin-right: 8px;
        background: #b2adad;
        padding: 5px 5px;
        border: none;
        text-transform: UPPERCASE;
        font-weight: bold;
        color: #fff;
        -webkit-transition: background 0.3s ease;
        transition: background 0.3s ease;
      }
      /* Cart-page end */
    </style>
  </head>
  <body>
  
  
<!-- main header navbar -->
<nav class="navbar navbar-expand-lg navbar-light custom-navbar" id="mainMenu">
    <div class="container">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/front-end/index.html">    
            <img src="<%=request.getContextPath()%>/front-end/images/MatDesignLogo.png" alt="">
        </a>
        <!--  navbar actions -->
        <div class="main-navbar-action">
            <div id="mainNavbarDropdown">
                <!-- navbar user account dropdown -->
                <div class="dropdown-wrapper" id="usermenu" data-collapse="false">
                    <div class="account-wrapper">
                        <!-- login form wrapper -->
                        
                        <div class="account-wrapper__content">
                            <form class="custom-form">
                                <div class="custom-form__btn">
                                    <a class="dropdown-item nav-link" href="<%=request.getContextPath()%>/front-end/member/login.jsp">會員登入/註冊</a>
                                    <a class="dropdown-item nav-link" href="<%=request.getContextPath()%>/front-end/designer_protfolio/login.jsp">設計師登入/註冊</a>
                                </div>
                                
                            </form>
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
                <a class="dropdown-link" data-target="usermenu">
                    <i class="icon-user"></i>
                </a>
            </div>
            <!-- navbar cart icon -->
            <div class="main-navbar-action__btn nav-dropdown">
                <a class="dropdown-link" data-target="cartmenu">
                    <span class="cart-badge">2</span>
                    <i class="icon-shopping-bag"></i>
                </a>
            </div>
            <!-- navbar actions content -->
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainNavbar"
                aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="mainNavbar">
            <ul class="navbar-nav main-navbar">
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="<%=request.getContextPath()%>/front-end/designer_protfolio/memFindPortfolio.jsp" >找作品</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="<%=request.getContextPath()%>/ShowDesignerPage" >找設計師</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="<%=request.getContextPath()%>/ShowShop" >商城</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="./forum/forumIndex.do" >論壇</a>
                </li>
                <!-- <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" data-toggle="dropdown">報導文章</a>
                </li> -->
                <li class="nav-item main-navbar__item">
                    <a class="nav-link" href="contact.html">關於我們</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- end main header navbar -->

  
    <!-- <Start------------------------------------------------------------------------------>

    <div class="container">
      <div class="cartcard">
        <div class="container-fliud">
          <div class="wrapper row">
            <div class="preview col-md-6">
              <div class="preview-pic tab-content">
                <div class="tab-pane active" id="pic-1">
                  <c:forEach
                    var="designerExpertiseVO"
                    items="${listXX}"
                    begin="0"
                    end="0"
                  >
                    <img
                      src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerExpertiseVO.designerVO.designerNo}"
                      width="100%"
                      alt=""
                    />
                  </c:forEach>
                </div>
              </div>
            </div>
            <div class="details col-md-6">
              <c:forEach
                var="designerExpertiseVO"
                items="${listXX}"
                begin="0"
                end="0"
              >
                <h3 class="product-title">
                  <p>設計師姓名:</p>
                  ${designerExpertiseVO.designerVO.designerName}
                </h3>
              </c:forEach>
              <p class="product-description">
                <c:forEach
                  var="designerExpertiseVO"
                  items="${listXX}"
                  begin="0"
                  end="0"
                >
                  簡介：${designerExpertiseVO.designerVO.designerDetail}
                </c:forEach>
              </p>
              <h4 class="price">作品: <span></span></h4>
              <br /><br />
              <h4 class="price">
                專長:
                <c:forEach var="designerExpertiseVO" items="${listXX}">
                  <u style="color: orange"
                    ><span
                      >${designerExpertiseVO.expertiseVO.expertiseName}</span></u>
                </c:forEach>
              </h4>
              <br /><br />

              <!-- 諮詢按鈕開始 -->

          <div>
           <c:forEach var="designerExpertiseVO" items="${listXX}" begin="0" end="0">
            <form method="get" action="<%=request.getContextPath()%>/inquiry">
                <input type="hidden" name="designerNo" value="${designerExpertiseVO.designerNo}"/>
               <input
                    class="btn btn-dark btn-block border-0 py-3"
                    style="
                      color: #fff;
                      background-color: #f28500;
                      border-color: #44425a;
                    "
                    type="submit"
                    value="我要諮詢"
                  />
                  
               <!--     <input
                    type="hidden"
                    name="memberNo"
                    value="${memberVO.memberNo}"
                  />-->
               
                </form>
                </c:forEach>
              </div>

              <!-- 諮詢按鈕結束 -->
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- <End------------------------------------------------------------------------------>

    <!-- Courses Start -->
    <div class="container-fluid py-5">
      <div class="container py-5">
        <div class="text-center mb-5">
          <h2
            class="text-primary text-uppercase mb-3"
            style="letter-spacing: 5px"
          >
            作品集
          </h2>
        </div>
        <div class="row">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="rounded overflow-hidden mb-2">
              <img
                class="img-fluid"
                src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}"
                width="100%"
                alt=""
              />
              <div class="bg-secondary p-4">
                <div class="d-flex justify-content-between mb-3"></div>
                <a class="h5" href="">作品名稱</a>
                <div class="border-top mt-4 pt-4">
                  <div class="d-flex justify-content-between">
                    <h6 class="m-0">
                      <i class="fa fa-star text-primary mr-2"></i>4.5
                      <small>(250)</small>
                    </h6>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="rounded overflow-hidden mb-2">
              <img
                class="img-fluid"
                src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}"
                width="100%"
                alt=""
              />
              <div class="bg-secondary p-4">
                <div class="d-flex justify-content-between mb-3"></div>
                <a class="h5" href="">作品名稱</a>
                <div class="border-top mt-4 pt-4">
                  <div class="d-flex justify-content-between">
                    <h6 class="m-0">
                      <i class="fa fa-star text-primary mr-2"></i>4.5
                      <small>(250)</small>
                    </h6>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="rounded overflow-hidden mb-2">
              <img
                class="img-fluid"
                src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}"
                width="100%"
                alt=""
              />
              <div class="bg-secondary p-4">
                <div class="d-flex justify-content-between mb-3"></div>
                <a class="h5" href="">作品名稱</a>
                <div class="border-top mt-4 pt-4">
                  <div class="d-flex justify-content-between">
                    <h6 class="m-0">
                      <i class="fa fa-star text-primary mr-2"></i>4.5
                      <small>(250)</small>
                    </h6>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Courses End -->

   	<!-- footer -->
<footer class="footer">
    <div class="container">
        <div class="footer__top-row">
            <div class="row">
                <div class="col-lg-4 col-md-6 footer__content">
                    <div class="footer-logo">
                        <img src="<%=request.getContextPath()%>/front-end/images/MatDesignLogo.png" alt="">
                    </div>
                    <p></p>
                    
                </div>
                <div class="col-lg-2 col-md-6 footer__content">
                    <h5 class="footer-heading">關於我們</h5>
                    <ul class="footer-list">
                        <li class="footer-list__item"><a href="index.html">關於我們</a></li>
                    </ul>
                </div>
                <div class="col-lg-3 col-md-6 footer__content">
                    <h5 class="footer-heading">網站地圖</h5>
                    <ul class="footer-list">
                        <li class="footer-list__item"><a href="#">找作品</a></li>
                        <li class="footer-list__item"><a href="#">找設計師</a></li>
                        <li class="footer-list__item"><a href="#">商城</a></li>
                        <li class="footer-list__item"><a href="#">論壇</a></li>
                    </ul>
                </div>
                <div class="col-lg-3 col-md-6 footer__content">
                    <h5 class="footer-heading">Keep in touch</h5>
                    <ul class="footer-list footer-list-info">
                        <li class="footer-list__item">
                            <span><i class="fas fa-envelope"></i></span>
                            <span>MatDesign@gmail.com</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="copyright">
            <p>&#169; copyright 2022. Designed by MatDesign </p>
        </div>
    </div>
</footer>
<!-- end footer -->
	

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"
      ><i class="fa fa-angle-double-up"></i
    ></a>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/front-end/designer/lib/easing/easing.min.js"></script>
    <script src="<%=request.getContextPath()%>/front-end/designer/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="<%=request.getContextPath()%>/front-end/designer/mail/jqBootstrapValidation.min.js"></script>
    <script src="<%=request.getContextPath()%>/front-end/designer/mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="<%=request.getContextPath()%>/front-end/designer/js/main.js"></script>
    
    
    <!-- All Jquery -->
 <script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/popper.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/bootstrap.min.js"></script>
<!-- owl carousel js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/owl.carousel.min.js"></script>
<!-- Jquery ui -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery-ui.min.js"></script>
<!-- light box js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/lightbox.min.js"></script>
<!-- typeahead js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/typeahead.jquery.min.js"></script>
<!-- master zoom image js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery.zoom.min.js"></script>
<!-- countdown js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/countdown.jquery.min.js"></script>
<!-- nice select js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/nice-select.min.js"></script>
<!-- <!-- wow js  -->
 <script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/wow.min.js"></script> 
<!-- <!-- custom js  -->
 <script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>
	

    <script>
      $(document).on("click", "#designerlogin", function () {
        $("#loginattr").removeAttr("value")(
          $("#loginattr").attr("value", "designerlogin")
        );
      });

      $(document).on("click", "#memberlogin", function () {
        $("#loginattr").removeAttr("value")(
          $("#loginattr").attr("value", "memberlogin")
        );
      });
    </script>
  </body>
</html>
