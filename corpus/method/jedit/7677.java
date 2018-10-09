void fireTextChanged() {
    TextEvent te = new TextEvent(this, TextEvent.TEXT_VALUE_CHANGED);
    for (TextListener listener : listeners) listener.textValueChanged(te);
}