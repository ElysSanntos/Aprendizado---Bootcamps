var hello = require("../hello");
describe("Hello", function() {
    it('has to print "Hello World!"', function() {
        var text = hello();
        expect(text).toEqual("Hello World!");
    });
});