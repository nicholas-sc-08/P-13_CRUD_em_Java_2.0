import javax.swing.JOptionPane;
import java.util.ArrayList;

public class crud{

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static boolean fim_do_crud = false;

    public static void main(String[] args){

        while(!fim_do_crud){

       String resposta = JOptionPane.showInputDialog("Escolha uma das opções a seguir:\n1) Cadastrar\n2) Pesquisar\n3)Excluir\n4) Editar\n5) Sair");

       switch(resposta){

        case "1":

            cadastrar_usuario();
            break;

        case "2":

            pesquisar_usuario();
            break;

        case "3":

            excluir_usuario();
            break;

        case "4":

            editar_usuario();
            break;

        case "5":

            fim_do_crud = true;
            break;

        default:

            JOptionPane.showMessageDialog(null, "Favor inserir uma das 5 opções, 1, 2, 3, 4 ou 5 que sejam válidas!");
            break;
       };
       };
    };

       private static void editar_usuario(){

            JOptionPane.showMessageDialog(null, "Você deve digitar o nome & o CPF do usuário que você deseja mudar;");

            String nome_a_mudar = JOptionPane.showInputDialog("Digite o nome do usuário que você quer mudar");

            String cpf_a_mudar = JOptionPane.showInputDialog("Digite o CPF do usuário que você quer mudar");

            boolean nome_ou_cpf_nao_cadastrado = false;

            for(int i = 0; i < usuarios.size(); i++){

                Usuario usuario = usuarios.get(i);
                boolean cpf_ou_email_ja_cadastrado = false;

                if(usuario.cpf.equals(cpf_a_mudar) && usuario.nome.equals(nome_a_mudar)){

                    nome_ou_cpf_nao_cadastrado = true;

                    String novo_nome = JOptionPane.showInputDialog("Digite o novo nome do usuário.");

                    String novo_cpf = JOptionPane.showInputDialog("Digite o novo cpf do usuário.");

                    String novo_email = JOptionPane.showInputDialog("Digite o novo email do usuário.");

                    String nova_senha = JOptionPane.showInputDialog("Digite o nova senha do usuário.");

                    for(int index = 0; i < usuarios.size(); i++){
                        
                        Usuario cpf_e_email_do_usuario = usuarios.get(index);

                        if(cpf_e_email_do_usuario.cpf.equals(novo_cpf) || cpf_e_email_do_usuario.email.equals(novo_email)){

                            cpf_ou_email_ja_cadastrado = true;
                        };
                    };

                    if(cpf_ou_email_ja_cadastrado){

                        JOptionPane.showMessageDialog(null, "CPF ou Email já cadastrados.");

                    } else {

                    usuario.nome = novo_nome;
                    usuario.cpf = novo_cpf;
                    usuario.email = novo_email;
                    usuario.senha = nova_senha;

                    };
                };
            };

            if(!nome_ou_cpf_nao_cadastrado){

                JOptionPane.showMessageDialog(null, "Nome ou CPF não cadastrado!");
            };
       };

       private static void excluir_usuario(){

            JOptionPane.showMessageDialog(null, "Você está para excluir um usuário, você deve digitar o nome & o CPF dele para que ele seja excluido;");

            String nome_a_excluir = JOptionPane.showInputDialog(null, "Digite o nome do usuário que deseja excluir:");

            String cpf_a_excluir = JOptionPane.showInputDialog(null, "Digite o CPF do usuário que você digitou o nome: ");

            for(int i = 0; i < usuarios.size(); i++){

                Usuario usuario = usuarios.get(i);

                if(usuario.cpf.equals(cpf_a_excluir) && usuario.nome.equals(nome_a_excluir)){

                    usuarios.remove(i);

                    JOptionPane.showMessageDialog(null, "Usuário Excluido!");

                } else {

                    JOptionPane.showMessageDialog(null, "CPF ou nome inválido!");
                };
            };
       };

       private static void pesquisar_usuario(){

            String resposta = JOptionPane.showInputDialog("Digite o nome que deseja pesquisar:");

            for(Usuario usuario : usuarios){

                if(usuario.nome.equals(resposta)){

                    JOptionPane.showMessageDialog(null, "Nome cadastrado!");

                    JOptionPane.showMessageDialog(null, "Nome: "+usuario.nome+"\nCPF: "+usuario.cpf+"\nEmail: "+usuario.email+"\nSenha: "+usuario.senha);

                } else {

                    JOptionPane.showMessageDialog(null, "Nome não cadastrado!");

                };
            };
       };

       private static void cadastrar_usuario(){

            boolean cpf_ja_cadastrado = false;
            boolean email_ja_cadastrado = false;

            String nome = JOptionPane.showInputDialog("Digite o nome de usuário:");

            String cpf = JOptionPane.showInputDialog("Digite seu cpf:");

            String email = JOptionPane.showInputDialog("Digite seu email:");

            String senha = JOptionPane.showInputDialog("Digite sua senha:");

            for(Usuario usuario : usuarios){

                if(usuario.cpf.equals(cpf)){

                    cpf_ja_cadastrado = true;
                };

                if(usuario.email.equals(email)){

                    email_ja_cadastrado = true;
                };
            };
            
            if(cpf_ja_cadastrado == false && email_ja_cadastrado == false){

                Usuario novo_usuario = new Usuario(nome, cpf, email, senha);

                usuarios.add(novo_usuario);
            
            } else {

                if(cpf_ja_cadastrado == true && email_ja_cadastrado == false){

                    JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
                } else if(cpf_ja_cadastrado == false && email_ja_cadastrado == true){

                    JOptionPane.showMessageDialog(null, "Email já cadastrado!");
                } else {

                    JOptionPane.showMessageDialog(null, "CPF & Email já cadastrado!");
                };
            };
       };
}
