<?xml version="1.0" encoding="UTF-8"?>

<ui:composition 
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<a4j:region id="scpcregion" renderRegionOnly="true" selfRendered="true">
	<h:form id="scpcform">
		<a4j:outputPanel id="errorop" ajaxRendered="true">
		</a4j:outputPanel>
		<h:panelGrid id="addnewpersonpg" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" style="padding-left:0px;padding-right:0px" width="96%">
			<h:outputLabel value="姓名:" for="newpersonname"></h:outputLabel>
			<h:panelGroup>
				<h:inputText value="#{stakeholderCreate.newPerson.name}" id="newpersonname" maxlength="20">
					<rich:beanValidator summary="有误"></rich:beanValidator>
					<f:validator validatorId="NameValidator"/>
				</h:inputText>
				<h:outputText value="*" styleClass="must-input-text"></h:outputText>
			</h:panelGroup>
			<h:panelGroup>
			<rich:message for="newpersonname" id="namemessage" styleClass="error-messages" showSummary="true" showDetail="true"/>
			</h:panelGroup>
			<h:outputLabel value="年龄:" for="newpersonage"></h:outputLabel>
			<rich:inputNumberSpinner value="#{stakeholderCreate.newPerson.age}" id="newpersonage" minValue="18" maxValue="100" step="1"/>
			<rich:message for="newpersonage"></rich:message>
			<h:outputLabel value="性别:" for="newpersonsex"></h:outputLabel>
			<h:selectOneRadio id="newpersonsex" value="#{stakeholderCreate.newPerson.sex}">
					<f:selectItems value="#{contantItem.sexItems}"/>
			</h:selectOneRadio>
			<h:outputText value=""></h:outputText>
			<h:outputLabel value="电话:" for="newpersonphone"></h:outputLabel>
			<h:inputText id="newpersonphone" value="#{stakeholderCreate.newPerson.phone}" maxlength="30">
					<f:validator validatorId="PhoneValidator"/>
			</h:inputText>
			<h:message for="newpersonphone" id="phonemessage" styleClass="error-messages"></h:message>
			<h:outputLabel value="传真:" for="newpersontax"></h:outputLabel>
			<h:inputText id="newpersontax" value="#{stakeholderCreate.newPerson.tax}" maxlength="30">
					<f:validator validatorId="PhoneValidator"/>
			</h:inputText>
			<h:message for="newpersontax" id="taxmessage" styleClass="error-messages"></h:message>
			<h:outputLabel value="手机:" for="newpersonmobile"></h:outputLabel>
			<h:inputText id="newpersonmobile" value="#{stakeholderCreate.newPerson.mobile}" maxlength="30">
					<f:validator validatorId="PhoneMobileValidator"/>
			</h:inputText>
			<h:message for="newpersonmobile" id="mobilemessage" styleClass="error-messages"></h:message>
			<h:outputLabel value="电邮:" for="newpersonemail"></h:outputLabel>
			<h:inputText id="newpersonemail" value="#{stakeholderCreate.newPerson.email}" maxlength="50">
					<f:validator validatorId="EmailValidator"/>
			</h:inputText>
			<h:message for="newpersonemail" id="emailmessage" styleClass="error-messages"></h:message>
			<h:outputLabel value="地址:" for="newpersonaddress"></h:outputLabel>
			<h:inputText id="newpersonaddress" value="#{stakeholderCreate.newPerson.address}" style="width:200px" maxlength="100">
					<f:validator validatorId="AddressValidator"/>
			</h:inputText>
			<h:message for="newpersonaddress" id="addressmessage" styleClass="error-messages"></h:message>
			<h:outputLabel value="职务:" for="newpersoneprincipalship"></h:outputLabel>
			<h:inputText id="newpersonprincipalship" value="#{stakeholderCreate.newPerson.principalship}" maxlength="20"></h:inputText>
			<h:outputText value=""></h:outputText>
			<h:outputLabel value="备注:" for="newpersonremark"></h:outputLabel>
			<h:inputTextarea id="newpersonremark" value="#{stakeholderCreate.newPerson.remark}" rows="5" cols="40">
					<rich:beanValidator summary="有误"></rich:beanValidator>
			</h:inputTextarea>
			<rich:message for="newpersonremark" id="remarkmessage" styleClass="error-messages"/>
			<h:outputLabel value=" "></h:outputLabel>
			<a4j:commandButton id="newpersonpgsavebutton" type="button" value="保存" action="#{stakeholderCreate.addNewPerson}" reRender="errorop,addnewpersonpg">
						<!-- <a4j:support event="onclick" ajaxSingle="true" limitToList="true" reRender="addnewpersonpg"></a4j:support>  -->
					</a4j:commandButton>
			
			<h:outputText value=""></h:outputText>
		</h:panelGrid>
	</h:form>
</a4j:region>
</ui:composition>	