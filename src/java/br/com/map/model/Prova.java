package br.com.map.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prova implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private  Collection<Materia> materias;
    @OneToMany
    private  Collection<Questao> questoes;

    public Prova() {
        this.materias = new ArrayList<Materia>();
        this.questoes = new ArrayList<Questao>();
    }

    public Collection<Questao> getQuestoes() {
        return questoes;
    }

    public Collection<Materia> getMaterias() {
        return materias;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
