/* Please include here all author script code needed */
$(document).ready(function(){

    $(".migrationButton").on('click', function() {
        var buttonID = $(this).attr('id');
        var number = buttonID.split("_")[1];
        $.ajax({
            type: "GET",
            url: "/bin/m27/migration",
            data: { migrationToDo: $(this).attr('val'),
                paths: $('#migrationPaths_' + number).val(),
                dryRun: $('#dryRun_' + number).is(':checked') },
            success: function(responseData) {
                $("#migrationResult").html(responseData);
            }
        });
    });

});