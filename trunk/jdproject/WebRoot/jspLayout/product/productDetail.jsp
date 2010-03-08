<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<style type="text/css">
        .pic-normal {
            width: 120px;
            border: 2px solid #ACBECE;

        }
        .wrap1 {
            width:190px;
            height: 130px;
            float: left;            
        }
</style>
<f:view>
<html>
	<head>
    <title>产品浏览</title>
    </head>
    <body>
    	<ui:composition template="./productTemplate.jsp">
    		<ui:define id="kitchenApplianceLeft" name="left">
    			<ui:include id="kitchenApplianceLeftInclude" src="./navigationProductLeft.jsp">
    				<ui:param name="currentPrimaryCategory" value="#{productInfo.primaryCategoryLabel}"/>
    			</ui:include>
    		</ui:define>
    		
			<ui:define id="kitchenApplianceContent" name="content">
				<rich:panel style="width:100%" styleClass="panel-none-border" headerClass="panel-header-gray-border" bodyClass="panel-documents-gray-border">
					<f:facet name="header">
						<h:panelGrid columns="3"  cellspacing="0" cellpadding="0" columnClasses="product-detail-panel-grid-header-left,product-detail-panel-grid-header-center,product-detail-panel-grid-header-right">
								<h:outputText value="" style="width:4px"></h:outputText>
								<h:panelGroup>
									<h:outputText value="[#{productInfo.product.brandCode}]#{productInfo.product.name}" styleClass="product-detail-font1"></h:outputText><f:verbatim><br/></f:verbatim>
									<h:outputText value="#{productInfo.product.description}" styleClass="product-detail-font2"></h:outputText>
								</h:panelGroup>
								<h:outputText value="" style="width:4px"></h:outputText>
							</h:panelGrid>	
					</f:facet>
					<h:panelGrid style="width:99%" columns="2" cellspacing="0" cellpadding="0" columnClasses="product-detail-panel-grid-body-column-one,product-detail-panel-grid-body-column-two">
							<a4j:outputPanel>
								<h:graphicImage value="/productimage/#{productInfo.product.imageName}"></h:graphicImage><f:verbatim><br/></f:verbatim>
								<a4j:commandLink style="" action="dd" value="推荐给朋友"></a4j:commandLink>
								<a4j:commandLink style="" action="aa" value="价格纠错"></a4j:commandLink>
							</a4j:outputPanel>
							<h:panelGrid columns="2">
								<h:outputLabel value="商品编号:"></h:outputLabel><h:outputText value="#{productInfo.product.code}"></h:outputText>
								<h:outputLabel value="商品型号:"></h:outputLabel><h:outputText value="#{productInfo.product.manufacturerCode}"></h:outputText>
								<h:outputLabel value="品牌/厂商:"></h:outputLabel><h:outputText value="#{productInfo.product.brandCode} / #{productInfo.product.provider.shortName} "></h:outputText>
								<h:outputLabel value="库存状况:"></h:outputLabel><h:outputText value="#{productInfo.product.currentNumber >0 ? '有货':'无货'}"></h:outputText>
								<h:outputLabel value="积分额度:"></h:outputLabel><h:outputText value="#{productInfo.product.integration}"></h:outputText>
								<h:outputLabel value="进货价:" rendered="#{currentUser.showPurchasePrice}"></h:outputLabel><h:outputText value="#{productInfo.product.purchasePrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showPurchasePrice}"/>
                     			<h:outputLabel value="代理价:" rendered="#{currentUser.showTradePriceOne}"></h:outputLabel><h:outputText value="#{productInfo.product.tradePriceOne}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceOne}"/>
                     			<h:outputLabel value="经销价:" rendered="#{currentUser.showTradePriceTwo}"></h:outputLabel><h:outputText value="#{productInfo.product.tradePriceTwo}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showTradePriceTwo}"/>
                     			<h:outputLabel value="零售价:" rendered="#{currentUser.showRetailPrice}"></h:outputLabel><h:outputText value="#{productInfo.product.retailPrice}" styleClass="show-product-data-grid-price" rendered="#{currentUser.showRetailPrice}"/>
                     			<f:facet name="footer">
                     				<h:panelGroup >
                     					<a4j:commandButton image="/css/images/icons/buynow4.gif"></a4j:commandButton><a4j:commandButton image="/css/images/icons/fav4.gif" style="padding-left:6px;"/>
                     					<h:outputText value="购买后跳转到"></h:outputText>
                     					<h:selectOneMenu value="#{productInfo.goUrlAfterAdd}">
                     						<f:selectItem itemLabel="不跳转" itemValue="none"><a4j:support event="onchange" immediate="true"></a4j:support></f:selectItem>
                     						<f:selectItem itemLabel="回上页" itemValue="goBack"><a4j:support event="onchange" immediate="true"></a4j:support></f:selectItem>
                     						<f:selectItem itemLabel="购物车" itemValue="goShoppingCart"><a4j:support event="onchange" immediate="true"></a4j:support></f:selectItem>
                     						
                     					</h:selectOneMenu>
                     					<h:commandButton action="#{productInfo.preViewId}" value="回"></h:commandButton>
                     				</h:panelGroup>
                     			</f:facet>
							</h:panelGrid>
					</h:panelGrid>
				</rich:panel>
				<rich:panel style="width:100%;padding-top:6px;" styleClass="panel-none-border" headerClass="panel-header-none-border" bodyClass="panel-documents-none-border">
					<ui:include src="/WEB-INF/jspLayout/subProductDetail/#{productInfo.subViewId}" />
			    </rich:panel>
    		</ui:define>
    		<ui:define id="kitchenApplianceRight" name="right">
    			<h:outputText value=""></h:outputText>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	