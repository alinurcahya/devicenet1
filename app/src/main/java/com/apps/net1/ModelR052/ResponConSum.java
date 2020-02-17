package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Dell_Cleva on 30/11/2018.
 */

@Root(strict = false)
public class ResponConSum {

    @ElementList
    public List<ClientInfo> clients_info;

    @Override
    public String toString() {
        return "ResponConSum{" +
                "clients_info=" + clients_info +
                '}';
    }

    public List<ClientInfo> getClientInfos() {
        return clients_info;
    }

    public void setClientInfos(List<ClientInfo> clientInfos) {
        this.clients_info = clientInfos;
    }

    public int getSum() {
        return clients_info.size();
    }

}


