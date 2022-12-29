<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default" data-assets-path="../assets/"
  data-template="vertical-menu-template-free">

<head>

  <meta charset="utf-8" />
  <meta name="viewport"
    content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

  <title>檢舉查核</title>

  <meta name="description" content="" />

  <!-- Favicon -->
  <link rel="icon" type="image/x-icon" href="../assets/img/favicon/favicon.ico" />

  <!-- Fonts -->
  <script src="https://kit.fontawesome.com/6a35b80892.js" crossorigin="anonymous"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
    rel="stylesheet" />

  <!-- Icons. Uncomment required icon fonts -->
  <link rel="stylesheet" href="../assets/vendor/fonts/boxicons.css" />

  <!-- Core CSS -->
  <link rel="stylesheet" href="../assets/vendor/css/core.css" class="template-customizer-core-css" />
  <link rel="stylesheet" href="../assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
  <link rel="stylesheet" href="../assets/css/demo.css" />

  <!-- Vendors CSS -->
  <link rel="stylesheet" href="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

  <link rel="stylesheet" href="../assets/vendor/libs/apex-charts/apex-charts.css" />

  <!-- Page CSS -->
  <link rel="stylesheet" href="../css/adminforum.css">

  <!-- Helpers -->
  <script src="../assets/vendor/js/helpers.js"></script>

  <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
  <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
  <script src="../assets/js/config.js"></script>

</head>

