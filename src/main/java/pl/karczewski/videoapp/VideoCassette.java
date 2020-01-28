package pl.karczewski.videoapp;   //KLASA PRZECHOWYWUJĄCA KASETY WIDEO

import java.time.LocalDate;

public class VideoCassette {

    private Long id;

    private String title;

    private LocalDate productionYear;                                   //JAVA 8 DATE INFORMATION INSIDE

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }
}
