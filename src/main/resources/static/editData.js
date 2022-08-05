$('#editModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var id = button.data('id')
    var name = button.data('name')
    var lastname = button.data('lastname')
    var password = button.data('password')
    var age = button.data('age')
    var email = button.data('email')
    var roles = button.data('roles')

    var modal = $(this)
    modal.find('.modal-id-ed input').val(id)
    modal.find('.modal-name-ed input').val(name)
    modal.find('.modal-lastname-ed input').val(lastname)
    modal.find('.modal-password-ed input').val(password)
    modal.find('.modal-age-ed input').val(age)
    modal.find('.modal-email-ed input').val(email)
    modal.find('.modal-roles-ed input').val(roles)
})