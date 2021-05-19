import React from 'react';

const Card = ({ icon }) => {
  return (
    <div class='menu-card' name='cust-request-new' id='custRequestNew'>
      <div class='card-header card-subheader-container'>
        <h3 class='fs-6 tertiary-color flex-baseline'>
          {icon()}
          {/* <svg
            class='mr-sm'
            height='16'
            width='16'
            viewBox='0 0 16 16'
            xmlns='http://www.w3.org/2000/svg'
          >
            <path
              d='M12 16a4 4 0 1 1 0-8 4 4 0 0 1 0 8zM3 1h8a1 1 0 0 1 0 2H3a1 1 0 1 1 0-2zm6.93 5.366A5.98 5.98 0 0 0 8.683 7H1a1 1 0 1 1 0-2h8a1 1 0 0 1 .93 1.366zM6.804 9a5.96 5.96 0 0 0-.72 2H2a1 1 0 0 1 0-2zm-.72 4a5.96 5.96 0 0 0 .72 2H1a1 1 0 0 1 0-2z'
              fill-rule='evenodd'
            ></path>
          </svg> */}
          Request
        </h3>
        <p>Submit a new request for reimbursement</p>
      </div>
    </div>
  );
};

export default Card;
