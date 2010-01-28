<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich"
xmlns:c="http://java.sun.com/jstl/core">
<f:subview id="scrollmouseView">
<script src="${facesContext.externalContext.requestContextPath}/css/jquery131.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/css.css" />

<DIV id="menu_btn" 
style="Z-INDEX: 200; FLOAT: left; POSITION: relative; HEIGHT: 32px"><SPAN 
id="litbBtn"
style="DISPLAY: block; Z-INDEX: 11; BACKGROUND: url(${facesContext.externalContext.requestContextPath}/css/images/icons/i_down2.gif) no-repeat; LEFT: 160px; OVERFLOW: hidden; WIDTH: 16px; CURSOR: pointer; POSITION: absolute; TOP: 18px; HEIGHT: 17px"></SPAN>
<DIV class="absolute" id="litbCon1">
<UL id="menu_index_top">
  <LI><A title="See All Categories" 
  href="http://www.lightinthebox.com/see-all.html" target="_top"><SPAN>See All 
  Categories</SPAN></A> </LI></UL>
</DIV><!-- leftmenustart -->
<DIV class="absolute" id="litbCon2" style="DISPLAY: none"><!-- BOF Categories Menu -->
<DIV id="left_menu">
<UL id="menu_index_top">
  <LI><A title="See All Categories" href="http://www.lightinthebox.com/see-all.html" target="_top"><SPAN>See All Categories</SPAN> </A></LI></UL><!-- ####menu### -->
<DIV class="menu" id="light_menu">
<UL>
  <LI><A title="wholesale Cell Phones" href="http://www.lightinthebox.com/wholesale-Cell-Phones_c206"><h:outputText value="#{headerTabPanel.kitchenAppliance.mainMenu.label}"/><!--[if IE 7]><!--></A><!--<![endif]--><!--[if lte IE 6]> 
  <TABLE>
    <TBODY>
    <TR>
      <TD><![endif]-->
        <UL class="select-free">
          <DIV>
          <c:forEach items="#{headerTabPanel.kitchenAppliance.subMenu}" var="subMenu" begin="1" step="1">
          	<LI class="#{subMenu.idSecond=='01'?'b_top':''}"><h:commandLink action="#{headerTabPanel.gotoProduct}" title="#{subMenu.label}" immediate="true"><f:param name="idFirst" value="#{subMenu.idFirst}"></f:param>
										<f:param name="idSecond" value="#{subMenu.idSecond}"></f:param>
										<f:param name="productType" value="#{subMenu.name}"></f:param>
										<a4j:actionparam name="kitchenApplianceMainMenuName" value="#{headerTabPanel.kitchenAppliance.mainMenu.name}" assignTo="#{productPanelBar.currentBar}"></a4j:actionparam><h:outputText value="#{subMenu.label}"/></h:commandLink>
          	</LI>
									
		  </c:forEach>
  	    </DIV>
  	  </UL><!--[if lte IE 6]></TD></TR></TBODY></TABLE></A><![endif]--></LI>
</UL>
</DIV>
</DIV><!-- EOF Categories Menu --></DIV><!-- ####menu### --></DIV>
<SCRIPT type="text/javascript">
	var closeMenu = true;
	function controlMenu(){
		if(closeMenu){
			$("#litbCon2").hide();$("#litbBtn").css({backgroundPosition:"0 0"});
		}else{
			$("#litbCon2").show();$("#litbBtn").css({backgroundPosition:"0 -16px"});
		}
	}
	 $("#litbBtn").bind("mouseover", function(){closeMenu=false;controlMenu();}); 
	 $("#litbCon2").hover(function(){closeMenu=false;setTimeout(controlMenu, 1000)}, function(){closeMenu=true;setTimeout(controlMenu, 1000);});
	</SCRIPT>

<DIV></DIV>

</f:subview>
</jsp:root>
