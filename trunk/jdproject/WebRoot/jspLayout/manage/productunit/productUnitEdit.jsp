<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view id="manageMainView">
<html>
	<head>
    <title>sdsdsdsdsd</title>
    </head>
    <body>
    	<ui:composition template="../manageTemplate.jsp">
    		<ui:define name="content">
    			<h:form id="productunitEditform">
    			<fieldset class="demo_fieldset">
				<legend class="demo_legend"><h:outputText value="#{manageHeaderMenu.menuTitle}" styleClass="simple-text"/></legend>
    			    <a4j:region id = "editregion" renderRegionOnly="false">
    			    <h:panelGrid id="editpanel" columns="3" rowClasses="table-row,table-odd-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
						<f:facet name="header">
							<h:outputText value="#{productUnitEdit.newProgressString}" id="newProgress"/>
            			</f:facet>
						<h:outputLabel id="labelname" value="单位名称：" for="unitName"></h:outputLabel>
						<h:inputText value="#{productUnitEdit.editProductUnit.unitName}" id="unitName">
							<rich:beanValidator summary="类型有误"/>
                		</h:inputText>
                		<rich:message for="unitName" />
                		<h:outputLabel id="labelnumber" value="单位序号：" for="serialNumber"></h:outputLabel>
						<h:inputText value="#{productUnitEdit.editProductUnit.serialNumber}" id="serialNumber" onblur="if(/\D/.test(this.value)){alert('只能输入数字');this.select();}">
                    		<rich:beanValidator summary="序号有误"/>
                    	</h:inputText>
                		<rich:message for="serialNumber" />
                		<h:outputText id="kongone" value=""></h:outputText>
							<h:panelGroup>
                				<a4j:commandButton id="actionupdate" action="#{productUnitEdit.updateProductUnit}" reRender="editpanel,table,sc2" value="更新"/>
								<h:outputText id="blankone" value="  "></h:outputText>
								<a4j:commandButton id="actionupdele" action="#{productUnitEdit.deleteProductUnit}" onclick="if (!confirm('确认删除此记录吗?')) return false;" reRender="editpanel,table,sc2" value="删除"/>
							</h:panelGroup>
                		<h:outputText id="kongtwo" value=" "></h:outputText>
					</h:panelGrid>
					</a4j:region>
					<a4j:region id="searchregion" renderRegionOnly="false">
					<h:panelGrid columns="3" columnClasses="table-one-column,table-two-column,table-three-column">
						<h:outputLabel id="labelsearch" value="按名称查询" for="searchProductUnitName"></h:outputLabel>
						
						<h:inputText id="searchProductUnitName" value="#{productUnitEdit.searchProductUnitName}">
								<a4j:support id="searchProductUnitNamesp" event="onblur" reRender="searchProductUnitName"></a4j:support>
						</h:inputText>
						<h:panelGroup>
							<a4j:commandButton id="searchbtn" action="#{productUnitEdit.searchProductUnitByName}" value="查询" limitToList="true" ajaxSingle="true" immediate="false" reRender="productunitlist,editpanel"></a4j:commandButton>
							<h:outputText id="blanktwo" value="  "></h:outputText>
							<a4j:commandButton id="allbtn" action="#{productUnitEdit.searchAllProductUnit}" value="所有" immediate="true" limitToList="true"  reRender="productunitlist,editpanel"></a4j:commandButton>
							<h:outputText id="recordnumberh" value="每页显示"></h:outputText>
							<h:selectOneMenu id="recordshownumber" value="#{productUnitEdit.recordNumberShow}">
								<f:selectItems id="recorednumbersitems" value="#{productUnitEdit.recordNumbers}"/>
								<a4j:support event="onchange" reRender="recordshownumber,table,sc2"></a4j:support>
							</h:selectOneMenu>
							<h:outputText id="recordnumberf" value="条"></h:outputText>
						</h:panelGroup>
					</h:panelGrid>
					</a4j:region>
					<a4j:region id = "tableregion" renderRegionOnly="false">
					<h:panelGrid columns="1" id="productunitlist"  columnClasses="top,top">
        			<rich:extendedDataTable value="#{productUnitEdit.productUnitsDataModel}" var="cat" id="table" rows="#{productUnitEdit.recordNumberShow}" frame="below" border="1" 
            		width="340px" height="254px" sortMode="#{productUnitEdit.sortMode}" 
                	selectionMode="#{productUnitEdit.selectionMode}"
                	selection="#{productUnitEdit.selection}"
                	binding="#{productUnitEdit.table}">
						<rich:column id="columnone" sortable="true" sortBy="#{cat.unitName}" width="170px" label="种类名称">
                			<f:facet name="header">
                    			<h:outputText id="headertextname" value="单位名称"/>
                			</f:facet>
                			<h:outputText value="#{cat.unitName}"/>
            			</rich:column> 
            			<rich:column id="columntwo" sortable="true" sortBy="#{cat.serialNumber}" width="170px" label="种类序号">
                			<f:facet name="header">
                    			<h:outputText id="headertextnumber" value="单位序号"/>
                			</f:facet>
                			<h:outputText value="#{cat.serialNumber}"/>
            			</rich:column> 
            		
						<a4j:support id="supportone" event="onclick" ignoreDupResponses="true" requestDelay="1"  action="#{productUnitEdit.takeSelection}"  reRender="editpanel" ajaxSingle="true"/>
            			<a4j:support id="supporttwo" event="onkeyup" ignoreDupResponses="true" requestDelay="1"  action="#{productUnitEdit.takeSelection}"  reRender="editpanel" ajaxSingle="true"/>
        				</rich:extendedDataTable>
      					<rich:datascroller align="left" for="table" maxPages="20"
						page="#{productUnitEdit.scrollerPage}" id="sc2"/>
        
        
        			</h:panelGrid>

					</a4j:region>
					</fieldset>
    			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	