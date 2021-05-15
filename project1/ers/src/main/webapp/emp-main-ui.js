// Attach event listeners to buttons
const cardButtons = document.querySelector( ".card-menu-container" );



function removeFromUi( element ) {
    element.classList.add( "hidden" )
}


document.querySelector( '#custRequestNew' ).addEventListener( 'click', function ( e ) {
    // remove card buttons
    removeFromUi( cardButtons );
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


