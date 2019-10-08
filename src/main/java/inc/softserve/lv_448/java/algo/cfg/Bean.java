package inc.softserve.lv_448.java.algo.cfg;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "bean")
@XmlAccessorType(XmlAccessType.FIELD)
class Bean {
    private String fullyQualifiedName;
}