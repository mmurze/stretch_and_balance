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
                token: user.token,
                roles: user.roles,
                lastname: user.lastname,
                firstname: user.firstname,
                username: user.username,
                id: user.id,
            });
        console.log(response.data)
        if (response.data.token) {
            console.log(response.data)
            localStorage.setItem('user', JSON.stringify(response.data));
        }
        return response.data;
    }
    async forgot(user) {
        const response = await axios
            .post(API_URL + 'forgot', {
                lastname: user.lastname,
                firstname: user.firstname,
                username: user.username
            });
        if (response.data.token) {
            localStorage.setItem('user', JSON.stringify(response.data));
        }
        return response.data;
    }

}
export default new AuthService();
