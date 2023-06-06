public class Ovo extends ComidaDecorator {
    public Ovo(Comida comida){
        super(comida);
    }
    public void preparar(){
        super.preparar();

    }
    @Override
    public void MostrarAdicionais() {
        System.out.print(" Ovo");
        comida.MostrarAdicionais();
    }
}
