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
    modal.find('.modal-id-ed input').val(id)
    modal.find('.modal-name-ed input').val(name)
    modal.find('.modal-lastname-ed input').val(lastname)
    modal.find('.modal-password-ed input').val(password)
    modal.find('.modal-age-ed input').val(age)
    modal.find('.modal-email-ed input').val(email)
    modal.find('.modal-roles-ed input').val(roles)
})