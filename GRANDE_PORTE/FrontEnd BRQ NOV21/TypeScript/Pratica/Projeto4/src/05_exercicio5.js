"use strict";
let cNome;
let cEmail;
let btnSubmit;
cNome = document.querySelector("body > div > div.main-agileinfo > div > form > input:nth-child(1)");
cEmail = document.querySelector("body > div > div.main-agileinfo > div > form > input.text.email");
btnSubmit = document.querySelector("body > div > div.main-agileinfo > div > form > input[type=submit]:nth-child(4)");
btnSubmit.addEventListener("click", function (event) {
    console.log(`Nome: ${cNome.value} - Email: ${cEmail.value}`);
});
