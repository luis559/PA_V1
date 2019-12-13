$(document).ready(function() {
    var table = $('#proveedoresTable').DataTable({
        "sAjaxSource": "/api/proveedores",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "estado" },
            { "mData": "numero" },
        ]
    })
});