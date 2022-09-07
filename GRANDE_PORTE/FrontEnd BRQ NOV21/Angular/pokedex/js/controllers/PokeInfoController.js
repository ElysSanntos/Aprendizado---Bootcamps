angular.module('pokedexApp')
.controller('PokeInfoController', PokeInfoController);

PokeInfoController.$inject = ['$routeParams', 'PokeApiFactory'];

function PokeInfoController($routeParams, PokeApiFactory){
    var vm = this;
    vm.pkm = {};

    var getPkm = function(){
        if(PokeApiFactory.pkmList.length){
            setPkm(PokeApiFactory.pkmList);
        }else{
            PokeApiFactory.listAll().then(setPkm);
        }
    }

    var setPkm = function(pkmList){
        var pkm = pkmList.find(pkm => pkm.number == $routeParams.pokeNumber);
        if(pkm){
            PokeApiFactory.getPkm(pkm)
                .then(info => {
                    pkm.info = info;
                    vm.pkm = pkm;
                })
        }
    }

    getPkm();

}