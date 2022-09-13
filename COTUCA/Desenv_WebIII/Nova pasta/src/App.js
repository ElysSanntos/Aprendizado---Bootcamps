
import './App.css';

import Logo from './components/template/Logo';
import Main from './components/template/Main';
import Menu from './components/template/Menu';
import Footer from './components/template/Footer';
import CrudAluno from './components/template/CrudAluno';


function App() {
  return (
    <div className="App">
      <Logo />
      <Main title="Bem Vindo!">
        <div>Cadastro de alunos, cursos e carômetro</div>{" "}
      </Main>
      <Footer />
      <CrudAluno />
      <Menu />
    </div>
  );
}

export default App;
