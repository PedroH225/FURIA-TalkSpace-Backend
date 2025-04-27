package br.com.xet_da_furia.model;

public enum Jogo {
    CS2("Counter-Strike 2"),
    VALORANT("Valorant"),
    RAINBOW_SIX("Rainbow Six Siege"),
    PUBG("PUBG"),
    LEAGUE_OF_LEGENDS("League of Legends"),
    ROCKET_LEAGUE("Rocket League"),
    APEX_LEGENDS("Apex Legends"),
    FIGHTING_GAMES("Fighting Games");

	private String jogo;
	
	Jogo(String jogo) {
		this.jogo = jogo;
	}
	
	public static Jogo fromString(String text) {
        for (Jogo jogo : Jogo.values()) {
            if (jogo.jogo.equalsIgnoreCase(text)) {
                return jogo;
            }
        }
        throw new IllegalArgumentException("Nenhum jogo encontrado para a string fornecida: " + text);
    }
	
	@Override
	public String toString() {
		return this.jogo;
	}
}
