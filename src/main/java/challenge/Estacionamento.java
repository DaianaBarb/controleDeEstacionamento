package challenge;

public class Estacionamento {
 ControleEstacionamento controle = new ControleEstacionamento();

    public void estacionar(Carro carro) {
        controle.validarCarroEstacionamento(carro);
        controle.validarMotorista(carro.getMotorista());
        controle.verificarVagasDisponivesOuRemover(carro);
    }
    public int carrosEstacionados() {
        return controle.getVagas().size();
    }
    public boolean carroEstacionado(Carro carro) {
        return controle.getVagas().contains(carro);
    }

}
