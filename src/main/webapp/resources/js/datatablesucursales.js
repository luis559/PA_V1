$(document).ready(function() {
    var table = $('#sucursalesTable').DataTable({
        "sAjaxSource": "/api/sucursales",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "ciudad" },
            { "mData": "direccion" },
            { "mData": "telefono" },
            { "mData": "gerencia" },
        ]
    })
});