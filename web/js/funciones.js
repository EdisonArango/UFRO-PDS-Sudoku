
$(document).ready(function (){
          $('.solo-numero').keyup(function (){
            this.value = (this.value + '').replace(/[^0-9]/g, '');
          });
        });
        
function borrar() {
    $(".cuadrado").val('');
}


