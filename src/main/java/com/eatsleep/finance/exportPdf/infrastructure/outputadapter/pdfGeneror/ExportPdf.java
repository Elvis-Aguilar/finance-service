package com.eatsleep.finance.exportPdf.infrastructure.outputadapter.pdfGeneror;

import com.eatsleep.finance.common.infrastructure.exceptions.ExternalServiceException;
import com.eatsleep.finance.exportPdf.infrastructure.outputadapter.thymeleaf.Thymeleaf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.Generated;
import org.springframework.core.io.ByteArrayResource;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExportPdf {

    private final Thymeleaf thymeleaf;
    private final PdfGenerator pdfGenerator;

    @Generated
    public ByteArrayResource downloadPdf(String templateName, Map<String, Object> templateVariables){
        String billHtml = thymeleaf.renderTemplate(templateName, templateVariables);
        try {
            byte[] pdfBytes = pdfGenerator.generatePdfFromHtmlString(billHtml);
            return new ByteArrayResource(pdfBytes);
        } catch (IOException e) {
            throw new ExternalServiceException("No se pudeo generar el pdf");
        }
    }

    @Generated
    public byte[]  generatePdf(String templateName, Map<String, Object> templateVariables){
        String billHtml = thymeleaf.renderTemplate(templateName, templateVariables);
        try {
            byte[] pdfBytes = pdfGenerator.generatePdfFromHtmlString(billHtml);

            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
            return resource.getByteArray();
        }catch (Exception e){
            return null;
        }
    }

    /**
     * return ResponseEntity.ok()
     *                     .contentType(MediaType.APPLICATION_PDF)
     *                     .contentLength(resource.contentLength())
     *                     .header(HttpHeaders.CONTENT_DISPOSITION,
     *                             ContentDisposition.attachment()
     *                                     .filename("pdf-test.pdf")
     *                                     .build()
     *                                     .toString())
     *                     .body(resource);
     */
}
