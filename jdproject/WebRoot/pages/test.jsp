<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<h:form>
<h:panelGrid columns="1" bgcolor="#bbd6ef" border="0" cellpadding="3" cellspacing="0" width="100%">
	<h:outputText value="header1"></h:outputText>
</h:panelGrid>

    <p>Here is an example of default tab panel with 3 tabs.</p>
    <rich:tabPanel>
        <rich:tab label="First">
         <!--  Here is tab #1 -->  
        </rich:tab>
        <rich:tab>
		<f:facet name="label">
		<!-- <h:outputText value="Second"></h:outputText> -->  
		</f:facet>
		<!-- <h:outputText value="here is tab #2"></h:outputText> -->  
		</rich:tab>
        <rich:tab label="Third">
        <!--     Here is tab #3 -->  
        </rich:tab>
    </rich:tabPanel>
    <br/><br/>
    <p>Here is an example of tab panel switched in "ajax" style. Second tab is disabled.</p>
    <rich:tabPanel switchType="ajax" headerSpacing="0px">
        <rich:tab label="新增">
            Here is tab #1
        </rich:tab>
        <rich:tab label="编辑">
            Here is tab #2
            <h:inputText value="#{bean.value1}"></h:inputText>
            <a4j:commandButton id="btn1" value="click me" reRender="l1,l2"></a4j:commandButton>
            <h:outputText id="l1" value="#{bean.value1}"></h:outputText>
        </rich:tab>
        <rich:tab label="Third">
            Here is tab #3
            <h:outputText id="l2" value="#{bean.value1}"></h:outputText>
        </rich:tab>
        <h:outputText value="gongong"></h:outputText>
        
    </rich:tabPanel>
    <br/><br/>
    <p>Here is an example of tab panel switched completely on client.</p>
    <rich:tabPanel switchType="client">
        <rich:tab label="First">
            Here is tab #1
        </rich:tab>
        <rich:tab label="Second">
            Here is tab #2
        </rich:tab>
        <rich:tab label="Third">
            Here is tab #3
        </rich:tab>
    </rich:tabPanel>
<h:panelGrid columns="2" columnClasses="top,top">
        <rich:extendedDataTable value="#{extendedTableBean.capitalsDataModel}" var="cap" id="table" rows="6"
            width="580px" height="400px" sortMode="#{extendedTableBean.sortMode}" 
                selectionMode="#{extendedTableBean.selectionMode}"
                selection="#{extendedTableBean.selection}"
                binding="#{extendedTableBean.table}">
            <rich:column sortable="false" label="Flag">  
                <f:facet name="header">
                    <h:outputText value="Flag"/>
                </f:facet>
                <h:graphicImage value="#{cap.stateFlag}"/>
            </rich:column> 
            <rich:column sortable="true" sortBy="#{cap.state}" filterBy="#{cap.state}" filterEvent="onkeyup" width="170px" label="State Name">
                <f:facet name="header">
                    <h:outputText value="State Name"/>
                </f:facet>
                <h:outputText value="#{cap.state}"/>
            </rich:column> 
            <rich:column sortable="true" sortBy="#{cap.name}" filterBy="#{cap.name}" filterEvent="onkeyup" width="170px" label="State Capital">
                <f:facet name="header">
                    <h:outputText value="State Capital"/>
                </f:facet>
                <h:outputText value="#{cap.name}"/>
            </rich:column> 
            <rich:column sortable="false" label="Time Zone">
                <f:facet name="header">
                    <h:outputText value="Time Zone"/>
                </f:facet>
                <h:outputText value="#{cap.timeZone}"/>
            </rich:column>
			<a4j:support event="onclick" ignoreDupResponses="true" requestDelay="500" action="#{extendedTableBean.takeSelection}" reRender="output"/>
            <a4j:support event="onkeyup" ignoreDupResponses="true" requestDelay="500" action="#{extendedTableBean.takeSelection}" reRender="output"/>
        </rich:extendedDataTable>
      <rich:datascroller align="left" for="table" maxPages="20"
			page="#{extendedTableBean.scrollerPage}" id="sc2"/>
        <rich:panel id="output" header="Current Selection" style="width:200px">
        <h:panelGrid columns="3">
            <h:inputText value="#{extendedTableBean.selectedCapital.name}"></h:inputText>
            <h:inputText value="#{extendedTableBean.selectedCapital.state}"></h:inputText>
            <h:inputText value="#{extendedTableBean.selectedCapital.timeZone}"></h:inputText>
        </h:panelGrid>
		<a4j:commandButton action="#{extendedTableBean.saveUpdate}" reRender="table"></a4j:commandButton>
        </rich:panel>
        <rich:panel>
            <f:facet name="header">
                <h:outputText value="Sort/Selection modes changing"/>
            </f:facet>
            <h:panelGrid columns="2">
                <h:outputText value="Sort Mode:"/>
                <h:selectOneMenu value="#{extendedTableBean.sortMode}">
                    <f:selectItem itemLabel="Single" itemValue="single"/>
                    <f:selectItem itemLabel="Multi" itemValue="multi"/>
                    <a4j:support event="onchange" ajaxSingle="true" reRender="table"/>
                </h:selectOneMenu>
                <h:outputText value="Selection Mode:"/>
                <h:selectOneMenu value="#{extendedTableBean.selectionMode}">
                    <a4j:support ajaxSingle="true" event="onchange" reRender="table"/>
                    <f:selectItem itemLabel="Single" itemValue="single"/>
                    <f:selectItem itemLabel="Multi" itemValue="multi"/>
                    <f:selectItem itemLabel="None" itemValue="none"/>
                </h:selectOneMenu>
            </h:panelGrid>
        </rich:panel>   
        </h:panelGrid>

</h:form>		
</jsp:root>	