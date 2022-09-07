var isAnagram = require("../anagram");


class Calculator {
    sum(n1, n2) {
        return n1 + n2;
    }
}

class Person {
    randomCalc(calculator) {
        var n1 = parseInt(Math.random() * 10),
            n2 = parseInt(Math.random() * 10);

        return `${n1} + ${n2} = ${calculator.sum(n1, n2)}`;
    }
}

xdescribe("Person", function() {
    it("uses the Calculator to sum", function() {
        var calculator = new Calculator();
        var person = new Person();

        spyOn(calculator, "sum");
        person.randomCalc(calculator);
        expect(calculator.sum).toHaveBeenCalled();
    });
});


xdescribe("Person", function() {
    it("uses the Calculator to sum", function() {
        var calculator = new Calculator();
        var person = new Person();

        spyOn(person, "randomCalc");
        person.randomCalc(calculator);
        expect(person.randomCalc).toHaveBeenCalledWith(calculator);
    });
});

xdescribe("Person", function() {
    it("uses the Calculator to sum", function() {
        var calculator = new Calculator();
        var person = new Person();

        spyOn(person, "randomCalc").and.callThrough();
        var result = person.randomCalc(calculator);
        expect(person.randomCalc).toHaveBeenCalledWith(calculator);
    });
});

xdescribe("Person", function() {
    it("uses the Calculator to sum", function() {
        var calculator = new Calculator();
        var person = new Person();

        spyOn(person, "randomCalc").and.returnValue(53184);
        var result = person.randomCalc(calculator);
        console.log(result);

        expect(person.randomCalc).toHaveBeenCalledWith(calculator);
    });

    describe("Person", function() {
        it("uses the Calculator to sum", function() {
            var calculator = new Calculator();
            var person = new Person();
            var fakeFunction = function() {
                return "my fake function!";
            };

            spyOn(person, "randomCalc").and.callFake(fakeFunction);

            var result = person.randomCalc(calculator);

            console.log(result);

            expect(person.randomCalc).toHaveBeenCalledWith(calculator);
        })
    })
})

describe("Anagram", function() {
    describe('Letras', function() {
        it('is true when "abc" and "cba"', function() {
            expect(isAnagram("abc", "cba")).toEqual(true);
        })
        it('is true when "Amor" and "Roma"', function() {
            expect(isAnagram("Amor", "Roma")).toEqual(true);
        })
        it("is true when two empty strings", function() {
            expect(isAnagram("", "")).toEqual(true);
        })
    })
    describe('Numeros', function() {
        it('is true when "132" and 312', function() {
            expect(isAnagram("132", 312)).toEqual(true);
        })
        it('is true when "0.12" and "102"', function() {
            expect(isAnagram("0.12", "102")).toEqual(true);
        })
        it('is true when 0.12 and "102"', function() {
            expect(isAnagram(0.12, "102")).toEqual(true);
        })
        it("is false when 012 and 102", function() {
            expect(isAnagram(012, 102)).toEqual(false);
        })
    })



});