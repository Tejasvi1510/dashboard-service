package com.dashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jdk.jfr.DataAmount;
import lombok.Data;

@Entity
@Data
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private int cid;

	@Column(name = "end_year")
	private String end_year;

	@Column(name = "citylng")
	private String citylng;

	@Column(name = "citylat")
	private String citylat;

	@Column(name = "intensity")
	private int intensity;

	@Column(name = "sector")
	private String sector;

	@Column(name = "topic")
	private String topic;

	@Column(name="insight",columnDefinition = "TEXT")
	private String insight;

	@Column(name = "swot")
	private String swot;

	@Column(name = "url")
	private String url;

	@Column(name = "region")
	private String region;

	@Column(name = "start_year")
	private String start_year;

	@Column(name = "impact")
	private String impact;

	@Column(name = "added")
	private String added;

	@Column(name = "published")
	private String published;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@Column(name = "relevance")
	private int relevance;

	@Column(name = "pestal")
	private String pestal;

	@Column(name = "source")
	private String source;

	@Column(name = "title",columnDefinition = "TEXT")
	private String title;

	@Column(name = "likelihood")
	private int likelihood;
}
