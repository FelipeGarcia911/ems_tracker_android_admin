package co.original.codigo.ems_tracker_admin.helpers.socket_io;

import android.util.Log;

import java.net.URISyntaxException;

import co.original.codigo.ems_tracker_admin.helpers.Constants;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class SocketConnection {

    private Socket socket;

    private static class SingletonHolder {
        private static final SocketConnection INSTANCE = new SocketConnection();
    }

    public static SocketConnection getInstance() {
        return SocketConnection.SingletonHolder.INSTANCE;
    }

    public void initSocketConn() throws URISyntaxException {
        socket = IO.socket(Constants.URL_SOCKET_CONN);
        socket.connect();
        bindSocketEvents();
    }

    public boolean emitSocketMessage(String socketMethod, String data){
        if (isSocketConnected()) {
            socket.emit(socketMethod, data);
            return true;
        }else{
            return false;
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isSocketConnected() {
        return socket != null && socket.connected();
    }

    private void bindSocketEvents(){
        // CONNECT EVENTS
        //------------------------------------------------------------------------------------------
        socket.on(Socket.EVENT_CONNECTING, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket","EVENT_ERROR");
            }
        });
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket","EVENT_CONNECT");
            }
        });
        socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket","EVENT_CONNECT_ERROR");
            }
        });
        socket.on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket","EVENT_CONNECT_TIMEOUT");
            }
        });
        socket.on(Socket.EVENT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket","EVENT_ERROR");
            }
        });

        // RECONNECT EVENTS
        //------------------------------------------------------------------------------------------
        socket.on(Socket.EVENT_RECONNECT_ATTEMPT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket","EVENT_RECONNECT_ATTEMPT");
            }
        });
        socket.on(Socket.EVENT_RECONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket","EVENT_RECONNECT");
            }
        });
        socket.on(Socket.EVENT_RECONNECT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket","EVENT_RECONNECT_ERROR");
            }
        });
    }

}
