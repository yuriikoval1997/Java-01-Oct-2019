package inc.softserve.lv_448.java.algo.cfg;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

class BeanUnmarshal {

    static BeanMap unMarshalingExample() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BeanMap.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (BeanMap) jaxbUnmarshaller.unmarshal(new File("src/main/resources/beans448.xml"));
    }
}
