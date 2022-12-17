<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.admin.model.*"%>

<%
AdminVO adminVO = (AdminVO) request.getAttribute("adminVO");
%>

<!DOCTYPE html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="../assets/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>MatDesign Admin</title>

<meta name="description" content="" />


<!-- Chat -->
<link rel="stylesheet" href="../assets/css/friendchat.css" />


</head>

<body onload="connect();" onunload="disconnect();">
	<!-- Layout wrapper -->
	
						<!-- 聊天室測試 -->
						<h3 id="statusOutput" class="statusOutput"></h3>
						<div id="row"></div>
						<div id="messagesArea" class="panel message-area"></div>
						<div class="panel input-area">
							<input id="message" class="text-field" type="text"
								placeholder="Message"
								onkeydown="if (event.keyCode == 13) sendMessage();" /> <input
								type="submit" id="sendMessage" class="button" value="Send"
								onclick="sendMessage();" /> <input type="button" id="connect"
								class="button" value="Connect" onclick="connect();" /> <input
								type="button" id="disconnect" class="button" value="Disconnect"
								onclick="disconnect();" />
						</div>
						<!-- /聊天室測試 -->



<!-- / Layout wrapper -->


<!-- 聊天室JS -->
<script>
	var MyPoint = "/ChatWS/${userName}";
	var host = window.location.host;
	var path = window.location.pathname;
	var webCtx = path.substring(0, path.indexOf('/', 1));
	var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;

	var statusOutput = document.getElementById("statusOutput");
	var messagesArea = document.getElementById("messagesArea");
	var self = '${userName}';
	var webSocket;
	
	function connect(){
		// create a websocket
		webSocket = new WebSocket(endPointURL);
		// 連線狀態開啟時 改變按鈕顯示
		webSocket.onopen = function(event){
			console.log("Connect Success!");
			document.getElementById('sendMessage').disabled = false;
			document.getElementById('connect').disabled = true;
			document.getElementById('disconnect').disabled = false;
		};
		
		webSocket.onmessage = function(event){
			var jsonObj = JSON.parse(event.data)
			if ("open" === jsonObj.type){
				refreshFriendList(jsonObj);
			}else if ("history" === jsonObj.type){
				messagesArea.innerHTML = '';
				var ul = document.createElement('ul');
				ul.id = "area";
				messagesArea.appendChild(ul);
				// 這行的jsonObj.message是從redis撈出跟好友的歷史訊息，再parse成JSON格式處理
				var message = JSON.parse(jsonObj.message);
				for(var i = 0; i < message.length; i++){
					var historyData = JSON.parse(messages[i]);
					var showMsg = historyData.message;
					var li = document.createElement('li');
					// 根據發送者是自己還是對方來給予不同的class名, 以達到訊息左右區分
					historyData.sender === self ? li.className += 'me' : li.className += 'friend';
					li.innerHTML = showMsg;
					ul.appendChild(li);
				}
			}else if("chat" === jsonObj.type){
					var li = document.createElement('li');
					jsonObj.sender === self ? li.className += 'me' : li.className += 'friend';
					li.innerHTML = jsonObj.message;
					console.log(li);
					document.getElementById("area").appendChild(li);
					messagesArea.scrollTop = messagesArea.scrollHeight;
			}else if("close" === jsonObj.type){
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
	function refreshFriendList(jsonObj){
		var friends = jsonObj.users;
		var row = document.getElementById("row");
		row.innerHTML = '';
		for (var i = 0; i < friends.length; i++) {
			if (friends[i] === self) { continue; }
			row.innerHTML +='<div id=' + i + ' class="column" name="friendName" value=' + friends[i] + ' ><h2>' + friends[i] + '</h2></div>';
		}
		addListener();
	}
	
	// 註冊列表點擊事件並抓取好友名字以取得歷史訊息
	function addListener(){
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
		document.getElementById('sendMessage').disabled = true;
		document.getElementById('connect').disabled = false;
		document.getElementById('disconnect').disabled = true;
	}
	
	

</script>
<!-- / 聊天室JS -->

</body>
</html>
