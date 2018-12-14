package br.com.map.builder;

import br.com.map.iterfaces.IBoleto;
import br.com.map.iterfaces.IBoletoBuilder;
import java.util.Date;


public class CaixaBoletoBuilder implements IBoletoBuilder {

    private String sacado;
    private String cedente;
    private double valor;
    private Date vencimento;
    private int nossoNumero;
    private String codigo;
    
 

	public void buildSacado(String sacado) {
        this.sacado = sacado;
    }

    public void buildCedente(String cedente) {
        this.cedente = cedente;
    }

    public void buildValor(double valor) {
        this.valor = valor;
    }

    public void buildVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public void buildNossoNumero(int nossoNumero) {
        this.nossoNumero = nossoNumero;
    }
    
    public void buildCodigoDeBarras(String codigo) {
    	this.codigo = codigo;
	}

    public IBoleto getBoleto() {
        return new BBBoleto(sacado, cedente, valor, vencimento, nossoNumero,codigo);
    }

	
}
