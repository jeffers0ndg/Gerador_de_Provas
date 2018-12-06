function cadastrar(){
    var req = new XMLHttpRequest();
    req.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            document.getElementById("novo").innerHTML = this.responseText;
        }
    };
    req.open("GET","cadastrar.jsp",true);
    req.send();
    
}
function editar(id){
    var req = new XMLHttpRequest();
    req.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            document.getElementById("novo").innerHTML = this.responseText;
        }
    };
    req.open("GET","editar.jsp?id="+id,true);
    req.send();
    
}

