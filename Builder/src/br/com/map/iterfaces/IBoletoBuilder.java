package br.com.map.iterfaces;

import java.util.Date;

public interface IBoletoBuilder {
    public void buildSacado(String sacado);
    public void buildCedente(String cedente);
    public void buildValor(double valor);
    public void buildVencimento(Date vencimento);
    public void buildNossoNumero(int nossoNumero);
    public void buildCodigoDeBarras(String codigo);
    public IBoleto getBoleto();
}
