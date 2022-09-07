angular.module('pokedexApp')
.controller('PokeDexController', PokeDexController);

PokeDexController.$inject = ['PokeApiFactory']

function PokeDexController(PokeApiFactory){
    var vm = this;
    vm.searchText = '';
    vm.pkmList = [];

    if(PokeApiFactory.pkmList.length){
       vm.pkmList = PokeApiFactory.pkmList;
    }else{
        PokeApiFactory.listAll()
            .then(pkmList => {
                vm.pkmList = pkmList;
            })
    }
}