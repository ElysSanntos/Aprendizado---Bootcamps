"use strict";
const form = document.querySelector(`.form`);
const username = document.querySelector(`.username`);
const email = document.querySelector(`.email`);
const password = document.querySelector(`.password`);
const password2 = document.querySelector(`.password2`);
const btton = document.querySelector(`button`);
//spread operator ...inputs
function verificaCamposVazios(...inputs) {
    inputs.forEach(function (campo) {
        if (!campo.value) {
            console.log(`${campo.className} está vazio`);
            apresentaMSGErro(campo, "O campo não pode ser vazio..");
        }
    });
}
function excluiMSGErro(form) {
    form.querySelectorAll(".show-error-message").forEach(function (item) {
        item.classList.remove("show-error-message");
    });
}
form.addEventListener("submit", function (event) {
    event.preventDefault();
    excluiMSGErro(form);
    verificaCamposVazios(username, email, password, password2);
});
function apresentaMSGErro(input, msg) {
    const formFild = input.parentElement;
    const errorMessage = formFild.querySelector(".error-message");
    errorMessage.innerText = msg;
    formFild.classList.add("show-error-message");
}
form.querySelectorAll('input').forEach(elemento => {
    elemento.addEventListener('blur', (event) => {
        event.preventDefault();
        if (!elemento.value) {
            apresentaMSGErro(elemento, 'O campo não pode ser vazio!');
        }
        else {
            let formField = elemento.parentElement;
            formField.classList.remove('show-error-message');
        }
    });
});
function verificaSenhaCurta(password) {
    if (password.value.length < 8) {
        console.log('Senha muito pequena');
        apresentaMSGErro(password, "A senha é muito curta!");
    }
}
function verificaSenhaDiferentes(password, password2) {
    if (password2.value != password.value) {
        console.log('Senhas Diferentes');
        apresentaMSGErro(password2, "As Senhas diferem!");
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
