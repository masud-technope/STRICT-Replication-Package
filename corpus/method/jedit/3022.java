//}}}
//{{{ stopServer() method
void stopServer() {
    abort = true;
    try {
        socket.close();
    } catch (IOException io) {
    }
    new File(portFile).delete();
}