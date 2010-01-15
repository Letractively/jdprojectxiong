<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="headerBackView">
<h:form id="mainheaderform">
<a4j:region id="mainheaderFormRegion" renderRegionOnly="false" selfRendered="true">
<DIV id="logoarea">
<DIV id="logoarea_top"><IMG id="logort" alt="" src="${facesContext.externalContext.requestContextPath}/css/images/icons/bg_logo_right.png"></IMG><IMG 
id="logolt" alt="" src="${facesContext.externalContext.requestContextPath}/css/images/icons/bg_logo_left.png"></IMG><A 
href="http://slickdeals.net/"><IMG src="${facesContext.externalContext.requestContextPath}/css/images/icons/company_logo.png" style="border:0px #fff solid"></IMG></A>
<DIV id="ads-top" style="BORDER-RIGHT: #ddd 1px solid; BORDER-TOP: #ddd 1px solid; BORDER-LEFT: #ddd 1px solid; BORDER-BOTTOM: #ddd 1px solid">

</DIV></DIV>
<DIV class="groupmsg" id="dealalertmsgfinal">Wanna find the latest deals on the go? 
Try out the <A href="http://m.slickdeals.net/"><B>Slickdeals Mobile 
Website</B></A> on your phone! <A 
onclick="togglewelcome('dealalertmsgfinal'); return false" 
href="http://slickdeals.net/coupons.php?&amp;dealalertmsgfinal=1">Hide this 
message.</A></DIV></DIV>
<DIV class="menu2" id="menu2">
	<UL>
	<LI id="main_menu_00"><A class="menu2one #{headerTabPanel.currentPrimaryCategory == ''?'selected':''}" href="http://slickdeals.net/">首页</A></LI>
  	<LI id="main_menu_01"><A class="menu2one #{headerTabPanel.currentPrimaryCategory == '01'?'selected':''}" href="http://slickdeals.net/"><h:outputText value="#{headerTabPanel.kitchenAppliance.mainMenu.label}"/></A></LI>
  	<LI id="main_menu_02"><A class="menu2two #{headerTabPanel.currentPrimaryCategory == '02'?'selected':''}" href="http://slickdeals.net/coupons.php"><h:outputText value="#{headerTabPanel.householdAppliance.mainMenu.label}"/></A></LI>
  	<LI id="main_menu_03"><A class="menu2three #{headerTabPanel.currentPrimaryCategory == '03'?'selected':''}" href="http://slickdeals.net/forums"><h:outputText value="#{headerTabPanel.personalCare.mainMenu.label}"/></A></LI>
  	<LI id="main_menu_04"><A class="menu2four #{headerTabPanel.currentPrimaryCategory == '04'?'selected':''}" href="http://blog.slickdeals.net/"><h:outputText value="#{headerTabPanel.healthDevice.mainMenu.label}"/></A></LI>
  	<LI id="main_menu_05"><A class="menu2five #{headerTabPanel.currentPrimaryCategory == '05'?'selected':''}" href="http://slickdeals.net/forums/sdmisc.php"><h:outputText value="#{headerTabPanel.majorAppliance.mainMenu.label}"/></A></LI>
	<LI id="main_menu_06"><A class="menu2six #{headerTabPanel.currentPrimaryCategory == '06'?'selected':''}" href="http://slickdeals.net/forums/sdmisc.php"><h:outputText value="#{headerTabPanel.phoneDigital.mainMenu.label}"/></A></LI>
	<LI id="main_menu_07"><A class="menu2seven #{headerTabPanel.currentPrimaryCategory == '07'?'selected':''}" href="http://slickdeals.net/forums/sdmisc.php"><h:outputText value="#{headerTabPanel.computerNetwork.mainMenu.label}"/></A></LI>
	</UL>
</DIV>
</a4j:region>
	

</h:form>
</f:subview>		
</jsp:root>	