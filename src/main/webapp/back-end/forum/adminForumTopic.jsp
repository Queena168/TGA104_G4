<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default" data-assets-path="../assets/"
  data-template="vertical-menu-template-free">

<head>
  <meta charset="utf-8" />
  <meta name="viewport"
    content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

  <title>論壇維護</title>

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

			<aside id="layout-menu"
				class="layout-menu menu-vertical menu bg-menu-theme">
				<div class="app-brand demo">
					<a href="index.jsp" class="app-brand-link"> <span
						class="app-brand-text demo menu-text fw-bolder ms-2">MatDesign</span>
					</a> <a href="javascript:void(0);"
						class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
						<i class="bx bx-chevron-left bx-sm align-middle"></i>
					</a>
				</div>

				<div class="menu-inner-shadow"></div>

				<ul class="menu-inner py-1">

					<!-- Member會員管理 -->
					<li class="menu-item"><a href="javascript:void(0);"
						class="menu-link menu-toggle"> <i
							class="menu-icon tf-icons fa-regular fa-user "></i>
							<div data-i18n="Member">會員管理</div>
					</a>

						<ul class="menu-sub">
							<li class="menu-item"><a
								href="../member/listAllMember.jsp" class="menu-link">
									<div data-i18n="">會員資料管理</div>
							</a></li>
						</ul></li>

					<!-- Designer設計師管理 -->
					<li class="menu-item"><a href="javascript:void(0);"
						class="menu-link menu-toggle"> <i
							class="menu-icon tf-icons fa-solid fa-user"></i>
							<div data-i18n="Designer">設計師管理</div>
					</a>
						<ul class="menu-sub">
							<li class="menu-item"><a
								href="../designer/Admin-Design-DesignerInfo.html"
								class="menu-link">
									<div data-i18n="">設計師資料管理</div>
							</a></li>
							<li class="menu-item"><a
								href="../designer_portfolio/listAllPortfolio.jsp" class="menu-link">
									<div data-i18n="">作品管理</div>
							</a></li>
						</ul></li>

					<!-- Designer_Order設計師訂單管理 -->
					<li class="menu-item"><a href="javascript:void(0);"
						class="menu-link menu-toggle"> <i
							class="menu-icon tf-icons fa-regular fa-file"></i>
							<div data-i18n="Designer_Order">合約案件管理</div>
					</a>
						<ul class="menu-sub">
							<li class="menu-item"><a
								href="../order/Admin-Order-OrderList.html" class="menu-link">
									<div data-i18n="">合約案件列表</div>
							</a></li>
							<li class="menu-item"><a
								href="../order/Admin-Order-OrderListDetail.html"
								class="menu-link" target="_blank">
									<div data-i18n="">合約案件明細</div>
							</a></li>
							<li class="menu-item"><a
								href="../order/Admin-Order-ReviewList.html" class="menu-link"
								target="_blank">
									<div data-i18n="">評價列表</div>
							</a></li>
							<li class="menu-item"><a
								href="../order/Admin-Order-OrderReportCheck.html"
								class="menu-link" target="_blank">
									<div data-i18n="">評價檢舉查核</div>
							</a></li>
						</ul></li>

					<!-- Forum論壇管理 -->
					<li class="menu-item active open"><a href="javascript:void(0);"
						class="menu-link menu-toggle"> <i
							class="menu-icon tf-icons fa-regular fa-pen-to-square"></i>
							<div data-i18n="Forum">論壇管理</div>
					</a>
						<ul class="menu-sub">
							<li class="menu-item active open"><a
								href="../forum/adminForumTopic.do" class="menu-link">
									<div data-i18n="">論壇維護</div>
							</a></li>
							<li class="menu-item"><a
								href="../forum/adminForumAll.do" class="menu-link">
									<div data-i18n="">文章列表</div>
							</a></li>
							<li class="menu-item"><a
								href="../forum/adminForumReport.do"
								class="menu-link">
									<div data-i18n="">檢舉查核</div>
							</a></li>
						</ul></li>

					<!-- Product商品管理 -->
					<li class="menu-item"><a href="javascript:void(0)"
						class="menu-link menu-toggle"> <i
							class="menu-icon tf-icons bx bx-shopping-bag"></i>
							<div data-i18n="Product">商品管理</div>
					</a>
						<ul class="menu-sub">
							<li class="menu-item"><a
								href="${pageContext.request.contextPath}/SelectAll"
								class="menu-link">
									<div data-i18n="">商品列表</div>
							</a></li>
							<!-- <li class="menu-item"><a
								href="../product/Admin-Product-ProductType.html"
								class="menu-link">
									<div data-i18n="">商品類別</div>
							</a></li> -->
							<li class="menu-item"><a
								href="${pageContext.request.contextPath}/BackendSelectAllOrder"
								class="menu-link">
									<div data-i18n="">商品訂單管理</div>
							</a></li>
						</ul></li>

					<!-- Article報導文章管理 -->
					<li class="menu-item"><a href="javascript:void(0)"
						class="menu-link menu-toggle"> <i
							class="menu-icon tf-icons bx bx-copy"></i>
							<div data-i18n="Article">報導文章管理</div>
					</a>
						<ul class="menu-sub">
							<li class="menu-item"><a
								href="../article/Admin-Article-ArticleList.html"
								class="menu-link">
									<div data-i18n="">報導文章列表</div>
							</a></li>
							<li class="menu-item"><a
								href="../article/Admin-Article-ArticleType.html"
								class="menu-link">
									<div data-i18n="">報導文章類別</div>
							</a></li>
						</ul></li>

					<!-- Admin管理員管理 -->
					<li class="menu-item"><a href="javascript:void(0);"
						class="menu-link menu-toggle"> <i
							class="menu-icon tf-icons fa-solid fa-users-gear"></i>
							<div data-i18n="Admin">管理員管理</div>
					</a>
						<ul class="menu-sub">
							<li class="menu-item"><a href="listAllAdmin.jsp"
								class="menu-link">
									<div data-i18n="">管理員資料管理</div>
							</a></li>
						</ul></li>
				</ul>
			</aside>
			<!-- / Menu -->

			<!-- Layout container -->
			<div class="layout-page">
				<!-- Navbar -->

				<nav
					class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
					id="layout-navbar">
					<div
						class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
						<a class="nav-item nav-link px-0 me-xl-4"
							href="javascript:void(0)"> <i class="bx bx-menu bx-sm"></i>
						</a>
					</div>

					<div class="navbar-nav-right d-flex align-items-center"
						id="navbar-collapse">

						<ul class="navbar-nav flex-row align-items-center ms-auto">
							<!-- User -->
							<li class="nav-item navbar-dropdown dropdown-user dropdown">
								<a class="nav-link dropdown-toggle hide-arrow"
								href="javascript:void(0);" data-bs-toggle="dropdown">
									<div class="avatar avatar-online">
										<img
											src="<%=request.getContextPath()%>/AdminPicReader?adminNo=${adminVO.adminNo}"
											alt class="w-px-40 rounded-circle" />
									</div>
							</a>
								<ul class="dropdown-menu dropdown-menu-end">
									<li><a class="dropdown-item" href="#">
											<div class="d-flex">
												<div class="flex-shrink-0 me-3">
													<div class="avatar avatar-online">
														<img
															src="<%=request.getContextPath()%>/AdminPicReader?adminNo=${adminVO.adminNo}"
															alt class="w-px-40  rounded-circle" />
													</div>
												</div>
												<div class="flex-grow-1">
													<span class="fw-semibold d-block">${adminVO.adminName}</span>
													<small class="text-muted">${adminVO.adminEmail}</small>
												</div>
											</div>
									</a></li>

									<li><form method="post"
											action="<%=request.getContextPath()%>/back-end/admin/admin.do">
											<div class="dropdown-item" > 
												
												<label class="btn rounded-pill bg-label-secondary" tabindex="0">
													<i class="bx bx-user me-2"></i> 
													<span class="align-middle">My Profile</span> 
													<input type="hidden" name="adminNo" value="${adminVO.adminNo}"> 
													<input type="hidden" name="action" value="getOne_For_Profile">
													<input type="submit" class="account-file-input" hidden />
												</label>
											</div>
										</form></li>
									<li><a class="dropdown-item" href="../adminLogin/admin-login.jsp">
												<label class="btn rounded-pill bg-label-secondary" tabindex="0">
													<i class="bx bx-power-off me-2"></i> 
													<span class="align-middle">Log Out</span> 
												</label>
									</a></li>	
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
              <h5 class="card-header">論壇維護
                <button id="add_btn" class="btn_style" style="float:right">新增討論區</button>
              </h5>
              <div class="table-responsive text-nowrap">
                <table class="table">
                  <thead>
                    <tr>
                      <th>討論區名稱</th>
                      <th>開版日期</th>
                      <th>修改日期</th>
                      <th>管理員編號</th>
                      <th>動作</th>
                    </tr>
                  </thead>
                  <tbody class="table-border-bottom-0">
                    <c:forEach var="forumTopicVO" items="${forumTopicVOList}" varStatus="status">
                      <tr>
                        <td style="display:none">${forumTopicVO.topicNo}</td>
                        <td>${forumTopicVO.topicName}</td>
                        <td>${forumTopicVO.startDate}</td>
                        <c:choose>
                          <c:when test="${forumTopicVO.modificationDate == null}">
                            <td>無</td>
                          </c:when>
                          <c:otherwise>
                            <td>${forumTopicVO.modificationDate}</td>
                          </c:otherwise>
                        </c:choose>
                        <td>${forumTopicVO.adminNo}</td>
                        <td> <button type="button" class="dropdown-item show_update"><i
                              class="bx bx-edit-alt me-1"></i>更新</button>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <!--/ Basic Bootstrap Table -->
            <hr class="my-5" />
            <div class="col-md-6" id="add_topic_div" style="display:none">
              <div class="card mb-4">
                <form id="add_topic_form">
                  <div class="card-body demo-vertical-spacing demo-only-element">
                    <h3>新增討論區</h3>
                    <div>
                      請輸入新討論區名稱(名稱請勿超過20字)
                      <div class="input-group">
                        <input id="add_topic_name" type="text" class="form-control" name="topicName" />
                      </div>
                    </div>
                    <div>
                      請選擇負責管理員<br>
                      <select name="adminNo" class="form-control">
                        <c:forEach var="adminVO" items="${adminVOList}">
                          <option value="${adminVO.adminNo}">
                            ${adminVO.adminNo}. ${adminVO.adminName}
                        </c:forEach>
                      </select>
                    </div>
                    <input type="hidden" name="action"><!-- value="insert"> --> 
                    <input class="btn_style" type="button" id="add_submit" value="送出">
                  </div>
                </form>
              </div>
            </div>
            <div class="col-md-6" id="update_topic_div" style="display:none">
              <div class="card mb-4">
                <form id="update_topic_form">
                  <div class="card-body demo-vertical-spacing demo-only-element">
                    <h3>修改討論區</h3>
                    <input id=update_topic_no type="hidden" name="topicNo" value="">
                    <div>
                      請輸入新討論區名稱(名稱請勿超過20字)
                      <div class="input-group">
                        <input id="update_topic_name" type="text" class="form-control" name="topicName" value="">
                      </div>
                    </div>
                    <div>
                      請選擇負責管理員<br>
                      <select name="adminNo" class="form-control" id="update_admin_no">
                        <c:forEach var="adminVO" items="${adminVOList}">
                          <option value="${adminVO.adminNo}">
                            ${adminVO.adminNo}. ${adminVO.adminName}
                        </c:forEach>
                      </select>
                    </div>
                    <input type="hidden" name="action"><!-- value="update"> --> 
                    <input class="btn_style" type="button" id="update_submit" value="送出">
                  </div>
                </form>
              </div>
            </div>
          </div>
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

  <script src="../js/forum_backend_topic.js"></script>

</body>

</html>