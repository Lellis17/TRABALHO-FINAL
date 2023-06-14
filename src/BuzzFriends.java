import javax.swing.*;
import java.util.List;

public class BuzzFriends {
    public static void main(String[] args) {
        RedeSocial redeSocial = new RedeSocial();

        while (true) {
            String opcaoStr = JOptionPane.showInputDialog(" Buzz Friends \n\n"
                    + "1. Cadastrar usuário\n"
                    + "2. Fazer login\n"
                    + "3. Sair\n\n"
                    + "Escolha uma opção:");

            if (opcaoStr == null) {
                break;
            }

            int opcao;
            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                continue;
            }

            if (opcao == 1) {
                String nome = JOptionPane.showInputDialog("Nome:");
                String email = JOptionPane.showInputDialog("E-mail:");
                String senha = JOptionPane.showInputDialog("Senha:");

                redeSocial.cadastrarUsuario(nome, email, senha);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

            } else if (opcao == 2) {
                String email = JOptionPane.showInputDialog("E-mail:");
                String senha = JOptionPane.showInputDialog("Senha:");

                if (redeSocial.fazerLogin(email, senha)) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");

                    while (true) {
                        String opcaoMenuStr = JOptionPane.showInputDialog(" Menu de Opções  \n\n"
                                + "1. Adicionar amigo\n"
                                + "2. Consultar amigos\n"
                                + "3. Remover amigo\n"
                                + "4. Enviar mensagem\n"
                                + "5. Fazer logout\n\n"
                                + "Escolha uma opção:");

                        if (opcaoMenuStr == null) {
                            break;
                        }

                        int opcaoMenu;
                        try {
                            opcaoMenu = Integer.parseInt(opcaoMenuStr);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                            continue;
                        }

                        if (opcaoMenu == 1) {
                            String emailAmigo = JOptionPane.showInputDialog("E-mail do amigo:");
                            Usuario amigo = redeSocial.usuarios.get(emailAmigo);
                            if (amigo != null) {
                                redeSocial.adicionarAmigo(amigo);
                                JOptionPane.showMessageDialog(null, "Amigo adicionado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                            }

                        } else if (opcaoMenu == 2) {
                            List<Usuario> amigos = redeSocial.consultarAmigos();
                            StringBuilder amigosStr = new StringBuilder("Amigos:\n");
                            for (Usuario amigo : amigos) {
                                amigosStr.append(amigo.getEmail()).append("\n");
                            }
                            JOptionPane.showMessageDialog(null, amigosStr.toString());

                        } else if (opcaoMenu == 3) {
                            String emailAmigo = JOptionPane.showInputDialog("E-mail do amigo:");
                            Usuario amigo = redeSocial.usuarios.get(emailAmigo);
                            if (amigo != null) {
                                redeSocial.removerAmigo(amigo);
                                JOptionPane.showMessageDialog(null, "Amigo removido com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                            }

                        } else if (opcaoMenu == 4) {
                            String emailAmigo = JOptionPane.showInputDialog("E-mail do amigo:");
                            Usuario amigo = redeSocial.usuarios.get(emailAmigo);
                            if (amigo != null) {
                                String mensagem = JOptionPane.showInputDialog("Mensagem:");
                                redeSocial.usuarioAtual.enviarMensagem(amigo, mensagem);
                                JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                            }

                        } else if (opcaoMenu == 5) {
                            redeSocial.fazerLogout();
                            JOptionPane.showMessageDialog(null, "Logout realizado com sucesso!");
                            break;

                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos.");
                }

            } else if (opcao == 3) {
                JOptionPane.showMessageDialog(null, "Saindo do programa...");
                break;

            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }
}
