<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="kitchenApplianceProductLeftView">
	<h:form id="kitchenApplianceProductLeftViewForm">
		<a4j:region id="kitchenApplianceProductLeftViewFormRegion" renderRegionOnly="false" selfRendered="true">
		<rich:panel headerClass="left-navigation-product-header" styleClass="panel-bar-product-top" bodyClass="left-navigation-product-body">
			<f:facet name="header"><h:outputLabel value="商品分类"/></f:facet>
			<rich:panelBar id="kitchenApplianceLeftPb" binding="#{productPanelBar.panelBar}" selectedPanel="#{productPanelBar.currentBar}" width="140"  styleClass="panel-bar-product-left" contentStyle="BACKGROUND-COLOR: #FFFFFF">
    				<rich:panelBarItem id="#{headerTabPanel.kitchenAppliance.mainMenu.name}" name="#{headerTabPanel.kitchenAppliance.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				<f:facet name="label">
    					<a4j:commandLink id="kitchenApplianceMainLabel" styleClass="fontb_1" value="#{headerTabPanel.kitchenAppliance.mainMenu.label}"><a4j:actionparam name="kitchenApplianceMainMenuName" value="#{headerTabPanel.kitchenAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam></a4j:commandLink>
    				</f:facet>
    				<rich:dataGrid id="kitchenApplianceContentDg" columns="2" value="#{headerTabPanel.kitchenAppliance.subMenu}" var="kitchenApplianceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{kitchenApplianceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{kitchenApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{kitchenApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{kitchenApplianceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
					<rich:panelBarItem id="#{headerTabPanel.householdAppliance.mainMenu.name}" name="#{headerTabPanel.householdAppliance.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				
    				<f:facet name="label">
    					<a4j:commandLink id="householdApplianceMainLabel" styleClass="fontb_1" value="#{headerTabPanel.householdAppliance.mainMenu.label}"><a4j:actionparam name="householdApplianceMainMenuName" value="#{headerTabPanel.householdAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam></a4j:commandLink>
					</f:facet>
    				<rich:dataGrid columns="2" value="#{headerTabPanel.householdAppliance.subMenu}" var="householdApplianceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{householdApplianceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{householdApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{householdApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{householdApplianceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
					<rich:panelBarItem id="#{headerTabPanel.personalCare.mainMenu.name}" name="#{headerTabPanel.personalCare.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				<f:facet name="label">
    					<a4j:commandLink id="personalCareMainLabel" styleClass="fontb_1" value="#{headerTabPanel.personalCare.mainMenu.label}"><a4j:actionparam name="personalCareMainMenuName" value="#{headerTabPanel.personalCare.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam></a4j:commandLink>
    				</f:facet>
    				<rich:dataGrid columns="2" value="#{headerTabPanel.personalCare.subMenu}" var="personalCareSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{personalCareSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{personalCareSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{personalCareSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{personalCareSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
					<rich:panelBarItem id="#{headerTabPanel.healthDevice.mainMenu.name}" name="#{headerTabPanel.healthDevice.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				<f:facet name="label">
    					<a4j:commandLink id="healthDeviceMainLabel" styleClass="fontb_1" value="#{headerTabPanel.healthDevice.mainMenu.label}"><a4j:actionparam name="healthDeviceMainMenuName" value="#{headerTabPanel.healthDevice.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam></a4j:commandLink>
    				</f:facet>
    				<rich:dataGrid columns="2" value="#{headerTabPanel.healthDevice.subMenu}" var="healthDeviceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{healthDeviceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{healthDeviceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{healthDeviceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{healthDeviceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
					<rich:panelBarItem id="#{headerTabPanel.majorAppliance.mainMenu.name}" name="#{headerTabPanel.majorAppliance.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				<f:facet name="label">
    					<a4j:commandLink id="majorApplianceMainLabel" styleClass="fontb_1" value="#{headerTabPanel.majorAppliance.mainMenu.label}"><a4j:actionparam name="majorApplianceMainMenuName" value="#{headerTabPanel.majorAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam></a4j:commandLink>
    				</f:facet>
    				<rich:dataGrid columns="2" value="#{headerTabPanel.majorAppliance.subMenu}" var="majorApplianceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{majorApplianceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{majorApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{majorApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{majorApplianceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
					<rich:panelBarItem id="#{headerTabPanel.phoneDigital.mainMenu.name}" name="#{headerTabPanel.phoneDigital.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				<f:facet name="label">
    					<a4j:commandLink id="phoneDigitalMainLabel" styleClass="fontb_1" value="#{headerTabPanel.phoneDigital.mainMenu.label}"><a4j:actionparam name="phoneDigitalMainMenuName" value="#{headerTabPanel.phoneDigital.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam></a4j:commandLink>
    				</f:facet>
    				<rich:dataGrid columns="2" value="#{headerTabPanel.phoneDigital.subMenu}" var="phoneDigitalSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{phoneDigitalSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{phoneDigitalSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{phoneDigitalSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{phoneDigitalSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
					<rich:panelBarItem id="#{headerTabPanel.computerNetwork.mainMenu.name}" name="#{headerTabPanel.computerNetwork.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				<f:facet name="label">
    					<a4j:commandLink id="computerNetworkMainLabel" styleClass="fontb_1" value="#{headerTabPanel.computerNetwork.mainMenu.label}"><a4j:actionparam name="computerNetworkMainMenuName" value="#{headerTabPanel.computerNetwork.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam></a4j:commandLink>
    				</f:facet>
    				<rich:dataGrid columns="2" value="#{headerTabPanel.computerNetwork.subMenu}" var="computerNetworkSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{computerNetworkSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{computerNetworkSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{computerNetworkSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{computerNetworkSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
			</rich:panelBar>
		</rich:panel>
		</a4j:region>
	</h:form>

</f:subview>
</jsp:root>

