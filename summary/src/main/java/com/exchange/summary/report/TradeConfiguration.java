package com.exchange.summary.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exchange.summary.report.model.ClientSummary;
import com.exchange.summary.report.model.TradeImpl;
import com.exchange.summary.report.parser.FileReadParser;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

@Configuration
public class TradeConfiguration<T> {
	private final Logger logger = LoggerFactory.getLogger(TradeConfiguration.class);

	@Autowired
	FileReadParser<T> fileParser;

	@Value("${output.filename}")
	String outputFileName;

	@Value("${output.fileheader}")
	String outputFileHeader;

	Map<String, String> clientSummary;

	@Bean
	@Profile("singapore")
	public Map<String, String> managerSingapore() {

		List<TradeImpl> trades = fileParser.parseFile(TradeImpl.class);
		trades.stream().forEach((trade) -> {
			logger.debug(trade.toString());
		});

		List<ClientSummary> clientDetails = getClientSpecificDetails(trades);
		clientDetails.stream().forEach((client) -> {
			logger.debug(client.toString());
		});

		clientSummary = getClientSummary(clientDetails);
		clientSummary.forEach((k, v) -> logger.debug(k + "," + v));

		return clientSummary;
	}

	List<ClientSummary> getClientSpecificDetails(List<TradeImpl> trade) {

		return trade.stream()
				.map(p -> new ClientSummary(p.getClientType(), p.getClientNumber(), p.getAccountNumber(),
						p.getSubAccountNumber(), p.getExchangeCode(), p.getProductGroupCode(), p.getSymbol(),
						p.getExpirationDate(), p.getQuantityLong() - p.getQuantityShort()))
				.collect(Collectors.toList());
	}

	Map<String, String> getClientSummary(List<ClientSummary> clientDetails) {
		return clientDetails.stream().collect(Collectors.groupingBy(
				p -> p.getClientType() + '-' + p.getClientNumber() + '-' + p.getAccountNumber() + '-'
						+ p.getSubAccountNumber() + ',' + p.getExchangeCode() + '-' + p.getProductGroupCode() + '-'
						+ p.getSymbol() + '-' + p.getFormattedDate(p.getExpirationDate()),
				Collectors.collectingAndThen(Collectors.summarizingDouble(ClientSummary::getTotalTransactionAmount),
						amount -> String.format("%7.2f", amount.getSum()))));
	}

	@Bean
	@Profile("hongkong")
	public Map<String, String> managerHongkong() {

		List<ClientSummary> clientDetails = fileParser.parseFile(TradeImpl.class).stream()
				.map(p -> new ClientSummary(p.getClientType(), p.getClientNumber(), p.getAccountNumber(),
						p.getSubAccountNumber(), p.getExchangeCode(), p.getProductGroupCode(), p.getSymbol(),
						p.getExpirationDate(), p.getQuantityLong() + p.getQuantityShort()))
				.collect(Collectors.toList());

		clientSummary = clientDetails.stream().collect(Collectors.groupingBy(
				p -> p.getClientType() + '-' + p.getClientNumber() + '-' + p.getAccountNumber() + '-'
						+ p.getSubAccountNumber() + ',' + p.getExchangeCode() + '-' + p.getProductGroupCode() + '-'
						+ p.getSymbol() + '-' + p.getFormattedDate(p.getExpirationDate()),
				Collectors.collectingAndThen(Collectors.summarizingDouble(ClientSummary::getTotalTransactionAmount),
						amount -> String.format("%7.2f", amount.getSum()))));

		return clientSummary;
	}

	@Bean
	public boolean managerWrite() {
		BufferedWriter csvResult = null;
		logger.info("Output file name "+outputFileName);
		
		try {
			csvResult = new BufferedWriter(new FileWriter(outputFileName));
		} catch (IOException e) {
			logger.error("File not found");
			e.printStackTrace();
		}

		CsvWriterSettings settings = new CsvWriterSettings();
		settings.setHeaderWritingEnabled(true);

		CsvWriter writer = new CsvWriter(csvResult, settings);

		writer.writeHeaders(outputFileHeader.split(","));

		clientSummary.forEach((k, v) -> writer.writeRow(k + "," + v));
		writer.close();

		logger.info("Run Finished");
		return true;
	}
}