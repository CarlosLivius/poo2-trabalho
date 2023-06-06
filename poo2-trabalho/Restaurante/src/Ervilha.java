public class Ervilha extends ComidaDecorator {
    public Ervilha(Comida comida){
        super(comida);
    }
    public void preparar(){
        super.preparar();
    }
    @Override
    public void MostrarAdicionais() {
        System.out.print(" Ervilha");
        super.MostrarAdicionais();
    }
}