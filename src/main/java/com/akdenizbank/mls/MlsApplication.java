package com.akdenizbank.mls;

import com.akdenizbank.mls.card.BankCard;
import com.akdenizbank.mls.card.service.BankCardService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlsApplication.class, args);

	}
}
