// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
})()

function addRow() {
    const tbodyRef = document.getElementById('myTable')
        .getElementsByTagName('tbody')[0];
    const row = tbodyRef.insertRow();
    const cell1 = row.insertCell(0);
    const cell2 = row.insertCell(1);
    const cell3 = row.insertCell(2);
    const cell4 = row.insertCell(3);

    cell1.innerHTML = document.getElementById("name").value;
    cell2.innerHTML = document.getElementById("width").value;
    cell3.innerHTML = document.getElementById("height").value;
    cell4.innerHTML = document.getElementById("depth").value;

    cell2.classList.add("right")
    cell3.classList.add("right")
    cell4.classList.add("right")

    document.getElementById("sum").innerText =
        parseFloat(document.getElementById("sum").innerText) +
        parseFloat(document.getElementById("depth").value);
}
