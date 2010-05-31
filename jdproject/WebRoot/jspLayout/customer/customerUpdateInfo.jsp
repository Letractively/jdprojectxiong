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
    <title>修改密码</title>
    </head>
    <body>
    	<ui:composition template="./customerTemplate.jsp">
    		<ui:define id="customerStepDisplay" name="stepDisplay">
				<h:form id="stepForm">
    			<a4j:outputPanel styleClass="step-display-output-panel">
    				<h:outputText value="当前位置"></h:outputText><h:commandLink action="index" styleClass="step-display-output-panel-link"><h:outputText value="首页"/></h:commandLink>
					<h:outputText value=">"></h:outputText>
					<h:commandLink action="mainCustomer" styleClass="step-display-output-panel-link"><h:outputText value="管理中心"/></h:commandLink>
					<h:outputText value="> 个人信息"></h:outputText>
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
				<h:form id="customerInfoForm">
				<a4j:region id="mainInfoRegion" renderRegionOnly="false" selfRendered="true">
					<rich:panel id="messageTitle" headerClass="messageTitle" style="width:100%">
						<f:facet name="header">
						<ul style="padding-left: 30px;">
              				<span class="STYLE1"></span>

              				<li class="button02" id="menu42">个人信息</li>
            			</ul>
        				</f:facet>
					</rich:panel>
					<rich:panel id="customerInfoContentPanel" style="width:100%" headerClass="header-error-messages" bodyClass="panel-documents-none-border">
						<f:facet name="header"><h:outputText id="errortext" value="#{customerUpdateInfoPage.errorMessages}" style="width:100%" styleClass="error-messages"/></f:facet>
						<h:panelGrid columns="3" columnClasses="update-password-common-panel-grid-one,update-password-common-panel-grid-two,update-password-common-panel-grid-three" rowClasses="common-panel-grid-row">
						<h:outputLabel value="用户ID:" for="userid"></h:outputLabel>
						<h:outputText value="#{customerUpdateInfoPage.stakeholder.userId}" id="userid">
                		</h:outputText>
                		<rich:message for="userid" />
						<h:outputText value=" "></h:outputText>
                		<h:outputText value="#{customerUpdateInfoPage.stakeholder.mnemonicchars}" id="mnemonicchar"></h:outputText>
						<h:outputText value=" "></h:outputText>
						<h:outputLabel value="简称:" for="shortname"></h:outputLabel>
                		<h:inputText value="#{customerUpdateInfoPage.stakeholder.shortName}" maxlength="50" id="shortname">
                		</h:inputText>
						<rich:message for="shortname"/>
						<h:outputLabel value="全称:" for="fullname"></h:outputLabel>
                		<h:inputText value="#{customerUpdateInfoPage.stakeholder.fullName}" maxlength="100" style="width:300px;" id="fullname">
                			<rich:beanValidator summary="错误,请检查"/>
							<f:validator validatorId="NameValidator"/>
                		</h:inputText>
						<rich:message for="fullname"/>
						<h:outputText value="区域:"></h:outputText>
						<h:panelGroup>
							<h:inputText value="#{customerUpdateInfoPage.stakeholder.province}" id="province" maxlength="50" style="width:80px;text-align:right"></h:inputText><h:outputLabel value="省(直辖市)  " for="province"></h:outputLabel>
							<h:inputText value="#{customerUpdateInfoPage.stakeholder.city}" id="city" maxlength="20" style="width:60px;text-align:right"></h:inputText><h:outputLabel value="市     " for="city"></h:outputLabel>
							<h:inputText value="#{customerUpdateInfoPage.stakeholder.county}" id="county" maxlength="20" style="width:61px;text-align:right"></h:inputText><h:outputLabel value="县(区)  " for="county"></h:outputLabel>
						</h:panelGroup>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="电话:" for="phone"></h:outputLabel>
                		<h:inputText value="#{customerUpdateInfoPage.stakeholder.phone}" maxlength="100" id="phone">
							<f:validator validatorId="PhoneValidator"/>
                		</h:inputText>
						<rich:message for="phone"/>
						<h:outputLabel value="传真:" for="tax"></h:outputLabel>
                		<h:inputText value="#{customerUpdateInfoPage.stakeholder.tax}" maxlength="100" id="tax">
						<f:validator validatorId="PhoneValidator"/>
                		</h:inputText>
						<rich:message for="tax"/>
						<h:outputLabel value="URL:" for="url"></h:outputLabel>
                		<h:inputText value="#{customerUpdateInfoPage.stakeholder.url}" maxlength="100" id="url">
                		</h:inputText>
						<rich:message for="url"/>
						<h:outputLabel value="备注:" for="remarks"></h:outputLabel>
                		<h:inputTextarea value="#{customerUpdateInfoPage.stakeholder.remarks}" style="width:300px;height:50px" id="remarks">
                			<rich:beanValidator summary="错误,请检查"/>
                		</h:inputTextarea>
						<rich:message for="remarks"/>
						<f:facet name="footer">
							
						</f:facet>
						</h:panelGrid>
					    <a4j:commandButton action="#{customerUpdateInfoPage.saveCustomerInfo}" value="保存" oncomplete="reClickActionByCustomerUpdateInfo">
					    	<a4j:jsFunction name="clickActionByCustomerUpdateInfoFunction" action="#{customerNavigationPage.clickActionByCustomerUpdateInfo}"></a4j:jsFunction>
					    </a4j:commandButton>
					</rich:panel>
					<rich:simpleTogglePanel id="scstp" switchType="ajax" ajaxSingle="true" reRender="newpersonform" width="100%" label="管理联系人" headerClass="simple-toggle-panel-header" bodyClass="simple-toggle-panel-body">
						<rich:dataTable value="#{editPersonPage.currDataModel}" var="person" id="table" rows="#{editPersonPage.numberOnePage}" frame="vsides" border="0" width="100%" style="padding:0px 0px 0px 0px;margin:0px 0px 0px 0px;vertical-align:top;"
            		cellpadding="0" cellspacing="0" lang="zh-cn" 
            		headerClass="data_table_header" styleClass="data_table" rowClasses="table-row-odd" columnClasses="align-center,align-center,align-center,align-center,align-center,align-left,align-center,align-center"
            		sortMode="#{editPersonPage.sortMode}" 
                	binding="#{editPersonPage.table}">
							<rich:column id="columnone" style="word-break:break-all; width:62px" sortable="false" label="姓名">
	                			<f:facet name="header">
	                    			<h:outputText id="headerselected" value="姓名"/>
	                			</f:facet>
	                			<h:outputText value="#{person.name}"></h:outputText>
	                		</rich:column>
	            			<rich:column id="columntwo" style="word-break:break-all; width:94px" sortable="false" label="性别">
	                			<f:facet name="header">
	                    			<h:outputText id="headershortname" value="性别"/>
	                			</f:facet>
	                			<h:outputLabel value="#{person.sex}"/>
	            			</rich:column>
							<rich:column id="columnthree" style="word-break:break-all; width:94px" sortable="false"  label="年龄">
	                			<f:facet name="header">
	                    			<h:outputText id="headerconsigneename" value="年龄"/>
	                			</f:facet>
	                			<h:outputLabel value="#{person.age}"/>
	            			</rich:column>
							<rich:column id="columnfoure" style="word-break:break-all; width:94px" sortable="false"  label="电话">
	                			<f:facet name="header">
	                    			<h:outputText id="headerconsigneemobile" value="电话"/>
	                			</f:facet>
	                			<h:outputLabel value="#{person.phone}"/>
	            			</rich:column>
							<rich:column id="columnfive" style="word-break:break-all; width:94px" sortable="false"  label="手机">
	                			<f:facet name="header">
	                    			<h:outputText id="headerconsigneephone" value="手机"/>
	                			</f:facet>
	                			<h:outputLabel value="#{person.mobile}"/>
	            			</rich:column>
							<rich:column id="columnsix" style="word-break:break-all; width:195px" sortable="false"  label="电邮">
	                			<f:facet name="header">
	                    			<h:outputText id="headerconsigneeaddress" value="电邮"/>
	                			</f:facet>
	                			<h:outputLabel value="#{person.email}"/>
	            			</rich:column>
							<rich:column id="columnseven" style="word-break:break-all; width:78px" sortable="false"  label="地址">
	                			<f:facet name="header">
	                    			<h:outputText id="headerconsigneezip" value="地址"/>
	                			</f:facet>
	                			<h:outputLabel value="#{person.address}"/>
	            			</rich:column>
							<rich:column id="columneight" style="word-break:break-all; width:8%" sortable="false"  label="操作">
	                			<f:facet name="header">
	                    			<h:outputText id="headerconsigneeoperate" value="操作"/>
	                			</f:facet>
	                			<a4j:commandLink action="#{editPersonPage.requireUpdatePerson}" value="修改" reRender="personInfoTitle,personInfoContent"></a4j:commandLink><a4j:commandLink value="删除" action="#{editPersonPage.deletePersonByEachItem}" onclick="{if (!confirm('确认删除	'+'#{person.name}'+'	吗?')) return false;}" reRender="table,tableScroller,personInfoTitle,personInfoContent"></a4j:commandLink>
	            			</rich:column>
	        			</rich:dataTable>
	      				<rich:datascroller id="tableScroller" align="left" for="table" maxPages="20" rendered="#{editPersonPage.dataCounts > editPersonPage.numberOnePage}"
							page="#{editPersonPage.scrollerPage}"/>
					
					
						<rich:panel id="personInfoTitle" style="width:100%" bodyClass="info-title">
							<h:outputText value="添加" rendered="#{editPersonPage.action == 'NEW'}"></h:outputText><h:outputText value="修改" rendered="#{editPersonPage.action == 'EDIT'}"></h:outputText><a4j:commandLink action="#{editPersonPage.preDddPerson}" value="新增收货地址" rendered="#{editPersonPage.action != 'NEW'}" styleClass="button-default-style" reRender="personInfoTitle,personInfoContent"></a4j:commandLink>
						</rich:panel>
						<rich:panel id="personInfoContent" style="width:100%" headerClass="header-error-messages" bodyClass="info-content">
							<f:facet name="header"><h:outputText value="#{editPersonPage.errorMessages}" style="width:100%" styleClass="error-messages"/></f:facet>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
									<h:outputText value="姓名："></h:outputText>
									<h:inputText id="personName" value="#{editPersonPage.editData.name}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
									<h:panelGroup><h:outputText/></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
									<h:outputText value="年龄："></h:outputText>
									<h:inputText value="#{editPersonPage.editData.age}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
									<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel styleClass="orange-text" value="简单易记的地址名称，如“家”，“我的公司”等"></h:outputLabel></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
									<h:outputText value="性别："></h:outputText>
									<h:inputText value="#{editPersonPage.editData.sex}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:66%"></h:inputText>
									<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel styleClass="orange-text" value="请填写准确的收货人信息。"></h:outputLabel></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
									<h:outputText value="电话："></h:outputText>
									<h:inputText value="#{editPersonPage.editData.phone}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
									<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel styleClass="orange-text" value="及时联系方式（免费短消息、电话）。"></h:outputLabel></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
									<h:outputText value="传真："></h:outputText>
									<h:inputText value="#{editPersonPage.editData.tax}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
									<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel styleClass="orange-text" value="可填写多个号码，中间请用英文逗号  ,  隔开。"></h:outputLabel></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
									<h:outputText value="手机："></h:outputText>
									<h:inputText value="#{editPersonPage.editData.mobile}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
									<h:panelGroup><h:outputText/></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
									<h:outputText value="电邮："></h:outputText>
									<h:inputText value="#{editPersonPage.editData.email}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:120px"></h:inputText>
									<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel styleClass="orange-text" value="请详细填写省、市、县（区）。"/></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
									<h:outputText value="地址："></h:outputText>
									<h:inputText value="#{editPersonPage.editData.address}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6"></h:inputText>
									<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel styleClass="orange-text" value="请务必详细填写，以保证货物准确递送。"></h:outputLabel></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-two,panel-grid-three">
									<h:outputText value="职务："></h:outputText>
									<h:inputText value="#{editPersonPage.editData.principalship}" styleClass="input-text-full-length" style="border:1px solid #d6d6d6;width:66%"></h:inputText>
									<h:panelGroup><h:outputText value="*" styleClass="red-text"></h:outputText><h:outputLabel styleClass="orange-text" value="请准确填写邮编。"></h:outputLabel></h:panelGroup>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
									<h:outputText value="配送备注："></h:outputText>
									<h:inputTextarea  value="#{editPersonPage.editData.remark}" styleClass="input-text-full-length" style="height:99px;"></h:inputTextarea>
									<h:outputLabel value=""></h:outputLabel>
								</h:panelGrid>
								<h:panelGrid columns="3" width="100%" styleClass="panel-grid-row-padding" columnClasses="panel-grid-one,panel-grid-three,panel-grid-two">
								<h:outputText value=""></h:outputText>
								<h:panelGroup>
								<a4j:commandLink action="#{editPersonPage.commitPerson}" value="提交" id="tijiao" styleClass="ButtonDefault" reRender="table,tableScroller,personInfoContent"></a4j:commandLink>
								<a4j:commandLink action="#{editPersonPage.reSetPerson}" value="重置" immediate="false" styleClass="ButtonDefault" reRender="table,tableScroller,personInfoContent"></a4j:commandLink>
								<a4j:commandLink action="#{editPersonPage.deletePerson}" value="删除" onclick="if (#{empty editPersonPage.editData.id}) {alert('当前无数据可以删除');} else {if (!confirm('确认删除此记录吗?')) return false;}" id="deleButton" styleClass="ButtonDefault"  reRender="table,tableScroller,personInfoTitle,personInfoContent"></a4j:commandLink>
								</h:panelGroup>
								<h:outputLabel value=""></h:outputLabel>
							</h:panelGrid>
								
						</rich:panel>
					</rich:simpleTogglePanel>
					
					
					
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