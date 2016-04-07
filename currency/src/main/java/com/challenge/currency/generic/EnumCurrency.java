package com.challenge.currency.generic;

public enum EnumCurrency {
	
	idEUR ("EUR"){
		@Override
		public String currency() {
			return "EUR";
		}

		@Override
		public String description() {
			return "Euro";
		}
	},
	idUSD ("USD"){
		@Override
		public String currency() {
			return "USD";
		}

		@Override
		public String description() {
			return "United States Dollar";
		}
	},
	idGBP ("GBP"){
		@Override
		public String currency() {
			return "GBP";
		}

		@Override
		public String description() {
			return "British Pound Sterling";
		}
	},
	idNZD ("NZD"){
		@Override
		public String currency() {
			return "NZD";
		}

		@Override
		public String description() {
			return "New Zealand Dollar";
		}
	},
	idAUD ("AUD"){
		@Override
		public String currency() {
			return "AUD";
		}

		@Override
		public String description() {
			return "Australian Dollar";
		}
	},
	idJPY ("JPY"){
		@Override
		public String currency() {
			return "JPY";
		}

		@Override
		public String description() {
			return "Japanese Yen";
		}
	},
	idHUF ("HUF"){
		@Override
		public String currency() {
			return "HUF";
		}

		@Override
		public String description() {
			return "Hungarian Forint";
		}
	};
	
	private String value;
	
	public abstract String currency();
	
	protected abstract String description();
	
	public String getDescription(){
		return this.description();
	}
	
	private EnumCurrency(String key){
		this.value = key;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
