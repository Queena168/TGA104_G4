<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Favicon -->
    <link rel="icon" href="../images/favicon.ico" sizes="32x32">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel='stylesheet' href='../css/fontawesome.min.css'>
    <!-- Animate -->
    <link href="../css/animate.css" rel="stylesheet">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <!-- light box -->
    <link rel="stylesheet" href="../css/lightbox.min.css">
    <!-- jquery ui -->
    <link rel="stylesheet" href="../css/jquery-ui.min.css">
    <!--    <link rel="stylesheet" href="//basehold.it/24">-->

    <!-- nice select -->
    <link rel="stylesheet" href="../css/nice-select.min.css">
    <!-- Main Styles -->
    <link rel="stylesheet" href="../scss/main.css">
    <link rel="stylesheet" href="../css/forum_style.css">

    <title>論壇首頁</title>

</head>

<body>
  <!-- main header navbar -->
<nav class="navbar navbar-expand-lg navbar-light custom-navbar" id="mainMenu">
    <div class="container">
        <a class="navbar-brand" href="index.html">    
            <img src="../images/MatDesignLogo.png" alt="">
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
                                    <a class="dropdown-item nav-link" href="../member/login.jsp">會員登入/註冊</a>
                                    <a class="dropdown-item nav-link" href="../designer_protfolio/login.jsp">設計師登入/註冊</a>
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
                    <a class="nav-link " href="${pageContext.request.contextPath}/front-end/designer_protfolio/memFindPortfolio.jsp" >找作品</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="${pageContext.request.contextPath}/ShowDesignerPage" >找設計師</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="${pageContext.request.contextPath}/ShowShop" >商城</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="${pageContext.request.contextPath}/front-end/forum/forumIndex.do" >論壇</a>
                </li>
                <!-- <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" data-toggle="dropdown">報導文章</a>
                </li> -->
                <li class="nav-item main-navbar__item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/front-end/contact.html">關於我們</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- end main header navbar -->

    <!-- ForumIndex Start -->
    <div class="forum_container">
        <div class="subforum">
            <div class="subforum-title">
                <form method="post" id="search_form" action="search"><!--forumpost.do-->
                    <input type="text" id="keyword" name="keyword" placeholder="搜尋論壇發文">
                    <input type="hidden" name="action" value="search">
                    <button type="button" class="search_btn" onclick="search()">確認</button>
                </form>
            </div>
            <c:forEach var="forumTopicVO" items="${forumTopicVOList}" varStatus="status">
                <div class="subforum-row">
                    <div class="subforum-icon subforum-column center">
                        <i class="fa fa-comments"></i>
                    </div>
                    <div class="subforum-description subforum-column">
                        <a href="topic.do?topicNo=${forumTopicVO.topicNo}&page=1">${forumTopicVO.topicName}</a>
                        </div>
                    <div class="subforum-stats subforum-column center">
                        <span>開版日期 <br>${forumTopicVO.startDate}</span>
                    </div>
                    <div class="subforum-info subforum-column AutoSkip">
                        <b>最新文章：<a
                                href="posts.do?topicNo=${forumPostVOList[status.index].topicNo}&postNo=${forumPostVOList[status.index].postNo}&page=1">${forumPostVOList[status.index].title}</a></b>
                        <br>發文者：<b>${forumPostVOList[status.index].nickName}</b>
                        <br>
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                            value="${forumPostVOList[status.index].postTime}" />
                    </div>
                </div>
            </c:forEach>
            <div class="hot">
                <div class="hot_title">熱門文章</div>
                <div class="hot_detail AutoSkip"><c:forEach var="hot" items="${hotList}" varStatus="status">
                    <b>[第${status.count}名]</b> <span>${viewList[status.index]}次瀏覽</span><br>
                    <a href="posts.do?topicNo=${hot.topicNo}&postNo=${hot.postNo}&page=1">${hot.title}</a><br><br>
                </c:forEach></div>
            </div>
        </div>
    </div>
    <!-- ForumIndex End -->

    <!-- footer -->
    <footer class="footer">
        <div class="container">
            <div class="footer__top-row">
                <div class="row">
                    <div class="col-lg-4 col-md-6 footer__content">
                        <div class="footer-logo">
                            <img src="../images/MatDesignLogo.png" alt="">
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

    <!-- scroll up btn -->
    <a class="back-to-top-btn" id="back-to-top"></a>
    <!-- end scroll up btn -->

    <!-- All Jquery -->
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/popper.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <!-- owl carousel js -->
    <script type="text/javascript" src="../js/owl.carousel.min.js"></script>
    <!-- Jquery ui -->
    <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
    <!-- light box js -->
    <script type="text/javascript" src="../js/lightbox.min.js"></script>
    <!-- typeahead js -->
    <script type="text/javascript" src="../js/typeahead.jquery.min.js"></script>
    <!-- master zoom image js -->
    <script type="text/javascript" src="../js/jquery.zoom.min.js"></script>
    <!-- countdown js -->
    <script type="text/javascript" src="../js/countdown.jquery.min.js"></script>
    <!-- nice select js -->
    <script type="text/javascript" src="../js/nice-select.min.js"></script>
    <!-- wow js -->
    <script type="text/javascript" src="../js/wow.min.js"></script>
    <!-- custom js -->
    <script type="text/javascript" src="../js/custom.js"></script>

    <script src="../js/forum.js"></script>

</body>

</html>