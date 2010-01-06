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
				<h:panelGroup>
					<h:outputLabel id="currentProductCategoryLabel" value="当前商品导航:"></h:outputLabel><h:outputText id="currentProductCategoryLabelValue" value="#{headerTabPanel.currentTab}"></h:outputText>
				</h:panelGroup>
				<rich:tabPanel valueChangeListener="#{headerTabPanel.valueChanged}"  headerSpacing="0px" immediate="false" headerClass="rich-tab-header" activeTabClass="rich-tab-active" inactiveTabClass="rich-tab-inactive" tabClass="richTabClass" contentClass="main-header-tabpanel-panel-grid" width="100%" switchType="ajax" selectedTab="#{headerTabPanel.currentTab}" id="tab_panel" headerAlignment="left" height="50px;">
					<f:valueChangeListener type="com.ejd.web.vo.richfaces.header.HeaderTabChangeListener"/>
					
					<rich:tab onclick="alert('\\'Canon\\' tab clicked');" disabled="#{headerTabPanel.disabledTabName == 'kitchenAppliance'}" name="#{headerTabPanel.kitchenAppliance.mainMenu.name}" label="#{headerTabPanel.kitchenAppliance.mainMenu.label}" reRender="s1,s2" labelWidth="72px" styleClass="rich-tab-style">
						<rich:panel id="kitchenApplianceHeaderRegionPanel" style="width:100%;" styleClass="rich-tabpanel-panel-grid" bodyClass="rich-tabpanel-content-text">
								<a4j:repeat id="kitchenApplianceRep" value="#{headerTabPanel.kitchenAppliance.subMenu}" var="kitchenApplianceSubMenu">
									<span style="rich-tabpanel-content-text">
									<h:commandLink action="#{headerTabPanel.gotoProduct}" value="#{kitchenApplianceSubMenu.label}" immediate="true"  style="color:#2c629e;font-family:Courier;font-size:12px;width:90">
								
										<f:param name="idFirst" value="#{kitchenApplianceSubMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{kitchenApplianceSubMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{kitchenApplianceSubMenu.name}"></f:param>
								
									</h:commandLink>
									</span>
								</a4j:repeat>
								
						</rich:panel>
						
					</rich:tab>
					<rich:tab disabled="#{headerTabPanel.disabledTabName == 'householdAppliance'}" name="#{headerTabPanel.householdAppliance.mainMenu.name}" label="#{headerTabPanel.householdAppliance.mainMenu.label}" reRender="s1,s2" labelWidth="72px" styleClass="rich-tab-style">
						<rich:panel id="householdApplianceHeaderRegionPanel" style="width:100%;" styleClass="rich-tabpanel-panel-grid" bodyClass="rich-tabpanel-content-text">
						<a4j:repeat id="householdApplianceRep" value="#{headerTabPanel.householdAppliance.subMenu}" var="householdApplianceSubMenu">
							
							<h:commandLink action="#{headerTabPanel.gotoProduct}" value="#{householdApplianceSubMenu.label}" immediate="true" style="color:#2c629e;font-family:Courier;font-size:12px;width:90">
								
								<f:param name="idFirst" value="#{householdApplianceSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{householdApplianceSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{householdApplianceSubMenu.name}"></f:param>
								
							</h:commandLink>
								
						</a4j:repeat>
						</rich:panel>
					</rich:tab>
					<rich:tab disabled="#{headerTabPanel.disabledTabName == 'personalCare'}" name="#{headerTabPanel.personalCare.mainMenu.name}" label="#{headerTabPanel.personalCare.mainMenu.label}" reRender="s1,s2" labelWidth="72px" styleClass="rich-tab-style">
						<rich:panel id="personalCareHeaderRegionPanel" style="width:100%;" styleClass="rich-tabpanel-panel-grid" bodyClass="rich-tabpanel-content-text">
						<a4j:repeat id="personalCareRep" value="#{headerTabPanel.personalCare.subMenu}" var="personalCareSubMenu">
							
							<h:commandLink action="#{headerTabPanel.gotoProduct}" value="#{personalCareSubMenu.label}" immediate="true" style="color:#2c629e;font-family:Courier;font-size:12px;width:90">
								
								<f:param name="idFirst" value="#{personalCareSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{personalCareSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{personalCareSubMenu.name}"></f:param>
								
							</h:commandLink>
								
						</a4j:repeat>	
						</rich:panel>
					</rich:tab>
					<rich:tab disabled="#{headerTabPanel.disabledTabName == 'healthDevice'}" name="#{headerTabPanel.healthDevice.mainMenu.name}" label="#{headerTabPanel.healthDevice.mainMenu.label}" reRender="s1,s2" labelWidth="72px" styleClass="rich-tab-style">
						<rich:panel id="healthDeviceHeaderRegionPanel" style="width:100%;" styleClass="rich-tabpanel-panel-grid" bodyClass="rich-tabpanel-content-text">
						<a4j:repeat id="healthDeviceRep" value="#{headerTabPanel.healthDevice.subMenu}" var="healthDeviceSubMenu">
							
							<h:commandLink action="#{headerTabPanel.gotoProduct}" value="#{healthDeviceSubMenu.label}" immediate="true" style="color:#2c629e;font-family:Courier;font-size:12px;width:90">
								
								<f:param name="idFirst" value="#{healthDeviceSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{healthDeviceSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{healthDeviceSubMenu.name}"></f:param>
								
							</h:commandLink>
								
						</a4j:repeat>	
						</rich:panel>
					</rich:tab>
					<rich:tab disabled="#{headerTabPanel.disabledTabName == 'majorAppliance'}" name="#{headerTabPanel.majorAppliance.mainMenu.name}" label="#{headerTabPanel.majorAppliance.mainMenu.label}" reRender="s1,s2" labelWidth="72px" styleClass="rich-tab-style">
						<rich:panel id="majorApplianceHeaderRegionPanel" style="width:100%;" styleClass="rich-tabpanel-panel-grid" bodyClass="rich-tabpanel-content-text">
						<a4j:repeat id="majorApplianceRep" value="#{headerTabPanel.majorAppliance.subMenu}" var="majorApplianceSubMenu">
							
							<h:commandLink action="#{headerTabPanel.gotoProduct}" value="#{majorApplianceSubMenu.label}" immediate="true" style="color:#2c629e;font-family:Courier;font-size:12px;width:90">
								
								<f:param name="idFirst" value="#{majorApplianceSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{majorApplianceSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{majorApplianceSubMenu.name}"></f:param>
								
							</h:commandLink>
								
						</a4j:repeat>	
						</rich:panel>
					</rich:tab>
					<rich:tab disabled="#{headerTabPanel.disabledTabName == 'phoneDigital'}" name="#{headerTabPanel.phoneDigital.mainMenu.name}" label="#{headerTabPanel.phoneDigital.mainMenu.label}" reRender="s1,s2" labelWidth="72px" styleClass="rich-tab-style">
						<rich:panel id="phoneDigitalHeaderRegionPanel" style="width:100%;" styleClass="rich-tabpanel-panel-grid" bodyClass="rich-tabpanel-content-text">
						<a4j:repeat id="phoneDigitalRep" value="#{headerTabPanel.phoneDigital.subMenu}" var="phoneDigitalSubMenu">
							
							<h:commandLink action="#{headerTabPanel.gotoProduct}" value="#{phoneDigitalSubMenu.label}" immediate="true" style="color:#2c629e;font-family:Courier;font-size:12px;width:90">
								
								<f:param name="idFirst" value="#{phoneDigitalSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{phoneDigitalSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{phoneDigitalSubMenu.name}"></f:param>
								
							</h:commandLink>
								
						</a4j:repeat>	
						</rich:panel>
					</rich:tab>
					<rich:tab disabled="#{headerTabPanel.disabledTabName == 'computerNetwork'}" name="#{headerTabPanel.computerNetwork.mainMenu.name}" label="#{headerTabPanel.computerNetwork.mainMenu.label}" reRender="s1,s2" labelWidth="72px" styleClass="rich-tab-style">
						<rich:panel id="computerNetworkHeaderRegionPanel" style="width:100%;" styleClass="rich-tabpanel-panel-grid" bodyClass="rich-tabpanel-content-text">
						<a4j:repeat id="computerNetworkRep" value="#{headerTabPanel.computerNetwork.subMenu}" var="computerNetworkSubMenu">
							
							<h:commandLink action="#{headerTabPanel.gotoProduct}" value="#{computerNetworkSubMenu.label}" immediate="true" style="color:#2c629e;font-family:Courier;font-size:12px;width:90">
								
								<f:param name="idFirst" value="#{computerNetworkSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{computerNetworkSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{computerNetworkSubMenu.name}"></f:param>
								
							</h:commandLink>
								
						</a4j:repeat>
						</rich:panel>	
					</rich:tab>
				</rich:tabPanel>	
			</a4j:region>
</h:form>
</f:subview>		
</jsp:root>	