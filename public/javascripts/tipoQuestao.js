function definirBloco(){
	var select = document.getElementById('1');
		var option = select.options[select.selectedIndex];
		console.log(option);
		if (option.value == "objetiva") {
			document.getElementById("objetiva").style.display = "block";
			document.getElementById("discursiva").style.display = "none";
		} else if (option.value == "discursiva") {
			document.getElementById("discursiva").style.display = "block";
			document.getElementById("objetiva").style.display = "none";
		}
	}


function novaQuestao(){
	document.getElementById("newQuestao").style.display = "block";

}

function adicionarLi() {
  var questao  = document.getElementById("NewQuestao").value;
  
  
  var lista  = document.getElementById("lista").innerHTML;
  lista = lista +"<li>"+questao+"</li>";

  document.getElementById("lista").innerHTML = lista;
  
  //lista = lista +"<li>"+ document.getElementById("newQuestao")+"</li>";
  //document.getElementById("lista").innerHTML = lista;
  //document.getElementById("lista").style.display = "block";
  //document.getElementById("lista").innerHTML;
  //document.getElementById("NewQuestao").innerHTML;
 //var fru = document.getElementById("frutas").value;
  
  

  
}