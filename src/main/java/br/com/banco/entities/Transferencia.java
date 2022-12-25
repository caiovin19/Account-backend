package br.com.banco.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "transferencia")
public class Transferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idIdentity;
    @Column(name = "data_transferencia")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy", timezone="GMT")
    private Date dataTransferencia;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "nome_operador_transacao")
    private String nomeOperadorTransacao;
    @Column(name = "conta_id")
    private Integer idConta;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "transferencias")
    @JsonIgnore
    private List<Conta> contas=new ArrayList<>();



    public Transferencia() {
    }

    public Transferencia(Integer idIdentity, Date dataTransferencia, Double valor, String tipo, String nomeOperadorTransicao, Integer idConta) {
        this.idIdentity = idIdentity;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransicao;
        this.idConta = idConta;
    }

    public Integer getIdIdentity() {
        return idIdentity;
    }

    public void setIdIdentity(Integer idIdentity) {
        this.idIdentity = idIdentity;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public List<Conta> getContas() {
        return contas;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "idIdentity=" + idIdentity +
                ", dataTransferencia=" + dataTransferencia +
                ", valor=" + valor +
                ", tipo='" + tipo + '\'' +
                ", nomeOperadorTransacao='" + nomeOperadorTransacao + '\'' +
                ", idConta=" + idConta +
                ", contas=" + contas +
                '}';
    }
}
