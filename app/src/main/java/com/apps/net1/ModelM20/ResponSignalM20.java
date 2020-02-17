package com.apps.net1.ModelM20;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(strict = false)
public class ResponSignalM20 {

    @Element(name="antenna_value", required=false)
    String antennaValue;

    public String getAntennaValue() {return this.antennaValue;}
    public void setAntennaValue(String value) {this.antennaValue = value;}

}