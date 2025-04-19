document.getElementById('loan-form').addEventListener('click', function() {
    var id = this.getAttribute("book-id");
    const xhr = new XMLHttpRequest();
    fetch("/api/v1/books/status/" + id)
        .then(response => response.json())
        .then(data =>
            {
                if(data){
                    const form = document.createElement('form');
                    form.method = 'get';
                    form.action = '/loanbook/' + id;
                    document.body.appendChild(form);
                    form.submit();
                }
                else{
                    document.getElementById("loan-notification").style.display='flex';
                }
            }   
        )
        .catch(error =>
            console.error("Ошибка получения данных", error)
        )
})

function sendSubmit(){
    document.getElementById("return-confirmation").style.display="none";
    var id = document.getElementById('return-form').getAttribute("book-id");
    const xhr = new XMLHttpRequest();
    fetch("/api/v1/books/status/" + id)
            .then(response => response.json())
            .then(data =>
                {
                    if(data){
                        document.getElementById("return-notification").style.display='flex';
                    }
                    else{
                        const form = document.createElement('form');
                        form.method = 'post';
                        form.action = '/books/return/' + id;
                        document.body.appendChild(form);
                        form.submit();
                    }
                }   
            )
            .catch(error =>
                console.error("Ошибка получения данных", error)
            )
}