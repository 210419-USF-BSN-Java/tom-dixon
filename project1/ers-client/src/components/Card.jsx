import React from 'react';

const Card = ({ icon, title, desc }) => {
  return (
    <div
      class='menu-card pt-6 px-7 max-w-16-custom pb-7 mb-5'
      name='cust-request-new'
      id='custRequestNew'
    >
      <div class='card-header card-subheader-container'>
        <h3 class='fs-6 tertiary-color flex-baseline-custom mb-1'>
          <span className='mr-2'>{icon()}</span>
          <span style={{ color: 'rgb(84, 105, 212)' }}>{title}</span>
        </h3>
        <p>{desc}</p>
      </div>
    </div>
  );
};

export default Card;
