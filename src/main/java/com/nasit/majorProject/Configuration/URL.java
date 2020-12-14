package com.nasit.majorProject.Configuration;

import java.util.HashMap;
import java.util.Map;

public class URL {
    private static final String getSession = "https://mdm.sahajbamba.me/getSession";
    private static final String getCPI = "https://mdm.sahajbamba.me/getcpi";
    private static final String getCourse = "https://mdm.sahajbamba.me/getcourse";
    private static final String getPersonalInfo = "http://localhost:8000/api/v1/getData";

    public static final HashMap<Integer, String> requestMap = (HashMap<Integer, String>) Map.ofEntries(
            Map.entry(1,getSession),
            Map.entry(2,getCPI),
            Map.entry(3,getCourse),
            Map.entry(4,getPersonalInfo)
    );
}
