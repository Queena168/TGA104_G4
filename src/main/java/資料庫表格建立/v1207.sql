create database if not exists MatDesignDB;

use MatDesignDB;

-- drop table if exists Admin;
-- drop table if exists Cart;
-- drop table if exists Chat;
-- drop table if exists ChatMessage;
-- drop table if exists Designer;
-- drop table if exists Forumpost;
-- drop table if exists Forumreply;
-- drop table if exists Forumreport;
-- drop table if exists Forumtopic;
-- drop table if exists Member;
-- drop table if exists Portfolio;
-- drop table if exists PortfolioStyle;
-- drop table if exists Postatt;
-- drop table if exists Product;
-- drop table if exists ProductOrder;
-- drop table if exists ProductOrderDetail;
-- drop table if exists ProductPic;
-- drop table if exists ProductType;
-- drop table if exists Replyatt;
-- drop table if exists Style;


-- (12.02 Mars) ADMIN createTime 定義DEFAULT CURRENT_TIMESTAMP--
-- -----ADMIN(管理員)----- --
create table Admin (
	adminNo        int auto_increment not null comment'管理員編號',
    adminEmail     varchar(50) not null comment'信箱',
    adminPassword  varchar(50) not null comment'密碼',
    adminName      varchar(50) comment'名稱',
    adminPic       longblob comment'大頭貼',
    adminPrivilege varchar(50) comment'權限',
    createTime     timestamp DEFAULT CURRENT_TIMESTAMP comment'創立時間',
    uploader       int comment'上傳管理員',
    constraint Admin_adminNo_PK primary key (adminNo)
);

-- //ADMIN測試資料// --
-- insert into Admin (adminEmail, adminPassword, adminName, adminPic, adminPrivilege, createTime, uploader) values ('test1@gmail.com', '123456', 'test1', null , '1', now(), 1);
-- insert into Admin (adminEmail, adminPassword, adminName, adminPic, adminPrivilege, createTime, uploader) values ('test2@gmail.com', '789012', 'test2', null , '1', now(), 1);
-- insert into Admin (adminEmail, adminPassword, adminName, adminPic, adminPrivilege, createTime, uploader) values ('test3@gmail.com', '345678', 'test3', null , '1', now(), 1);


-- 會員
CREATE TABLE Member (
 memberNo INT NOT NULL AUTO_INCREMENT COMMENT '會員編號',
 memberPassword varchar(50) NOT NULL COMMENT '會員密碼',
 memberName varchar(20) NOT NULL COMMENT '會員姓名',
 nickName varchar(20) NOT NULL COMMENT '會員暱稱',
 gender char(1) NOT NULL COMMENT '性別',
 birthDate datetime NOT NULL COMMENT '出生年月日',
 activaction boolean NOT NULL COMMENT '啟用狀態',
 constraint Member_memberNo_PK PRIMARY KEY(memberNo)
);
-- 參考資料
 -- insert into Member (memberPassword,memberName,nickName,gender,birthDate,ctivaction) values (4,'david','小明','男',780806,true);
--  insert into Member (memberPassword,memberName,nickName,gender,birthDate,ctivaction) values (4,'bob','珊迪','女',901110,true);


-- (12.06 Morris)修改以下
-- 1. 增加Phone欄位，定義設機師手機號
-- 2. 增加DesignerDetail，定義設計師簡介
-- 3. 原 DesignerName VARCHAR(25) 修改為 DesignerName VARCHAR(50)
-- 4. 原 ApprovalStatus VARCHAR(25) 修改為 ApprovalStatus VARCHAR(50)

-- 設計師表格
CREATE TABLE Designer(
DesignerNo INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '設計師編號',
DesignerAccount VARCHAR(50) NOT NULL COMMENT '設計師帳號(信箱)',
DesignerPassword VARCHAR(50) NOT NULL COMMENT '設計師密碼',
DesignerName VARCHAR(50) NOT NULL COMMENT '設計師名稱',
DesignerCompany VARCHAR(50) COMMENT '公司名稱',
DesignerPic LONGBLOB COMMENT '設計師照片',
Phone VARCHAR(50) COMMENT '手機號碼',
DesignerDetail VARCHAR(50) COMMENT '設計師簡介',
ApprovalStatus VARCHAR(50) COMMENT '審核狀態',
ApprovalTime TIMESTAMP COMMENT '審核時間',
Approver INT COMMENT '審核管理員編號',
DesignerStatus BOOLEAN COMMENT '設計師狀態',
CONSTRAINT FK_ADMIN_NO FOREIGN KEY (Approver) REFERENCES Admin(AdminNo) ON DELETE SET NULL ON UPDATE CASCADE
);

