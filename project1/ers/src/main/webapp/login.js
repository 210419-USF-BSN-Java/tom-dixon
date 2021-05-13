// list for submit event
// get form
const form = document.querySelector( "#login-form" );
form.addEventListener( 'submit', function ( e ) {
    console.log( "login event listener" )
    console.log( e.target )
} )