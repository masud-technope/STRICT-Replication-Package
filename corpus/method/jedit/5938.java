private void rotateMargins(float topMargin, float leftMargin, float rightMargin, float bottomMargin, OrientationRequested orientationRequested) {
    if (OrientationRequested.REVERSE_PORTRAIT.equals(orientationRequested)) {
        float m = leftMargin;
        leftMargin = rightMargin;
        rightMargin = m;
        m = topMargin;
        topMargin = bottomMargin;
        bottomMargin = m;
    } else if (OrientationRequested.LANDSCAPE.equals(orientationRequested)) {
        float m = leftMargin;
        leftMargin = bottomMargin;
        bottomMargin = rightMargin;
        rightMargin = topMargin;
        topMargin = m;
    } else if (OrientationRequested.REVERSE_LANDSCAPE.equals(orientationRequested)) {
        float m = leftMargin;
        leftMargin = topMargin;
        topMargin = rightMargin;
        rightMargin = bottomMargin;
        bottomMargin = m;
    }
}