//}}}
//{{{ scrollLaterIfRequired() method
private void scrollLaterIfRequired() {
    if (tailIsOn)
        ThreadUtilities.runInDispatchThread(new Runnable() {

            @Override
            public void run() {
                scrollToTail();
            }
        });
}