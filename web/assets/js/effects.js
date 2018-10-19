function energy() {
    let elem = document.getElementById("energy"),
        width = 1,
        id = setInterval(() => {
            if (width >= 100) {
        clearInterval(id)
    } else {
        width++;
        elem.style.width = width + '%';
        elem.innerHTML = width + '%';
    }
}, 10);
}