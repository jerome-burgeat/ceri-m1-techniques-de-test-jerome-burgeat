package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokedexFactoryTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;
    IPokedex iPokedex;
    IPokedexFactory iPokedexFactory;

    @BeforeEach
    void initPokemon() {

        iPokemonMetadataProvider = index -> null;
        iPokemonFactory = (index, cp, hp, dust, candy) -> null;

        iPokedex = new IPokedex() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public int addPokemon(Pokemon pokemon) {
                return 0;
            }

            @Override
            public Pokemon getPokemon(int id) throws PokedexException {
                return null;
            }

            @Override
            public List<Pokemon> getPokemons() {
                return null;
            }

            @Override
            public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
                return null;
            }

            @Override
            public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
                return null;
            }

            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                return null;
            }
        };

        iPokedexFactory = (metadataProvider, pokemonFactory) -> iPokedex;
    }

    @Test
    void createPokedex() {
        assertEquals(iPokedex, iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory));
    }

}