void classMapping(String msg) {
    if (mappingFeedbackListener != null) {
        mappingFeedbackListener.classMapping(msg);
    } else
        System.err.println("Mapping: " + msg);
}