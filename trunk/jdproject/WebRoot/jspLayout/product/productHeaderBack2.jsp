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
<h:form id="headerMainform">
			<a4j:region id="kitchenApplianceProductLeftViewFormRegion" renderRegionOnly="false" selfRendered="true">
				<rich:panel headerClass="panel-header-none-border" bodyClass="panel-documents-none-border">
					<f:facet name="header">
						<h:panelGrid columns="3" columnClasses="panel-header-none-border-main-pg-column-one,panel-header-none-border-main-pg-column-two,panel-header-none-border-main-pg-column-three">
						<rich:panel style="align:right">
							<h:graphicImage url="/css/images/logo_v2k9feb.gif"></h:graphicImage>
						</rich:panel>
						<rich:panel>
							<rich:panel id="noUserLoginPg" styleClass="main_header_login_navigation" rendered="#{currentUser.userInfo == null || !currentUser.userLoginFlag}">
    						<h:panelGrid columns="5" style="vertial-align:bottom;text-align:left;">
    						<h:outputText id="loginUserLabel" value="用户名:" styleClass="user-name"/>
    						<h:inputText id="loginUserId" value="#{currentUser.loginInfo.userId}" styleClass="user-name" size="15"/>
    						<h:outputText id="loginUserPasswordLabel" value="密码:" styleClass="user-name"/>
    						<h:inputSecret id="loginUserPassword" value="#{currentUser.loginInfo.userPassword}" size="15" styleClass="user-name"/>
    						<h:commandButton id="loginInBtn" action="#{currentUser.loginInAction}" image="/css/images/login.gif"><a4j:support event="onclick" reRender="kitchenApplianceProductLeftViewFormRegion"/></h:commandButton>
    						</h:panelGrid>
    						</rich:panel>
    						<rich:panel id="hasUserLoginPg" styleClass="main_header_login_navigation" rendered="#{currentUser.userInfo != null || currentUser.userLoginFlag}">
    							<h:panelGrid columns="4" style="vertial-align:bottom;text-align:left;">
    							<h:outputText id="loginInUserLabelLeft" value="您好: "/><h:outputText id="loginUserIdText" value="#{currentUser.userInfo.fullName}"/><h:outputText id="loginInUserLabelRight" value="欢迎回来!"/>
    							<h:commandButton id="loginOutBtn" image="/css/images/login.gif" action="#{currentUser.loginOutAction}"><a4j:support event="onclick" reRender="noUserLoginRegion,hasUserLoginRegion"/></h:commandButton>
    							</h:panelGrid>
    						</rich:panel>
						</rich:panel>
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
						</h:panelGrid>
					</f:facet>
				</rich:panel>
				<rich:toolBar id="mainheaderpronavbar" style="width:970px;heigh:36px;" styleClass="rich-tool-bar-style" contentStyle="rich-tool-bar-content-style">
					<rich:toolBarGroup id="headerfirst" styleClass="rich-tool-bar-first">
						<h:outputLabel value="" style="width:20px"></h:outputLabel>
					</rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.kitchenAppliance.mainMenu.name}" styleClass="#{headerTabPanel.currentPrimaryCategory == '01'?'rich-tool-bar-select':''}">
		            	<h:commandLink id="kitchenAppliancebtn" action="#{headerTabPanel.gotoProduct}" styleClass="rich-tool-bar-content-style" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.kitchenAppliance.mainMenu.label}" for="kitchenAppliancebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.kitchenAppliance.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.kitchenAppliance.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.kitchenAppliance.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.householdAppliance.mainMenu.name}" styleClass="#{headerTabPanel.currentPrimaryCategory == '02'?'rich-tool-bar-select':''}">
		            	<h:commandLink id="householdAppliancebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.householdAppliance.mainMenu.label}" for="householdAppliancebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.householdAppliance.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.householdAppliance.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.householdAppliance.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.personalCare.mainMenu.name}" styleClass="#{headerTabPanel.currentPrimaryCategory == '03'?'rich-tool-bar-select':''}">
		            	<h:commandLink id="personalCarebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.personalCare.mainMenu.label}" for="personalCarebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.personalCare.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.personalCare.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.personalCare.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.healthDevice.mainMenu.name}" styleClass="#{headerTabPanel.currentPrimaryCategory == '04'?'rich-tool-bar-select':''}">
		            	<h:commandLink id="healthDevicebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.healthDevice.mainMenu.label}" for="healthDevicebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.healthDevice.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.healthDevice.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.healthDevice.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.majorAppliance.mainMenu.name}" styleClass="#{headerTabPanel.currentPrimaryCategory == '05'?'rich-tool-bar-select':''}">
		            	<h:commandLink id="majorAppliancebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.majorAppliance.mainMenu.label}" for="majorAppliancebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.majorAppliance.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.majorAppliance.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.majorAppliance.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.phoneDigital.mainMenu.name}" styleClass="#{headerTabPanel.currentPrimaryCategory == '06'?'rich-tool-bar-select':''}">
		            	<h:commandLink id="phoneDigitalbtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.phoneDigital.mainMenu.label}" for="phoneDigitalbtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.phoneDigital.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.phoneDigital.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.phoneDigital.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.computerNetwork.mainMenu.name}" styleClass="#{headerTabPanel.currentPrimaryCategory == '07'?'rich-tool-bar-select':''}">
		            	<h:commandLink id="computerNetworktn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.computerNetwork.mainMenu.label}" for="computerNetworktn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.computerNetwork.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.computerNetwork.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.computerNetwork.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		        </rich:toolBar>
			</a4j:region>
</h:form>
</f:subview>		
</jsp:root>	