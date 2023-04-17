package ca.tetervak.flowerdata.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerDataRepository extends JpaRepository<Flower,String> {
}
