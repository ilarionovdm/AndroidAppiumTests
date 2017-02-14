package VKsrc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by Lion on 30.01.2017.
 */
@XmlRootElement(name = "VKConfig")
public class VKConfig {

    static{
        try {
            File file = new File(VKConfig.class.getResource("/VKSettings.xml").toURI());
            JAXBContext context = JAXBContext.newInstance(VKConfig.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            instance = (VKConfig) unmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            throw new RuntimeException("Не удалось загрузить XML конфиг");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static VKConfig instance;

    public static VKConfig getInstance() {
        return instance;
    }

    @XmlElement(name = "login", required = true)
    private String login;

    @XmlElement(name = "password", required = true)
    private String password;

    @XmlElement(name = "songName", required = false)
    private String songName;

    public String getLogin() {
        return getInstance().login;
    }

    public String getPassword() {
        return getInstance().password;
    }

    public String getSongName() {
        return getInstance().songName;
    }
}
