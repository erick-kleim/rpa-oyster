package br.com.oystr.entity;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Set;

public class Machine {

	private String model;
	private String contractType;
	private String make;
	private String year;
	private String workedHours;
	private String city;
	private String price;
	private Set<String> pictures;
	private String url;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(String workedHours) {
		this.workedHours = workedHours;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Set<String> getPictures() {
		return pictures;
	}

	public void setPictures(Set<String> picture) {
		this.pictures = picture;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return MessageFormat.format("""
				
				model={0}
				contractType={1}
				make={2}
				year={3}
				workedHours={4}
				city={5}
				price={6}
				pictures={7}
				url={8}
				""",
				model, contractType, make, year,
				workedHours, city, price, picturesUrl(), url);
	}
	
	private String picturesUrl() {
		return pictures.stream().reduce((s1, s2) -> s1 + "\n" + s2).get();
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, contractType, make, model, pictures, price, url, workedHours, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machine other = (Machine) obj;
		return Objects.equals(city, other.city) && Objects.equals(contractType, other.contractType)
				&& Objects.equals(make, other.make) && Objects.equals(model, other.model)
				&& Objects.equals(pictures, other.pictures) && Objects.equals(price, other.price)
				&& Objects.equals(url, other.url) && Objects.equals(workedHours, other.workedHours)
				&& Objects.equals(year, other.year);
	}

	
}
