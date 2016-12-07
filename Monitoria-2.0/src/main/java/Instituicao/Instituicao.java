package Instituicao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.instituicao")
public class Instituicao implements Serializable {
  
    @Id
    @Column(name= "cnpj")
    private Integer cnpj;     
    
    @Column(name="nome")
    private String nome;

    @Column(name="num_cartao")
    private String num_cartao;
    
    @Column(name="email")
    private String email;
    
    @Column(name="senha")
    private String senha;

    @Column(name="instituicao_id")
    private Integer instituicao_id;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(Integer instituicao_id) {
        this.instituicao_id = instituicao_id;
    }
    
}
