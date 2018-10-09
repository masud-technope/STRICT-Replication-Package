//{{{ doAWTRequest() method
/**
		 * Actually run the Runnable
		 * @param request the request to run
		 */
private void doAWTRequest(Runnable request) {
    try {
        request.run();
    } catch (Throwable t) {
        Log.log(Log.ERROR, this, "Exception " + "in AWT thread:");
        Log.log(Log.ERROR, this, t);
    }
//}}}
}