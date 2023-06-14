import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;


class RedeSocial {
    Map<String, Usuario> usuarios;
    Usuario usuarioAtual;

    public RedeSocial() {
        this.usuarios = new HashMap<>();
        this.usuarioAtual = null;
    }

    public void cadastrarUsuario(String nome, String email, String senha) {
        Usuario usuario = new UsuarioPadrao(nome, email, senha);
        usuarios.put(email, usuario);
    }

    public boolean fazerLogin(String email, String senha) {
        Usuario usuario = usuarios.get(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            usuarioAtual = usuario;
            return true;
        }
        return false;
    }

    public void fazerLogout() {
        usuarioAtual = null;
    }

    public void adicionarAmigo(Usuario amigo) {
        usuarioAtual.adicionarAmigo(amigo);
    }

    public void removerAmigo(Usuario amigo) {
        usuarioAtual.removerAmigo(amigo);
    }

    public List<Usuario> consultarAmigos() {
        return usuarioAtual.getAmigos();
    }
}

