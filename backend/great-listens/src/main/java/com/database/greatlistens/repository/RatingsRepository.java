package com.database.greatlistens.repository;

import com.database.greatlistens.model.Ratings;
import com.database.greatlistens.CompositeIds.RatingsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, RatingsId> {
}
