package br.com.map.main;

import br.com.map.builder.BBBoletoBuilder;
import br.com.map.iterfaces.IBoletoBuilder;
import br.com.map.iterfaces.IBoleto;

import java.io.FileNotFoundException;
import java.util.Date;

import com.itextpdf.text.DocumentException;

public class Main {

    public static void main(String[] args) {
    	
//        IBoletoBuilder bb = new BBBoletoBuilder();
//        IBoletoBuilder bra = new BBBoletoBuilder();
//        IBoletoBuilder caixa = new BBBoletoBuilder();
//        
//        GeradorDeBoleto gbb = new GeradorDeBoleto(bb);
//        IBoleto boletobb = gbb.geraBoleto("1234567890987","Jefferson", "Brando do Brasil", 100, new Date(118, 11, 22));
//        
//        GeradorDeBoleto gbbra = new GeradorDeBoleto(bra);
//        IBoleto boletobra = gbbra.geraBoleto("9098123874567","Jadson", "Bradesco", 1000, new Date(118, 12, 19));
//        
//        GeradorDeBoleto gbcaixa = new GeradorDeBoleto(bra);
//        IBoleto boletocaixa = gbcaixa.geraBoleto("9098123874567","Jackson", "CAIXA", 1000, new Date(119, 1, 2));
//        
    	GeradorDePdf2 pdf2 = new GeradorDePdf2("novo", "novo", "novo", 100, new Date(119,1,2));
		
        
    }

}