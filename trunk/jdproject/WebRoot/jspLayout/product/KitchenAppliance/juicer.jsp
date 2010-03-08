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
    		<ui:define id="juicerLeft" name="left">
    			<ui:include id="juicerLeftInclude" src="../navigationProductLeft.jsp">
    				<ui:param name="currentPrimaryCategory" value="kitchenAppliance"/>
    			</ui:include>
    		</ui:define>
    		
			<ui:define id="juicerContent" name="content">
				<a4j:region id="juicerSearchNavigationRegion" renderRegionOnly="false" selfRendered="true">
    			<h:form id="juicerSearchNavigationRegionForm">
    			<rich:panelBar id="juicerpb" styleClass="panel-none-border" headerClass="panel-header-none-border" style="width:#{msgs['template.product.content.widthpx']};border-style:none;" contentStyle="panel-documents-none-border">
    				<rich:panelBarItem id="juicerPbi" headerClass="navigation-product-top-panel-bar-item-header">
    				<f:facet name="label">
    					<h:panelGroup>
    						<h:outputText value="商品筛选" styleClass="navigation-product-top-panel-bar-item-header-label"></h:outputText>
    					</h:panelGroup>
    				</f:facet>
						<ui:include id="phoneinp12" src="./SubJuicer/navigationTopJuicer.jsp">
							<ui:param name="brands" value="#{navigationJuicer.brandCodeItems}" />
							<ui:param name="priceRangeList" value="#{navigationJuicer.priceRangeList}"/>
						</ui:include>
					</rich:panelBarItem>
				</rich:panelBar>
				</h:form>
				</a4j:region>
    			<h:panelGrid columns="1" style="width:100%" cellspacing="0" cellpadding="0" styleClass="table-row">
    			<a4j:region id="juicerContentRegionStyle" renderRegionOnly="false" selfRendered="true">
    				<h:form id="juicerContentRegionStyleForm">
    					<rich:panel id="juicerContentRegionStyleFormPanel" styleClass="panel-none-border" headerClass="panel-header-none-border" bodyClass="operate-show-style">
    						<h:panelGrid columns="1" style="width:80%;" columnClasses="operate-show-style-column-one">
    						<h:panelGroup>
            					<h:outputText value="显示方式" style="vertical-align: middle;padding-right:6px;"></h:outputText>
            					<h:graphicImage value="/css/images/icons/list.gif" style="border:0;vertical-align: middle;"></h:graphicImage>
								<h:outputText value="        "></h:outputText>
								<a4j:commandLink id="imgbutton" reRender="juicerContentRegionStyleFormPanel,productList">
									<h:graphicImage value="/css/images/i_img#{listJuicerProduct.styleImg}.gif" style="border:0;width:18px;height:18px;vertical-align: middle;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="_on" assignTo="#{listJuicerProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="" assignTo="#{listJuicerProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="" assignTo="#{listJuicerProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
								<a4j:commandLink id="imgfontbutton" reRender="juicerContentRegionStyleFormPanel,productList">
									<h:graphicImage value="/css/images/i_imgfont#{listJuicerProduct.styleImgFont}.gif" style="border:0;width:18px;height:18px;vertical-align: middle;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="" assignTo="#{listJuicerProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="_on" assignTo="#{listJuicerProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="" assignTo="#{listJuicerProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
								<a4j:commandLink id="fontbutton" reRender="juicerContentRegionStyleFormPanel,productList">
									<h:graphicImage value="/css/images/i_font#{listJuicerProduct.styleFont}.gif" style="border:0;width:18px;height:18px;vertical-align: middle;">
									</h:graphicImage>
									<a4j:actionparam name="styleImg" value="" assignTo="#{listJuicerProduct.styleImg}"></a4j:actionparam>
									<a4j:actionparam name="styleImgFont" value="" assignTo="#{listJuicerProduct.styleImgFont}"></a4j:actionparam>
									<a4j:actionparam name="styleFont" value="_on" assignTo="#{listJuicerProduct.styleFont}"></a4j:actionparam>
								</a4j:commandLink>
							
									<h:outputText value="每页显示数量" style="vertical-align: middle;padding-left:88px;"></h:outputText>
									<h:graphicImage value="/css/images/icons/list.gif" style="border:0;vertical-align: middle;"></h:graphicImage>
									<h:outputText value="        "></h:outputText>
									<a4j:commandLink id="number15button" reRender="juicerContentRegionStyleFormPanel,productList">
										<h:graphicImage value="/css/images/number15#{listJuicerProduct.number10}.gif" style="border:0;width:18px;height:18px;vertical-align: middle;">
										</h:graphicImage>
										<a4j:actionparam name="number10" value="_on" assignTo="#{listJuicerProduct.number10}"></a4j:actionparam>
										<a4j:actionparam name="number20" value="" assignTo="#{listJuicerProduct.number20}"></a4j:actionparam>
										<a4j:actionparam name="number40" value="" assignTo="#{listJuicerProduct.number40}"></a4j:actionparam>
										<a4j:actionparam name="number100" value="" assignTo="#{listJuicerProduct.number100}"></a4j:actionparam>
										<a4j:actionparam name="numberOnePage" value="15" assignTo="#{listJuicerProduct.numberOnePage}"></a4j:actionparam>
								    </a4j:commandLink>
									<a4j:commandLink id="number30button" reRender="juicerContentRegionStyleFormPanel,productList">
										<h:graphicImage value="/css/images/number30#{listJuicerProduct.number20}.gif" style="border:0;width:18px;height:18px;vertical-align: middle;">
										</h:graphicImage>
										<a4j:actionparam name="number10" value="" assignTo="#{listJuicerProduct.number10}"></a4j:actionparam>
										<a4j:actionparam name="number20" value="_on" assignTo="#{listJuicerProduct.number20}"></a4j:actionparam>
										<a4j:actionparam name="number40" value="" assignTo="#{listJuicerProduct.number40}"></a4j:actionparam>
										<a4j:actionparam name="number100" value="" assignTo="#{listJuicerProduct.number100}"></a4j:actionparam>
										<a4j:actionparam name="numberOnePage" value="30" assignTo="#{listJuicerProduct.numberOnePage}"></a4j:actionparam>
								    </a4j:commandLink>
									<a4j:commandLink id="number60button" reRender="juicerContentRegionStyleFormPanel,productList">
										<h:graphicImage value="/css/images/number60#{listJuicerProduct.number40}.gif" style="border:0;width:18px;height:18px;vertical-align: middle;">
										</h:graphicImage>
										<a4j:actionparam name="number10" value="" assignTo="#{listJuicerProduct.number10}"></a4j:actionparam>
										<a4j:actionparam name="number20" value="" assignTo="#{listJuicerProduct.number20}"></a4j:actionparam>
										<a4j:actionparam name="number40" value="_on" assignTo="#{listJuicerProduct.number40}"></a4j:actionparam>
										<a4j:actionparam name="number100" value="" assignTo="#{listJuicerProduct.number100}"></a4j:actionparam>
										<a4j:actionparam name="numberOnePage" value="45" assignTo="#{listJuicerProduct.numberOnePage}"></a4j:actionparam>
								    </a4j:commandLink>
									<a4j:commandLink id="number90button" reRender="juicerContentRegionStyleFormPanel,productList">
										<h:graphicImage value="/css/images/number90#{listJuicerProduct.number100}.gif" style="border:0;width:18px;height:18px;vertical-align: middle;">
										</h:graphicImage>
										<a4j:actionparam name="number10" value="" assignTo="#{listJuicerProduct.number10}"></a4j:actionparam>
										<a4j:actionparam name="number20" value="" assignTo="#{listJuicerProduct.number20}"></a4j:actionparam>
										<a4j:actionparam name="number40" value="" assignTo="#{listJuicerProduct.number40}"></a4j:actionparam>
										<a4j:actionparam name="number100" value="_on" assignTo="#{listJuicerProduct.number100}"></a4j:actionparam>
										<a4j:actionparam name="numberOnePage" value="90" assignTo="#{listJuicerProduct.numberOnePage}"></a4j:actionparam>
								    </a4j:commandLink>
									
							</h:panelGroup>
							</h:panelGrid>
        				</rich:panel>
    				</h:form>
    			</a4j:region>
    			<a4j:region id="juicerContentRegionContent" renderRegionOnly="false" selfRendered="true">
    			<h:form id="juicerContentRegionContentForm">
    			<h:panelGrid id="productList" columns="1" style="width:100%"  cellspacing="0" cellpadding="0" styleClass="table-list-product-panel-grid" rowClasses="table-list-product-panel-grid-main-column">
    			<h:outputText value="抱歉，找不到符合条件的商品!" rendered="#{(null != listJuicerProduct.dataModel) and (listJuicerProduct.dataModel.rowCount le 0)}" styleClass="no-product-find"></h:outputText>
    			<rich:dataGrid id="productListImg" rendered="#{listJuicerProduct.styleImgFlag}" headerClass="table-list-product-panel-grid-header" footerClass="table-list-product-panel-grid-footer" width="100%" columns="3" elements="#{listJuicerProduct.numberOnePage}" cellspacing="0" cellpadding="0" first="1" columnClasses="table-list-product-panel-grid-column" value="#{listJuicerProduct.dataModel}" var="product" rowKeyVar="rowIndex" frame="void" border="0" align="center" styleClass="table-list-product-panel-grid-data-grid">            
                <f:facet name="header">
                	<h:panelGroup>
                		<h:outputText value="产品列表(共有:#{listJuicerProduct.dataModel.rowCount}件商品)" rendered="#{listJuicerProduct.dataModel.rowCount>0}"></h:outputText>
                	</h:panelGroup>
      			</f:facet>
     				<a4j:region renderRegionOnly="false" selfRendered="true">
                 	<rich:panel styleClass="show-product-data-grid-panel">
                 	<h:panelGrid columns="1">  
                 		
                 		<h:outputLabel value="#{rowIndex+1}" styleClass="current-product-show-number"></h:outputLabel>
                 		<h:graphicImage value="/productimage/#{product.imageName}"></h:graphicImage>
                 		<h:panelGrid columns="1" rowClasses="show-product-data-grid-row-two,show-product-data-grid-row-three,show-product-data-grid-row-four,show-product-data-grid-row-five,show-product-data-grid-row-six,show-product-data-grid-row-seven,show-product-data-grid-row-eight">
                 	 	<h:commandLink action="#{productGlobalNavigation.seeProductDetail}" immediate="true">
                 	 		<f:param name="productid" value="#{product.id}"></f:param>
                 	 	<h:panelGroup styleClass="font6">
                 	 	<h:outputText value="#{product.brandCode}"/>
                     	<h:outputText value="#{product.name}"/>
                     	<h:outputText value="#{product.description}" style="color:red;"/>
                     	</h:panelGroup>
						</h:commandLink>
                     	<h:outputText value="商品编号:#{product.code}" styleClass="gray"/>
                     
                     	<h:panelGroup><h:outputLabel value="进货价:" rendered="#{currentUser.showPurchasePrice}"></h:outputLabel><h:outputText value="#{product.purchasePrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showPurchasePrice}"/></h:panelGroup>
                     	<h:panelGroup><h:outputLabel value="代理价:" rendered="#{currentUser.showTradePriceOne}"></h:outputLabel><h:outputText value="#{product.tradePriceOne}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceOne}"/></h:panelGroup>
                     	<h:panelGroup><h:outputLabel value="经销价:" rendered="#{currentUser.showTradePriceTwo}"></h:outputLabel><h:outputText value="#{product.tradePriceTwo}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceTwo}"/></h:panelGroup>
                     	<h:panelGroup><h:outputLabel value="零售价:" rendered="#{currentUser.showRetailPrice}"></h:outputLabel><h:outputText value="#{product.retailPrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showRetailPrice}"/></h:panelGroup>
                     	<h:panelGroup>
                     	<a4j:commandButton image="/css/images/icons/buttons-buy.gif" action="#{shopCart.addInventoryItem}"><a4j:actionparam name="productCode" value="#{product.code}"/></a4j:commandButton>
                     	<a4j:commandButton image="/css/images/icons/buttons-collect.gif" action="#{shopCart.addInventoryItem}"><a4j:actionparam name="productCode" value="#{product.code}"/></a4j:commandButton>
                     	<a4j:status>
                			<f:facet name="start">
                    			<h:graphicImage  value="/css/images/icons/blue-loading.gif"/>
               			 	</f:facet>
            			</a4j:status>
                     	</h:panelGroup>
                     	</h:panelGrid>
                    </h:panelGrid>
                 	</rich:panel>
                 	<rich:separator lineType="dotted" height="1px"/>
                    </a4j:region>
                 	<f:facet name="footer">
                 	<h:panelGroup>
                 		<rich:datascroller for="productListImg" id="dcFooterProductList" page="#{listJuicerProduct.scrollerPage}" pageIndexVar="currentPage" pagesVar="totalPages" maxPages="10" rendered="#{listJuicerProduct.dataModel.rowCount>0}" style="width:483px;align:center">
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
             	
             	<rich:dataGrid id="productListImgFont" rendered="#{listJuicerProduct.styleImgFontFlag}" headerClass="table-list-product-panel-grid-header" footerClass="table-list-product-panel-grid-footer" width="100%" columns="1" elements="#{listJuicerProduct.numberOnePage}" cellspacing="0" cellpadding="10" first="1" rowClasses="show-image-font-product-data-grid-row-one,show-image-font-product-data-grid-row-two" columnClasses="table-list-product-panel-grid-column" value="#{listJuicerProduct.dataModel}" var="product" rowKeyVar="rowIndex" frame="void" border="0" align="center" styleClass="table-list-product-panel-grid-data-grid">            
                <f:facet name="header">
                	<h:panelGroup>
                		<h:outputText value="产品列表(共有:#{listJuicerProduct.dataModel.rowCount}件商品)" rendered="#{listJuicerProduct.dataModel.rowCount>0}"></h:outputText>
                	</h:panelGroup>
      			</f:facet>
     				<a4j:region renderRegionOnly="false" selfRendered="true">
                 	<rich:panel styleClass="show-product-data-grid-panel-auto-height">
                 	<h:panelGrid columns="3" columnClasses="show-image-font-product-data-grid-column-one,show-image-font-product-data-grid-column-two,show-image-font-product-data-grid-column-three">  
                 		<h:panelGrid columns="1">
                 		<h:outputLabel value="#{rowIndex+1}" styleClass="current-product-show-number"></h:outputLabel>
                 		<h:graphicImage value="/productimage/#{product.imageName}"></h:graphicImage>
                 		<h:outputText value="商品编号:#{product.code}" styleClass="gray"/>
                 		</h:panelGrid>
                 	 	<h:panelGrid columns="1">
                 	 	<h:panelGroup styleClass="font6">
                 	 	<h:outputText value="#{product.brandCode}"/>
                     	<h:outputText value="#{product.name}"/>
                     	<h:outputText value="#{product.description}" style="font-weight:bold;color:red;"/>
                     	</h:panelGroup>
                     	<h:panelGroup styleClass="gray">
                     	<h:outputLabel value="进货价:" rendered="#{currentUser.showPurchasePrice}"></h:outputLabel><h:outputText value="#{product.purchasePrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showPurchasePrice}"/>
                     	<h:outputLabel value="代理价:" rendered="#{currentUser.showTradePriceOne}"></h:outputLabel><h:outputText value="#{product.tradePriceOne}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceOne}"/>
                     	<h:outputLabel value="经销价:" rendered="#{currentUser.showTradePriceTwo}"></h:outputLabel><h:outputText value="#{product.tradePriceTwo}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceTwo}"/>
                     	<h:outputLabel value="零售价:" rendered="#{currentUser.showRetailPrice}"></h:outputLabel><h:outputText value="#{product.retailPrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showRetailPrice}"/>
                     	</h:panelGroup>
                     	</h:panelGrid>
                     	<h:panelGroup>
                     	<a4j:commandButton image="/css/images/icons/buttons-buy.gif" action="#{shopCart.addInventoryItem}"><a4j:actionparam name="productCode" value="#{product.code}"/></a4j:commandButton>
                     	<a4j:status>
                			<f:facet name="start">
                    			<h:graphicImage  value="/css/images/icons/blue-loading.gif"/>
               			 	</f:facet>
            			</a4j:status>
                     	</h:panelGroup>
                    </h:panelGrid>
                 	</rich:panel>
                 	<rich:separator lineType="dotted" height="1px"/>
                 	</a4j:region>
                 	<f:facet name="footer">
                 	<h:panelGroup>
                 		<rich:datascroller for="productListImgFont" id="imgFontFooterProductList" page="#{listJuicerProduct.scrollerPage}" pageIndexVar="currentPage" pagesVar="totalPages" maxPages="10" rendered="#{listJuicerProduct.dataModel.rowCount>0}" style="width:483px;align:center">
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
             	
				<rich:dataGrid id="productListFont" rendered="#{listJuicerProduct.styleFontFlag}" headerClass="table-list-product-panel-grid-header" footerClass="table-list-product-panel-grid-footer" width="100%" columns="1" elements="#{listJuicerProduct.numberOnePage}" cellspacing="0" cellpadding="10" first="1" rowClasses="show-font-product-data-grid-row-one,show-font-product-data-grid-row-two" columnClasses="table-list-product-panel-grid-column" value="#{listJuicerProduct.dataModel}" var="product" rowKeyVar="rowIndex" frame="void" border="0" align="center" styleClass="table-list-product-panel-grid-data-grid">            
                <f:facet name="header">
                	<h:panelGroup>
                		<h:outputText value="产品列表(共有:#{listJuicerProduct.dataModel.rowCount}件商品)" rendered="#{listJuicerProduct.dataModel.rowCount>0}"></h:outputText>
                	</h:panelGroup>
      			</f:facet>
     				<a4j:region renderRegionOnly="false" selfRendered="true">
                 	<rich:panel styleClass="show-product-data-grid-panel-auto-height">
                 	<h:panelGrid columns="4" columnClasses="show-font-product-data-grid-column-one,show-font-product-data-grid-column-two,show-font-product-data-grid-column-three,show-font-product-data-grid-column-four">  
                 		<h:panelGrid columns="1">
						<h:panelGroup>
                 			<h:outputLabel value="#{rowIndex+1}" styleClass="current-product-show-number"></h:outputLabel>
                 			<h:outputText value="  商品编号:#{product.code}" styleClass="gray"/>
						</h:panelGroup>
                 		</h:panelGrid>
                 	 	<h:panelGroup styleClass="font6_">
                 	 	<h:outputText value="#{product.brandCode}"/>
                     	<h:outputText value="#{product.name}"/>
                     	<h:outputText value="#{product.description}" style="color:red;"/>
                     	</h:panelGroup>
                     	<h:panelGroup styleClass="gray">
                     	<h:outputLabel value="进货价:" rendered="#{currentUser.showPurchasePrice}"></h:outputLabel><h:outputText value="#{product.purchasePrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showPurchasePrice}"/>
                     	<h:outputLabel value="代理价:" rendered="#{currentUser.showTradePriceOne}"></h:outputLabel><h:outputText value="#{product.tradePriceOne}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceOne}"/>
                     	<h:outputLabel value="经销价:" rendered="#{currentUser.showTradePriceTwo}"></h:outputLabel><h:outputText value="#{product.tradePriceTwo}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceTwo}"/>
                     	<h:outputLabel value="零售价:" rendered="#{currentUser.showRetailPrice}"></h:outputLabel><h:outputText value="#{product.retailPrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showRetailPrice}"/>
                     	</h:panelGroup>
                     	<h:panelGroup>
                     	<a4j:commandButton image="/css/images/icons/buttons-buy.gif" action="#{shopCart.addInventoryItem}"><a4j:actionparam name="productCode" value="#{product.code}"/></a4j:commandButton>
                     	<a4j:status>
                			<f:facet name="start">
                    			<h:graphicImage  value="/css/images/icons/blue-loading.gif"/>
               			 	</f:facet>
            			</a4j:status>
                     	</h:panelGroup>
                    </h:panelGrid>
                 	</rich:panel>
                 	<rich:separator lineType="dotted" height="1px"/>
                 	</a4j:region>
                 	<f:facet name="footer">
                 	<h:panelGroup>
                 		<rich:datascroller for="productListFont" id="FontFooterProductList" page="#{listJuicerProduct.scrollerPage}" pageIndexVar="currentPage" pagesVar="totalPages" maxPages="10" rendered="#{listJuicerProduct.dataModel.rowCount>0}" style="width:483px;align:center">
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
             
             </h:panelGrid>
             </h:form>
             </a4j:region>
             </h:panelGrid>
    		</ui:define>
    		<ui:define id="juicerRight" name="right">
    			<h:outputText value=""></h:outputText>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	