const form = document.querySelector(`.form`) as HTMLFormElement;
const username = document.querySelector(`.username`) as HTMLInputElement;
const email = document.querySelector(`.email`) as HTMLInputElement;
const password = document.querySelector(`.password`) as HTMLInputElement;
const password2 = document.querySelector(`.password2`) as HTMLInputElement;
const btton = document.querySelector(`button`)as HTMLButtonElement;

//spread operator ...inputs
function verificaCamposVazios(...inputs: HTMLInputElement[]): void 
{
  inputs.forEach(function (campo) 
  {
    if (!campo.value) 
    {
      console.log(`${campo.className} está vazio`);
      apresentaMSGErro(campo, "O campo não pode ser vazio..");
    }
  });
}

function excluiMSGErro(form: HTMLFormElement): void 
{
  form.querySelectorAll(".show-error-message").forEach(function (item) 
  {
    item.classList.remove("show-error-message");
  });
}

form.addEventListener("submit", function (event: Event) 
{
  event.preventDefault();
  excluiMSGErro(form);
  verificaCamposVazios(username, email, password, password2);
});

function apresentaMSGErro(input: HTMLInputElement, msg: string) 
{
  const formFild = input.parentElement as HTMLDivElement;
  const errorMessage = formFild.querySelector(".error-message" ) as HTMLSpanElement;
  errorMessage.innerText = msg;
  formFild.classList.add("show-error-message");
}

form.querySelectorAll('input').forEach(elemento =>
{
    elemento.addEventListener('blur',(event)=>
    {event.preventDefault();
        if(!elemento.value)
        {
            apresentaMSGErro(elemento,'O campo não pode ser vazio!');
        }
        else
        {
            let formField = elemento.parentElement as HTMLDivElement;
            formField.classList.remove('show-error-message');
        }
})
})

function verificaSenhaCurta(password: HTMLInputElement): void {
    if(password.value.length < 8){
        console.log('Senha muito pequena');
        apresentaMSGErro(password,"A senha é muito curta!");
    }
}

function verificaSenhaDiferentes(password: HTMLInputElement,password2:HTMLInputElement):void{
    if(password2.value != password.value){
        console.log('Senhas Diferentes');
        apresentaMSGErro(password2,"As Senhas diferem!");
    }
}


// var senha = document.getElementById("password");
// var confirmaSenha = document.getElementById("password2");

// function validaSenha()
// {
//   if (password.value != password2.value) {
//     password2.setCustomValidity("Senhas diferentes!");
//   } else {
//     password2.setCustomValidity("");
//   }
// }

// password.onchange = validaSenha;
// password2.onkeyup = validaSenha;


