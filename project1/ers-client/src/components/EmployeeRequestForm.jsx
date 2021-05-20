import React from 'react';
import axios from 'axios';

function EmployeeRequestForm() {
  async function createOptions() {
    try {
      const result = await axios.get('reimbursement-types');
      console.log(result.data);
    } catch (err) {
      console.log(err);
    }
  }

  return (
    <div class='w-full max-w-xs'>
      <h2>Reimbursement Request</h2>
      <form
        class='bg-gray-100 shadow-md rounded px-8 pt-6 pb-8 mb-4'
        action='emp-request'
      >
        <label
          className='block text-gray-700 text-sm font-bold mb-2'
          htmlFor='type'
        >
          Type
        </label>
        <select className='block appearance-none w-full bg-white border border-gray-200 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow-sm leading-tight focus:outline-none focus:shadow-outline'>
          <option>Other</option>
          <option>Lodging</option>
          <option>meals</option>
        </select>
        <label
          className='block text-gray-700 text-sm font-bold mb-2'
          htmlFor='amount'
        >
          Amount
        </label>
        <input
          className='block appearance-none w-full bg-white border border-gray-200 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow-sm leading-tight focus:outline-none focus:shadow-outline'
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
          class='form-textarea mt-1 block w-full rounded border border-gray-200 '
          rows='3'
          placeholder='Additional information?'
        ></textarea>
      </form>
    </div>
  );
}

export default EmployeeRequestForm;
