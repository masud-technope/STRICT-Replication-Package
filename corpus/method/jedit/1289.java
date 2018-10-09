void endClassMapping() {
    if (mappingFeedbackListener != null)
        mappingFeedbackListener.endClassMapping();
    else
        System.err.println("End ClassPath Mapping");
}