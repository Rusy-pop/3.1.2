const allUsers = document.getElementById("allUsers");
const url = "http://localhost:8080/rest"

fetch(url)
    .then(response => {
        if (response.ok) {
            // console.log(response)
            return response.json()
        } else {
            console.log("Error")
        }
    })
    .then(data =>
        userTable(data)
    )

function userTable(users) {
    let table = ''
    users.forEach(user => {
        table += `
                <tr> 
                    <td>${user.id}</td> 
                    <td>${user.username}</td> 
                    <td>${user.lastname}</td> 
                    <td>${user.email}</td> 
                    <td>${user.password}</td> 
                    <td>${user.roles}</td> 
                    <td>
                        <button type="button" class="btn btn-info btn-sm" data-toggle="modal" id="editButton" data-target="#editModal"
                            data-id="${user.id}" data-name="${user.username}" data-lastname="${user.lastname}"
                            data-password="${user.password}" data-age="${user.age}" data-email="${user.email}"
                            data-roles="${user.roles}">Edit
                        </button>
                    <td>
                        <button type="button" class="btn btn-danger btn-sm"
                            data-toggle="modal"
                            data-target="#deleteModal"
                            data-id="${user.id}"
                            data-name="${user.username}"
                            data-lastname="${user.lastname}"
                            data-age="${user.age}"
                            data-email="${user.email}"
                            data-roles="${user.roles}">Delete
                        </button>
                    </td>
                </tr>`
    })
    allUsers.innerHTML = table;
}