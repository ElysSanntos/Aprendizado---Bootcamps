public class PrevisaoDoTempo{
	public double getTemperatura() throws MuitoFrio {
		double temperatura = Math.random()*50.0;
		if(temperatura < 10.0) {
			throw new MuitoFrio("Que friaca..." + temperatura + "ºC");
		}
		return temperatura;
	}
}