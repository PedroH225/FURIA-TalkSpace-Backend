package br.com.xet_da_furia.model;

public enum Tema {
	DISCUSSAO_DE_PARTIDA("Discussão de Partida"),
    NOTICIAS("Notícias"),
    ANALISES_ESTRATEGICAS("Análises Estratégicas"),
    HIGHLIGHTS("Melhores Momentos"),
    TREINOS_E_TATICA("Treinos e Tática"),
    RUMORES_E_TRANSFERENCIAS("Rumores e Transferências"),
    EVENTOS_E_CAMPEONATOS("Eventos e Campeonatos"),
    OFF_TOPIC("Off-topic"),
    MEMES("Memes");

	private String tema;
	
    Tema(String tema) {
        this.tema = tema;
    }
	
    public static Tema fromString(String text) {
        for (Tema tema : Tema.values()) {
            if (tema.tema.equalsIgnoreCase(text)) {
                return tema;
            }
        }
        throw new IllegalArgumentException("Nenhum tema encontrado para a string fornecida: " + text);
    }
	
    @Override
    public String toString() {
        return this.tema;
    }
}
