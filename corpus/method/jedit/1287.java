void errorWhileMapping(String s) {
    if (mappingFeedbackListener != null)
        mappingFeedbackListener.errorWhileMapping(s);
    else
        System.err.println(s);
}