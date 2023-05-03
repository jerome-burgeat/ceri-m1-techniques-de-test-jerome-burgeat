package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static List<PokemonMetadata> pokemonMetadataList;

    public PokemonMetadataProvider() {
        pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        //pokemonMetadataList.add(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 151)
            throw new PokedexException("Le pokemon est introuvable");
        try {
            return pokemonMetadataList.get(index);
        } catch (Exception e) {
            throw new PokedexException("Le pokemon est introuvable");
        }
    }
}