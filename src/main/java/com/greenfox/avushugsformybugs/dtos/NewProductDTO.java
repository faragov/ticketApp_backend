package com.greenfox.avushugsformybugs.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class NewProductDTO {

  @NotEmpty(message = "Name can not be empty")
  private String name;

  @NotNull(message = "Price has to be between 100 and 50000")
  @Min(100)
  @Max(50000)
  private Integer price;

  @NotNull(message = "Duration has to be between 1 and 730")
  @Min(1)
  @Max(730)
  private Integer duration;

  @NotEmpty(message = "Description can not be empty")
  private String description;

  @NotEmpty(message = "Type can not be empty")
  private String type;

  public NewProductDTO(String name, Integer price, Integer duration, String description, String type) {
    this.name = name;
    this.price = price;
    this.duration = duration;
    this.description = description;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public Integer getPrice() {
    return price;
  }

  public Integer getDuration() {
    return duration;
  }

  public String getDescription() {
    return description;
  }

  public String getType() {
    return type;
  }
}
