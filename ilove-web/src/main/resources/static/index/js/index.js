$(function () {
    var app = new Vue({
            el: '#app',
            methods: {
                handleOpen(key, keyPath) {
                    console.log(key, keyPath);
                },
                handleClose(key, keyPath) {
                    console.log(key, keyPath);
                }
            },
            data: {
                isCollapse: false,  // 折叠面板

            },

        }
    );
});

