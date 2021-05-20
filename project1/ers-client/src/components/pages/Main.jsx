import React, { useState } from 'react';
import Page from '../Page';
import employeeNavCards from '../EmployeeNavCards';
import managerNavCards from '../ManagerNavCards';

import { Redirect } from 'react-router';

const Main = ({ user }) => {
  const [manView, setManView] = useState(null);
  const [empView, setEmpView] = useState(null);
  const [mainView, setMainView] = useState(null);
  //TODO weird shift on other card in same column when hovering

  const manViewStateControl = {
    //TODO implement manager views
    pending: function () {
      console.log('pending');
    },
    resolved: function () {
      console.log('resolved');
    },
    singleEmployee: function () {
      console.log('single view');
    },
    allEmployees: function () {
      console.log('all employees');
    },
  };

  const empViewStateControl = {
    //TODO implement manager views
    request: function () {
      setEmpView('request');
    },
    resolved: function () {
      setEmpView('resolved');
    },
    pending: function () {
      setEmpView('pending');
    },
  };

  function generateMainView() {
    const view = empView || manView;

    switch (view) {
      case 'request':
        return EmployeeRequestForm();
      case 'pending':
        return EmployeePendingRequests();
      case 'resolved':
        return EmployeeResolvedRequests();
      default:
        return null;
    }
  }

  function EmployeeRequestForm() {
    // get option types
    return (
      <div>
        <h2>Reimbursement Request</h2>
        <form class='' action='emp-request'>
          <input type='text' />
          <input type='text' />
          <input type='text' />
        </form>
      </div>
    );
  }

  function EmployeePendingRequests(props) {
    return (
      <div>
        <h2>Pending Request Table</h2>
      </div>
    );
  }

  function EmployeeResolvedRequests() {
    return (
      <div>
        <h2>Resolved Requests</h2>
      </div>
    );
  }

  return !user ? (
    <Redirect to='/login' />
  ) : (
    <Page>
      <h1 style={{ fontSize: 'calc(1.3rem + .6vw)' }}>Reimbursements</h1>
      <h3 class='text-l uppercase text-gray-500 mb-10'>
        {user.roleId == 1 ? 'Manager' : 'Employee'}
      </h3>
      <div
        name='card-container'
        class='flex flex-wrap gap-x-3 gap-y-3 justify-around'
      >
        {user.roleId == 1
          ? managerNavCards(manViewStateControl)
          : employeeNavCards(empViewStateControl)}
      </div>
      <div className='main-content flex justify-center' name='main-content'>
        {empView || manView ? generateMainView() : null}
      </div>
    </Page>
  );
};

export default Main;
