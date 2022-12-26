import { createWebHistory, createRouter } from "vue-router";
import AllPages from "@/components/AllPages.vue";
import Login from "@/components/LoginPage.vue";
import Register from "@/components/SignUpPage.vue";
import Schedule from "@/components/Schedule.vue";
import Profile from "@/components/Profile.vue";
// const Profile = () => import("@/components/Profile.vue")

const routes = [
    {
        path: "/",
        component: AllPages,
        name: "AllPages"
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
        path: "/profile",
        name: "profile",
        component: Profile,
        meta: { auth: true }
    },
    {
        path: "/schedule",
        name: "schedule",
        component: Schedule,
        meta: { auth: true }
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;