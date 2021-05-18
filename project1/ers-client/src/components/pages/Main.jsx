import React from 'react';
import Page from '../Page';
import Card from '../Card';

const Main = (props) => {
  return (
    <Page>
      <h1>{props.heading}</h1>
      {props.subheading}{' '}
      <div name='card-container' class=''>
        <Card />
        <Card />
        <Card />
      </div>
    </Page>
  );
};

export default Main;
