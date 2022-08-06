const editForm = document.getElementById("editFormId");

editForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData(editForm);
    const editUser = {
        roles: ["USER"]
    }
    for (const pair of formData.entries()) {
        if (pair[0] === "roles") {
            if (pair[1] === "ADMIN") {
                editUser.roles.push(pair[1]);
                editUser.roles.splice(0, 1);
            }
        } else {
            editUser[pair[0]] = pair[1];
        }
        console.log(JSON.stringify(editUser));
    }

    fetch(url, {
        method: 'PUT',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(editUser)
    })
        .then(response => {
            if (response.ok) {
                console.log(JSON.stringify(editUser))
                return response.json()
            } else {
                console.log("Error")
            }
        })
        .then(() => getAllUsers());
    $("#editModal").modal("hide");
    deleteForm.reset();
})
