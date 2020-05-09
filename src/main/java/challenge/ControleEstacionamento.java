package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControleEstacionamento {
    private static final int IDADE_PERMITIDA = 18;
    private static final int LIMITE_DE_VAGAS = 10;
    private static final int IDADE_SENIORIDADE = 55;
    private List<Carro> vagas = new ArrayList<>();
    public void validarCarroEstacionamento(Carro carro){
         if (Objects.isNull(carro.getMotorista())) {
            throw new EstacionamentoException("Carro sem motorista!");
        } }
    public void verificarVagasDisponivesOuRemover(Carro carro){
        int id;
        if(vagas.size()==LIMITE_DE_VAGAS){
            id= verificarSenioridadeOuRemover();
            vagas.add(id,carro);
        } else{
            vagas.add(carro);} }
    public int verificarSenioridadeOuRemover(){
        int id;
        Carro motoristaMenorQue55anos= vagas.stream()
                .filter(carro-> carro.getMotorista().getIdade()<IDADE_SENIORIDADE)
                .findFirst()
                .orElseThrow(()->new EstacionamentoException("Todos os motoristas tem mais de 55 anos!"));
        id= vagas.indexOf(motoristaMenorQue55anos);
        vagas.remove(motoristaMenorQue55anos);
        return id;
    }
    public void validarMotorista(Motorista motorista){
        if (Objects.isNull(motorista))
            throw new EstacionamentoException("Carro sem motorista não é autorizado estacionar!");
        if (motorista.getIdade() < IDADE_PERMITIDA)
            throw new EstacionamentoException("Motorista menor de " + IDADE_PERMITIDA + " anos");
    }
    public List<Carro> getVagas() {
        return vagas;
    }

    public void setVagas(List<Carro> vagas) {
        this.vagas = vagas;
    }

}
