package solution;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

public class CurrencyConverter {
	
	private ExchangeRateService exchangeRateService = new ExchangeRateServiceByAppspot();

	public void setExchangeRateService(ExchangeRateService exchangeRateService) {
		this.exchangeRateService = exchangeRateService;
	}

	public double convertAmount(double fromAmount, String fromCurrencyParameter,
			String toCurrencyParameter) {

		double toAmount = 0;

		try {
			ExchangeRate exchangeRate = exchangeRateService
					.getRate(fromCurrencyParameter, toCurrencyParameter);
			toAmount = fromAmount * exchangeRate.rate;
		} catch (JsonSyntaxException | IOException e) {
			// returning default toAmount;
		}
		return toAmount;
	}
}
