function onSliderChange(value) {
    const circle = document.getElementById("circle");
    circle.style.height = '' + value + 'px'
    circle.style.lineHeight = '' + value + 'px'
    circle.style.width = '' + value + 'px'
    circle.style.borderRadius = '' + (value * 2) + 'px'
    const center = document.getElementById("center");
    center.innerText='' + value + 'px'
}

// const slider = document.getElementById("myRange");
// slider.oninput = function () {
//     onSliderChange(this.value)
// }