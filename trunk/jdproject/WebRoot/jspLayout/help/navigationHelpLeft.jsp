<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="subHelpLeftView">
	<h:form id="subHelpLeftViewForm">
		<a4j:region id="subHelpLeftViewFormRegion" renderRegionOnly="false" selfRendered="true">
		<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border-none-padding">
			<f:facet name="header">
				<h:panelGrid columns="3" style="align:left"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
					<h:outputText value="" style="width:4px"></h:outputText>
						<h:panelGroup>
							<h:outputText value="帮助中心" styleClass="header-text-style"></h:outputText>
						</h:panelGroup>
					<h:outputText value="" style="width:4px"></h:outputText>
				</h:panelGrid>	
			</f:facet>
			<rich:panelMenu style="width:100%;" mode="ajax"   expandSingle="false"
			   selectedChild="#{menuState.selectedMenuItem}"  
			   iconExpandedGroup="disc"   
			   iconCollapsedGroup="disc" 
			   iconExpandedTopGroup="chevronUp"   
			   iconGroupTopPosition="right"   
			   iconCollapsedTopGroup="chevronDown">  
			   <rich:panelMenuGroup label="新手上路" id="group1" expanded="true">  
			     <rich:panelMenuItem label="新用户注册" id="group1_item1" 
			         actionListener="#{helpPanelMenu.select}"  
			         action="newCustomerRegister"  
			         mode="server" value="newCustomerRegister.jsp" immediate="true" reRender="maiHelpRegion"/>  
			     <rich:panelMenuItem label="订购流程" id="group1_item2"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="orderFlow"  
			         mode="server" value="orderFlow.jsp" immediate="true" reRender="maiHelpRegion"/>  
			     <rich:panelMenuItem label="商品缺货" id="group1_item3"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="shortageOfGoods"  
			         mode="server" value="shortageOfGoods.jsp" immediate="true" reRender="maiHelpRegion"/>  
			    </rich:panelMenuGroup>  
			    <rich:panelMenuGroup label="帐户及定单信息" id="group2" expanded="true">  
			        <rich:panelMenuItem label="我的助手" id="group2_item1"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="myAssistant"  
			         mode="ajax" value="myAssistant.jsp" immediate="true" reRender="mainHelpRegion"/>  
			     <rich:panelMenuItem label="忘记密码" id="group2_item2"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>  
			     <rich:panelMenuItem label="取消定单" id="group2_item3"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="发票制度" id="group2_item4"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>   
			    </rich:panelMenuGroup>
			    <rich:panelMenuGroup label="付款/退款方式" id="group3" expanded="true">  
			        <rich:panelMenuItem label="货到付款" id="group3_item1"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>  
			     <rich:panelMenuItem label="网上支付" id="group3_item2"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>  
			     <rich:panelMenuItem label="支付宝" id="group3_item3"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="邮局汇款" id="group3_item4"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="银行转账" id="group3_item5"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="帐户余额支付" id="group3_item6"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="退款帮助" id="group3_item7"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			    </rich:panelMenuGroup>
			    <rich:panelMenuGroup label="订单处理与配送" id="group4" expanded="true">  
			        <rich:panelMenuItem label="货到付款开通" id="group4_item1"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>  
			     <rich:panelMenuItem label="订单状态" id="group4_item2"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>  
			     <rich:panelMenuItem label="送货方式" id="group4_item3"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="配送时间" id="group4_item4"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="费收标准" id="group4_item5"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			    </rich:panelMenuGroup>
			    <rich:panelMenuGroup label="商品验货与签收" id="group5" expanded="true">  
			        <rich:panelMenuItem label="商品验货与签收" id="group5_item1"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>  
			    </rich:panelMenuGroup>
			    <rich:panelMenuGroup label="商品验货与签收" id="group6" expanded="true">  
			        <rich:panelMenuItem label="退/换货政策" id="group6_item1"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			         <rich:panelMenuItem label="退/换货流程" id="group6_item2"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/>
			         <rich:panelMenuItem label="补发货流程" id="group6_item3"   
			         actionListener="#{helpPanelMenu.select}"  
			         action="/select.xhtml"  
			         mode="ajax"/> 
			    </rich:panelMenuGroup>
			 </rich:panelMenu>
		</rich:panel>
		</a4j:region>
	</h:form>

</f:subview>
</jsp:root>

