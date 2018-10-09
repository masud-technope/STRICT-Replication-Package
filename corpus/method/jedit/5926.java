private float convertFromMicrometers(float margin, int units) {
    return margin / Integer.valueOf(units).floatValue();
}