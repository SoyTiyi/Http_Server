var app = (function() {
    const response = (error, data) => {
        if (error != null) {
            console.log(`Error: ${error}`);
            alert("Formato Invalido -> ej: 10.5,3.5,5");
            return;
        }
        $("#reponse").text(data.response);

    }

    const send = () => {
        var data = $("#list").val();
        postMethod(data, response);
    }

    const postMethod = (listNum,numbers) => {
        var promise = $.get({
            url: "/Apps",
            data: JSON.stringify(listNum),
            contentType: "application/json"
        });
        promise.then((data) => {
            numbers(null, JSON.parse(data));
        },(error) => {
            numbers(error, null);
        });
    }

    return {
        send: function() {
            send();
        }
    }
})();