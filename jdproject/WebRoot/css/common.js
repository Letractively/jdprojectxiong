//var contentPath = ${facesContext.externalContext.requestContextPath};
function searchStakehoderBegin(){
   alert("good");
   var _name = "good";
   processSearchStakeholderMethod();
}
function changeFinish(data){
   alert("finish");
   alert(data);
   if (undefined == data || data.length <2) {
	   //do nothing
   } else {
   popup = window.open("./popup/popupStakeholder.jsf",
           "popup", 
           "height=300,width=500,toolbar=no,menubar=no,"
           + "scrollbars=no");               
        popup.openerFormId = source.form.id;
        popup.focus();
   }
}