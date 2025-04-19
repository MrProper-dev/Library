window.onload = function() {
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    var table = document.getElementById("books");
    var rows = table.getElementsByTagName("tr");

    for (var i = 0; i < rows.length; i++) {
        var cells = rows[i].getElementsByTagName("td");
        if(new Date(cells[9].textContent).setHours(0, 0, 0, 0) < today.getTime()){
            rows[i].style.backgroundColor = "#a23838";
        }
    }
};