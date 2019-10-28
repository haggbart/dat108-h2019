package inclass;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

public class CurrencyConverter {
	
	private ExchangeRateService ers = new ExchangeRateServiceAppspot();
	
	void setExchangeRateService(ExchangeRateService ers) {
		this.ers = ers;
	}

	public double convertAmount(double fromAmount, String fromCurrencyParameter, String toCurrencyParameter) {
		
		double toAmount = 0;
		
		ExchangeRate exchangeRate;
		try {
			exchangeRate = ers.getRate(fromCurrencyParameter, toCurrencyParameter);
			toAmount = fromAmount * exchangeRate.rate;
		} catch (JsonSyntaxException | IOException e) {
			// returning default toAmount;
		}
		return toAmount;
	}
}
