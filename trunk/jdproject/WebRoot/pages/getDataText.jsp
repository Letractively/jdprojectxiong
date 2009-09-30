<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<html>
<head>
    <title></title>
</head>

<body>
<f:view>

<a4j:outputPanel ajaxRendered="true">
	<h:messages />
</a4j:outputPanel>

<h:form id="suggestionbox_form">
<br/>
<br/>

<h:outputText
        value="Simple richfaces Suggestion Box test web application."
        style="font: 18px;font-weight: bold;"/>
<br/>
<br/>

<h:panelGrid columns="1" border="0" style="border: 1px solid black;width:100%;">
    <f:verbatim>Suggestion Box will suggest you Town's names if it's started with the "a" or
        "A" letter</f:verbatim>

    <f:facet name="header">
        <f:verbatim>Input With Suggestion Feature</f:verbatim>
    </f:facet>


    <f:verbatim>&#160;</f:verbatim>
    <h:panelGroup style="width:100%">
	    <h:inputTextarea value="#{webData.sendUrl}" id="text" style="width:800px;height:800px;"/>
	    <h:commandButton value="获得详细数据" action="#{webData.getWebDataText}"><a4j:support event="onclick" reRender="receivedTextId"/></h:commandButton>
    </h:panelGroup>
    
    <h:panelGroup>
    <a4j:region id="setRegin">
    <h:panelGrid columns="2" headerClass="" style="width:100%">
    	<f:facet name="header"><h:selectBooleanCheckbox id="useProxyId" value="#{webData.useProxy}"><a4j:support event="onclick" reRender="setRegin"/></h:selectBooleanCheckbox></f:facet>
    	<h:outputText value="代理IP地址:"></h:outputText><h:inputText value="#{webData.host}"></h:inputText>
    	<h:outputText value="端口"></h:outputText><rich:inplaceInput value="#{webData.port}"></rich:inplaceInput>
    	<h:outputText value="PC登陆名"></h:outputText><h:inputText value="#{webData.username}"></h:inputText>
    	<h:outputText value="密码"></h:outputText><h:inputText value="#{webData.password}"></h:inputText>
    </h:panelGrid>
    </a4j:region>
    </h:panelGroup>
	<h:panelGroup>
	<h:inputTextarea style="width:100%;height:150px;" id="receivedTextId" value="#{webData.receivedText}"></h:inputTextarea>
	</h:panelGroup>
    <h:panelGroup style="width:100%">
	    <h:inputTextarea value="#{webData.errorSendUrl}" id="text1" style="width:800px;height:800px;"/>
	    <h:commandButton value="获得详细数据" action="#{webData.getErrorWebDataText}"><a4j:support event="onclick" reRender="receivedTextId"/></h:commandButton>
    </h:panelGroup>

</h:panelGrid>
</h:form>
</f:view>
</body>
</html>	
</jsp:root>	