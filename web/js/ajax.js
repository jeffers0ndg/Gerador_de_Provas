function ola(){
    ajax = new XMLHttpRequest();
    //var url = "../QuestaoServlet?op=cadastrar";
    var url = "../QuestaoServlet";
    ajax.open("POST",url,true);
    ajax.onreadystatechange = function (){
        if(ajax.readyState == 4 && ajax.status == 200){
            document.getElementById('res').innerHTML = ajax.responseText;
        }
    }
    ajax.send();
}
