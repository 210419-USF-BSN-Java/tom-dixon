import React from 'react';

const Page = (props) => {
  // the basic container for every page.
  return <div className='page p-8'>{props.children}</div>;
};

export default Page;
