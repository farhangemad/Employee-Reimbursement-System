document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("logoutButton").addEventListener('click', async function (e) {

        e.preventDefault();

        deleteAllCookies();
        window.location.href = "/index.html"
    });

    document.getElementById("viewInfo").addEventListener('click', async function (e) {
        e.preventDefault();
        let name = getCookie("fname");
        let lastName = getCookie("lname");

        //deleteAllCookies();
        let returned = await fetch("employee", {
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
            console.log(name);
            console.log(lastName);

            if (val.includes(name) && val.includes(lastName)) {
                htmlStr = htmlStr + val + "<br>";
            }
        }
        document.getElementById("records").innerHTML = htmlStr;

    });

    document.getElementById("pendingReq").addEventListener('click', async function (e) {
        e.preventDefault();
        let name = getCookie("fname");
        let lastName = getCookie("lname");
        //deleteAllCookies();

        let check1 = 0;
        if (lastName == "Duet"){
            check1 = 1;
        } else if (lastName == "Doe"){
            check1 = 2;
        } else if (lastName == "Offit"){
            check1 = 3;
        } else if (lastName == "Johnson"){
            check1 = 4;
        } else if (lastName == "Davis"){
            check1 = 5;
        }

        check1 = check1+"----";

        let returned = await fetch("employee", {
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
            if (val.includes("false") && val.includes(check1)) {
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

    document.getElementById("resolvedReq").addEventListener('click', async function (e) {
        e.preventDefault();

        let lastName = getCookie("lname");
        //deleteAllCookies();
        let check = 0;
        if (lastName == "Duet"){
            check = 1;
        } else if (lastName == "Doe"){
            check = 2;
        } else if (lastName == "Offit"){
            check = 3;
        } else if (lastName == "Johnson"){
            check = 4;
        } else if (lastName == "Davis"){
            check = 5;
        }

        check = check+"----";

        let returned = await fetch("employee", {
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
            if (val.includes("true") && val.includes(check)) {
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

    let form = document.querySelector("#requestForm");

    document.getElementById("submitRequestButton").addEventListener('click', async function (e) {
        e.preventDefault();
        //const form = document.getElementById('requestForm');
        let employee_id = form.querySelector('input[name="id"]').value;
        let amount = form.querySelector('input[name="amount"]').value;
        let reas = form.querySelector('input[name="reason"]').value;
        //login.querySelector('input[name="password"]').value
        console.log(employee_id);
        console.log(amount);
        console.log(reas);
        console.log(typeof reas);

        //const employee_id = emp.value;
        //const amount = am.value;
        //let reas1 = reas.value;
        let reason = "REASONCODE:"+reas;


        const data = {
            employee_id: employee_id,
            amount: amount,
            reason: reason,
        };
        console.log(data);
        const res = await fetch(`employee/req`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        }).catch((err) => {
            console.log(err);
        });
        console.log(res);

    });


})

//Functions
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