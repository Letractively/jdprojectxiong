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
				<a4j:region id="mainConsigneeRegion">
					<rich:panel id="messageTitle" headerClass="messageTitle" style="width:100%">
						<f:facet name="header">
						<ul style="padding-left: 30px;">
              				<span class="STYLE1"></span>

              				<li class="button02" id="menu42">管理收货信息</li>
            			</ul>
        				</f:facet>
					</rich:panel>
					<a4j:outputPanel id="consigneeTable" style="width:100%">
						<table border="1" cellpadding="0" cellspacing="0" class="form_table">
				            <thead class="t_hue4">
				                <tr class="title1">
				                    <th class="td-gray" style="width: 50px"><h:outputText value="设为默认" /></th>
				                    <th class="td-gray" style="width: 80px"><h:outputText value="地址简称" /></th>
				                    <th class="td-gray" style="width: 60px"><h:outputText value="收货人" /></th>
				                    <th class="td-gray" style="width: 90px"><h:outputText value="手机" /></th>
				                    <th class="td-gray" style="width: 100px"><h:outputText value="电话" /></th>
									<th class="td-gray" style="text-align:left;width: 100px"><h:outputText value="详细地址" /></th>
									<th class="td-gray" style="width: 50px"><h:outputText value="邮政编码" /></th>
									<th class="td-gray" style="width: 52px"><h:outputText value="操作" /></th>
				                </tr>
				            </thead>
				            <tbody>
								<tr>
									<td><input name="defaultAddress" id="defaultAddress_2815" 
value="2815" onclick="setDefaultAddress(this.value);" type="radio"/></td>
									<td>(家庭地址)</td>
									<td>我自己</td>
									<td>13658958986</td>
									<td>020-25658958</td>
									<td class="left" title="广东省佛山市禅城区">广东省佛山市禅城区广东省佛山市禅城区</td>
									<td><span class="f11">435678</span></td>
									<td>
									<a href="javascript:void(2815);" 
onclick="changeModAddress(2815);lockedRow(this);">修改</a>
									<a href="javascript:void(2815);" 
onclick="changeDelAddress(2815);">删除</a>
									</td>
								  </tr>
							</tbody>
						</table>
					</a4j:outputPanel>
					<rich:panel id="consigneeInfoDetail" style="boder-style:none;" bodyClass="info_area">
						<rich:panel id="consigneeInfoTitle" bodyClass="info-title">
							<h:outputText value="添加/修改"></h:outputText>
						</rich:panel>
						<rich:panel id="consigneeInfoContent" headerClass="header-error-messages" bodyClass="info-content">
							<f:facet name="header"><h:outputText value="errormessage" style="width:100%"/></f:facet>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称"></h:outputText>
								<h:inputText value="dd"></h:inputText>
								<h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等。"></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称"></h:outputText>
								<h:inputText value="dd"></h:inputText>
								<h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等。"></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称"></h:outputText>
								<h:inputText value="dd"></h:inputText>
								<h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等。"></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称"></h:outputText>
								<h:inputText value="dd"></h:inputText>
								<h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等。"></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称"></h:outputText>
								<h:inputText value="dd"></h:inputText>
								<h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等。"></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称"></h:outputText>
								<h:inputText value="dd"></h:inputText>
								<h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等。"></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称"></h:outputText>
								<h:inputText value="dd"></h:inputText>
								<h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等。"></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:outputText value="地址简称"></h:outputText>
								<h:inputTextarea  value="dd"></h:inputTextarea>
								<h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等。"></h:outputLabel>
							</h:panelGrid>
						</rich:panel>
					</rich:panel>
				</a4j:region>
    		</ui:define>
    		<ui:define id="customerRight" name="right">
    			<h:outputText value=""></h:outputText>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	