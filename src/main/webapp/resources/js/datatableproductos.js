$(document).ready(function() {
    var table = $('#productosTable').DataTable({
        "sAjaxSource": "/api/productos",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "descripcion" },
        ]
    })
});