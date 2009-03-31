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
    	<ui:composition template="./manageTemplate.jsp">
    		<ui:define name="content">
    			<h:form id="productbrandEditform">
    			<fieldset class="demo_fieldset">
				<legend class="demo_legend"><h:outputText value="#{manageHeaderMenu.menuTitle}" styleClass="simple-text"/></legend>
    			    <a4j:region id = "editregion" renderRegionOnly="false">
    			    <h:panelGrid id="editpanel" columns="3" rowClasses="table-row,table-odd-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
						<f:facet name="header">
							<h:outputText value="#{productBrandEdit.newProgressString}" id="newProgress"/>
            			</f:facet>
						<h:outputLabel id="labelname" value="类型名称：" for="brandName"></h:outputLabel>
						<h:inputText value="#{productBrandEdit.editProductBrand.brandName}" id="brandName">
							<rich:beanValidator summary="类型有误"/>
                		</h:inputText>
                		<rich:message for="brandName" />
                		<h:outputLabel id="labelnumber" value="类型序号：" for="serialNumber"></h:outputLabel>
						<h:inputText value="#{productBrandEdit.editProductBrand.serialNumber}" id="serialNumber" onblur="if(/\D/.test(this.value)){alert('只能输入数字');this.select();}">
                    		<rich:beanValidator summary="序号有误"/>
                    	</h:inputText>
                		<rich:message for="serialNumber" />
                		<h:outputText id="kongone" value=""></h:outputText>
							<h:panelGroup>
                				<a4j:commandButton id="actionupdate" action="#{productBrandEdit.updateProductBrand}" reRender="editpanel,table,sc2" value="更新"/>
								<h:outputText id="blankone" value="  "></h:outputText>
								<a4j:commandButton id="actionupdele" action="#{productBrandEdit.deleteProductBrand}" onclick="if (!confirm('确认删除此记录吗?')) return false;" reRender="editpanel,table,sc2" value="删除"/>
							</h:panelGroup>
                		<h:outputText id="kongtwo" value=" "></h:outputText>
					</h:panelGrid>
					</a4j:region>
					<a4j:region id="searchregion" renderRegionOnly="false">
					<h:panelGrid columns="3" columnClasses="table-one-column,table-two-column,table-three-column">
						<h:outputLabel id="labelsearch" value="按名称查询" for="searchProductBrandName"></h:outputLabel>
						
						<h:inputText id="searchProductBrandName" value="#{productBrandEdit.searchProductBrandName}">
								<a4j:support id="searchProductBrandNamesp" event="onblur" reRender="searchProductBrandName"></a4j:support>
						</h:inputText>
						<h:panelGroup>
							<a4j:commandButton id="searchbtn" action="#{productBrandEdit.searchProductBrandByName}" value="查询" limitToList="true" ajaxSingle="true" immediate="false" reRender="productbrandlist,editpanel"></a4j:commandButton>
							<h:outputText id="blanktwo" value="  "></h:outputText>
							<a4j:commandButton id="allbtn" action="#{productBrandEdit.searchAllProductBrand}" value="所有" immediate="true" limitToList="true"  reRender="productbrandlist,editpanel"></a4j:commandButton>
							<h:outputText id="recordnumberh" value="每页显示"></h:outputText>
							<h:selectOneMenu id="recordshownumber" value="#{productBrandEdit.recordNumberShow}">
								<f:selectItems id="recorednumbersitems" value="#{productBrandEdit.recordNumbers}"/>
								<a4j:support event="onchange" reRender="recordshownumber,table,sc2"></a4j:support>
							</h:selectOneMenu>
							<h:outputText id="recordnumberf" value="条"></h:outputText>
						</h:panelGroup>
					</h:panelGrid>
					</a4j:region>
					<a4j:region id = "tableregion" renderRegionOnly="false">
					<h:panelGrid columns="1" id="productbrandlist"  columnClasses="top,top">
        			<rich:extendedDataTable value="#{productBrandEdit.productBrandsDataModel}" var="cat" id="table" rows="#{productBrandEdit.recordNumberShow}" frame="below" border="1" 
            		width="340px" height="254px" sortMode="#{productBrandEdit.sortMode}" 
                	selectionMode="#{productBrandEdit.selectionMode}"
                	selection="#{productBrandEdit.selection}"
                	binding="#{productBrandEdit.table}">
						<rich:column id="columnone" sortable="true" sortBy="#{cat.brandName}" width="170px" label="种类名称">
                			<f:facet name="header">
                    			<h:outputText id="headertextname" value="种类名称"/>
                			</f:facet>
                			<h:outputText value="#{cat.brandName}"/>
            			</rich:column> 
            			<rich:column id="columntwo" sortable="true" sortBy="#{cat.serialNumber}" width="170px" label="种类序号">
                			<f:facet name="header">
                    			<h:outputText id="headertextnumber" value="种类序号"/>
                			</f:facet>
                			<h:outputText value="#{cat.serialNumber}"/>
            			</rich:column> 
            		
						<a4j:support id="supportone" event="onclick" ignoreDupResponses="true" requestDelay="1"  action="#{productBrandEdit.takeSelection}"  reRender="editpanel" ajaxSingle="true"/>
            			<a4j:support id="supporttwo" event="onkeyup" ignoreDupResponses="true" requestDelay="1"  action="#{productBrandEdit.takeSelection}"  reRender="editpanel" ajaxSingle="true"/>
        				</rich:extendedDataTable>
      					<rich:datascroller align="left" for="table" maxPages="20"
						page="#{productBrandEdit.scrollerPage}" id="sc2"/>
        
        
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