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

function makeNote(index) {
    return {
        index: index,
        load: function () {
            let key = "note-name-" + index;
            document.getElementById("name").value = localStorage.getItem(key);
            key = "note-content-" + index;
            document.getElementById("content").innerText = localStorage.getItem(key);
            setCurrentIndex(index)
        },
        save: function () {
            let key = "note-name-" + index;
            localStorage.setItem(key, document.getElementById("name").value);
            key = "note-content-" + index;
            localStorage.setItem(key, document.getElementById("content").value);
            if (index >= getNoteCount()) {
                increaseNoteCount()
            }
        },
        getName: function () {
            let key = "note-name-" + index;
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
