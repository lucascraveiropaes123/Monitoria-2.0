package Disciplina;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.disciplina")
public class Disciplina implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "key_disciplina")
    private Integer key_disciplina;     
    
    @Column(name="nome")
    private String nome;

    @Column(name="instituicao_id")
    private Integer instituicao_id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getKey_disciplina() {
        return key_disciplina;
    }

    public void setKey_disciplina(Integer key_disciplina) {
        this.key_disciplina = key_disciplina;
    }

    public Integer getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(Integer instituicao_id) {
        this.instituicao_id = instituicao_id;
    }

    
}
