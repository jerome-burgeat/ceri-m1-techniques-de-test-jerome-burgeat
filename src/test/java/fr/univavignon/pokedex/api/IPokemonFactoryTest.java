package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonFactoryTest {

    Pokemon bulbizarre;
    IPokemonFactory iBulbizarreFactory;
    Pokemon aquali;
    IPokemonFactory iAqualieFactory;

    @BeforeEach
    void initPokemon() {
        bulbizarre = new Pokemon(0,"Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        iBulbizarreFactory = (index, cp, hp, dust, candy) -> bulbizarre;

        aquali = new Pokemon(133,"Aquali", 186, 168, 260, 2729,202,5000, 4, 100);
        iAqualieFactory = (index, cp, hp, dust, candy) -> aquali;
    }


    @Test
    void getCreateBulbizarre() throws PokedexException {
        assertEquals(bulbizarre, iBulbizarreFactory.createPokemon(0,613, 64, 4000, 4));
    }

    @Test
    void getCreateAquali() throws PokedexException {
        assertEquals(aquali, iAqualieFactory.createPokemon(133, 2729,202,5000, 4));
    }

}