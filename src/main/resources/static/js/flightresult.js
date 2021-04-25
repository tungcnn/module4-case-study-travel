let flight1Id;
let flight2Id;

function selectFlight(id) {
    flight1Id = id;
    window.location.href += "#firstFlight"
    $.ajax({
        url: '/flights/users/' + id,
        type: 'GET',
        success: function (data) {
            document.getElementById("firstFlight").innerHTML = printFlight(data)
        }
    })
}

function selectFlight2(id) {
    flight2Id = id;
    $.ajax({
        url: '/flights/users/' + id,
        type: 'GET',
        success: function (data) {
            document.getElementById("secondFlight").innerHTML = printFlight(data)
        }
    })
}
function printFlight(data) {
 return '<div class="card" style="width: 100%;">\n' +
     '                    <div class="card-body">\n' +
     '                        <h3 class="font-weight-bold mb-3">' + data.fromLocation.name + ' => ' + data.toLocation.name + '</h3>\n' +
     '                        <h5 class="font-weight-bold mb-3">' + data.date +'</h5>\n' +
     '                        <h5 class="font-weight-bold mb-3">' + data.flightBrand.name + '</h5>\n' +
     '                    </div>\n' +
     '                    <ul class="list-group list-group-flush">\n' +
     '                        <li class="list-group-item">Depart: ' + data.startTime + '</li>\n' +
     '                        <li class="list-group-item">Arrive: ' + data.arriveTime + '</li>\n' +
     '                        <li class="list-group-item">Price: ' + data.price + '</li>\n' +
     '                    </ul>\n' +
     '                </div>'
}
function handleBooking() {
    if (flight1Id === undefined && flight2Id === undefined) {
        alert("You must choose at least 1 flight")
    } else {
        window.location.href = "/flights/users/book?flightID=" + flight1Id + "&flight2ID=" + flight2Id
    }
}