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
			<rich:panelBar id="kitchenApplianceLeftPb" styleClass="panel-bar-product-left" contentStyle="BACKGROUND-COLOR: #ffffe8">
    				<rich:panelBarItem id="kitchenApplianceLeftPbi" headerClass="kitchen-appliance-left-navigation-panel-bar-item-header">
    				<f:facet name="label">
    					<h:outputText value="#{headerTabPanel.kitchenAppliance.mainMenu.label}"></h:outputText>
    				</f:facet>
    				<rich:dataGrid columns="2" value="#{headerTabPanel.kitchenAppliance.subMenu}" var="kitchenApplianceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{kitchenApplianceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{kitchenApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{kitchenApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{kitchenApplianceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					</rich:panelBarItem>
			</rich:panelBar>
		</a4j:region>
	</h:form>

</f:subview>
</jsp:root>

