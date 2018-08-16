function signInButton() {
    window.open("../html/signIn.html");
}

function signOutButton() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            console.log(xmlHttp.responseText)
        }
    }
    xmlHttp.open("GET", "/login", true);
    xmlHttp.send(null);
}

function singlePlayerButton() {
    var c;
}

function multiplePlayerButton() {
    var d;
}