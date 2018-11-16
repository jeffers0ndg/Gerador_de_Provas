package br.com.map.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Questao implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Materia materia;
    private String enunciado;
    private String resolucao;
    private Integer dificuldade;
    private String altLetraA;
    private String altLetraB;
    private String altLetraC;
    private String altLetraD;
    private String altLetraE;

    public Questao() {
    }

    
    public Questao(Materia materia, String enunciado, String resolucao, Integer dificuldade, String altLetraA, String altLetraB, String altLetraC, String altLetraD, String altLetraE) {
        this.materia = materia;
        this.enunciado = enunciado;
        this.resolucao = resolucao;
        this.dificuldade = dificuldade;
        this.altLetraA = altLetraA;
        this.altLetraB = altLetraB;
        this.altLetraC = altLetraC;
        this.altLetraD = altLetraD;
        this.altLetraE = altLetraE;
    }

    
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    } 
    
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getAltLetraA() {
        return altLetraA;
    }

    public void setAltLetraA(String altLetraA) {
        this.altLetraA = altLetraA;
    }

    public String getAltLetraB() {
        return altLetraB;
    }

    public void setAltLetraB(String altLetraB) {
        this.altLetraB = altLetraB;
    }

    public String getAltLetraC() {
        return altLetraC;
    }

    public void setAltLetraC(String altLetraC) {
        this.altLetraC = altLetraC;
    }

    public String getAltLetraD() {
        return altLetraD;
    }

    public void setAltLetraD(String altLetraD) {
        this.altLetraD = altLetraD;
    }

    public String getAltLetraE() {
        return altLetraE;
    }

    public void setAltLetraE(String altLetraE) {
        this.altLetraE = altLetraE;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        System.out.println(materia+" " +enunciado +" "+ resolucao + "" + altLetraA);
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
