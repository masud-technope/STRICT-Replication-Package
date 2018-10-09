//}}}
//{{{ turnOnElasticTabstops() method
/**
	 * Turn ON elastic tab stops.
	 */
public void turnOnElasticTabstops() {
    if (buffer.isLoading())
        return;
    buffer.indentUsingElasticTabstops();
    buffer.elasticTabstopsOn = true;
}