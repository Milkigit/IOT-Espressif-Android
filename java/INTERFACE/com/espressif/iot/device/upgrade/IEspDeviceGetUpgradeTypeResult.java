package com.espressif.iot.device.upgrade;

import com.espressif.iot.type.upgrade.EspUpgradeDeviceTypeResult;

public interface IEspDeviceGetUpgradeTypeResult extends IEspDeviceUpgrade
{
    final boolean IS_USED_BY_DEVELOPER = true;
    /**
     * get the device's @see EspUpgradeDeviceTypeResult by its romVersion and latestRomVersion
     * @param romVersion current rom version
     * @param latestRomVersion the latest rom version
     * @return @see EspUpgradeDeviceTypeResult
     */
    EspUpgradeDeviceTypeResult getDeviceUpgradeTypeResult(String romVersion,String latestRomVersion);
}
