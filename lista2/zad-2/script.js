(function () {
    'use strict'
    const forms = document.querySelectorAll('.needs-validation');
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

    const cellName = row.insertCell(0);
    const cellWidth = row.insertCell(1);
    const cellHeight = row.insertCell(2);
    const cellDepth = row.insertCell(3);
    const cellVolume = row.insertCell(4);
    const cellSum = document.getElementById("sum");

    cellWidth.classList.add("right")
    cellHeight.classList.add("right")
    cellDepth.classList.add("right")
    cellVolume.classList.add("right")

    let name = document.getElementById("name").value;
    let width = document.getElementById("width").value;
    let height = document.getElementById("height").value;
    let depth = document.getElementById("depth").value;
    let volume = (parseFloat(width) * parseFloat(height) * parseFloat(depth));
    let sum = parseFloat(cellSum.innerText) + volume;

    cellName.innerHTML = name;
    cellWidth.innerHTML = width;
    cellHeight.innerHTML = height;
    cellDepth.innerHTML = depth;
    cellVolume.innerHTML = volume.toFixed(2);
    cellSum.innerText = sum.toFixed(2);
}
