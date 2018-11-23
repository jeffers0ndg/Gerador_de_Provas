package br.com.map.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Materia implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    public Materia(String nome) {
        this.nome = nome;
    }

    public Materia() {
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: "+id+" Nome: "+nome;
    }
    
    

    
}
