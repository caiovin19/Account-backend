package br.com.banco.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Id;

@Entity
@Table(name= "conta")

public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "id_conta", nullable = false)
    private Integer idConta;
    @Column(name = "nome_responsavel")
    private String nomeResponsavel;
    private Double soma;


    @ManyToMany
   @JoinTable(name="tb_conta_transferencia", joinColumns = @JoinColumn(name="id_conta"), inverseJoinColumns = @JoinColumn(name="conta_id"))
    List<Transferencia>transferencias=new ArrayList<>();

    public Conta(){

    }

    public Conta(Integer idConta, String nomeResponsavel, Double soma, Double valorTransf) {
        this.idConta = idConta;
        this.nomeResponsavel = nomeResponsavel;
        this.soma=soma;
//        this.valorTransf=valorTransf;
    }

    public Integer getIdConta() {

        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public List<Transferencia> getTransferencias() {
       return transferencias;
   }

    public Double getSoma() {
        return soma;
    }

    public void setSoma(Double soma) {
        this.soma = soma;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return idConta == conta.idConta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConta);
    }
}
