/**
		If the claspath map is not initialized, do it now.
		If component maps are not do them as well...

		Random note:
		Should this be "insure" or "ensure".  I know I've seen "ensure" used
		in the JDK source.  Here's what Webster has to say:

			Main Entry:ensure Pronunciation:in-'shur
			Function:transitive verb Inflected
			Form(s):ensured; ensuring : to make sure,
			certain, or safe : GUARANTEE synonyms ENSURE,
			INSURE, ASSURE, SECURE mean to make a thing or
			person sure. ENSURE, INSURE, and ASSURE are
			interchangeable in many contexts where they
			indicate the making certain or inevitable of an
			outcome, but INSURE sometimes stresses the
			taking of necessary measures beforehand, and
			ASSURE distinctively implies the removal of
			doubt and suspense from a person's mind. SECURE
			implies action taken to guard against attack or
			loss.
	*/
public void insureInitialized() {
    insureInitialized(true);
}