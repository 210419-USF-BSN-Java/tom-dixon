
function deleteCookies() {
    let res = document.cookie;
    let cookies = res.split( ";" );
    for ( let i = 0; i < cookies.length; i++ ) {
        let key = cookies[ i ].split( "=" );
        document.cookie = key[ 0 ] + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
        console.log( document.cookie )
    }
}

export default deleteCookies;