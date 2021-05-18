import React, { useState } from 'react';
import axios from 'axios';
import qs from 'qs';

const LoginForm = () => {
  const initialValues = { username: '', password: '' };

  const [form, setForm] = useState(initialValues);

  function onChange(e) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  async function handleFormSubmit(e) {
    e.preventDefault();
    const { username, password } = form;

    const formData = qs.stringify({
      username: username,
      password: password,
    });

    const headers = {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
    };

    const result = await axios.post('login', formData, headers);
    console.log(result);
  }
  return (
    <div className='h-screen font-sans login bg-cover'>
      <div className='container mx-auto h-full flex flex-1 justify-center items-center'>
        <div className='leading-loose'>
          <form
            onSubmit={handleFormSubmit}
            className='max-w-sm m-4 p-10 bg-white bg-opacity-25 rounded shadow-xl'
          >
            <p className='text-gray-600 font-medium text-center text-lg font-bold'>
              LOGIN
            </p>
            <div className=''>
              <label className='block text-sm text-white' for='email'>
                E-mail
              </label>
              <input
                onChange={onChange}
                name='username'
                className='w-full px-5 py-1 text-gray-700 bg-gray-300 rounded focus:outline-none focus:bg-white'
                value={form.username}
                placeholder='username'
                aria-label='username'
                required
              />
            </div>
            <div className='mt-2'>
              <label className='block  text-sm text-white'>Senha</label>
              <input
                onChange={onChange}
                className='w-full px-5 py-1 text-gray-700 bg-gray-300 rounded focus:outline-none focus:bg-white'
                name='password'
                id='password'
                placeholder='password'
                arial-label='password'
                required
              />
            </div>

            <div className='mt-4 items-center flex justify-center'>
              <button
                type='submit'
                className='px-4 py-1 text-white font-light tracking-wider bg-gray-900 hover:bg-gray-800 rounded'
              >
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default LoginForm;