-- 測試資料
insert into Designer( 	
        DesignerAccount,
        DesignerPassword,
        DesignerName,
        DesignerCompany,
        DesignerPic,
        Phone,
        DesignerDetail,
        ApprovalStatus,
        ApprovalTime,
        Approver,
        DesignerStatus)
			values('test@gmail.com','123345','Joe','JoeDesign',null,'0911123456','我是設計師1號，很高興為您服務','審核成功',NOW(),1,0);
            
            
insert into DESIGNER( 	
        DesignerAccount,
        DesignerPassword,
        DesignerName,
        DesignerCompany,
        DesignerPic,
		Phone,
        DesignerDetail,
        ApprovalStatus,
        ApprovalTime,
        Approver,
        DesignerStatus)
			values('test2@gmail.com','123345','Van','MVG',null,'0911123456','我是設計師2號，很高興為您服務','審核成功',NOW(),1,0);

-- -----CHAT(聊天室)----- --
create table Chat (
	chatNo      int auto_increment not null comment'聊天室編號',
    memberNo    int not null comment'會員編號',
    designerNo  int not null comment'設計師編號',
    constraint Chat_chatNo_PK primary key (chatNo),
    constraint Chat_memberNo_FK foreign key (memberNo) references Member (memberNo),
    constraint Chat_designerNo_FK foreign key (designerNo) references Designer (designerNo)
);


-- //CHAT測試資料// --
-- insert into Chat (memberNo, designerNo) values (1, 1);
-- insert into Chat (memberNo, designerNo) values (1, 2);
-- insert into Chat (memberNo, designerNo) values (2, 1);
-- insert into Chat (memberNo, designerNo) values (2, 2);


-- (12.02 Mars) CHAT_MESSAGE sendTime 定義DEFAULT CURRENT_TIMESTAMP--
-- -----CHAT_MESSAGE(聊天訊息)----- --
create table ChatMessage(
	messageNo  int auto_increment not null comment'訊息編號',
    chatNo     int not null comment'聊天室編號',
    message    text comment'聊天內容',
    sendTime   timestamp DEFAULT CURRENT_TIMESTAMP comment'發送時間',
    sender     boolean comment'0為設計師發送 1為會員發送',
    constraint ChatMessage_messageNo_PK primary key (messageNo),
    constraint ChatMessage_chatNo_FK foreign key (chatNo) references Chat (chatNo)
);

-- //CHAT_MESSAGE測試資料// --
-- insert into ChatMessage (chatNo, message, sendTime, sender) values (1, '你好 設計師',            now(), 1) ;
-- insert into ChatMessage (chatNo, message, sendTime, sender) values (2, '會員你好 有什麼需要',     now(), 0) ;
-- insert into ChatMessage (chatNo, message, sendTime, sender) values (3, '設計師你好 我有裝潢需求',  now(), 1) ;
-- insert into ChatMessage (chatNo, message, sendTime, sender) values (4, '會員2你好 有什麼需求請說', now(), 0) ;


-- (12.02 Mars) PORTFOLIO createTime, modificationTime定義皆有修改--
-- -----PORTFOLIO(設計師＿作品)----- --
create table Portfolio(
	portfolioNo      int auto_increment not null comment'作品編號',
    portfolioName    varchar(100) not null comment'作品名稱',
    designerNo       int not null comment'設計師編號',
    portfolioPic1     blob comment'照片編號1',
    portfolioPic2    blob comment'照片編號2',
    portfolioPic3    blob comment'照片編號3',
    portfolioPic4    blob comment'照片編號4',
    description      longtext not null comment'作品描述',
    createTime       timestamp DEFAULT CURRENT_TIMESTAMP comment'上傳時間',
    modificationTime timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment'修改時間',
    houseAge         varchar(25) comment'屋齡',
    houseSize        varchar(25) comment'坪數',
    houseArea        varchar(25) comment'區域',
    constraint Portfolio_portfolioNo_PK primary key (portfolioNo),
    constraint Portfolio_designerNo_FK foreign key (designerNo) references Designer (designerNo)
);

