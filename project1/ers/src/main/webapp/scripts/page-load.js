window.addEventListener( 'load', ( event ) => {
    setTimeout( function () {
        // remove spinner from DOM
        console.log( "IS THIS THING ON" )
        document.querySelector( ".spinner-container" ).remove();
        // display card choices
        document.querySelector( "#card-menu-container" ).classList.remove( "hidden" )


    }, 2000 );



} );





