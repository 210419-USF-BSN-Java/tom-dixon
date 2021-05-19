import React from 'react';
import Page from '../Page';
import Card from '../Card';
import fatStacks from '../../svg-icons/fatStacks';

const Main = ({ user }) => {
  //TODO get reimbursements according to user role/id

  // create card content based on roleId (1 = manager, 2 = employee)

  const { id, roleId, userName } = user;
  return (
    <Page>
      <h1 style={{ fontSize: 'calc(1.3rem + .6vw)' }}>Reimbursements</h1>
      <h3 class='text-l uppercase text-gray-500 mb-10'>
        {roleId == 1 ? 'Manager' : 'Employee'}
      </h3>

      <div
        name='card-container'
        class='flex flex-wrap gap-x-3 gap-y-3 justify-around'
      >
        <Card icon={fatStacks} title='Request' />
        <Card icon={fatStacks} title='Request' />
        <Card icon={fatStacks} title='Request' />
      </div>
    </Page>
  );
};

export default Main;
