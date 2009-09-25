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

<h:panelGrid columns="4" border="0" style="border: 1px solid black;">
    <f:verbatim>Suggestion Box will suggest you Town's names if it's started with the "a" or
        "A" letter</f:verbatim>

    <f:facet name="header">
        <f:verbatim>Input With Suggestion Feature</f:verbatim>
    </f:facet>


    <f:verbatim>&#160;</f:verbatim>
    <h:panelGroup>
	    <h:inputText value="#{webData.sendUrl}" id="text"/>
	    <h:commandButton value="获得文本" action="#{webData.getWebPageText}"><a4j:support event="onclick" reRender="receivedTextId"/></h:commandButton>
    </h:panelGroup>
	<h:panelGroup>
	<h:outputText id="receivedTextId" value="#{webData.receivedText}"></h:outputText>
	</h:panelGroup>
    

</h:panelGrid>
</h:form>
</f:view>
</body>
</html>	
</jsp:root>	