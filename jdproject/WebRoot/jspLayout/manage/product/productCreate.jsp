<?xml version="1.0" encoding="UTF-8"?>
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
    <title>新增产品</title>
    </head>
    <body>
    	<ui:composition template="../manageTemplate.jsp">
    		<ui:define name="content">
    			<h:form id="productform">
    			<fieldset class="demo_fieldset">
				<legend class="demo_legend"><h:outputText value="#{manageHeaderMenu.menuTitle}"/></legend>
    				<h:panelGrid id="newpanel" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
						<h:outputLabel value="产品编码:" for="productCode"></h:outputLabel>
						<h:inputText value="#{productCreate.product.code}" id="productCode">
							<a4j:support event="onblur" action="#{productCreate.setProductIntroduceFileName}" ajaxSingle="ture" limitToList="true" reRender="introduceFileName"></a4j:support>
                		</h:inputText>
                		<rich:message for="productCode" />
                		<h:outputLabel value="原厂商编码:" for="manufacturerCode"></h:outputLabel>
						<h:inputText value="#{productCreate.product.manufacturerCode}" id="manufacturerCode" maxlength="20">
                    	</h:inputText>
                		<rich:message for="manufacturerCode" />
                		<h:outputLabel value="原厂商:" for="productProviderFullName"></h:outputLabel>
                		<h:panelGroup>
							<h:inputText value="#{productCreate.product.provider.fullName}" id="productProviderFullName">
							<a4j:support action="#{productCreate.setPopupStakeholderSearchName}" event="onblur" ajaxSingle="true" limitToList="true" reRender="productProviderFullName,popupStakeholderSearchName"></a4j:support> 
                    		</h:inputText>
                    		<a4j:jsFunction oncomplete="changeFinishInCreateProduct(data);" name="processSearchStakeholderMethodInCreateProduct"
    						data="#{popupStakeholder.searchName}"
    						actionListener="#{popupStakeholder.ActionListenerTest}"
   						 	action="#{popupStakeholder.valueChange}">

    						
     						<a4j:actionparam name="param1" value="A" assignTo="#{popupStakeholder.statusItem}" />
     						<a4j:actionparam name="param2" value="P" assignTo="#{popupStakeholder.typeItem}" />
     						<a4j:actionparam name="param3" value="productCreate" assignTo="#{popupStakeholder.facesBean}" />
     						<a4j:actionparam name="param4" value="product.provider" assignTo="#{popupStakeholder.propertyOfFacesBean}" />
   							</a4j:jsFunction>
   							<a4j:jsFunction name="processFreshStakeholerInCreateProduct" ajaxSingle="true" limitToList="true" reRender="productProviderFullName">
   						 	</a4j:jsFunction>
                    		<a4j:commandButton value="..." immediate="true" ajaxSingle="true" onclick="searchStakehoderInCreateProductBegin(); return false;"/>
                    	</h:panelGroup>
                		<rich:message for="productProviderFullName" />
						<h:outputLabel value="条码号:" for="barcode"></h:outputLabel>
						<h:inputText value="#{productCreate.product.barcode}" id="barcode" maxlength="50">
                    	</h:inputText>
                		<rich:message for="barcode" />
						<h:outputLabel value="名称:" for="name"></h:outputLabel>
						<h:inputText value="#{productCreate.product.name}" id="name" maxlength="50">
                    	</h:inputText>
                		<rich:message for="name" />
                		<h:outputLabel value="描述:" for="description"></h:outputLabel>
						<h:inputText value="#{productCreate.product.description}" id="description" maxlength="50">
                    	</h:inputText>
                		<rich:message for="description" />
						<h:outputLabel value="图片:" for="imageName"></h:outputLabel>
						<h:panelGroup>
	    					<h:inputText value="#{productCreate.product.imageName}" id="imageName" maxlength="50"/>
	    					<rich:suggestionbox id="suggestionBoxId" for="imageName" tokens=","
	                        rules="#{imageSuggestionBox.rules}"
	                        suggestionAction="#{imageSuggestionBox.autocomplete}" var="result"
	                        fetchValue="#{result.name}"
	                        first="#{imageSuggestionBox.intFirst}"
	                        minChars="0"
	                        shadowOpacity="#{imageSuggestionBox.shadowOpacity}"
	                        border="#{imageSuggestionBox.border}"
	                        width="#{imageSuggestionBox.width}"
	                        height="#{imageSuggestionBox.height}"
	                        shadowDepth="#{imageSuggestionBox.shadowDepth}"
	                        cellpadding="#{imageSuggestionBox.cellpadding}"
	                        usingSuggestObjects="#{imageSuggestionBox.usingSuggestObjects}">
	
	            			<a4j:ajaxListener type="com.ejd.web.vo.listener.AjaxListener"/>
	        				<h:column>
	            				<h:outputText value="#{result.name}"/>
	        				</h:column>
	    					</rich:suggestionbox>
    					</h:panelGroup>
                		<rich:message for="imageName" />
						<h:outputLabel value="规格:" for="spec"></h:outputLabel>
						<h:inputText value="#{productCreate.product.spec}" id="spec" maxlength="50">
                    	</h:inputText>
                		<rich:message for="spec" />
						<h:outputLabel value="大类:" for="primaryCategoryCode"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.primaryCategoryCode}" id="primaryCategoryCode" immediate="true" valueChangeListener="#{productCreate.changePrimaryCategory}">
							<f:selectItems value="#{productCreate.primaryCategoryCodeItems}"/>
							<a4j:support event="onchange" action="#{productCreate.changeSecondCategoryAndBrand}" reRender="secondCategoryCode,subProduct" ajaxSingle="true" immediate="true"></a4j:support>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						<h:outputLabel value="小类:" for="secondCategoryCode"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.secondCategoryCode}" id="secondCategoryCode" immediate="true" valueChangeListener="#{productCreate.changeSecondCategory}">
							<f:selectItems value="#{productCreate.secondCategoryCodeItems}" />
							<a4j:support event="onchange" action="#{productCreate.changeSecondCategoryCode}" reRender="subProduct" ajaxSingle="true" immediate="true"></a4j:support>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
                		<h:outputLabel value="品牌:" for="brandId"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.brandCode}" id="brandId">
							<f:selectItems value="#{productCreate.brandCodeItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
                		<h:outputLabel value="单位:" for="unitId"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.unitId}" id="unitId">
							<f:selectItems value="#{existProductUnit.unitItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						<h:outputLabel value="状态:" for="status"></h:outputLabel>
						<h:selectOneMenu value="#{productCreate.product.status}" id="status">
							<f:selectItems value="#{existProductStatus.statusItems}"/>
						</h:selectOneMenu>
                		<h:outputText value=" "></h:outputText>
						
						<h:outputLabel value="进货价:" for="purchasePrice"></h:outputLabel>
						<h:inputText value="#{productCreate.product.purchasePrice}" id="purchasePrice" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="purchasePrice" />
						<h:outputLabel value="零售价:" for="retailPrice"></h:outputLabel>
						<h:inputText value="#{productCreate.product.retailPrice}" id="retailPrice" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="purchasePrice" showSummary="false"/>
                		<h:outputLabel value="积分:" for="integration"></h:outputLabel>
						<h:inputText value="#{productCreate.product.integration}" id="integration" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="integration" showSummary="false"/>
						<h:outputLabel value="经销商价:" for="tradePriceOne"></h:outputLabel>
						<h:inputText value="#{productCreate.product.tradePriceOne}" id="tradePriceOne" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="tradePriceOne" />
						<h:outputLabel value="代理商价:" for="tradePriceTwo"></h:outputLabel>
						<h:inputText value="#{productCreate.product.tradePriceTwo}" id="tradePriceTwo" onchange="if(!(/^[0-9]+(.[0-9]{1,2})?$/.test(this.value))){alert('只能输入1-2位正实数');this.value='0.0';}">
                    	</h:inputText>
                		<rich:message for="tradePriceTwo" />
                		<h:outputLabel value="库存数量:" for="stockLowerNumber"></h:outputLabel>
						<rich:inputNumberSpinner value="#{productCreate.product.currentNumber}" id="currentNumber" minValue="1" maxValue="10000" step="1"/>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="库存下限:" for="stockLowerNumber"></h:outputLabel>
						<rich:inputNumberSpinner value="#{productCreate.product.stockLowerNumber}" id="stockLowerNumber" minValue="1" maxValue="10000" step="1"/>
						<h:outputText value=""></h:outputText>
						<h:outputLabel value="库存上限:" for="stockUpperNumber"></h:outputLabel>
						<rich:inputNumberSpinner value="#{productCreate.product.stockUpperNumber }" id="stockUpperNumber" minValue="1" maxValue="100000" step="1"/>
						<h:outputText value=" "></h:outputText>
						<h:outputLabel value="介绍页面:" for="introduceFileName"></h:outputLabel>
						<h:inputText value="#{productCreate.product.introduceFileName}" id="introduceFileName" maxlength="50" readonly="true">
                    	</h:inputText>
                		<rich:message for="introduceFileName" />
						<f:facet name="footer">
							<h:panelGroup id="subProduct">
							<h:panelGrid id="riceCooker" rendered="#{productCreate.currProductType == 'riceCooker'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="riceCookerFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="riceCookerFeild1"></h:inputText>
								<rich:message for="riceCookerFeild1" />
								<h:outputLabel value="功率(W):" for="riceCookerFeild2"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field2}" id="riceCookerFeild2"></h:inputText>
								<rich:message for="riceCookerFeild2" />
							</h:panelGrid>
							<h:panelGrid id="inductionCooker" rendered="#{productCreate.currProductType == 'inductionCooker'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="面斑类型:" for="inductionCookerFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="inductionCookerFeild6">
									<f:selectItems value="#{existInductionCookerPanelType.panelTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="inductionCookerFeild1" />
								<h:outputLabel value="配件:" for="inductionCookerFeild7"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field7}" id="inductionCookerFeild7">
									<f:selectItems value="#{existInductionCookerFitting.fittingItems}"/>
								</h:selectOneMenu>
								<rich:message for="inductionCookerFeild2" />
							</h:panelGrid>
							<h:panelGrid id="electricStewPan" rendered="#{productCreate.currProductType == 'electricStewPan'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="electricStewPanFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="electricStewPanFeild1"></h:inputText>
								<rich:message for="electricStewPanFeild1" />
								
							</h:panelGrid>
							<h:panelGrid id="electronicOven" rendered="#{productCreate.currProductType == 'electronicOven'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="加热方式:" for="electronicOvenFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="electronicOvenFeild6">
									<f:selectItems value="#{existElectronicOvenHotType.hotTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="electronicOvenFeild6" />
								
							</h:panelGrid>
							<h:panelGrid id="burntStewpot" rendered="#{productCreate.currProductType == 'burntStewpot'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="burntStewpotFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="burntStewpotFeild1"></h:inputText>
								<rich:message for="burntStewpotFeild1" />
								<h:outputLabel value="功率:" for="burntStewpotFeild2"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field2}" id="burntStewpotFeild2"></h:inputText>
								<rich:message for="burntStewpotFeild2" />
							</h:panelGrid>
							<h:panelGrid id="electricPressureCooker" rendered="#{productCreate.currProductType == 'electricPressureCooker'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="electricPressureCookerFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="electricPressureCookerFeild1"></h:inputText>
								<rich:message for="electricPressureCookerFeild1" />
								<h:outputLabel value="控制方式:" for="electricPressureCookerFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="electricPressureCookerFeild6">
									<f:selectItems value="#{existElectricPressureCookerControlType.controlTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="electricPressureCookerFeild6" />
							</h:panelGrid>
							<h:panelGrid id="eggCooker" rendered="#{productCreate.currProductType == 'eggCooker'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容量(个):" for="eggCookerFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="eggCookerFeild1"></h:inputText>
								<rich:message for="eggCookerFeild1" />
								<h:outputLabel value="控制方式:" for="eggCookerFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="eggCookerFeild6">
									<f:selectItems value="#{existEggCookerTimeType.timeTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="eggCookerFeild6" />
							</h:panelGrid>
							<h:panelGrid id="toaster" rendered="#{productCreate.currProductType == 'toaster'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="类别:" for="toasterFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="toasterFeild6">
									<f:selectItems value="#{existToasterType.typeItems}"/>
								</h:selectOneMenu>
								<rich:message for="toasterFeild6" />
							</h:panelGrid>
							<h:panelGrid id="microwaveOven" rendered="#{productCreate.currProductType == 'microwaveOven'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="microwaveOvenFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="microwaveOvenFeild1"></h:inputText>
								<rich:message for="microwaveOvenFeild1" />
								<h:outputLabel value="控制方式:" for="microwaveOvenFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="microwaveOvenFeild6">
									<f:selectItems value="#{existElectricPressureCookerControlType.controlTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="microwaveOvenFeild6" />
							</h:panelGrid>
							
							<h:panelGrid id="disinfectionCabinet" rendered="#{productCreate.currProductType == 'disinfectionCabinet'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="disinfectionCabinetFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="disinfectionCabinetFeild1"></h:inputText>
								<rich:message for="disinfectionCabinetFeild1" />
								<h:outputLabel value="功率(W):" for="disinfectionCabinetFeild2"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field2}" id="disinfectionCabinetFeild2"></h:inputText>
								<rich:message for="disinfectionCabinetFeild2" />
								<h:outputLabel value="消毒方式:" for="disinfectionCabinetFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="disinfectionCabinetFeild6">
									<f:selectItems value="#{existDisinfectionCabinetType.typeItems}"/>
								</h:selectOneMenu>
								<rich:message for="disinfectionCabinetFeild6" />
							</h:panelGrid>
							
							<h:panelGrid id="gasStove" rendered="#{productCreate.currProductType == 'gasStove'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="燃烧器数量(P):" for="gasStovetFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="gasStoveFeild1"></h:inputText>
								<rich:message for="gasStoveFeild1" />
								<h:outputLabel value="适用气源:" for="gasStoveFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="gasStoveFeild6">
									<f:selectItems value="#{existGasStoveGasType.gasTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="gasStoveFeild6" />
								<h:outputLabel value="安装方式:" for="gasStoveFeild7"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field7}" id="gasStoveFeild7">
									<f:selectItems value="#{existGasStoveFitType.fitTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="gasStoveFeild7" />
							</h:panelGrid>
							
							<h:panelGrid id="gasWaterHeater" rendered="#{productCreate.currProductType == 'gasWaterHeater'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="gasWaterHeaterFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="gasWaterHeaterFeild1"></h:inputText>
								<rich:message for="gasWaterHeaterFeild1" />
								<h:outputLabel value="热水产率(L/min):" for="gasWaterHeaterFeild2"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field2}" id="gasWaterHeaterFeild2"></h:inputText>
								<rich:message for="gasWaterHeaterFeild2" />
								<h:outputLabel value="气源类型:" for="gasWaterHeaterFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="gasWaterHeaterFeild6">
									<f:selectItems value="#{existGasStoveGasType.gasTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="gasWaterHeaterFeild6" />
								<h:outputLabel value="排烟方式:" for="gasWaterHeaterFeild7"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field7}" id="gasWaterHeaterFeild7">
									<f:selectItems value="#{existGasWaterHeaterSmokeType.smokeTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="gasWaterHeaterFeild7" />
							</h:panelGrid>
							
							<h:panelGrid id="electricWaterHeater" rendered="#{productCreate.currProductType == 'electricWaterHeater'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="electricWaterHeaterFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="electricWaterHeaterFeild1"></h:inputText>
								<rich:message for="electricWaterHeaterFeild1" />
								<h:outputLabel value="加热功率(W):" for="electricWaterHeaterFeild2"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field2}" id="electricWaterHeaterFeild2"></h:inputText>
								<rich:message for="electricWaterHeaterFeild2" />
								<h:outputLabel value="额定水压(Mpa):" for="electricWaterHeaterFeild3"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field3}" id="electricWaterHeaterFeild3"></h:inputText>
								<rich:message for="electricWaterHeaterFeild3" />
								<h:outputLabel value="款式:" for="electricWaterHeaterFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="electricWaterHeaterFeild6">
									<f:selectItems value="#{existElectricWaterHeaterSetType.setTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="electricWaterHeaterFeild6" />
							</h:panelGrid>
							<h:panelGrid id="ventilator" rendered="#{productCreate.currProductType == 'ventilator'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="排风量(m³/min):" for="ventilatorFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="ventilatorFeild1"></h:inputText>
								<rich:message for="ventilatorFeild1" />
								<h:outputLabel value="功率(W):" for="ventilatorFeild2"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field2}" id="ventilatorFeild2"></h:inputText>
								<rich:message for="ventilatorFeild2" />
							</h:panelGrid>
							<h:panelGrid id="electricKettle" rendered="#{productCreate.currProductType == 'electricKettle'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容量(L):" for="electricKettleFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="electricKettleFeild1"></h:inputText>
								<rich:message for="electricKettleFeild1" />
								<h:outputLabel value="材质:" for="electricKettleFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="electricKettleFeild6">
									<f:selectItems value="#{existElectricKettleMaterialType.materialTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="electricKettleFeild6" />
							</h:panelGrid>
							<h:panelGrid id="electricFan" rendered="#{productCreate.currProductType == 'electricFan'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="功率(W):" for="electricFanFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="electricFanFeild1"></h:inputText>
								<rich:message for="electricFanFeild1" />
								<h:outputLabel value="档位:" for="electricFanFeild2"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field2}" id="electricFanFeild2"></h:inputText>
								<rich:message for="electricFanFeild2" />
								<h:outputLabel value="类型:" for="electricFanFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="electricFanFeild6">
									<f:selectItems value="#{existElectricFanSetType.setTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="electricFanFeild6" />
							</h:panelGrid>
							<h:panelGrid id="electricIron" rendered="#{productCreate.currProductType == 'electricIron'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="类别:" for="electricIronFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="electricIronFeild6">
									<f:selectItems value="#{existElectricIronSteamType.steamTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="electricIronFeild6" />
							</h:panelGrid>
							
							<h:panelGrid id="vacuumCleaner" rendered="#{productCreate.currProductType == 'vacuumCleaner'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="供电方式:" for="vacuumCleanerFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="vacuumCleanerFeild6">
									<f:selectItems value="#{existVacuumCleanerPowerSupplyType.powerSupplyTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="vacuumCleanerFeild6" />
								<h:outputLabel value="类型:" for="vacuumCleanerFeild7"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field7}" id="vacuumCleanerFeild7">
									<f:selectItems value="#{existVacuumCleanerUseType.useTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="vacuumCleanerFeild7" />
							</h:panelGrid>
							
							<h:panelGrid id="humidifier" rendered="#{productCreate.currProductType == 'humidifier'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="容积(L):" for="humidifierFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="humidifierFeild1"></h:inputText>
								<rich:message for="humidifierFeild1" />
								<h:outputLabel value="类别:" for="humidifierFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="humidifierFeild6">
									<f:selectItems value="#{existHumidifierUseType.useTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="humidifierFeild6" />
							</h:panelGrid>
							
							<h:panelGrid id="electricHeater" rendered="#{productCreate.currProductType == 'electricHeater'}" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
								<h:outputLabel value="功率(W):" for="electricHeaterFeild1"></h:outputLabel>
								<h:inputText value="#{productCreate.product.field1}" id="electricHeaterFeild1"></h:inputText>
								<rich:message for="electricHeaterFeild1" />
								<h:outputLabel value="类型:" for="electricHeaterFeild6"></h:outputLabel>
								<h:selectOneMenu value="#{productCreate.product.field6}" id="electricHeaterFeild6">
									<f:selectItems value="#{existElectricHeaterUseType.useTypeItems}"/>
								</h:selectOneMenu>
								<rich:message for="electricHeaterFeild6" />
							</h:panelGrid>
							
							<h:panelGrid columns="2" columnClasses="alight:left">
								<a4j:commandButton type="image" image="/css/images/blank.gif"></a4j:commandButton>
								<a4j:commandButton type="image" image="/css/images/createmyaccount.gif" action="#{productCreate.createProduct}"></a4j:commandButton>
								
							</h:panelGrid>
							</h:panelGroup>
						</f:facet>
					</h:panelGrid>
					</fieldset>
    			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	
