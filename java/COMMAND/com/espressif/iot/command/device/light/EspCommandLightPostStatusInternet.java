package com.espressif.iot.command.device.light;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.espressif.iot.base.api.EspBaseApiUtil;
import com.espressif.iot.type.device.status.IEspStatusLight;
import com.espressif.iot.type.net.HeaderPair;
import com.espressif.iot.util.RouterUtil;

public class EspCommandLightPostStatusInternet implements IEspCommandLightPostStatusInternet
{
    private final static Logger log = Logger.getLogger(EspCommandLightPostStatusInternet.class);
    
    private boolean postCurrentLightStatus(String deviceKey, IEspStatusLight statusLight, String router)
    {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectX = new JSONObject();
        String headerKey = Authorization;
        String headerValue = Token + " " + deviceKey;
        
        JSONObject result = null;
        try
        {
            jsonObjectX.put(X, statusLight.getFreq());
            jsonObjectX.put(Y, statusLight.getRed());
            jsonObjectX.put(Z, statusLight.getGreen());
            jsonObjectX.put(K, statusLight.getBlue());
            jsonObjectX.put(L, 50);
            jsonObject.put(Datapoint, jsonObjectX);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            return false;
        }
        HeaderPair header = new HeaderPair(headerKey, headerValue);
        String url = URL;
        if (router != null)
        {
            url += "&router=" + RouterUtil.getBroadcastRouter(router);
        }
        
        result = EspBaseApiUtil.Post(url, jsonObject, header);
        if (result == null)
        {
            return false;
        }
        
        // try {
        int status = -1;
        try
        {
            if (result != null)
            {
                status = Integer.parseInt(result.getString(Status));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        if (status == HttpStatus.SC_OK)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public boolean doCommandLightPostStatusInternet(String deviceKey, IEspStatusLight statusLight)
    {
        return doCommandLightPostStatusInternet(deviceKey, statusLight, null);
    }

    @Override
    public boolean doCommandLightPostStatusInternet(String deviceKey, IEspStatusLight statusLight, String router)
    {
        boolean result = postCurrentLightStatus(deviceKey, statusLight, router);
        log.debug(Thread.currentThread().toString() + "##doCommandLightPostStatusInternet(deviceKey=[" + deviceKey
            + "],statusLight=[" + statusLight + "]): " + result);
        return result;
    }
    
}
