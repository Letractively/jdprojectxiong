<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="manageTemplateView">
<script src="${facesContext.externalContext.requestContextPath}/css/jquery131.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/css.css" />

<DIV id="menu_btn" 
style="Z-INDEX: 200; FLOAT: left; POSITION: relative; HEIGHT: 70px"><SPAN 
id="litbBtn"
style="DISPLAY: block; Z-INDEX: 11; BACKGROUND: url(http://image.lightinthebox.com/includes/templates/dev_v2/images/english/button/menu_arrow.gif) no-repeat; LEFT: 160px; OVERFLOW: hidden; WIDTH: 16px; CURSOR: pointer; POSITION: absolute; TOP: 18px; HEIGHT: 17px"></SPAN>
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
  <LI><A title="wholesale Cell Phones" href="http://www.lightinthebox.com/wholesale-Cell-Phones_c206">Cell Phones<!--[if IE 7]><!--></A><!--<![endif]--><!--[if lte IE 6]> 
  <TABLE>
    <TBODY>
    <TR>
      <TD><![endif]-->
        <UL class="select-free">
          <DIV>
          <LI class="b_top"><A title="wholesale HiPhone" 
          href="http://www.lightinthebox.com/wholesale-HiPhone_c1498">HiPhone(172)</A> 
          </LI>
          <LI><A title="wholesale Multi Function Cell Phones" 
          href="http://www.lightinthebox.com/wholesale-Multi-Function-Cell-Phones_c209">Multi 
          Function Cell Phones(1991)</A> </LI>
          <LI><A title="wholesale Bar Phone" 
          href="http://www.lightinthebox.com/wholesale-Bar-Phone_c2204">Bar 
          Phone(821)</A> </LI>
          <LI><A title="wholesale Slide Phone" 
          href="http://www.lightinthebox.com/wholesale-Slide-Phone_c2205">Slide 
          Phone(246)</A> </LI>
          <LI><A title="wholesale Flip Phone" 
          href="http://www.lightinthebox.com/wholesale-Flip-Phone_c2206">Flip 
          Phone(107)</A> </LI>
          <LI><A title="wholesale Watch Cell Phone" 
          href="http://www.lightinthebox.com/wholesale-Watch-Cell-Phone_c1298">Watch 
          Cell Phone(37)</A> </LI>
          <LI><A title="wholesale New Cell Phones" 
          href="http://www.lightinthebox.com/wholesale-New-Cell-Phones_c2706">New 
          Cell Phones(98)</A> </LI>
          <LI><A title="wholesale Cheap Cell Phones" 
          href="http://www.lightinthebox.com/wholesale-Cheap-Cell-Phones_c2740">Cheap 
          Cell Phones(79)</A> </LI>
          <LI><A title="wholesale Brand Cell Phones" 
          href="http://www.lightinthebox.com/wholesale-Brand-Cell-Phones_c207">Brand 
          Cell Phones(10)</A> </LI>
          <LI><A title="More Cell Phones" 
          href="http://www.lightinthebox.com/wholesale-Cell-Phones_c206">All 
          Cell Phones 
  </A></LI></DIV></UL><!--[if lte IE 6]></TD></TR></TBODY></TABLE></A><![endif]--></LI>
</UL></DIV>
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
	 $("#litbBtn").bind("mouseover", function(){alert("bind");closeMenu=false;controlMenu();}); 
	 $("#litbCon2").hover(function(){alert("hover");closeMenu=false;setTimeout(controlMenu, 2000)}, function(){closeMenu=true;setTimeout(controlMenu, 2000);});
	</SCRIPT>

<DIV></DIV>

</f:subview>
</jsp:root>
