import axios from 'axios';
import React, { useState, useEffect } from 'react';

const Employees = () => {
  useEffect(() => {
    callLoadEmps();
    return () => {};
  }, []);

  const [emps, setEmps] = useState([]);

  async function callLoadEmps() {
    const result = await axios.get('employees');
    console.log(result);
  }

  return <div>Employee</div>;
};

export default Employees;
