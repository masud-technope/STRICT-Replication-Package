/**
	 * Handles a message sent on the EditBus.
	 */
// next version: remove this
public void handleMessage(EBMessage message) {
    EditBus.removeFromBus(this);
    if (seenWarning)
        return;
    seenWarning = true;
    Log.log(Log.WARNING, this, getClassName() + " should extend" + " EditPlugin not EBPlugin since it has an empty" + " handleMessage()");
}