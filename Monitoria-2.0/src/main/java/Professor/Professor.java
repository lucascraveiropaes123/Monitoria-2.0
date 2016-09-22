package Professor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.professor")
public class Professor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_professor")
    private Integer id_professor;     
    
    @Column(name="primeiro_nome")
    private String primeiro_nome;
    
    @Column(name="nome_completo")
    private String nome_completo;
    
    @Column(name="materia")
    private String materia;
    
    @Column(name="login")
    private String login;
    
    @Column(name="senha")
    private String senha;

    public Integer getId_professor() {
        return id_professor;
    }

    public void setId_professor(Integer id_professor) {
        this.id_professor = id_professor;
    }

    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    public void setPrimeiro_nome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
