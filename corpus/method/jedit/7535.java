//}}}
//{{{ queueAWTRunner() method
public void queueAWTRunner(boolean wait) {
    if (wait)
        ThreadUtilities.runInDispatchThreadAndWait(new RunRequestsInAWTThread());
    else {
        synchronized (this) {
            if (awtQueue.isEmpty())
                return;
            if (!awtQueueStarted || awtRunnerQueued)
                return;
            awtRunnerQueued = true;
        }
        EventQueue.invokeLater(new RunRequestsInAWTThread());
    //			Log.log(Log.DEBUG,this,"AWT runner queued");
    }
}