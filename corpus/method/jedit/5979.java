// returns INCH or MM depending on Locale
// note that while Canada is mostly metric, Canadian paper sizes
// are essentially US ANSI sizes rounded to the nearest 5 mm
private int getUnits() {
    String country = Locale.getDefault().getCountry();
    //String country = "Latvia";    // for testing metric
    if ("".equals(country) || Locale.US.getCountry().equals(country) || Locale.CANADA.getCountry().equals(country)) {
        return MediaPrintableArea.INCH;
    }
    return MediaPrintableArea.MM;
}