<body>
  <!-- Layout wrapper -->
  <div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
      <!-- Menu -->

      <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
        <div class="app-brand demo">
          <a href="../index.html" class="app-brand-link">
            <span class="app-brand-text demo menu-text fw-bolder ms-2">MatDesign</span>
          </a>

          <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
            <i class="bx bx-chevron-left bx-sm align-middle"></i>
          </a>
        </div>

        <div class="menu-inner-shadow"></div>

        <ul class="menu-inner py-1">

          <!-- Member會員管理 -->
          <li class="menu-item">
            <a href="javascript:void(0);" class="menu-link menu-toggle">
              <i class="menu-icon tf-icons fa-regular fa-user "></i>
              <div data-i18n="Member">會員管理</div>
            </a>

            <ul class="menu-sub">
              <li class="menu-item">
                <a href="../member/Admin-Member-MemberInfo.html" class="menu-link">
                  <div data-i18n="">會員資料管理</div>
                </a>
              </li>
            </ul>
          </li>

          <!-- Designer設計師管理 -->
          <li class="menu-item">
            <a href="javascript:void(0);" class="menu-link menu-toggle">
              <i class="menu-icon tf-icons fa-solid fa-user"></i>
              <div data-i18n="Designer">設計師管理</div>
            </a>
            <ul class="menu-sub">
              <li class="menu-item">
                <a href="../designer/Admin-Design-DesignerInfo.html" class="menu-link">
                  <div data-i18n="">設計師資料管理</div>
                </a>
              </li>
              <li class="menu-item">
                <a href="../designer/Admin-Design-Portfolio.html" class="menu-link">
                  <div data-i18n="">作品管理</div>
                </a>
              </li>
            </ul>
          </li>

          <!-- Designer_Order設計師訂單管理 -->
          <li class="menu-item">
            <a href="javascript:void(0);" class="menu-link menu-toggle">
              <i class="menu-icon tf-icons fa-regular fa-file"></i>
              <div data-i18n="Designer_Order">合約案件管理</div>
            </a>
            <ul class="menu-sub">
              <li class="menu-item">
                <a href="../order/Admin-Order-OrderList.html" class="menu-link">
                  <div data-i18n="">合約案件列表</div>
                </a>
              </li>
              <li class="menu-item">
                <a href="../order/Admin-Order-OrderListDetail.html" class="menu-link">
                  <div data-i18n="">合約案件明細</div>
                </a>
              </li>
              <li class="menu-item">
                <a href="../order/Admin-Order-ReviewList.html" class="menu-link">
                  <div data-i18n="">評價列表</div>
                </a>
              </li>
              <li class="menu-item">
                <a href="../order/Admin-Order-OrderReportCheck.html" class="menu-link">
                  <div data-i18n="">評價檢舉查核</div>
                </a>
              </li>
            </ul>
          </li>

          <!-- Forum論壇管理 -->
          <li class="menu-item active open">
            <a href="javascript:void(0);" class="menu-link menu-toggle">
              <i class="menu-icon tf-icons fa-regular fa-pen-to-square"></i>
              <div data-i18n="Forum">論壇管理</div>
            </a>
            <ul class="menu-sub">
              <li class="menu-item">
                <a href="adminForumTopic.do" class="menu-link">
                  <div data-i18n="">論壇維護</div>
                </a>
              </li>
              <li class="menu-item">
                <a href="adminForumAll.do" class="menu-link">
                  <div data-i18n="">文章列表</div>
                </a>
              </li>
              <li class="menu-item active">
                <a href="adminForumReport.do" class="menu-link">
                  <div data-i18n="">檢舉查核</div>
                </a>
              </li>
            </ul>
          </li>

          <!-- Product商品管理 -->
          <li class="menu-item">
            <a href="javascript:void(0)" class="menu-link menu-toggle">
              <i class="menu-icon tf-icons bx bx-shopping-bag"></i>
              <div data-i18n="Product">商品管理</div>
            </a>
            <ul class="menu-sub">
              <li class="menu-item">
                <a href="../product/Admin-Product-ProductList.html" class="menu-link">
                  <div data-i18n="">商品列表</div>
                </a>
              </li>
              <li class="menu-item">
                <a href="../product/Admin-Product-ProductType.html" class="menu-link">
                  <div data-i18n="">商品類別</div>
                </a>
              </li>
              <li class="menu-item">
                <a href="../product/Admin-Product-ProductOrderList.html" class="menu-link">
                  <div data-i18n="">商品訂單管理</div>
                </a>
              </li>
            </ul>
          </li>

          <!-- Article報導文章管理 -->
          <li class="menu-item">
            <a href="javascript:void(0)" class="menu-link menu-toggle">
              <i class="menu-icon tf-icons bx bx-copy"></i>
              <div data-i18n="Article">報導文章管理</div>
            </a>
            <ul class="menu-sub">
              <li class="menu-item">
                <a href="../article/Admin-Article-ArticleList.html" class="menu-link">
                  <div data-i18n="">報導文章列表</div>
                </a>
              </li>
              <li class="menu-item">
                <a href="../article/Admin-Article-ArticleType.html" class="menu-link">
                  <div data-i18n="">報導文章類別</div>
                </a>
              </li>
            </ul>
          </li>

          <!-- Admin管理員管理 -->
          <li class="menu-item">
            <a href="javascript:void(0);" class="menu-link menu-toggle">
              <i class="menu-icon tf-icons fa-solid fa-users-gear"></i>
              <div data-i18n="Admin">管理員管理</div>
            </a>
            <ul class="menu-sub">
              <li class="menu-item">
                <a href="../admin/Admin-Admin-AdminInfo.html" class="menu-link">
                  <div data-i18n="">管理員資料管理</div>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </aside>
      <!-- / Menu -->

      <!-- Layout container -->
      <div class="layout-page">
        <!-- Navbar -->
        <nav
          class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
          id="layout-navbar">
          <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
            <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
              <i class="bx bx-menu bx-sm"></i>
            </a>
          </div>

          <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">

            <ul class="navbar-nav flex-row align-items-center ms-auto">
              <!-- User -->
              <li class="nav-item navbar-dropdown dropdown-user dropdown">
                <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                  <div class="avatar avatar-online">
                    <img src="../assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle" />
                  </div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                  <li>
                    <a class="dropdown-item" href="#">
                      <div class="d-flex">
                        <div class="flex-shrink-0 me-3">
                          <div class="avatar avatar-online">
                            <img src="../assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle" />
                          </div>
                        </div>
                        <div class="flex-grow-1">
                          <span class="fw-semibold d-block">John Doe</span>
                          <small class="text-muted">Admin</small>
                        </div>
                      </div>
                    </a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">
                      <i class="bx bx-user me-2"></i>
                      <span class="align-middle">My Profile</span>
                    </a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">
                      <i class="bx bx-cog me-2"></i>
                      <span class="align-middle">Settings</span>
                    </a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="auth-login-basic.html">
                      <i class="bx bx-power-off me-2"></i>
                      <span class="align-middle">Log Out</span>
                    </a>
                  </li>
                </ul>
              </li>
              <!--/ User -->
            </ul>
          </div>
        </nav>
        <!-- / Navbar -->

        <!-- Content wrapper -->
        <div class="content-wrapper">
          <!-- Content -->
          <div class="container-xxl flex-grow-1 container-p-y">
            <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">論壇管理</span></h4>

            <!-- Basic Bootstrap Table -->
            <div class="card">
              <div class="card-header">
                <h5>檢舉查核</h5>
                <form action="adminForumReport.do" method="post">
                  <select name="listname">
                    <option value="all" ${listname=="all" ? 'selected' :''}>全部案件
                    <option value="done" ${listname=="done" ? 'selected' :''}>已處理
                    <option value="undone" ${listname=="undone" ? 'selected' :''}>未處理
                  </select>
                  <button class="sendButton btn_style" type="submit">送出</button>
                </form>
              </div>
              <div class="table-responsive text-nowrap">
                <table class="table">
                  <thead>
                    <tr>
                      <th>案件編號</th>
                      <th>檢舉發文/回應編號</th>
                      <th>文章內容</th>
                      <th>檢舉原因</th>
                      <th>檢舉時間</th>
                      <th>處理狀態</th>
                      <th>處理結果</th>
                      <th>動作</th>
                      <th>負責管理員</th>
                      <th>處理時間</th>
                    </tr>
                  </thead>
                  <tbody class="table-border-bottom-0">
                    <c:forEach var="forumReportVOList" items="${forumReportVOList}" begin="${pageStart}"
                      end="${pageEnd}">
                      <tr>
                        <td>${forumReportVOList.reportNo}</td>
                        <td>
                          發文編號：${forumReportVOList.postNo ==0?'--':forumReportVOList.postNo}<br>
                          回文編號： ${forumReportVOList.replyNo ==0? '--':forumReportVOList.replyNo}
                        </td>
                        <td>
                          <button class="openButton btn_style">展開</button>
                          <div class="contentPopup pop">
                            <div class="contentContainer">
                              <button class="closeContent close_btn">關閉</button><br><br>
                              ${forumReportVOList.postNo==0?'forumReportVOList.replyContent':forumReportVOList.postContent}
                            </div>
                          </div>
                        </td>
                        <td>
                          <button class="openButton btn_style">點選展開</button>
                          <div class="reasonPopup pop">
                            <div class="reasonContainer">
                              檢舉人：${forumReportVOList.informant}<br>檢舉原因：<br>
                              <textarea rows="5" cols="25" readonly>${forumReportVOList.reportReason}</textarea><br>
                              <button class="closeReason close_btn">關閉</button>
                            </div>
                          </div>
                        </td>
                        <td>
                          <fmt:formatDate pattern="yyyy-MM-dd" value="${forumReportVOList.reportTime}" />
                          <br>
                          <fmt:formatDate pattern="HH:mm:ss" value="${forumReportVOList.reportTime}" />
                        </td>
                        <c:choose>
                          <c:when test="${forumReportVOList.reportStatus=='已處理'}">
                            <td><label class="badge bg-label-success me-1">${forumReportVOList.reportStatus}</label>
                            </td>
                          </c:when>
                          <c:otherwise>
                            <td><label class="badge bg-label-warning me-1">${forumReportVOList.reportStatus}</label>
                            </td>
                          </c:otherwise>
                        </c:choose>
                        <td>${forumReportVOList.reviewResult}</td>
                        <c:choose>
                          <c:when test="${forumReportVOList.reportStatus!='已處理'}">
                            <td>
                              <form id="review_form" method="post"><select name="reviewResult">
                                  <option value="">請選擇
                                  <option value="未違規">未違規
                                  <option value="下架">下架
                                </select>
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="reviewer" value="1">
                                <%-- 記得換成${adminVO.adminNo} --%>
                                  <input type="hidden" name="postNo" value="${forumReportVOList.postNo}">
                                  <input type="hidden" name="replyNo" value="${forumReportVOList.replyNo}">
                                  <input type="hidden" name="listname" value="${listname}">
                                  <button class="sendButton btn_style review_btn" type="button">送出</button>
                              </form>
                            </td>
                          </c:when>
                          <c:otherwise>
                            <td>結案</td>
                          </c:otherwise>
                        </c:choose>
                        <td>
                          <c:if test="${forumReportVOList.reviewer !=0}">
                            ${forumReportVOList.reviewer}
                          </c:if>
                        </td>
                        <td>
                          <fmt:formatDate pattern="yyyy-MM-dd" value="${forumReportVOList.reviewTime}" />
                          <br>
                          <fmt:formatDate pattern="HH:mm:ss" value="${forumReportVOList.reviewTime}" />
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <c:if test="${not empty forumReportVOList}">
              <c:if test="${param.page>1}">
                <a href="adminForumReport.do?page=${param.page-1}&listname=${listname}">上一頁 </a>
              </c:if>
              <c:if test="${param.page<totalPage}">
                <a href="adminForumReport.do?page=${param.page+1}&listname=${listname}">下一頁</a>
              </c:if>
              <div style="float:right">
                <a href="adminForumReport.do?page=1&listname=${listname}">至第一頁</a>
                <span>第${param.page}頁 / 共${totalPage}頁</span>
                <a href="adminForumReport.do?page=${totalPage}&listname=${listname}">至最後一頁</a>
              </div>
            </c:if>
            <!--/ Basic Bootstrap Table -->

            <!-- / Content -->

            <!-- Footer -->
            <footer class="content-footer footer bg-footer-theme">
              <div class="container-xxl d-flex flex-wrap justify-content-between py-2 flex-md-row flex-column">
                <div class="mb-2 mb-md-0">
                  ©
                  <script>
                    document.write(new Date().getFullYear());
                  </script>
                  , made by
                  <a href="#" target="_blank" class="footer-link fw-bolder">MatDesign</a>
                </div>
              </div>
            </footer>
            <!-- / Footer -->

            <div class="content-backdrop fade"></div>
          </div>
          <!-- Content wrapper -->
        </div>
        <!-- / Layout page -->
      </div>

      <!-- Overlay -->
      <div class="layout-overlay layout-menu-toggle"></div>
    </div>
    <!-- / Layout wrapper -->

    <!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->
    <script src="../assets/vendor/libs/jquery/jquery.js"></script>
    <script src="../assets/vendor/libs/popper/popper.js"></script>
    <script src="../assets/vendor/js/bootstrap.js"></script>
    <script src="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

    <script src="../assets/vendor/js/menu.js"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->
    <script src="../assets/vendor/libs/apex-charts/apexcharts.js"></script>

    <!-- Main JS -->
    <script src="../assets/js/main.js"></script>

    <!-- Page JS -->
    <script src="../assets/js/dashboards-analytics.js"></script>

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>

    <script src="../js/forum_backend.js"></script>

</body>

</html>