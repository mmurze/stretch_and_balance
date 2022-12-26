export default class Validations {
    static checkEmail(email) {
        if ( /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email,)) {
            return true;
        }
        return false;
    }

    static minLength(password) {
        if(!(/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,30}$/.test(password,))) {
            return false;
        }
        return true;
    }

    static cheackPasswords(password1, password2) {
        if (password1 !== password2) {
            return false;
        }
        return true;
    }
}
