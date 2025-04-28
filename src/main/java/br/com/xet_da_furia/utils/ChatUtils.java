package br.com.xet_da_furia.utils;

import java.util.Optional;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.model.Usuario;

public class ChatUtils {

	public static void garantirParticipacao(Chat chat, String usuarioId) {
		Optional<Usuario> buscarUsuario = chat.getParticipantes().stream()
				.filter(p -> p.getId().equals(usuarioId))
				.findFirst();
		
		if (buscarUsuario.isEmpty()) {
			throw new RuntimeException("Você não está participando do chat.");
		}
	}
}
