var h3Text = function () {
    $('h3').click(function () {
        var h3Text = $('h3').text();
        alert(h3Text);
    });
};

var callHelloOsgiServlet = function () {
    $('#callHelloOsgiServlet').click(function () {
        $.ajax({
            type: "GET",
            url: "/bin/helloosgiservlet",
            success: function (data, textStatus, jqXHR) {
                console.log("success: " + textStatus);
                console.log("data: " + data);
                $('#callHelloOsgiServletOutput').text(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('Json error!');
                console.log("jqXHR.status: " + jqXHR.status);
                console.log("jqXHR.statusText: " + jqXHR.statusText);
                console.log("jqXHR.readyState: " + jqXHR.readyState);
                console.log("textStatus: " + textStatus);
                console.log("errorThrown: " + errorThrown);
                console.log("jqXHR.redirect: " + jqXHR.redirect);
            },
            complete: function (jqXHR, textStatus) {
                console.log("complete: " + textStatus);
            }
        })
    });
};

var callHelloOsgiServletProp = function () {
    $('.callHelloOsgiServletProp').click(function () {
        $.ajax({
            type: "GET",
            url: "/bin/helloosgiservletprop",
            data: {
                name: "Ajax ",
                surname: "Call"
            },
            success: function (data, textStatus, jqXHR) {
                $('.callHelloOsgiServletPropOutput').text(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("errorThrown: " + errorThrown);
            }
        })
    });
};

var callHelloOsgiServletPropReset = function () {
    $('.callHelloOsgiServletPropReset').click(function () {
        $.ajax({
            type: "GET",
            url: "/bin/helloosgiservletprop",
            data: {
                name: "Marco ",
                surname: "Guastalli"
            },
            success: function (data, textStatus, jqXHR) {
                $('.callHelloOsgiServletPropOutput').text(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("errorThrown: " + errorThrown);
            }
        })
    });
};

var refreshJora = function () {
    $('#refreshJora').click(function () {
        $.ajax({
            type: "GET",
            url: "/content/m27/jora.jora.html",
            success: function (data, textStatus, jqXHR) {
                $('#printJora').text(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("errorThrown: " + errorThrown);
            }
        })
    });
};

var getIsbnBook = function () {
    $("#isbnCodeSubmit").on('click', function() {
        $.ajax({
            type: "GET",
            url: "/bin/m27/getIsbnBook",
            data: {
                mappedUri: $('#mappedUri').val(),
                isbnCode: $('#isbnCode').val()
            },
            success: function(responseData) {
                $("#getIsbnBookOutput").html(responseData);
            }
        });
    });
};

/**
 * document ready function
 */
$(document).ready(function () {
    h3Text();
    callHelloOsgiServlet()
    callHelloOsgiServletProp()
    callHelloOsgiServletPropReset()
    refreshJora()
    getIsbnBook()
});