package br.com.uft.homologadora.util;

import br.com.uft.homologadora.model.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author UFT
 */
public class Servicos {

    public Servicos() {

    }

    public String criptografa(String senha) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(), 0, senha.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ns) {
            ns.printStackTrace();
        }
        return senha;
    }

    public void enviarEmail(Usuario user, String senha) throws EmailException {
        /* SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail 
        email.setSmtpPort(465);
        email.addTo(user.getEmail(), user.getNome()); //destinatário
        email.setFrom("elaynnealmeida@gmail.com", "Ciência da Computação - UFT"); // remetente
        email.setSubject("Mensagem de Teste"); // assunto do e-mail
        email.setMsg("Teste de Email utilizando commons-email "+senha); //conteudo do e-mail
        email.send(); //envia o e-mail*/

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email.addTo(user.getEmail(), user.getNome()); //destinatário
        email.setFrom("elaynnealmeida@gmail.com", "Ciência da Computação - UFT"); // remetente - MODIFIQUE AQUI
        email.setSubject("senha de acesso ao sistema de homoloção PAF-ECF"); // MODIFIQUE AQUI
        email.setMsg("login: " + user.getEmail() + " senha: " + senha); //MODIFIQUE AQUI
        email.setAuthentication("elaynnealmeida", "senha");// MODIFIQUE AQUI
        email.setSmtpPort(465);
        email.setSSL(true);
        email.setTLS(true);
        // envia o email
        email.send();
    }
}
