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
    <title>新用户注册</title>
    </head>
    <body>
    	<ui:composition template="./commonTemplate.jsp">
    		
    		<ui:define id="commonStepDisplayOfShoppingCart" name="commonStepDisplay">
    			
			</ui:define>
    		<ui:define id="contentHeader" name="contentHeader">
    				<h:outputText value="欢迎您注册新会员！"></h:outputText>
			</ui:define>
			<ui:define id="customerRegisterContent" name="content">
			<h:form>
				<a4j:region id="customerRegisterRegion" renderRegionOnly="false" selfRendered="true">
					<h:panelGrid columns="2" style="width:100%" columnClasses="width-eighty,width-twenty" cellspacing="2" cellpadding="2">
						<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border-none-padding">
						<f:facet name="header">
							<h:panelGrid columns="3" style="align:left;"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
									<h:outputText value="" style="width:4px"></h:outputText>
									<h:panelGroup>
										<H3><h:outputText value="请填写以下信息" styleClass="panel-header-none-border-text"></h:outputText><h:outputText id="registErros" value="#{registPage.errorMessage}" style="color:red;padding-left:12px;font-weight:normal;"/></H3>
									</h:panelGroup>
									<h:outputText value="" style="width:4px"></h:outputText>
								</h:panelGrid>	
						</f:facet>
						<h:panelGrid columns="3" columnClasses="common-panel-grid-one,common-panel-grid-two,common-panel-grid-three" rowClasses="common-panel-grid-row">
							<h:outputLabel value="您的用户名：" for="userId"></h:outputLabel><h:inputText id="userId" value="#{registPage.userId}" styleClass="input-text"><f:validator validatorId="UserValidator"/></h:inputText><h:message for="userId" />
							<h:outputLabel value="请设置密码：" for="userPassword"></h:outputLabel><h:inputSecret id="userPassword" value="#{registPage.userPassword}" redisplay="true" styleClass="input-text"><f:validator validatorId="PasswordValidator"/></h:inputSecret><h:message for="userPassword" />
							<h:outputLabel value="请确认密码：" for="verifyPassword"></h:outputLabel><h:inputSecret id="verifyPassword" value="#{registPage.verifyPassword}" redisplay="false" styleClass="input-text"><f:validator validatorId="PasswordValidator"/></h:inputSecret><h:message for="verifyPassword" />
							<h:outputLabel value="E-mail地址：" for="email"></h:outputLabel><h:inputText id="email" value="#{registPage.email}" styleClass="input-text"><f:validator validatorId="EmailValidator"/></h:inputText><h:message for="email" />
						</h:panelGrid>
						<a4j:outputPanel>
							<h:panelGroup style="padding-left: 128px;vAlign: bottom;"><h:selectBooleanCheckbox value="#{registPage.agreementFlag}" immediate="true"></h:selectBooleanCheckbox><h:outputLabel value="我已阅读并同意该协议" style="padding-right:6px;"></h:outputLabel><h:commandButton value="填写完毕，注册" action="#{registPage.registerIn}" styleClass="ButtonDefault"></h:commandButton><h:commandButton type="reset" value="重置" styleClass="ButtonDefault"></h:commandButton></h:panelGroup>
						</a4j:outputPanel>
						<rich:panel style="padding-left:120px;padding-right:120px;">
						<iframe id="agreementFrame" style="magging-top:20px;BORDER-RIGHT: #999 1px solid; BORDER-TOP: #999 1px solid; FLOAT: none; BORDER-LEFT: #999 1px solid; width: 100%; BORDER-BOTTOM: #999 1px solid; HEIGHT: 430px" name="main2" src="./agreement_comment.htm" scrolling="yes">
	
						</iframe>
	           			</rich:panel>
						</rich:panel>
						
	           			
	           			<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border" style="float:top">
								<f:facet name="header">
									<h:panelGrid columns="1" style="align:left;" width="100%"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-rectangles">
									<h:panelGroup>
										<H3><h:outputText value="注册后，您可立即享受" styleClass="panel-header-none-border-text"></h:outputText><h:outputText value="" style="color:red;padding-left:12px;font-weight:normal;"/></H3>
									</h:panelGroup>
								</h:panelGrid>
								</f:facet>
								<h:panelGrid columns="1">
									<h:outputText value="111111"></h:outputText>
									<h:outputText value="22222"></h:outputText>
									<h:outputText value="33333"></h:outputText>
									<h:outputText value="44444"></h:outputText>
								</h:panelGrid>
						</rich:panel>
	           		</h:panelGrid>
				</a4j:region>	
			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	