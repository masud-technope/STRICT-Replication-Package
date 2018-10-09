@Override
public void paint(Graphics panelGraphics) {
    if (panelGraphics != null && bufImage != null) {
        panelGraphics.drawImage(bufImage, 0, 0, w, h, this);
    }
}