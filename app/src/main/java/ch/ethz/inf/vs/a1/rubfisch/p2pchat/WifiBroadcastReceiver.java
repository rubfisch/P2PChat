package ch.ethz.inf.vs.a1.rubfisch.p2pchat;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.PeerListListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by G on 26.11.2017.
 */

public class WifiBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager mManager;
    private Channel mChannel;
    private Activity mActivity;
    PeerListListener myPeerListListener;
    //private List peers = new ArrayList();

    public WifiBroadcastReceiver(WifiP2pManager manager, Channel channel,
                                       Activity activity) {
        super();
        this.mManager = manager;
        this.mChannel = channel;
        this.mActivity = activity;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                // Wifi P2P is enabled
            } else {
                // Wi-Fi P2P is not enabled
            }
            // Check to see if Wi-Fi is enabled and notify appropriate activity
        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            // Call WifiP2pManager.requestPeers() to get a list of current peers
            // request available peers from the wifi p2p manager. This is an
            // asynchronous call and the calling activity is notified with a
            // callback on PeerListListener.onPeersAvailable()
            if (mManager != null) {
                mManager.requestPeers(mChannel, myPeerListListener);
            }
        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            // Respond to new connection or disconnections

        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
        }
    }

/*    @Override
    public void onPeersAvailable(WifiP2pDeviceList peerList) {
        List<WifiP2pDevice> devices = (new ArrayList<>());
        devices.addAll(peerList.getDeviceList());

        //do something with the device list
    } */

   /* private PeerListListener peerListListener = new PeerListListener() {
        @Override
        public void onPeersAvailable(WifiP2pDeviceList peerList) {

            // Out with the old, in with the new.
            peers.clear();
            peers.addAll(peerList.getDeviceList());

            // If an AdapterView is backed by this data, notify it
            // of the change.  For instance, if you have a ListView of available
            // peers, trigger an update.
            //((WiFiPeerListAdapter) getListAdapter()).notifyDataSetChanged();
            if (peers.size() == 0) {
                //no devices found
                return;
            }
        }
    };



    @Override
    public void connect() {
        // Picking the first device found on the network.
        WifiP2pDevice device = peers.get(0);

        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = WpsInfo.PBC;

        mManager.connect(mChannel, config, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                // WiFiDirectBroadcastReceiver will notify us. Ignore for now.
            }

            @Override
            public void onFailure(int reason) {
                Toast.makeText(BroadcastReceiverActivity.this, "Connect failed. Retry.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    } */
}
/* Change device name
Method m = manager.getClass().getMethod("setDeviceName", new Class[]     {channel.getClass(), String.class,
                    WifiP2pManager.ActionListener.class});
        m.invoke(manager, channel, newDeviceName, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
            }
            @Override
            public void onFailure(int reason) {
            }
    });
 */