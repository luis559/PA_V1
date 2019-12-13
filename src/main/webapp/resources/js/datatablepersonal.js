$(document).ready(function() {
    var table = $('#personalTable').DataTable({
        "sAjaxSource": "/api/personal",
        "sAjaxDataProp": "",
        "order": [
            [0, "asc"]
        ],
        "aoColumns": [
            { "mData": "id" },
            { "mData": "nombre" },
            { "mData": "cargo" },
            { "mData": "sueldo" },
            { "mData": "edad" },
            { "mData": "celular" },
        ]
    })
});