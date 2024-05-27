import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class ARController {

    @GetMapping("/model")
    public ResponseEntity<byte[]> getModel() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/n.glb");
        byte[] model = Files.readAllBytes(Path.of(resource.getURI()));
        return ResponseEntity.ok().header("Content-Type", "model/gltf-binary").body(model);
    }
}
