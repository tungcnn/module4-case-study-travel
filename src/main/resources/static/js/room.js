function addNewRoom() {
    let hotel = $('#hotel').val();
    let name = $('#name').val();
    let type = $('#type').val();
    let price = $('#price').val();
    let slot = $('#slot').val();
    let detail = $('#detail').val();
    let newRoom = {
        hotel: {
            id: hotel
        },
        name: name,
        type: type,
        price: price,
        slot: slot,
        detail: detail
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newRoom),

        url: "/rooms",

        success: successHandle
    });
    event.preventDefault();
}

function successHandle(currentPage) {
    $.ajax({
        type: "GET",
        url: `/rooms/ajax?page=${currentPage}`,
        success: function (data) {
            let room = "";
            for (let i = 0; i < data.content.length; i++) {
                room += getNewRoom(data.content[i])
            }
            document.getElementById('rooms').innerHTML = room;
            document.getElementById('hotel').value = "";
            document.getElementById('name').value = "";
            document.getElementById('type').value = "";
            document.getElementById('price').value = "";
            document.getElementById('slot').value = "";
            document.getElementById('detail').value = "";
        }
    });
}

function getNewRoom(newRoom) {
    return `<tr>
                        <td>${newRoom.id}</td>
                        <td>${newRoom.hotel.name}</td>
                        <td>${newRoom.name}</td>
                        <td>${newRoom.type}</td>
                        <td>${newRoom.price}</td>
                        <td>${newRoom.slot}</td>
                        <td>${newRoom.detail}</td>
                        <td><a class="btn btn-primary editRoom" href="/rooms/${newRoom.id}" id="${newRoom.id}" onclick="showFormEdit(id)" data-toggle="modal" data-target="#editModal">Edit</a></td>
                        <td><a class="btn btn-danger deleteRoom" href="/rooms/${newRoom.id}" id="${newRoom.id}" onclick="deleteRoom(id)">Delete</a></td>
                    </tr>`;
}

function showFormEdit(id) {
    $.ajax({
        type: "GET",
        url: `/rooms/${id}`,
        success: function (data) {
            document.getElementById('idEdit').value = data.id;
            document.getElementById('hotelEdit').value = data.hotel.id;
            document.getElementById('nameEdit').value = data.name;
            document.getElementById('typeEdit').value = data.type;
            document.getElementById('priceEdit').value = data.price;
            document.getElementById('slotEdit').value = data.slot;
            document.getElementById('detailEdit').value = data.detail;
        }
    })
}

function editRoom() {
    let id = $('#idEdit').val();
    let hotel = $('#hotelEdit').val();
    let name = $('#nameEdit').val();
    let type = $('#typeEdit').val();
    let price = $('#priceEdit').val();
    let slot = $('#slotEdit').val();
    let detail = $('#detailEdit').val();
    let newRoom = {
        id: id,
        hotel: {
            id: hotel
        },
        name: name,
        type: type,
        price: price,
        slot: slot,
        detail: detail
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newRoom),

        url: "/rooms",

        success: successHandle
    });
    event.preventDefault();
}

function showDeleteForm(id) {
    $.ajax({
        type: "GET",
        url: `/rooms/${id}`,
        success: function (data) {
            document.getElementById('idDelete').value = data.id;
            document.getElementById('hotelDelete').value = data.hotel.id;
            document.getElementById('nameDelete').value = data.name;
            document.getElementById('typeDelete').value = data.type;
            document.getElementById('priceDelete').value = data.price;
            document.getElementById('slotDelete').value = data.slot;
            document.getElementById('detailDelete').value = data.detail;
        }
    })
}

function deleteRoom() {
    let id = document.getElementById('idDelete').value;
    $.ajax({
        url: `/rooms/${id}`,
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
        url: `/rooms/ajax?page=${newPage}`,
        type: "GET",
        success: function successHandle() {
            $.ajax({
                type: "GET",
                url: `/rooms/ajax?page=${newPage}`,
                success: function (data) {
                    let room = "";
                    for (let i = 0; i < data.content.length; i++) {
                        room += getNewRoom(data.content[i])
                    }
                    document.getElementById('rooms').innerHTML = room;
                    document.getElementById('hotel').value = "";
                    document.getElementById('name').value = "";
                    document.getElementById('type').value = "";
                    document.getElementById('price').value = "";
                    document.getElementById('slot').value = "";
                    document.getElementById('detail').value = "";
                }
            });
        }

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

function searchBy() {
    
}
