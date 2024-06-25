package br.com.gobarber.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
@SequenceGenerator(name="seq_user", allocationSize = 1, initialValue = 1)
public class User implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
  private Long id;
  private String name;
  private String thumbnail;
  private String email;
  private String password;
  private Instant createdAt;
  private Instant updatedAt;
  
  @PrePersist
  public void prePersist(){
    this.createdAt = Instant.now();
  }

  @PreUpdate
  public void preUpdate(){
    this.updatedAt = Instant.now();
  }
}
