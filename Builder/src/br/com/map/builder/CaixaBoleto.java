package br.com.map.builder;

import br.com.map.iterfaces.IBoleto;
import java.text.SimpleDateFormat;
import java.util.Date;


class CaixaBoleto implements IBoleto {

    private String sacado;
    private String cedente;
    private double valor;
    private Date vencimento;
    private int nossoNumero;
    private String codigo;


    public CaixaBoleto(String sacado, String cedente, double valor, Date vencimento, int nossoNumero, String codigo) {
		super();
		this.sacado = sacado;
		this.cedente = cedente;
		this.valor = valor;
		this.vencimento = vencimento;
		this.nossoNumero = nossoNumero;
		this.codigo = codigo;
	}

	public String getSacado() {
        return sacado;
    }

    public String getCedente() {
        return cedente;
    }

    public double getValor() {
        return valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public int getNossoNumero() {
        return nossoNumero;
    }
    
    public String getCodigoDeBarras() {
		return codigo;
	}


}
