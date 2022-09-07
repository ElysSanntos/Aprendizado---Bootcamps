interface aluno {
  nome: string;
  email: string;
  idade: number;
}

let nomeFormulario: HTMLInputElement;
let emailFormulario: HTMLInputElement;
let idadeFormulario: HTMLInputElement;
let botaoFormulario: HTMLInputElement;
let mensagemFormulario: HTMLElement;

nomeFormulario = document.querySelector(
  "body > div > div.main-agileinfo > div > form > input:nth-child(1)"
) as HTMLInputElement;

emailFormulario = document.querySelector(
  "body > div > div.main-agileinfo > div > form > input.text.email"
) as HTMLInputElement;

idadeFormulario = document.querySelector(
  "body > div > div.main-agileinfo > div > form > input:nth-child(3)"
) as HTMLInputElement;

botaoFormulario = document.querySelector(
  "body > div > div.main-agileinfo > div > form > input[type=submit]:nth-child(4)"
) as HTMLInputElement;

mensagemFormulario = document.getElementById("salvo") as HTMLElement;

botaoFormulario.addEventListener("click", function (event) {
  event.preventDefault();

  let alunoFormulario: aluno = {
    nome: nomeFormulario.value,
    email: emailFormulario.value,
    idade: parseInt(idadeFormulario.value),
  };

  nomeFormulario.value = "";
  emailFormulario.value = "";
  idadeFormulario.value = "";

  mensagemFormulario.innerText = "Usuário salvo com sucesso!";

  setTimeout(function () {
    mensagemFormulario.innerText = "";
  }, 3000);

  console.log(alunoFormulario);
});
