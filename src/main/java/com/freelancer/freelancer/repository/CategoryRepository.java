package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
