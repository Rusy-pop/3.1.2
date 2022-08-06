const deleteForm = document.getElementById("deleteFormId");

deleteForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData(deleteForm);
    const deleteUser = {
        roles: ["USER"]
    }
    for (const pair of formData.entries()) {
        if (pair[0] === "roles") {
            if (pair[1] === "ADMIN") {
                deleteUser.roles.push(pair[1]);
                deleteUser.roles.splice(0, 1);
            }
        } else {
            deleteUser[pair[0]] = pair[1];
        }
        console.log(JSON.stringify(deleteUser));
    }

    fetch(url, {
        method: 'DELETE',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(deleteUser)
    })
        .then(response => {
            if (response.ok) {
                console.log(JSON.stringify(deleteUser))
            } else {
                console.log("Error")
            }
        })
        .then(() => getAllUsers());
    $("#deleteModal").modal("hide");
    deleteForm.reset();
})