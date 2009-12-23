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
	<table width="100%" cellpadding="0" cellspacing="0" style="padding-bottom: 0px;">
    	<tbody>
    		<tr>
    		<td align="right">
    		<a4j:region id="noUserLoginRegion" renderRegionOnly="true" rendered="#{currentUser.userInfo == null || !currentUser.userLoginFlag}" selfRendered="true">
    			<rich:panel id="noUserLoginPg" styleClass="main_header_login_navigation">
    				<h:panelGrid columns="4" style="vertial-align:middle;text-align:center;">
    				<h:panelGroup style="text-valign:middle"><h:outputText id="loginUserLabel" value="用户名:" styleClass="user-name"/><h:inputText id="loginUserId" value="#{currentUser.loginInfo.userId}" styleClass="user-name" size="15"/></h:panelGroup>
    				<h:panelGroup><h:outputText id="loginUserPasswordLabel" value="密码:" styleClass="user-name"/><h:inputSecret id="loginUserPassword" value="#{currentUser.loginInfo.userPassword}" size="12" styleClass="user-name"/></h:panelGroup>
    				<h:commandButton id="loginInBtn" action="#{currentUser.loginInAction}" image="/css/images/login.gif"><a4j:support event="onclick" reRender="noUserLoginRegion,hasUserLoginRegion"/></h:commandButton>
    				<rich:panel id="noUserLoginPgOthersPgPanel" styleClass="main_header_login_navigation_others">
    						<h:outputLink id="newUserRegistryLink" value="http://www.sohu.com"><h:outputText id="newUserRegistryLinkText" value="新用户注册"/></h:outputLink>
    						<h:outputText id="specchar1" value="-"></h:outputText>
    						<h:outputLink id="forgotPasswordLink" value="http://www.sohu.com"><h:outputText id="forgotPasswordLinkText" value="忘记密码"/></h:outputLink>
    				</rich:panel>
    				</h:panelGrid>
    			</rich:panel>
    		</a4j:region>
    		<a4j:region id="hasUserLoginRegion" renderRegionOnly="true" rendered="#{currentUser.userInfo != null || currentUser.userLoginFlag}" selfRendered="true">
    			<rich:panel id="hasUserLoginPg" styleClass="main_header_login_navigation">
    				<h:panelGrid columns="4" style="vertial-align:middle;text-align:center;">
    					<h:panelGroup><h:outputText id="loginInUserLabelLeft" value="您好: "/><h:outputText id="loginUserIdText" value="#{currentUser.userInfo.fullName}"/><h:outputText id="loginInUserLabelRight" value="欢迎回来!"/></h:panelGroup>
    					<h:commandButton id="loginOutBtn" image="/css/images/login.gif" action="#{currentUser.loginOutAction}"><a4j:support event="onclick" reRender="noUserLoginRegion,hasUserLoginRegion"/></h:commandButton>
    					<rich:panel id="UserLoginPgOthersPgPanel" styleClass="main_header_login_navigation_others">
    						<h:outputLink id="newUserRegistryLinkUserLoginIn" value="http://www.sohu.com"><h:outputText id="newUserRegistryLinkTextUserLoginIn" value="新用户注册"/></h:outputLink>
    						<h:outputText id="specchar1UserLoginIn" value="-"></h:outputText>
    						<h:outputLink id="forgotPasswordLinkUserLoginIn" value="http://www.sohu.com"><h:outputText id="forgotPasswordLinkTextUserLoginIn" value="忘记密码"/></h:outputLink>
    				</rich:panel>
    				</h:panelGrid>
    			</rich:panel>
    		</a4j:region>
    		</td>
    		</tr>
		</tbody>
	</table>
</h:form>
</f:subview>		
</jsp:root>	