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

    function successHandle() {
    $.ajax({
        type: "GET",
        url: "/rooms/ajax",
        success: function (data) {
            console.log(data)
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

    function deleteRoom(id) {
    $.ajax({
        url: `/rooms/${id}`,
        type: "DELETE",
        success: function () {
            document.getElementById(id).parentElement.parentElement.remove();
        }
    });
    event.preventDefault();
}
