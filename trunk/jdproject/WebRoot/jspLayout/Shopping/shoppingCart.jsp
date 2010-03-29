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
    <title>购物车</title>
    </head>
    <body>
    	<ui:composition template="./shoppingTemplate.jsp">
    		
    		<ui:define id="productStepDisplayOfShoppingCart" name="productStepDisplay">
    			<a4j:outputPanel style="font-size:12px;">
    				<h:outputText value="当前位置 > "></h:outputText><h:outputLink value="${facesContext.externalContext.requestContextPath}/jspLayout/product/productMain.jsf"><h:outputText value="首页"/></h:outputLink><h:outputText value=">我的购物车"></h:outputText>
    			</a4j:outputPanel>
			</ui:define>
    		<ui:define id="contentHeader" name="contentHeader">
    				<h:outputText value="我的购物车"></h:outputText>
			</ui:define>
			<ui:define id="shoppingCartContent" name="content">
			<h:form>
				<a4j:region id="shoppingCartDataTableRegion" renderRegionOnly="false" selfRendered="true">
				<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border-none-padding">
					<f:facet name="header">
						<h:panelGrid columns="3" style="align:left"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
								<h:outputText value="" style="width:4px"></h:outputText>
								<h:panelGroup>
									<h:outputText value="我已挑选的商品"></h:outputText>
								</h:panelGroup>
								<h:outputText value="" style="width:4px"></h:outputText>
							</h:panelGrid>	
					</f:facet>
					<a4j:outputPanel rendered="#{empty shopCart.cart.inventory}" styleClass="orange-text lh3 f14"><h:outputText value="您还没有挑选商品，赶快选择心爱的商品吧！" style="padding-left:300px;padding-right:300px;"></h:outputText></a4j:outputPanel>
					<rich:dataTable id="shoppingCartTable" value="#{shopCart.cart.inventory}" var="inventory" frame="box" columns="9" headerClass="shopping-cart-table-header" rowClasses="table-row-odd,table-row-even" columnClasses="shopping-cart-table-column1,shopping-cart-table-column2,shopping-cart-table-column3,shopping-cart-table-column4,shopping-cart-table-column5,shopping-cart-table-column6,shopping-cart-table-column7,shopping-cart-table-column8" cellpadding="1" cellspacing="1" border="0" sortMode="single" width="100%">
						<rich:column sortable="false" style="width:5%;" label="选择">
							<f:facet name="header"><h:outputText value="选择"/></f:facet>
							<h:selectBooleanCheckbox value="#{inventory.selected}"><a4j:support event="onclick" reRender="deleteAllBtn"/></h:selectBooleanCheckbox>
							<f:facet name="footer"><h:commandLink id="deleteAllBtn" action="#{shopCart.removeMulSelectedFromShoppingCart}" immediate="true" value="删除" styleClass="button-default-style" disabled="#{!(shopCart.cart.haveSelected)}" onclick="return confirm('确认删除购物车中选中的商品吗？');"><a4j:support event="onclick" reRender="shoppingCartTable,goNextStepBtn,clearShoppingCartBtn"></a4j:support></h:commandLink></f:facet>
						</rich:column>
						<rich:column sortable="false" style="width:42%;" label="商品名称">
							<f:facet name="header"><h:outputText value="商品名称"/></f:facet>
							<h:commandLink action="#{productGlobalNavigation.seeProductDetail}" immediate="true"><h:outputText value="#{inventory.name}"></h:outputText><f:param name="productid" value="#{inventory.id}"></f:param></h:commandLink>
						</rich:column>
						<rich:column sortable="false" style="width:8%;" label="销售价格">
							<f:facet name="header"><h:outputText value="销售价格"/></f:facet>
							<h:outputText value="#{inventory.salesPrice}"></h:outputText>
						</rich:column>
						<rich:column sortable="false" style="width:8%;" label="赠送积分">
							<f:facet name="header"><h:outputText value="赠送积分"/></f:facet>
							<h:outputText value="#{inventory.integration}"></h:outputText>
						</rich:column>
						<rich:column sortable="false" style="width:7%;" headerClass="shopping-cart-table-column-header" label="购买数量">
							<f:facet name="header"><h:outputText value="购买数量"/></f:facet>
							<rich:inputNumberSpinner value="#{inventory.salesQuantity}" step="1" minValue="1" maxValue="300" inputSize="1" style="align:center"><a4j:support event="onchange" action="#{shopCart.recalCulateIventory}" reRender="shoppingCartTable"/></rich:inputNumberSpinner>
						</rich:column>
						<rich:column sortable="false" footerClass="align-right" style="width:7%;" label="商品状态">
							<f:facet name="header"><h:outputText value="商品状态"/></f:facet>
							<h:outputText value="现货" rendered="#{inventory.currentNumber > 0}"></h:outputText>
							<h:outputText value="需预定" rendered="#{!(inventory.currentNumber > 0)}"></h:outputText>
							<f:facet name="footer"><h:outputText id="allToatl" value="金额合计:" style="font-weight:bold;"/></f:facet>
						</rich:column>
						<rich:column sortable="false" style="width:7%;" selfSorted="false" footerClass="align-center" label="金额小计">
							<f:facet name="header"><h:outputText value="金额小计"/></f:facet>
							<h:outputText id="subTotal" value="#{inventory.salesQuantity * inventory.salesPrice}"></h:outputText>
							<f:facet name="footer"><h:outputText value="#{shopCart.cart.inventoryPriceTotal}"/></f:facet>
						</rich:column>
						<rich:column sortable="false" style="width:14%;" selfSorted="false" label="单项操作">
							<f:facet name="header"><h:outputText value="单项操作"/></f:facet>
							<h:panelGroup><h:commandLink action="#{shopCart.removeOneSelectedFromShoppingCart}" immediate="true" value="删除" styleClass="button-default-style" onclick="javascript:return confirm('确认删除购物车中该商品吗？');"><a4j:support event="onclick" reRender="shoppingCartTable,goNextStepBtn,clearShoppingCartBtn"></a4j:support><f:param name="selectedProductId" value="#{inventory.id}"/></h:commandLink><a4j:commandLink value="移入收藏夹" styleClass="button-default-style"/></h:panelGroup>
						</rich:column>
					</rich:dataTable>
				</rich:panel>
				<h:panelGrid columns="2" style="width:100%;padding-top: 10px;padding-left: 28px;" headerClass="panel-header-none-border" columnClasses="align-left,align-right" styleClass="panel-none-border">
					<h:panelGroup>
						<h:commandLink value="继续购物" styleClass="ButtonDefault" immediate="true"></h:commandLink>
						<h:commandLink id="clearShoppingCartBtn" action="#{shopCart.clearShoppingCart}" value="清空购物车" disabled="#{empty shopCart.cart.inventory}" styleClass="ButtonDefault" onclick="javascript:return confirm('确认清空购物车中所有的商品吗？');"></h:commandLink>
					</h:panelGroup>
					<h:commandLink id="goNextStepBtn" action="#{shopCart.gotoGenerateOrder}" value="下一步" disabled="#{empty shopCart.cart.inventory}" styleClass="ButtonYellow" immediate="true"><f:param name="comeFrom" value="shoppingCart"></f:param></h:commandLink>
				</h:panelGrid>
				<h:panelGrid columns="1" headerClass="panel-header-none-border" styleClass="panel-none-border">
					<h:outputText value="下单三步曲:"></h:outputText>
					<h:outputText value="第一步：选定需要的商品，点击『购买』按钮进入购物车。如需要多次选购，只需点击『继续购物』即可返回商品页面。选购完毕后请点击『下一步』按钮进入订单结算。"></h:outputText>
					<h:outputText value="第二步：填写并确认收货人信息，选择您需要的付款方式及送货方式，确认无误后点『提交订单』。"></h:outputText>
					<h:outputText value="第三步：支付订单货款，然后等待收货或者自行上门提货。"></h:outputText>
				</h:panelGrid>
			</a4j:region>	
			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	