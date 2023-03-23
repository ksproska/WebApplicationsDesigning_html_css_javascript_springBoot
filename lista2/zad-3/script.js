const noteCountKey = "note-count";
const noteCurrentKey = "note-current";

function getNoteCount() {
    let count = parseInt(localStorage.getItem(noteCountKey));
    if (isNaN(count)) {
        count = 0;
    }
    return count;
}

function increaseNoteCount() {
    let count = getNoteCount() + 1;
    localStorage.setItem(noteCountKey, count.toString());
}

function getCurrentIndex() {
    let index = parseInt(localStorage.getItem(noteCurrentKey));
    if (isNaN(index)) {
        index = -1;
    }
    return index;
}

function setCurrentIndex(index) {
    localStorage.setItem(noteCurrentKey, index.toString());
}

function makeNote(index) {
    const noteNameKey = "note-name-";
    const noteContentKey = "note-content-";
    return {
        index: index,
        load: function () {
            let key = noteNameKey + index;
            document.getElementById("name").value = localStorage.getItem(key);
            key = noteContentKey + index;
            document.getElementById("content").innerText = localStorage.getItem(key);
            setCurrentIndex(index)
        },
        save: function () {
            let key = noteNameKey + index;
            localStorage.setItem(key, document.getElementById("name").value);
            key = noteContentKey + index;
            localStorage.setItem(key, document.getElementById("content").value);
            if (index >= getNoteCount()) {
                increaseNoteCount()
            }
        },
        getName: function () {
            let key = noteNameKey + index;
            return document.getElementById("name").value = localStorage.getItem(key);
        }
    };
}

function saveCurrent() {
    let index = getCurrentIndex();
    if (index === -1) {
        index = getNoteCount();
    }
    let note = makeNote(index);
    note.save();
    setItemsInList();
    document.getElementById("form").reset();
    document.getElementById("content").innerText = "";
    setCurrentIndex(-1);
}

function loadNote(index) {
    let note = makeNote(index);
    note.load();
}

function setItemsInList() {
    let list = document.getElementById("list");
    list.innerHTML = "";
    let count = getNoteCount();
    for (let i = 0; i < count; i++) {
        let note = makeNote(i);
        list.innerHTML += `<li><a href=\"javascript:loadNote(${i})\">${note.getName()}</a></li>`
    }
}

window.onload = (event) => {
    setItemsInList()
    document.getElementById("form").reset();
    setCurrentIndex(-1)
}
