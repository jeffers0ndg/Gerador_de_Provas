package br.com.map.main;

import br.com.map.iterfaces.IBoleto;
import br.com.map.iterfaces.IBoletoBuilder;
import java.util.Date;

public class GeradorDeBoleto {

    private IBoletoBuilder boletoBuilder;

    public GeradorDeBoleto(IBoletoBuilder boletoBuilder) {
        this.boletoBuilder = boletoBuilder;
    }

    public IBoleto geraBoleto(String codigo,String sacado, String cedente, double valor, Date vencimento) {
        this.boletoBuilder.buildCodigoDeBarras(codigo);
    	this.boletoBuilder.buildSacado(sacado);
        this.boletoBuilder.buildCedente(cedente);
        this.boletoBuilder.buildValor(valor);
        this.boletoBuilder.buildVencimento(vencimento);
        new GeradorDePdf(codigo, sacado, cedente, valor, vencimento);
        return this.boletoBuilder.getBoleto();
        
    }
}
