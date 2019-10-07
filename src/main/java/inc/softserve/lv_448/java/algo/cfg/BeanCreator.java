package inc.softserve.lv_448.java.algo.cfg;

import inc.softserve.lv_448.java.algo.starter.Startable;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.Map;

public class BeanCreator {

    private Map<Integer, Startable> container = new HashMap<>();

    public void initBeans() throws JAXBException {
        BeanUnmarshal.unMarshalingExample().getBeanMap().forEach((k, v) -> {
            try {
                container.put(k, (Startable) Class.forName(v.getFullyQualifiedName().trim()).newInstance());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Map<Integer, Startable> getContainer() {
        return container;
    }
}
