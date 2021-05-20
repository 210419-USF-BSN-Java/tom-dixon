import Card from './Card';

import time from '../svg-icons/time';
import bank from '../svg-icons/bank';
import fatStacks from '../svg-icons/fatStacks';

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

export default employeeNavCards;
