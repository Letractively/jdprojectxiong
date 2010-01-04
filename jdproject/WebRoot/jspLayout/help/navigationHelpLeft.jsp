<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="kitchenApplianceProductLeftView">
	<h:form id="kitchenApplianceProductLeftViewForm">
		<a4j:region id="kitchenApplianceProductLeftViewFormRegion" renderRegionOnly="false" selfRendered="true">
		<rich:panel headerClass="main-left-product-header" styleClass="panel-bar-product-top" bodyClass="main-left-product-body">
			<f:facet name="header"><h:outputLabel value="帮助中心"/></f:facet>
			<h:panelGroup>
			<rich:panel id="noUserLoginPg" styleClass="main_header_login_navigation" rendered="#{currentUser.userInfo == null || !currentUser.userLoginFlag}">
    			<h:panelGrid columns="1" style="vertial-align:bottom;text-align:left;">
    				<h:outputText id="loginUserLabel" value="用户名:" styleClass="user-name"/>
    				<h:inputText id="loginUserId" value="#{currentUser.loginInfo.userId}" styleClass="user-name" size="15"/>
    				<h:outputText id="loginUserPasswordLabel" value="密码:" styleClass="user-name"/>
    				<h:inputSecret id="loginUserPassword" value="#{currentUser.loginInfo.userPassword}" size="15" styleClass="user-name"/>
    				<h:commandButton id="loginInBtn" action="#{currentUser.loginInAction}" image="/css/images/login.gif"><a4j:support event="onclick" reRender="kitchenApplianceProductLeftViewFormRegion"/></h:commandButton>
    			</h:panelGrid>
    		</rich:panel>
			</h:panelGroup>
			<h:panelGroup>
				<rich:panel id="hasUserLoginPg" styleClass="main_header_login_navigation" rendered="#{currentUser.userInfo != null || currentUser.userLoginFlag}">
    				<DIV class="ye_r_t">
					<DIV class="ye_l_t">
					<DIV class="ye_r_b">
					<DIV class="ye_l_b">
    				<h:panelGrid columns="1" style="vertial-align:bottom;text-align:left;">
    					<h:outputText id="loginInUserLabelLeft" value="您好: "/><h:outputText id="loginUserIdText" value="#{currentUser.userInfo.fullName}"/><h:outputText id="loginInUserLabelRight" value="欢迎回来!"/>
    					<h:commandButton id="loginOutBtn" image="/css/images/login.gif" action="#{currentUser.loginOutAction}"><a4j:support event="onclick" reRender="noUserLoginRegion,hasUserLoginRegion"/></h:commandButton>
    				</h:panelGrid>
    				</DIV>
    				</DIV>
    				</DIV>
    				</DIV>
    			</rich:panel>
			</h:panelGroup>
			<rich:panel id="UserLoginPgOthersPgPanel" styleClass="main_header_login_navigation_others">
    						<h:outputLink id="newUserRegistryLinkUserLoginIn" value="http://www.sohu.com"><h:outputText id="newUserRegistryLinkTextUserLoginIn" value="新用户注册"/></h:outputLink>
    						<h:outputText id="specchar1UserLoginIn" value="-"></h:outputText>
    						<h:outputLink id="forgotPasswordLinkUserLoginIn" value="http://www.sohu.com"><h:outputText id="forgotPasswordLinkTextUserLoginIn" value="忘记密码"/></h:outputLink>
    		</rich:panel>
			<rich:panelMenu style="width:136px" mode="client"   
   selectedChild="#{menuState.selectedMenuItem}"  
   iconExpandedGroup="disc"   
   iconCollapsedGroup="disc" 
   iconExpandedTopGroup="chevronUp"   
   iconGroupTopPosition="right"   
   iconCollapsedTopGroup="chevronDown">  
   <rich:panelMenuGroup label="新手上路" id="group1">  
     <rich:panelMenuItem label="新用户注册" id="group1_item1" 
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
     <rich:panelMenuItem label="订购流程" id="group1_item2"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
     <rich:panelMenuItem label="商品缺货" id="group1_item3"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
    </rich:panelMenuGroup>  
    <rich:panelMenuGroup label="帐户及定单信息" id="group2">  
        <rich:panelMenuItem label="我的助手" id="group2_item1"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
     <rich:panelMenuItem label="忘记密码" id="group2_item2"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
     <rich:panelMenuItem label="取消定单" id="group2_item3"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
     <rich:panelMenuItem label="发票制度" id="group2_item4"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>   
    </rich:panelMenuGroup>
    <rich:panelMenuGroup label="付款/退款方式" id="group3">  
        <rich:panelMenuItem label="货到付款" id="group3_item1"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
     <rich:panelMenuItem label="网上支付" id="group3_item2"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
     <rich:panelMenuItem label="支付宝" id="group3_item3"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
     <rich:panelMenuItem label="邮局汇款" id="group3_item4"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
     <rich:panelMenuItem label="银行转账" id="group3_item5"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
     <rich:panelMenuItem label="帐户余额支付" id="group3_item6"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
     <rich:panelMenuItem label="退款帮助" id="group3_item7"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
    </rich:panelMenuGroup>
    <rich:panelMenuGroup label="订单处理与配送" id="group4">  
        <rich:panelMenuItem label="货到付款开通范围" id="group4_item1"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
     <rich:panelMenuItem label="订单状态" id="group4_item2"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
     <rich:panelMenuItem label="送货方式" id="group4_item3"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
     <rich:panelMenuItem label="配送时间和范围" id="group4_item4"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
     <rich:panelMenuItem label="费收标准" id="group4_item5"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
    </rich:panelMenuGroup>
    <rich:panelMenuGroup label="商品验货与签收" id="group5">  
        <rich:panelMenuItem label="商品验货与签收" id="group5_item1"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>  
    </rich:panelMenuGroup>
    <rich:panelMenuGroup label="商品验货与签收" id="group6">  
        <rich:panelMenuItem label="退/换货政策" id="group6_item1"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
         <rich:panelMenuItem label="退/换货流程" id="group6_item2"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/>
         <rich:panelMenuItem label="补发货流程" id="group6_item3"   
         actionListener="#{helpPanelMenu.select}"  
         action="/select.xhtml"  
         mode="server"/> 
    </rich:panelMenuGroup>
 </rich:panelMenu>
		</rich:panel>
		</a4j:region>
	</h:form>

</f:subview>
</jsp:root>

