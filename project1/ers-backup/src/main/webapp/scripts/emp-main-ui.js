// Attach event listeners to buttons
const cardButtons = document.querySelector( ".card-menu-container" );
const requestForm = document.querySelector( "#request-form" )



function removeFromUi( element ) {
    element.classList.add( "hidden" )
}

function addToUi( element ) {
    element.classList.remove( "hidden" )
}


document.querySelector( '#custRequestNew' ).addEventListener( 'click', function ( e ) {
    // remove card buttons
    removeFromUi( cardButtons );
    addToUi( requestForm )
    // show form



} )

document.querySelector( '#custViewPending' ).addEventListener( 'click', function () {
    console.log( 'clicked pending' )
    removeFromUi( cardButtons );

} )

document.querySelector( '#custViewResolved' ).addEventListener( 'click', function () {
    console.log( 'clicked resolved' )
    removeFromUi( cardButtons );

} )


