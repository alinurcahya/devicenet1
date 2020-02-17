package com.apps.net1.Util;

/**
 * Created by Dell_Cleva on 29/11/2018.
 */

public class Constant {

    public static String SSIDReq = "<?xml version=1.0 encoding=US-ASCII?> <RGW><param><method>call</method><session>000</session><obj_path>wireless</obj_path><obj_method>wifi_get_detail</obj_method></param></RGW>";
    public static String IMSIReq = "<?xml version=1.0 encoding=US-ASCII?> <RGW><param><method>call</method><session>000</session><obj_path>cm</obj_path><obj_method>get_link_context</obj_method></param></RGW>";
    public static String ICCIDReq = "<?xml version=1.0 encoding=US-ASCII?> <RGW><param><method>call</method><session>000</session><obj_path>cm</obj_path><obj_method>get_iccid</obj_method></param></RGW>";
    public static String HWMACReq = "<?xml version=1.0 encoding=US-ASCII?> <RGW><param><method>call</method><session>000</session><obj_path>version</obj_path><obj_method>get_version</obj_method></param></RGW>";
    public static String CONNECTSUMReq = "<?xml version=1.0 encoding=US-ASCII?> <RGW><param><method>call</method><session>000</session><obj_path>statistics</obj_path><obj_method>get_conn_clients_info</obj_method></param></RGW>";
    public static String IPLANReq = "<?xml version=1.0 encoding=US-ASCII?> <RGW><param><method>call</method><session>000</session><obj_path>router</obj_path><obj_method>router_get_lan_ip</obj_method></param></RGW>";

}
