package cs489.miu.edu.hotel_reservation_service.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageConfig {
    @Value("${file.separator}")
    private String fileSeparator;

    @Value("${user.dir}")
    private String userDir;

    @Value("${image.path}")
    private String imageUploadPath;

    public String getAbsoluteImageUploadPath() {
        return userDir + fileSeparator + imageUploadPath;
    }
}
