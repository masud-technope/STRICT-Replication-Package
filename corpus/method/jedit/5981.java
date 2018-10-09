public AttributeSet getAttributes() {
    AttributeSet as = new HashAttributeSet();
    as.add(new JobPriority(((Priority) priority.getSelectedItem()).getValue()));
    if (finishing.isEnabled()) {
        as.add((Finishings) finishing.getSelectedItem());
    }
    // print now
    Date holdUntil = new Date(0L);
    if (atButton.isSelected()) {
        // print later
        holdUntil = ((SpinnerDateModel) when.getModel()).getDate();
    } else if (holdButton.isSelected()) {
        // hold for a year, seems weird
        Calendar later = Calendar.getInstance();
        later.add(Calendar.YEAR, 1);
        holdUntil = later.getTime();
    }
    as.add(new JobHoldUntil(holdUntil));
    return as;
}