import { addition } from "./firstFunction"

describe("Test Addition", () => {

    it('Testing addition function', ()=> {
        expect( addition(10,30) ).toBe(40);
    })
})