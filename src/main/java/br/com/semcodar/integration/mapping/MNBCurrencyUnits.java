package br.com.semcodar.integration.mapping;

import javax.xml.bind.annotation.*;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "MNBCurrencyUnits")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MNBCurrencyUnits")
public class MNBCurrencyUnits {

    @XmlPath("Units/Unit")
    @XmlAnyElement(lax=true)
    private Object units;

    public Object getUnits() {
        return units;
    }

    public void setUnits(Object units) {
        this.units = units;
    }
}
