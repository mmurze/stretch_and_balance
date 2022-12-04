<template>
    <nav class="navbar navbar-expand-md fixed-top">
        <div class="container">

            <a class="navbar-brand smoothScroll" href="#home">Stretch and Balance</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
                <i class="fa fa-bars  mr-lg-auto mb-2" aria-hidden="true"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">

                <ul class="navbar-nav ml-lg-auto">
                    <li class="nav-item">
                        <a href="#about" class="nav-link smoothScroll">О нас</a>
                    </li>

                    <li class="nav-item">
                        <a href="#class" class="nav-link smoothScroll">Занятия</a>
                    </li>

                    <li class="nav-item">
                        <a href="#schedule" class="nav-link smoothScroll">Расписание</a>
                    </li>

                    <li class="nav-item">
                        <a href="#contact" class="nav-link smoothScroll">Контакты</a>
                    </li>

                    <li v-if="!currentUser" class="nav-item">
                        <router-link class="nav-link " to="/register" href="#">
                            <i class="fa fa-user-circle mr-lg-auto mb-2 "></i>
                        </router-link>
                    </li>

                    <li v-if="currentUser" class="nav-item">
                        <router-link class="nav-link " to="/profile" href="#">
                            <i class="fa fa-user-circle mr-lg-auto mb-2 "></i>
                        </router-link>
                    </li>
                    <li v-if="currentUser" class="nav-item" @click.prevent="logout">
                        <router-link class="nav-link" to="/" href="#"> Выйти </router-link>
                    </li>
