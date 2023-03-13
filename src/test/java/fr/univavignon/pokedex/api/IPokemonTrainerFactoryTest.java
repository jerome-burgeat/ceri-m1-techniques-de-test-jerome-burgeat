package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory iPokemonTrainerFactory;

    IPokedex iPokedex;

    IPokedexFactory iPokedexFactory;

    PokemonTrainer trainer;

    @BeforeEach
    void initPokemonTrainer() {
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

        trainer = new PokemonTrainer("Sacha", Team.INSTINCT, iPokedex);

        iPokemonTrainerFactory = (name, team, pokedexFactory) -> trainer;
    }

    @Test
    void getTrainerInstinct() throws PokedexException{
        assertEquals(trainer,iPokemonTrainerFactory.createTrainer("Sacha", Team.INSTINCT, iPokedexFactory));
    }
}