package br.com.map.iterfaces;

import java.util.Date;

public interface IBoleto {
    public String getSacado();
    public String getCedente();
    public double getValor();
    public Date getVencimento();
    public int getNossoNumero();
    public String getCodigoDeBarras();
    public String toString();
}
