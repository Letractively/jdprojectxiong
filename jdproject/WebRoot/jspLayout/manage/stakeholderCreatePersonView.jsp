<?xml version="1.0" encoding="UTF-8"?>
<ui:composition
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<!--  <a4j:region id="scpvnavegationregion" renderRegionOnly="true"> -->
	<!-- <h:form id="scpvnavagationform">  -->
		<a4j:commandButton id="linkone" immediate="true" value="aaa" action="stakeholderCreatePersonCreate">
			
		</a4j:commandButton>
		<h:commandButton id="linkone43" value="aaa" >
			<a4j:support event="onclick" ajaxSingle="true" limitToList="true" reRender="a4jinclude" action="stakeholderCreatePersonCreate"></a4j:support>
		</h:commandButton>
		
	<!-- </h:form>  -->
	<!-- </a4j:region> -->
	<!-- <a4j:region id="scpvnavregion1"> -->
	<!--<h:form> -->
		<h:outputText value="view"></h:outputText>
	<!--</h:form> -->
	<!-- </a4j:region> -->
</ui:composition>	