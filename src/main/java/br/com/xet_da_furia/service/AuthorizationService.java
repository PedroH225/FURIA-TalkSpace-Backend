package br.com.xet_da_furia.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.xet_da_furia.model.Usuario;
import br.com.xet_da_furia.model.dto.LoginDto;
import br.com.xet_da_furia.model.dto.RegisterDTO;
import br.com.xet_da_furia.repository.UsuarioRepository;
import br.com.xet_da_furia.security.TokenService;

@Service
public class AuthorizationService implements UserDetailsService{
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private TokenService tokenService;

    private AuthenticationManager authenticationManager;
    
    private boolean verificarEmailExistente(String email) {
		return userRepository.buscarPorEmail(email).isPresent();
	}
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    } 

    public ResponseEntity<Object> login(LoginDto data){
        authenticationManager = context.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        Map<String, String> response = new HashMap<String, String>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }


    public ResponseEntity<Object> register (RegisterDTO registerDto){
    	if (verificarEmailExistente(registerDto.email())) {
			throw new RuntimeException("Email em uso.");
		}
    	
    	String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.senha());
        
        Usuario newUser = new Usuario(registerDto.nome(), registerDto.email(), encryptedPassword);
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}