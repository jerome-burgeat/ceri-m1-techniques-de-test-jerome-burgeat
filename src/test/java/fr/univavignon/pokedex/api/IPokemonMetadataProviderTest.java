package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider iBulbizarreMetadataProvider;
    IPokemonMetadataProvider iAqualiMetadataProvider;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;

    @BeforeEach
    void initPokemon() {
        bulbizarre = new PokemonMetadata(0,"Bulbizarre", 126, 126, 90);
        iBulbizarreMetadataProvider = index -> bulbizarre;

        aquali = new PokemonMetadata(133,"Aquali", 186, 168, 260);
        iAqualiMetadataProvider = index -> aquali;
    }

    @Test
    void getBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre,iBulbizarreMetadataProvider.getPokemonMetadata(0));
    }

    @Test
    void getAqualiMetadata() throws PokedexException{
        assertEquals(aquali,iAqualiMetadataProvider.getPokemonMetadata(133));
    }

}