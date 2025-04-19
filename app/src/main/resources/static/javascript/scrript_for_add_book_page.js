function sendSubmit(){
    document.getElementById("confirmation").style.display="none";
    const form = document.getElementById("form");
    var inputs = form.getElementsByTagName('input');
    var isEmpty = false;
    for(i=0; i<inputs.length; i++){
        if(inputs[i].getAttribute("notEmpty") !== null){
            if(inputs[i].value === ""){
                inputs[i].style.backgroundColor = "#bf24248a";
                isEmpty = true;
            }
        }
    }
    if(!isEmpty){
        form.submit();
    }
}