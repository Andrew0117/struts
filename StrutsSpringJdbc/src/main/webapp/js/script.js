$(document).ready(function() {
    $.datepicker.setDefaults();
    $('input#birthday')
            .datepicker({dateFormat: 'yy-mm-dd'})
            .datepicker();
});