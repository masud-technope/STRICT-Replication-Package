private void map(String[] classes, Object source) {
    for (int i = 0; i < classes.length; i++) {
        //System.out.println( classes[i] +": "+ source );
        mapClass(classes[i], source);
    }
}