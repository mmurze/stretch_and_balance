<template>
  <nav class="navbar navbar-expand-md fixed-top">
    <div class="container">
      <router-link class="navbar-brand" to="/" href="#">
        <a>Stretch and Balance</a>
      </router-link>

      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
        <i class="fa fa-bars  mr-lg-auto mb-2" aria-hidden="true"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">

        <ul class="navbar-nav ml-lg-auto">

          <li v-if="!currentUser" class="nav-item">
            <router-link class="nav-link " to="/register" href="#">
              <i class="fa fa-user-circle mr-lg-auto mb-2 "></i>
            </router-link>
          </li>
          <li v-if="currentUser" class="nav-item" @click="logout">
            <router-link class="nav-link" to="" href=""> Выйти </router-link>
          </li>
          <li v-if="showAdminBoard" class="nav-item" @click="schedule">
            <router-link class="nav-link" to="" href=""> Изменить расписание </router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="col-12">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h2 class="modal-title" id="userFormLabelSignUp">Пользователь </h2>
        </div>

        <div class="modal-body">
          <table class="table">
            <thead>
              <tr v-if="edit">
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Почта</th>
              </tr>
            </thead>
            <tbody>
              <tr v-if="edit">
                <td>{{ currentUser.firstName }}</td>
                <td>{{ currentUser.lastName }}</td>
                <td>{{ currentUser.username }}</td>
              </tr>
              <tr v-else>
                <input type="text" class="form-control" v-model.trim="firstname" required placeholder="Имя" />
                <input type="text" class="form-control" v-model.trim="lastname" required placeholder="Фамилия">
              </tr>
            </tbody>
          </table>
          <button class="form-controll" id="buttonSignIn" @click="editUesr">Изменить</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Profile',
  data() {
    return {
      firstname: '',
      lastname: '',
      username: '',
      edit: true,
    }
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      console.log(this.currentUser);
      if (this.currentUser && this.currentUser['roles']) {
        return this.currentUser['roles'].includes('ROLE_ADMIN');
      }
      return false;
    },
  },
  mounted() {
    
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  },
  methods: {
    logout() {
      this.$store.dispatch("auth/logout")
      this.$router.push("/");
    },
    schedule(){
      this.$router.push("/schedule");
    },
    editUesr() {
      if (this.edit === false) {
        if(this.firstname === ''){
          this.firstname = this.$store.state.auth.user.firstName
        }
        if(this.lastname === ''){
          this.lastname = this.$store.state.auth.user.lastname
        }
        if(this.username === ''){
          this.username = this.$store.state.auth.user.username
        }
        this.$store.dispatch("auth/update", {
          // token: this.$store.state.auth.user.token,
          // id: this.$store.state.auth.user.id,
          // roles: this.$store.state.auth.user.roles,
          firstname: this.firstname,
          lastname: this.lastname,
          username: this.username,
        }).then(
          () => {
            // this.token = response.token;
            this.firstname = '';
            this.lastname = '';
          },
          (error) => {
            console.log(error)
            this.error =
              (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();

          }
        );
        this.edit = true
      } else {
        this.edit = false
      }
    }
  },
};
</script>

<style scoped>
.form-controll {
  display: flex;
  border-radius: var(--border-radius-small);
  margin: 0.5rem 25%;
  opacity: 0.85;
}

.form-controll {
  display: block;
  width: 50%;
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
</style>