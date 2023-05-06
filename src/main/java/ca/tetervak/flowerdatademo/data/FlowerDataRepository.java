package ca.tetervak.flowerdatademo.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerDataRepository extends JpaRepository<Flower,String> {
}
