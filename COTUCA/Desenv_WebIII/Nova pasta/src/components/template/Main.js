import './Main.css'; 
import React from 'react'; 
import Header from './Header';

export default function Main(props) { 

return (
  <React.Fragment>
    <Header />
    <main className="content">
      <Header {...props} />
      <main>
        <div>{props.children}</div>
      </main>
    </main>
  </React.Fragment>
);} 