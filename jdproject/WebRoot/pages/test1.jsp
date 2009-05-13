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

</h:form>		
</jsp:root>	