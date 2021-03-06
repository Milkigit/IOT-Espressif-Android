package com.espressif.iot.action.user;

import com.espressif.iot.action.IEspActionInternet;
import com.espressif.iot.action.IEspActionUser;
import com.espressif.iot.type.user.EspLoginResult;

public interface IEspActionUserLoginInternet extends IEspActionUser, IEspActionInternet
{
    /**
     * login by Internet
     * 
     * @param userEmail user's email
     * @param userPassword user's password
     * @param isPwdSaved whether the password will be saved
     * @param isAutoLogin whether it is auto login
     * @return @see EspLoginResult
     */
    EspLoginResult doActionUserLoginInternet(String userEmail, String userPassword, boolean isPwdSaved,
        boolean isAutoLogin);
}
