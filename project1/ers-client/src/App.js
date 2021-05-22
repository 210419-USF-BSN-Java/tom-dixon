import React, { useState } from 'react'
import axios from 'axios'
import qs from 'qs';

import '../src/styles/custom.css'


// import './App.css';
import LoginPage from './components/pages/LoginPage'
import Main from './components/pages/Main'
import AppNav from './components/AppNav'
import { BrowserRouter as Router, Route } from 'react-router-dom';


const formHeaders = {
  'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
};

// MAIN APP -- BEGIN
function App() {
  const [ user, setUser ] = useState( null );
  const [ reimReqs, setReimReqs ] = useState( [] );


  // API CALLS
  async function login( formData ) {

    console.log( 'check form data login' )
    console.log( formData )
    const result = await axios.post( 'login', formData, formHeaders );
    console.log( result.data )
    if ( result.data ) {
      const { data: { id, roleId, username } } = result;
      setUser( { id, roleId, username } )
    }
  }

  async function logout() {
    console.log( "logout called" )
    const result = await axios.get( 'logout' )
    console.log( result )
    setUser( null )
  }

  async function addRequest( { amount, desc, typeId } ) {

    //  add employee id rename vars to match params in the back and format as path params because Servlets
    const reqParams = qs.stringify( {
      amount,
      description: desc,
      type: typeId,
      empId: user.id
    } )

    const result = await axios.post( 'emp-reimbursement', reqParams, formHeaders );
    console.log( result )
    // add to state
    setReimReqs( [ ...reimReqs, result ] )
  }

  async function getReimbursementTypes() {
    //dynamically generate reimbursement type options for emp req form
    console.log( "get reimbursement types" )
    const result = await axios.get( 'reimbursementRequest' )
    console.log( result )
  }

  async function getOneEmpsReqs() {
    let { data } = await axios.get( 'emp-reimbursement' )
    if ( data ) {
      console.log( data )
      return data.filter( e => e.statusId == 1 );
    }
  }

  function getAllReqs() {
    console.log( 'make get req to "reimbursements"' )
    // filter results for 
  }

  function getEmployees() {
    console.log( "GET ALL EMPLOYEES" )
  }

  return (
    <Router>
      <AppNav user={user} logout={logout} />
      <Route path="/" render={props => ( <LoginPage {...props} login={login} user={user} /> )} />
      <Route path="/main" render={props => ( <Main {...props} user={user} addReq={addRequest} getOneEmpsReqs={getOneEmpsReqs} getAllReqs={getAllReqs} getEmployees={getEmployees} /> )} />
    </Router>
  );
}

export default App;