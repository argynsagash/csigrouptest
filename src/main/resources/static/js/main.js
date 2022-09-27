Vue.component('todo-item', {
    template: '<li>Это одна задача в списке</li>'
});


var app = new Vue({
    el: '#app',
    template: '<todo-item/>',
    data: {
        message: 'Привет, Vue!'
    }
})