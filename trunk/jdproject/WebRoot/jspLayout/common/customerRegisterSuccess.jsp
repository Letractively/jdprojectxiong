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
    <title>新用户注册成功</title>
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
					<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" style="padding-top:55px" bodyClass="panel-documents-none-border">
						<rich:panel headerClass="panel-header-none-border" style="padding-left:220px;padding-right:220px;" bodyClass="panel-documents-none-border">
							<h:panelGrid columns="4" headerClass="align-left" style="magging-right:20px;" rowClasses="common-panel-grid-row">
								<f:facet name="header"><h:panelGroup><h:outputText value="恭喜" styleClass="gray-text"/><h:outputText value="#{currentUser.userInfo.fullName}" styleClass="orange-text"></h:outputText><h:outputText value="！您已经注册成功，欢迎加入电器商城" styleClass="gray-text"></h:outputText><br/><br/><br/><br/><h:outputText value="请选择您要进行的操作!" styleClass="lh3 f14" style="font-weight:normal"></h:outputText></h:panelGroup></f:facet>
								<h:commandLink><h:graphicImage value="/css/images/icons/r_profile.gif"/></h:commandLink>
								<h:commandLink><h:graphicImage value="/css/images/icons/r_index.gif"/></h:commandLink>
								<h:commandLink><h:graphicImage value="/css/images/icons/r_shopcart.gif"/></h:commandLink>
								<h:commandLink><h:graphicImage value="/css/images/icons/r_aboutus.gif"/></h:commandLink>
							</h:panelGrid>
					</rich:panel>
					</rich:panel>
					
				</a4j:region>	
			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	