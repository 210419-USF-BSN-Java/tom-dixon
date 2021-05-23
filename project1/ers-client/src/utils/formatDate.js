function formatDate( date ) {
    const now = new Date( date );
    // const month = now.getMonth() + 1
    // const day = now.getDate();
    // const year = now.getFullYear()
    // // const inter = now.toDateString().split( ' ' ).slice( 1 ).join( ' ' );
    // console.log( `${ now.getMonth() + 1 }/${ now.getDate() }/${ now.getFullYear().toString().slice( 2 ) }` )
    return `${ now.getMonth() + 1 }/${ now.getDate() }/${ now.getFullYear().toString().slice( 2 ) }`
}

export default formatDate