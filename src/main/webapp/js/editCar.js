/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function initDialog() {
 $("#idEditCar").dialog({
     modal: true,
     buttons: {
            Edytuj: function () {
                $("#updateCar").click();
            },
            Zamknij: function () {
                $(this).dialog("close");
            }
     },
 });
}

