<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="userLoginAndNavigationSubView">
<h:form id="userLoginAndNavigationSubForm">
	<table width="100%" height="38" cellpadding="4" cellspacing="0" style="padding-bottom: 15px;">
    	<tbody>
    		<a4j:region id="noUserLoginRegion" renderRegionOnly="true" rendered="#{currentUser.userInfo == null || !currentUser.userLoginFlag}" selfRendered="true">
    			<h:panelGrid id="noUserLoginPg" columns="4">
    				<h:outputText value="请登陆"></h:outputText>
    				<h:panelGroup><h:outputText value="用户名:"/><h:inputText id="loginUserId" value="#{currentUser.loginInfo.userId}"/></h:panelGroup>
    				<h:panelGroup><h:outputText value="密码:"/><h:inputSecret id="loginUserPassword" value="#{currentUser.loginInfo.userPassword}"/></h:panelGroup>
    				<h:commandButton id="loginInBtn" value="登陆" action="#{currentUser.loginInAction}"><a4j:support event="onclick" reRender="noUserLoginRegion,hasUserLoginRegion"/></h:commandButton>
    			</h:panelGrid>
    		</a4j:region>
    		<a4j:region id="hasUserLoginRegion" renderRegionOnly="true" rendered="#{currentUser.userInfo != null || currentUser.userLoginFlag}" selfRendered="true">
    			<h:panelGrid id="hasUserLoginPg" columns="4">
    				<h:outputText value="登陆信息"></h:outputText>
    				<h:panelGroup><h:outputText value="用户名:"/><h:outputText id="loginUserIdText" value="#{currentUser.userInfo.fullName}"/></h:panelGroup>
    				
    				<h:commandButton id="loginOutBtn" value="退出" action="#{currentUser.loginOutAction}"><a4j:support event="onclick" reRender="noUserLoginRegion,hasUserLoginRegion"/></h:commandButton>
    			</h:panelGrid>
    		</a4j:region>
		</tbody>
	</table>
</h:form>
</f:subview>		
</jsp:root>	