import React, { useState, useEffect } from 'react';
import DescpriptionModal from './DescpriptionModal';
import Record from './Record';

const PendingRequestTable = ({ getReqs, getAllReqs, user }) => {
  const [reqs, setReqs] = useState([]);
  const [modalText, setModalText] = useState(null);

  useEffect(() => {
    loadReqs();
    return () => {
      clearReqs();
    };
  }, []);

  function closeModal() {
    setModalText(null);
  }

  function makeDescriptionModal(text) {
    setModalText(text);
  }

  async function loadReqs() {
    let reqs;
    user.roleId == '1' ? (reqs = await getAllReqs()) : (reqs = await getReqs());
    setReqs(reqs);
  }

  function clearReqs() {
    setReqs([]);
  }

  return (
    <div class='container mx-auto px-4 sm:px-8 max-w-3xl'>
      <div class='py-8'>
        <div class='flex flex-row mb-1 sm:mb-0 justify-between w-full'>
          <h2 class='text-xl leading-tight'>Pending Requests</h2>
          <div class='text-end'>
            <form class='flex w-full max-w-sm space-x-3'>
              <div class=' relative '>
                <input
                  type='text'
                  id='"form-subscribe-Filter'
                  class=' block appearance-none w-full bg-white border border-gray-200 hover:border-gray-500 px-4 py-2 pr-8 shadow-sm text-sm leading-tight focus:outline-none focus:shadow-outline'
                  placeholder='search by description'
                />
              </div>
            </form>
          </div>
        </div>
        <div class='-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto'>
          <div class='inline-block min-w-full shadow overflow-hidden'>
            <table
              class='min-w-full leading-normal'
              style={{ overflowY: 'auto' }}
            >
              <thead>
                <tr>
                  <th
                    scope='col'
                    class='px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-center text-sm uppercase font-normal'
                  >
                    ID
                  </th>
                  <th
                    scope='col'
                    class='px-5 py-3 bg-white  border-b border-gray-200 text-gray-800 text-sm uppercase font-normal'
                  >
                    amount
                  </th>
                  <th
                    scope='col'
                    class='px-5 py-3 bg-white  border-b border-gray-200 text-gray-800 text-sm uppercase font-normal'
                  >
                    type
                  </th>
                  <th
                    scope='col'
                    class='px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal'
                  >
                    submitted
                  </th>
                  <th
                    scope='col'
                    class='px-5 py-3 bg-white  border-b border-gray-200 text-gray-800   text-sm uppercase font-normal'
                  >
                    description
                  </th>
                  <th
                    scope='col'
                    class='px-5 py-3 bg-white  border-b border-gray-200 text-gray-800   text-sm uppercase font-normal'
                  >
                    receipt
                  </th>
                </tr>
              </thead>
              <tbody className='relative'>
                {modalText && (
                  <DescpriptionModal closeModal={closeModal} text={modalText} />
                )}
                {reqs &&
                  reqs.map(({ ...props }) => (
                    <Record
                      {...props}
                      makeDescriptionModal={makeDescriptionModal}
                    />
                  ))}
              </tbody>
            </table>
            <div class='px-5 bg-white py-5 flex flex-col xs:flex-row items-center xs:justify-between'>
              <div class='flex items-center'>
                <button
                  type='button'
                  class='w-full p-4 border text-base rounded-l-xl text-gray-600 bg-white hover:bg-gray-100'
                >
                  <svg
                    width='9'
                    fill='currentColor'
                    height='8'
                    class=''
                    viewBox='0 0 1792 1792'
                    xmlns='http://www.w3.org/2000/svg'
                  >
                    <path d='M1427 301l-531 531 531 531q19 19 19 45t-19 45l-166 166q-19 19-45 19t-45-19l-742-742q-19-19-19-45t19-45l742-742q19-19 45-19t45 19l166 166q19 19 19 45t-19 45z'></path>
                  </svg>
                </button>
                <button
                  type='button'
                  class='w-full px-4 py-2 border-t border-b text-base text-indigo-500 bg-white hover:bg-gray-100 '
                >
                  1
                </button>
                <button
                  type='button'
                  class='w-full px-4 py-2 border text-base text-gray-600 bg-white hover:bg-gray-100'
                >
                  2
                </button>
                <button
                  type='button'
                  class='w-full px-4 py-2 border-t border-b text-base text-gray-600 bg-white hover:bg-gray-100'
                >
                  3
                </button>
                <button
                  type='button'
                  class='w-full px-4 py-2 border text-base text-gray-600 bg-white hover:bg-gray-100'
                >
                  4
                </button>
                <button
                  type='button'
                  class='w-full p-4 border-t border-b border-r text-base  rounded-r-xl text-gray-600 bg-white hover:bg-gray-100'
                >
                  <svg
                    width='9'
                    fill='currentColor'
                    height='8'
                    class=''
                    viewBox='0 0 1792 1792'
                    xmlns='http://www.w3.org/2000/svg'
                  >
                    <path d='M1363 877l-742 742q-19 19-45 19t-45-19l-166-166q-19-19-19-45t19-45l531-531-531-531q-19-19-19-45t19-45l166-166q19-19 45-19t45 19l742 742q19 19 19 45t-19 45z'></path>
                  </svg>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PendingRequestTable;
