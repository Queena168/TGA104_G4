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
    <!-- Topbar Start -->
    <div class="container-fluid d-none d-lg-block">
      <div class="row align-items-center py-4 px-xl-5">
        <div class="align-item-center-right">
          <a
            href="#"
            type="button"
            class="btn btn-primary py-2 px-4 d-none d-lg-block"
            data-bs-toggle="modal"
            data-bs-target="#loginModal"
            style="
              color: #fff;
              background-color: #ff6600;
              border-color: #ff6600;
            "
            >登入/註冊</a
          >
        </div>

        <div class="modal fade" id="loginModal">
          <div class="modal-dialog">
            <div class="modal-content">
              <!-- Registration Start -->

              <div
                class="container-fluid bg-registration py-5"
                style="margin: 30px 0"
              >
                <div class="col-lg-5">
                  <div id="cardborder" class="card border-0">
                    <!-- tab標籤開始 -->
                    <div class="h-swicher-wrapper container">
                      <div class="row justify-content-center">
                        <div
                          class="col-md-10 d-flex justify-content-center py-4"
                        >
                          <div class="h-swicher">
                            <input
                              type="hidden"
                              name="action"
                              value="memberlogin"
                            />
                            <input
                              type="radio"
                              name="login"
                              id="memberlogin"
                              checked="checked"
                              class="swicher-input swicher-input-memberlogin"
                            />
                            <label for="memberlogin" class="swicher-label"
                              >會員登入</label
                            >
                            <input
                              type="hidden"
                              name="action"
                              value="designerlogin"
                            />
                            <input
                              type="radio"
                              name="login"
                              id="designerlogin"
                              class="swicher-input swicher-input-designerlogin"
                            />
                            <label for="designerlogin" class="swicher-label"
                              >設計師登入</label
                            >
                            <span class="switcher-toggle"></span>
                          </div>
                        </div>
                      </div>
                    </div>

                    <!-- tab標籤結束 -->
                    <form
                      method="post"
                      action="<%=request.getContextPath()%>/Login"
                      enctype="multipart/form-data"
                    >
                      <div class="card-body rounded-bottom bg-primary p-5">
                        <!-- <form> -->
                        <div class="form-group">
                          <input
                            type="email"
                            class="form-control border-0 p-4"
                            placeholder="帳號"
                            required="required"
                            name="account"
                          />
                        </div>
                        <div class="form-group">
                          <input
                            type="password"
                            class="form-control border-0 p-4"
                            placeholder="密碼"
                            required="required"
                            name="password"
                          />
                        </div>
                        <!-- <div class="form-group"></div> -->
                        <!--	<input type="checkbox" class="remember" />記住我的密碼 -->
                        <div>
                          <input
                            type="hidden"
                            id="loginattr"
                            name="login"
                            value="memberlogin"
                          />
                          <input
                            class="btn btn-dark btn-block border-0 py-3"
                            style="
                              color: #fff;
                              background-color: #44425a;
                              border-color: #44425a;
                            "
                            type="submit"
                            value="登入"
                          />
                        </div>
                        <!-- 	</form> -->
                        <!-- Footer -->
                        <div class="modal-footer">
                          <div class="signup">
                            <span style="color: black; font-weight: bold"
                              >尚未成為會員</span
                            >
                            <a
                              href="#"
                              type="button"
                              class="member"
                              style="color: black; font-weight: bold"
                            >
                              <u>加入會員</u></a
                            >
                          </div>

                          <div class="signup">
                            <span style="color: black; font-weight: bold"
                              >加入設計團隊</span
                            >
                            <a
                              href="addDesigner.jsp"
                              type="button"
                              class="designer"
                              style="color: black; font-weight: bold"
                              ><u> 成為夥伴 </u></a
                            >
                          </div>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>

              <!-- Registration End -->
            </div>
          </div>
        </div>

        <div class="col-lg-0">
          <a
            href="<%=request.getContextPath()%>/front-end/designer/index.jsp"
            class="text-decoration-none"
          >
            <h1 class="m-0"><span class="text-primary">M</span>atDesign</h1>
          </a>
        </div>
      </div>
    </div>
    <!-- Topbar End -->

    <!-- Navbar Start -->
    <div class="container-fluid">
      <div class="row border-top px-xl-5">
        <div class="col-lg-9">
          <nav
            class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0"
          >
            <a
              href="<%=request.getContextPath()%>/front-end/designer/index.jsp"
              class="text-decoration-none d-block d-lg-none"
            >
              <h1 class="m-0"><span class="text-primary">M</span>atDesign</h1>
            </a>
            <button
              type="button"
              class="navbar-toggler"
              data-toggle="collapse"
              data-target="#navbarCollapse"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
            <div
              class="collapse navbar-collapse justify-content-between"
              id="navbarCollapse"
            >
              <div
                class="collapse navbar-collapse justify-content-between"
                id="navbarCollapse"
              >
                <div class="navbar-nav py-0">
                  <div id="selfedit" style="width: 200px">
                    <a href="index.html" class="nav-item nav-link"
                      ><b>找作品</b></a
                    >
                  </div>
                  <div id="ordermanage" style="width: 200px">
                    <a
                      href="<%=request.getContextPath()%>/ShowDesignerPage"
                      class="nav-item nav-link"
                      ><b>找設計師</b></a
                    >
                  </div>
                  <div id="quotation" style="width: 200px">
                    <a href="course.html" class="nav-item nav-link"
                      ><b>商城</b></a
                    >
                  </div>
                  <div id="contract" style="width: 200px">
                    <a href="teacher.html" class="nav-item nav-link"
                      ><b>論壇</b></a
                    >
                  </div>
                  <div id="portfolio" style="width: 200px">
                    <a href="teacher.html" class="nav-item nav-link"
                      ><b>報導文章</b></a
                    >
                  </div>
                </div>
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
            </div>
            <div class="col-md-6 mb-5"></div>
          </div>
        </div>
      </div>
    </div>

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
