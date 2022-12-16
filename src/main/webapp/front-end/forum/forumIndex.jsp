<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="Free HTML Templates" name="keywords" />
    <meta content="Free HTML Templates" name="description" />

    <link href="../CSS/MatDesign.css" rel="stylesheet" />
    <link rel="stylesheet" href="../CSS/forum_style.css">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon" />

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet" />

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet" />

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="../CSS/style.css" rel="stylesheet" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

    <title>論壇首頁</title>

</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid d-none d-lg-block">
        <div class="row align-items-center py-4 px-xl-5">
            <div class="align-item-center-right">
                <a href="#" type="button" class="btn btn-primary py-2 px-4 d-none d-lg-block" data-bs-toggle="modal"
                    data-bs-target="#loginModal">登入/註冊</a>
            </div>

            <div class="modal fade" id="loginModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Registration Start -->
                        <div class="container-fluid bg-registration py-5" style="margin: 30px 0">
                            <div class="col-lg-5">
                                <div id="cardborder" class="card border-0">
                                    <!-- tab標籤開始 -->
                                    <div class="h-swicher-wrapper container">
                                        <div class="row justify-content-center">
                                            <div class="col-md-10 d-flex justify-content-center py-4">
                                                <div class="h-swicher">
                                                    <input type="radio" name="login" id="memberlogin" checked="checked"
                                                        class="swicher-input swicher-input-memberlogin" />
                                                    <label for="memberlogin" name="login"
                                                        class="swicher-label">會員登入</label>
                                                    <input type="radio" name="login" id="designerlogin"
                                                        class="swicher-input swicher-input-designerlogin" />
                                                    <label for="designerlogin" name="login"
                                                        class="swicher-label">設計師登入</label>
                                                    <span class="switcher-toggle"></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- tab標籤結束 -->
                                    <div class="card-body rounded-bottom bg-primary p-5">
                                        <form>
                                            <div class="form-group">
                                                <input type="text" class="form-control border-0 p-4" placeholder="帳號"
                                                    required="required" />
                                            </div>
                                            <div class="form-group">
                                                <input type="email" class="form-control border-0 p-4" placeholder="密碼"
                                                    required="required" />
                                            </div>
                                            <div class="form-group"></div>
                                            <input type="checkbox" class="remember" />記住我的密碼
                                            <div>
                                                <button class="btn btn-dark btn-block border-0 py-3" type="submit">
                                                    送出
                                                </button>
                                            </div>
                                        </form>
                                        <!-- Footer -->
                                        <div class="modal-footer">
                                            <div class="signup">
                                                <span style="color: black; font-weight: bold">尚未成為會員</span>
                                                <a href="#" type="button" class="member"
                                                    style="color: black; font-weight: bold">
                                                    立即加入
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Registration End -->
                    </div>
                </div>
            </div>

            <div class="col-lg-0">
                <a href="" class="text-decoration-none">
                    <h1 class="m-0"><span class="text-primary">M</span>atDesign</h1>
                </a>
            </div>
            <!-- <div class="col-lg-3 text-right">
				<div class="d-inline-flex align-items-center">
					<i class="fa fa-2x fa-map-marker-alt text-primary mr-3"></i>
					<div class="text-left">
						<h6 class="font-weight-semi-bold mb-1">Our Office</h6>
						<small>123 Street, New York, USA</small>
					</div>
				</div>
			</div>
			<div class="col-lg-3 text-right">
				<div class="d-inline-flex align-items-center">
					<i class="fa fa-2x fa-envelope text-primary mr-3"></i>
					<div class="text-left">
						<h6 class="font-weight-semi-bold mb-1">Email Us</h6>
						<small>info@example.com</small>
					</div>
				</div>
			</div>
			<div class="col-lg-3 text-right">
				<div class="d-inline-flex align-items-center">
					<i class="fa fa-2x fa-phone text-primary mr-3"></i>
					<div class="text-left">
						<h6 class="font-weight-semi-bold mb-1">Call Us</h6>
						<small>+012 345 6789</small>
					</div>
				</div>
			</div> -->
        </div>
    </div>
    <!-- Topbar End -->

    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <!-- <div class="col-lg-3 d-none d-lg-block">
				<a class="d-flex align-items-center justify-content-between bg-secondary w-100 text-decoration-none"
					data-toggle="collapse" href="#navbar-vertical" style="height: 67px; padding: 0 30px">
					<h5 class="text-primary m-0">
						<i class="fa fa-book-open mr-2"></i>Subjects
					</h5>
					<i class="fa fa-angle-down text-primary"></i>
				</a>
				<nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
					id="navbar-vertical" style="width: calc(100% - 30px); z-index: 9">
					<div class="navbar-nav w-100">
						<div class="nav-item dropdown">
							<a href="#" class="nav-link" data-toggle="dropdown">Web Design <i
									class="fa fa-angle-down float-right mt-1"></i></a>
							<div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
								<a href="" class="dropdown-item">HTML</a>
								<a href="" class="dropdown-item">CSS</a>
								<a href="" class="dropdown-item">jQuery</a>
							</div>
						</div>
						<a href="" class="nav-item nav-link">Apps Design</a>
						<a href="" class="nav-item nav-link">Marketing</a>
						<a href="" class="nav-item nav-link">Research</a>
						<a href="" class="nav-item nav-link">SEO</a>
					</div>
				</nav>
			</div> -->
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0"><span class="text-primary">M</span>atDesign</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav py-0">
                            <a id="product" href="index.html" class="nav-item nav-link">找作品</a>
                            <a id="design" href="about.html" class="nav-item nav-link">找設計師</a>
                            <a id="store" href="course.html" class="nav-item nav-link">商城</a>
                            <a id="fourm" href="forumIndex.do" class="nav-item nav-link">論壇</a>
                            <a id="topic" href="teacher.html" class="nav-item nav-link">報導文章</a>
                            <!-- <div class="nav-item dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Blog</a>
								<div class="dropdown-menu rounded-0 m-0">
									<a href="blog.html" class="dropdown-item">Blog List</a>
									<a href="single.html" class="dropdown-item">Blog Detail</a>
								</div>
							</div> -->
                            <!-- <a href="contact.html" class="nav-item nav-link">Contact</a> -->
                        </div>
                        <!-- <a class="btn btn-primary py-2 px-4 ml-auto d-none d-lg-block" href="">登入/註冊</a> -->
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->

    <!-- ForumTopics Start -->
    <div class="forum_container">
        <div>
            <form method="post" id="form" class="form" action="forumpost.do">
                <input type="text" name="keyword" placeholder="搜尋論壇發文">
                <input type="hidden" name="action" value="search">
                <button type="button" onclick="search()">確認</button>
            </form>
        </div>

        <div class="main">
            <c:forEach var="forumTopicVO" items="${forumTopicVOList}" varStatus="status">
                <%--從forumIndex.do傳來的forumTopicVOList--%>
                    <div class="subforum-row">

                        <div class="subforum-icon subforum-column center">
                            <i class="fas fa-archway" style="color:black"></i>
                        </div>

                        <div class="subforum-description subforum-column">
                            <h4><a href="topic.do?topicNo=${forumTopicVO.topicNo}">${forumTopicVO.topicName}</a>
                            </h4>
                        </div>

                        <div class="subforum-stats subforum-column center">
                            <span>開版日期 <br>${forumTopicVO.startDate}</span>
                        </div>

                        <div class="subforum-info subforum-column AutoSkip">
                            <b>最新文章：<a
                                    href="posts.do?topicNo=${forumPostVOList[status.index].topicNo}&postNo=${forumPostVOList[status.index].postNo}">${forumPostVOList[status.index].title}</a></b>
                            <br>發文者：<b>${forumPostVOList[status.index].nickName}</b>
                            <%--從forumIndex.do傳來的forumPostVOList，相同的index--%>
                                <br>
                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                    value="${forumPostVOList[status.index].postTime}" />
                        </div>
                    </div>
            </c:forEach>
        </div>
        <div class="hot AutoSkip">
            <h4>熱門文章</h4>
            <c:forEach var="hot" items="${hotList}" varStatus="status"> <%--從forumIndex.do傳來的hotList--%>
                    <b>[第${status.count}名]</b> <span style="color:lightgray;">${viewList[status.index]}次瀏覽</span><br>
                    <a href="posts.do?topicNo=${hot.topicNo}&postNo=${hot.postNo}">${hot.title}</a><br><br>
            </c:forEach> <%--從forumIndex.do傳來的viewList，相同的index--%>
        </div>
        <!-- ForumTopics End -->

        <!-- Footer Start -->
        <div id="footer" class="container-fluid bg-dark text-white py-5 px-sm-3 px-lg-5" style="margin-top: 10px">
            <div class="row pt-5">
                <div class="col-lg-7 col-md-12">
                    <div class="row">
                        <div class="col-md-6 mb-5">
                            <h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px">
                                關於我們
                            </h5>

                            <a href="#" style="font-weight: bold">關於我們</a>
                            <!-- <p>
							<i class="fa fa-map-marker-alt mr-2"></i>123 Street, New York,
							USA
						</p>
						<p><i class="fa fa-phone-alt mr-2"></i>+012 345 67890</p>
						<p><i class="fa fa-envelope mr-2"></i>info@example.com</p>
						<div class="d-flex justify-content-start mt-4">
							<a class="btn btn-outline-light btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
							<a class="btn btn-outline-light btn-square mr-2" href="#"><i
									class="fab fa-facebook-f"></i></a>
							<a class="btn btn-outline-light btn-square mr-2" href="#"><i
									class="fab fa-linkedin-in"></i></a>
							<a class="btn btn-outline-light btn-square" href="#"><i class="fab fa-instagram"></i></a>
						</div> -->
                        </div>
                        <!-- <div class="col-md-6 mb-5">
						<h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px">
							Our Courses
						</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Web Design</a>
							<a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Apps Design</a>
							<a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Marketing</a>
							<a class="text-white mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Research</a>
							<a class="text-white" href="#"><i class="fa fa-angle-right mr-2"></i>SEO</a>
						</div>
					</div> -->
                    </div>
                </div>
                <!-- <div class="col-lg-5 col-md-12 mb-5">
				<h5 class="text-primary text-uppercase mb-4" style="letter-spacing: 5px">
					Newsletter
				</h5>
				<p>
					Rebum labore lorem dolores kasd est, et ipsum amet et at kasd, ipsum
					sea tempor magna tempor. Accu kasd sed ea duo ipsum. Dolor duo
					eirmod sea justo no lorem est diam
				</p>
				<div class="w-100">
					<div class="input-group">
						<input type="text" class="form-control border-light" style="padding: 30px"
							placeholder="Your Email Address" />
						<div class="input-group-append">
							<button class="btn btn-primary px-4">Sign Up</button>
						</div>
					</div>
				</div>
			</div> -->
            </div>
        </div>
        <!-- <div class="container-fluid bg-dark text-white border-top py-4 px-sm-3 px-md-5"
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
        <%-- <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="../js/main.js"></script> --%>
        
        <script src="../js/forum.js"></script>

</body>

</html>