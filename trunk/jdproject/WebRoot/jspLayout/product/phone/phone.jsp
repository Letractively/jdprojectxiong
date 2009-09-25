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
    		<ui:define id="definecontent" name="content">
				<a4j:region id="phoneregionleft" renderRegionOnly="false" selfRendered="true">
    			<h:form id="phoneleftform">
    			<rich:panelBar id="phonepb" styleClass="panel-bar-product-left" contentStyle="background:none;">
    				<rich:panelBarItem id="phone" headerClass="navigation-panel-bar-item-left-header">
						<f:facet name="label">
							<h:panelGroup layout="block">
							<ui:include id="phoneinp11" src="../productNavigationPanelHeader.jsp" >
								<ui:param name="label" value="#{navigationLeft.phonePrimaryCategoryName}"/>
								
							</ui:include>
							</h:panelGroup>
							
						</f:facet>
						<ui:include id="phoneinp12" src="../productNavigationGroup.jsp" >
 							<ui:param name="brands" value="#{navigationLeft.phoneBrands}" />
							<ui:param name="secondCategorys" value="#{navigationLeft.phoneSecondCategorys}" />
							<ui:param name="prices" value="#{navigationLeft.phonePrices}"/>
							<ui:param name="primaryCategoryId" value="#{navigationLeft.phonePrimaryCategory.id}"/>
							<ui:param name="model" value="phone"/>
 						</ui:include>
					</rich:panelBarItem>
				</rich:panelBar>
				</h:form>
			</a4j:region>
    			<h:panelGrid columns="1" style="width:100%;" styleClass="table-row">
    			<a4j:region id="regioncontentstyle" renderRegionOnly="false" selfRendered="true">
    				<h:form id="phonecontentstyleform">
    					<h:panelGrid style="width:100%" styleClass="operate_title">
    						<rich:panel id="regioncontentstylepanel" style="width:100%;" styleClass="table-list-product-panel-grid-data-grid">
            					<h:outputText value="显示方式"></h:outputText>
            					<h:graphicImage value="/css/images/list.gif" style="border:0">
								</h:graphicImage>
								<a4j:commandLink id="imgbutton" reRender="regioncontentstylepanel,productList">
									<h:graphicImage value="/css/images/i_img#{listPhoneProduct.styleImg}.gif" style="border:0;width:18px;height:15px;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="_on" assignTo="#{listPhoneProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="" assignTo="#{listPhoneProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="" assignTo="#{listPhoneProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
								<a4j:commandLink id="imgfontbutton" reRender="regioncontentstylepanel,productList">
									<h:graphicImage value="/css/images/i_imgfont#{listPhoneProduct.styleImgFont}.gif" style="border:0;width:18px;height:15px;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="" assignTo="#{listPhoneProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="_on" assignTo="#{listPhoneProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="" assignTo="#{listPhoneProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
								<a4j:commandLink id="fontbutton" reRender="regioncontentstylepanel,productList">
									<h:graphicImage value="/css/images/i_font#{listPhoneProduct.styleFont}.gif" style="border:0;width:18px;height:15px;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="" assignTo="#{listPhoneProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="" assignTo="#{listPhoneProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="_on" assignTo="#{listPhoneProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
        					</rich:panel>
    					</h:panelGrid>
    				</h:form>
    			</a4j:region>
    			<a4j:region id="regioncontent" renderRegionOnly="false" selfRendered="true">
    			<h:form id="phonecontentform">
    			<h:panelGrid id="productList" columns="1" style="width:100%;" styleClass="table-list-product-panel-grid">
    			<rich:dataGrid id="productListImg" headerClass="table-list-product-panel-grid-header" footerClass="table-list-product-panel-grid-footer" width="100%" columns="3" elements="10" cellspacing="0" cellpadding="10" first="1" columnClasses="table-list-product-panel-grid-column" value="#{listPhoneProduct.dataModel}" var="product" rendered="#{listPhoneProduct.styleImgFlag}" frame="void" border="0" align="center" styleClass="table-list-product-panel-grid-data-grid">            
                 
     				
                 <rich:panel style="border:0px;">
                 	 <h:graphicImage value="/productimage/#{product.imageName}"></h:graphicImage>
                     <h:outputText value="#{product.code}" />
                     <h:outputText value="#{product.name}" />
                     <h:outputText value="#{product.purchasePrice}" rendered="#{currentUser.showPurchasePrice}"/>
                     <h:outputText value="#{product.tradePriceOne}" rendered="#{currentUser.showTradePriceOne}"/>
                     <h:outputText value="#{product.tradePriceTwo}" rendered="#{currentUser.showTradePriceTwo}"/>
                     <h:outputText value="#{product.retailPrice}" rendered="#{currentUser.showRetailPrice}"/>
                 </rich:panel>
                   
                 <f:facet name="footer">
                 	<h:panelGroup>
                 		<rich:datascroller for="productListImg" id="dcFooterProductList" page="#{listPhoneProduct.scrollerPage}" pageIndexVar="currentPage" pagesVar="totalPages" maxPages="10" style="width:483px;align:center">
                 		<f:facet name="controlSeparator">
                 		</f:facet>
                 		<f:facet name="first">
                 		</f:facet>
                 		<f:facet name="first_disabled">
                 			
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
                 	</h:panelGroup>
                 </f:facet>              
             </rich:dataGrid>
             
             
            
         
				<h:panelGroup id="productListImgFont" rendered="#{listPhoneProduct.styleImgFontFlag}">
				<table>
                <tbody>
        		<thread>
        			<tr>
        			<td>dd</td>
        			<td>eee</td>
        			<td>ff</td>
        			<td>cc</td>
        			</tr>
        		</thread>
                <a4j:repeat value="#{listPhoneProduct.dataModel}" var="product" rowKeyVar="index">
                <tr>
                	<td>
                    <h:outputText value="#{product.code}" /></td>
                    <td><h:outputText value="#{product.name}" /></td>
                    <td><h:outputText value="#{product.brand.brandName}"></h:outputText></td>
                    <td><h:outputText value="#{product.purchasePrice}" rendered="#{currentUser.showPurchasePrice}"/>
                     <h:outputText value="#{product.tradePriceOne}" rendered="#{currentUser.showTradePriceOne}"/>
                     <h:outputText value="#{product.tradePriceTwo}" rendered="#{currentUser.showTradePriceTwo}"/>
                     <h:outputText value="#{product.retailPrice}" rendered="#{currentUser.showRetailPrice}"/>
                   </td>
                   </tr>
                </a4j:repeat>
           		</tbody>
           		</table>
			</h:panelGroup>	
             
             
             <h:panelGroup >
             <rich:dataList value="#{listPhoneProduct.dataModel}" var="product" rowKeyVar="index" rows="20" rendered="#{listPhoneProduct.styleFontFlag}">
             	<h:panelGrid columns="5" style="width:100%;font:10px;" columnClasses="table-list-product-column,table-list-product-column,table-list-product-column,table-list-product-column,table-list-product-column">
             	<h:outputText value="#{product.code}" />
                <h:outputText value="#{product.name}" />
                <h:outputText value="#{product.brand.brandName}"></h:outputText>
                <h:outputText value="#{product.purchasePrice}" rendered="#{currentUser.showPurchasePrice}"/>
                     <h:outputText value="#{product.tradePriceOne}" rendered="#{currentUser.showTradePriceOne}"/>
                     <h:outputText value="#{product.tradePriceTwo}" rendered="#{currentUser.showTradePriceTwo}"/>
                     <h:outputText value="#{product.retailPrice}" rendered="#{currentUser.showRetailPrice}"/>
                <a4j:commandButton value="button"></a4j:commandButton>
                </h:panelGrid>
                <rich:separator/>
             </rich:dataList>
          	 </h:panelGroup>
             
             </h:panelGrid>
             </h:form>
             </a4j:region>
             </h:panelGrid>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	