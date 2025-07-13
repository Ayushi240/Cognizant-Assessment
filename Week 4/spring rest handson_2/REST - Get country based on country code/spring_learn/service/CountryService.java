package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.model.CountryList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/country.xml");

            JAXBContext context = JAXBContext.newInstance(CountryList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CountryList countryList = (CountryList) unmarshaller.unmarshal(is);
            List<Country> countries = countryList.getCountries();

            return countries.stream()
                    .filter(c -> c.getCode().equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Country not found for code: " + code));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load countries", e);
        }
    }
}
