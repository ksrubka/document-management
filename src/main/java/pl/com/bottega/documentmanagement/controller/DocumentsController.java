package pl.com.bottega.documentmanagement.controller;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.documentmanagement.api.DocumentFlowProcess;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;

/**
 * Created by maciuch on 03.07.16.
 */
@RestController
@RequestMapping("/documents")
public class DocumentsController {

    private DocumentFlowProcess documentFlowProcess;

    public DocumentsController(DocumentFlowProcess documentFlowProcess) {
        this.documentFlowProcess = documentFlowProcess;
    }

    @PutMapping
    public DocumentNumber create(@RequestBody DocumentRequest documentRequest) {
        return documentFlowProcess.create(documentRequest.getTitle(), documentRequest.getContent());
    }

    @PostMapping("/{documentNumber}")
<<<<<<< HEAD
    public void update(@PathVariable String documentNumber, @RequestBody DocumentRequest documentRequest) {
        documentFlowProcess.change(new DocumentNumber(documentNumber), documentRequest.getTitle(), documentRequest.getContent());
    }

=======
    public String update(@PathVariable String documentNumber, @RequestBody DocumentRequest documentRequest) {
        documentFlowProcess.change(new DocumentNumber(documentNumber), documentRequest.getTitle(), documentRequest.getContent());
        return "{'success': true}";
    }
>>>>>>> origin/master
}