-- //PORTFOLIO測試資料// --
-- insert into Portfolio (portfolioName, designerNo, portfolioPic1, portfolioPic2, portfolioPic3, portfolioPic4, description, createTime, modificationTime, houseAge, houseSize, houseArea)
-- values ('作品1', 1, null, null, null, null, '這是1號作品描述', now(), now(), '1年', '10坪', '北部' );
-- insert into Portfolio (portfolioName, designerNo, portfolioPic1, portfolioPic2, portfolioPic3, portfolioPic4, description, createTime, modificationTime, houseAge, houseSize, houseArea)
-- values ('作品2', 2, null, null, null, null, '這是2號作品描述', now(), now(), '2年', '20坪', '中部' );
-- insert into Portfolio (portfolioName, designerNo, portfolioPic1, portfolioPic2, portfolioPic3, portfolioPic4, description, createTime, modificationTime, houseAge, houseSize, houseArea)
-- values ('作品3', 3, null, null, null, null, '這是3號作品描述', now(), now(), '3年', '30坪', '南部' );


-- -----STYLE(風格)----- --
create table Style(
	styleNo   int auto_increment not null comment'風格編號',
    styleName varchar(50) not null comment'風格名稱',
    constraint Style_styleNo_PK primary key (styleNo)
);

-- //STYLE測試資料// --
-- insert into Style (styleName) values('北歐風');
-- insert into Style (styleName) values('現代風');
-- insert into Style (styleName) values('工業風');

-- -----PORFOLIO_STYLE(作品風格)----- --
create table PortfolioStyle(
	portfolioStyleNO  int auto_increment not null comment'作品風格編號',
    portfolioNo       int not null comment'作品編號',
    styleNo           int not null comment'風格編號',
    constraint PortfolioStyle_portfolioStyleNO_PK primary key (portfolioStyleNO),
    constraint PortfolioStyle_portfolioNo_FK foreign key (portfolioNo) references Portfolio (portfolioNo),
    constraint PortfolioStyle_styleNo_FK foreign key (styleNo) references Style (styleNo)
);

-- //PORFOLIO_STYLE測試資料// --
-- insert into PortfolioStyle (portfolioNo, styleNo) values (1, 1);
-- insert into PortfolioStyle (portfolioNo, styleNo) values (2, 2);



CREATE TABLE ForumTopic(
	topicNo int auto_increment not null comment '討論區編號',
    topicName varchar(20) not null comment '討論區名稱',
    startDate date default (current_date) not null comment '開版日期',
	modificationDate date comment '修改日期',
    adminNo int not null comment '管理者編號',
    constraint ForumTopic_topicNo_PK primary key (topicNo),
    constraint ForumTopic_adminNo_FK foreign key (adminNo) references Admin (adminNo) 
);
-- 假資料 --
-- INSERT INTO ForumTopic (topicName, adminNo) VALUES ("裝潢經驗分享區", 1);
-- INSERT INTO ForumTopic (topicName, adminNo) VALUES ("DIY自己來", 1);
-- INSERT INTO ForumTopic (topicName, adminNo) VALUES ("設計師甘苦談", 2);

-- (12.07 于寬) 修改content 型別成longtext
CREATE TABLE ForumPost(
	postNo int auto_increment not null comment '文章編號',
	memberNo int not null comment '會員編號',
    topicNo int not null  comment '所屬討論區編號',
    title varchar(50) not null  comment '文章標題',
    content longtext not null  comment '文章內容',
    postTime timestamp default now() not null comment '發文時間',
	modificationTime timestamp comment '修改時間',
    view int default 0 not null comment '瀏覽次數',
	constraint ForumPost_postNo_PK primary key (postNo),
    constraint ForumPost_topicNo_FK foreign key (topicNo) references ForumTopic (topicNo),
    constraint ForumPost_memberNo_FK foreign key (memberNo) references Member (memberNo)
);
-- 假資料 --
-- INSERT INTO ForumPost (memberNo, topicNo, title, content) VALUES (1, 1, "這是一篇發文", "發文內容");
-- INSERT INTO ForumPost (memberNo, topicNo, title, content) VALUES (2, 2, "這是一篇發文", "發文內容");
-- INSERT INTO ForumPost (memberNo, topicNo, title, content) VALUES (2, 2, "這是一篇發文", "發文內容");
-- INSERT INTO ForumPost (memberNo, topicNo, title, content) VALUES (1, 3, "這是一篇發文", "發文內容");
-- INSERT INTO ForumPost (memberNo, topicNo, title, content) VALUES (1, 3, "這是一篇發文", "發文內容");

