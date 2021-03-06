package moj.tvz.hr.listatopolovec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LowBatteryReceiver extends BroadcastReceiver {

    private boolean status = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Low battery please lower the brightness" ,Toast.LENGTH_LONG).show();
        status = true;
    }

    public boolean isStatus() {
        return status;
    }
}
