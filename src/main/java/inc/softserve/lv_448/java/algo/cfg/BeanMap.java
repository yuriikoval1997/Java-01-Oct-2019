package inc.softserve.lv_448.java.algo.cfg;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement (name="beans")
@XmlAccessorType(XmlAccessType.FIELD)
class BeanMap {
     
    private Map<Integer, Bean> beanMap = new HashMap<>();
 
    Map<Integer, Bean> getBeanMap() {
        return beanMap;
    }
}