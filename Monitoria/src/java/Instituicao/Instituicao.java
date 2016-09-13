package Instituicao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sistemamonitoria.instituicao")
public class Instituicao implements Serializable {
       
    @Id
    @Column(name="pk_instituicao")
    private String pk_instituicao;
    
    @Column(name="nome")
    private String nome;

    @Column(name= "cnpj")
    private Integer cnpj;
    
    @Column(name="num_cartao")
    private String num_cartao;
    
    @Column(name="login")
    private String login;
    
    @Column(name="senha")
    private String senha;

    public String getPk_instituicao() {
        return pk_instituicao;
    }

    public void setPk_instituicao(String pk_instituicao) {
        this.pk_instituicao = pk_instituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
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
