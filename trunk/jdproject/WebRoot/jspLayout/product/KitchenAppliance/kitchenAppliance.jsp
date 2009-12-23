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
    <title>产品浏览</title>
    </head>
    <body>
    	<ui:composition template="../productTemplate.jsp">
    		<ui:define id="kitchenApplianceLeft" name="left">
    			<ui:include id="kitchenApplianceLeftInclude" src="../navigationProductRight.jsp">
    			</ui:include>
    		</ui:define>
    		<ui:define id="kitchenApplianceSearchNavigation" name="productSearchNavigation">
				<a4j:region id="kitchenApplianceSearchNavigationRegion" renderRegionOnly="false" selfRendered="true">
    			<h:form id="kitchenApplianceSearchNavigationRegionForm">
    			<rich:panelBar id="kitchenAppliancepb" styleClass="panel-bar-product-top" contentStyle="background:none;">
    				<rich:panelBarItem id="kitchenAppliancePbi" headerClass="navigation-product-top-panel-bar-item-header">
    				<f:facet name="label">
    					<h:outputText value="商品筛选" styleClass="navigation-product-top-panel-bar-item-header-label"></h:outputText>
    				</f:facet>
						<ui:include id="phoneinp12" src="./navigationTopKitchenAppliance.jsp">
							<ui:param name="brands" value="#{navigationKitchenAppliance.brandCodeItems}" />
							<ui:param name="secondCategorys" value="#{navigationKitchenAppliance.secondCategoryCodeList}" />
						</ui:include>
					</rich:panelBarItem>
				</rich:panelBar>
				</h:form>
			</a4j:region>
			</ui:define>
			<ui:define id="kitchenApplianceContent" name="content">
    			<h:panelGrid columns="1" style="width:100%;" styleClass="table-row">
    			<a4j:region id="kitchenApplianceContentRegionStyle" renderRegionOnly="false" selfRendered="true">
    				<h:form id="kitchenApplianceContentRegionStyleForm">
    					<rich:panel id="kitchenApplianceContentRegionStyleFormPanel" styleClass="operate_title">
    						<h:panelGrid columns="2" style="width:80%;">
    							<h:panelGroup>
            					<h:outputText value="显示方式"></h:outputText>
            					<h:graphicImage value="/css/images/icons/list.gif" style="border:0;vertical-align: middle;"></h:graphicImage>
								<h:outputText value="        "></h:outputText>
								<a4j:commandLink id="imgbutton" reRender="kitchenApplianceContentRegionStyleFormPanel,productList">
									<h:graphicImage value="/css/images/i_img#{listKitchenApplianceProduct.styleImg}.gif" style="border:0;width:20px;height:17px;vertical-align: middle;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="_on" assignTo="#{listKitchenApplianceProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="" assignTo="#{listKitchenApplianceProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="" assignTo="#{listKitchenApplianceProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
								<a4j:commandLink id="imgfontbutton" reRender="kitchenApplianceContentRegionStyleFormPanel,productList">
									<h:graphicImage value="/css/images/i_imgfont#{listKitchenApplianceProduct.styleImgFont}.gif" style="border:0;width:20px;height:17px;vertical-align: middle;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="" assignTo="#{listKitchenApplianceProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="_on" assignTo="#{listKitchenApplianceProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="" assignTo="#{listKitchenApplianceProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
								<a4j:commandLink id="fontbutton" reRender="kitchenApplianceContentRegionStyleFormPanel,productList">
									<h:graphicImage value="/css/images/i_font#{listKitchenApplianceProduct.styleFont}.gif" style="border:0;width:20px;height:17px;vertical-align: middle;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="" assignTo="#{listKitchenApplianceProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="" assignTo="#{listKitchenApplianceProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="_on" assignTo="#{listKitchenApplianceProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
							</h:panelGroup>
							<h:panelGroup>
									<h:outputText value="每页显示数量" style="vertical-align: middle;"></h:outputText>
									<h:graphicImage value="/css/images/icons/list.gif" style="border:0;vertical-align: middle;"></h:graphicImage>
									<h:outputText value="        "></h:outputText>
									<a4j:commandLink id="number15button" reRender="kitchenApplianceContentRegionStyleFormPanel,productList">
										<h:graphicImage value="/css/images/number15#{listKitchenApplianceProduct.number15}.gif" style="border:0;width:20px;height:17px;vertical-align: middle;">
										</h:graphicImage>
										<a4j:actionparam name="number15" value="_on" assignTo="#{listKitchenApplianceProduct.number15}"></a4j:actionparam>
										<a4j:actionparam name="number30" value="" assignTo="#{listKitchenApplianceProduct.number30}"></a4j:actionparam>
										<a4j:actionparam name="number60" value="" assignTo="#{listKitchenApplianceProduct.number60}"></a4j:actionparam>
										<a4j:actionparam name="number90" value="" assignTo="#{listKitchenApplianceProduct.number90}"></a4j:actionparam>
										<a4j:actionparam name="numberOnePage" value="15" assignTo="#{listKitchenApplianceProduct.numberOnePage}"></a4j:actionparam>
								    </a4j:commandLink>
									<a4j:commandLink id="number30button" reRender="kitchenApplianceContentRegionStyleFormPanel,productList">
										<h:graphicImage value="/css/images/number30#{listKitchenApplianceProduct.number30}.gif" style="border:0;width:20px;height:17px;vertical-align: middle;">
										</h:graphicImage>
										<a4j:actionparam name="number15" value="" assignTo="#{listKitchenApplianceProduct.number15}"></a4j:actionparam>
										<a4j:actionparam name="number30" value="_on" assignTo="#{listKitchenApplianceProduct.number30}"></a4j:actionparam>
										<a4j:actionparam name="number60" value="" assignTo="#{listKitchenApplianceProduct.number60}"></a4j:actionparam>
										<a4j:actionparam name="number90" value="" assignTo="#{listKitchenApplianceProduct.number90}"></a4j:actionparam>
										<a4j:actionparam name="numberOnePage" value="30" assignTo="#{listKitchenApplianceProduct.numberOnePage}"></a4j:actionparam>
								    </a4j:commandLink>
									<a4j:commandLink id="number60button" reRender="kitchenApplianceContentRegionStyleFormPanel,productList">
										<h:graphicImage value="/css/images/number60#{listKitchenApplianceProduct.number60}.gif" style="border:0;width:20px;height:17px;vertical-align: middle;">
										</h:graphicImage>
										<a4j:actionparam name="number15" value="" assignTo="#{listKitchenApplianceProduct.number15}"></a4j:actionparam>
										<a4j:actionparam name="number30" value="" assignTo="#{listKitchenApplianceProduct.number30}"></a4j:actionparam>
										<a4j:actionparam name="number60" value="_on" assignTo="#{listKitchenApplianceProduct.number60}"></a4j:actionparam>
										<a4j:actionparam name="number90" value="" assignTo="#{listKitchenApplianceProduct.number90}"></a4j:actionparam>
										<a4j:actionparam name="numberOnePage" value="60" assignTo="#{listKitchenApplianceProduct.numberOnePage}"></a4j:actionparam>
								    </a4j:commandLink>
									<a4j:commandLink id="number90button" reRender="kitchenApplianceContentRegionStyleFormPanel,productList">
										<h:graphicImage value="/css/images/number90#{listKitchenApplianceProduct.number90}.gif" style="border:0;width:20px;height:17px;vertical-align: middle;">
										</h:graphicImage>
										<a4j:actionparam name="number15" value="" assignTo="#{listKitchenApplianceProduct.number15}"></a4j:actionparam>
										<a4j:actionparam name="number30" value="" assignTo="#{listKitchenApplianceProduct.number30}"></a4j:actionparam>
										<a4j:actionparam name="number60" value="" assignTo="#{listKitchenApplianceProduct.number60}"></a4j:actionparam>
										<a4j:actionparam name="number90" value="_on" assignTo="#{listKitchenApplianceProduct.number90}"></a4j:actionparam>
										<a4j:actionparam name="numberOnePage" value="90" assignTo="#{listKitchenApplianceProduct.numberOnePage}"></a4j:actionparam>
								    </a4j:commandLink>
									
							</h:panelGroup>
							</h:panelGrid>
        				</rich:panel>
    				</h:form>
    			</a4j:region>
    			<a4j:region id="kitchenApplianceContentRegionContent" renderRegionOnly="false" selfRendered="true">
    			<h:form id="kitchenApplianceContentRegionContentForm">
    			<h:panelGrid id="productList" columns="1" style="width:100%;" styleClass="table-list-product-panel-grid">
    			<h:outputText value="抱歉，找不到符合条件的商品!" rendered="#{not (listKitchenApplianceProduct.dataModel.rowCount>0)}" styleClass="no-product-find"></h:outputText>
    			<rich:dataGrid id="productListImg" headerClass="table-list-product-panel-grid-header" footerClass="table-list-product-panel-grid-footer" width="100%" columns="3" elements="#{listKitchenApplianceProduct.numberOnePage}" cellspacing="0" cellpadding="10" first="1" columnClasses="table-list-product-panel-grid-column" value="#{listKitchenApplianceProduct.dataModel}" var="product" rendered="#{listKitchenApplianceProduct.styleImgFlag}" frame="void" border="0" align="center" styleClass="table-list-product-panel-grid-data-grid">            
                 <f:facet name="header">
                 	<h:outputText value="共:#{listKitchenApplianceProduct.dataModel.rowCount}件商品" rendered="#{listKitchenApplianceProduct.dataModel.rowCount>0}"></h:outputText>
      			 </f:facet>
     				
                 <rich:panel style="border:0px;">
                 	<h:panelGrid columns="1" rowClasses="show-product-data-grid-row-one,show-product-data-grid-row-two,show-product-data-grid-row-three,show-product-data-grid-row-four,show-product-data-grid-row-five,show-product-data-grid-row-six,show-product-data-grid-row-seven">  
                 	 <h:graphicImage value="/productimage/#{product.imageName}"></h:graphicImage>
                 	 <h:panelGroup>
                 	 <h:outputText value="#{product.brandCode}"/>
                     <h:outputText value="#{product.name}"/>
                     <h:outputText value="#{product.description}" style="color:red;"/>
                     </h:panelGroup>
                     <h:outputText value="商品编号:#{product.code}"/>
                     
                     <h:panelGroup><h:outputLabel value="进货价:" rendered="#{currentUser.showPurchasePrice}"></h:outputLabel><h:outputText value="#{product.purchasePrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showPurchasePrice}"/></h:panelGroup>
                     <h:panelGroup><h:outputLabel value="代理价:" rendered="#{currentUser.showTradePriceOne}"></h:outputLabel><h:outputText value="#{product.tradePriceOne}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceOne}"/></h:panelGroup>
                     <h:panelGroup><h:outputLabel value="经销价:" rendered="#{currentUser.showTradePriceTwo}"></h:outputLabel><h:outputText value="#{product.tradePriceTwo}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceTwo}"/></h:panelGroup>
                     <h:panelGroup><h:outputLabel value="零售价:" rendered="#{currentUser.showRetailPrice}"></h:outputLabel><h:outputText value="#{product.retailPrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showRetailPrice}"/></h:panelGroup>
                     </h:panelGrid>
                 </rich:panel>
                   
                 <f:facet name="footer">
                 	<h:panelGroup>
                 		<rich:datascroller for="productListImg" id="dcFooterProductList" page="#{listKitchenApplianceProduct.scrollerPage}" pageIndexVar="currentPage" pagesVar="totalPages" maxPages="10" rendered="#{listKitchenApplianceProduct.dataModel.rowCount>0}" style="width:483px;align:center">
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
             
             
            
         
				<h:panelGroup id="productListImgFont" rendered="#{listKitchenApplianceProduct.styleImgFontFlag}">
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
                <a4j:repeat value="#{listKitchenApplianceProduct.dataModel}" var="product" rowKeyVar="index">
                <tr>
                	<td>
                    <h:outputText value="#{product.code}" /></td>
                    <td><h:outputText value="#{product.name}" /></td>
                    <td><h:outputText value="#{product.brandCode}"></h:outputText></td>
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
             <rich:dataList value="#{listKitchenApplianceProduct.dataModel}" var="product" rowKeyVar="index" rows="20" rendered="#{listKitchenApplianceProduct.styleFontFlag}">
             	<h:panelGrid columns="5" style="width:100%;font:10px;" columnClasses="table-list-product-column,table-list-product-column,table-list-product-column,table-list-product-column,table-list-product-column">
             	<h:outputText value="#{product.code}" />
                <h:outputText value="#{product.name}" />
                <h:outputText value="#{product.brandCode}"></h:outputText>
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