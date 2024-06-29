package com.dashboard.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.dao.CompanyRepository;
import com.dashboard.model.Company;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository cRepository;

    @Override
    public List<Company> getData() {
        return cRepository.findAll();
    }

    @Override
    public void saveFileV2() {
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/Data.csv"))) {
            String[] headers = reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                Company c = new Company();
                if (line.length > 0) c.setEnd_year(parseField(line[0]));
                if (line.length > 1) c.setCitylng(parseField(line[1]));
                if (line.length > 2) c.setCitylat(parseField(line[2]));
                if (line.length > 3) c.setIntensity(parseIntegerField(line[3]));
                if (line.length > 4) c.setSector(parseField(line[4]));
                if (line.length > 5) c.setTopic(parseField(line[5]));
                if (line.length > 6) c.setInsight(parseField(line[6]));
                if (line.length > 7) c.setSwot(parseField(line[7]));
                if (line.length > 8) c.setUrl(parseField(line[8]));
                if (line.length > 9) c.setRegion(parseField(line[9]));
                if (line.length > 10) c.setStart_year(parseField(line[10]));
                if (line.length > 11) c.setImpact(parseField(line[11]));
                if (line.length > 12) c.setAdded(parseField(line[12]));
                if (line.length > 13) c.setPublished(parseField(line[13]));
                if (line.length > 14) c.setCity(parseField(line[14]));
                if (line.length > 15) c.setCountry(parseField(line[15]));
                if (line.length > 16) c.setRelevance(parseIntegerField(line[16]));
                if (line.length > 17) c.setPestal(parseField(line[17]));
                if (line.length > 18) c.setSource(parseField(line[18]));
                if (line.length > 19) c.setTitle(parseField(line[19]));
                if (line.length > 20) c.setLikelihood(parseIntegerField(line[20]));

                cRepository.save(c);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println(e);
        }
    }

    private String parseField(String field) {
        if (field != null && field.startsWith("\"") && field.endsWith("\"")) {
            return field.substring(1, field.length() - 1);
        }
        return field;
    }

    private int parseIntegerField(String field) {
        if (field != null && !field.isEmpty()) {
            return Integer.parseInt(field);
        }
        return 0;
    }

    @Override
    public List<Object> getDataBy(String filterName, String filter) {
        if (filterName.equalsIgnoreCase("end_year")) {
            return cRepository.findDashboardDetailsByEndYear(filter);
        } else if (filterName.equalsIgnoreCase("topic")) {
            return cRepository.findDashboardDetailsByTopic(filter);
        } else if (filterName.equalsIgnoreCase("sector")) {
            return cRepository.findDashboardDetailsBySector(filter);
        } else if (filterName.equalsIgnoreCase("pestal")) {
            return cRepository.findDashboardDetailsByPestal(filter);
        } else if (filterName.equalsIgnoreCase("source")) {
            return cRepository.findDashboardDetailsBySource(filter);
        } else if (filterName.equalsIgnoreCase("swot")) {
            return cRepository.findDashboardDetailsBySwot(filter);
        } else if (filterName.equalsIgnoreCase("country")) {
            return cRepository.findDashboardDetailsByCountry(filter);
        } else if (filterName.equalsIgnoreCase("city")) {
            return cRepository.findDashboardDetailsByCity(filter);
        } else if (filterName.equalsIgnoreCase("all")) {
            return cRepository.findDashboardDetails();
        } else {
            return null;
        }
    }
}