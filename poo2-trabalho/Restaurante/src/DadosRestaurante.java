import java.util.ArrayList;

public class DadosRestaurante {
    private static ArrayList<Comida> comidas;
    public static void inicializaDados(){
        comidas = (ArrayList<Comida>) Persist.recuperar("contas.dat");
        if(comidas == null)
        comidas = new ArrayList<Comida>();
    }
    public static void cadastrar(Comida a){
        comidas.add(a);
        boolean r = Persist.gravar(comidas,"contas.dat");
    }

    public static void MostraDados(){
        for(int i=0 ; i<comidas.size();i++){
            System.out.println("Pedido "+ i + ":");
            comidas.get(i).MostraComida();
            if(comidas.get(i) instanceof ComidaDecorator){
            System.out.print("Com adicionais: ");
            comidas.get(i).MostrarAdicionais();
        }
        System.out.println("");
        }
    }
    
}
