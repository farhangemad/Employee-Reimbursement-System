document.addEventListener('DOMContentLoaded', function () {
    let login = document.querySelector("#loginForm");

    document.getElementById("submitLoginButton").addEventListener('click', async function (e) {
        e.preventDefault();
        // login = document.querySelector("#login");
        let json = {
            username: login.querySelector('input[name="username"]').value,
            password: login.querySelector('input[name="password"]').value
        }

        let returned = await fetch("index", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(json)
        });

        //let data = await returned.json();
        let superstatus = getCookie("superstatus");


        if (returned.status === 200) {
            //window.location.href = "/manager.html"
            if (superstatus === "true") {
                window.location.href = "/manager.html"
            } else {
                window.location.href = "/employee.html"
            }
        } else {
            if (returned.status === 401) {
                let p = document.createElement("p");
                p.innerHTML = "invalid username/password";
            } else {
                let p = document.createElement("p");
                p.innerHTML = "unknown failure sorry";
            }
        }
    });

});

function getCookie(cName) {
    const name = cName + "=";
    const cDecoded = decodeURIComponent(document.cookie); //to be careful
    const cArr = cDecoded.split('; ');
    let res;
    cArr.forEach(val => {
        if (val.indexOf(name) === 0) res = val.substring(name.length);
    })
    return res
}