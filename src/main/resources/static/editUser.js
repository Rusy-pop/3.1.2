const editForm = document.getElementById("editFormId");

editForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData(editForm);
    const object = {
        roles: ["USER"]
    }

    for (var pair of formData.entries()) {
        if (pair[0] === "roles") {
            if (pair[1] === "ADMIN") {
                object.roles.push(pair[1]);
                object.roles.splice(0, 1);
            }
        } else {
            object[pair[0]] = pair[1];
        }
        console.log(JSON.stringify(object));
    }

    fetch(url+"/"+object.id, {
        method: 'PUT',
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
