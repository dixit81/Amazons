

$(document).ready(function () {
    var boundSelectTile = selectTile();
    $('.cell').click(boundSelectTile);

    updateState();
});


function selectTile() {
    var currentSelected=null;
    return function() {

        // Nothing selected, make a new selection
        if (currentSelected===null) {
            currentSelected = $(this);
            currentSelected.toggleClass('selected');

        // Repeated click, deselect
        } else if (currentSelected===$(this)) {
            currentSelected.toggleClass('selected');

        // Second click TODO what about the arrow throw?
        } else {
            // TODO Perform a POST to /api/move and upon success call updateState()
            // $(this).data('i')
            currentSelected.toggleClass('selected');

        }

        console.log(this, currentSelected);
    };
}

function updateState() {
    // TODO Perform a GET to /api/state and set the classes of relevant tiles accordingly
}
