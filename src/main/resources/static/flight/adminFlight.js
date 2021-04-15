function addFlight() {
    let date = $('#date').val();
    let startTime = $('#startTime').val() + ":00";
    let arriveTime = $('#arriveTime').val() + ":00";
    let fromLocation = $('#fromLocation').val();
    let toLocation = $('#toLocation').val();
    let price = $('#price').val();
    let flightBrand = $('#flightBrand').val();
    let flightBrandID = flightBrand.slice(0, 1);
    let flightBrandCode = flightBrand.slice(1);
    let newFlight = {
        date: date,
        startTime: startTime,
        arriveTime: arriveTime,
        fromLocation: {
            id: fromLocation,
        },
        toLocation: {
            id: toLocation,
        },
        price: price,
        flightBrand: {
            id: flightBrandID,
            code: flightBrandCode
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newFlight),
        url: "/flights",
        success: successHandler
    });
    event.preventDefault();
}

function successHandler(currentPage) {
    $.ajax({
        type: "GET",
        url: `/flights/ajax?page=${currentPage}`,
        success: function (data) {
            console.log(data);
            let content = "";
            for (let i = 0; i < data.content.length; i++) {
                content += getFlight(data.content[i]);
            }
            document.getElementById("flightList").innerHTML = content;
            document.getElementById("date").value = "";
            document.getElementById("startTime").value = "";
            document.getElementById("arriveTime").value = "";
            document.getElementById("fromLocation").value = "";
            document.getElementById("toLocation").value = "";
            document.getElementById("price").value = "";
            document.getElementById("flightBrand").value = 1;
        }
    })
}

function getFlight(flight) {
    let date = new Date(flight.date);
    let month = date.getMonth() + 1;
    let date2 = date.getDate();
    if (date2 < 10) {
        date2 = "0" + date2;
    }
    if (month < 10) {
        month = "0" + month;
    }
    date = date.getFullYear() + "-" + month + "-" + date2;
    return `<tr>
                        <td>${flight.id}</td>
                        <td>${flight.code}</td>
                        <td>${date}</td>
                        <td>${flight.startTime}</td>
                        <td>${flight.arriveTime}</td>
                        <td>${flight.fromLocation.name}</td>
                        <td>${flight.toLocation.name}</td>
                        <td>${flight.price}</td>
                        <td>${flight.flightBrand.name}</td>
                        <td><a id="${flight.id}" href="/flights/${flight.id}}" onclick="showEditModal(id)" class="btn btn-primary" data-toggle="modal" data-target="#editModal">Edit</a></td>
                        <td><a id="${flight.id}" href="/flights/${flight.id}}" onclick="showDeleteModal(id)" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</a></td>
                    </tr>`
}

function showEditModal(id) {
    $.ajax({
        type: "GET",
        url: `/flights/${id}`,
        success: function (data) {
            let date = new Date(data.date);
            let month = date.getMonth() + 1;
            let date2 = date.getDate();
            if (date2 < 10) {
                date2 = "0" + date2;
            }
            if (month < 10) {
                month = "0" + month;
            }
            date = date.getFullYear() + "-" + month + "-" + date2;
            document.getElementById("idEdit").value = data.id;
            document.getElementById("dateEdit").value = date;
            document.getElementById("startTimeEdit").value = data.startTime;
            document.getElementById("arriveTimeEdit").value = data.arriveTime;
            document.getElementById("fromLocationEdit").value = data.fromLocation.id;
            document.getElementById("toLocationEdit").value = data.toLocation.id;
            document.getElementById("priceEdit").value = data.price;
            document.getElementById("flightBrandEdit").value = data.flightBrand.id;
        }
    })
}

function editFlight() {
    let id = $('#idEdit').val();
    let date = $('#dateEdit').val();
    let startTime = $('#startTimeEdit').val();
    let arriveTime = $('#arriveTimeEdit').val();
    let fromLocation = $('#fromLocationEdit').val();
    let toLocation = $('#toLocationEdit').val();
    let price = $('#priceEdit').val();
    let flightBrand = $('#flightBrandEdit').val();
    let newFlight = {
        id: id,
        date: date,
        startTime: startTime,
        arriveTime: arriveTime,
        fromLocation: {
            id: fromLocation,
        },
        toLocation: {
            id: toLocation,
        },
        price: price,
        flightBrand: {
            id: flightBrand
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(newFlight),
        url: `/flights`,
        success: successHandler
    });
    event.preventDefault();
}

function showDeleteModal(id) {
    $.ajax({
        type: "GET",
        url: `/flights/${id}`,
        success: function (data) {
            let date = new Date(data.date);
            let month = date.getMonth() + 1;
            let date2 = date.getDate();
            if (date2 < 10) {
                date2 = "0" + date2;
            }
            if (month < 10) {
                month = "0" + month;
            }
            date = date.getFullYear() + "-" + month + "-" + date2;
            document.getElementById("idDel").value = data.id;
            document.getElementById("dateDel").value = date;
            document.getElementById("startTimeDel").value = data.startTime;
            document.getElementById("arriveTimeDel").value = data.arriveTime;
            document.getElementById("fromLocationDel").value = data.fromLocation.id;
            document.getElementById("toLocationDel").value = data.toLocation.id;
            document.getElementById("priceDel").value = data.price;
            document.getElementById("flightBrandDel").value = data.flightBrand.id;
        }
    })
}

function deleteFlight() {
    let id = document.getElementById("idDel").value;
    $.ajax({
        url: `/flights/${id}`,
        type: "DELETE",
        success: function () {
            document.getElementById(id).parentElement.parentElement.remove();
        }
    });
    event.preventDefault();
}

function toActivePage(id) {
    let buttons = document.getElementsByClassName("page-item");
    for (i = 0; i < buttons.length; i++) {
        if (buttons[i].classList.contains("active")) buttons[i].classList.remove("active");
    }
    let ele = document.getElementById(id);
    ele.classList.add("active");
    let currentPage = document.getElementById("currentPage");
    let newPage = parseInt(id.slice(4, 5));
    currentPage.innerText = newPage + 1;
    $.ajax({
        url: `/flights/ajax?page=${newPage}`,
        type: "GET",
        success: successHandler(newPage)
    })
}

function previousPage() {
    let currentPage = parseInt(document.getElementById("currentPage").innerText);
    if (currentPage !== 1) {
        currentPage -= 2;
        let id = "page" + currentPage;
        toActivePage(id);
    }
}

function nextPage() {
    let currentPage = parseInt(document.getElementById("currentPage").innerText);
    let buttons = document.getElementsByClassName("page-item");
    let lastPage;
    for (let i = 0; i < buttons.length - 1; i++) {
        lastPage = buttons[i];
    }
    let lastPageNumber = parseInt(lastPage.id.slice(4, 5)) + 1;
    if (currentPage !== lastPageNumber) {
        let id = "page" + currentPage;
        toActivePage(id);
    }
}

function searchFlight() {
    let search = $("#searchBox").val();
    $.ajax({
        url: `/flights/ajax?q=${search}`,
        type: "GET",
        success: function (data) {
            console.log(data);
            let content = "";
            for (let i = 0; i < data.content.length; i++) {
                content += getFlight(data.content[i]);
            }
            document.getElementById("flightList").innerHTML = content;
        }
    })
}