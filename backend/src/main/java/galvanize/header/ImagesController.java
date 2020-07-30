package galvanize.header;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/images")
@CrossOrigin
public class ImagesController {

    private final ImagesRepository repository;

    public ImagesController(ImagesRepository repository) {
        this.repository = repository;

    }

    @GetMapping("/{id}")
    public void getImageById(@PathVariable String id, HttpServletResponse response) throws IOException {
        ClassPathResource image = new ClassPathResource("Images/Picture" + id + ".png");
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(image.getInputStream(), response.getOutputStream());
    }

//    @GetMapping("/{flightid}")
//    public void getImageById(@PathVariable String flightid, HttpServletResponse response) throws IOException {
//        ClassPathResource image = new ClassPathResource("Images/Picture" + id + ".png");
//        response.setContentType(MediaType.IMAGE_PNG_VALUE);
//        StreamUtils.copy(image.getInputStream(), response.getOutputStream());
//    }


}