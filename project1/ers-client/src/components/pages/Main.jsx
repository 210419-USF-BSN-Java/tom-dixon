import React from 'react';
import Page from '../Page';
import Card from '../Card';
import fatStacks from '../../svg-icons/fatStacks';
import time from '../../svg-icons/time';
import bank from '../../svg-icons/bank';
import userIcon from '../../svg-icons/userIcon';
import usersIcon from '../../svg-icons/usersIcon';
import { Redirect } from 'react-router';

const Main = ({ user }) => {
  //TODO get reimbursements according to user role/id

  //TODO weird shift on other card in same column when hovering
  const employeeNavCards = () => {
    return (
      <>
        <Card
          icon={fatStacks}
          title='Request'
          desc='Submit a new request for reimbursement'
        />
        <Card
          icon={time}
          title='Pending'
          desc='View all pending reimbursement requests'
        />
        <Card
          icon={bank}
          title='Resolved'
          desc='View all approved/rejected reimbursement requests'
        />
      </>
    );
  };

  const managerNavCards = () => {
    return (
      <>
        <div>
          <Card
            icon={time}
            title='Pending'
            desc='View all pending reimbursement requests'
          />
          <Card
            icon={bank}
            title='Resolved'
            desc='View all approved/rejected reimbursement requests'
          />
        </div>
        <div>
          <Card
            icon={userIcon}
            title='Employee requests'
            desc='View all requests from a single employee'
          />
          <Card
            icon={usersIcon}
            title='Employees'
            desc='View all employees on record'
          />
        </div>
      </>
    );
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
        {user.roleId == 1 ? managerNavCards() : employeeNavCards()}
      </div>
    </Page>
  );
};

export default Main;
