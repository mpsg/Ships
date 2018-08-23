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
    var message = "/test?&param1=5&param2=2";
    xmlHttp.open("GET", message, true);
    xmlHttp.send(null);
}

function singlePlayerButton() {
    var c;
}

function multiplePlayerButton() {
    var d;
}