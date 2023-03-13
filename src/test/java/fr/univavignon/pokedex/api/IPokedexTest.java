package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokedexTest {

    Pokemon bulbizarre;
    IPokedex iPokedexBulbizarre;
    Pokemon aquali;
    IPokedex iPokedexAquali;

    @BeforeEach
    void initPokemon() {
        bulbizarre = new Pokemon(0,"Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        iPokedexBulbizarre = new IPokedex() {
            @Override
            public int size() {
                return 10;
            }

            @Override
            public int addPokemon(Pokemon pokemon) {
                return 11;
            }

            @Override
            public Pokemon getPokemon(int id) throws PokedexException {
                return bulbizarre;
            }

            @Override
            public List<Pokemon> getPokemons() {
                List<Pokemon> listPokemons = new ArrayList<>();
                listPokemons.add(bulbizarre);
                listPokemons.add(aquali);
                return listPokemons;
            }

            @Override
            public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
                List<Pokemon> listPokemons = new ArrayList<>();
                listPokemons.add(bulbizarre);
                listPokemons.add(aquali);
                return listPokemons;
            }

            @Override
            public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
                return bulbizarre;
            }

            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                return bulbizarre;
            }
        };

        aquali = new Pokemon(133,"Aquali", 186, 168, 260, 2729,202,5000, 4, 100);
        iPokedexAquali = new IPokedex() {
            @Override
            public int size() {
                return 2;
            }

            @Override
            public int addPokemon(Pokemon pokemon) {
                return 3;
            }

            @Override
            public Pokemon getPokemon(int id) throws PokedexException {
                return aquali;
            }

            @Override
            public List<Pokemon> getPokemons() {
                List<Pokemon> listPokemons = new ArrayList<>();
                listPokemons.add(bulbizarre);
                listPokemons.add(aquali);
                return listPokemons;
            }

            @Override
            public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
                List<Pokemon> listPokemons = new ArrayList<>();
                listPokemons.add(bulbizarre);
                listPokemons.add(aquali);
                return listPokemons;
            }

            @Override
            public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
                return aquali;
            }

            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                return aquali;
            }
        };
    }

    @Test
    void sizeBulbizarre() {
        assertEquals(10, iPokedexBulbizarre.size());
    }

    @Test
    void sizeAquali() {
        assertEquals(2, iPokedexAquali.size());
    }

    @Test
    void addBulbizarre() {
        assertEquals(11, iPokedexBulbizarre.addPokemon(bulbizarre));
    }

    @Test
    void addAquali() {
        assertEquals(3, iPokedexAquali.addPokemon(aquali));
    }

    @Test
    void getBulbizarre() throws PokedexException {
        assertEquals(bulbizarre, iPokedexBulbizarre.getPokemon(0));
    }

    @Test
    void getAquali() throws PokedexException {
        assertEquals(aquali, iPokedexAquali.getPokemon(133));
    }

    @Test
    void getPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        assertEquals(pokemons, iPokedexBulbizarre.getPokemons());
        assertEquals(pokemons, iPokedexAquali.getPokemons());
    }

    @Test
    void getPokemonComparator() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        Comparator<Pokemon> test = (o1, o2) -> 0;

        assertEquals(pokemons, iPokedexBulbizarre.getPokemons(test));
        assertEquals(pokemons, iPokedexAquali.getPokemons(test));
    }
}