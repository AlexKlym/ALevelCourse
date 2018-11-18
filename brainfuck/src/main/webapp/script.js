
var inpu = document.getElementById("inp");
var output = document.getElementById("out");
var button = document.getElementById("submit");


button.addEventListener("click", function () {
    axios.get('input', {
        params: {
            input: inpu.value
        }
    })
        .then(function (result) {
            var ans = result.data.output;
            document.getElementById("output").value = ans;


        })


});
