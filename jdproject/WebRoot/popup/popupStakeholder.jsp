<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<html>
   
   <f:view>
      <head>                  
         <script language="javascript">
            function reFreshParent() {
               window.opener.reFreshStakeholderInCreateProduct();
               window.close();
            }          
            function selectRowData() {
                processSelecteStakeholderMethodInPopupStakeholder();
            }     
         </script>
         <link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/common.css"/>
         <title>Select a state/province</title>
      </head>
      <body>
      	<h:form id="liststakeholerform">
      		<a4j:commandButton value="getdb" action="#{popupStakeholder.getStakeholderFromDb}" oncomplete="reFreshParent();"></a4j:commandButton>
			 <rich:dataTable id="stakeholderList" rowClasses="table-odd-row;table-even-row" width="483" rows="20" value="#{popupStakeholder.dataModel}" var="stakeholder" onRowDblClick="selectRowData();">            
                 <f:facet name="header">
                     <rich:columnGroup>
                         <h:column>
                             <h:outputText value="名称" />
                         </h:column>
                         <h:column>
                             <h:outputText value="省份" />
                         </h:column>
                         <h:column>
                             <h:outputText value="城市" />
                         </h:column>
                                                 
                     </rich:columnGroup>
                 </f:facet>
     				
                 <h:column>
                     <h:outputText value="#{stakeholder.fullName}" />
                     <a4j:jsFunction oncomplete="reFreshParent();" ajaxSingle="true" name="processSelecteStakeholderMethodInPopupStakeholder" action="#{popupStakeholder.getStakeholderRowData}">
   				</a4j:jsFunction>
                 </h:column>
                 <h:column>
                     <h:outputText value="#{stakeholder.province}" />
                     <a4j:jsFunction oncomplete="reFreshParent();" ajaxSingle="true" name="processSelecteStakeholderMethodInPopupStakeholder" action="#{popupStakeholder.getStakeholderRowData}">
   					</a4j:jsFunction>
                 </h:column> 
                 <h:column>
                     <h:outputText value="#{stakeholder.city}" />
                     <a4j:jsFunction oncomplete="reFreshParent();" ajaxSingle="true" name="processSelecteStakeholderMethodInPopupStakeholder" action="#{popupStakeholder.getStakeholderRowData}">
   				     </a4j:jsFunction>
                 </h:column>                 
             </rich:dataTable>
             <rich:datascroller for="stakeholderList" id="dcStakeholderList" page="#{popupStakeholder.scrollerPage}" style="width:483px"/>
         </h:form>    
			
      </body>
   </f:view>
</html>
</jsp:root>