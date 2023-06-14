import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

class UsuarioPadrao extends Usuario {
    public UsuarioPadrao(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void enviarMensagem(Usuario amigo, String mensagem) {
        JOptionPane.showMessageDialog(null, "Enviando mensagem para " + amigo.getEmail() + ":\n\n" + mensagem);
    }
}

