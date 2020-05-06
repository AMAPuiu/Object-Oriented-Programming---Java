package Website;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static java.awt.Desktop.getDesktop;

abstract public class URLOpener {

    public void openURL(URL u) throws URISyntaxException, IOException {
        getDesktop().browse(u.toURI());
    }
    abstract public void print();
}
