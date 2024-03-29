package com.greenfox.avushugsformybugs.dtos;

public class ProductSlimDTO {
  private Long id;
  private String name;
  private int price;
  private int duration;
  private String type;

  public ProductSlimDTO() {
  }

  public ProductSlimDTO(Long id, String name, int price, int duration, String type) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.duration = duration;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
