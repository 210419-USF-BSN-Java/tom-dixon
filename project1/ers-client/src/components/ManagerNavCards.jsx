import Card from './Card';
import userIcon from '../svg-icons/userIcon';
import usersIcon from '../svg-icons/usersIcon';
import time from '../svg-icons/time';
import bank from '../svg-icons/bank';

const managerNavCards = ({
  pending,
  resolved,
  singleEmployee,
  allEmployees,
}) => {
  return (
    <>
      <div>
        <Card
          action={pending}
          icon={time}
          title='Pending'
          desc='View all pending reimbursement requests'
        />
        <Card
          action={resolved}
          icon={bank}
          title='Resolved'
          desc='View all approved/rejected reimbursement requests'
        />
      </div>
      <div>
        <Card
          action={singleEmployee}
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
