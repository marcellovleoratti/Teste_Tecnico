package br.com.teste_tecnico.teste.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="apolices", catalog="Teste_Tecnico")
public class Apolices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Number numero_apolice;

    @NotNull
    private String inc_vigencia;

    @NotNull
    private String fim_vingencia;

    @NotNull
    private String placa_veiculo;

    @NotNull
    private BigDecimal valor_apolice;

    @ManyToOne
    @JoinColumn(name = "cliente_apolice")
    private Clientes cliente_apolice;

    @NotNull
    private String Vencimento_Apolice;

    @NotNull
    private Integer Qtd_dias_Vencimento;

    public Clientes getCliente_apolice() {
        return cliente_apolice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Number getNumero_apolice() {
        return numero_apolice;
    }

    public void setNumero_apolice(Number numero_apolice) {
        this.numero_apolice = numero_apolice;
    }

    public String getPlaca_veiculo() {
        return placa_veiculo;
    }

    public void setPlaca_veiculo(String placa_veiculo) {
        this.placa_veiculo = placa_veiculo;
    }

    public BigDecimal getValor_apolice() {
        return valor_apolice;
    }

    public void setValor_apolice(BigDecimal valor_apolice) {
        this.valor_apolice = valor_apolice;
    }

    public void setCliente_apolice(Clientes cliente_apolice) {
        this.cliente_apolice = cliente_apolice;
    }

    public String getVencimento_Apolice() {
        return Vencimento_Apolice;
    }

    public void setVencimento_Apolice(String vencimento_Apolice) {
        Vencimento_Apolice = vencimento_Apolice;
    }

    public Integer getQtd_dias_Vencimento() {
        return Qtd_dias_Vencimento;
    }

    public void setQtd_dias_Vencimento(Integer qtd_dias_Vencimento) {
        Qtd_dias_Vencimento = qtd_dias_Vencimento;
    }

    public String getInc_vigencia() {
        return inc_vigencia;
    }

    public void setInc_vigencia(String inc_vigencia) {
        this.inc_vigencia = inc_vigencia;
    }

    public String getFim_vingencia() {
        return fim_vingencia;
    }

    public void setFim_vingencia(String fim_vingencia) {
        this.fim_vingencia = fim_vingencia;
    }
}
