import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import Exemplo01 from './components/Exemplo01';
import ExibeNotas from './components/ExibeNotas';
import NumeroAleatorio from './components/NumeroAleatorio';
import ObtemNotas from './components/ObtemNotas';
import VerificaIdade from './components/VerificaIdade';

const root = ReactDOM.createRoot (document.getElementById('root'));
root.render(<App/>, 
  <React.StrictMode>
<Exemplo01 />
<ExibeNotas />
<NumeroAleatorio/>
<ObtemNotas/>
<VerificaIdade/>

  </React.StrictMode>
)


