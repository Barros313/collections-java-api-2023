package set.operacoesBasicas;

import java.security.cert.CertificateRevokedException;
import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvivado {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvivado() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigo(int codigoConvite) {
        for (Convidado convidado : convidadoSet) {
            if (convidado.getCodigoConvite() == codigoConvite) {
                convidadoSet.remove(convidado);
                return;
            }
        }

        System.out.println("Não existe convidado com esse código de convite");
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvivado conjuntoConvidados = new ConjuntoConvivado();

        conjuntoConvidados.adicionarConvidado("Convidado 1", 1234);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 1236);

        conjuntoConvidados.removerConvidadoPorCodigo(1234);

        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados");
        conjuntoConvidados.exibirConvidados();
    }
}
