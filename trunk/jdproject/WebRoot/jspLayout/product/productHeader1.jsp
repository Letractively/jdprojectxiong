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
		<h:panelGrid columns="3" columnClasses="main-header-left,main-header-center,main-header-right" styleClass="main-header">
			<h:outputText value=""></h:outputText>
			<h:panelGroup>
				<h:panelGrid columns="3" columnClasses="sub-main-header-left,sub-main-header-center,sub-main-header-right">
					<h:graphicImage url="/css/images/company_logo.gif"></h:graphicImage>
					<h:outputText value=""></h:outputText>
					<h:panelGrid columns="1" style="align:left;">
						<h:panelGroup>
						<f:subview id="userLoginAndNavigationMainView">
								<ui:include src="./userLoginAndNavigation.jsp" />
						</f:subview>
						</h:panelGroup>
						<h:panelGroup>
							<h:graphicImage url="/css/images/user_order.jpg" rendered="#{currentUser.userInfo != null || currentUser.userLoginFlag}"></h:graphicImage>
		              		<h:graphicImage url="/css/images/user_help.jpg"></h:graphicImage>
		              		<h:graphicImage url="/css/images/user_shopcart.jpg"></h:graphicImage>
		              		<h:graphicImage url="/css/images/user_home.jpg"></h:graphicImage>
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
					</h:panelGroup>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGroup>
			<h:outputText value=""></h:outputText>
		</h:panelGrid>
	</a4j:region>
						
					
</h:form>
</f:subview>		
</jsp:root>	