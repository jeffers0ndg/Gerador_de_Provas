package br.com.map.facade;

import br.com.map.dao.DAOProva;
import br.com.map.dao.DaoException;
import br.com.map.model.Prova;
import br.com.map.model.Questao;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GabaritoFacade {

    private Document document;
    private PdfWriter writer;
    private DAOProva daop;

    public GabaritoFacade() {
        document = new Document(PageSize.A4, 50, 50, 50, 50);
        daop = new DAOProva();
    }
    
   

    public void gerarGabarito(long idProva,OutputStream diretorio) {

        try {
            Prova p = daop.find(idProva);
            writer = PdfWriter.getInstance(document, diretorio);

            document.open();
            
            int cont = 1;
            
                
            document.add(new Paragraph("Prova: "+p.getTitulo()));
            for (Questao questoes : p.getQuestoes()) {
                document.add(new Paragraph(String.valueOf(cont)+") "+questoes.getResolucao()));
                cont ++;

            }

            PdfContentByte cb = writer.getDirectContent();

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
            document.close();
        } catch (DaoException ex) {
            Logger.getLogger(GabaritoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
