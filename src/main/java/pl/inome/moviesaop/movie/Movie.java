package pl.inome.moviesaop.movie;

class Movie {

    private String title;
    private Integer productionYear;
    private String producer;

    public Movie() {
    }

    public Movie(String title, Integer productionYear, String producer) {
        this.title = title;
        this.productionYear = productionYear;
        this.producer = producer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", productionYear=" + productionYear +
                ", producer='" + producer + '\'' +
                '}';
    }
}
