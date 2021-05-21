import React, { useState } from 'react';
import Page from '../Page';
import employeeNavCards from '../EmployeeNavCards';
import managerNavCards from '../ManagerNavCards';
import EmployeeRequestForm from '../EmployeeRequestForm';

import { Redirect } from 'react-router';

const initialReqFormValues = {
  typeId: 0,
  dec: '',
  amount: 0,
};

const Main = ({ user, addRequest }) => {
  const [manView, setManView] = useState(null);
  const [empView, setEmpView] = useState(null);
  // const [mainView, setMainView] = useState(null);
  const [reqFormValues, setReqFormValues] = useState(initialReqFormValues);

  function handleReqFormChange(e) {
    console.log(e.target.name);
  }

  function handleRequestSubmit() {
    console.log('Call addRequest');
    addRequest();
  }

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
        return EmployeeRequestForm(reqFormValues, handleReqFormChange);
      case 'pending':
        return EmployeePendingRequests();
      case 'resolved':
        return EmployeeResolvedRequests();
      default:
        return null;
    }
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
      <h3 className='ext-l uppercase text-gray-500 mb-10'>
        {user.roleId == 1 ? 'Manager' : 'Employee'}
      </h3>
      <div
        name='card-container'
        className='flex flex-wrap gap-x-3 gap-y-3 justify-around mb-9'
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
