import React from 'react';
import LoginForm from '../LoginForm';

const LoginPage = ({ login, user }) => {
  return (
    <div>
      <LoginForm login={login} user={user} />
    </div>
  );
};

export default LoginPage;
