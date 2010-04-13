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
    <title>定单信息确认</title>
    </head>
    <body>
    	<ui:composition template="./shoppingTemplate.jsp">
    		
    		<ui:define id="productStepDisplayOfGenerateOrder" name="productStepDisplay">
    			<a4j:outputPanel style="font-size:12px;">
    				
    			</a4j:outputPanel>
			</ui:define>
    		<ui:define id="contentHeader" name="contentHeader">
    				<h:outputText value="核对订单并确认"></h:outputText>
			</ui:define>
			<ui:define id="shoppingCartContent" name="content">
			<h:form>
				<a4j:region id="shoppingCartDataTableRegion" renderRegionOnly="false" selfRendered="true">
				<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border-none-padding">
					<f:facet name="header">
						<h:panelGrid columns="3" style="align:left"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
								<h:outputText value="" style="width:4px"></h:outputText>
								<h:panelGroup>
									<h:outputText value="请确认以下信息，然后提交订单"></h:outputText>
								</h:panelGroup>
								<h:outputText value="" style="width:4px"></h:outputText>
							</h:panelGrid>	
					</f:facet>
					<a4j:outputPanel id="viewAddress">
						<h:panelGrid columns="2">
							<f:facet name="header"><h:panelGroup><h:outputText value="收货人信息"></h:outputText><h:commandLink><h:outputText value="[修改]"/></h:commandLink><h:commandLink><h:outputText value="[选择其它]"/></h:commandLink></h:panelGroup></f:facet>
							<h:outputText value="收货联系人"></h:outputText><h:outputText value="#{generateOrderPage.consigneeName}"></h:outputText>
							<h:outputText value="手机"></h:outputText><h:outputText value="#{generateOrderPage.consigneeMobile}"></h:outputText>
							<h:outputText value="联系电话"></h:outputText><h:outputText value="#{generateOrderPage.consigneePhone}"></h:outputText>
							<h:outputText value="地区"></h:outputText><h:outputText value="#{generateOrderPage.consigneeProvince}"></h:outputText>
							<h:outputText value="联系地址"></h:outputText><h:outputText value="#{generateOrderPage.consigneeAddress}"></h:outputText>
							<h:outputText value="邮编"></h:outputText><h:outputText value="#{generateOrderPage.consigneeZip}"></h:outputText>
						</h:panelGrid>
					</a4j:outputPanel>
					<a4j:outputPanel id="editAddress">
					</a4j:outputPanel>
				</rich:panel>
				<rich:panel headerClass="panel-header-gray-border-yellow-bg" styleClass="panel-none-border" bodyClass="panel-documents-gray-border-none-padding">
					<f:facet name="header">
						<h:panelGroup>
							<h:outputText value="我要使用优惠券及积分"></h:outputText>
						</h:panelGroup>	
					</f:facet>
					<h:panelGrid columns="2" columnClasses="width-eighty,width-twenty">
						<h:panelGrid columns="3">
							<h:outputText value="优惠券号码"></h:outputText><h:inputText id="shoppingCartCouponsAccount" value="#{shopCart.couponAccount}"></h:inputText><h:panelGroup><h:commandLink action="#{shopCart.selectOneCoupon}" value="使用优惠券" disabled="#{empty shopCart.cart.inventory}" styleClass="button-default-style"><a4j:support event="onclick" reRender="couponErrorMessage"></a4j:support></h:commandLink><h:graphicImage id="couponCheckImage" value="/css/images/icons/IconYes.gif" rendered="#{shopCart.couponChecked}"></h:graphicImage><h:outputText value="本张券面额:#{shopCart.couponScore}元" rendered="#{shopCart.couponChecked}"></h:outputText><h:outputText id="couponErrorMessage" value="#{shopCart.couponErrorMessage}"/></h:panelGroup>
							<h:outputText value="使用积分值"></h:outputText><rich:inputNumberSpinner id="shoppingCartIntegrationScore" value="#{shopCart.integrationScore}" minValue="0" maxValue="#{currentUser.userInfo.integration}" step="1" disabled="#{(empty shopCart.cart.inventory) or !(shopCart.integrationChecked)}" immediate="true"><f:convertNumber pattern="0" /><a4j:support event="onchange" reRender="messageOfUseIntegration,needPaymentAll"></a4j:support></rich:inputNumberSpinner><h:panelGroup><h:commandLink action="#{shopCart.useIntegrationLink}" value="使用积分" rendered="#{!(shopCart.integrationChecked)}" disabled="#{empty shopCart.cart.inventory}" styleClass="button-default-style"></h:commandLink><h:commandLink action="#{shopCart.notUseIntegrationLink}" value="不使用积分" rendered="#{shopCart.integrationChecked}" styleClass="button-default-style"></h:commandLink><h:graphicImage id="integrationCheckImage" value="/css/images/icons/IconYes.gif" rendered="#{shopCart.integrationChecked}"></h:graphicImage><h:outputText id="messageOfUseIntegration" value="您能使用的积分范围是0-#{currentUser.userInfo.integration},当前已使用等值金额为:#{shopCart.integrationScore/10}" rendered="#{shopCart.integrationChecked}"></h:outputText></h:panelGroup>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputText value="商品总额(元)"></h:outputText><h:outputText id="inventoryPriceTotal" value="#{shopCart.cart.inventoryPriceTotal}"><f:convertNumber pattern="###,##0.00"/></h:outputText>
							<h:outputText value="应付总额(元)"></h:outputText><h:outputText id="needPaymentAll" value="#{shopCart.needPayment}"><f:convertNumber pattern="###,##0.00"/></h:outputText>
						</h:panelGrid>
					</h:panelGrid>
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