-- (12.07 于寬) 修改content 型別成longtext
CREATE TABLE ForumReply(
	replyNo int auto_increment not null comment '回應編號',
    memberNo int not null comment '會員編號',
    replyTo int not null comment '對應文章編號',
    content longtext not null comment '回應內容',
    replyTime timestamp default now() not null comment '回應時間',
	modificationTime timestamp comment '修改時間',
    view int default 0 not null comment '瀏覽次數',
	constraint ForumReply_replyNo_PK primary key (replyNo),
    constraint ForumReply_replyTo_FK foreign key (replyTo) references ForumPost (postNo),
	constraint ForumReply_memberNo_FK foreign key (memberNo) references Member (memberNo)
);
-- 假資料 --
-- INSERT INTO ForumReply (memberNo, replyTo, content) VALUES (1, 2, "回應內容");
-- INSERT INTO ForumReply (memberNo, replyTo, content) VALUES (1, 1, "回應內容");
-- INSERT INTO ForumReply (memberNo, replyTo, content) VALUES (2, 2, "回應內容");
-- INSERT INTO ForumReply (memberNo, replyTo, content) VALUES (2, 3, "回應內容");
-- INSERT INTO ForumReply (memberNo, replyTo, content) VALUES (2, 1, "回應內容");


CREATE TABLE PostAtt(
	postAttNo int auto_increment not null comment '文章附檔流水號',
    postNo int not null comment '文章編號',
    att longblob comment '附檔',
    uploadTime timestamp default now() not null comment '上傳時間',
	modificationTime timestamp comment '修改時間',
    constraint PostAtt_postAttNo_PK primary key (postAttNo),
    constraint PostAtt_postNo_FK foreign key (postNo) references ForumPost (postNo)
);
-- 假資料 --
-- INSERT INTO PostAtt (postNo) VALUES (1);
-- INSERT INTO PostAtt (postNo) VALUES (2);
-- INSERT INTO PostAtt (postNo) VALUES (3);


CREATE TABLE ReplyAtt(
	replyAttNo int auto_increment not null comment '回應附檔流水號',
    replyNo int not null comment '回應編號',
    att longblob comment '附檔',
    uploadTime timestamp default now() not null comment '上傳時間',
	modificationTime timestamp comment '修改時間',
    constraint ReplyAtt_replyAttNo_PK primary key (replyAttNo),
	constraint ReplyAtt_replyNo_FK foreign key (replyNo) references ForumReply (replyNo)
);
-- 假資料 --
-- INSERT INTO ReplyAtt (replyNo) VALUES (1);
-- INSERT INTO ReplyAtt (replyNo) VALUES (2);
-- INSERT INTO ReplyAtt (replyNo) VALUES (3);


CREATE TABLE ForumReport(
	reportNo int auto_increment not null comment '檢舉案件編號',
    postNo int comment '文章編號',
    replyNo int comment '回應編號',
    informant int not null comment '檢舉者',
    reviewer int comment '審核者',
    reportReason varchar(50) not null comment '檢舉原因',
    reportTime timestamp default now() not null comment '檢舉時間',
    reportStatus varchar(25) default "未處理" not null comment '案件處理狀態',
	reviewTime timestamp comment '審核時間',
    reviewResult varchar(25) comment '審核結果',
    constraint ForumReport_reportNo_PK primary key (reportNo),
    constraint ForumReport_postNo_FK foreign key (postNo) references ForumPost (postNo),
	constraint ForumReportT_replyNo_FK foreign key (replyNo) references ForumReply (replyNo),
	constraint ForumReport_informant_FK foreign key (informant) references Member (memberNo),
	constraint ForumReport_reviewer_FK foreign key (reviewer) references Admin (adminNo)
);
-- 假資料 --
-- INSERT INTO ForumReport (postNo, informant, reportReason) VALUES (1, 1, "NONONO");
-- INSERT INTO ForumReport (postNo, informant, reportReason) VALUES (2, 2, "NONONO");
-- INSERT INTO ForumReport (replyNo, informant, reportReason) VALUES (3, 1, "NONONO");
-- INSERT INTO ForumReport (replyNo, informant, reportReason) VALUES (4, 2, "NONONO");
-- INSERT INTO ForumReport (postNo, informant, reportReason) VALUES (3, 1, "NONONO");

