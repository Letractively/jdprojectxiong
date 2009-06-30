<script language="JavaScript">
            function doPopup(source) {
        	alert("in");
               var searchName = source.form[source.form.id + ":searchName"];
               var statusItem = "A";
               var typeItem = "P";
               var compomentId = "productform" + ":productProviderFullName";
               var facesBean = "productCreate";
               var propertyOfFacesBean = "product.provider";
               if (searchName.length > 2) {
                     popup = window.open("../../../popug/popupStakeholder.jsf",
                        "popup", 
                        "height=300,width=500,toolbar=no,menubar=no,"
                        + "scrollbars=no");               
                     popup.openerFormId = source.form.id;
                     popup.focus();
                     var hidden = document.forms.hidden;
                     hidden["hidden:go"].value = "x"; // any value will do
                     hidden["hidden:searchName"].value = searchName.value;
                     hidden["hidden:statusItem"].value = statusItem;
                     hidden["hidden:typeItem"].value = typeItem;
                     hidden["hidden:compomentId"].value = compomentId
                     hidden["hidden:facesBean"].value = facesBean;
                     hidden["hidden:propertyOfFacesBean"].value = propertyOfFacesBean;
                     hidden.submit();          
                }
               
            }               
</script>
