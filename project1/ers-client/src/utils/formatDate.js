function formatDate( date ) {
    const now = new Date( date );
    const inter = now.toDateString().split( ' ' ).slice( 1 ).join( ' ' );

    console.log( inter )
    return now.toDateString().split( ' ' ).slice( 1 ).join( ' ' );
}

export default formatDate