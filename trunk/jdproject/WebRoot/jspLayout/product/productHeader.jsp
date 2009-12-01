<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="headerMainView">
<h:form id="headerMainform"> 
	<a4j:region id="kitchenApplianceHeaderRegion" renderRegionOnly="false" selfRendered="true">
		<table height="131" cellSpacing="0" cellPadding="0" width="100%" background="${facesContext.externalContext.requestContextPath}/css/images/icons/top_bg.jpg" border="0">
		<tbody>
		  <tr>
		    <td vAlign="top" align="left">
		      <table class="logo" height="59" cellSpacing="0" cellPadding="0" width="100%" 
		      align="center" border="0">
		        <tbody>
		        <tr>
		          <td vAlign="bottom" align="left">
		            <table height="30" cellSpacing="0" cellPadding="0" width="1000" border="0">
		              <tbody>
		              <tr>
		                <td class="font1" align="right" width="423"></td>
		                <td class="font1" align="left" width="280"><span class="font2_1" 
		                  id="loginDiv"></span>
		                </td>
		                <td class="font1" align="right" width="271"><a class="font1" 
		                  href="http://www.xinhuabookstore.com/customer/">我的帐户</a> - <a 
		                  class="font1" 
		                  href="http://www.xinhuabookstore.com/customer/register/register.jsp">新用户注册</a> 
		                  - <a class="font1" 
		                  href="http://www.xinhuabookstore.com/help/">新手上路</a> - <a 
		                  class="font1" 
		                  href="http://www.xinhuabookstore.com/help/shoppingdemo/">购物演示</a></td>
		                <td width="26"></td></tr></tbody></table>
		            <table height="26" cellSpacing="0" cellPadding="0" width="1000" border="0">
		              <tbody>
		              <tr>
		                <td width="400"></td>
		                <td vAlign="bottom" width="21"><img height="26" 
		                  src="${facesContext.externalContext.requestContextPath}/css/images/icons/top_01.gif" width="21"/></td>
		                <td vAlign="bottom" background="${facesContext.externalContext.requestContextPath}/css/images/icons/top_bg3.jpg">
		                  <table height="26" cellSpacing="0" cellPadding="0" width="95%" 
		                  align="center" border="0">
		                    <tbody>
		                    <tr>
		                      <td id="tbottom1" onmouseover="changeTopCss(this)" 
		                      vAlign="bottom" align="middle"><a class="font_top" 
		                        href="http://www.xinhuabookstore.com/"><strong>首　　页</strong></a></td>
		                      <td class="top_line" vAlign="bottom" align="middle"></td>
		                      <td id="tbottom2" onmouseover="changeTopCss(this)" 
		                      vAlign="bottom" align="middle"><a class="font_top"
		                        href="http://www.xinhuabookstore.com/book/"><strong>图书频道</strong></a></td>
		                      <td class="top_line" vAlign="bottom" align="middle"></td>
		                      <td id="tbottom3" onmouseover="changeTopCss(this)" 
		                      vAlign="bottom" align="middle"><a class="font_top" 
		                        href="http://www.xinhuabookstore.com/cd/"><strong>音像频道</strong></a></td>
		                      <td class="top_line" vAlign="bottom" align="middle"></td>
		                      <td id="tbottom4" onmouseover="changeTopCss(this)" 
		                      vAlign="bottom" align="middle"><a class="font_top" 
		                        href="http://www.xinhuabookstore.com/subject/"><strong>精彩专题</strong></a></td>
		                      <td class="top_line" vAlign="bottom" align="middle"></td>
		                      <td id="tbottom5" onmouseover="changeTopCss(this)" 
		                      vAlign="bottom" align="middle"><a class="font_top" 
		                        href="http://www.xinhuabookstore.com/category/"><strong>分类导购</strong></a></td>
		                      <td class="top_line" vAlign="bottom" align="middle"></td>
		                      <td id="tbottom6" onmouseover="changeTopCss(this)" 
		                      vAlign="bottom" align="middle"><a class="font_top" 
		                        href="http://www.xinhuabookstore.com/help/"><strong>帮助中心</strong></a></td></tr></tbody></table></td>
		                <td width="21"><img height="26" src="${facesContext.externalContext.requestContextPath}/css/images/icons/top_02.jpg" 
		                  width="21"/></td></tr></tbody></table></td></tr></tbody></table>
		      <table class="top_bg2" height="42" cellSpacing="0" cellPadding="0" width="980" 
		      align="center" border="0">
		        <tbody>
		        <tr>
		          <td width="74"><span class="fontb_1">商品搜索:</span></td> 
		          <td width="160"><h:inputText id="productSearchId" value=""></h:inputText>
		          </td>
		          <td width="100">
		          	<h:commandLink id="Image81111" onmouseover="MM_swapImage('Image81111','','./css/images/icons/top_bt1a.gif',1)" 
		            onmouseout="MM_swapImgRestore()" style="height:21; width:85;border:0;"><h:graphicImage url="./css/images/icons/top_bt1a.gif"/></h:commandLink>
		          
		          </td>
		          <td width="100"><a 
		            onmouseover="MM_swapImage('Image91112','','${facesContext.externalContext.requestContextPath}/css/images/icons/top_bt2a.gif',1)" 
		            onmouseout="MM_swapImgRestore()" 
		            href="http://www.xinhuabookstore.com/search/advanced_search.jsp"><img 
		            id="Image91112" height="21" src="${facesContext.externalContext.requestContextPath}/css/images/icons/top_bt2.gif" width="85" 
		            border="0" name="Image91112"/></a></td>
		          <td width="100">
		            <table height="18" cellSpacing="0" cellPadding="0" width="100" border="0">
		              <tbody>
		              <tr>
		                <td align="middle" width="130"><a 
		                  onmouseover="MM_swapImage('Image43','','${facesContext.externalContext.requestContextPath}/css/images/icons/bt_gouwua.gif',0)" 
		                  onmouseout="MM_swapImgRestore()" 
		                  href="javascript:view_cart()"><img id="Image43" height="35" 
		                  src="${facesContext.externalContext.requestContextPath}/css/images/icons/bt_gouwu.gif" width="100" border="0" 
		                  name="Image43"/></a></td></tr></tbody></table></td>
		          <td width="210">
		            <table height="18" cellSpacing="0" cellPadding="0" width="210" border="0">
		              <tbody>
		              <tr>
		                <td align="middle" width="226"><img height="21" 
		                  src="${facesContext.externalContext.requestContextPath}/css/images/icons/bt_tel.gif" 
		            width="202"/></td></tr></tbody></table></td></tr></tbody></table>
		      <table height="28" cellSpacing="0" cellPadding="0" width="980" align="center" 
		      border="0">
		        <tbody>
		        <tr>
		          <td>热门搜索： <font face="Verdana"><a class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E5%A5%A5%E5%B7%B4%E9%A9%AC">奥巴马</a> 
		            <A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E5%85%AC%E5%8A%A1%E5%91%98%E5%BD%95%E7%94%A8%E8%80%83%E8%AF%95&amp;category=1&amp;usersort=6&amp;column=&amp;categorycode=&amp;name=&amp;barcode=&amp;author=&amp;manufacturer=&amp;mindiscount=&amp;maxdiscount=&amp;minprice=&amp;maxprice=&amp;enabledate=&amp;expiredate=">公务员考试</A> 
		            <A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E6%98%8E%E6%9C%9D%E9%82%A3%E4%BA%9B%E4%BA%8B%E5%84%BF+">明朝那些事儿</A><A 
		            class="font1" 
		            href="http://www.xinhuabookstore.com/product/1248862/">冷箭</A> <A 
		            class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E5%AF%8C%E7%88%B8%E7%88%B8">富爸爸</A> 
		            <A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E9%BB%84%E5%B8%9D%E5%86%85%E7%BB%8F">黄帝内经</A><A 
		            class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E6%B2%89%E6%80%9D%E5%BD%95">沉思录</A><A 
		            class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E4%B8%AD%E9%87%8C%E5%B7%B4%E4%BA%BA">中里巴人</A> 
		            <A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E8%97%8F%E5%9C%B0%E5%AF%86%E7%A0%81">藏地密码</A> 
		            <A class="font1" 
		            href="http://www.xinhuabookstore.com/product/1182946/">家庭医学全书</A><font 
		            face="宋体"><A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E5%85%94%E6%96%AF%E5%9F%BA&amp;Submit.x=27&amp;Submit.y=11">兔斯基</A></font><font 
		            face="Verdana"> </font><A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E4%B8%8D%E7%94%9F%E7%97%85%E7%9A%84%E6%99%BA%E6%85%A7">不生病的智慧</A> 
		            <A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E6%91%A9%E5%B0%94%E5%BA%84%E5%9B%AD">摩尔庄园</A> 
		            <A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E7%AC%AC%E4%B9%9D%E5%B1%8A%E6%A1%83%E6%9D%8E%E6%9D%AF">桃李杯</A><A 
		            class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E6%96%B0%E6%A6%82%E5%BF%B5%E8%8B%B1%E8%AF%AD">新概念英语</A> 
		            <font face="Verdana"><A class="font1" 
		            href="http://www.xinhuabookstore.com/search/?keyword=%E6%B0%B4%E7%9F%A5%E9%81%93%E7%AD%94%E6%A1%88">水知道答案</A></font></font> 
		          </td></tr></tbody></table></td></tr></tbody></table>
	</a4j:region>
						
					
</h:form>
</f:subview>		
</jsp:root>	