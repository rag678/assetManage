package com.example.assetManage.repository;

import com.example.assetManage.entities.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Assets,Long> {
    Optional<Assets> findByName(String name);
}
