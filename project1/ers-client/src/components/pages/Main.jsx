import React from 'react';
import Page from '../Page';
import Card from '../Card';

const Main = ({ user }) => {
  //TODO if user.roleId == 2, get reimbursements
  return (
    <Page>
      <h1 style={{ fontSize: 'calc(1.3rem + .6vw)' }}>Reimbursements</h1>
      <h3 class='text-xl'>{user.roleId == 1 ? 'Manager' : 'Employee'}</h3>
      <div name='card-container' class=''>
        <Card />
        <Card />
        <Card />
      </div>
    </Page>
  );
};

export default Main;
