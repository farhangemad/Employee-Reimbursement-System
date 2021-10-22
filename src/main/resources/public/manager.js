document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("logoutButton").addEventListener('click', async function (e) {

        e.preventDefault();

        deleteAllCookies();
        window.location.href = "/index.html"

    });
    /////////////////////////This goes in the thins
    //let name = getCookie("firstname");
    //let lastName = getCookie("lastname");
    //let names = name + " " + lastName;
    //document.getElementById("records").innerHTML = names;

    document.getElementById("viewEmployees").addEventListener('click', async function (e) {
        e.preventDefault();
        deleteAllCookies()
        let returned = await fetch("manager", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            //body: JSON.stringify(json)
        });
        let cookies = document.cookie.split(";");
        let htmlStr = "";

        for (let i = 1; i <= cookies.length; i++) {
            let cname = "Emp"+i;
            let val = getCookie(cname);
            htmlStr = htmlStr+val+"<br>";
        }
        document.getElementById("records").innerHTML = htmlStr;

    });

    document.getElementById("pending").addEventListener('click', async function (e) {
        e.preventDefault();
        deleteAllCookies()
        let returned = await fetch("manager", {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            //body: JSON.stringify(json)
        });
        let cookies = document.cookie.split(";");
        let htmlStr = "";

        for (let i = 1; i <= cookies.length; i++) {
            let cname = "Req"+i;
            let val = getCookie(cname);
            if (val.includes("false")) {
                let res = val.replace(/----/, " Amount: $");
                let tim = res.replace(/---/, "   Reason: ");
                let ret = tim.replace(/---/, "   Submitted on: ");
                let lom = ret.replace(/---/, "   Resolved: ");
                let out = lom.replace(/---/, "    Approver ID: ");
                let outst = out.replace(/\*/g, ":");
                let outstring = outst.replace(/_/g, " ");

                htmlStr = htmlStr + outstring + "<br>";
            }
        }
        document.getElementById("records").innerHTML = htmlStr;

    });


    document.getElementById("resolved").addEventListener('click', async function (e) {
        e.preventDefault();
        deleteAllCookies()
        let returned = await fetch("manager", {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            //body: JSON.stringify(json)
        });
        let cookies = document.cookie.split(";");
        let htmlStr = "";

        for (let i = 1; i <= cookies.length; i++) {
            let cname = "Req"+i;
            let val = getCookie(cname);
            if (val.includes("true")) {
                let res = val.replace(/----/, " Amount: $");
                let tim = res.replace(/---/, "   Reason: ");
                let ret = tim.replace(/---/, "   Submitted on: ");
                let lom = ret.replace(/---/, "   Resolved: ");
                let out = lom.replace(/---/, "    Approver ID: ");
                let outst = out.replace(/\*/g, ":");
                let outstring = outst.replace(/_/g, " ");

                htmlStr = htmlStr + outstring + "<br>";
            }
        }
        document.getElementById("records").innerHTML = htmlStr;

    });


    document.getElementById("submitIDButton").addEventListener('click', async function (e) {
        e.preventDefault();
        deleteAllCookies()
        const form = document.getElementById('viewAReq');
        const empId = form.elements['Employee'];
        let empID = empId.value;

        let returned = await fetch("manager", {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            //body: JSON.stringify(json)
        });


        let cookies = document.cookie.split(";");
        let htmlStr = "";

        for (let i = 1; i <= cookies.length; i++) {
            let cname = "Req"+i;
            let val = getCookie(cname);
            if (val.includes(empID+"----")) {
                let res = val.replace(/----/, " Amount: $");
                let tim = res.replace(/---/, "   Reason: ");
                let ret = tim.replace(/---/, "   Submitted on: ");
                let lom = ret.replace(/---/, "   Resolved: ");
                let out = lom.replace(/---/, "    Approver ID: ");
                let outst = out.replace(/\*/g, ":");
                let outstring = outst.replace(/_/g, " ");

                htmlStr = htmlStr + outstring + "<br>";
            }
        }
        document.getElementById("records").innerHTML = htmlStr;

    });

});

function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function deleteAllCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}



