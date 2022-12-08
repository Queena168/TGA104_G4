<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.designer.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.designer.model.*" %>
<%@ page import="com.designer.service.*" %>
<%@ page import="com.designer.controller.*" %>


<%-- 此頁暫練習採用 Script 的寫法取值 --%>


<html>
<head>
<title>設計師資料 - listOneDesigner.jsp</title>
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
<link href="<%=request.getContextPath()%>/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="<%=request.getContextPath()%>/front-end/designer/css/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/front-end/designer/css/MatDesign.css" rel="stylesheet" />

  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"></script>
    

    
    
    
 
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
</style>
  <style >
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
  color: #FF6600;
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
  background: #FF6600;
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
    <!-- Topbar Start -->
    <div class="container-fluid d-none d-lg-block">
      <div class="row align-items-center py-4 px-xl-5">          
        <div class="col-lg-0">
          <a href="<%=request.getContextPath()%>/front-end/designer/index.jsp" class="text-decoration-none">
            <h1 class="m-0"><span class="text-primary">M</span>atDesign</h1>
          </a>
      </div>
    </div>
    <!-- Topbar End -->

    <!-- Navbar Start -->
    <div class="container-fluid">
      <div class="row border-top px-xl-5">      
        <div class="col-lg-9">
          <nav
            class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
            <a href="<%=request.getContextPath()%>/front-end/designer/index.jsp" class="text-decoration-none d-block d-lg-none">
              <h1 class="m-0"><span class="text-primary">M</span>atDesign</h1>
            </a>
            <button
              type="button"
              class="navbar-toggler"
              data-toggle="collapse"
              data-target="#navbarCollapse">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div
              class="collapse navbar-collapse justify-content-between"
              id="navbarCollapse" >
              <div class="navbar-nav py-0">
                <a id="product" href="index.html" class="nav-item nav-link" >找作品</a>
                <a id="design" href="<%=request.getContextPath()%>/front-end/designer/findDesigner.jsp" class="nav-item nav-link">找設計師</a >
                <a id="store" href="course.html" class="nav-item nav-link">商城</a>
                <a id="fourm" href="teacher.html" class="nav-item nav-link">論壇</a>
                <a id="topic" href="teacher.html" class="nav-item nav-link">報導文章</a>
               
              </div>
       
            </div>
          </nav>
        </div>
      </div>
    </div>
    <!-- Navbar End -->
    <!-- <Start------------------------------------------------------------------------------>
      <div class="container">
        <div class="cartcard">
          <div class="container-fliud">
            <div class="wrapper row">
              <div class="preview col-md-6">
                <div class="preview-pic tab-content">
                  <div class="tab-pane active" id="pic-1">
                    <img src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100% alt="" />
                  </div>
         
                </div>
              </div>
              <div class="details col-md-6">
                <h3 class="product-title"><p>設計師姓名:</p>${designerVO.designerName}</h3>
                <p class="product-description">
                  簡介：${designerVO.designerDetail}
                </p>
                <h4 class="price">作品: <span></span></h4>
                <br /><br />
              </div>
            </div>
          </div>
        </div>
      </div>
  
      <!-- <End------------------------------------------------------------------------------>

    <!-- Carousel Start -->
    <!-- <div class="container-fluid p-0 pb-5 mb-5">
      <div
        id="header-carousel"
        class="carousel slide carousel-fade"
        data-ride="carousel"
      >
        <ol class="carousel-indicators">
          <li
            data-target="#header-carousel"
            data-slide-to="0"
            class="active"
          ></li>
          <li data-target="#header-carousel" data-slide-to="1"></li>
          <li data-target="#header-carousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active" style="min-height: 300px">
            <img
              class="position-relative w-100"
              src="./img/matdesign001.jpg"
              style="min-height: 300px; object-fit: cover"
            />
            <div
              class="carousel-caption d-flex align-items-center justify-content-center"
            >
              <div class="p-5" style="width: 100%; max-width: 900px">
                <h5 class="text-white text-uppercase mb-md-3">
                  Best Online Courses
                </h5>
                <h1 class="display-3 text-white mb-md-4">
                  Best Education From Your Home
                </h1>
                <a
                  href=""
                  class="btn btn-primary py-md-2 px-md-4 font-weight-semi-bold mt-2"
                  >Learn More</a
                >
              </div>
            </div>
          </div>
          <div class="carousel-item" style="min-height: 300px">
            <img
              class="position-relative w-100"
              src="./img/matdesign002.jpg"
              style="min-height: 300px; object-fit: cover"
            />
            <div
              class="carousel-caption d-flex align-items-center justify-content-center"
            >
              <div class="p-5" style="width: 100%; max-width: 900px">
                <h5 class="text-white text-uppercase mb-md-3">
                  Best Online Courses
                </h5>
                <h1 class="display-3 text-white mb-md-4">
                  Best Online Learning Platform
                </h1>
                <a
                  href=""
                  class="btn btn-primary py-md-2 px-md-4 font-weight-semi-bold mt-2"
                  >Learn More</a
                >
              </div>
            </div>
          </div>
          <div class="carousel-item" style="min-height: 300px">
            <img
              class="position-relative w-100"
              src="./img/matdesign003.jpg"
              style="min-height: 300px; object-fit: cover"
            />
            <div
              class="carousel-caption d-flex align-items-center justify-content-center"
            >
              <div class="p-5" style="width: 100%; max-width: 900px">
                <h5 class="text-white text-uppercase mb-md-3">
                  Best Online Courses
                </h5>
                <h1 class="display-3 text-white mb-md-4">
                  New Way To Learn From Home
                </h1>
                <a
                  href=""
                  class="btn btn-primary py-md-2 px-md-4 font-weight-semi-bold mt-2"
                  >Learn More</a
                >
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Carousel End -->

    <!-- Courses Start -->
    <div class="container-fluid py-5">
      <div class="container py-5">
        <div class="text-center mb-5">
          <h2
            class="text-primary text-uppercase mb-3"
            style="letter-spacing: 5px">
            作品集
          </h2>
        </div>
        <div class="row">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="rounded overflow-hidden mb-2">
              <img
                class="img-fluid"
                src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100%"
                alt=""
              />
              <div class="bg-secondary p-4">
                <div class="d-flex justify-content-between mb-3">
             </div>
                <a class="h5" href=""
                  >Web design & development courses for beginner</a
                >
                <div class="border-top mt-4 pt-4">
                  <div class="d-flex justify-content-between">
                    <h6 class="m-0">
                      <i class="fa fa-star text-primary mr-2"></i>4.5
                      <small>(250)</small>
                    </h6>
                    <h5 class="m-0">$99</h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="rounded overflow-hidden mb-2">
              <img
                class="img-fluid"
                src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100%"
                alt=""
              />
              <div class="bg-secondary p-4">
                <div class="d-flex justify-content-between mb-3">
                  
                </div>
                <a class="h5" href=""
                  >Web design & development courses for beginner</a
                >
                <div class="border-top mt-4 pt-4">
                  <div class="d-flex justify-content-between">
                    <h6 class="m-0">
                      <i class="fa fa-star text-primary mr-2"></i>4.5
                      <small>(250)</small>
                    </h6>
                    <h5 class="m-0">$99</h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="rounded overflow-hidden mb-2">
              <img
                class="img-fluid"
                src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100%"
                alt=""
              />
              <div class="bg-secondary p-4">
                <div class="d-flex justify-content-between mb-3">
                
                </div>
                <a class="h5" href=""
                  >Web design & development courses for beginner</a
                >
                <div class="border-top mt-4 pt-4">
                  <div class="d-flex justify-content-between">
                    <h6 class="m-0">
                      <i class="fa fa-star text-primary mr-2"></i>4.5
                      <small>(250)</small>
                    </h6>
                    <h5 class="m-0">$99</h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
   
        </div>
      </div>
    </div>
    <!-- Courses End -->

    <!-- Team Start -->
    <!-- <div class="container-fluid py-5">
      <div class="container pt-5 pb-3">
        <div class="text-center mb-5">
          <h5
            class="text-primary text-uppercase mb-3"
            style="letter-spacing: 5px"
          >
            Teachers
          </h5>
          <h1>Meet Our Teachers</h1>
        </div>
        <div class="row">
          <div class="col-md-6 col-lg-3 text-center team mb-4">
            <div class="team-item rounded overflow-hidden mb-2">
              <div class="team-img position-relative">
                <img class="img-fluid" src="img/team-1.jpg" alt="" />
                <div class="team-social">
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-twitter"></i
                  ></a>
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-facebook-f"></i
                  ></a>
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-linkedin-in"></i
                  ></a>
                </div>
              </div>
              <div class="bg-secondary p-4">
                <h5>Jhon Doe</h5>
                <p class="m-0">Web Designer</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 text-center team mb-4">
            <div class="team-item rounded overflow-hidden mb-2">
              <div class="team-img position-relative">
                <img class="img-fluid" src="img/team-2.jpg" alt="" />
                <div class="team-social">
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-twitter"></i
                  ></a>
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-facebook-f"></i
                  ></a>
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-linkedin-in"></i
                  ></a>
                </div>
              </div>
              <div class="bg-secondary p-4">
                <h5>Jhon Doe</h5>
                <p class="m-0">Web Designer</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 text-center team mb-4">
            <div class="team-item rounded overflow-hidden mb-2">
              <div class="team-img position-relative">
                <img class="img-fluid" src="img/team-3.jpg" alt="" />
                <div class="team-social">
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-twitter"></i
                  ></a>
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-facebook-f"></i
                  ></a>
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-linkedin-in"></i
                  ></a>
                </div>
              </div>
              <div class="bg-secondary p-4">
                <h5>Jhon Doe</h5>
                <p class="m-0">Web Designer</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 text-center team mb-4">
            <div class="team-item rounded overflow-hidden mb-2">
              <div class="team-img position-relative">
                <img class="img-fluid" src="img/team-4.jpg" alt="" />
                <div class="team-social">
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-twitter"></i
                  ></a>
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-facebook-f"></i
                  ></a>
                  <a class="btn btn-outline-light btn-square mx-1" href="#"
                    ><i class="fab fa-linkedin-in"></i
                  ></a>
                </div>
              </div>
              <div class="bg-secondary p-4">
                <h5>Jhon Doe</h5>
                <p class="m-0">Web Designer</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div> -->
    <!-- Team End -->

    <!-- Testimonial Start -->
    <!-- <div class="container-fluid py-5">
      <div class="container py-5">
        <div class="text-center mb-5">
          <h5
            class="text-primary text-uppercase mb-3"
            style="letter-spacing: 5px"
          >
            Testimonial
          </h5>
          <h1>What Say Our Students</h1>
        </div>
        <div class="row justify-content-center">
          <div class="col-lg-8">
            <div class="owl-carousel testimonial-carousel">
              <div class="text-center">
                <i class="fa fa-3x fa-quote-left text-primary mb-4"></i>
                <h4 class="font-weight-normal mb-4">
                  Dolor eirmod diam stet kasd sed. Aliqu rebum est eos. Rebum
                  elitr dolore et eos labore, stet justo sed est sed. Diam sed
                  sed dolor stet amet eirmod eos labore diam
                </h4>
                <img
                  class="img-fluid mx-auto mb-3"
                  src="img/testimonial-1.jpg"
                  alt=""
                />
                <h5 class="m-0">Client Name</h5>
                <span>Profession</span>
              </div>
              <div class="text-center">
                <i class="fa fa-3x fa-quote-left text-primary mb-4"></i>
                <h4 class="font-weight-normal mb-4">
                  Dolor eirmod diam stet kasd sed. Aliqu rebum est eos. Rebum
                  elitr dolore et eos labore, stet justo sed est sed. Diam sed
                  sed dolor stet amet eirmod eos labore diam
                </h4>
                <img
                  class="img-fluid mx-auto mb-3"
                  src="img/testimonial-2.jpg"
                  alt=""
                />
                <h5 class="m-0">Client Name</h5>
                <span>Profession</span>
              </div>
              <div class="text-center">
                <i class="fa fa-3x fa-quote-left text-primary mb-4"></i>
                <h4 class="font-weight-normal mb-4">
                  Dolor eirmod diam stet kasd sed. Aliqu rebum est eos. Rebum
                  elitr dolore et eos labore, stet justo sed est sed. Diam sed
                  sed dolor stet amet eirmod eos labore diam
                </h4>
                <img
                  class="img-fluid mx-auto mb-3"
                  src="img/testimonial-3.jpg"
                  alt=""
                />
                <h5 class="m-0">Client Name</h5>
                <span>Profession</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div> -->
    <!-- Testimonial End -->

    <!-- Blog Start -->
    <!-- <div class="container-fluid py-5">
      <div class="container pt-5 pb-3">
        <div class="text-center mb-5">
          <h5
            class="text-primary text-uppercase mb-3"
            style="letter-spacing: 5px"
          >
            Our Blog
          </h5>
          <h1>Latest From Our Blog</h1>
        </div>
        <div class="row pb-3">
          <div class="col-lg-4 mb-4">
            <div
              class="blog-item position-relative overflow-hidden rounded mb-2"
            >
              <img class="img-fluid" src="img/blog-1.jpg" alt="" />
              <a class="blog-overlay text-decoration-none" href="">
                <h5 class="text-white mb-3">
                  Lorem elitr magna stet eirmod labore amet labore clita at ut
                  clita
                </h5>
                <p class="text-primary m-0">Jan 01, 2050</p>
              </a>
            </div>
          </div>
          <div class="col-lg-4 mb-4">
            <div
              class="blog-item position-relative overflow-hidden rounded mb-2"
            >
              <img class="img-fluid" src="img/blog-2.jpg" alt="" />
              <a class="blog-overlay text-decoration-none" href="">
                <h5 class="text-white mb-3">
                  Lorem elitr magna stet eirmod labore amet labore clita at ut
                  clita
                </h5>
                <p class="text-primary m-0">Jan 01, 2050</p>
              </a>
            </div>
          </div>
          <div class="col-lg-4 mb-4">
            <div
              class="blog-item position-relative overflow-hidden rounded mb-2"
            >
              <img class="img-fluid" src="img/blog-3.jpg" alt="" />
              <a class="blog-overlay text-decoration-none" href="">
                <h5 class="text-white mb-3">
                  Lorem elitr magna stet eirmod labore amet labore clita at ut
                  clita
                </h5>
                <p class="text-primary m-0">Jan 01, 2050</p>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div> -->
    <!-- Blog End -->
    <!-- About Start -->
    <!-- <div class="container-fluid py-5">
      <div class="container py-5">
        <div class="row align-items-center">
          <div class="col-lg-5">
            <img
              class="img-fluid rounded mb-4 mb-lg-0"
              src="img/about.jpg"
              alt=""
            />
          </div>
          <div class="col-lg-7">
            <div class="text-left mb-4">
              <h5
                class="text-primary text-uppercase mb-3"
                style="letter-spacing: 5px"
              >
                About Us
              </h5>
              <h1>Innovative Way To Learn</h1>
            </div>
            <p>
              Aliquyam accusam clita nonumy ipsum sit sea clita ipsum clita,
              ipsum dolores amet voluptua duo dolores et sit ipsum rebum,
              sadipscing et erat eirmod diam kasd labore clita est. Diam sanctus
              gubergren sit rebum clita amet, sea est sea vero sed et.
              Sadipscing labore tempor at sit dolor clita consetetur diam. Diam
              ut diam tempor no et, lorem dolore invidunt no nonumy stet ea
              labore, dolor justo et sit gubergren diam sed sed no ipsum. Sit
              tempor ut nonumy elitr dolores justo aliquyam ipsum stet
            </p>
            <a
              href=""
              class="btn btn-primary py-md-2 px-md-4 font-weight-semi-bold mt-2"
              >Learn More</a
            >
          </div>
        </div>
      </div>
    </div> -->
    <!-- About End -->

    <!-- Footer Start -->
    <div
      id="footer"
      class="container-fluid bg-dark text-white py-5 px-sm-3 px-lg-5"
      style="margin-top: 10px"
    >
      <div class="row pt-5">
        <div class="col-lg-7 col-md-12">
          <div class="row">
            <div class="col-md-6 mb-5">
              <h5
                class="text-primary text-uppercase mb-4"
                style="letter-spacing: 5px"
              >
                關於我們
              </h5>

              <a href="#" style="font-weight: bold">關於我們</a>
              <!-- <p>
                <i class="fa fa-map-marker-alt mr-2"></i>123 Street, New York,
                USA
              </p> -->
              <!-- <p><i class="fa fa-phone-alt mr-2"></i>+012 345 67890</p>
              <p><i class="fa fa-envelope mr-2"></i>info@example.com</p> -->
              <!-- <div class="d-flex justify-content-start mt-4">
                <a class="btn btn-outline-light btn-square mr-2" href="#"
                  ><i class="fab fa-twitter"></i
                ></a>
                <a class="btn btn-outline-light btn-square mr-2" href="#"
                  ><i class="fab fa-facebook-f"></i
                ></a>
                <a class="btn btn-outline-light btn-square mr-2" href="#"
                  ><i class="fab fa-linkedin-in"></i
                ></a>
                <a class="btn btn-outline-light btn-square" href="#"
                  ><i class="fab fa-instagram"></i
                ></a>
              </div> -->
            </div>
            <div class="col-md-6 mb-5">
              <!-- <h5
                class="text-primary text-uppercase mb-4"
                style="letter-spacing: 5px"
              >
                Our Courses
              </h5> -->
              <!-- <div class="d-flex flex-column justify-content-start">
                <a class="text-white mb-2" href="#"
                  ><i class="fa fa-angle-right mr-2"></i>Web Design</a
                >
                <a class="text-white mb-2" href="#"
                  ><i class="fa fa-angle-right mr-2"></i>Apps Design</a
                >
                <a class="text-white mb-2" href="#"
                  ><i class="fa fa-angle-right mr-2"></i>Marketing</a
                >
                <a class="text-white mb-2" href="#"
                  ><i class="fa fa-angle-right mr-2"></i>Research</a
                >
                <a class="text-white" href="#"
                  ><i class="fa fa-angle-right mr-2"></i>SEO</a
                >
              </div> -->
            </div>
          </div>
        </div>
        <!-- <div class="col-lg-5 col-md-12 mb-5">
          <h5
            class="text-primary text-uppercase mb-4"
            style="letter-spacing: 5px"
          >
            Newsletter
          </h5>
          <p>
            Rebum labore lorem dolores kasd est, et ipsum amet et at kasd, ipsum
            sea tempor magna tempor. Accu kasd sed ea duo ipsum. Dolor duo
            eirmod sea justo no lorem est diam
          </p>
          <div class="w-100">
            <div class="input-group">
              <input
                type="text"
                class="form-control border-light"
                style="padding: 30px"
                placeholder="Your Email Address"
              />
              <div class="input-group-append">
                <button class="btn btn-primary px-4">Sign Up</button>
              </div>
            </div>
          </div>
        </div> -->
      </div>
    </div>
    <!-- <div
      class="container-fluid bg-dark text-white border-top py-4 px-sm-3 px-md-5"
      style="border-color: rgba(256, 256, 256, 0.1) !important">
      <div class="row">
        <div class="col-lg-6 text-center text-md-left mb-3 mb-md-0">
          <p class="m-0 text-white">
            &copy; <a href="#">Domain Name</a>. All Rights Reserved. Designed by
            <a href="https://htmlcodex.com">HTML Codex</a>
          </p>
        </div>
        <div class="col-lg-6 text-center text-md-right">
          <ul class="nav d-inline-flex">
            <li class="nav-item">
              <a class="nav-link text-white py-0" href="#">Privacy</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white py-0" href="#">Terms</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white py-0" href="#">FAQs</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white py-0" href="#">Help</a>
            </li>
          </ul>
        </div>
      </div>
    </div> -->
    <!-- Footer End -->

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"
      ><i class="fa fa-angle-double-up"></i
    ></a>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>

  </body>
</html>