<template>
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container">
            <router-link class="navbar-brand" to="/" href="#">
                <a>Stretch and Balance</a>
            </router-link>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
                <i class="fa fa-bars  mr-lg-auto mb-2" aria-hidden="true"></i>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-lg-auto">

                    <li class="nav-item">
                        <router-link class="btn custom-btn bg-color" to="/login" href="#">
                            <a class="nav-link">Уже зарегестрированы?</a>
                        </router-link>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <div class="col-md-12">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title" id="userFormLabelSignUp">Регистарция </h2>
                </div>

                <div class="modal-body">
                    <form class="user-form" role="form" @submit.prevent="handleRegister()">
                        <input type="text" class="form-control" v-model.trim="firstname" required placeholder="Имя" />
                        <input type="text" class="form-control" v-model.trim="lastname" required placeholder="Фамилия">

                        <input type="email" class="form-control" v-model.trim="username" placeholder="Почта">
                        <div class="error" v-if="errors.username"> {{ errors.username }} </div>

                        <input type="password" class="form-control" v-model.trim="password" placeholder="Пароль">
                        <div class="error" v-if="errors.password"> {{ errors.password }} </div>
                        <p>Вы должны ввести один символ, одну строчную и заглавную букву, как минимум. Длина не
                            менее 8 символов</p>

                        <input type="password" class="form-control" v-model.trim="password_repeat"
                            placeholder="Повторите пароль">
                        <div class="error" v-if="errors.password_repeat"> {{ errors.password_repeat }} </div>

                        <div v-if="error" class="error"> {{ error }} </div>

                        <button type="submit" class="form-controll" :disabled="successful" id="buttonSignIn">
                            reg
                        </button>

                        <div v-if="success" class="success"> {{ success }} </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import SignupValidations from '../services/SignupValidations';

export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: "Register",
    data() {
        return {
            success: '',
            firstname: '',
            lastname: '',
            username: '',
            password: '',
            password_repeat: '',
            errors: [],
            error: ' ',
        };
    },
    computed: {
        loggedIn() {
            return this.$store.state.auth.status.loggedIn;
        },
    },
    methods: {
        handleRegister() {
            let validations = new SignupValidations(
                this.username,
                this.password,
                this.password_repeat,
                this.password.length,
            );
            this.errors = validations.checkValidations();
            if ('username' in this.errors || 'password' in this.errors || 'password_repeat' in this.errors) {
                return false;
            }
            this.error = '';
            this.$store.dispatch("auth/register", {
                firstname: this.firstname,
                lastname: this.lastname,
                password: this.password,
                username: this.username,
            }).then(
                (data) => {
                    console.log(data);
                    this.error = validations.getErrorMessageFromCode(data || data.data || data.message);
                    if(data === 'GREAT_USER'){
                        this.error = ''
                        this.success = 'Вы зарегестрирвоаны. Теперь можете войти!'
                    }
                },
                (error) => {
                    this.error = validations.getErrorMessageFromCode(error.response.data.message);
                }
            );
        },
    }
}


</script>

<style scoped>
.error {
    display: flex;
    color: red;
}
.success {
    display: flex;
    color: green;
}

.form-controll {
    display: flex;
    border-radius: var(--border-radius-small);
    margin: 1.3rem 0;
    opacity: 0.85;
}

.form-controll {
    display: block;
    width: 100%;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    line-height: 1.5;
    color: #495057;
    border-radius: 0.25rem;
    transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

.navbar {
    background: var(--dark-color);
    padding: 1.2rem;
}

.btn:not(:disabled):not(.disabled) {
    cursor: pointer;
}

.bg-color {
    background: var(--primary-color);
    color: var(--white-color);
}

.custom-btn {
    /* border-radius: var(--border-radius-small); */
    padding: 2px;
    font-size: 20px;
    text-transform: uppercase;
    white-space: nowrap;
    transition: all 0.3s ease;
}

.btn {
    display: inline-block;
    font-weight: 400;
    text-align: center;
    vertical-align: middle;
    user-select: none;
    border: 1px solid transparent;
    line-height: 0;
}

/* a {
    text-decoration: none;
} */
</style>
 