<!-- 
                    <li v-if="showAdminBoard" class="nav-item">
                        <router-link class="nav-link " to="/register" href="#">
                            <i class="fa fa-user-circle mr-lg-auto mb-2 "></i>
                        </router-link>
                    </li> -->
                </ul>
            </div>
        </div>
    </nav>

    <section class="hero d-flex flex-column justify-content-center align-items-center section" id="home">

        <div class="bg-overlay1"></div>

        <div class="container">
            <div class="row">

                <div class="col-lg-8 col-md-10 mx-auto col-12">
                    <div class="hero-text mt-5 text-center">
                        <h1 class="text-white">Начни путь к себе в Stretch and Balance</h1>
                        <a href="#feature" class="btn custom-btn bg-color mt-3">начать</a>
                    </div>
                </div>

            </div>
        </div>
    </section>


    <section class="feature" id="feature">
        <div class="container">
            <div class="row">

                <div class="d-flex flex-column justify-content-center ml-lg-auto mr-lg-5 col-lg-5 col-md-6 col-12">
                    <h2 class="mb-3 text-white">Ты еще не с нами?</h2>
                    <h6 class="mb-4 text-white">Зарегистрируйся и запишись на первую тренировку</h6>
                    <!-- <a href="#" class="btn custom-btn bg-color mt-3" data-toggle="modal" data-target="#userFormSignUp">
                        Зарегестрироваться</a> -->

                    <router-link class="btn custom-btn bg-color mt-3" to="/register" href="#">
                        <a class="nav-link">Зарегестрироваться</a>
                    </router-link>
                </div>

                <div class="mr-lg-auto mt-3 col-lg-4 col-md-6 col-12">
                    <div class="about-working-hours">
                        <div>
                            <h2 class="mb-4 text-white"> у нас тренирвоки каждый день</h2>
                            <strong class="mt-3 d-block">Пн - Вс</strong>
                            <p>10:00 - 22:00</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>


    <!-- ABOUT -->
    <section class="about d-flex flex-column justify-content-center align-items-center section" id="about">
        <div class="bg-overlay2"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto col-12">

                    <div class="hero-text mt-5 text-center">
                        <h2 class="mb-4">Мы крутая студия</h2>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <h2 class="mb-4">Мы крутая студия</h2>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <h2 class="mb-4">Мы крутая студия</h2>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <h2 class="mb-4">Мы крутая студия</h2>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                        <a>У нас супер круто. Приходите к нам)</a>
                        <a>спасибо за внимание</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- CLASS -->
    <section class="class section" id="class">
        <div class="container">
            <div class="row">

                <div class="col-lg-12 col-12 text-center mb-5">
                    <h6>Осознанный путь к своему телу</h6>
                    <h2>Наши занятия</h2>
                </div>

                <div class="col-lg-4 col-md-6 col-12">
                    <div class="class-thumb">
                        <img src="../../public/front/images/class/yoga.jpg" class="img-fluid" alt="Class">
                        <div class="class-info">
                            <h3 class="mb-1">Йога</h3>
                            <p class="mt-3">Тут описание йога(скорее всего модальное окно)</p>
                        </div>
                    </div>
                </div>

                <div class="mt-5 mt-lg-0 mt-md-0 col-lg-4 col-md-6 col-12">
                    <div class="class-thumb">
                        <img src="../../public/front/images/class/pilates.jpg" class="img-fluid" alt="Class">

                        <div class="class-info">
                            <h3 class="mb-1">Пилатес</h3>
                            <p class="mt-3">Краткое описание</p>
                        </div>
                    </div>
                </div>

                <div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12">
                    <div class="class-thumb">
                        <img src="../../public/front/images/class/stretching.jpg" class="img-fluid" alt="Class">

                        <div class="class-info">
                            <h3 class="mb-1">Растяжка</h3>
                            <p class="mt-3">Краткое описание</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>


    <!-- SCHEDULE -->
    <section class="schedule section" id="schedule">
        <div class="container">
            <div class="row">

                <div class="col-lg-12 col-12 text-center">
                    <h2 class="text-white">Расписание занятий</h2>
                </div>

                <div class="col-lg-12 py-5 col-md-12 col-12">
                    <table class="table table-bordered table-responsive schedule-table">

                        <thead class="thead-light">
                            <th><i class="fa fa-calendar"></i></th>
                            <th>ПН</th>
                            <th>ВТ</th>
                            <th>СР</th>
                            <th>ЧТ</th>
                            <th>ПТ</th>
                            <th>СБ</th>
                            <th>ВС</th>
                        </thead>

                        <tbody>
                            <tr>
                                <td><small>7:00</small></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>

                            <tr>
                                <td><small>9:00</small></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>

                            <tr>
                                <td><small>11:00</small></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>

                            <tr>
                                <td><small>14:00</small></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </section>


    <!-- CONTACT -->
    <section class="contact section" id="contact">
        <div class="container">
            <div class="row">

                <div class="ml-auto col-lg-5 col-md-6 col-12">
                    <h2 class="mb-4 pb-2">Если у вас остались вопросы - свяжитесь с нами </h2>
                    <p class="mr-4">
                        <i class="fa fa-envelope-o mr-1"></i>
                        <a href="#">OUR@email.ru</a>
                    </p>
                    <p class="mr-4">
                        <i class="fa fa-phone mr-1"></i> +7-912-314-12-12
                    </p>
                </div>

                <div class="mx-auto mt-4 mt-lg-0 mt-md-0 col-lg-5 col-md-6 col-12">
                    <h2 class="mb-4">Вы можете найи нас здесь</h2>
                    <p><i class="fa fa-map-marker mr-1"></i> Санкт-Петербург, ул.Смолячкова 13</p>
                    <div class="google-map">
                        <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d998.3726806794687!2d30.34192085077869!3d59.96954729999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x469633df8227a7b7%3A0xac5614d0b282f72d!2z0JHQvtC70YzRiNC-0Lkg0KHQsNC80L_RgdC-0L3QuNC10LLRgdC60LjQuSDQv9GALiwgNDUsINCh0LDQvdC60YIt0J_QtdGC0LXRgNCx0YPRgNCzLCAxOTQwNDQ!5e0!3m2!1sru!2sru!4v1666968502194!5m2!1sru!2sru"
                            width="200" height="200" style="border:0;" allowfullscreen="" loading="lazy"
                            referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </div>

            </div>
        </div>
    </section>


</template>

<script>
export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: "AllPagesGuests",
    computed: {
        currentUser() {
      return this.$store.state.auth.user;
    }
    },
    methods: {
        async logout() {
            await this.$store.dispatch("auth/logout");
            this.$router.push("/login");
        },
    },
}
</script>