$('#editModal').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget);
    const id = button.data('id');
    const name = button.data('name');
    const lastname = button.data('lastname');
    const password = button.data('password');
    const age = button.data('age');
    const email = button.data('email')
    const roles = button.data('roles')

    console.log(id)

    const modal = $(this)
    modal.find('.id input').val(id)
    modal.find('.modal-name-ed input').val(name)
    modal.find('.modal-lastname-ed input').val(lastname)
    modal.find('.modal-password-ed input').val(password)
    modal.find('.modal-age-ed input').val(age)
    modal.find('.modal-email-ed input').val(email)
    modal.find('.modal-roles-ed input').val(roles)
})

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
