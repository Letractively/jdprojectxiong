<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<a4j:region id="scpenavegationregion" renderRegionOnly="true" selfRendered="true">
	<h:form id="scpenavegationregionform">
		
		<rich:orderingList id="orderingListPersons" binding="#{stakeholderCreate.orderingListPerson}"
								converter="#{personVoConverter}"
								value="#{stakeholderCreate.persons}" var="item" rowKeyVar="row"
								selection="#{stakeholderCreate.personSelections}"
								controlsType="#{stakeholderCreate.controlsType}"
								controlsHorizontalAlign="#{stakeholderCreate.controlsHorizontalAlign}"
								controlsVerticalAlign="#{stakeholderCreate.controlsVerticalAlign}"
								orderControlsVisible="#{stakeholderCreate.orderControlsVisible}"
								fastOrderControlsVisible="#{stakeholderCreate.fastOrderControlsVisible}"
								listWidth="100%"
								listHeight="100px"
								ontopclick="#{stakeholderCreate.ontopclick}"
								onbottomclick="#{stakeholderCreate.onbottomclick}"
								columnClasses="columns"
								captionLabel="联系人信息"
								topControlLabel="起始"
								upControlLabel="上移"
								downControlLabel="下移"
								bottomControlLabel="最后"
								immediate="true"
								>
							<h:column>
                    			<f:facet name="header">
                        			<h:outputText value="序号"></h:outputText>
                    			</f:facet>
                    			<h:outputText value="#{row+1}"></h:outputText>
                			</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="删除" />
								</f:facet>
								<h:selectBooleanCheckbox value="#{item.selected}"><a4j:support event="onclick" ajaxSingle="true"/></h:selectBooleanCheckbox>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="姓名" />
								</f:facet>
								<h:inputText value="#{item.name}" binding="#{stakeholderCreate.inputPerson}" styleClass="inplaceInputDisplay" >
									<f:validator validatorId="NameValidator"/>
									<a4j:support event="onchange" ajaxSingle="true" action="#{stakeholderCreate.valueChangeInputInOrderingListPerson}" limitToList="true" reRender="scpenavegationregionform"/>
								</h:inputText>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="年龄" />
								</f:facet>
								<rich:inputNumberSpinner value="#{item.age}" minValue="18" maxValue="100" step="1">
									<a4j:support event="onchange" ajaxSingle="true" action="#{stakeholderCreate.valueChangeInputInOrderingListPerson}" limitToList="true" reRender="scpenavegationregionform"/>
								</rich:inputNumberSpinner>
								<!-- <h:inputText value="#{item.age}"  styleClass="inplaceInputDisplay"  onblur="if(/\D/.test(this.value)){alert('只能输入数字');this.select();}">
									<a4j:support event="onblur" ajaxSingle="true"/>
								</h:inputText>  -->
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="性别" />
								</f:facet>
								<h:selectOneMenu value="#{item.sex}">
									<f:selectItems value="#{contantItem.sexItems}"/>
									<a4j:support event="onchange" ajaxSingle="true" action="#{stakeholderCreate.valueChangeInputInOrderingListPerson}" limitToList="true" reRender="scpenavegationregionform"/>
								</h:selectOneMenu>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="电话" />
								</f:facet>
								<h:inputText value="#{item.phone}">
									<f:validator validatorId="PhoneValidator"/>
									<a4j:support event="onchange" ajaxSingle="true" action="#{stakeholderCreate.valueChangeInputInOrderingListPerson}" limitToList="true" reRender="scpenavegationregionform"/>
								</h:inputText>
							</h:column>
							
						<a4j:support id="ght" event="onclick" ignoreDupResponses="true" requestDelay="500" action="#{stakeholderCreate.takeSelection}"/>
            			<a4j:support id="ki" event="onkeyup" ignoreDupResponses="true" requestDelay="500" action="#{stakeholderCreate.takeSelection}"/>
		</rich:orderingList>
		<h:messages id="allerrors" styleClass="error-messages" showSummary="true" showDetail="true"></h:messages>
		<a4j:status startText="START" startStyle="color: red;"
					stopText="STOP" stopStyle="color: green;" />
		<a4j:commandButton id="olpsavebutton" value="save" immediate="true" action="#{stakeholderCreate.applyUpdate}"></a4j:commandButton>
		
	</h:form>
	</a4j:region>
</jsp:root>	