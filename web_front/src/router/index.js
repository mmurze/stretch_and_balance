import { createWebHistory, createRouter } from "vue-router";
import AllPagesGuests from "@/components/AllPagesGuests.vue";
import AllPagesUsers from "@/components/AllPagesUsers.vue";
import Login from "@/components/LoginPage.vue";
import Forgot from "@/components/Forgot.vue";
import Register from "@/components/SignUpPage.vue";
import store from '@/store';
const Profile = () => import("@/components/Profile.vue")

const routes = [
    {
        path: "/",
        component: AllPagesGuests,
        name: "AllPagesGuests"
    },
    {
        path: "/login",
        name: "Login",
        component: Login,
        meta: { auth: false }
    },
    {
        path: "/register",
        name: "Register",
        component: Register,
        meta: { auth: false }
    },
    {
        path: "/forgot",
        name: "Forgot",
        component: Forgot,
        meta: { auth: false }
    },
    {
        path: "/auth",
        name: "AllPagesUsers",
        component: AllPagesUsers,
        meta: { auth: true }
    },
    {
        path: "/profile",
        name: "profile",
        component: Profile,
        meta: { auth: true }
    }
];

const router = createRouter({
    //     mode: 'history',
    //     base: process.env.BASE_URL,
    history: createWebHistory(),
    routes,
});
router.beforeEach((to, from, next) => {
    if (
        'auth' in to.meta &&
        to.meta.auth &&
        !store.state.auth.status.loggedIn
    ) {
        next('/login');
    } else if (
        'auth' in to.meta &&
        !to.meta.auth &&
        store.state.auth.status.loggedIn
    ) {
        next('/');
    } else {
        next();
    }
});
/* eslint-disable */
// router.beforeEach((to, from, next) => {
//     if (to.matched.some((record) => record.meta.requiresAuth)) {
//         if (store.getters.isAuthenticated) {
//             next();
//             return;
//         }
//         next("/login");
//     } else {
//         next();
//     }
// });

// router.beforeEach((to, from, next) => {
//     if (to.matched.some((record) => record.meta.guest)) {
//         if (store.getters.isAuthenticated) {
//             next("/profile");
//             return;
//         }
//         next();
//     } else {
//         next();
//     }
// });

export default router;