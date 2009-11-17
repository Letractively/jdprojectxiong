<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="headerMainView">
<h:form id="headerMainform"> 
				<rich:tabPanel valueChangeListener="#{headerTabPanelBean.valueChanged}" headerSpacing="0px" immediate="false" tabClass="tabClass" activeTabClass="italic" width="100%" switchType="ajax" binding="#{headerTabPanelBean.tabPanel}" selectedTab="#{headerTabPanelBean.currentTab}" id="tab_panel" headerAlignment="left" height="50px;">
					<f:valueChangeListener type="com.ejd.web.vo.richfaces.header.HeaderTabChangeListener"/>
					
					<rich:tab onclick="alert('\\'Canon\\' tab clicked');" disabled="#{headerTabPanelBean.disabledTabName == 'kitchenAppliance'}" name="#{headerTabPanelBean.kitchenAppliance.mainMenu.name}" label="#{headerTabPanelBean.kitchenAppliance.mainMenu.description}" reRender="s1,s2" labelWidth="88px">
						<a4j:repeat id="kitchenApplianceRep" value="#{headerTabPanelBean.kitchenAppliance.subMenu}" var="kitchenApplianceSubMenu">
							<SPAN>
							<h:commandLink action="#{headerTabPanelBean.gotoProduct}" value="#{kitchenApplianceSubMenu.description}" immediate="true">
								
								<f:param name="idFirst" value="#{kitchenApplianceSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{kitchenApplianceSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{kitchenApplianceSubMenu.name}"></f:param>
								
							</h:commandLink></SPAN>
								
						</a4j:repeat>
						
					</rich:tab>
					<rich:tab disabled="#{headerTabPanelBean.disabledTabName == 'householdAppliance'}" name="#{headerTabPanelBean.householdAppliance.mainMenu.name}" label="#{headerTabPanelBean.householdAppliance.mainMenu.description}" reRender="s1,s2" labelWidth="88px">
						<a4j:repeat id="householdApplianceRep" value="#{headerTabPanelBean.householdAppliance.subMenu}" var="householdApplianceSubMenu">
							<SPAN>
							<h:commandLink action="#{headerTabPanelBean.gotoProduct}" value="#{householdApplianceSubMenu.description}" immediate="true">
								
								<f:param name="idFirst" value="#{householdApplianceSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{householdApplianceSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{householdApplianceSubMenu.name}"></f:param>
								
							</h:commandLink></SPAN>
								
						</a4j:repeat>
					</rich:tab>
					<rich:tab disabled="#{headerTabPanelBean.disabledTabName == 'personalCare'}" name="#{headerTabPanelBean.personalCare.mainMenu.name}" label="#{headerTabPanelBean.personalCare.mainMenu.description}" reRender="s1,s2" labelWidth="88px">
						<a4j:repeat id="personalCareRep" value="#{headerTabPanelBean.personalCare.subMenu}" var="personalCareSubMenu">
							<SPAN>
							<h:commandLink action="#{headerTabPanelBean.gotoProduct}" value="#{personalCareSubMenu.description}" immediate="true">
								
								<f:param name="idFirst" value="#{personalCareSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{personalCareSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{personalCareSubMenu.name}"></f:param>
								
							</h:commandLink></SPAN>
								
						</a4j:repeat>	
					</rich:tab>
					<rich:tab disabled="#{headerTabPanelBean.disabledTabName == 'healthDevice'}" name="#{headerTabPanelBean.healthDevice.mainMenu.name}" label="#{headerTabPanelBean.healthDevice.mainMenu.description}" reRender="s1,s2" labelWidth="88px">
						<a4j:repeat id="healthDeviceRep" value="#{headerTabPanelBean.healthDevice.subMenu}" var="healthDeviceSubMenu">
							<SPAN>
							<h:commandLink action="#{headerTabPanelBean.gotoProduct}" value="#{healthDeviceSubMenu.description}" immediate="true">
								
								<f:param name="idFirst" value="#{healthDeviceSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{healthDeviceSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{healthDeviceSubMenu.name}"></f:param>
								
							</h:commandLink></SPAN>
								
						</a4j:repeat>	
					</rich:tab>
					<rich:tab disabled="#{headerTabPanelBean.disabledTabName == 'majorAppliance'}" name="#{headerTabPanelBean.majorAppliance.mainMenu.name}" label="#{headerTabPanelBean.majorAppliance.mainMenu.description}" reRender="s1,s2" labelWidth="88px">
						<a4j:repeat id="majorApplianceRep" value="#{headerTabPanelBean.majorAppliance.subMenu}" var="majorApplianceSubMenu">
							<SPAN>
							<h:commandLink action="#{headerTabPanelBean.gotoProduct}" value="#{majorApplianceSubMenu.description}" immediate="true">
								
								<f:param name="idFirst" value="#{majorApplianceSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{majorApplianceSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{majorApplianceSubMenu.name}"></f:param>
								
							</h:commandLink></SPAN>
								
						</a4j:repeat>	
					</rich:tab>
					<rich:tab disabled="#{headerTabPanelBean.disabledTabName == 'phoneDigital'}" name="#{headerTabPanelBean.phoneDigital.mainMenu.name}" label="#{headerTabPanelBean.phoneDigital.mainMenu.description}" reRender="s1,s2" labelWidth="88px">
						<a4j:repeat id="phoneDigitalRep" value="#{headerTabPanelBean.phoneDigital.subMenu}" var="phoneDigitalSubMenu">
							<SPAN>
							<h:commandLink action="#{headerTabPanelBean.gotoProduct}" value="#{phoneDigitalSubMenu.description}" immediate="true">
								
								<f:param name="idFirst" value="#{phoneDigitalSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{phoneDigitalSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{phoneDigitalSubMenu.name}"></f:param>
								
							</h:commandLink></SPAN>
								
						</a4j:repeat>	
					</rich:tab>
					<rich:tab disabled="#{headerTabPanelBean.disabledTabName == 'computerNetwork'}" name="#{headerTabPanelBean.computerNetwork.mainMenu.name}" label="#{headerTabPanelBean.computerNetwork.mainMenu.description}" reRender="s1,s2" labelWidth="88px">
						<a4j:repeat id="computerNetworkRep" value="#{headerTabPanelBean.computerNetwork.subMenu}" var="computerNetworkSubMenu">
							<SPAN>
							<h:commandLink action="#{headerTabPanelBean.gotoProduct}" value="#{computerNetworkSubMenu.description}" immediate="true">
								
								<f:param name="idFirst" value="#{computerNetworkSubMenu.idFirst}"></f:param>
									<f:param name="idSecond" value="#{computerNetworkSubMenu.idSecond}"></f:param>
									<f:param name="productType" value="#{computerNetworkSubMenu.name}"></f:param>
								
							</h:commandLink></SPAN>
								
						</a4j:repeat>	
					</rich:tab>
					
				</rich:tabPanel>	
</h:form>
</f:subview>		
</jsp:root>	