package br.com.map.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.scene.shape.Line;

public class GeradorDePdf2 {
	private Document document;
	private  PdfWriter writer;
	private String codigo;
	private String sacado;
	private String cedente;
	private double valor;
	private Date vencimento;
	
	
	
	public GeradorDePdf2(String codigo, String sacado, String cedente, double valor,
			Date vencimento) {
		document = new Document(PageSize.A4, 50, 50, 50, 50);
		this.codigo = codigo;
		this.sacado = sacado;
		this.cedente = cedente;
		this.valor = valor;
		this.vencimento = vencimento;
		gerar();
	}



	public void gerar(){
				 
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(cedente+".pdf"));
			
			document.open();
			
			document.add(new Paragraph("Boleto Bancario:".concat("           ").concat(codigo)));
			document.add(new Paragraph("Cedente:".concat("    ").concat(cedente)));
			document.add(new Paragraph("Sacado:".concat("     ").concat(sacado)));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			
			document.close();
			
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
			document.close();
		}
		 
		 
	}

}
