package inc.softserve.lv_448.java.algo.cfg;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement (name="beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanMap {
     
    private Map<Integer, Bean> beanMap = new HashMap<Integer, Bean>();
 
    public Map<Integer, Bean> getBeanMap() {
        return beanMap;
    }
 
    public void setBeanMap(Map<Integer, Bean> beanMap) {
        this.beanMap = beanMap;
    }
}