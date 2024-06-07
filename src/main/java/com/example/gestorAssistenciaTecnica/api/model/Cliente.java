package com.example.gestorAssistenciaTecnica.api.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jefferson
 */
@Entity
@Table(name = "cliente", schema = "public")
public class Cliente {

    private Long id;
    private String nomeRazao;
    private String cpfCnpj;
    private String iDInscEstadual;
    private String apelidoNomeFant;
    private boolean isFornecedor;
    private boolean isTecnico;
    private boolean isPj;
    private Date dataNascFund;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getiDInscEstadual() {
        return iDInscEstadual;
    }

    public void setiDInscEstadual(String iDInscEstadual) {
        this.iDInscEstadual = iDInscEstadual;
    }

    public String getApelidoNomeFant() {
        return apelidoNomeFant;
    }

    public void setApelidoNomeFant(String apelidoNomeFant) {
        this.apelidoNomeFant = apelidoNomeFant;
    }

    public boolean isIsFornecedor() {
        return isFornecedor;
    }

    public void setIsFornecedor(boolean isFornecedor) {
        this.isFornecedor = isFornecedor;
    }

    public boolean isIsTecnico() {
        return isTecnico;
    }

    public void setIsTecnico(boolean isTecnico) {
        this.isTecnico = isTecnico;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cliente_id")
    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cliente_id")
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public boolean isIsPj() {
        return isPj;
    }

    public void setIsPj(boolean isPj) {
        this.isPj = isPj;
    }

    public Date getDataNascFund() {
        return dataNascFund;
    }

    public void setDataNascFund(Date dataNascFund) {
        this.dataNascFund = dataNascFund;
    }

}
