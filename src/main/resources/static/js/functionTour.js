
function search() {
    let search = $("#search").val();
    $.ajax({
        url: `/admin/tours/list?t=${search}`,
        type: "GET",
        success: function (data){
            console.log(data);
            let content = "";
            for (let i = 0; i < data.content.length; i++) {
                content += getTour(data.content[i]);
            }
            document.getElementById("lisTour").innerHTML = content;
        }
    });
}

function addTour() {
    let name = $('#name').val();
    let description = $('#description').val();
    let price = $('#price').val();
    let time = $('#time').val();
    let location = $('#location').val();
    let newTour = {
        name: name,
        description: description,
        price: price,
        time: time,
        location: {
            id: location
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newTour),
        url: "/admin/tours/save",
        success: successHandler

    });
    event.preventDefault();
}

function successHandler() {
    $.ajax({
        url: `/admin/tours/list`,
        type: "GET",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.content.length; i++) {
                content += getTour(data.content[i]);
            }
            document.getElementById("lisTour").innerHTML = content;
        }
    })
}


function getTour(tour) {
    return `<tr>
                        <td>${tour.name}</td>
                        <td>${tour.description}</td>
                        <td>${tour.price}</td>
                        <td>${tour.time}</td>
                        <td>${tour.location.name}</td>
                        <td>
                        <a id="${tour.id}" href="/tours/find/${tour.id}" onclick="showDelete(id)" class="btn btn-danger" data-toggle="modal" data-target="#deleteTour">Delete</a>
                        <a id="${tour.id}" href="/tours/find/${tour.id}" onclick="ShowEditTour(id)"class="btn btn-primary" data-toggle="modal" data-target="#ShowEditTour"
                   data-whatever="@getbootstrap">Edit</a>
                        </td>
                    </tr>`
}

function showDelete(id) {
    $.ajax({
        url: `/admin/tours/find/${id}`,
        type: "GET",
        success: function (data) {
            document.getElementById("iddelete").value = data.id;
            document.getElementById("namedelete").innerText = data.name;
        }
    });
}

function deleteTour() {
    let iddelte = $('#iddelete').val();
    $.ajax({
        url: `/admin/tours/delete/${iddelte}`,
        type: "DELETE",
        success: function () {
            document.getElementById(iddelte).parentElement.parentElement.remove()
        }
    });
    event.preventDefault();
}


function ShowEditTour(id) {
    $.ajax({
        url: "/admin/tours/find/" + id,
        type: "GET",
        success: function (data) {
            document.getElementById("ids").value = data.id;
            document.getElementById("names").value = data.name;
            document.getElementById("descriptions").value = data.description;
            document.getElementById("prices").value = data.price;
            document.getElementById("times").value = data.time;
            document.getElementById("locations").value = data.location.id;
        }
    });
}

function editTour() {
    let ids = $('#ids').val();
    let names = $('#names').val();
    let descriptions = $('#descriptions').val();
    let prices = $('#prices').val();
    let times = $('#times').val();
    let locations = $('#locations').val();
    let editTours = {
        id: ids,
        name: names,
        description: descriptions,
        price: prices,
        time: times,
        location: {id: locations},
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(editTours),
        url: `/admin/tours`,
        success: successHandler
    });
    event.preventDefault();
}


function toActivePage(id) {
    let buttons = document.getElementsByClassName("page-item");
    for (let i = 0; i < buttons.length; i++) {
        if (buttons[i].classList.contains("active")) buttons[i].classList.remove("active");
    }
    let ele = document.getElementById(id);
    ele.classList.add("active");
    let currentPage = document.getElementById("currentPage");
    let newPage = parseInt(id.slice(4, 5));
    currentPage.innerText = newPage + 1;
    $.ajax({
        url: `/admin/tours/page=${newPage}`,
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
    for (let i = 0; i < buttons.length; i++) {
        lastPage = buttons[i];
    }
    let lastPageNumber = parseInt(lastPage.id.slice(4, 5));
    if (currentPage !== lastPageNumber) {
        let id = "page" + currentPage;
        toActivePage(id);
    }
}
