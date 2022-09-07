 var a = { nome: "Jasmine" };
 var b = { nome: "Jasmine" };

 var myFunction = function() {
     throw new Error();
 }



 var matchers = require("../matchers");
 describe("Matchers", function() {

     //  var myMatchers = {
     //      toBe2: function(util, customEqualityTesters) {
     //          return {
     //              compare: function(actual, expected) {
     //                  var result = {};

     //                  result.pass = actual === 2;

     //                  if (!result.pass) {
     //                      result.message = "Expected " + actual + " to be exactly 2";
     //                  }

     //                  return result;
     //              }
     //          }
     //      }
     //  }

     // * Registra o Matcher criado * / /
     //  beforeEach(function() {
     //      jasmine.addNatchers(myMatchers);

     //  })
     //  it("is 2", function() {
     //      expect(3).toBe2();
     //      //  })

     it("Espera que a seja toEquals b", function() {
         expect(a).toEqual(b);
     });

     xit("Espera que a e b sejam o mesmo objeto", function() {
         expect(a).toBe(b);
     })

     it("Espera que a e a sejam o mesmo objeto", function() {
         expect(a).toBe(a);
     })

     it("Espera que o valor seja verdadeiro", function() {
         expect(true).toBeTruthy(); //Pode passar no lugar do true a string que se espera como verdadeira, tem a mesma importancia do == do js
     })
     it("Espera que o valor seja falso", function() {
             expect(false).toBeFalsy(); //pode se passar o valor 0 no lugar de false
         })
         // it("Espera que o valor b esteja contido em a", function() {
         //     expect(a).toContain(as); //pode se passar o valor 0 no lugar de false
         // })
         // it("Espera que o valor esteja indefinido", function() {
         //     expect(a.name).toBeUndefined();
         // })
     it("Espera que o valor esteja definido", function() {
             expect(a).toBeDefined();
         })
         // it("Espera que um valor null seja passado", function() {
         //     expect(a).toBeNull();
         // })
     it("Indica que o valor não é um numero", function() {
         expect(0 / 0).toBeNaN();
     })
     it("Indica que o valor não é um numero", function() {
         expect(10).not.toBeNaN();
     })
     it("Verifica se o valor é maior do que o valor informado", function() {
         expect(10).toBeGreaterThan(1);
     })
     it("Verifica se o valor é menor do que o valor informado", function() {
         expect('a').toBeLessThan('z');
     })
     it("Verifica se o valor é proximo do outro", function() {
         expect(20.3).toBeCloseTo(20.32, 1);
     })
     it("Verifica uma expressão regular", function() {
         expect('Jasmine').toMatch(/Jasmine/);
     })
     it("Espera que a função retorne um erro", function() {
         expect(myFunction).toThrow();
     })


 })