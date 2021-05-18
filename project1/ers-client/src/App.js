import React from 'react'


// import './App.css';
import LoginPage from './components/pages/LoginPage'
// // import Main from './components/pages/Main'
import AppNav from './components/AppNav'
import { BrowserRouter as Router, Route } from 'react-router-dom';


function App() {
  return (
    <Router>
      <AppNav />
      <Route path="/" component={LoginPage} />
    </Router>
  );
}

export default App;