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
    void getTrainer() {
        assertEquals(PokemonTrainer.class,iPokemonTrainerFactory.createTrainer("Sacha", Team.INSTINCT, iPokedexFactory).getClass());
    }

    @Test
    void getTrainerName() {
        assertEquals(trainer.getName(),iPokemonTrainerFactory.createTrainer("Sacha", Team.INSTINCT, iPokedexFactory).getName());
    }

    @Test
    void getTrainerTeam() {
        assertEquals(trainer.getTeam(),iPokemonTrainerFactory.createTrainer("Sacha", Team.INSTINCT, iPokedexFactory).getTeam());
    }

    @Test
    void getPokedexTeam() {
        assertEquals(trainer.getPokedex(),iPokemonTrainerFactory.createTrainer("Sacha", Team.INSTINCT, iPokedexFactory).getPokedex());
    }
}