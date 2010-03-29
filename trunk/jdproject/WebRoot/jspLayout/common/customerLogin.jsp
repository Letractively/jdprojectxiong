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
    				<h:outputText value="欢迎您登录! "></h:outputText>
			</ui:define>
			<ui:define id="customerLoginContent" name="content">
			<h:form>
				<a4j:region id="customerLoginRegion" renderRegionOnly="false" selfRendered="true">
					<h:panelGrid columns="2" style="width:100%" columnClasses="width-eighty,width-twenty" cellspacing="2" cellpadding="2">
						<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border-none-padding">
							<f:facet name="header">
								<h:panelGrid columns="3" style="align:left"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
									<h:outputText value="" style="width:4px"></h:outputText>
									<h:panelGroup>
										<H3><h:outputText value="用户登陆" styleClass="panel-header-none-border-text"></h:outputText><h:outputText id="registErros" value="#{currentUser.errorMessage}" style="color:red;padding-left:12px;font-weight:normal;"/></H3>
									</h:panelGroup>
									<h:outputText value="" style="width:4px"></h:outputText>
								</h:panelGrid>	
							</f:facet>
							<h:panelGrid columns="3" columnClasses="common-panel-grid-one,common-panel-grid-two,common-panel-grid-three" rowClasses="common-panel-grid-row">
								<h:outputLabel id="loginUserLabel" value="您的用户名：" for="userId"></h:outputLabel><h:inputText id="userId" value="#{currentUser.loginInfo.userId}" styleClass="input-text"><f:validator validatorId="UserValidator"/></h:inputText><h:message for="userId" />
								<h:outputLabel id="loginUserPasswordLabel" value="您的密码：" for="userPassword"></h:outputLabel><h:inputSecret id="userPassword" value="#{currentUser.loginInfo.userPassword}" redisplay="false" styleClass="input-text"><f:validator validatorId="PasswordValidator"/></h:inputSecret><h:message for="userPassword" />
								<h:outputLabel id="loginUserVerifyCodeLabel" value="验证码："></h:outputLabel><h:inputText id="verifyCode" value="#{currentUser.verifyCode}" styleClass="input-text"></h:inputText>
								<h:panelGroup>
                       				<rich:paint2D id="painter" width="98" height="28" data="#{generateVerifyCode}" format="png" paint="#{paintVerifyCode.paint}" />
                       				<h:commandLink id="getverifycode" value="换一张" actionListener="#{generateVerifyCode.loadVerifyCodeListener}" immediate="true"></h:commandLink>
                   				</h:panelGroup>
							</h:panelGrid>
							<a4j:outputPanel>
								<h:panelGroup style="padding-left: 276px;vAlign: bottom;"><h:commandLink id="loginInBtn" value="登陆" action="#{currentUser.loginInAction}" styleClass="ButtonDefault"><f:param name="comeFrom" value="#{currentUser.comeFrom}"></f:param></h:commandLink></h:panelGroup>
							</a4j:outputPanel>
						</rich:panel>
						
						<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border" style="float:top">
								<f:facet name="header">
									<h:panelGrid columns="1" style="align:left;" width="100%"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-rectangles">
									<h:panelGroup>
										<H3><h:outputText value="用户登陆" styleClass="panel-header-none-border-text"></h:outputText><h:outputText value="" style="color:red;padding-left:12px;font-weight:normal;"/></H3>
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