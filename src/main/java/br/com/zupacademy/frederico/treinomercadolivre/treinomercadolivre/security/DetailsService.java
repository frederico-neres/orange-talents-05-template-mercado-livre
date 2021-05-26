package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.security;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.usuario.Usuario;
import io.jsonwebtoken.Jwts;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class DetailsService implements UserDetailsService {

 
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        String jpql = "SELECT u FROM Usuario u WHERE u.login = :login";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("login", login); 
        
        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return usuario;
        }catch (NoResultException exception) {
            throw new UsernameNotFoundException("Dados invalidos");
        }

    }

}
