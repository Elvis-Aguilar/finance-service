package com.eatsleep.finance.exportPdf.infrastructure.outputadapter.pdfGeneror;

import org.springframework.stereotype.Service;

import lombok.Generated;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfGenerator {

    @Generated
    public byte[] generatePdfFromHtmlString(String html) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);

            return outputStream.toByteArray();
        }
    }
}
