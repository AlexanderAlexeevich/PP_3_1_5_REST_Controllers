document.addEventListener('DOMContentLoaded', async function () {
    await showUserEmailOnNavbar()
    await fillTableOfAllUsers();
    await fillTableAboutCurrentUser();
    await addNewUserForm();
    await DeleteModalHandler();
    await EditModalHandler();
});

const ROLE_USER = {id: 2, roleName: "ROLE_USER"};
const ROLE_ADMIN = {id: 1, roleName: "ROLE_ADMIN"};
//емаил пользователя в навбаре

async function showUserEmailOnNavbar() {
    const currentUserEmailNavbar = document.getElementById("currentUserEmailNavbar")
    const currentUser = await dataAboutCurrentUser();
    currentUserEmailNavbar.innerHTML =
                `<strong>${currentUser.username}</strong>
                 with roles: 
                 ${currentUser.roles.map(role => role.role.replace('ROLE_', '')).join(' ')}`;
}
