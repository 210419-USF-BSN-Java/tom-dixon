function formatDate( date ) {
    const formattedDate = new Date( date );
    return formattedDate.toDateString().split( ' ' ).slice( 1 ).join( ' ' );
}

export default formatDate