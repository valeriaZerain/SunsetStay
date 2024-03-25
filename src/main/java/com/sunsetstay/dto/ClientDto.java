package com.sunsetstay.dto;

import java.io.Serializable;

/** DTO for {@link com.sunsetstay.entities.Client} */
public class ClientDto implements Serializable {
  private final Integer id;
  private final Integer ci;
  private final String fullName;
  private final String email;

  public ClientDto(Integer id, Integer ci, String fullName, String email) {
    this.id = id;
    this.ci = ci;
    this.fullName = fullName;
    this.email = email;
  }

  public Integer getId() {
    return id;
  }

  public Integer getCi() {
    return ci;
  }

  public String getFullName() {
    return fullName;
  }

  public String getEmail() {
    return email;
  }
}
