package Planilha;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.planilha")
public class Planilha implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_planilha")
    private Integer id_planilha;     
    
    @Column(name="data_dia")
    private String data_dia;
    
    @Column(name="data_mes")
    private String data_mes;
    
    @Column(name="data_ano")
    private String data_ano;
    
    @Column(name="nome_completo_visitante")
    private String visitante;
    
    @Column(name="bolsista")
    private Integer bolsista;
    
    @Column(name="tipo_documento")
    private String tipo_documento;
    
    @Column(name="num_documento")
    private String num_documento;
    
    @Column(name="computador")
    private String computador;
    
    @Column(name="laboratorio")
    private String laboratorio;
    
    @Column(name="hora_entrada")
    private String hora_entrada;
    
    @Column(name="hora_saida")
    private String hora_saida;
    
    @Column(name="min_entrada")
    private String min_entrada;

    @Column(name="min_saida")
    private String min_saida;

    @Column(name="instituicao_id")
    private Integer instituicao_id;
    
    public Integer getId_planilha() {
        return id_planilha;
    }

    public void setId_planilha(Integer id_planilha) {
        this.id_planilha = id_planilha;
    }

    public String getData_dia() {
        return data_dia;
    }

    public void setData_dia(String data_dia) {
        this.data_dia = data_dia;
    }

    public String getData_mes() {
        return data_mes;
    }

    public void setData_mes(String data_mes) {
        this.data_mes = data_mes;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public Integer getBolsista() {
        return bolsista;
    }

    public void setBolsista(Integer bolsista) {
        this.bolsista = bolsista;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getComputador() {
        return computador;
    }

    public void setComputador(String computador) {
        this.computador = computador;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(String hora_saida) {
        this.hora_saida = hora_saida;
    }    

    public String getMin_entrada() {
        return min_entrada;
    }

    public void setMin_entrada(String min_entrada) {
        this.min_entrada = min_entrada;
    }

    public String getMin_saida() {
        return min_saida;
    }

    public void setMin_saida(String min_saida) {
        this.min_saida = min_saida;
    }

    public String getData_ano() {
        return data_ano;
    }

    public void setData_ano(String data_ano) {
        this.data_ano = data_ano;
    }

    public Integer getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(Integer instituicao_id) {
        this.instituicao_id = instituicao_id;
    }
}
