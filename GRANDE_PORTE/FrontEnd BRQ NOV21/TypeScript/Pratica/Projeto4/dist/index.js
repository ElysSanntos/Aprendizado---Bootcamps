"use strict";
let campoNome;
let campoEmail;
let botaoSubmit;
campoNome = document.querySelector("body > div > div.main-agileinfo > div > form > input:nth-child(1)");
campoEmail = document.querySelector("body > div > div.main-agileinfo > div > form > input.text.email");
botaoSubmit = document.querySelector("body > div > div.main-agileinfo > div > form > input[type=submit]:nth-child(4)");
botaoSubmit.addEventListener("click", function (event) {
    alert(`Nome: ${campoNome.value} - Email: ${campoEmail.value}`);
});
