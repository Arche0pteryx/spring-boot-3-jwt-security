package com.alibou.security;

import org.json.JSONObject;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;


import static org.hibernate.type.SqlTypes.JSON;

@SpringBootApplication
public class CryptoComparePrice implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CryptoComparePrice.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        try {
            double ethPrice = getCryptoPrice1("ETHUSDT");
            System.out.println("Current ETH price: $" + ethPrice);
            System.out.println("ETH price on KuCoin: " + getCryptoPrice2("ETH-USDT"));
            double btcPrice = getCryptoPrice1("BTCUSDT");
            System.out.println("Current BTC price: $" + btcPrice);
            btcPrice = getCryptoPrice2("BTC-USDT");
            System.out.println("Current BTC price: $" + btcPrice);
            double solPrice = getCryptoPrice1("SOLUSDT");
            System.out.println("Current SOL price: $" + solPrice);
            solPrice = getCryptoPrice2("SOL-USDT");
            System.out.println("Current SOL price: $" + solPrice);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static double getCryptoPrice1( String pair) throws Exception {
        String url = "https://api.binance.com/api/v3/ticker/price?symbol="+pair;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject json = new JSONObject(response.toString());
        return json.getDouble("price");
    }
    public static double  getCryptoPrice2( String pair) throws Exception {
        URL obj = new URL("https://api.kucoin.com/api/v1/market/orderbook/level1?symbol="+pair);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject jsondata = new JSONObject(response.toString());
        JSONObject json = new JSONObject(jsondata.get("data").toString());
        return json.getDouble("price");
    }



}