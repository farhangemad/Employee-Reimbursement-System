document.addEventListener('DOMContentLoaded', function () {
    let login = document.querySelector("#login");
    const toast = document.querySelector(".toast");


    login.querySelector('.btn-submit').addEventListener('click', async function (e) {
        e.preventDefault();
        // login = document.querySelector("#login");
        let json = {
            username: login.querySelector('input[name="user"]').value,
            password: login.querySelector('input[name="pass"]').value
        }

        let returned = await fetch("login", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(json)
        });

        let data = await returned.json();


        if (returned.status === 200 && true) {
            window.location.replace("http://localhost:63342/PROJECT1/src/main/webapp/WEB-INF/employee.html");
        } else {
            toast.querySelector(".toast-content p").textContent =
                "Login failed";
            toast.classList.toggle("activate");
            setTimeout(() => toast.classList.toggle("activate"), 5000);
        }
    });

});