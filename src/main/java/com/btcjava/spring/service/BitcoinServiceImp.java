package com.btcjava.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.btcjava.spring.bean.Bitcoin;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class BitcoinServiceImp implements BitcoinService {

	private static List<Bitcoin> bitcoins;

        @Override
        public List<Bitcoin> getBitcoin() {
		// TODO Auto-generated method stub
		return bitcoins;
	}

        @Override
	public Bitcoin findById(int id) {
		// TODO Auto-generated method stub
//              int timeStamp = (int) (new Date().getTime()/1000);
//              System.out.println("Current Timestamp : " + timeStamp);
//              int BtcTimeStamp = timeStamp -(id*60);
//              System.out.println("BtcTimeStamp : "+BtcTimeStamp);
//		for (Bitcoin bitcoin : bitcoins) {
//			if (bitcoin.getId() == BtcTimeStamp) {
//				return bitcoin;
//			}
//		}
                try {
                    Date date = new Date();
                   String NowDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
                   LocalDate StartDateTime = LocalDate.now().minusDays(id/60);
                   String StartDate= new SimpleDateFormat("yyyy-MM-dd").format(StartDateTime);
                   HttpResponse<String> BitcoinResponse = Unirest.get("https://api.coindesk.com/v1/bpi/historical/close.json?start="+StartDate+"&end="+NowDate).asString();
                   Bitcoin btc = new Bitcoin(id, BitcoinResponse.getBody());
                   return btc;
                }catch(UnirestException e){
                  return null;
                }
            
         }

        @Override
	public void createBitcoin(Bitcoin bitcoin) {
		// TODO Auto-generated method stub
		bitcoins.add(bitcoin);
	}

}
