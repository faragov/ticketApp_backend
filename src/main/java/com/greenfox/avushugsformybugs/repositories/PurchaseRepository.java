package com.greenfox.avushugsformybugs.repositories;

import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

  Set<Purchase> findPurchaseByUserIdAndStatus(Long userId, PurchaseStatus status);

}
