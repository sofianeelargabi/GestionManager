$(document).ready(function () {
    $('#dtBasicExample').DataTable();
    $('.dataTables_length').addClass('bs-select');
  });



function onButtonClick(){       
var answer;   
answer = window.confirm("Etes-vous sûr de vouloir ajouter ce client ?");     
 if (answer == true) {
     return true;
  } else {
     return false;
  }
}
function onButtonDeco(){       
	var answer;   
	answer = window.confirm("Etes-vous sûr de vouloir vous déconnecter ?");     
	 if (answer == true) {
	     return true;
	  } else {
	     return false;
	  }
	}

