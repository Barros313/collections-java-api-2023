package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();

        for (Contato c : contatoSet) {
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }

        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                return c;
            }
        }

        System.out.println("Nome não encontrado");

        return null;
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Camila", 123456);
        agenda.adicionarContato("Camila", 5665);
        agenda.adicionarContato("Camila Cavalcante", 11111111);
        agenda.adicionarContato("Camila DIO", 123456);
        agenda.adicionarContato("Maria Silva", 11111111);

        System.out.println(agenda.pesquisarPorNome("Camila"));
        System.out.println("Contato atualizado: " + agenda.atualizarNumeroContato("Maria Silva", 55555555));

        agenda.exibirContatos();
    }
}
