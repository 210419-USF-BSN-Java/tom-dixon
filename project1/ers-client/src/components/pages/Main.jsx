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

const Main = ({ user, addReq }) => {
  const [manView, setManView] = useState(null);
  const [empView, setEmpView] = useState(null);

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
        return (
          <EmployeeRequestForm addReq={addReq} clearMain={clearMainView} />
        );
      case 'pending':
        console.log('pending');
        break;
      case 'resolved':
        console.log('resolved requests');
        break;
      default:
        return null;
    }
  }

  function clearMainView() {
    empView ? setEmpView(null) : setManView(null);
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
