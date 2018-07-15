package com.btcjava.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btcjava.spring.bean.Bitcoin;
import com.btcjava.spring.service.BitcoinService;
import java.util.Date;


@RestController
@RequestMapping(value={"/btc"})
public class BitcoinController {

	@Autowired
	BitcoinService bitcoinService;
	

    @GetMapping(value = "/{minute}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bitcoin> getUserById(@PathVariable("minute") int minute) {
        System.out.println("Fetching Bitcoin with last minute " + minute);
        Bitcoin bitcoin = bitcoinService.findById(minute);
        if (bitcoin == null) {
            return new ResponseEntity<Bitcoin>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bitcoin>(bitcoin, HttpStatus.OK);
    }
 
}
