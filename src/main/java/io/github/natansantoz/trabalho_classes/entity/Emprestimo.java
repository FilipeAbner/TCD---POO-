package io.github.natansantoz.trabalho_classes.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public final class Emprestimo extends Entidade {

    private Cliente cliente;
    private Long cliente_id;
    private Exemplar exemplar;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataLimiteDevolucao;
    private LocalDateTime dataDevolvido;
    private LocalDateTime dataPagamentoMulta;
    private BigDecimal multa;
    private static final int MAX_LENGTH_OBSERVACAO = 300;
    private String observacao;
    private long atraso;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Emprestimo() {

        this.atraso = 0l;
        this.multa = BigDecimal.valueOf(0);
        setDataEmprestimo();
        setDataLimiteDevolucao();
    }

    public Emprestimo(Cliente cliente, Exemplar exemplar, String observacao, Long cliente_id) {

        this();
        this.cliente_id = cliente_id;
        this.cliente = cliente;
        this.exemplar = exemplar;
        this.observacao = observacao;
    }

    public Emprestimo(Cliente cliente, Exemplar exemplar, LocalDateTime dataEmprestimo,
            LocalDateTime dataLimiteDevolucao, LocalDateTime dataDevolvido,
            LocalDateTime dataPagamentoMulta, long atraso, BigDecimal multa,
            String observacao, Long cliente_id) {

        this.cliente_id = cliente_id;
        this.cliente = cliente;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataLimiteDevolucao = dataLimiteDevolucao;
        this.dataDevolvido = dataDevolvido;
        this.dataPagamentoMulta = dataPagamentoMulta;
        this.atraso = atraso;
        this.multa = multa;
        this.observacao = observacao;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public void setAtraso(long atraso) {
        this.atraso = atraso;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;
//        cliente.adicionarEmprestimo(this);
    }

    public Exemplar getExemplar() {

        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {

        this.exemplar = exemplar;
        exemplar.setEmprestimo(this);

    }

    public LocalDateTime getDataEmprestimo() {

        return dataEmprestimo;
    }

    public void setDataEmprestimo() {

//        if (dataEmprestimo == null){
        this.dataEmprestimo = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
//        }
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {

//        if (this.dataEmprestimo == null){
        this.dataEmprestimo = dataEmprestimo;
//        }
    }

    public LocalDateTime getDataLimiteDevolucao() {

        return dataLimiteDevolucao;
    }

    public void setDataLimiteDevolucao() {

        if (dataLimiteDevolucao == null) {
            this.dataLimiteDevolucao = LocalDateTime.now().plusDays(30);
        }
    }

    public void setDataLimiteDevolucao(LocalDateTime dataLimiteDevolucao) {

//        if(this.dataLimiteDevolucao == null){
        this.dataLimiteDevolucao = dataLimiteDevolucao;
//        }
    }

    public LocalDateTime getDataDevolvido() {

        return dataDevolvido;
    }

    public void setDataDevolvido() {

        if (dataDevolvido == null) {
            this.dataDevolvido = LocalDateTime.now();
        }
    }

    public void setDataDevolvido(LocalDateTime dataDevolvido) {

//        if(this.dataDevolvido == null){
        this.dataDevolvido = dataDevolvido;
//        }
    }

    public LocalDateTime getDataPagamentoMulta() {

        return dataPagamentoMulta;
    }

    public void setDataPagamentoMulta() {

        if (this.dataPagamentoMulta == null) {
            this.dataPagamentoMulta = LocalDateTime.now();
        }
    }

    public void setDataPagamentoMulta(LocalDateTime dataPagamentoMulta) {

//        if(this.dataPagamentoMulta == null){
        this.dataPagamentoMulta = dataPagamentoMulta;
//        }
    }

    public long getAtraso() {
        
        long quantidadeDiasEmAtraso = ChronoUnit.DAYS.between(
                dataLimiteDevolucao, LocalDateTime.now()) + 1l;
        
        this.atraso = quantidadeDiasEmAtraso > 0 ? quantidadeDiasEmAtraso : 0;

        // se atrasado, retorna a quantidade de dias em atraso. se não, retorna 0 
        return atraso;
    }

    public String getObservacao() {

        return observacao;
    }

    public void setObservacao(String observacao) {

        this.observacao =
            observacao.substring(0, 
                Math.min(observacao.length(), MAX_LENGTH_OBSERVACAO));
    }

    public BigDecimal getMulta() {

        if (!isAtrasado()) {
            return BigDecimal.valueOf(0);
        }

        BigDecimal taxaDiaria = BigDecimal.valueOf(1.5);
        BigDecimal diasEmAtraso = BigDecimal.valueOf(atraso);

        multa = taxaDiaria.multiply(diasEmAtraso);

        return multa;
    }
    
//</editor-fold>

    public boolean isAtrasado() {

        return getAtraso() > 0;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
        return "ID: " 
                + (getId().toString().length() > 1 
                ? getId() + "  | " 
                :  getId() + "   | " ) + "Data do Emprestimo: " 
                + dataEmprestimo.toLocalDate().format(formatter)
                + " | " + "Devolvido: " + 
                dataDevolvido.toLocalDate().format(formatter);
    }
    
    
}
