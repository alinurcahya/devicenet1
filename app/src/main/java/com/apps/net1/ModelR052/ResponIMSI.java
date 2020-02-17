package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 29/11/2018.
 */

@Root(strict = false)
public class ResponIMSI {

    @Element(name = "celluar_basic_info")
    CellularInfo cellularInfo;

    public ResponIMSI() {
    }

    public CellularInfo getCellularInfo() {
        return cellularInfo;
    }

    public void setCellularInfo(CellularInfo cellularInfo) {
        this.cellularInfo = cellularInfo;
    }

    @Override
    public String toString() {
        return "ResponIMSI{" +
                "cellularInfo=" + cellularInfo +
                '}';
    }
}


