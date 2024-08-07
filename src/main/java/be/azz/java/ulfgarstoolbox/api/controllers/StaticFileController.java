package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.IRuleBookService;
import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(Constants.API_URL + "/file")
@RequiredArgsConstructor
public class StaticFileController {

    private final IRuleBookService ruleBookService;

    @GetMapping("/cover/{id:\\d+}")
    public ResponseEntity<FileSystemResource> getBookCover(@PathVariable Long id) {
        String fileName = ruleBookService.getRuleBookById(id).coverImage();
        return getStaticFile(fileName);
    }

    @GetMapping("/content/{id:\\d+}")
    public ResponseEntity<FileSystemResource> getFileContent(@PathVariable Long id) {
        String fileName = ruleBookService.getRuleBookById(id).link();
        return getStaticFile(fileName);
    }

    @GetMapping("/images/{fileName}")
    public ResponseEntity<FileSystemResource> getImage(@PathVariable String fileName) {
        return getStaticFile("images/" + fileName);
    }

    private ResponseEntity<FileSystemResource> getStaticFile(String fileName) {
        Path publicDirectory = Paths.get(".").toAbsolutePath();
        try {
            Path path = Paths.get(publicDirectory.toString(), fileName);
            FileSystemResource resource = new FileSystemResource(path);

            if (resource.exists()) {
                HttpHeaders headers = new HttpHeaders();
                MediaType mediaType = getMediaTypeForFileName(fileName);
                headers.setContentType(mediaType);

                // Pour les PDF, on ajoute l'en-tête Content-Disposition
                if (mediaType.equals(MediaType.APPLICATION_PDF)) {
                    headers.setContentDisposition(ContentDisposition.builder("inline").filename(fileName).build());
                }

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    private MediaType getMediaTypeForFileName(String fileName) {
        if (fileName.toLowerCase().endsWith(".pdf")) {
            return MediaType.APPLICATION_PDF;
        } else if (fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else {
            // Par défaut, on renvoie un type OCTET_STREAM
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

}
