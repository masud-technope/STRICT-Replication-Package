//}}}
//}}}
//{{{ Miscellaneous methods
//{{{ setWaitSocket() method
/**
	 * This socket is closed when the buffer is closed.
	 * @param waitSocket the socket
	 */
public void setWaitSocket(Socket waitSocket) {
    this.waitSocket = waitSocket;
}