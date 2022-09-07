angular.module('pokedexApp')
.component('pokeListItemComponent', {
    templateUrl: './js/components/PokeListItem/PokeListItemComponent.html',
    controller: PokeListItemController,
    bindings: {
        pkm: '='
    }
})

function PokeListItemController(){

}