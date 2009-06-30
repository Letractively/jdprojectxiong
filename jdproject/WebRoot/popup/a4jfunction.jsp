<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<script language="javascript">
function changeBegin(){
   alert("good");
   var _name = "good";
   processMethod();
}
function changeFinish(data){
   alert("finish");
   alert(data);
   popup = window.open("${facesContext.externalContext.requestContextPath}/popup/popupStakeholder.jsf",
           "popup", 
           "height=300,width=500,toolbar=no,menubar=no,"
           + "scrollbars=no");               
        popup.openerFormId = source.form.id;
        popup.focus();
}
</script>
<body>
<h:form>
   <a4j:jsFunction oncomplete="changeFinish(data);" name="processMethod"
    data="#{valueChangeTest.name},#{valueChangeTest.age}"
    actionListener="#{valueChangeTest.ActionListenerTest}"
    action="#{valueChangeTest.valueChange}">

    <a4j:actionparam name="param1" value="what"
     assignTo="#{valueChangeTest.name}" />
     <a4j:actionparam name="param2" value="29"
     assignTo="#{valueChangeTest.age}" />
   </a4j:jsFunction>

<a4j:commandButton type="button"  value="good" onclick="changeBegin();return false;" />
</h:form>
</body>
</jsp:root>