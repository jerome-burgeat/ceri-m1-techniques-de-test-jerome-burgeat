package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;

    @BeforeEach
    void initPokemon() {
        bulbizarre = new PokemonMetadata(0,"Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133,"Aquali", 186, 168, 260);
    }

    @Test
    void getPokemonMetadata() throws PokedexException{
        iPokemonMetadataProvider = index -> bulbizarre;
        assertEquals(bulbizarre,iPokemonMetadataProvider.getPokemonMetadata(0));
        iPokemonMetadataProvider = index -> aquali;
        assertEquals(aquali,iPokemonMetadataProvider.getPokemonMetadata(133));
    }

    @Test
    void getIndexBulbizarre() throws PokedexException {
        iPokemonMetadataProvider = index -> bulbizarre;
        assertEquals(0,iPokemonMetadataProvider.getPokemonMetadata(0).getIndex());
    }

    @Test
    void getIndexAquali() throws PokedexException {
        iPokemonMetadataProvider = index -> aquali;
        assertEquals(133,iPokemonMetadataProvider.getPokemonMetadata(133).getIndex());
    }
}