package br.com.ituniverse.checklist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "tb_checklist_servidor")
public class Servidor {

    @Id
    private String id;
    private String fabricante;
    private String modelo;
    private String tag;
    private String tamanhoMemoria;
    private String frequencia;
    private String observacao;

    private boolean existe; //Existe PDV ?
    private String status;
    private String tecnico;
    private LocalDate dataTroca;
    private String intercorrencia;
    private List<String> antes;
    private List<String> depois;

    @JsonIgnoreProperties({"servidor"})
    @OneToOne(cascade = CascadeType.REMOVE)
    private Loja loja;

    public Servidor(){}

    public Servidor(String id, String fabricante, String modelo, String tag, String tamanhoMemoria, String frequencia, String observacao, boolean existe, String status, String tecnico, LocalDate dataTroca, String intercorrencia, List<String> antes, List<String> depois, Loja loja) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tag = tag;
        this.tamanhoMemoria = tamanhoMemoria;
        this.frequencia = frequencia;
        this.observacao = observacao;
        this.existe = existe;
        this.status = status;
        this.tecnico = tecnico;
        this.dataTroca = dataTroca;
        this.intercorrencia = intercorrencia;
        this.antes = antes;
        this.depois = depois;
        this.loja = loja;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTamanhoMemoria() {
        return tamanhoMemoria;
    }

    public void setTamanhoMemoria(String tamanhoMemoria) {
        this.tamanhoMemoria = tamanhoMemoria;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public LocalDate getDataTroca() {
        return dataTroca;
    }

    public void setDataTroca(LocalDate dataTroca) {
        this.dataTroca = dataTroca;
    }

    public String getIntercorrencia() {
        return intercorrencia;
    }

    public void setIntercorrencia(String intercorrencia) {
        this.intercorrencia = intercorrencia;
    }

    public List<String> getAntes() {
        return antes;
    }

    public void setAntes(List<String> antes) {
        this.antes = antes;
    }

    public List<String> getDepois() {
        return depois;
    }

    public void setDepois(List<String> depois) {
        this.depois = depois;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
