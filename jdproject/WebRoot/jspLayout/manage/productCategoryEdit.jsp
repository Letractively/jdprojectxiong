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
    			<h:form id="productcategoryEditform">
    			<fieldset class="demo_fieldset">
				<legend class="demo_legend"><h:outputText value="#{manageHeaderMenu.menuTitle}"/></legend>
    			
    				<h:panelGrid id="editpanel" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
						<f:facet name="header">
                			<h:outputText value="#{productCategoryEdit.newProgressString}" id="newProgress"/>
            			</f:facet>
						<h:outputLabel id="labelname" value="类型名称：" for="categoryName"></h:outputLabel>
						<h:inputText value="#{productCategoryEdit.editProductCategory.categoryName}" id="categoryName">
							<!--<rich:beanValidator summary="类型有误"/> -->
                		</h:inputText>
                		<rich:message for="categoryName" />
                		<h:outputLabel id="labelnumber" value="类型序号：" for="serialNumber"></h:outputLabel>
						<h:inputText value="#{productCategoryEdit.editProductCategory.serialNumber}" id="serialNumber" onblur="if(/\D/.test(this.value)){alert('只能输入数字');this.select();}">
                    		<!-- <rich:beanValidator summary="序号有误"/> -->
                    	</h:inputText>
                		<rich:message for="serialNumber" />
                		<h:outputText id="kongone" value=""></h:outputText>
                			<a4j:commandButton id="actionupdate" action="#{productCategoryEdit.updateProductCategory}" reRender="editpanel" value="更新"/>
                		<h:outputText id="kongtwo" value=" "></h:outputText>
					</h:panelGrid>
					<h:panelGrid columns="3" columnClasses="table-one-column,table-two-column,table-three-column">
						<h:outputLabel id="labelsearch" value="按名称查询" for="searchProductCategoryName"></h:outputLabel>
						<h:inputText id="searchProductCategoryName" value="#{productCategoryEdit.searchProductCategoryName}"></h:inputText>
						<h:panelGroup>
							<a4j:commandButton id="searchbtn" action="#{productCategoryEdit.searchProductCategoryByName}" value="查询" immediate="true" reRender="productcategorylist"></a4j:commandButton>
							<a4j:commandButton id="allbtn" action="#{productCategoryEdit.searchAllProductCategory}" value="所有" immediate="true" reRender="productcategorylist"></a4j:commandButton>
						</h:panelGroup>
					</h:panelGrid>

					<h:panelGrid columns="1" id="productcategorylist"  columnClasses="top,top">
        			<rich:extendedDataTable value="#{productCategoryEdit.productCategorysDataModel}" var="cat" id="table" rows="15"
            		width="500px" height="280px" sortMode="#{productCategoryEdit.sortMode}" 
                	selectionMode="#{productCategoryEdit.selectionMode}"
                	selection="#{productCategoryEdit.selection}"
                	binding="#{productCategoryEdit.table}">
            			<rich:column id="columnone" sortable="true" sortBy="#{cat.categoryName}" width="170px" label="种类名称">
                			<f:facet name="header">
                    			<h:outputText id="headertextname" value="种类名称"/>
                			</f:facet>
                			<h:outputText value="#{cat.categoryName}"/>
            			</rich:column> 
            			<rich:column id="columntwo" sortable="true" sortBy="#{cat.serialNumber}" width="170px" label="种类序号">
                			<f:facet name="header">
                    			<h:outputText id="headertextnumber" value="种类序号"/>
                			</f:facet>
                			<h:outputText value="#{cat.serialNumber}"/>
            			</rich:column> 
            		
						<a4j:support id="supportone" event="onclick" ignoreDupResponses="true" requestDelay="500"  action="#{productCategoryEdit.takeSelection}" reRender="categoryName,serialNumber"/>
            			<a4j:support id="supporttwo" event="onkeyup" ignoreDupResponses="true" requestDelay="500"  action="#{productCategoryEdit.takeSelection}" reRender="categoryName,serialNumber"/>
        				</rich:extendedDataTable>
      					<rich:datascroller align="left" for="table" maxPages="20"
						page="#{productCategoryEdit.scrollerPage}" id="sc2"/>
        
        
        			</h:panelGrid>
					</fieldset>
    			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	