-- 創建商品類別 --
create table ProductType(
	productTypeNo int auto_increment not null comment '商品類別編號',
    productTypeName varchar(50) comment '商品類別名稱', 
    constraint PRODUCT_TYPE_PRODUCT_TYPE_NO_PK primary key (productTypeNo)
);
-- 插入商品類別值 --
-- insert into ProductType(productTypeName) values('家飾');
-- insert into ProductType(productTypeName) values('家具');
-- insert into ProductType(productTypeName) values('建材');

-- 創建商品 --
create table Product(
	productNo int auto_increment not null comment '商品編號',
    productTypeNo int not null comment '商品類別編號',
    productName varchar(50) not null comment '商品名稱',
    stock int not null comment '商品庫存量',
    price int not null comment '商品單價',
    productDescription varchar(100) comment '商品描述',
    productStatus varchar(50) comment '商品狀態',
    adminNo int not null comment '管理員編號',
    constraint PRODUCT_PRODUCT_NO_PK primary key (productNo),
    constraint PRODUCT_TYPE_PRODUCT_TYPE_NO_FK foreign key (productTypeNo) references ProductType (productTypeNo),
    constraint ADMIN_ADMIN_NO_FK foreign key (adminNo) references Admin (adminNo)
);
-- 插入商品值 --
-- insert into Product(productNo, productTypeNo, productName, stock, price, productDescription, productStatus) values(1, 1, '磁磚', 10, 50, 'MatDesign磁磚', '已上架');
-- insert into Product(productNo, productTypeNo, productName, stock, price, productDescription, productStatus) values(2, 1, '塗料', 10, 500, 'MatDesign塗料', '已上架');
-- insert into Product(productNo, productTypeNo, productName, stock, price, productDescription, productStatus) values(3, 2, '壁紙', 10, 100, 'MatDesign壁紙', '已上架');  

-- 創建商品圖片 --      
create table ProductPic(
	productPicNo int auto_increment not null comment '流水編號',
    productNo int not null comment '商品編號',
    pic longblob comment '圖片檔案',
    constraint PRODUCT_PIC_PRODUCT_PIC_NO_PK primary key (productPicNo),
    constraint PRODUCT_PRODUCT_NO_FK foreign key (productNo) references Product (productNo)
);

-- 創建購物車 --
create table Cart(
	cartNo int auto_increment not null comment '購物車編號',
    memberNO int not null comment '會員編號',
    productNo 	int not null comment '商品編號',
    qty int not null comment '各商品數量',
    constraint CART_CART_NO_PK primary key (cartNo),
    constraint MEMBER_MEMBER_NO_FK foreign key (memberNo) references Member (memberNo), 
    constraint PRODUCT_PRODUCT_NO_CART_FK foreign key (productNo) references Product (productNo)
);

-- (12.01 Queena)商城 修改商品訂單表格中「付款日期」與「運送日期」欄位--
-- 創建商品訂單 --
create table ProductOrder(
    orderNo int auto_increment not null comment '商品訂單編號',
    memberNo int not null comment '會員編號',
    receiverName varchar(50) not null comment '收件人姓名',
    receiverPhone varchar(50) not null comment '收件人電話',
    receiverAddress varchar(50) not null comment '收件人地址',
    totalQTY int not null comment '商品總數量',
    totalAmount int not null comment '商品總額',
    invoiceNo varchar(50) not null comment '訂單發票號碼',
    BusinessNumber varchar(50) comment '統一編號',
    paidDate timestamp not null comment '付款日期',
    shipDate timestamp comment '運送日期',
    orderStatus varchar(50) not null comment '訂單狀態',
    constraint PRODUCT_ORDER_ORDER_NO_PK primary key (orderNo),
    constraint ProductOrder_MEMBER_MEMBER_NO_FK foreign key (memberNo) references Member (memberNo)
);
insert into ProductOrder(memberNo, receiverName, receiverPhone, receiverAddress, totalQTY, totalAmount, invoiceNo, businessNumber, paidDate, shipDate, orderStatus) 
	 values(1, "David", "0912345888", "新北市土城區學享街20號", 20, 600, "Vj071934", null, now(), null, "已成立");

