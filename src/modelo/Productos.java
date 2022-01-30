package modelo;

public class Productos {

	private String title, release_year, rental_duration, rating;
	
	

	public Productos() {
	
		title="";
		release_year="";
		rental_duration="";
		rating="";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public String getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(String rental_duration) {
		this.rental_duration = rental_duration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
