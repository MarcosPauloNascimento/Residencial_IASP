/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencial.db.relatorios;

import java.sql.Connection;
import residencial.db.bancodehoras.dao.BancoDeHoras;
import residencial.db.conexao.Conexao;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JTable;
import residencial.db.util.Utilitarios;

public class RelHoraExtraMonitora {

    BancoDeHoras bh = new BancoDeHoras();

    public void imprime(String dir, boolean todas, String nomeRel, JTable tabela, int idMonitora) throws FileNotFoundException {
        List<String> lista = new ArrayList<>();
        if (todas) {
            lista = bh.listaIds();
        } else {
            bh.listarDadosPorMonitora(tabela, idMonitora);
        }

        Utilitarios util = new Utilitarios();
        Document gerarRelatorioPDF = new Document();
        try {
            com.itextpdf.text.Font negrito = FontFactory.getFont("Segoe UI", 16, Font.BOLD, BaseColor.BLACK);
            com.itextpdf.text.Font fontePadrao = FontFactory.getFont("Segoe UI", 12, BaseColor.BLACK);
            com.itextpdf.text.Font verde = FontFactory.getFont("Segoe UI", 12, BaseColor.BLUE);
            com.itextpdf.text.Font vermelho = FontFactory.getFont("Segoe UI", 12, BaseColor.RED);

            //cria uma instancia do documento e da o nome do pdf
            PdfWriter.getInstance(gerarRelatorioPDF, new FileOutputStream(dir+"\\" + nomeRel + ".pdf"));

            //abrir o documento
            gerarRelatorioPDF.open();

            //setar o tamnho da página
            gerarRelatorioPDF.setPageSize(PageSize.A4);

            //AQUI EU ADICIONO O LOGO DA IGREJA
            Image imagem = Image.getInstance("C:\\Users\\Marcos Paulo\\Documents\\NetBeansProjects\\Residencial_IASP\\src\\residencial\\db\\images\\unasp.png");
            //setar o tamanho da imagem
            imagem.scaleToFit(150, 100);
            imagem.setAlignment(1);
            gerarRelatorioPDF.add(imagem);
            //adicinando primeiro paragrafo
            Paragraph titulo = new Paragraph("Relatório Detalhado de Horas Extras", negrito);
            titulo.setAlignment(1);
            gerarRelatorioPDF.add(titulo);

            Paragraph emissao = new Paragraph("Data de Impressão: " + util.getDateTime(), fontePadrao);
            emissao.setAlignment(1);
            emissao.setPaddingTop(20);
            gerarRelatorioPDF.add(emissao);

            gerarRelatorioPDF.add(new Paragraph(" "));

            Phrase p1 = new Phrase("Data");
            Phrase p2 = new Phrase("Tipo");
            Phrase p3 = new Phrase("Hora de Entrada");
            Phrase p4 = new Phrase("Hora de Saída");
            Phrase p5 = new Phrase("Qtde Horas");
            Phrase p6 = new Phrase("Justificativa");

            p1.setFont(negrito);

            PdfPTable table = null;

            PdfPCell monitora, header1, header2, header3, header4, header5, header6, cell = null, cell1 = null;

            monitora = new PdfPCell();
            header1 = new PdfPCell(p1);
            header2 = new PdfPCell(p2);
            header3 = new PdfPCell(p3);
            header4 = new PdfPCell(p4);
            header5 = new PdfPCell(p5);
            header6 = new PdfPCell(p6);

            header1.setPadding(5.0f);
            header2.setPadding(5.0f);
            header3.setPadding(5.0f);
            header4.setPadding(5.0f);
            header5.setPadding(5.0f);
            header6.setPadding(5.0f);

            header1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header6.setBackgroundColor(BaseColor.LIGHT_GRAY);

            header1.setHorizontalAlignment(Element.ALIGN_CENTER);
            header2.setHorizontalAlignment(Element.ALIGN_CENTER);
            header3.setHorizontalAlignment(Element.ALIGN_CENTER);
            header4.setHorizontalAlignment(Element.ALIGN_CENTER);
            header5.setHorizontalAlignment(Element.ALIGN_CENTER);

            header1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header6.setVerticalAlignment(Element.ALIGN_MIDDLE);

            header6.setColspan(3);

            Phrase pDado = null;
            Paragraph msgTotal = null;
            String id = "";
            if (todas) {
                for (int k = 0; k < lista.size(); k++) {
                    bh.listarTodosDados(lista.get(k));
                    criaTabela(table, id, monitora, fontePadrao, 
                            header1, header2, header3, header4, header5, header6, 
                            pDado, cell, cell1, gerarRelatorioPDF, msgTotal, verde, vermelho);
                }
            } else {
                criaTabela(table, id, monitora, fontePadrao, 
                        header1, header2, header3, header4, header5, header6, 
                        pDado, cell, cell1, gerarRelatorioPDF, msgTotal, verde, vermelho);
            }

        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            gerarRelatorioPDF.close();
        }

    }

    private void criaTabela(PdfPTable table, String id, PdfPCell monitora, Font fontePadrao, PdfPCell header1,
            PdfPCell header2, PdfPCell header3, PdfPCell header4, PdfPCell header5, PdfPCell header6,
            Phrase pDado, PdfPCell cell, PdfPCell cell1, Document gerarRelatorioPDF,
            Paragraph msgTotal, Font verde, Font vermelho) {

        for (int i = 0; i < bh.bancoDeHoras.size(); i++) {
            table = new PdfPTable(8);
            table.setWidthPercentage(100.0f);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            String[] dados = bh.bancoDeHoras.get(i).split(";");

            if (!id.equals(dados[7])) {
                id = dados[7];

                monitora = new PdfPCell(new Paragraph("Monitora: " + dados[0], fontePadrao));
                monitora.setColspan(8);
                monitora.setBorder(0);
                monitora.setPadding(15.0f);
                monitora.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table.addCell(monitora);
                table.addCell(header1);
                table.addCell(header2);
                table.addCell(header3);
                table.addCell(header4);
                table.addCell(header5);
                table.addCell(header6);

            }

            for (int j = 0; j < dados.length; j++) {

                if (j < 5) {
                    pDado = new Phrase(dados[j + 1]);
                    cell = new PdfPCell(pDado);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);

                } else if (j == 5) {
                    Phrase justificativa = new Phrase(dados[j + 1]);
                    cell1 = new PdfPCell(justificativa);
                    cell1.setColspan(3);
                    cell1.setPadding(7.0f);
                    table.addCell(cell1);
                }

            }
            try {
                gerarRelatorioPDF.add(table);
            } catch (DocumentException ex) {
                Logger.getLogger(RelHoraExtraMonitora.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (bh.getStatus().equals("Crédito")) {
            msgTotal = new Paragraph("Status: " + bh.getStatus() + " - " + bh.getTotalHoras(), verde);
        } else {
            msgTotal = new Paragraph("Status: " + bh.getStatus() + " - " + bh.getTotalHoras(), vermelho);
        }
        msgTotal.setAlignment(2);
        try {
            gerarRelatorioPDF.add(msgTotal);
        } catch (DocumentException ex) {
            Logger.getLogger(RelHoraExtraMonitora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
