/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function initDialog() {
 $("#idDetails").dialog({
     modal: true,
     buttons: {
            Zamknij: function () {
                $(this).dialog("close");
            }
     },
 });
}