-- 創建商品訂單明細 --
create table ProductOrderDetail(
	orderDetailNo int auto_increment not null comment '明細流水編號',
    orderNo int not null comment '商品訂單編號',
    productNo int not null comment '商品編號',
    qty int not null comment '各商品數量',
    constraint PRODUCT_ORDER_DETAIL_ORDER_DETAIL_NO_PK primary key (orderDetailNo),
    constraint PRODUCT_ORDER_ORDER_NO_FK foreign key (orderNo) references ProductOrder (orderNo),
    constraint PRODUCT_PRODUCT_NO_DETAIL_FK foreign key (productNo) references Product (productNo)
);


-- 我的最愛論壇
CREATE TABLE FavoriteForum (
 favoritePostNo int NOT NULL AUTO_INCREMENT COMMENT '收藏文章流水號',
 memberNo int COMMENT '會員編號',
 postNo int COMMENT '文章編號',
 replyNo int COMMENT '回應',
 addTime timestamp NOT NULL COMMENT '收藏時間',
 CONSTRAINT FavoriteForum_favoritePostNo_PK PRIMARY KEY (favoritePostNo),
 CONSTRAINT FavoriteForum_memberNo_FK FOREIGN KEY (memberNo) references Member (memberNo),
 CONSTRAINT FavoriteForum_postNo_FK FOREIGN KEY (postNo) references ForumPost (postNo),
 CONSTRAINT FavoriteForum_replyNo_FK FOREIGN KEY (replyNo) references ForumReply (replyNo)
 );


 
 -- 參考資料
--  insert into FavoriteForum (memberNo,postNo,replyNo,addTime) values (3,4,5,20130930);
--  insert into FavoriteForum (memberNo,postNo,replyNo,addTime) values (6,5,4,20150908);
--  insert into FavoriteForum (memberNo,postNo,replyNo,addTime) values (7,8,9,20120701);
 
-- 我的最愛作品
CREATE TABLE FavoritePortfolio (
 favoritePortfolioNo int NOT NULL AUTO_INCREMENT COMMENT '我的最愛流水號',
 memberNo int NOT NULL COMMENT '會員編號',
 portfolioNo int NOT NULL COMMENT '作品編號',
 CONSTRAINT FavoritePortfolio_favoritePortfolioNo_PK PRIMARY KEY (favoritePortfolioNo),
 CONSTRAINT FavoritePortfolio_memberNo_FK FOREIGN KEY (memberNo) references Member (memberNo),
 CONSTRAINT FavoritePortfolio_portfolioNo_FK FOREIGN KEY (portfolioNo) references Portfolio (portfolioNo)
  );
-- 參考資料
-- insert into FavoritePortfolio(memberNo,portfolioNo) values (3,3);
-- insert into FavoritePortfolio(memberNo,portfolioNo) values (4,4);

  
-- 我的最愛商品
CREATE TABLE FavoriteProduct (
 favoriteProductNo int NOT NULL AUTO_INCREMENT COMMENT '我的最愛流水號',
 memberNo int NOT NULL COMMENT '會員編號',
 productNo int COMMENT '商品編號',
 CONSTRAINT FavoriteProduct_FavoriteProductNo_PK PRIMARY KEY (FavoriteProductNo),
 CONSTRAINT FavoriteProduct_MemberNo_FK FOREIGN KEY (MemberNo) references Member (MemberNo),
 CONSTRAINT FavoriteProduct_productNo_FK FOREIGN KEY (ProductNo) references Product (ProductNo)
);
-- 參考資料
-- insert into FavoriteProduct(memberNo,productNo) values (1,1);
-- insert into FavoriteProduct(memberNo,productNo) values (2,2);



CREATE TABLE Expertise(
expertiseNo INT NOT NULL PRIMARY KEY  AUTO_INCREMENT COMMENT '專長編號',
expertiseName VARCHAR(25) NOT NULL COMMENT '專長名稱'
);

-- INSERT INTO Expertise(expertiseName)VALUES('節能綠建築設計');
-- INSERT INTO Expertise(expertiseName)VALUES('小資坪數改造');

CREATE TABLE DesignerExpertise(
designerExpertiseNo INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '設計師專長編號',
designerNo INT  COMMENT '設計師編號',
expertiseNo INT  COMMENT '專長編號',
CONSTRAINT FK_DESIGNER_NO FOREIGN KEY (designerNo) REFERENCES Designer(designerNo) ON DELETE SET NULL ON UPDATE CASCADE,
CONSTRAINT FK_EXPERTISE_NO FOREIGN KEY (expertiseNo) REFERENCES Expertise(expertiseNo) ON DELETE SET NULL ON UPDATE CASCADE
);

