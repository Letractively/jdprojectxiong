<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view>
<html>
	<head>
    <title>修改密码</title>
    </head>
    <body>
    	<ui:composition template="./customerTemplate.jsp">
    		<ui:define id="customerStepDisplay" name="stepDisplay">
				<h:form id="stepForm">
    			<a4j:outputPanel styleClass="step-display-output-panel">
    				<h:outputText value="当前位置"></h:outputText><h:commandLink action="index" styleClass="step-display-output-panel-link"><h:outputText value="首页"/></h:commandLink>
					<h:outputText value=">"></h:outputText>
					<h:commandLink action="mainCustomer" styleClass="step-display-output-panel-link"><h:outputText value="管理中心"/></h:commandLink>
					<h:outputText value="> 修改密码"></h:outputText>
    			</a4j:outputPanel>
				</h:form>
    		</ui:define>
    		<ui:define id="customerLeft" name="left">
    			<ui:include id="customerLeftInclude" src="./navigationCustomerLeft.jsp">
    			</ui:include>
    		</ui:define>
    		<ui:define id="contentHeader" name="contentHeader">
    			<h:outputText value=""></h:outputText>
			</ui:define>
			<ui:define id="customerContent" name="content">
				<h:form id="customerPasswordForm">
				<a4j:region id="mainPasswordRegion" renderRegionOnly="false" selfRendered="true">
					<rich:panel id="messageTitle" headerClass="messageTitle" style="width:100%">
						<f:facet name="header">
						<ul style="padding-left: 30px;">
              				<span class="STYLE1"></span>

              				<li class="button02" id="menu42">修改密码</li>
            			</ul>
        				</f:facet>
					</rich:panel>
					<rich:panel id="customerPasswordContentPanel" style="width:100%" headerClass="header-error-messages" bodyClass="panel-documents-none-border">
						<f:facet name="header"><h:outputText id="errortext" value="#{customerUpdatePasswordPage.errorMessages}" style="width:100%" styleClass="error-messages"/></f:facet>
						<h:panelGrid columns="3" columnClasses="update-password-common-panel-grid-one,update-password-common-panel-grid-two,update-password-common-panel-grid-three" rowClasses="common-panel-grid-row">
							<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="原密码："></h:outputLabel></h:panelGroup><h:inputSecret id="oldPassword" value="#{customerUpdatePasswordPage.oldUserPassword}" redisplay="true" maxlength="24"></h:inputSecret><h:panelGroup><h:outputLabel styleClass="orange-text" value="请输入原始密码"></h:outputLabel><h:message for="oldPassword"/></h:panelGroup>
							<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="新密码："></h:outputLabel></h:panelGroup><h:inputSecret id="newPassword" value="#{customerUpdatePasswordPage.newUserPassword}" redisplay="true" maxlength="24"></h:inputSecret><h:panelGroup><h:outputLabel styleClass="orange-text" value="请输入新密码"></h:outputLabel><h:message for="newPassword"/></h:panelGroup>
							<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="确认密码："></h:outputLabel></h:panelGroup><h:inputSecret id="verifyNewPassword" value="#{customerUpdatePasswordPage.verifyNewUserPassword}" redisplay="true" maxlength="24"></h:inputSecret><h:panelGroup><h:outputLabel styleClass="orange-text" value="请再次输入新密码"></h:outputLabel><h:message for="verifyNewPassword"/></h:panelGroup>
							<h:outputLabel value=""></h:outputLabel><h:panelGroup><a4j:commandLink id="updateBtn" action="#{customerUpdatePasswordPage.updatePassword}" value="确认修改" oncomplete="javascript:if ('#{customerUpdatePasswordPage.updated}'=='true') {alert('恭喜，'+'#{currentUser.userInfo.fullName}'+'密码修改成功！');}" styleClass="ButtonDefault" reRender="customerPasswordContentPanel,errortext"></a4j:commandLink><a4j:commandLink id="resetBtn" action="#{customerUpdatePasswordPage.resetPassword}" value="重置" styleClass="ButtonDefault" reRender="customerPasswordContentPanel"></a4j:commandLink></h:panelGroup><h:outputLabel value=""></h:outputLabel>
						</h:panelGrid>
					
					</rich:panel>
					
					
					
					
				</a4j:region>
				</h:form>
    		</ui:define>
    		<ui:define id="customerRight" name="right">
    			<h:outputText value=""></h:outputText>
    		</ui:define>
    	</ui:composition>
    	
    </body>
</html>	
</f:view>		
</jsp:root>	