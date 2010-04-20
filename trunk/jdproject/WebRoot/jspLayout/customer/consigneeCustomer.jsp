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
    	<ui:composition template="./customerTemplate.jsp">
    		<ui:define id="customerStepDisplay" name="stepDisplay">
				<h:form id="stepForm">
    			<a4j:outputPanel styleClass="step-display-output-panel">
    				<h:outputText value="当前位置"></h:outputText><h:commandLink action="index" styleClass="step-display-output-panel-link"><h:outputText value="首页"/></h:commandLink>
					<h:outputText value=">"></h:outputText>
					<h:commandLink action="mainCustomer" styleClass="step-display-output-panel-link"><h:outputText value="管理中心"/></h:commandLink>
					<h:outputText value="> 管理收货信息"></h:outputText>
    			</a4j:outputPanel>
				</h:form>
    		</ui:define>
    		<ui:define id="customerLeft" name="left">
    			<ui:include id="customerLeftInclude" src="./navigationCustomerLeft.jsp">
    			</ui:include>
    		</ui:define>
    		<ui:define id="contentHeader" name="contentHeader">
    			<h:outputText value=""></h:outputText>
			</ui:define>
			<ui:define id="customerContent" name="content">
				<h:form id="customerConsigneeForm">
				<a4j:region id="mainConsigneeRegion" renderRegionOnly="false" selfRendered="true">
					<rich:panel id="messageTitle" headerClass="messageTitle" style="width:100%">
						<f:facet name="header">
						<ul style="padding-left: 30px;">
              				<span class="STYLE1"></span>

              				<li class="button02" id="menu42">管理收货信息</li>
            			</ul>
        				</f:facet>
					</rich:panel>
					<rich:panel id="consigneeTable" style="width:100%" bodyClass="info_area">
						<table border="1" cellpadding="0" width="100%" cellspacing="0" class="form_table">
				            <thead class="t_hue4">
				                <tr class="title1">
				                    <th class="td-gray" width="7%"><h:outputText value="设为默认" /></th>
				                    <th class="td-gray" width="11%"><h:outputText value="地址简称" /></th>
				                    <th class="td-gray" width="8%"><h:outputText value="收货人" /></th>
				                    <th class="td-gray" width="12%"><h:outputText value="手机" /></th>
				                    <th class="td-gray" width="15%"><h:outputText value="电话" /></th>
									<th class="td-gray" width="20%"><h:outputText value="详细地址" /></th>
									<th class="td-gray" width="8%"><h:outputText value="邮政编码" /></th>
									<th class="td-gray" width="8%"><h:outputText value="操作" /></th>
				                </tr>
				            </thead>
				            <tbody>
				            	<a4j:repeat value="#{editConsigneePage.consignees}" var="consignee">
								<tr>
									<td><h:selectBooleanCheckbox value="#{consignee.selected}"/></td>
									<td><h:outputLabel value="#{consignee.shortName}"/></td>
									<td><h:outputLabel value="#{consignee.consigneeName}"/></td>
									<td><h:outputLabel value="#{consignee.consigneeMobile}"/></td>
									<td><h:outputLabel value="#{consignee.consigneePhone}"/></td>
									<td class="left" title=""><h:outputLabel value="#{consignee.consigneeAddress}"/></td>
									<td><h:outputLabel value="#{consignee.consigneeZip}"/></td>
									<td>
									<a href="javascript:void(2815);" 
onclick="changeModAddress(2815);lockedRow(this);">修改</a>
									<a href="javascript:void(2815);" 
onclick="changeDelAddress(2815);">删除</a>
									</td>
								  </tr>
								  </a4j:repeat>
							</tbody>
						</table>
					</rich:panel>
					<rich:panel id="consigneeInfoTitle" style="width:100%" bodyClass="info-title">
						<h:outputText value="添加/修改"></h:outputText>
					</rich:panel>
					<rich:panel id="consigneeInfoContent" style="width:100%" headerClass="header-error-messages" bodyClass="info-content">
						<f:facet name="header"><h:outputText value="#{editConsigneePage.errorMessages}" style="width:100%"/></f:facet>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="发票抬头："></h:outputText>
								<h:inputText id="invoiceCompanyName" value="#{editConsigneePage.consignee.invoiceCompanyName}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText/></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称："></h:outputText>
								<h:inputText value="#{editConsigneePage.consignee.shortName}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="收货人："></h:outputText>
								<h:inputText value="#{editConsigneePage.consignee.consigneeName}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:66%"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="请填写准确的收货人信息。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="手机："></h:outputText>
								<h:inputText value="#{editConsigneePage.consignee.consigneeMobile}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="及时联系方式（免费短消息、电话）。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="电话："></h:outputText>
								<h:inputText value="#{editConsigneePage.consignee.consigneePhone}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="可填写多个号码，中间请用英文逗号  ,  隔开。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="传真："></h:outputText>
								<h:inputText value="#{editConsigneePage.consignee.consigneeTax}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText/></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value="地区："></h:outputText>
								<h:panelGroup>
									<h:inputText value="#{editConsigneePage.consignee.consigneeProvince}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:120px"></h:inputText><h:outputText value="省" style="vertical-align:middle;"></h:outputText>
									<h:inputText value="#{editConsigneePage.consignee.consigneeCity}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:120px"></h:inputText><h:outputText value="市" style="vertical-align:middle;"></h:outputText>
									<h:inputText value="#{editConsigneePage.consignee.consigneeCounty}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:80px"></h:inputText><h:outputText value="县（区）" style="vertical-align:middle;"></h:outputText>
								</h:panelGroup>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="请详细填写省、市、县（区）。"/></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value="详细地址："></h:outputText>
								<h:inputText value="#{editConsigneePage.consignee.consigneeAddress}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="请务必详细填写，以保证货物准确递送。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="邮编："></h:outputText>
								<h:inputText value="#{editConsigneePage.consignee.consigneeZip}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:66%"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="请准确填写邮编。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value="配送备注："></h:outputText>
								<h:inputTextarea  value="#{editConsigneePage.consignee.remark}" styleClass="input-text-full-length" style="height:99px;"></h:inputTextarea>
								<h:outputLabel value=""></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value=""></h:outputText>
								<h:panelGroup><h:selectBooleanCheckbox value="#{editConsigneePage.consignee.selected}" style="margin:16px 0px 0px 0px;vertical-align:bottom;"></h:selectBooleanCheckbox><h:outputLabel style="margin:16px 0px 0px 0px;vertical-align:bottom;" value="设定此地址为默认收货地址"/></h:panelGroup>
								<h:outputLabel value=""></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value=""></h:outputText>
								<h:panelGroup><a4j:commandLink action="#{editConsigneePage.commitConsignee}" value="提交" id="tijiao" styleClass="ButtonDefault"></a4j:commandLink><h:commandLink action="#{editConsigneePage.reSetConsignee}" value="重置" immediate="false" styleClass="ButtonDefault"><a4j:support event="onclick" reRender="invoiceCompanyName"></a4j:support></h:commandLink></h:panelGroup>
								<h:outputLabel value=""></h:outputLabel>
							</h:panelGrid>
					</rich:panel>
				</a4j:region>
				</h:form>
    		</ui:define>
    		<ui:define id="customerRight" name="right">
    			<h:outputText value=""></h:outputText>
    		</ui:define>
    	</ui:composition>
    	
    </body>
</html>	
</f:view>		
</jsp:root>	