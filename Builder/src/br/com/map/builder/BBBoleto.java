package br.com.map.builder;

import br.com.map.iterfaces.IBoleto;
import java.text.SimpleDateFormat;
import java.util.Date;


class BBBoleto implements IBoleto {

    private String sacado;
    private String cedente;
    private double valor;
    private Date vencimento;
    private int nossoNumero;
    private String codigo;


    public BBBoleto(String sacado, String cedente, double valor, Date vencimento, int nossoNumero, String codigo) {
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Boleto BB");
        stringBuilder.append("\n");
        stringBuilder.append("Sacado :" + this.sacado);
        stringBuilder.append("\n");
        stringBuilder.append("Cedente :" + this.cedente);
        stringBuilder.append("\n");
        stringBuilder.append("Valor :" + this.valor);
        stringBuilder.append("\n");
        stringBuilder.append("Vencimento :" + this.sacado);
        stringBuilder.append("\n");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String format = simpleDateFormat.format(this.vencimento.getTime());
        stringBuilder.append("Vencimento :" + format);
        stringBuilder.append("\n");
        stringBuilder.append("Nosso Número :" + this.nossoNumero);
        stringBuilder.append("\n");
        stringBuilder.append("Código de barras :" + this.codigo);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

}
