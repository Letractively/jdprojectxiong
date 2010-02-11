<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="theproductDetailsubview">
	<rich:tabPanel switchType="ajax" headerSpacing="0px">
				        <rich:tab>
				        	<f:facet name="label"><h:panelGroup><h:outputLabel value="&#160;"></h:outputLabel>产品描述&#160;</h:panelGroup></f:facet>
				            100001
				        </rich:tab>
				        <rich:tab>
				        	<f:facet name="label"><h:panelGroup><h:outputLabel value="&#160;"></h:outputLabel>规格参数&#160;</h:panelGroup></f:facet>
				            Here is tab #2
				            <h:inputText value="dfdfdf"></h:inputText>
				            <a4j:commandButton id="btn1" value="click me" reRender="l1,l2"></a4j:commandButton>
				            <h:outputText id="l1" value="cvccvcv"></h:outputText>
				        </rich:tab>
				        <rich:tab>
				        <f:facet name="label"><h:panelGroup><h:outputLabel value="&#160;"></h:outputLabel>包装信息&#160;</h:panelGroup></f:facet>
				            Here is tab #3
				            <h:outputText id="l2" value="fdfdfdf"></h:outputText>
				        </rich:tab>
				        <rich:tab>
				        	<f:facet name="label"><h:panelGroup><h:outputLabel value="&#160;"></h:outputLabel>保修条款&#160;</h:panelGroup></f:facet>
				            Here is tab #3
				            <h:outputText id="l3" value="fdfdfdf"></h:outputText>
				        </rich:tab>
				    </rich:tabPanel>
</f:subview>		
</jsp:root>	