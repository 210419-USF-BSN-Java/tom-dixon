import React from 'react';
import ReadIcon from '../svg-icons/readDesc';
import PhotoIcon from '../svg-icons/photo';
import CheckIcon from '../svg-icons/check';
import RejectIcon from '../svg-icons/reject';
import formatDate from '../utils/formatDate';

const Record = ({
  id,
  amount,
  type,
  dateSubmitted,
  description,
  authorId,
  authorFirstName,
  authorLastName,
  makeDescriptionModal,
  isManager,
  approveReq,
  rejectReq,
}) => {
  function handleApprove() {
    approveReq(id);
  }

  function handleReject() {
    rejectReq(id);
  }

  return (
    <tr className='w-100'>
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-sm'>
        <div class='flex-shrink-0'></div>
        <div class='ml-1'>
          <p class='text-gray-900 whitespace-no-wrap'>{id}</p>
        </div>
      </td>
      {isManager && (
        <td class='px-5 py-5 border-b border-gray-200 bg-white text-sm'>
          <p class='text-gray-900 whitespace-no-wrap text-left pr-10'>
            {authorFirstName}
          </p>
          <p class='text-gray-900 whitespace-no-wrap text-left pr-10'>
            {authorLastName}
          </p>
        </td>
      )}
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-sm'>
        <p class='text-gray-900 whitespace-no-wrap text-left pr-10'>
          ${(Math.round(amount * 100) / 100).toFixed(2)}
        </p>
      </td>
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-sm'>
        <p class='text-gray-900 whitespace-no-wrap pr-10'>{type}</p>
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
          {(description && <ReadIcon />) || '--'}
        </button>
      </td>
      <td class='px-5 py-5 border-b border-gray-200 bg-white text-center text-sm'>
        <button href='#' class='text-indigo-600 hover:text-indigo-900'>
          <PhotoIcon />
        </button>
      </td>
      {isManager && (
        <td class='px-5 py-5 border-b border-gray-200 bg-white text-center text-sm'>
          <div>
            <button
              onClick={() => handleApprove()}
              class='text-indigo-600 hover:text-indigo-900'
            >
              <CheckIcon />
            </button>

            <button
              onClick={() => handleReject()}
              class='text-indigo-600 hover:text-indigo-900'
            >
              <RejectIcon />
            </button>
          </div>
        </td>
      )}
    </tr>
  );
};

export default Record;
