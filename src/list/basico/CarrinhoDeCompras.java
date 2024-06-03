package list.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class CarrinhoDeCompras {
    private final List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(item);
            }
        }

        itemList.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        if (itemList.isEmpty()) {
            throw new RuntimeException("O carrinho está vazio!");
        }

        double total = 0;

        for (Item item : itemList) {
            total += item.getPreco() * item.getQuantidade();
        }

        return total;
    }

    public void exibirItens() {
        if (itemList.isEmpty()) {
            System.out.println("O carrinho está vazio!");
            return;
        }

        for (Item item : itemList) {
            System.out.println("Item: " + item.getNome());
            System.out.println("Preço: R$" + item.getPreco());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.printf("Subtotal: R$%.2f\n\n", (item.getPreco() * item.getQuantidade()));
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Red Bull 200ml Tradicional", 9.49, 2);
        carrinho.adicionarItem("Torcidas 70g Pimenta Mexicana", 2.49, 5);

        carrinho.exibirItens();
        System.out.printf("Valor total: R$%.2f\n\n", carrinho.calcularValorTotal());

        carrinho.removerItem("Red Bull 200ml Tradicional");
        carrinho.removerItem("Torcidas 70g Pimenta Mexicana");

        carrinho.exibirItens();
        try {
            System.out.printf("Valor total: R$%.2f", carrinho.calcularValorTotal());
        } catch (RuntimeException e) {
            System.out.println("O carrinho está vazio!");
            return;
        }


    }
}
