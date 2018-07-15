# Btc_Rest_api  

Bitcoin Price API
If you are trying to do interesting things with bitcoin price data last X minutes, you shouldn't have to be concerned with the low-level details of how to obtain that data, or the particular JSON structures that it comes in. This module will provide a unified way of getting price data from various exchanges which have publicly available API's, as well as a unified representation of that data rather than exchange specific ones.


Dependencies
The only dependency is on the requests library. You can either do java 8 install requests or maven install 1.8 requirements.txt inside the directory.

Bitstamp, Bitfinex, OKCoin, Huobi, and Coinapult
All of these classes expose the interface below:

Coindesk
The Coindesk class offers a much richer price interface:

get_current_price(currency='USD')
get_past_price(minute)
get_current_price and get_past_price both return Decimal objects.

get_current_price takes in an optional parameter specifying the currency.

The dates for all functions must be in the form 'YYYY-MM-DD'.

get_historical_data_as_dict will return a dictionary of the following format:

{'2014-10-20': 400.00, '2014-10-21': 301.99}
Remember that these date/prices will not be in any given order.

get_historical_data_as_list will return a list of dictionaries, correctly sorted by date from start to end.

[
    {'date': 'YYYY-MM-DD', 'price': 300.00},
    {'date': 'YYYY-MM-DD', 'price': 301.00 }
]
