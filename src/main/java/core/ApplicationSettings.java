package core;

import org.openqa.selenium.Dimension;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ApplicationSettings {

    public String webProtocol;
    public String targetHost;
    public String baseUrl;
    public String seleniumServer;
    public long timeToWait;
    public long timeToTimeout;
    public long timeToSleep;
    public String browserType;
    public static Dimension res1920x1080 = new Dimension(1920, 1080);
    //public static Dimension res1600x900 = new Dimension(1600, 900);

    public ApplicationSettings (){
        try {

            File propertiesFile = new File("src/main/resources/properties.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(propertiesFile);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("property");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    switch (element.getAttribute("name")) {
                        case "TargetHost" :
                            targetHost = element.getAttribute("value");
                            break;
                        case "Protocol" :
                            webProtocol = element.getAttribute("value");
                            break;
                        case "SeleniumServer" :
                            seleniumServer = element.getAttribute("value");
                            break;
                        case "TimetoWait" :
                            timeToWait = Long.parseLong(element.getAttribute("value"));
                            break;
                        case "TimeToTimeout" :
                            timeToTimeout = Long.parseLong(element.getAttribute("value"));
                            break;
                        case "TimeToSleep" :
                            timeToSleep = Long.parseLong(element.getAttribute("value"));
                            break;
                        case "Browser" :
                            browserType = element.getAttribute("value");
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        baseUrl = webProtocol + "://" + targetHost + "/";
        seleniumServer = "http://" + seleniumServer + ":5555/wd/hub";

        /*if (browserType.equals("ff")) {
            seleniumServer = "http://" + seleniumServer + ":4444/wd/hub";
        } else {
            seleniumServer = "http://" + seleniumServer + ":5555/wd/hub";
        }*/

    }
}