-- INSERT INTO DesignerExpertise(designerNo,expertiseNo) VALUES(1,2); 
-- INSERT INTO DesignerExpertise(designerNo,expertiseNo) VALUES(2,1); 


CREATE TABLE DesignerOrder(
orderNo INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '案件編號',
designerNo INT COMMENT '設計師編號',
memberNo INT COMMENT '會員編號',
inquiryBudget INT COMMENT '諮詢預算',
inquirySize INT COMMENT '諮詢坪數',
inquiryDetail TEXT COMMENT '諮詢構想描述',
quotationDetail TEXT COMMENT '報價單內容',
quotationAmount INT COMMENT '報價單總金額',
quotationSendTime TIMESTAMP COMMENT '報價單送出時間',
quotationApprovalTime TIMESTAMP COMMENT '報價單成立時間', 
quotationAtt LONGBLOB COMMENT '報價單附檔',
quotationStatus VARCHAR(25) COMMENT '報價單狀態',
contractDetail TEXT COMMENT '合約訂單內容',
contractAtt LONGBLOB COMMENT '合約訂單附檔',
contractStatus VARCHAR(25) COMMENT '合約狀態',
contractApprovalTime TIMESTAMP COMMENT '合約訂單成立時間',
contractModificationTime TIMESTAMP COMMENT '合約訂單最後修改時間',
quotationNote TEXT COMMENT '報價備註',
contractNote TEXT COMMENT '合約訂單備註',
finishStatus BOOLEAN COMMENT '是否結案',
reviewStars INT COMMENT '評價星數',
reviewDetail TEXT COMMENT '評價內容',
reviewTime TIMESTAMP COMMENT '評價時間',
CONSTRAINT FK_DESIGNER_ORDER_NO FOREIGN KEY (designerNo) REFERENCES Designer(designerNo) ON DELETE SET NULL ON UPDATE CASCADE,
CONSTRAINT FK_MEMBER_NO FOREIGN KEY (memberNo) REFERENCES Member(memberNo) ON DELETE SET NULL ON UPDATE CASCADE
);

-- 假資料
-- INSERT INTO DesignerOrder(designerNo,memberNo,inquiryBudget,inquirySize,inquiryDetail,quotationDetail,quotationAmount,quotationSendTime,quotationApprovalTime,
-- quotationAtt,quotationStatus,contractDetail,contractAtt,contractStatus,contractApprovalTime,contractModificationTime,
-- quotationNote,contractNote,finishStatus,reviewStars,reviewDetail,reviewTime)
--     VALUES(
--     1,2,1200000,38,'將房間改建成工業溫馨風','收到，我們再找一天來處理',
--     1150000,now(),NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'工業溫馨，預定20230506前往客戶觀看實際狀況',NULL,NULL,NULL,NULL,NULL
--     );
--     
--  INSERT INTO DesignerOrder(designerNo,memberNo,inquiryBudget,inquirySize,inquiryDetail,quotationDetail,quotationAmount,quotationSendTime,quotationApprovalTime,
-- quotationAtt,quotationStatus,contractDetail,contractAtt,contractStatus,contractApprovalTime,contractModificationTime,
-- quotationNote,contractNote,finishStatus,reviewStars,reviewDetail,reviewTime)
--     VALUES(
--     2,1,367000,18,'居家改造','能讓我看一下環境格局嗎?',
--     400000,now(),20221225,NULL,'同意報價','坪數:18坪,付款金額:400000,分期付款期數:6期,合約內容:雙方同意報價，將於20230303動工......XXXXX',NULL,'同意合約',20221231,20221210,'小資客戶',
--     '坪數:18坪,付款金額:400000,分期付款期數:6期',1,5,'設計師設計風格創新,非常照顧客戶,會再推薦有需求的親好友找Heat設計師',20230630
--     );
--     
--      INSERT INTO DesignerOrder(designerNo,memberNo,inquiryBudget,inquirySize,inquiryDetail,quotationDetail,quotationAmount,quotationSendTime,quotationApprovalTime,
-- quotationAtt,quotationStatus,contractDetail,contractAtt,contractStatus,contractApprovalTime,contractModificationTime,
-- quotationNote,contractNote,finishStatus,reviewStars,reviewDetail,reviewTime)
--     VALUES(
--     2,3,2367000,69,'居家改造','能讓我看一下環境格局嗎?',
--     2500000,now(),20230123,NULL,'同意報價','坪數:69坪,付款金額:2450000,分期付款期數:8期,合約內容:雙方同意報價，將於20230401動工......XXXXX',NULL,'同意合約',20230226,20230224,'大客戶',
--     '坪數:69坪,付款金額:2450000,分期付款期數:8期',0,NULL,NULL,NULL
--     );
    
  

