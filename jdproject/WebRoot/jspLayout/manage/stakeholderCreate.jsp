<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view id="manageMainView">
<a4j:loadScript src="resource:///org/richfaces/renderkit/html/scripts/scriptaculous/effects.js" />
<html>
	<head>

    <title>create stakeholder</title>
    </head>
	
    <body>
    	<ui:composition template="./manageTemplate.jsp">
			
    		<ui:define name="content">
    			
    			<fieldset class="demo_fieldset">
				<legend class="demo_legend"><h:outputText value="#{manageHeaderMenu.menuTitle}"/></legend>
    				<a4j:region renderRegionOnly="true" immediate="true" selfRendered="true">
    				<h:form id="cratestakeholderform">
    				<h:panelGrid id="stakeholderpg" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
						<f:facet name="header">
                			<h:outputText value="创建新用户" id="newProgress"/>
            			</f:facet>
						<h:outputLabel value="用户ID:" for="userid"></h:outputLabel>
						<h:inputText value="#{stakeholderCreate.stakeholder.userId}" maxlength="20" id="userid">
							<rich:beanValidator summary="错误，请检查"/>
                		</h:inputText>
                		<rich:message for="userid" />
						<h:outputText value=" "></h:outputText>
                		<h:outputText value="#{stakeholderCreate.stakeholder.mnemonicchars}" id="mnemonicchar"></h:outputText>
						<h:outputText value=" "></h:outputText>
						<h:outputLabel value="简称:" for="shortname"></h:outputLabel>
                		<h:inputText value="#{stakeholderCreate.stakeholder.shortName}" maxlength="50" id="shortname">
                			<rich:beanValidator summary="错误,请检查"/>
                		</h:inputText>
						<rich:message for="shortname"/>
						<h:outputLabel value="全称:" for="fullname"></h:outputLabel>
                		<h:inputText value="#{stakeholderCreate.stakeholder.fullName}" maxlength="100" style="width:300px;" id="fullname">
                			<rich:beanValidator summary="错误,请检查"/>
                		</h:inputText>
						<rich:message for="fullname"/>
						<h:outputText value="区域:"></h:outputText>
						<h:panelGroup>
							<h:inputText value="#{stakeholderCreate.stakeholder.province}" id="province" maxlength="50" style="width:80px;text-align:right"></h:inputText><h:outputLabel value="省(直辖市)  " for="province"></h:outputLabel>
							<h:inputText value="#{stakeholderCreate.stakeholder.city}" id="city" maxlength="20" style="width:60px;text-align:right"></h:inputText><h:outputLabel value="市     " for="city"></h:outputLabel>
							<h:inputText value="#{stakeholderCreate.stakeholder.county}" id="county" maxlength="20" style="width:61px;text-align:right"></h:inputText><h:outputLabel value="县(区)  " for="county"></h:outputLabel>
						</h:panelGroup>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="电话:" for="phone"></h:outputLabel>
                		<h:inputText value="#{stakeholderCreate.stakeholder.phone}" maxlength="100" id="phone">
                		</h:inputText>
						<rich:message for="phone"/>
						<h:outputLabel value="传真:" for="tax"></h:outputLabel>
                		<h:inputText value="#{stakeholderCreate.stakeholder.tax}" maxlength="100" id="tax">
                		</h:inputText>
						<rich:message for="tax"/>
						<h:outputLabel value="URL:" for="url"></h:outputLabel>
                		<h:inputText value="#{stakeholderCreate.stakeholder.url}" maxlength="100" id="url">
                		</h:inputText>
						<rich:message for="url"/>
						<h:outputLabel value="备注:" for="remarks"></h:outputLabel>
                		<h:inputTextarea value="#{stakeholderCreate.stakeholder.remarks}" style="width:300px;height:50px" id="remarks">
                			<rich:beanValidator summary="错误,请检查"/>
                		</h:inputTextarea>
						<rich:message for="remarks"/>
						<h:outputLabel value="状态:" for="status"></h:outputLabel>
						<h:selectOneMenu value="#{stakeholderCreate.stakeholder.status}">
							<f:selectItem itemValue="N" itemLabel="待批"/>
							<f:selectItem itemValue="L" itemLabel="锁定"/>
							<f:selectItem itemValue="A" itemLabel="正常"/>
						</h:selectOneMenu>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="类型:" for="type"></h:outputLabel>
						<h:selectOneMenu value="#{stakeholderCreate.stakeholder.type}">
							<f:selectItem itemValue="V" itemLabel="游客"/>
							<f:selectItem itemValue="P" itemLabel="供应商"/>
							<f:selectItem itemValue="C" itemLabel="客户"/>
							<f:selectItem itemValue="A" itemLabel="代理商"/>
							<f:selectItem itemValue="D" itemLabel="经销商"/>
						</h:selectOneMenu>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="税号:" for="taxaccounts"></h:outputLabel>
                		<h:inputText value="#{stakeholderCreate.stakeholder.taxaccounts}" maxlength="100" id="taxaccounts">
                		</h:inputText>
						<h:outputText value=""></h:outputText>
					</h:panelGrid>
					</h:form>
					</a4j:region>
					<a4j:region id="regionnewperson" renderRegionOnly="true" immediate="true" selfRendered="true">
					<rich:simpleTogglePanel id="scstp" switchType="ajax" ajaxSingle="true" reRender="newpersonform" width="100%" label="可选数据填写" headerClass="simple-toggle-panel-header" bodyClass="simple-toggle-panel-body">
						<rich:tabPanel switchType="ajax" headerSpacing="0px" immediate="false" tabClass="tabClass" activeTabClass="bold" inactiveTabClass="bold" width="100%" binding="#{stakeholderCreate.tabPersonPanel}" selectedTab="#{stakeholderCreate.currentTabPerson}" id="tab_panel_person" headerAlignment="left">
        					<rich:tab name="createPerson" switchType="ajax" labelWidth="100%" label="新增">
            					<a4j:include id="a4jincludenew" ajaxRendered="true" viewId="/jspLayout/manage/stakeholderCreatePersonCreate.jsp"/>
        					</rich:tab>
        					<rich:tab name="editPerson" switchType="ajax" labelWidth="100%" label="编辑">
            					<a4j:include id="a4jincludeedit" ajaxRendered="true" viewId="/jspLayout/manage/stakeholderCreatePersonEdit.jsp"/>
								
        					</rich:tab>

    					</rich:tabPanel>
					</rich:simpleTogglePanel>
					</a4j:region>
				</fieldset>
    			
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	