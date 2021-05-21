import React from 'react';
import axios from 'axios';

function EmployeeRequestForm() {
  const typeOptions = [
    { id: 1, expense_type: 'Lodging' },
    { id: 2, expense_type: 'Travel' },
    { id: 3, expense_type: 'Food' },
    { id: 4, expense_type: 'Other' },
  ];

  return (
    <div class='w-full max-w-xs text-sm'>
      <h2 class='text-2xl action-text form-title text-center mb-3'>
        Reimbursement Request
      </h2>
      <form
        class='bg-gray shadow-md rounded px-8 pt-6 pb-8 mb-4'
        action='emp-request'
      >
        <label
          className='block text-gray-700 text-sm font-bold mb-2'
          htmlFor='type'
        >
          Type
        </label>
        <select className='block appearance-none w-full bg-white border border-gray-200 hover:border-gray-500 px-4 py-2 pr-8 mb-6 shadow-sm leading-tight focus:outline-none focus:shadow-outline'>
          {typeOptions.map(({ id, expense_type }) => (
            <option key={id} id={id}>
              {expense_type}
            </option>
          ))}
        </select>
        <label
          className='block text-gray-700 text-sm font-bold mb-2'
          htmlFor='amount'
        >
          Amount
        </label>
        <input
          className='block appearance-none w-full bg-white border border-gray-200 hover:border-gray-500 px-4 py-2 pr-8 shadow-sm mb-6 text-sm leading-tight focus:outline-none focus:shadow-outline'
          type='number'
          name='amount'
          id=''
        />
        <label
          className='block text-gray-700 text-sm font-bold mb-2'
          htmlFor='amount'
        >
          Description
        </label>
        <textarea
          class='hover:border-gray-500 form-textarea mt-1 block w-full border border-gray-200 px-2 py-2 mb-5'
          rows='3'
          placeholder='Additional information?'
        ></textarea>

        <div class='flex justify-center'>
          <button
            class='shadow form-btn focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4'
            type='button'
          >
            Request{' '}
          </button>
        </div>
      </form>
    </div>
  );
}

export default EmployeeRequestForm;
