import React from 'react';
import ReadIcon from '../svg-icons/readDesc';
import PhotoIcon from '../svg-icons/photo';

const Record = ({
  id,
  amount,
  dateSubmitted,
  description,
  makeDescriptionModal,
}) => {
  function formatDate(date) {
    const formattedDate = new Date(date);
    return formattedDate.toDateString();
  }

  return (
    <tr className='w-100'>
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-sm'>
        <div class=''>
          <div class='flex-shrink-0'></div>
          <div class='ml-3'>
            <p class='text-gray-900 whitespace-no-wrap'>{id}</p>
          </div>
        </div>
      </td>
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-sm'>
        <p class='text-gray-900 whitespace-no-wrap text-right pr-10'>
          ${(Math.round(amount * 100) / 100).toFixed(2)}
        </p>
      </td>
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-sm'>
        <p class='text-gray-900 whitespace-no-wrap'>
          {formatDate(dateSubmitted)}
        </p>
      </td>
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-center text-sm'>
        <button
          onClick={() => makeDescriptionModal(description)}
          href='#'
          class='text-indigo-600 hover:text-indigo-900'
        >
          <ReadIcon />
        </button>
      </td>
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-center text-sm'>
        <button href='#' class='text-indigo-600 hover:text-indigo-900'>
          <PhotoIcon />
        </button>
      </td>
    </tr>
  );
};

export default Record;
