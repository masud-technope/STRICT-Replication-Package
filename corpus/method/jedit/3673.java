//}}}
//{{{ setRepeatCount() method
/**
	 * Sets the number of times the next action will be repeated.
	 * @param repeatCount The repeat count
	 */
public void setRepeatCount(int repeatCount) {
    int oldRepeatCount = this.repeatCount;
    this.repeatCount = repeatCount;
    if (oldRepeatCount != repeatCount)
        view.getStatus().setMessage(null);
}