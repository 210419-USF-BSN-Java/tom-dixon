import React from 'react';

const AppNav = ({ user, logout }) => {
  return (
    <header className='border-b md:flex md:items-center md:justify-between p-4 pb-0 shadow-lg md:pb-4'>
      <div className='flex items-center justify-between mb-4 md:mb-0'>
        <h1 className='leading-none text-2xl text-grey-darkest'>
          <button
            className='no-underline text-grey-darkest hover:text-black'
            href='#'
          >
            ERS
          </button>
        </h1>

        <button className='text-black hover:text-orange md:hidden' href='#'>
          <i className='fa fa-2x fa-bars'></i>
        </button>
      </div>

      <nav>
        <ul className='list-reset md:flex md:items-center'>
          <li className='md:ml-4'>
            <button
              className='border-t block no-underline hover:underline py-2 text-grey-darkest hover:text-black md:border-none md:p-0'
              href='#'
            >
              About
            </button>
          </li>
          <li className='md:ml-4'>
            <button
              className='border-t block no-underline hover:underline py-2 text-grey-darkest hover:text-black md:border-none md:p-0'
              href='#'
            >
              Contact
            </button>
          </li>
          <li className='md:ml-4'>
            <button
              className='border-t block no-underline hover:underline py-2 text-grey-darkest hover:text-black md:border-none md:p-0'
              onClick={logout}
            >
              Logout
            </button>
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default AppNav;
