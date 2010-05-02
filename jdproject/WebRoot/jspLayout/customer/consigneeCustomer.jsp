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
					<rich:extendedDataTable value="#{editConsigneePage.currDataModel}" var="consignee" id="table" rows="#{editConsigneePage.recordNumberShow}" frame="above" border="1" width="100%" style="padding:0px 0px 0px 0px;margin:0px 0px 0px 0px;vertical-align:top;" height="#{(editConsigneePage.pageRows+1)*25+25}px"
            		cellpadding="0" cellspacing="0" lang="zh-cn" 
            		headerClass="t_hue4" styleClass="form_table" rowClasses="table-row-odd" selectedClass="table-row-selected"  
            		sortMode="#{editConsigneePage.sortMode}" 
                	selectionMode="#{editConsigneePage.selectionMode}"
                	selection="#{editConsigneePage.selection}"
                	binding="#{editConsigneePage.table}">
					<a4j:support id="supportone" event="onselectionchange" ignoreDupResponses="true" requestDelay="1"  action="#{editConsigneePage.selfTakeSelection}"  reRender="consigneeInfoContent" ajaxSingle="true"/>
						<rich:column id="columnone" width="8%" sortable="false" label="为默认">
                			<f:facet name="header">
                    			<h:outputText id="headerselected" value="设为默认"/>
                			</f:facet>
                			<h:selectBooleanCheckbox value="#{consignee.selected}"></h:selectBooleanCheckbox>
            			</rich:column> 
            			<rich:column id="columntwo" width="15%" sortable="false" label="地址简称">
                			<f:facet name="header">
                    			<h:outputText id="headershortname" value="地址简称"/>
                			</f:facet>
                			<h:outputLabel value="#{consignee.shortName}"/>
            			</rich:column>
						<rich:column id="columnthree" width="15%" sortable="false"  label="收货人">
                			<f:facet name="header">
                    			<h:outputText id="headerconsigneename" value="收货人"/>
                			</f:facet>
                			<h:outputLabel value="#{consignee.consigneeName}"/>
            			</rich:column>
						<rich:column id="columnfoure" width="15%" sortable="false"  label="手机">
                			<f:facet name="header">
                    			<h:outputText id="headerconsigneemobile" value="手机"/>
                			</f:facet>
                			<h:outputLabel value="#{consignee.consigneeMobile}"/>
            			</rich:column>
						<rich:column id="columnfive" width="15%" sortable="false"  label="电话">
                			<f:facet name="header">
                    			<h:outputText id="headerconsigneephone" value="电话"/>
                			</f:facet>
                			<h:outputLabel value="#{consignee.consigneePhone}"/>
            			</rich:column>
						<rich:column id="columnsix" width="25%" sortable="false"  label="详细地址">
                			<f:facet name="header">
                    			<h:outputText id="headerconsigneeaddress" value="详细地址"/>
                			</f:facet>
                			<h:outputLabel value="#{consignee.consigneeAddress}"/>
            			</rich:column>
						<rich:column id="columnseven" width="8%" sortable="false"  label="邮政编码">
                			<f:facet name="header">
                    			<h:outputText id="headerconsigneezip" value="邮政编码"/>
                			</f:facet>
                			<h:outputLabel value="#{consignee.consigneeZip}"/>
            			</rich:column>
        				</rich:extendedDataTable>
      					<rich:datascroller id="tableScroller" align="left" for="table" maxPages="20" rendered="#{editConsigneePage.dataCounts > editConsigneePage.recordNumberShow}"
						page="#{editConsigneePage.scrollerPage}"/>
					
					
					<rich:panel id="consigneeInfoTitle" style="width:100%" bodyClass="info-title">
						<h:outputText value="添加/修改"></h:outputText>
					</rich:panel>
					<rich:panel id="consigneeInfoContent" style="width:100%" headerClass="header-error-messages" bodyClass="info-content">
						<f:facet name="header"><h:outputText value="#{editConsigneePage.errorMessages}" style="width:100%" styleClass="error-messages"/></f:facet>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="发票抬头："></h:outputText>
								<h:inputText id="invoiceCompanyName" value="#{editConsigneePage.editData.invoiceCompanyName}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText/></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="地址简称："></h:outputText>
								<h:inputText value="#{editConsigneePage.editData.shortName}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="简单易记的地址名称，如“家”，“我的公司”等"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="收货人："></h:outputText>
								<h:inputText value="#{editConsigneePage.editData.consigneeName}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:66%"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="请填写准确的收货人信息。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="手机："></h:outputText>
								<h:inputText value="#{editConsigneePage.editData.consigneeMobile}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="及时联系方式（免费短消息、电话）。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="电话："></h:outputText>
								<h:inputText value="#{editConsigneePage.editData.consigneePhone}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="可填写多个号码，中间请用英文逗号  ,  隔开。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="传真："></h:outputText>
								<h:inputText value="#{editConsigneePage.editData.consigneeTax}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText/></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value="地区："></h:outputText>
								<h:panelGroup>
									<h:inputText value="#{editConsigneePage.editData.consigneeProvince}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:120px"></h:inputText><h:outputText value="省" style="vertical-align:middle;"></h:outputText>
									<h:inputText value="#{editConsigneePage.editData.consigneeCity}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:120px"></h:inputText><h:outputText value="市" style="vertical-align:middle;"></h:outputText>
									<h:inputText value="#{editConsigneePage.editData.consigneeCounty}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:80px"></h:inputText><h:outputText value="县（区）" style="vertical-align:middle;"></h:outputText>
								</h:panelGroup>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="请详细填写省、市、县（区）。"/></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value="详细地址："></h:outputText>
								<h:inputText value="#{editConsigneePage.editData.consigneeAddress}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="请务必详细填写，以保证货物准确递送。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
								<h:outputText value="邮编："></h:outputText>
								<h:inputText value="#{editConsigneePage.editData.consigneeZip}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:66%"></h:inputText>
								<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel value="请准确填写邮编。"></h:outputLabel></h:panelGroup>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value="配送备注："></h:outputText>
								<h:inputTextarea  value="#{editConsigneePage.editData.remark}" styleClass="input-text-full-length" style="height:99px;"></h:inputTextarea>
								<h:outputLabel value=""></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value=""></h:outputText>
								<h:panelGroup><h:selectBooleanCheckbox value="#{editConsigneePage.editData.selected}" style="margin:16px 0px 0px 0px;vertical-align:bottom;"></h:selectBooleanCheckbox><h:outputLabel style="margin:16px 0px 0px 0px;vertical-align:bottom;" value="设定此地址为默认收货地址"/></h:panelGroup>
								<h:outputLabel value=""></h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value=""></h:outputText>
								<h:panelGroup>
								<a4j:commandLink action="#{editConsigneePage.commitConsignee}" value="提交" id="tijiao" styleClass="ButtonDefault" reRender="table,tableScroller,consigneeInfoContent"></a4j:commandLink>
								<a4j:commandLink action="#{editConsigneePage.reSetConsignee}" value="重置" immediate="false" styleClass="ButtonDefault" reRender="table,tableScroller,consigneeInfoContent"></a4j:commandLink>
								<a4j:commandLink action="#{editConsigneePage.deleteConsignee}" value="删除" onclick="if (#{empty editConsigneePage.editData.id}) {alert('当前无数据可以删除');} else {if (!confirm('确认删除此记录吗?')) return false;}" id="deleButton" styleClass="ButtonDefault"  reRender="table,tableScroller,consigneeInfoContent"></a4j:commandLink>
								</h:panelGroup>
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