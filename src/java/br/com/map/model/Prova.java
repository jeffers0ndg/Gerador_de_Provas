package br.com.map.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity

public class Prova implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    @ManyToMany
    private Collection<Materia> materias;
    @ManyToMany
    private Collection<Questao> questoes;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return titulo + "\n " + materias.toString() + "\n " + questoes.toString();
    }
    

}