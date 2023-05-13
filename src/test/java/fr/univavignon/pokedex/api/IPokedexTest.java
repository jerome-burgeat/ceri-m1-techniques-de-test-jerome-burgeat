package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokedexTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;
    List<Pokemon> pokemons;

    IPokedex iPokedex;
    Pokemon bulbizarre;
    Pokemon aquali;

    @BeforeEach
    void initPokemon() {
        iPokemonMetadataProvider = new PokemonMetadataProvider();
        iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
        iPokedex = new Pokedex(iPokemonMetadataProvider, iPokemonFactory);

        bulbizarre = new Pokemon(0,"Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133,"Aquali", 186, 168, 260, 2729,202,5000, 4, 100);

        pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        iPokedex.addPokemon(bulbizarre);
        iPokedex.addPokemon(aquali);
    }

    @Test
    void size() {
        assertEquals(pokemons.size(), iPokedex.getPokemons().size());
    }

    @Test
    void getBulbizarreMetadata() throws PokedexException {
        assertEquals(bulbizarre.getPokemonMetadata(bulbizarre.getIndex()),iPokedex.getPokemon(bulbizarre.getIndex()).getPokemonMetadata(bulbizarre.getIndex()));
    }

    /*@Test
    void getAqualiMetadata() throws PokedexException {
        assertEquals(aquali.getPokemonMetadata(aquali.getIndex()),iPokedex.getPokemon(aquali.getIndex()).getPokemonMetadata(aquali.getIndex()));
    }*/

    @Test
    void getIndexBulbizarre() throws PokedexException {
        assertEquals(bulbizarre.getIndex(),iPokedex.getPokemon(bulbizarre.getIndex()).getIndex());
    }

    /*@Test
    void getIndexAquali() throws PokedexException {
        assertEquals(aquali.getIndex(),iPokedex.getPokemon(aquali.getIndex()).getIndex());
    }*/

    @Test
    void getNameBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getName(),iPokedex.getPokemon(bulbizarre.getIndex()).getName());
    }

    /*@Test
    void getNameAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getName(),iPokedex.getPokemon(aquali.getIndex()).getName());
    }*/

    @Test
    void getAttackBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getAttack(),iPokedex.getPokemon(bulbizarre.getIndex()).getAttack());
    }

    /*@Test
    void getAttackAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getAttack(),iPokedex.getPokemon(aquali.getIndex()).getAttack());
    }*/

    @Test
    void getDefenseBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getDefense(),iPokedex.getPokemon(bulbizarre.getIndex()).getDefense());
    }

    /*@Test
    void getDefenseAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getDefense(),iPokedex.getPokemon(aquali.getIndex()).getDefense());
    }*/

    @Test
    void getStaminaBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getStamina(),iPokedex.getPokemon(bulbizarre.getIndex()).getStamina());
    }

    /*@Test
    void getStaminaAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getStamina(),iPokedex.getPokemon(aquali.getIndex()).getStamina());
    }*/

    @Test
    void getCPBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getCp(),iPokedex.getPokemon(bulbizarre.getIndex()).getCp());
    }

    /*@Test
    void getCPAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getCp(),iPokedex.getPokemon(aquali.getIndex()).getCp());
    }*/

    @Test
    void getHPBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getHp(),iPokedex.getPokemon(bulbizarre.getIndex()).getHp());
    }

    /*@Test
    void getHPAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getHp(),iPokedex.getPokemon(aquali.getIndex()).getHp());
    }*/

    @Test
    void getDustBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getDust(),iPokedex.getPokemon(bulbizarre.getIndex()).getDust());
    }

    /*@Test
    void getDustAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getDust(),iPokedex.getPokemon(aquali.getIndex()).getDust());
    }*/

    @Test
    void getCandyBulbizarreMetadata() throws PokedexException{
        assertEquals(bulbizarre.getCandy(),iPokedex.getPokemon(bulbizarre.getIndex()).getCandy());
    }

    /*@Test
    void getCandyAqualiMetadata() throws PokedexException{
        assertEquals(aquali.getCandy(),iPokedex.getPokemon(aquali.getIndex()).getCandy());
    }*/

    @Test
    void getPokemons() throws PokedexException {
        assertEquals(pokemons.get(0).getPokemonMetadata(bulbizarre.getIndex()), iPokedex.getPokemons().get(0).getPokemonMetadata(bulbizarre.getIndex()));
        assertEquals(pokemons.get(1).getPokemonMetadata(aquali.getIndex()), iPokedex.getPokemons().get(1).getPokemonMetadata(aquali.getIndex()));
    }

    @Test
    void getPokemonComparator() throws PokedexException {
        Comparator<Pokemon> order = (o1, o2) -> 0;

        assertEquals(pokemons.get(0).getPokemonMetadata(bulbizarre.getIndex()), iPokedex.getPokemons(order).get(0).getPokemonMetadata(bulbizarre.getIndex()));
        assertEquals(pokemons.get(1).getPokemonMetadata(aquali.getIndex()), iPokedex.getPokemons(order).get(1).getPokemonMetadata(aquali.getIndex()));
    }

    @Test
    void getPokedexException() {
        for(int i=-10; i <= -1; i++) {
            int negatif = i;
            assertThrows(PokedexException.class, () -> iPokedex.getPokemon(negatif));
        }
        for(int i=151; i <= 160; i++) {
            int auDessus = i;
            assertThrows(PokedexException.class, () -> iPokedex.getPokemon(auDessus));
        }
    }
}