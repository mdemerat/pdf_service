package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("/pdf")
public class PDFResource {

    @Inject
    PDFGenerator pdfGenerator;

    @GET
    @Produces("application/pdf")
    public byte[] pdf() {
        return pdfGenerator.generate();
    }
}
