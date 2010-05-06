<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="subCustomerLeftView">
	<h:form id="subCustomerLeftViewForm">
		<a4j:region id="subCustomerLeftViewFormRegion" renderRegionOnly="false" selfRendered="true">
		<rich:panel headerClass="panel-header-none-border" styleClass="panel-none-border" bodyClass="panel-documents-gray-border-none-padding">
			<f:facet name="header">
				<h:panelGrid columns="3" style="align:left"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
					<h:outputText value="" style="width:4px"></h:outputText>
						<h:panelGroup>
							<h:outputText value="管理中心" styleClass="header-text-style"></h:outputText>
						</h:panelGroup>
					<h:outputText value="" style="width:4px"></h:outputText>
				</h:panelGrid>	
			</f:facet>
			<rich:panelMenu style="width:100%;" mode="ajax"   expandSingle="false"  
			   iconExpandedGroup="disc"   
			   iconCollapsedGroup="disc" 
			   iconExpandedTopGroup="chevronUp"   
			   iconGroupTopPosition="right"   
			   iconCollapsedTopGroup="chevronDown">  
			   <rich:panelMenuGroup label="交易中心" id="group1" expanded="true">  
			     <rich:panelMenuItem label="订单管理" id="group1_item1"   
			         action="newCustomerRegister"  
			         mode="server" immediate="true" />  
			     <rich:panelMenuItem label="购物车" id="group1_item2"   
			         action="#{customerNavigationPage.clickActionByShoppingCart}"
			         mode="server" immediate="true" >
			         <a4j:actionparam name="paramItem" value="shoppingCart" assignTo="#{customerNavigationPage.param}"/>
			     </rich:panelMenuItem>
			    </rich:panelMenuGroup>  
			    <rich:panelMenuGroup label="服务中心" id="group2" expanded="true">  
			        <rich:panelMenuItem label="我的咨询" id="group2_item1"   
			         action="myAssistant"  
			         mode="ajax" immediate="true" />  
			     <rich:panelMenuItem label="我的评价" id="group2_item2"   
			         action="/select.xhtml"  
			         mode="ajax"/>  
			     <rich:panelMenuItem label="我的讨论" id="group2_item3"   
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="我的收藏" id="group2_item4"   
			         action="/select.xhtml"  
			         mode="ajax"/>   
			    </rich:panelMenuGroup>
			    <rich:panelMenuGroup label="个人信息" id="group3" expanded="true">  
			        <rich:panelMenuItem label="管理个人信息" id="group3_item1"   
			         action="/select.xhtml"  
			         mode="ajax"/>  
			     <rich:panelMenuItem label="管理收货信息" id="group3_item2"   
			         action="#{customerNavigationPage.clickActionByConsigneeCustomer}"  immediate="true"
			         mode="server"><a4j:actionparam name="paramItem" value="consigneeCustomer" assignTo="#{customerNavigationPage.param}"/>
   				</rich:panelMenuItem>
			     <rich:panelMenuItem label="修改帐户密码" id="group3_item3"   
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="我的积分" id="group3_item4"   
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="我的奖品" id="group3_item5"   
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="我的优惠券" id="group3_item6"   
			         action="/select.xhtml"  
			         mode="ajax"/>
			     <rich:panelMenuItem label="帐户余额" id="group3_item7"   
			         action="/select.xhtml"  
			         mode="ajax"/>
			    </rich:panelMenuGroup>
			 </rich:panelMenu>
		</rich:panel>
		</a4j:region>
	</h:form>

</f:subview>
</jsp:root>

