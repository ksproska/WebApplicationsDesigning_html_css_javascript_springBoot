function onSliderChange(value) {
    const circle = document.getElementById("circle")
    circle.style.height = '' + value + 'px'
    circle.style.lineHeight = '' + value + 'px'
    circle.style.width = '' + value + 'px'
    circle.style.borderRadius = '' + (value * 2) + 'px'
    circle.innerText='' + value + 'px'
}

window.onload = (event) => {
    const slider = document.getElementById("slider")
    let initValue = 10
    slider.value = initValue
    onSliderChange(initValue)
}
