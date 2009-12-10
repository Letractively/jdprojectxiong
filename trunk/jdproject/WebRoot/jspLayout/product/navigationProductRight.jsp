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
			<rich:panelBar id="kitchenApplianceLeftPb" binding="#{productPanelBar.panelBar}" selectedPanel="#{productPanelBar.currentBar}" styleClass="panel-bar-product-left" contentStyle="BACKGROUND-COLOR: #ffffe8">
    				<rich:panelBarItem id="#{headerTabPanel.kitchenAppliance.mainMenu.name}" name="#{headerTabPanel.kitchenAppliance.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				<f:facet name="label">
    					<h:outputText styleClass="fontb_1" value="#{headerTabPanel.kitchenAppliance.mainMenu.label}"></h:outputText>
    				</f:facet>
    				<rich:dataGrid columns="2" value="#{headerTabPanel.kitchenAppliance.subMenu}" var="kitchenApplianceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{kitchenApplianceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{kitchenApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{kitchenApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{kitchenApplianceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
					<rich:panelBarItem id="#{headerTabPanel.householdAppliance.mainMenu.name}" name="#{headerTabPanel.householdAppliance.mainMenu.name}" headerClass="navigation-product-panel-bar-item">
    				<f:facet name="label">
    					<h:outputText styleClass="fontb_1" value="#{headerTabPanel.householdAppliance.mainMenu.label}"></h:outputText>
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
    					<h:outputText styleClass="fontb_1" value="#{headerTabPanel.personalCare.mainMenu.label}"></h:outputText>
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
    					<h:outputText styleClass="fontb_1" value="#{headerTabPanel.healthDevice.mainMenu.label}"></h:outputText>
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
    					<h:outputText styleClass="fontb_1" value="#{headerTabPanel.majorAppliance.mainMenu.label}"></h:outputText>
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
    					<h:outputText styleClass="fontb_1" value="#{headerTabPanel.phoneDigital.mainMenu.label}"></h:outputText>
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
    					<h:outputText styleClass="fontb_1" value="#{headerTabPanel.computerNetwork.mainMenu.label}"></h:outputText>
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
		</a4j:region>
	</h:form>

</f:subview>
</jsp:root>

