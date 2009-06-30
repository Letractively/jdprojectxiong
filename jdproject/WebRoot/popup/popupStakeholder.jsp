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
            function doSave(value) {
               formId = window.openerFormId;
               opener.document.forms[formId][formId + ":state"].value = value;
               window.close();
            }               
         </script>
         <title>Select a state/province</title>
      </head>
      <body>
      	<h:form id="liststakeholerform">
			 <rich:dataTable id="stakeholderList" width="483" rows="20" value="#{popupStakeholder.dataModel}" var="stakeholder">            
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
                         province
                                                 
                     </rich:columnGroup>
                 </f:facet>
     
                 <h:column>
                     <h:outputText value="#{stakeholder.fullName}" />
                 </h:column>
                 <h:column>
                     <h:outputText value="#{stakeholder.province}" />
                 </h:column> 
                 <h:column>
                     <h:outputText value="#{stakeholder.city}" />
                 </h:column>                 
             </rich:dataTable>
             <rich:datascroller for="stakeholderList" id="dcStakeholderList" style="width:483px"/>
         </h:form>    
			
      </body>
   </f:view>
</html>
</jsp:root>