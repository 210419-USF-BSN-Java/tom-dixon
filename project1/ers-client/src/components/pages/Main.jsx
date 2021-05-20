import React, { useState } from 'react';
import Page from '../Page';
import employeeNavCards from '../EmployeeNavCards';
import managerNavCards from '../ManagerNavCards';

import { Redirect } from 'react-router';

const Main = ({ user }) => {
  const [manView, setManView] = useState(null);
  const [empView, setEmpView] = useState(null);
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
          : employeeNavCards()}
      </div>
    </Page>
  );
};

export default Main;
