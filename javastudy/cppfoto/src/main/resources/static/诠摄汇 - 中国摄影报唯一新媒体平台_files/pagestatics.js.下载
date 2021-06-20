(function (a) {
    a.pagect = {

        url: '../handlers/pagecount.aspx',
        inti: function (i) {

            $.ajax({
                url: this.url,
                type: "GET",
                async: false,
                cache: false,
                data: {
                    action: 'select',
                    pageurl: i
                },
                success: function (result) {

                    if (result == 'success') {

                    }
                    else {

                    }
                },
                error: function () { }
            });

        },
        insert: function (url, from) {

            $.ajax({
                url: this.url,
                type: "GET",
                async: false,
                cache: false,
                data: {
                    action: 'insert',
                    pageurl: url,
                    pagefrom: from
                },
                success: function (result) {
                    
                    if (result == 'success') {

                    }
                    else {

                    }
                },
                error: function () { }
            });
        }
    }
})(jQuery);

