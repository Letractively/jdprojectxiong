<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="manageLeftNavigationView">
<h:form id="manageLeftNavigationForm">
	<style>
        .cols{
            vertical-align:top;
            width:50%;
            PADDING-LEFT: 0px;
        }
    </style>    
    <rich:panelMenu id="navigationPanelMenu" selectedChild="pg" style="width:200px" disabled="false"  mode="ajax" expandMode="ajax" expandSingle="false"
        iconExpandedGroup="disc" iconCollapsedGroup="disc" 
        iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right" 
        iconCollapsedTopGroup="chevronDown" iconCollapsedTopPosition="right" >
        <rich:panelMenuGroup label="基础数据" expanded="true">
            <rich:panelMenuItem label="产品类别" action="#{managePanelMenu.updateCurrent}" immediate="true">
                <f:param name="current" value="productcategory"/>
            </rich:panelMenuItem>
            <rich:panelMenuItem label="产品品牌" action="#{managePanelMenu.updateCurrent}">
                <f:param name="current" value="Item 1.2"/>
            </rich:panelMenuItem>
            <rich:panelMenuItem label="Item 1.3" action="#{managePanelMenu.updateCurrent}">
                <f:param name="current" value="Item 1.3"/>
            </rich:panelMenuItem>
        </rich:panelMenuGroup>
        <rich:panelMenuGroup name="pg" expanded="true" label="Group 2">
            <rich:panelMenuItem label="Item 2.1" action="#{managePanelMenu.updateCurrent}">
                <f:param name="current" value="Item 2.1"/>
            </rich:panelMenuItem>
            <rich:panelMenuItem   label="Item 2.2" action="#{managePanelMenu.updateCurrent}">
                <f:param name="current" value="Item 2.2"/>
            </rich:panelMenuItem>
            <rich:panelMenuItem label="Item 2.3" action="#{managePanelMenu.updateCurrent}">
                <f:param name="current" value="Item 2.3"/>
            </rich:panelMenuItem>
            <rich:panelMenuGroup label="Group 2.4">
                <rich:panelMenuItem label="Item 2.4.1" action="#{managePanelMenu.updateCurrent}">
                    <f:param name="current" value="Item 2.4.1"/>
                </rich:panelMenuItem>
                <rich:panelMenuItem label="Item 2.4.2" action="#{managePanelMenu.updateCurrent}">
                    <f:param name="current" value="Item 2.4.2"/>
                </rich:panelMenuItem>
                <rich:panelMenuItem label="Item 2.4.3" action="#{managePanelMenu.updateCurrent}">
                    <f:param name="current" value="Item 2.4.3"/>
                </rich:panelMenuItem>
            </rich:panelMenuGroup>
            <rich:panelMenuItem label="Item 2.5" action="#{managePanelMenu.updateCurrent}">
                    <f:param name="current" value="Item 2.5"/>
            </rich:panelMenuItem>
        </rich:panelMenuGroup>
        <rich:panelMenuGroup expanded="true" label="Group 3">
            <rich:panelMenuItem label="Item 3.1" action="#{managePanelMenu.updateCurrent}">
                    <f:param name="current" value="Item 3.1"/>
            </rich:panelMenuItem>
            <rich:panelMenuItem label="Item 3.2" action="#{managePanelMenu.updateCurrent}">
                    <f:param name="current" value="Item 3.2"/>
            </rich:panelMenuItem>
            <rich:panelMenuItem label="Item 3.3" action="#{managePanelMenu.updateCurrent}">
                    <f:param name="current" value="Item 3.3"/>
            </rich:panelMenuItem>
        </rich:panelMenuGroup>
    </rich:panelMenu>
</h:form>
</f:subview>		
</jsp:root>	