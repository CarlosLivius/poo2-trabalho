public class MaisQueijo extends ComidaDecorator {
    public MaisQueijo(Comida comida){
        super(comida);
    }
    public void preparar(){
        super.preparar();

    }
    @Override
    public void MostrarAdicionais() {
        System.out.print(" Mais Queijo");
        comida.MostrarAdicionais();
    }
}

