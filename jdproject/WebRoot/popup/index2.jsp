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
         <script language="JavaScript"><!--
            function doPopup(source) {
               var country = source.form[source.form.id + ":country"];
               for (var i = 0; i < country.length; i++) {
                  if (country[i].checked) {
                     popup = window.open("popup2.jsf",
                        "popup", 
                        "height=300,width=500,toolbar=no,menubar=no,"
                        + "scrollbars=no");               
                     popup.openerFormId = source.form.id;
                     popup.focus();
                     var hidden = document.forms.hidden;
                     hidden["hidden:go"].value = "x"; // any value will do
                     hidden["hidden:country"].value = country[i].value;
                     hidden.submit();          
                  }
               }
            }               
         --></script>
         <title>A Simple Java Server Faces Application</title>
      </head>
      <body>
         <h:form>
            <table>
               <tr>
                  <td>Country:</td>
                  <td>
                     <h:selectOneRadio id="country" value="#{bb.country}">
                        <f:selectItem itemLabel="USA"  itemValue="USA"/>
                        <f:selectItem itemLabel="Canada"  itemValue="Canada"/>
                     </h:selectOneRadio>
                  </td>
               </tr>             
               <tr>
                  <td>State/Province:</td>
                  <td>
                     <h:inputText id="state" value="#{bb.state}"/>
                  </td>
                  <td>
                     <h:commandButton value="..."
                        onclick="doPopup(this); return false;"/><h:commandButton id="testid" action="#{bb.popudbclick}" actionListener="#{bb.ActionListenerTest}"></h:commandButton>
                  </td>
               </tr>
            </table>
            <p>
               <h:commandButton value="Next" action="next"/>
            </p>
         </h:form>

         <h:form id="hidden" target="popup">
            <h:inputHidden id="country" value="#{bb.country}"/>
            <h:commandLink id="go" action="showStates" value="">
               <f:verbatim/>
            </h:commandLink>
         </h:form>
      </body>
   </f:view>
</html>
</jsp:root>