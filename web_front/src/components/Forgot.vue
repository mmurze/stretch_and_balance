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
                            <a class="nav-link">Войти</a>
                        </router-link>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" id="userFormLabelSignIn">Забыли пароль </h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form class="user-form" role="form" @submit.prevent="handleForgot()">
                    <input type="email" class="form-control" v-model.trim="username" placeholder="Почта">
                    <div class="error" v-if="errors.username"> {{ errors.username }} </div>

                    <button class="form-controll" id="buttonSignIn"> Отпарвить </button>

                    <div v-if="error" class="error"> {{ error }} </div>

                </form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: "Forgot",
    data() {
        return {
            username: '',
            errors: [],
            error: '',
        };
    },
    methods: {
        handleForgot() {
            this.error = '';

            // this.$store.dispatch("auth/forgot", {
            //     username: this.username,
            // }).then(
            //     () => {
            //         // this.token = response.token;
            //         // console.log(response)
            //         this.$router.push("/profile");
            //     },
            //     (error) => {
            //         console.log(error)
            //         this.error = validations.getErrorMessageFromCode(error.response.data.message);
            //     }
            // );
        },
    },
}

</script>


<style scoped>
.error {
    display: flex;
    color: red;
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

.error {
    display: flex;
    color: red;
}

.p {
    line-height: 1em;
    margin-top: 1rem;
}

.btn:not(:disabled):not(.disabled) {
    cursor: pointer;
}

.bg-color {
    background: var(--primary-color);
    color: var(--white-color);
}

.custom-btn {
    border-radius: var(--border-radius-small);
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

a {
    text-decoration: none;
}
</style>