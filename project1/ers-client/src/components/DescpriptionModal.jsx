import React from 'react';
import Close from '../svg-icons/close';

const DescpriptionModal = ({ text, closeModal }) => {
  return (
    <div class=' absolute absolute-center-custom  bg-gray-50 pt-10 pb-3 flex items-start text-gray-800 my-4 shadow fixed-width-md'>
      <div class=' px-3'>
        <h3 class='font-semibold absolute top-2 left-2 tracking-wider action-text'>
          Description
        </h3>
        <p class='py-2'>{text}</p>
        <div class='space-x-6 text-right'>
          <button
            onClick={() => closeModal()}
            class='font-semibold tracking-wider hover:underline focus:outline-none absolute top-2 right-2'
          >
            <Close />
          </button>
        </div>
      </div>
    </div>
  );
};

export default DescpriptionModal;

//    <div className='absolute shadow bg-white w-44 px-5 pb-5 pt-8 text-sm top-50 left-50'>
//       <h3 className='absolute top-2 uppercase text-bold'>Description</h3>
//       <button onClick={() => closeModal()} className='absolute top-2 right-2'>
//         <Close />
//       </button>
//       <p>{text}</p>
//     </div>
