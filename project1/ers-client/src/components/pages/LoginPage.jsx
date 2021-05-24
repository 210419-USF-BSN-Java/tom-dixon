import React from 'react';
import LoginForm from '../LoginForm';

const LoginPage = ({ login, user }) => {
  return (
    <div>
      <div className='flex flex-col tecxt-gray-800 justify-center  pt-36 pb-10 '>
        <h2 className='mx-auto text-6xl font-mono tracking-widest text-gray-700	title-shadow'>
          ERS
        </h2>
        <h1 className='mx-auto uppercase'>Employee Reimbursement System</h1>
      </div>

      <LoginForm login={login} user={user} />
    </div>
  );
};

export default LoginPage;
