<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view>
<html>
	<head>
    <title>sdsdsdsdsd</title>
    </head>
    <body>
    	<ui:composition template="../productTemplate.jsp">
    		<ui:define name="left">
    			<rich:panelBar id="phonepb" style="width: auto;" height="300px" contentStyle="background:none;">
					<rich:panelBarItem id="phone">
						<f:facet name="label">
							<h:panelGroup layout="block">
							<ui:include id="phoneinp11" src="../productNavigationPanelHeader.jsp" >
								<ui:param name="label" value="#{navigationLeft.phonePrimaryCategory}"/>
								
							</ui:include>
							</h:panelGroup>
							
						</f:facet>
						<ui:include id="phoneinp12" src="../productNavigationGroup.jsp" >
 							<ui:param name="brands" value="#{navigationLeft.phoneBrands}" />
							<ui:param name="secondCategorys" value="#{navigationLeft.phoneSecondCategorys}" />
 						</ui:include>
					</rich:panelBarItem>
				</rich:panelBar>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	