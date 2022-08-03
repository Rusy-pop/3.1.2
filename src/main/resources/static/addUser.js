// const url = "http://localhost:8080/rest"
const addForm = document.getElementById("addUser");

addForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData(addForm);
    const object = {
        roles:["USER"]
    }

    for (var pair of formData.entries()) {
        if (pair[0] === "roles") {
            if (pair[1] === "ADMIN") {
                object.roles.push(pair[1]);
                object.roles.splice(0,1);
            }
        } else {
            object[pair[0]] = pair[1];
        }
        console.log(JSON.stringify(object));
    }

    fetch(url, {
        method: 'POST',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(response => {
            if (response.ok) {
                console.log(JSON.stringify(object))
                return response.json()
            } else {
                console.log("Error")
            }
        })
})
