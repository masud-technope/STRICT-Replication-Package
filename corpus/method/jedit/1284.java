/**
	*/
public static void addMappingFeedback(MappingFeedback mf) {
    if (mappingFeedbackListener != null)
        throw new RuntimeException("Unimplemented: already a listener");
    mappingFeedbackListener = mf;
}