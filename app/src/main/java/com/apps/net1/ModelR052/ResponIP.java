package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 30/11/2018.
 */

@Root(strict = false)
public class ResponIP {
    @Element
    Router router;

    @Override
    public String toString() {
        return "ResponIP{" +
                "router=" + router +
                '}';
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }
}


