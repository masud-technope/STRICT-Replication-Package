void startClassMapping() {
    if (mappingFeedbackListener != null)
        mappingFeedbackListener.startClassMapping();
    else
        System.err.println("Start ClassPath Mapping");
}