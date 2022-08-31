package org.acme;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.enterprise.context.ApplicationScoped;
import java.awt.*;
import java.io.ByteArrayOutputStream;

@ApplicationScoped
public class PDFGenerator {

    public static byte[] generate() {

        try {
            Document doc = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(doc, baos);
            //setting font family, color
            Font font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC, Color.RED);
            doc.open();
            Paragraph para = new Paragraph("Hello! This PDF is created using openPDF", font);
            doc.add(para);
            doc.close();
            writer.close();
            return baos.toByteArray();

        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
