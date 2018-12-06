package br.com.map.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

public class Gabarito implements Serializable {
    private long id;
    private String[] respostas;
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
