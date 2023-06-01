public class PastelFactory extends ComidaFactory {
    @Override
    public Comida criarComida(String... ingredientes) {
        String recheio = ingredientes[0];
        String tamanho = ingredientes[1];
        return new Pastel(recheio, tamanho);
    }
}