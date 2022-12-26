<template>
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container">
            <router-link class="navbar-brand" to="/" href="#">
                <a>Stretch and Balance</a>
            </router-link>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
                <i class="fa fa-bars  mr-lg-auto mb-2" aria-hidden="true"></i>
            </button>
        </div>
    </nav>

    <section class="schedule">
        <FullCalendar :options='calendarOptions'>
        </FullCalendar>
    </section>
</template>

<script>
import FullCalendar from '@fullcalendar/vue3'
import timeGridPlugin from '@fullcalendar/timegrid'
import interactionPlugin from '@fullcalendar/interaction'


export default {
    // eslint-disable-next-line vue/multi-word-component-names
    name: "Schedule",
    components: {
        FullCalendar // make the <FullCalendar> tag available
    },
    data: function () {
        return {
            calendarOptions: {
                plugins: [
                    timeGridPlugin,
                    interactionPlugin
                ],
                initialView: 'timeGridWeek',
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'timeGridWeek'
                },
                slotMinTime:'08:00:00',
                slotMaxTime:'22:00:00',
                height: 800,
                locale: 'ru',
                editable: true,
                selectable: true,
                weekday: 'long',
                firstDay: 1,
                buttonText: {
                    today: 'сегодня',
                    week: 'неделя'
                },
                allDaySlot: false,
                select: function (info) {
                    alert('selected ' + info.startStr + ' to ' + info.endStr);
                },
                eventClick: function (info) {
                    alert('Clicked on: ' + info.event.start);
                },
                events: [
                    { title: 'Meeting', start: new Date() }
                ]
            }
        }
    }
}
</script>

<style>
.schedule {
    margin-top: 4rem;
}
</style>