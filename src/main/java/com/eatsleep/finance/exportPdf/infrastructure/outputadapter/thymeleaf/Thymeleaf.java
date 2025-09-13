package com.eatsleep.finance.exportPdf.infrastructure.outputadapter.thymeleaf;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Thymeleaf {

    private final SpringTemplateEngine templateEngine;

    public String renderTemplate(String template, Map<String, Object> variables) {
        Context context = new Context();
        context.setVariables(variables);

        return templateEngine.process(template, context);
    }
}
