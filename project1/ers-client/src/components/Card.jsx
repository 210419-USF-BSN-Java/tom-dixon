import React from 'react';

const Card = ({ icon, title, desc, action }) => {
  function handleClick() {
    // console.log('hello');
    action();
  }

  return (
    <button
      onClick={handleClick}
      class='menu-card pt-6 px-7 max-w-16-custom pb-7 mb-5'
      name='cust-request-new'
      id='custRequestNew'
    >
      <div class='card-header card-subheader-container'>
        <h3 class='fs-6 tertiary-color flex-baseline-custom mb-1'>
          <span className='mr-2'>{icon()}</span>
          <span class='action-text'>{title}</span>
        </h3>
        <p>{desc}</p>
      </div>
    </button>
  );
};

export default Card;
