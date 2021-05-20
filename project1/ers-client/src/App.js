import React, { useState } from 'react'
import axios from 'axios'
import '../src/styles/custom.css'


// import './App.css';
import LoginPage from './components/pages/LoginPage'
import Main from './components/pages/Main'
import AppNav from './components/AppNav'
import { BrowserRouter as Router, Route } from 'react-router-dom';


function App() {
  const [ user, setUser ] = useState( null );

  async function login( formData ) {
    const headers = {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
    };
    const result = await axios.post( 'login', formData, headers );
    console.log( result.data )
    if ( result.data ) {
      const { data: { id, roleId, username } } = result;
      setUser( { id, roleId, username } )
    }
  }

  async function logout() {
    //TODO call to /logout 
    console.log( "logout called" )
    const result = await axios.get( 'logout' )
    console.log( result )
    setUser( null )
  }

  return (
    <Router>
      <AppNav user={user} logout={logout} />
      <Route path="/" render={props => ( <LoginPage {...props} login={login} user={user} /> )} />
      <Route path="/main" render={props => ( <Main {...props} user={user} /> )} />
    </Router>
  );
}

export default App;