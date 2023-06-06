public class Milho extends ComidaDecorator {
    public Milho(Comida comida){
        super(comida);
    }
    public void preparar(){
        super.preparar();

    }
    @Override
    public void MostrarAdicionais() {
        System.out.print(" Milho");
        comida.MostrarAdicionais();
    }
}
