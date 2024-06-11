package map.basico;

import java.util.HashMap;
import java.util.Map;

public class AgendaContato {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContato() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (agendaContatoMap.isEmpty()) {
            handleEmptyAgenda();
            return;
        }

        agendaContatoMap.remove(nome);
    }

    public void exibirContatos() {
        if (agendaContatoMap.isEmpty()) {
            handleEmptyAgenda();
            return;
        }

        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        return agendaContatoMap.get(nome);
    }

    private void handleEmptyAgenda() {
        System.out.println("Agenda vazia");
    }

    public static void main(String[] args) {
        AgendaContato agendaContato = new AgendaContato();

        agendaContato.adicionarContato("Camila", 123456);
        agendaContato.adicionarContato("Camila", 5665);
        agendaContato.adicionarContato("Camila Cavalcante", 111111111);
        agendaContato.adicionarContato("Camila DIO", 654987);
        agendaContato.adicionarContato("Maria Silva", 11111111);
        agendaContato.adicionarContato("Camila", 4444);

        agendaContato.removerContato("Maria Silva");

        agendaContato.exibirContatos();
        System.out.println("Número: " + agendaContato.pesquisarPorNome("Camila DIO"));
    }
}
