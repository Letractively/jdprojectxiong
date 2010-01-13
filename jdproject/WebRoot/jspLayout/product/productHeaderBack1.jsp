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
				
				<rich:toolBar height="34" id="mainheaderpronavbar">
		            <rich:toolBarGroup id="#{headerTabPanel.kitchenAppliance.mainMenu.name}">
		            	<h:commandLink id="kitchenAppliancebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.kitchenAppliance.mainMenu.label}" for="kitchenAppliancebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.kitchenAppliance.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.kitchenAppliance.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.kitchenAppliance.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.householdAppliance.mainMenu.name}">
		            	<h:commandLink id="householdAppliancebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.householdAppliance.mainMenu.label}" for="householdAppliancebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.householdAppliance.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.householdAppliance.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.householdAppliance.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.personalCare.mainMenu.name}">
		            	<h:commandLink id="personalCarebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.personalCare.mainMenu.label}" for="personalCarebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.personalCare.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.personalCare.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.personalCare.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.healthDevice.mainMenu.name}">
		            	<h:commandLink id="healthDevicebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.healthDevice.mainMenu.label}" for="healthDevicebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.healthDevice.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.healthDevice.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.healthDevice.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.majorAppliance.mainMenu.name}">
		            	<h:commandLink id="majorAppliancebtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.majorAppliance.mainMenu.label}" for="majorAppliancebtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.majorAppliance.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.majorAppliance.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.majorAppliance.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.phoneDigital.mainMenu.name}">
		            	<h:commandLink id="phoneDigitalbtn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.phoneDigital.mainMenu.label}" for="phoneDigitalbtn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.phoneDigital.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.phoneDigital.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.phoneDigital.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		            <rich:toolBarGroup id="#{headerTabPanel.computerNetwork.mainMenu.name}" styleClass="rich-toolbar-select">
		            	<h:commandLink id="computerNetworktn" action="#{headerTabPanel.gotoProduct}" immediate="true">
		              		<h:outputLabel value="#{headerTabPanel.computerNetwork.mainMenu.label}" for="computerNetworktn" />
		              		<f:param name="idFirst" value="#{headerTabPanel.computerNetwork.mainMenu.idFirst}"></f:param>
							<f:param name="idSecond" value="#{headerTabPanel.computerNetwork.mainMenu.idSecond}"></f:param>
							<f:param name="productType" value="#{headerTabPanel.computerNetwork.mainMenu.name}"></f:param>
		              	</h:commandLink>
		            </rich:toolBarGroup>
		        </rich:toolBar>
				
				<rich:tabPanel valueChangeListener="#{headerTabPanel.valueChanged}"  headerSpacing="0" immediate="false" headerClass="rich-tabpanel-header" activeTabClass="rich-tab-active" inactiveTabClass="rich-tab-inactive" tabClass="richTabClass" contentClass="main-header-tabpanel-content-class" width="100%" switchType="ajax" selectedTab="#{headerTabPanel.currentTab}" id="tab_panel" headerAlignment="left" height="50px;">
					<f:valueChangeListener type="com.ejd.web.vo.richfaces.header.HeaderTabChangeListener"/>
					
					<rich:tab onclick="alert('\\'Canon\\' tab clicked');" disabled="#{headerTabPanel.disabledTabName == 'kitchenAppliance'}" name="#{headerTabPanel.kitchenAppliance.mainMenu.name}" label="#{headerTabPanel.kitchenAppliance.mainMenu.label}" reRender="s1,s2" labelWidth="72px" styleClass="rich-tab-style">
						<rich:panel id="kitchenApplianceHeaderRegionPanel" style="width:100%;" styleClass="rich-tabpanel-panel-grid" bodyClass="rich-tabpanel-content-text">
								<a4j:repeat id="kitchenApplianceRep" value="#{headerTabPanel.kitchenAppliance.subMenu}" var="kitchenApplianceSubMenu">
									<span style="rich-tabpanel-content-text">
									<h:commandLink action="#{headerTabPanel.gotoProduct}" value="#{kitchenApplianceSubMenu.label}" immediate="true"  style="color:#2c629e;font-family:Courier;font-size:12px;width:80">
								
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