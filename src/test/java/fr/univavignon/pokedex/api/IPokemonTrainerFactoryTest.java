package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonTrainerFactoryTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;
    IPokedexFactory iPokedexFactory;
    IPokedex iPokedex;
    IPokemonTrainerFactory iPokemonTrainerFactory;
    PokemonTrainer trainer;

    @BeforeEach
    void initPokemonTrainer() {
        iPokemonMetadataProvider = new PokemonMetadataProvider();
        iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
        iPokedexFactory = new PokedexFactory();
        iPokedex = new Pokedex(iPokemonMetadataProvider, iPokemonFactory);

        trainer = new PokemonTrainer("Sacha", Team.INSTINCT, iPokedex);

        iPokemonTrainerFactory = (name, team, pokedexFactory) -> trainer;
    }

    @Test
    void getTrainerInstinct() {
        assertEquals(trainer,iPokemonTrainerFactory.createTrainer("Sacha", Team.INSTINCT, iPokedexFactory));
    }
}