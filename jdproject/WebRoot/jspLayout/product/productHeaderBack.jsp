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
<DIV id="header_bar">
<DIV id="header_bar_left"></DIV>
<DIV id="header_bar_right">
<UL>
  <LI><A 
  onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.qkankan.com/');" 
  href="http://www.qkankan.com/">设为首页</A></LI>
  <LI class="fav"><A 
  href="javascript:addBookmark('国外网站大全','http://www.qkankan.com')">加入收藏</A></LI>
  <LI class="msg"><A 
  href="http://www.qkankan.com/e/tool/gbook/?bid=1">网友留言</A></LI></UL>
</DIV>
</DIV>

<DIV id="top"><A id="gotop"></A>
<DIV id="toplogo"><A href="http://www.qkankan.com/"><IMG style="border-style:none"
onmouseover="showDiv('logoHomeTip');" onMouseOut="hideDiv('logoHomeTip');" 
height="65" alt="国外网站大全" src="国外品牌.files/logo.gif" width="225"></IMG></A></DIV>
<DIV id="logoHomeTip" style="DISPLAY: none">首页</DIV>
<DIV id="topad">
<UL>
  <LI><A href="http://www.amazon.cn/?source=qkankan" target="_blank"><IMG 
  height="60" src="国外品牌.files/joyo.gif" width="100" style="border-style:none"></IMG></A> </LI>
  <LI><A 
  href="http://www.bjyouxi.com/member/sss/index.php?gameid=200&amp;spread=qkgg" 
  target="_blank"><IMG height="60" src="国外品牌.files/game.jpg" width="468" style="border-style:none"></IMG></A> </LI>
  <LI><A 
  href="http://union.dangdang.com/transfer/transfer.aspx?from=P-263291&amp;backurl=http://book.dangdang.com" 
  target="_blank"><IMG height="60" src="国外品牌.files/dangdang.gif" width="100" style="border-style:none"></IMG></A> 
</LI></UL>
</DIV>
</DIV>

<DIV id="header_menu">
<DIV id="header_menu_left"></DIV>
<DIV id="header_menu_middle">
<DIV id="header_menu_link">
<UL>
  <LI class="#{headerTabPanel.currentPrimaryCategory == ''?'select':''}"><A class="on" href="${facesContext.externalContext.requestContextPath}"><h:outputText value="首页"/></A> </LI>
  <LI class="#{headerTabPanel.currentPrimaryCategory == '01'?'select':''}"><A class="on" href="${facesContext.externalContext.requestContextPath}/jspLayout/product/KitchenAppliance/kitchenAppliance.jsf"><h:outputText value="#{headerTabPanel.kitchenAppliance.mainMenu.label}"/></A> </LI>
  <LI class="#{headerTabPanel.currentPrimaryCategory == '02'?'select':''}"><A class="on" href="http://www.qkankan.com/gangaotai/all/"><h:outputText value="#{headerTabPanel.householdAppliance.mainMenu.label}"/></A> </LI>
  <LI class="#{headerTabPanel.currentPrimaryCategory == '03'?'select':''}"><A class="on" href="http://www.qkankan.com/guowaimingxing.html"><h:outputText value="#{headerTabPanel.personalCare.mainMenu.label}"/></A> </LI>
  <LI class="#{headerTabPanel.currentPrimaryCategory == '04'?'select':''}"><A class="on" href="http://www.qkankan.com/brand/"><h:outputText value="#{headerTabPanel.healthDevice.mainMenu.label}"/></A> </LI>
  <LI class="#{headerTabPanel.currentPrimaryCategory == '05'?'select':''}"><A class="on" href="http://www.qkankan.com/webpic/composite/"><h:outputText value="#{headerTabPanel.majorAppliance.mainMenu.label}"/></A> </LI>
  <LI class="#{headerTabPanel.currentPrimaryCategory == '06'?'select':''}"><A class="on" href="http://www.qkankan.com/zaixianfanyi.html"><h:outputText value="#{headerTabPanel.phoneDigital.mainMenu.label}"/></A> </LI>
  <LI class="#{headerTabPanel.currentPrimaryCategory == '07'?'select':''}"><A class="on" href="http://www.qkankan.com/zaixianfanyi.html"><h:outputText value="#{headerTabPanel.computerNetwork.mainMenu.label}"/></A> </LI>
 </UL>
</DIV>
<DIV id="header_menu_new"></DIV>
<DIV id="header_menu_words">
<UL>
  <LI><A href="http://www.qkankan.com/europe/germany/commerce/200801/604.html" 
  target="_blank">阿迪达斯</A> | <A 
  href="http://www.qkankan.com/europe/france/commerce/200711/219.html" 
  target="_blank">兰蔻</A> | <A 
  href="http://www.qkankan.com/asia/japan/commerce/200810/1298.html" 
  target="_blank">西铁城</A> | <A 
  href="http://www.qkankan.com/africa/south-africa/commerce/200810/1302.html" 
  target="_blank">戴比尔斯</A> | <A 
  href="http://www.qkankan.com/asia/korea/commerce/200809/1195.html" 
  target="_blank">百家好</A> | <A 
  href="http://www.qkankan.com/north-america/america/commerce/200812/1530.html" 
  target="_blank">Zippo</A> | <A 
  href="http://www.qkankan.com/europe/france/commerce/200801/511.html" 
  target="_blank">路易威登</A> | <A 
  href="http://www.qkankan.com/asia/japan/commerce/2007-11-14/152.html" 
  target="_blank">爱普生</A> | <A 
  href="http://www.qkankan.com/north-america/america/commerce/200812/1531.html" 
  target="_blank">哈根达斯</A> | <A 
  href="http://www.qkankan.com/asia/japan/car/200712/446.html" 
  target="_blank">丰田</A> | </LI>
  <LI class="search">
   <h:panelGrid id="searchtable" columns="3" columnClasses="header-search-panel-grid-one,header-search-panel-grid-two,header-search-panel-grid-three">
   		<h:outputText value="商品ID" ></h:outputText>
   		<h:inputText value="ddd"></h:inputText>
   		<h:outputText value="ddd"></h:outputText>
   </h:panelGrid>
  
  </LI></UL></DIV></DIV>
<DIV id="header_menu_right"></DIV></DIV>
</a4j:region>
	

</h:form>
</f:subview>		
</jsp:root>	