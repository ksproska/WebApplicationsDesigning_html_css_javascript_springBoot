function getNoteCount() {
    let key = "note-count";
    let count = parseInt(localStorage.getItem(key));
    if (isNaN(count)) {
        count = 0;
    }
    return count;
}

function increaseNoteCount() {
    let count = getNoteCount() + 1;
    let key = "note-count";
    localStorage.setItem(key, count.toString());
}

function getCurrentIndex() {
    let key = "note-current";
    let index = parseInt(localStorage.getItem(key));
    if (isNaN(index)) {
        index = -1;
    }
    return index;
}

function setCurrentIndex(index) {
    let key = "note-current";
    localStorage.setItem(key, index.toString());
}

function saveNote() {
    let index = getCurrentIndex();
    if (index === -1) {
        index = getNoteCount() + 1;
    }
    console.log(`saving at: ${index}`)
    let key = "note-name-" + index;
    localStorage.setItem(key, document.getElementById("name").value);
    key = "note-content-" + index;+
    localStorage.setItem(key, document.getElementById("content").value);
    if (index >= getNoteCount()) {
        increaseNoteCount()
    }
    addItemsToList();
    document.getElementById("name").value = "";
    document.getElementById("content").innerText = "";
    setCurrentIndex(-1);
}

function loadNote(index) {
    console.log(`index: ${index}`)
    let key = "note-name-" + index;
    document.getElementById("name").value = localStorage.getItem(key);
    key = "note-content-" + index;
    document.getElementById("content").innerText = localStorage.getItem(key);
    setCurrentIndex(index)
}

function getNoteName(index) {
    let key = "note-name-" + index;
    return document.getElementById("name").value = localStorage.getItem(key);
}

function addItemsToList() {
    let list = document.getElementById("list");
    list.innerHTML = "";
    let count = getNoteCount();
    console.log(`count: ${count}`);
    for (let i = 0; i < count; i++) {
        let name = getNoteName(i);
        list.innerHTML += `<li><a href=\"javascript:loadNote(${i})\">${name}</a></li>`
    }
}

addItemsToList()
setCurrentIndex(-1)
