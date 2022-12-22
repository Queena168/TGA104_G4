<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>MatDesign chatroom</title>
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600"
	rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="../css/chatroom.css">

</head>
<body onload="connect();" onunload="disconnect();">
	<!-- partial:index.partial.html -->
	<div class="wrapper">
		<div class="container">
			<div class="left">
				<div class="top">
					<h1>聊天室</h1>
				</div>
				<div >
					<ul class="people" id="row">

					<!-- <li class="person" data-chat="person2">
	                    <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/382994/dog.png" alt="" />
	                    <span class="name">Dog Woofson</span>
	                    <span class="time">1:44 PM</span>
	                    <span class="preview">I've forgotten how it felt before</span>
	                </li> -->

					</ul>
				</div>
			</div>
			<div class="right">
				<div class="top">
					<span> To: <span id="friendName" class="name"></span></span>
				</div>
				<div id="messagesArea" class="chat " >
				</div>
				<!-- <div class="chat" data-chat="person2">
                <div class="conversation-start">
                    <span>Today, 5:38 PM</span>
                </div>
                <div class="bubble you">
                    Hello, can you hear me?
                </div>
                <div class="bubble you">
                    I'm in California dreaming
                </div>
                <div class="bubble me">
                    ... about who we used to be.
                </div>
                <div class="bubble me">
                    Are you serious?
                </div>
                <div class="bubble you">
                    When we were younger and free...
                </div>
                <div class="bubble you">
                    I've forgotten how it felt before
                </div>
            </div> -->


				<div class="write ">
					<a href="javascript:;" class="write-link attach"></a> <input
						id="message" class="text-field" type="text" placeholder="Message"
						onkeydown="if (event.keyCode == 13) sendMessage();" /> <a
						href="javascript:;" class="write-link smiley"></a> <a
						href="javascript:;" class="write-link send"> <input
						type="submit" id="sendMessage" class="button" value="Send"
						onclick="sendMessage();" hidden />
					</a>
				</div>
			</div>
		</div>
		<!-- message -->
		<script>
			var MyPoint = "/ChatWS/${userName}";
			var host = window.location.host;
			var path = window.location.pathname;
			var webCtx = path.substring(0, path.indexOf('/', 1));
			var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;

			var statusOutput = document.getElementById("friendName");
			var messagesArea = document.getElementById("messagesArea");
			var self = '${userName}';
			var webSocket;

			function connect() {
				// create a websocket
				webSocket = new WebSocket(endPointURL);
				// 連線狀態開啟時 改變按鈕顯示
				webSocket.onopen = function(event) {
					console.log("Connect Success!");
				
					
				};

				webSocket.onmessage = function(event) {
					var jsonObj = JSON.parse(event.data)
					if ("open" === jsonObj.type) {
						refreshFriendList(jsonObj);
					} else if ("history" === jsonObj.type) {
						messagesArea.innerHTML = '';
						var chatDiv = document.createElement('div');
						var friend = statusOutput.innerHTML;
						chatDiv.setAttribute("class","chat");
						chatDiv.setAttribute("data-chat",friend)
						messagesArea.appendChild(chatDiv);
						
						// 這行的jsonObj.message是從redis撈出跟好友的歷史訊息，再parse成JSON格式處理
						var messages = JSON.parse(jsonObj.message);
						console.log(JSON.parse(jsonObj.message));
						for (var i = 0; i < messages.length; i++) {
							var historyData = JSON.parse(messages[i]);
							var showMsg = historyData.message;
							
							var conversationDiv = document.createElement('div');
							// 根據發送者是自己還是對方來給予不同的class名, 以達到訊息左右區分
							historyData.sender === self ? conversationDiv.className += 'me'
									: conversationDiv.className += 'friend';
							conversationDiv.innerHTML = showMsg;
							chatDiv.appendChild(conversationDiv);
						}
					} else if ("chat" === jsonObj.type) {
						var li = document.createElement('li');
						jsonObj.sender === self ? li.className += 'me'
								: li.className += 'friend';
						li.innerHTML = jsonObj.message;
						console.log(li);
						document.getElementById("area").appendChild(li);
						messagesArea.scrollTop = messagesArea.scrollHeight;
					} else if ("close" === jsonObj.type) {
						refreshFriendList(jsonObj);
					}
				};

				webSocket.onclose = function(event) {
					console.log("Disconnected!");
				};
			}

			function sendMessage() {
				var inputMessage = document.getElementById("message");
				var friend = statusOutput.textContent;
				var message = inputMessage.value.trim();

				if (message === "") {
					alert("Input a message");
					inputMessage.focus();
				} else if (friend === "") {
					alert("Choose a friend");
				} else {
					var jsonObj = {
						"type" : "chat",
						"sender" : self,
						"receiver" : friend,
						"message" : message
					};
					webSocket.send(JSON.stringify(jsonObj));
					inputMessage.value = "";
					inputMessage.focus();
				}
			}

			// 有好友上線或離線就更新列表
			function refreshFriendList(jsonObj) {
				var friends = jsonObj.users;
				var row = document.getElementById("row");
				row.innerHTML = '';
				for (var i = 0; i < friends.length; i++) {
					if (friends[i] === self) {
						continue;
					}
					/* row.innerHTML += '<div id=' + i + ' class="column" name="friendName" value=' + friends[i] + ' ><h2>'
							+ friends[i] + '</h2></div>'; */
					row.innerHTML +=
						'<li class="person" data-chat=' + friends[i] + ' id=' + i + ' class="column" name="friendName" value=' + friends[i] + '><span class="name">' + friends[i] + '</span> </li>'	
				}
				addListener();
			}

			// 註冊列表點擊事件並抓取好友名字以取得歷史訊息
			function addListener() {
				var container = document.getElementById("row");
				container.addEventListener("click", function(e) {
					var friend = e.srcElement.textContent;
					updateFriendName(friend);
					var jsonObj = {
						"type" : "history",
						"sender" : self,
						"receiver" : friend,
						"message" : ""
					};
					webSocket.send(JSON.stringify(jsonObj));
				});
			}

			function updateFriendName(name) {
				statusOutput.innerHTML = name;
			}

			function disconnect() {
				webSocket.close();
			}
		</script>
		<!-- partial -->
		<!-- <script src="../js/chatroomscript.js"></script> -->
</body>
</html>
