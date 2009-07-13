<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view>
<html>
	<head>
		<title></title>
	</head>
	<body bgcolor="white">
	
	<h:form id="indexform">
	<table border="0" cellpadding="5" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td bgcolor="#a4d67a"><span class="d-r"><b>Already a member? Sign in.</b></span>
				</td>
			</tr>
			<tr>
				<td style="border-left: 1px solid rgb(164, 214, 122); border-right: 1px solid rgb(164, 214, 122); border-bottom: 1px solid rgb(164, 214, 122); padding: 15px;" bgcolor="#e5f4d6">

					<table border="0" cellpadding="0" cellspacing="5" width="100%">
						<tbody>
							<tr>
								<td align="right" width="45%">
									<span class="d-r">Epinions.com ID:</span>
								</td>
								<td colspan="2" width="55%">
									<span class="d-r">
    								<h:inputText value="id"></h:inputText>
    								</span>

								</td>
							</tr>
							<tr>
								<td align="right">
									<span class="d-r">Password:</span>
								</td>
								<td colspan="2">
									<span class="d-r">
    								<h:inputSecret value=""></h:inputSecret>
    								</span>
								</td>
							</tr>
							<tr>
								<td width="38%"></td>
								<td valign="top" width="1%">
									<span class="d-r"></span>
								</td>
								<td width="57%">
								<span class="d-s">Save my password on this computer.</span>
								</td>
							</tr>
							<tr>
								<td colspan="3" height="6">
								</td>
							</tr>
							<tr>
								<td colspan="3" align="middle">
									<span class="d-r"><a href="http://www.epinions.com/login/forgot.html">Forgot your password?</a></span>
								</td>
							</tr>
							<tr>
								<td colspan="3" height="6">
								</td>
							</tr>
							<tr>
								<td colspan="3" align="center">
									<h:commandLink action="manageLogin">
										<h:graphicImage value="/css/images/signin.gif" style="border:0">
										</h:graphicImage>
									</h:commandLink>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
	</h:form>
	</body>	

</html>  
</f:view>
</jsp:root>
        		
       
