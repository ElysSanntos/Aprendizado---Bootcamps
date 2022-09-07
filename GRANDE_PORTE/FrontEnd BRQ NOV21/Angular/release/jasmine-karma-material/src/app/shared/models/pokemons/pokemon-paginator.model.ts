import { PokemonModel } from "./pokemon.model";

export class PokemonPaginatorModel{

    count : number;
    next: string;
    previous : string | null;
    results: Array<PokemonModel>;
}