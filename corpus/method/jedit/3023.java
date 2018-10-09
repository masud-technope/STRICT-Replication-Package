//}}}
//{{{ run() method
public void run() {
    for (; ; ) {
        if (abort)
            return;
        Socket client = null;
        try {
            client = socket.accept();
            // Stop script kiddies from opening the edit
            // server port and just leaving it open, as a
            // DoS
            client.setSoTimeout(1000);
            Log.log(Log.MESSAGE, this, client + ": connected");
            DataInputStream in = new DataInputStream(client.getInputStream());
            if (!handleClient(client, in))
                abort = true;
        } catch (Exception e) {
            if (!abort)
                Log.log(Log.ERROR, this, e);
            abort = true;
        }
    }
}