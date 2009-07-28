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
				<a4j:region id="cameraregionleft" renderRegionOnly="false" selfRendered="true">
    			<h:form id="cameraleftform">
				<rich:panelBar id="camerapb" style="width: auto;" height="300px" contentStyle="background:none;">
					<rich:panelBarItem id="camera">
						<f:facet name="label">
							<h:panelGroup layout="block">
							<ui:include id="phoneinp23" src="../productNavigationPanelHeader.jsp" >
								<ui:param name="label" value="#{navigationLeft.cameraPrimaryCategoryName}"/>
								
							</ui:include>
							
							</h:panelGroup>
						</f:facet>
						<ui:include id="phoneinp24" src="../productNavigationGroup.jsp" >
 							<ui:param name="brands" value="#{navigationLeft.cameraBrands}" />
							<ui:param name="secondCategorys" value="#{navigationLeft.cameraSecondCategorys}" />
							<ui:param name="prices" value="#{navigationLeft.cameraPrices}"/>
							<ui:param name="primaryCategoryId" value="#{navigationLeft.cameraPrimaryCategory.id}"/>
							<ui:param name="model" value="camera"/>
 						</ui:include>
					</rich:panelBarItem>
				</rich:panelBar>
				</h:form>
				</a4j:region>
			</ui:define>
			
			<ui:define id="definecontent" name="content">
    			<a4j:region id="regioncontent" renderRegionOnly="false" selfRendered="true">
    			<h:form id="cameracontentform">
    			<rich:dataTable id="productList" rowClasses="table-odd-row;table-even-row" width="483" rows="20" value="#{listCameraProduct.dataModel}" var="product">            
                 <f:facet name="header">
                     <rich:columnGroup>
                         <h:column>
                             <h:outputText value="code" />
                         </h:column>
                         <h:column>
                             <h:outputText value="name" />
                         </h:column>
                         <h:column>
                             <h:outputText value="retailPrice" />
                         </h:column>
                                                 
                     </rich:columnGroup>
                 </f:facet>
     				
                 <h:column>
                     <h:outputText value="#{product.code}" />
                     
   				
                 </h:column>
                 <h:column>
                     <h:outputText value="#{product.name}" />
                     
                 </h:column> 
                 <h:column>
                     <h:outputText value="#{product.retailPrice}" />
                    
                 </h:column>   
                 <f:facet name="footer">
                 	<rich:datascroller for="productList" id="dcProductList" page="#{listCameraProduct.scrollerPage}" pageIndexVar="currentPage" pagesVar="totalPages" maxPages="10" style="width:483px">
                 		<f:facet name="controlSeparator">
                 		</f:facet>
                 		<f:facet name="first">
                 		</f:facet>
                 		<f:facet name="first_disabled">
                 			<h:graphicImage url="/css/images/cars.gif"></h:graphicImage>
                 		</f:facet> 
                 		<f:facet name="last">
                 		</f:facet>
                 		<f:facet name="last_disabled">
                 		</f:facet>
                 		<f:facet name="fastrewind">
                 		</f:facet>
                 		<f:facet name="fastrewind_disabled">
                 		</f:facet>
                 		<f:facet name="previous">
                 		</f:facet>
                 		<f:facet name="previous_disabled">
                 		</f:facet>
                 		<f:facet name="next">
                 		</f:facet>
                 		<f:facet name="next_disabled">
                 		</f:facet>
                 		<f:facet name="pages">
                 		</f:facet>
                 	</rich:datascroller>
                 </f:facet>              
             </rich:dataTable>
             </h:form>
             </a4j:region>
    		</ui:define>
		</ui:composition>
	</body>
</html>	
</f:view>
</jsp:root>	