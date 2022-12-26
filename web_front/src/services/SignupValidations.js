import Validations from './validations';

export default class SignupValidations {
    constructor(username, password, password_repeat, length) {
        this.username = username;
        this.password = password;
        this.password_repeat = password_repeat;
        this.length = length
    }

    checkValidations() {
        let errors = [];

        if (!Validations.checkEmail(this.username)) {
            errors['username'] = 'Неверно введена почта';
        }
        if (!Validations.minLength(this.password)) {
            errors['password'] = 'Неверно введен пароль';
        }
        if (!Validations.cheackPasswords(this.password, this.password_repeat)) {
            errors['password_repeat'] = 'Пароли не совпадают';
        }

        return errors;
    }

    getErrorMessageFromCode(errorCode) {
        switch (errorCode) {
            case 'EMAIL_EXISTS':
                return 'Почта уже зарегестрирвоана';
            case 'EMAIL_NOT_FOUND':
                return 'Почта не зарегестрирвоана';
            case 'Bad credentials':
                return 'Неправильные почта или пароль';
            default:
                return 'Неизвестная ошибкаю Попробуйте еще раз';
        }
    }
}
