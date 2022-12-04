const BASE_URL = 'http://localhost:8080/api/users';
export const addUser = async user => {
    try {
        const response = await axios.post(`${BASE_URL}/signup`, user);
        const newUser = response.data;

        console.log(`Added a new User!`, newUser);

        return newUser;
    } catch (errors) {
        console.error(errors);
    }
};


const form = document.querySelector('#buttonSignUp');

form.onclick = async (event) => {
    event.preventDefault();

    const firstName = document.querySelector('#firstName').value;
    const lastName = document.querySelector('#lastName').value;
    const email = document.querySelector('#email').value;
    const password = document.querySelector('#password').value;


    const user = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        password: password,
    };

    await addUser(user);
};


export const logInUser = async user => {
    try {
        const response = await axios.post(`${BASE_URL}/signin`, user);
        const newUser = response.data;

        console.log(`Logged in a User!`, newUser);

        return newUser;
    } catch (errors) {
        console.error(errors);
    }
};


const form2 = document.querySelector('#buttonSignIn');
form2.onclick = async (event) => {
    event.preventDefault();

    const email = document.querySelector('#email1').value;
    const password = document.querySelector('#password1').value;


    const user = {
        email: email,
        password: password,
    };

    await logInUser(user);
};

