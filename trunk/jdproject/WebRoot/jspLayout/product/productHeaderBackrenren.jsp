<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="headerBackView">
<h:form id="mainheaderform">
<a4j:region id="mainheaderFormRegion" renderRegionOnly="false" selfRendered="true">
				<rich:panel headerClass="panel-header-none-border" bodyClass="panel-documents-none-border">
					<h:panelGrid id="headeronenav" columns="10" columnClasses="panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column,panel-header-none-border-pg-column">
							<h:outputLink value="www.sohu.com"><h:outputLabel value="eee"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="fff"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="ggg"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="hhh"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="购物车"/></h:outputLink>
							<h:outputLink value="${facesContext.externalContext.requestContextPath}/jspLayout/help/mainHelp.jsf" target="_blank"><h:outputLabel value="帮助中心"/><a4j:support event="onclick" immediate="true"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="登陆"/></h:outputLink>
							<h:outputLink value="www.sohu.com"><h:outputLabel value="注册"/></h:outputLink>
					</h:panelGrid>
					
				</rich:panel>
</a4j:region>

<DIV class="menu-bar rr" id="navBar">
<DIV class="navigation-wrapper">
<DIV class="navigation clearfix">
<DIV id="logo">
<H1><h:commandLink><h:graphicImage url="/css/images/logo.png" style="width:122;height:35;border: 0px solid #ffffff;"></h:graphicImage></h:commandLink></H1></DIV>
<DIV class="nav-body clearfix">
<DIV class="nav-main">
<DIV class="menu">
<DIV class="menu-title"><A 
href="${facesContext.externalContext.requestContextPath}"><SPAN>首页</SPAN></A></DIV></DIV>
<DIV class="menu" style="MARGIN: 0px">
<DIV class="menu-title #{headerTabPanel.currentPrimaryCategory == '01'?'select':''}"><A 
href="${facesContext.externalContext.requestContextPath}/jspLayout/product/KitchenAppliance/kitchenAppliance.jsf"><SPAN><h:outputText value="#{headerTabPanel.kitchenAppliance.mainMenu.label}"/></SPAN></A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title #{headerTabPanel.currentPrimaryCategory == '02'?'select':''}"><A 
href="http://friend.renren.com/myfriendlistx.do"><SPAN><h:outputText value="#{headerTabPanel.householdAppliance.mainMenu.label}"/></SPAN></A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title #{headerTabPanel.currentPrimaryCategory == '03'?'select':''}"><A 
href="http://app.renren.com/app/apps/list?origin=119"><SPAN><h:outputText value="#{headerTabPanel.personalCare.mainMenu.label}"/></SPAN></A> </DIV></DIV>
<DIV class="menu">
<DIV class="menu-title #{headerTabPanel.currentPrimaryCategory == '04'?'select':''}"><A href="http://game.renren.com/"><SPAN><h:outputText value="#{headerTabPanel.healthDevice.mainMenu.label}"/></SPAN></A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title #{headerTabPanel.currentPrimaryCategory == '05'?'select':''}"><A  
href="http://msg.renren.com/"><SPAN><h:outputText value="#{headerTabPanel.majorAppliance.mainMenu.label}"/></SPAN></A> </DIV></DIV>
<DIV class="menu">
<DIV class="menu-title #{headerTabPanel.currentPrimaryCategory == '06'?'select':''}"><A
href="http://msg.renren.com/"><SPAN><h:outputText value="#{headerTabPanel.phoneDigital.mainMenu.label}"/></SPAN></A> </DIV></DIV>
<DIV class="menu">
<DIV class="menu-title #{headerTabPanel.currentPrimaryCategory == '07'?'select':''}"><A
href="http://msg.renren.com/"><SPAN><h:outputText value="#{headerTabPanel.computerNetwork.mainMenu.label}"/></SPAN></A> </DIV></DIV>
</DIV>
<DIV class="nav-other">
<DIV class="menu">
<DIV class="charge menu-title"><A 
href="http://pay.renren.com/">充值</A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title"><A 
href="http://invite.renren.com/Invite.do">邀请</A></DIV></DIV>
<DIV class="menu">
<DIV class="menu-title" id="optionMenuActive"><A onMouseOver="" 
href="http://renren.com/profile.do?id=739836807&amp;v=info&amp;act=edit">设置</A></DIV></DIV>
<DIV class="menu last">
<DIV class="menu-title"><A 
href="http://www.renren.com/Logout.do?get_check=1714286847">退出</A></DIV></DIV>
</DIV></DIV></DIV></DIV></DIV>
</h:form>
</f:subview>		
</jsp:root>	