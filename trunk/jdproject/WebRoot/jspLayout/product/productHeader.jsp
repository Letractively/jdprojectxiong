<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich"
xmlns:c="http://java.sun.com/jstl/core">
<f:subview id="headerMainView">
<h:form id="headerMainform"> 
	<a4j:region id="kitchenApplianceHeaderRegion" renderRegionOnly="false" selfRendered="true">
		<table height="131" cellSpacing="0" cellPadding="0" width="998" class="main_header" border="0">
		<tbody>
		  <tr>
		  <td width="2px" background="${facesContext.externalContext.requestContextPath}/css/images/icons/topleft_bg.jpg">
		  </td>
		  <td>
		  <table>
		  <tbody>
		  <tr>
		    <td vAlign="top" align="left" width="96%">
		      <table class="logo" height="59" cellSpacing="0" cellPadding="0" width="100%" border="0">
		        <tbody>
		        <tr>
		          <td width="20%"><h:graphicImage url="/css/images/company_logo.gif"></h:graphicImage></td>
		          <td vAlign="bottom" align="right" width="80%">
		            <table height="30" cellSpacing="0" cellPadding="0" align="center" width="100%" border="0">
		              <tbody>
		              <tr>
		                <td width="100%" align="right">
		                	<f:subview id="userLoginAndNavigationMainView">
								<ui:include src="./userLoginAndNavigation.jsp" />
							</f:subview>
						</td>
		              </tr>
		              </tbody>
		            </table>
		            <table height="26" cellSpacing="0" cellPadding="0" align="center" width="100%" border="0">
		              <tbody>
		              <tr align="right">
		              <td width="84%">
		              	<h:graphicImage url="/css/images/user_order.jpg" rendered="#{currentUser.userInfo != null || currentUser.userLoginFlag}"></h:graphicImage>
		              	<h:graphicImage url="/css/images/user_help.jpg"></h:graphicImage>
		              	<h:graphicImage url="/css/images/user_shopcart.jpg"></h:graphicImage>
		              	<h:graphicImage url="/css/images/user_home.jpg"></h:graphicImage>
		              	
		              </td>
		               <td width="16%">
		               <rich:dropDownMenu value="所有分类 " submitMode="server" direction="bottom-left"  jointPoint="td" event="onmouseover" showDelay="10">
                			<rich:menuGroup value="#{headerTabPanel.kitchenAppliance.mainMenu.label}" direction="bottom-left">
                    			
                    			<c:forEach items="#{headerTabPanel.kitchenAppliance.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="server">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="kitchenApplianceMainMenuName" value="#{headerTabPanel.kitchenAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.householdAppliance.mainMenu.label}" direction="bottom-left">
                    			
                    			<c:forEach items="#{headerTabPanel.householdAppliance.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="server">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="householdApplianceMainMenuName" value="#{headerTabPanel.householdAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
               				<rich:menuGroup value="#{headerTabPanel.personalCare.mainMenu.label}" direction="bottom-left">
                    			
                    			<c:forEach items="#{headerTabPanel.personalCare.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="server">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="personalCareMainMenuName" value="#{headerTabPanel.personalCare.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.healthDevice.mainMenu.label}" direction="bottom-left">
                    			
                    			<c:forEach items="#{headerTabPanel.healthDevice.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="server">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="healthDeviceMainMenuName" value="#{headerTabPanel.healthDevice.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.majorAppliance.mainMenu.label}" direction="bottom-left">
                    			
                    			<c:forEach items="#{headerTabPanel.majorAppliance.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="server">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="majorApplianceMainMenuName" value="#{headerTabPanel.majorAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.phoneDigital.mainMenu.label}" direction="bottom-left">
                    			
                    			<c:forEach items="#{headerTabPanel.phoneDigital.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="server">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="phoneDigitalMainMenuName" value="#{headerTabPanel.phoneDigital.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                			<rich:menuGroup value="#{headerTabPanel.computerNetwork.mainMenu.label}" direction="bottom-left">
                    			
                    			<c:forEach items="#{headerTabPanel.computerNetwork.subMenu}" var="subMenu">
									<rich:menuItem action="#{headerTabPanel.gotoProduct}" value="#{subMenu.label}" submitMode="server">
										<f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="computerNetworkMainMenuName" value="#{headerTabPanel.computerNetwork.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam>
									</rich:menuItem>
								</c:forEach>
                			</rich:menuGroup>
                		</rich:dropDownMenu>
						</td>
		                </tr>
		                </tbody>
		               </table>
		             </td>
		           </tr>
		           </tbody>
		      </table>
		      <table class="top_bg2" height="42" cellSpacing="0" cellPadding="0" width="100%" align="center" border="0">
		        <tbody>
		        <tr>
		          <td width="280" align="right"><span class="fontb_1">商品搜索:</span></td> 
		          <td width="160"><h:inputText id="productSearchId" value=""></h:inputText>
		          </td>
		          <td width="100">
		          	<h:commandLink id="Image81111" onmouseover="MM_swapImage('Image81111','','./css/images/icons/top_bt1a.gif',1)" 
		            onmouseout="MM_swapImgRestore()" style="height:21; width:85;border:0;"></h:commandLink>
		          
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
		                <td align="middle" width="130">
		                </td></tr></tbody></table></td>
		          <td width="210">
		            <table height="18" cellSpacing="0" cellPadding="0" width="210" border="0">
		              <tbody>
		              <tr>
		                <td align="middle" width="226"></td></tr></tbody></table></td></tr></tbody></table>
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
		          </td></tr></tbody></table></td></tr></tbody></table></td><td width="2px" background="${facesContext.externalContext.requestContextPath}/css/images/icons/topright_bg.jpg"></td></tr></tbody></table>
	</a4j:region>
						
					
</h:form>
</f:subview>		
</jsp:root>	