CREATE TABLE DesignerOrderPhase(
phaseNo INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '期數流水編號',
orderNo INT  COMMENT '報價單合約訂單表單流水號',
orderPhase INT NOT NULL COMMENT '訂單期數',
amount INT NOT NULL COMMENT '各期金額',
constructionStatus VARCHAR(25) COMMENT '施工狀態',
paymentPhase INT COMMENT'收款期數',
paymentStatus VARCHAR(25) COMMENT '收款狀態',
paymentAtt LONGBLOB COMMENT '付款證明附檔',
modificationTime TIMESTAMP COMMENT '修改時間',
CONSTRAINT FK_ORDER_NO FOREIGN KEY (orderNo) REFERENCES DesignerOrder(orderNo) ON DELETE SET NULL ON UPDATE CASCADE
);



-- INSERT INTO DesignerOrderPhase(orderNo,orderPhase,amount,constructionStatus,paymentPhase,paymentStatus,paymentAtt,modificationTime
--     )VALUES(2,6,65000,'第一期施工完成',6,'已付款',NULL,20230203);
--     
--     INSERT INTO DesignerOrderPhase(orderNo,orderPhase,amount,constructionStatus,paymentPhase,paymentStatus,paymentAtt,modificationTime
--     )VALUES(3,8,320000,'第四期施工完成',4,'未付款',NULL,20230713);
    
    -- ------ARTICLE_MAIN_TOPIC(報導文章_文章主類別)------
create table ArticleMainTopic(
	mainTopicNo		int auto_increment not null comment'報導文章主類別編號',
	mainTopicName	varchar(50) not null comment'報導文章主類別名稱',
    uploadTime		timestamp comment'上傳時間',
    adminNo			int comment'管理員編號',
    constraint ArticleMainTopic_mainTopicNo_PK primary key (mainTopicNo),
    constraint ArticleMainTopic_adminNo_FK foreign key (adminNo) references Admin (adminNo)
);

-- ------ARTICLE_SUB_TOPIC(報導文章_文章副類別)------
create table ArticleSubTopic(
	subTopicNo		int auto_increment not null comment'報導文章副類別編號',
    subTopicName	varchar(50) not null comment'報導文章副類別名稱',
    mainTopicNo		int comment'報導文章主類別編號',
    uploadTime		timestamp comment'上傳時間',
    adminNo			int comment'管理員編號',
    constraint	ArticleSubTopic_aubTopicNo_PK primary key (subTopicNo),
    constraint	ArticleSubTopic_mainTopicNo_FK foreign key (mainTopicNo) references ArticleMainTopic (mainTopicNo),
    constraint	ArticleSubTopic_adminNo_FK foreign key (adminNo) references Admin (adminNo)
);

-- ------ARTICLE(報導文章)------
create table Article(
	articleNo		int auto_increment not null comment'報導文章編號',
    title			varchar(100) not null comment'報導文章標題',
    mainTopicNo		int comment'報導文章主類別編號',
    subTopicNo		int comment'報導文章副類別編號',
    content			text comment'報導文章內容',
    uploadTime		timestamp comment'上傳時間',
    adminNo			int comment'管理員編號',
    constraint  Article_articleNo_PK primary key (articleNo),
    constraint	Article_mainTopicNo_FK foreign key (mainTopicNo) references ArticleMainTopic (mainTopicNo),
    constraint	Article_subTopicNo_FK foreign key (subTopicNo) references ArticleSubTopic (subTopicNo)
);

-- ------ARTICLE_PIC(報導文章_圖片)------
create table ArticlePic(
	picNo			int auto_increment not null comment'圖片編號',
    articleNo		int comment'報導文章編號',
    pic				blob comment'圖片檔案',
    uploadTime		timestamp comment'上傳時間',
    adminNo			int comment'管理員編號',
    constraint		ArticlePic_picNo primary key (picNo),
    constraint		ArticlePic_adminNo_FK foreign key (adminNo) references admin (adminNo)
);
