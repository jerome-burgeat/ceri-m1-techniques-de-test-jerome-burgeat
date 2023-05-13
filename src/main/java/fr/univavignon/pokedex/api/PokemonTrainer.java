package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
public class PokemonTrainer implements IPokemonTrainerFactory {

	/** Trainer name. **/
	private final String name;

	/** Trainer team. **/
	private final Team team;
	
	/** Trainer pokedex. **/
	private final IPokedex pokedex;
	
	/**
	 * Default constructor.
	 * 
	 * @param name Trainer name.
	 * @param team Trainer team.
	 * @param pokedex Trainer pokedex.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}
	
	/** Name getter. **/
	public String getName() {
		return name;
	}

	/** Team getter. **/
	public Team getTeam() {
		return team;
	}
	
	/** Pokedex getter. **/
	public IPokedex getPokedex() {
		return pokedex;
	}

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
		IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
		if(this.getName() != null && this.getTeam() != null || this.getPokedex() != null) {
			return this;
		}
		else if(metadataProvider != null && pokedexFactory != null) {
			return new PokemonTrainer(name, team, pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
		}
		return null;
	}
}