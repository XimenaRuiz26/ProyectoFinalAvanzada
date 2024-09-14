package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.servicios.interfaces.ImagenesServicio;
import org.springframework.stereotype.Service;

@Service
public class ImagenesServicioImpl implements ImagenesServicio {

    private final Cloudinary cloudinary;
    public ImagenesServicioImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dk0vyi7yi");
        config.put("api_key", "444834788181461");
        config.put("api_secret", "bMFA0ikjKLLkZAc-M5OqbLdOcd4");
        cloudinary = new Cloudinary(config);
    }
    @Override
    public Map subiImagen(MultipartFile imagen) throws Exception {
        File file = convertir(imagen);
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "UniLocal"));
    }

    @Override
    public Map eliminarImagen(String idImagen) throws Exception {
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }
    private File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}
