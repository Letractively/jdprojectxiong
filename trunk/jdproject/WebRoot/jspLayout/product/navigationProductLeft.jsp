<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="allProductLeftView">
	<h:form id="allProductLeftViewForm">
		<a4j:region id="allProductLeftViewFormRegion" renderRegionOnly="false" selfRendered="true">
		<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border">
			<f:facet name="header">
				<h:panelGrid columns="3"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
					<h:outputText value="" style="width:4px"></h:outputText>
					<h:panelGroup>
						 <h:outputText value="商品分类" styleClass="product-detail-font1"></h:outputText>
					</h:panelGroup>
					<h:outputText value="" style="width:4px"></h:outputText>
				</h:panelGrid>			
			
			</f:facet>
			
    				<rich:dataGrid id="kitchenApplianceContentDg" rendered="#{currentPrimaryCategory == 'kitchenAppliance'?'true':'false'}" columns="2" value="#{headerTabPanel.kitchenAppliance.subMenu}" var="kitchenApplianceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<h:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{kitchenApplianceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{kitchenApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{kitchenApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{kitchenApplianceSubMenu.name}"></f:param>
								
						</h:commandLink>
    				</rich:dataGrid>
					<rich:dataGrid rendered="#{currentPrimaryCategory == 'householdAppliance'?'true':'false'}" columns="2" value="#{headerTabPanel.householdAppliance.subMenu}" var="householdApplianceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{householdApplianceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{householdApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{householdApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{householdApplianceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					<rich:dataGrid rendered="#{currentPrimaryCategory == 'personalCare'?'true':'false'}" columns="2" value="#{headerTabPanel.personalCare.subMenu}" var="personalCareSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{personalCareSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{personalCareSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{personalCareSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{personalCareSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					<rich:dataGrid rendered="#{currentPrimaryCategory == 'healthDevice'?'true':'false'}" columns="2" value="#{headerTabPanel.healthDevice.subMenu}" var="healthDeviceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{healthDeviceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{healthDeviceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{healthDeviceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{healthDeviceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					<rich:dataGrid rendered="#{currentPrimaryCategory == 'majorAppliance'?'true':'false'}" columns="2" value="#{headerTabPanel.majorAppliance.subMenu}" var="majorApplianceSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{majorApplianceSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{majorApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{majorApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{majorApplianceSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					<rich:dataGrid rendered="#{currentPrimaryCategory == 'phoneDigital'?'true':'false'}" columns="2" value="#{headerTabPanel.phoneDigital.subMenu}" var="phoneDigitalSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{phoneDigitalSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{phoneDigitalSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{phoneDigitalSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{phoneDigitalSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
					<rich:dataGrid rendered="#{currentPrimaryCategory == 'computerNetwork'?'true':'false'}" columns="2" value="#{headerTabPanel.computerNetwork.subMenu}" var="computerNetworkSubMenu" columnClasses="table-list-product-left-panel-grid-column" styleClass="navigation-left-kitchen_appliance-product-panel-grid-data-grid">
    					<a4j:commandLink action="#{headerTabPanel.gotoProduct}" styleClass="font3b" value="#{computerNetworkSubMenu.label}" immediate="true">
								
										<f:param name="idFirst" value="#{computerNetworkSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{computerNetworkSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{computerNetworkSubMenu.name}"></f:param>
								
						</a4j:commandLink>
    				</rich:dataGrid>
			
		</rich:panel>
		</a4j:region>
	</h:form>

</f:subview>
</jsp:root>

