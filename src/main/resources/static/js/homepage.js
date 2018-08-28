function signInButton() {
    window.open("../html/signIn.html");
}

function signOutButton() {
    //var xmlHttp = new XMLHttpRequest();
    //xmlHttp.onreadystatechange = function () {
    //    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
    //        console.log(xmlHttp.responseText)
    //    }
    //}
    //var message = "/test?&param1=5&param2=2";
    //xmlHttp.open("GET", message, true);
    //xmlHttp.send(null);

    var xmlHttp = new XMLHttpRequest();
    var message = "/login?data=" + encodeURIComponent(JSON.stringify({"param1": "2", "param2": "B6"}));
    xmlHttp.open("GET", message, true);
    xmlHttp.setRequestHeader("Content-Type", "application/json");
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var json = JSON.parse(message.responseText);
            console.log(json.param1 + ", " + json.param2);
        }
    }

    xmlHttp.send();
}

function singlePlayerButton() {
    var c;
}

function multiplePlayerButton() {
    var d;
}