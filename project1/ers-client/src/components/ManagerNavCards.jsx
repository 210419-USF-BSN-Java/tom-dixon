import Card from './Card';
import userIcon from '../svg-icons/userIcon';
import usersIcon from '../svg-icons/usersIcon';
import time from '../svg-icons/time';
import bank from '../svg-icons/bank';

const managerNavCards = ({ allReqs, allEmployees }) => {
  return (
    <>
      <div className='flex flex-col'>
        <Card
          action={allReqs}
          icon={time}
          title='Pending'
          desc='View all pending reimbursement requests'
        />
        <Card
          action={allReqs}
          icon={bank}
          title='Resolved'
          desc='View all approved/rejected reimbursement requests'
        />
      </div>
      <div className='flex flex-col'>
        <Card
          action={allReqs}
          icon={userIcon}
          title='Employee requests'
          desc='View all requests from a single employee'
        />
        <Card
          action={allEmployees}
          icon={usersIcon}
          title='Employees'
          desc='View all employees on record'
        />
      </div>
    </>
  );
};

export default managerNavCards;
