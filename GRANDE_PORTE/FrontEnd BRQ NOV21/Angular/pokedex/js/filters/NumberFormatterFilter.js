angular.module('pokedexApp')
.filter('NumberFormatter', function(){
    return function(input){
        var output = ('000' + parseInt(input)).slice(-3);
        return output;
    }
})