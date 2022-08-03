const info = document.querySelector('.allUsers');
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
    let output = ''
    users.forEach(user => {
        output += ` 
                <tr> 
                    <td>${user.id}</td> 
                    <td>${user.username}</td> 
                    <td>${user.lastname}</td> 
                    <td>${user.email}</td> 
                    <td>${user.password}</td> 
                    <td>${user.roles}</td> 
                    <td>
                        <button type="button" class="btn btn-info btn-sm"
                            data-toggle="modal"
                            data-target="#editModal"
                            th:data-id="${user.id}"
                            th:data-name="${user.username}"
                            th:data-lastname="${user.lastname}"
                            th:data-password="${user.password}"
                            th:data-age="${user.age}"
                            th:data-email="${user.email}"
                            th:data-roles="${user.roles}">Edit
                        </button>
                    <td>
                        <button type="button" class="btn btn-danger btn-sm"
                            data-toggle="modal"
                            data-target="#deleteModal"
                            th:data-id="${user.id}"
                            th:data-name="${user.username}"
                            th:data-lastname="${user.lastname}"
                            th:data-age="${user.age}"
                            th:data-email="${user.email}"
                            th:data-roles="${user.roles}">Delete
                        </button>
                    </td>
                </tr>`
    })
    info.innerHTML = output;
}