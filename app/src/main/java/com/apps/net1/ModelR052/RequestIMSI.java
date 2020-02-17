package com.apps.net1.ModelR052;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by Dell_Cleva on 29/11/2018.
 */
//<RGW>
//<param>
//<method>call</method>
//<session>000</session>
//<obj_path>cm</obj_path>
//<obj_method>get_link_context</obj_method>
//</param>
//</RGW>
@Root(name = "RGW")
@NamespaceList
public class RequestIMSI {

    public RequestIMSI(){

    }

    @Element(name = "param")
    Param param;

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }
}

class Param{
    @Element(name = "method")
    String method;

    @Element(name = "session")
    String session;

    @Element(name = "obj_path")
    String obj_path;

    @Element(name = "obj_method")
    String obj_method;

    public Param(){

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getObj_path() {
        return obj_path;
    }

    public void setObj_path(String obj_path) {
        this.obj_path = obj_path;
    }

    public String getObj_method() {
        return obj_method;
    }

    public void setObj_method(String obj_method) {
        this.obj_method = obj_method;
    }
}