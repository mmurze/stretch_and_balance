import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth/';

class AuthService {
    async login(user) {
        const response = await axios
            .post(API_URL + 'signin', {
                username: user.username,
                password: user.password
            });
        if (response.data.token) {
            localStorage.setItem('user', JSON.stringify(response.data));
        }
        return response.data;
    }
    async logout() {
        localStorage.removeItem('user');
    }

    async register(user) {
        return axios.post(API_URL + 'signup', {
            lastname: user.lastname,
            firstname: user.firstname,
            username: user.username,
            password: user.password
        });
    }
    async update(user) {
        const response = await axios
            .post(API_URL + 'update', {
                username: user.username,
                lastname: user.lastname,
                firstname: user.firstname,
            });
        if (response.data) {
            const userstr = localStorage.getItem('user');
            const parsedObject = JSON.parse(userstr);
            parsedObject.lastName = response.data.lastName;
            parsedObject.firstName = response.data.firstName;
            localStorage.setItem("user", JSON.stringify(parsedObject));
            location.reload();
        }
        return response.data;
    }
}
export default new AuthService();
